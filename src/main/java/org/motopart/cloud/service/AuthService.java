package org.motopart.cloud.service;

import org.motopart.cloud.dto.request.*;
import org.motopart.cloud.entity.AppRegistration;
import org.motopart.cloud.entity.OtpEntity;
import org.motopart.cloud.entity.UserEntity;
import org.motopart.cloud.repository.AppRegistrationRepository;
import org.motopart.cloud.repository.OtpRepository;
import org.motopart.cloud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.UUID;

@Service
public class AuthService {

    private final AppRegistrationRepository appRepo;
    private final UserRepository userRepo;
    private final OtpRepository otpRepo;
    private final SecureRandom random = new SecureRandom();

    public AuthService(AppRegistrationRepository appRepo, UserRepository userRepo, OtpRepository otpRepo) {
        this.appRepo = appRepo;
        this.userRepo = userRepo;
        this.otpRepo = otpRepo;
    }

    public String registerApp(AppRegRequest r) {
        AppRegistration a = new AppRegistration();
        a.setDeviceId(r.deviceId);
        a.setOsInfo(r.osInfo);
        a.setModelInfo(r.modelInfo);
        a.setClientVersion(r.clientVersion);
        a.setDeviceToken(r.deviceToken);
        return String.valueOf(appRepo.save(a).getId());
    }

    public UserEntity signUp(SignUpRequest r) {
        UserEntity u = userRepo.findByMobileAndAppId(r.userPhone, r.appId).orElseGet(UserEntity::new);
        u.setUsername(r.userName);
        u.setEmail(r.userEmail);
        u.setMobile(r.userPhone);
        u.setType(r.type);
        u.setAppId(r.appId);
        u.setLocationId(r.locationId);
        u.setLocation(r.locationName);
        u.setDoc1(r.doc1);
        u.setDoc2(r.doc2);
        u.setProfileUrl(r.profileUrl);
        u.setStatus("1");
        u.setToken(newToken());
        u.setLastUpdated(Instant.now());
        return userRepo.save(u);
    }

    /** Generates and stores an OTP. In production wire this to an SMS provider. */
    public String generateOtp(OtpRequest r) {
        String code = String.format("%04d", random.nextInt(10000));
        OtpEntity o = new OtpEntity();
        o.setUserPhone(r.userPhone);
        o.setAppId(r.appId);
        o.setOtpCode(code);
        otpRepo.save(o);
        // Returning the code keeps local testing simple; remove before production.
        return "OTP generated: " + code;
    }

    public UserEntity login(LoginRequest r) {
        OtpEntity otp = otpRepo
                .findTopByUserPhoneAndAppIdOrderByCreatedAtDesc(r.userPhone, r.appId)
                .orElse(null);
        boolean ok = otp != null && otp.getOtpCode() != null && otp.getOtpCode().equals(r.otp);
        if (!ok) {
            return null;
        }
        UserEntity u = userRepo.findByMobileAndAppId(r.userPhone, r.appId)
                .or(() -> userRepo.findByMobile(r.userPhone))
                .orElse(null);
        if (u != null) {
            u.setToken(newToken());
            u.setLastUpdated(Instant.now());
            userRepo.save(u);
        }
        return u;
    }

    private String newToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
