package org.motopart.cloud.controller;

import org.motopart.cloud.common.ApiBaseResponse;
import org.motopart.cloud.dto.request.CustomAdRequest;
import org.motopart.cloud.dto.response.AdData;
import org.motopart.cloud.dto.response.SuggestionData;
import org.motopart.cloud.dto.response.UserData;
import org.motopart.cloud.service.MiscService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiscController {

    private final MiscService misc;

    public MiscController(MiscService misc) {
        this.misc = misc;
    }

    // 20. Suggestions
    @GetMapping("/suggession")
    public ApiBaseResponse<List<SuggestionData>> suggestions(
            @RequestParam("suggession") String suggession) {
        return ApiBaseResponse.success(
                misc.getSuggestions(suggession).stream().map(SuggestionData::from).toList());
    }

    // 21. Custom ads (GET)
    @GetMapping("/customad")
    public ApiBaseResponse<List<AdData>> ads(
            @RequestParam(value = "type", required = false) String type) {
        return ApiBaseResponse.success(misc.getAds().stream().map(AdData::from).toList());
    }

    // 22. Create custom ad (admin)
    @PostMapping("/customad")
    public ApiBaseResponse<String> createAd(@RequestBody CustomAdRequest req) {
        misc.createAd(req);
        return ApiBaseResponse.success("Success");
    }

    // 23. All users data (GET /upload)
    @GetMapping("/upload")
    public ApiBaseResponse<List<UserData>> users() {
        return ApiBaseResponse.success(misc.getAllUsers().stream().map(UserData::from).toList());
    }
}
