package org.motopart.cloud.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.motopart.cloud.common.ApiBaseResponse;
import org.springframework.web.bind.annotation.*;

/**
 * 25. Clear data (admin). The original ClearData payload isn't defined in the cloud
 * layer, so this accepts an open JsonNode. Wire up the actual clearing logic once the
 * payload shape is confirmed.
 */
@RestController
public class ClearDataController {

    @PutMapping("/cleardata/{id}")
    public ApiBaseResponse<String> clearData(@PathVariable("id") String id,
                                              @RequestBody(required = false) JsonNode body) {
        // TODO: implement actual clearing once ClearData fields are confirmed.
        return ApiBaseResponse.success("Data cleared");
    }
}
