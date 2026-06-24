package org.motopart.cloud.controller;

import org.motopart.cloud.common.ApiBaseResponse;
import org.motopart.cloud.dto.request.*;
import org.motopart.cloud.dto.response.*;
import org.motopart.cloud.entity.Location;
import org.motopart.cloud.entity.UserEntity;
import org.motopart.cloud.service.AuthService;
import org.motopart.cloud.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

    private final AuthService authService;
    private final CatalogService catalogService;

    public AuthController(AuthService authService, CatalogService catalogService) {
        this.authService = authService;
        this.catalogService = catalogService;
    }

    // 1. App registration
    @PostMapping("/application")
    public ApiBaseResponse<AppRegData> register(@RequestBody AppRegRequest req) {
        return ApiBaseResponse.success(new AppRegData(authService.registerApp(req)));
    }

    // 2. Locations (GET /user)
    @GetMapping("/user")
    public ApiBaseResponse<List<LocationData>> locations() {
        List<LocationData> data = catalogService.getLocations().stream()
                .map(LocationData::from).toList();
        return ApiBaseResponse.success(data);
    }

    // 3. Signup (POST /user)
    @PostMapping("/user")
    public ApiBaseResponse<SignUpData> signup(@RequestBody SignUpRequest req) {
        UserEntity u = authService.signUp(req);
        return ApiBaseResponse.success(SignUpData.from(u));
    }

    // 4. OTP
    @PostMapping("/otp")
    public ApiBaseResponse<String> otp(@RequestBody OtpRequest req) {
        return ApiBaseResponse.success(authService.generateOtp(req));
    }

    // 5. Login
    @PostMapping("/login")
    public ApiBaseResponse<LoginData> login(@RequestBody LoginRequest req) {
        UserEntity u = authService.login(req);
        if (u == null) return ApiBaseResponse.error("Invalid OTP or user not found");
        return ApiBaseResponse.success(LoginData.from(u));
    }
}
