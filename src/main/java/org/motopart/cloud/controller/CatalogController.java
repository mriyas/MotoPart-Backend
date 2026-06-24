package org.motopart.cloud.controller;

import org.motopart.cloud.common.ApiBaseResponse;
import org.motopart.cloud.dto.request.*;
import org.motopart.cloud.dto.response.*;
import org.motopart.cloud.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    private final CatalogService catalog;

    public CatalogController(CatalogService catalog) {
        this.catalog = catalog;
    }

    // 6. Types
    @GetMapping("/type")
    public ApiBaseResponse<List<VehicleTypeData>> types() {
        return ApiBaseResponse.success(catalog.getTypes().stream().map(VehicleTypeData::from).toList());
    }

    // 7. Years (GET)
    @GetMapping("/year")
    public ApiBaseResponse<List<YearData>> years() {
        return ApiBaseResponse.success(catalog.getYears().stream().map(YearData::from).toList());
    }

    // 8. Create year (admin)
    @PostMapping("/year")
    public ApiBaseResponse<String> createYear(@RequestBody YearRequest req) {
        catalog.createYear(req);
        return ApiBaseResponse.success("Success");
    }

    // 9. Makers (GET)
    @GetMapping("/makers")
    public ApiBaseResponse<List<MakerData>> makers() {
        return ApiBaseResponse.success(catalog.getMakers().stream().map(MakerData::from).toList());
    }

    // 10. Create maker(s) (admin) - single or array
    @PostMapping("/makers")
    public ApiBaseResponse<String> createMakers(@RequestBody List<MakerRequest> req) {
        catalog.createMakers(req);
        return ApiBaseResponse.success("Success");
    }

    // 11. Models (GET)
    @GetMapping("/model")
    public ApiBaseResponse<List<ModelData>> models(
            @RequestParam(value = "makersId", required = false) String makersId,
            @RequestParam(value = "appId", required = false) String appId,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "count", defaultValue = "25") int count) {
        return ApiBaseResponse.success(
                catalog.getModels(makersId, start, count).stream().map(ModelData::from).toList());
    }

    // 12. Create model(s) (admin)
    @PostMapping("/model")
    public ApiBaseResponse<String> createModels(@RequestBody List<ModelRequest> req) {
        catalog.createModels(req);
        return ApiBaseResponse.success("Success");
    }

    // 13. Parts (GET)
    @GetMapping("/parts")
    public ApiBaseResponse<List<PartData>> parts(
            @RequestParam(value = "makersId", required = false) String makersId,
            @RequestParam(value = "modelId", required = false) String modelId,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "count", defaultValue = "25") int count) {
        return ApiBaseResponse.success(
                catalog.getParts(makersId, modelId, year, start, count).stream().map(PartData::from).toList());
    }

    // 14. Create part(s) (admin)
    @PostMapping("/parts")
    public ApiBaseResponse<String> createParts(@RequestBody List<PartRequest> req) {
        catalog.createParts(req);
        return ApiBaseResponse.success("Success");
    }

    // 15. SubParts (GET)
    @GetMapping("/subpart")
    public ApiBaseResponse<List<SubPartData>> subParts(
            @RequestParam(value = "makersId", required = false) String makersId,
            @RequestParam(value = "modelId", required = false) String modelId,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "partId", required = false) String partId,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "count", defaultValue = "25") int count) {
        return ApiBaseResponse.success(
                catalog.getSubParts(makersId, modelId, year, partId, start, count)
                        .stream().map(SubPartData::from).toList());
    }

    // 16. Create subpart(s) (admin)
    @PostMapping("/subpart")
    public ApiBaseResponse<String> createSubParts(@RequestBody List<SubPartRequest> req) {
        catalog.createSubParts(req);
        return ApiBaseResponse.success("Success");
    }

    // 17. Models (GET)
    @GetMapping("/series")
    public ApiBaseResponse<List<ModelData>> series(
            @RequestParam(value = "makersId", required = false) String makersId,
            @RequestParam(value = "appId", required = false) String appId,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "count", defaultValue = "25") int count) {
        return ApiBaseResponse.success(
                catalog.getModels(makersId, start, count).stream().map(ModelData::from).toList());
    }

    // 18. Create series(s) (admin)
    @PostMapping("/series")
    public ApiBaseResponse<String> createSeries(@RequestBody List<ModelRequest> req) {
        catalog.createSeries(req);
        return ApiBaseResponse.success("Success");
    }
}
