package org.motopart.cloud.service;

import org.motopart.cloud.dto.request.CustomAdRequest;
import org.motopart.cloud.entity.CustomAd;
import org.motopart.cloud.entity.Suggestion;
import org.motopart.cloud.entity.UserEntity;
import org.motopart.cloud.repository.CustomAdRepository;
import org.motopart.cloud.repository.SuggestionRepository;
import org.motopart.cloud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscService {

    private final CustomAdRepository adRepo;
    private final SuggestionRepository suggestionRepo;
    private final UserRepository userRepo;

    public MiscService(CustomAdRepository adRepo, SuggestionRepository suggestionRepo,
                       UserRepository userRepo) {
        this.adRepo = adRepo;
        this.suggestionRepo = suggestionRepo;
        this.userRepo = userRepo;
    }

    public List<CustomAd> getAds() { return adRepo.findAll(); }

    public void createAd(CustomAdRequest r) {
        CustomAd a = new CustomAd();
        a.setAdurl(r.adurl);
        a.setStatus(r.status);
        a.setOuturl(r.outurl);
        adRepo.save(a);
    }

    public List<Suggestion> getSuggestions(String term) {
        // simple: return all; could filter by term containing
        return suggestionRepo.findAll();
    }

    public List<UserEntity> getAllUsers() { return userRepo.findAll(); }
}
