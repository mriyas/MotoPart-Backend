package org.motopart.cloud.controller;

import org.motopart.cloud.common.ApiBaseResponse;
import org.motopart.cloud.dto.request.PostControlRequest;
import org.motopart.cloud.dto.request.PostRequest;
import org.motopart.cloud.dto.response.PostCreationData;
import org.motopart.cloud.dto.response.PostItemData;
import org.motopart.cloud.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 17. Get posts (filtered)
    @GetMapping("/post")
    public ApiBaseResponse<List<PostItemData>> getPosts(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "makerId", required = false) String makerId,
            @RequestParam(value = "modelId", required = false) String modelId,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "partId", required = false) String partId,
            @RequestParam(value = "subpartId", required = false) String subpartId,
            @RequestParam(value = "itemCondition", required = false) String itemCondition,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "userid", required = false) Integer userid,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "count", defaultValue = "200") int count) {

        List<PostItemData> data = postService.getPosts(
                type, makerId, modelId, year, partId, subpartId, itemCondition, location, userid, start, count)
                .stream().map(PostItemData::from).toList();
        return ApiBaseResponse.success(data);
    }

    // 18. Create posts (array, header auth: appid/token/userId)
    @PostMapping("/post")
    public ApiBaseResponse<PostCreationData> createPosts(
            @RequestBody List<PostRequest> req,
            @RequestHeader(value = "userId", required = false) String userId) {
        String id = postService.createPosts(req, userId);
        return ApiBaseResponse.success(new PostCreationData(id));
    }

    // 19. Search
    @GetMapping("/search")
    public ApiBaseResponse<List<PostItemData>> search(@RequestParam("search") String search) {
        List<PostItemData> data = postService.search(search, 200)
                .stream().map(PostItemData::from).toList();
        return ApiBaseResponse.success(data);
    }

    // 24. Admin post control (enable/disable) - array
    @PostMapping("/adminpost")
    public ApiBaseResponse<String> adminPost(@RequestBody List<PostControlRequest> req) {
        for (PostControlRequest r : req) {
            postService.setPostStatus(r.postid, r.status);
        }
        return ApiBaseResponse.success("Success");
    }
}
