package org.motopart.cloud.service;

import org.motopart.cloud.dto.request.*;
import org.motopart.cloud.entity.*;
import org.motopart.cloud.repository.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final VehicleTypeRepository typeRepo;
    private final YearRepository yearRepo;
    private final MakerRepository makerRepo;
    private final ModelRepository modelRepo;
    private final PartRepository partRepo;
    private final SubPartRepository subPartRepo;
    private final LocationRepository locationRepo;

    public CatalogService(VehicleTypeRepository typeRepo, YearRepository yearRepo,
                          MakerRepository makerRepo, ModelRepository modelRepo,
                          PartRepository partRepo, SubPartRepository subPartRepo,
                          LocationRepository locationRepo) {
        this.typeRepo = typeRepo;
        this.yearRepo = yearRepo;
        this.makerRepo = makerRepo;
        this.modelRepo = modelRepo;
        this.partRepo = partRepo;
        this.subPartRepo = subPartRepo;
        this.locationRepo = locationRepo;
    }

    // ---- reads ----
    public List<VehicleType> getTypes() { return typeRepo.findAll(); }
    public List<YearEntity> getYears() { return yearRepo.findAll(); }
    public List<Maker> getMakers() { return makerRepo.findAll(); }
    public List<Location> getLocations() { return locationRepo.findAll(); }

    public List<ModelEntity> getModels(String makerId, int start, int count) {
        Pageable page = PageRequest.of(start / Math.max(count, 1), Math.max(count, 1));
        if (makerId != null && !makerId.isEmpty()) {
            return modelRepo.findByMakerId(makerId, page);
        }
        return modelRepo.findAll(page).getContent();
    }

    public List<Part> getParts(String makerId, String modelId, String year, int start, int count) {
        Pageable page = PageRequest.of(start / Math.max(count, 1), Math.max(count, 1));
        return partRepo.findByMakerIdAndModelIdAndYear(makerId, modelId, year, page);
    }

    public List<SubPart> getSubParts(String makerId, String modelId, String year, String partId, int start, int count) {
        Pageable page = PageRequest.of(start / Math.max(count, 1), Math.max(count, 1));
        return subPartRepo.findByMakerIdAndModelIdAndYearAndPartId(makerId, modelId, year, partId, page);
    }

    // ---- admin writes ----
    public void createYear(YearRequest r) {
        YearEntity y = new YearEntity();
        y.setYear(r.year);
        y.setType(r.type);
        yearRepo.save(y);
    }

    public void createMakers(List<MakerRequest> list) {
        for (MakerRequest r : list) {
            Maker m = new Maker();
            m.setMakerNameArabic(r.makersnameArabic);
            m.setMakerName(r.makersname);
            m.setMakerImageUrl(r.url);
            m.setType(r.type);
            makerRepo.save(m);
        }
    }

    public void createModels(List<ModelRequest> list) {
        for (ModelRequest r : list) {
            ModelEntity m = new ModelEntity();
            m.setModelName(r.modelname);
            m.setModelNameArabic(r.modelnameArabic);
            m.setModelImageUrl(r.url);
            m.setMakerId(r.makerid);
            m.setType(r.type);
            m.setYear(r.year);
            modelRepo.save(m);
        }
    }

    public void createSeries(List<ModelRequest> list) {
        createModels(list);
    }

    public void createParts(List<PartRequest> list) {
        for (PartRequest r : list) {
            Part p = new Part();
            p.setPartName(r.partname);
            p.setPartNameArabic(r.partnameArabic);
            p.setPartImageUrl(r.url);
            p.setPartDescription(r.partdec);
            p.setMakerId(r.makerid);
            p.setModelId(r.modelid);
            p.setType(r.type);
            p.setYear(r.year);
            partRepo.save(p);
        }
    }

    public void createSubParts(List<SubPartRequest> list) {
        for (SubPartRequest r : list) {
            SubPart s = new SubPart();
            s.setSubPartName(r.subpartname);
            s.setSubPartNameArabic(r.subpartnameArabic);
            s.setSubPartImageUrl(r.url);
            s.setDescription(r.subpartdec);
            s.setMakerId(r.makerid);
            s.setModelId(r.modelid);
            s.setPartId(r.partid);
            s.setType(r.type);
            s.setYear(r.year);
            subPartRepo.save(s);
        }
    }
}
