package org.motopart.cloud.service;

import jakarta.persistence.criteria.Predicate;
import org.motopart.cloud.dto.request.PostRequest;
import org.motopart.cloud.entity.Post;
import org.motopart.cloud.entity.UserEntity;
import org.motopart.cloud.repository.PostRepository;
import org.motopart.cloud.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public List<Post> getPosts(String type, String makerId, String modelId, String year,
                               String partId, String subpartId, String itemCondition,
                               String location, Integer userid, int start, int count) {

        Specification<Post> spec = (root, query, cb) -> {
            List<Predicate> preds = new ArrayList<>();
            if (notEmpty(makerId)) preds.add(cb.equal(root.get("makerId"), makerId));
            if (notEmpty(type) && !"0".equals(type)) preds.add(cb.equal(root.get("type"), type));
            if (notEmpty(modelId)) preds.add(cb.equal(root.get("modelId"), modelId));
            if (notEmpty(year)) preds.add(cb.equal(root.get("year"), year));
            if (notEmpty(partId)) preds.add(cb.equal(root.get("partId"), partId));
            if (notEmpty(subpartId)) preds.add(cb.equal(root.get("subPartId"), subpartId));
            if (notEmpty(itemCondition)) preds.add(cb.equal(root.get("itemCondition"), itemCondition));
            if (notEmpty(location)) preds.add(cb.equal(root.get("location"), location));
            if (userid != null && userid > 0) preds.add(cb.equal(root.get("userId"), String.valueOf(userid)));
            return cb.and(preds.toArray(new Predicate[0]));
        };

        Pageable page = PageRequest.of(start / Math.max(count, 1), Math.max(count, 1));
        return postRepo.findAll(spec, page).getContent();
    }

    public List<Post> search(String term, int count) {
        Pageable page = PageRequest.of(0, Math.max(count, 1));
        return postRepo.findByItemTittleContainingIgnoreCaseOrItemDescriptionContainingIgnoreCase(
                term, term, page);
    }

    public String createPosts(List<PostRequest> requests, String userIdHeader) {
        String lastId = "";
        for (PostRequest r : requests) {
            Post p = new Post();
            p.setUserId(r.userId != null ? r.userId : userIdHeader);
            p.setItemCondition(r.condition);
            p.setType(r.type);
            p.setYear(r.year);
            p.setMakerId(r.makerId);
            p.setModelId(r.modelId);
            p.setPartId(r.partId);
            p.setSubPartId(r.subpartId);
            p.setItemUsage(r.usage);
            p.setItemTittle(r.tittle);
            p.setItemDescription(r.description);
            p.setPrice(r.price);
            p.setImageUrl1(r.img1);
            p.setImageUrl2(r.img2);
            p.setImageUrl3(r.img3);
            p.setImageUrl4(r.img4);
            p.setImageUrl5(r.img5);
            p.setImageUrl6(r.img6);
            p.setStatus(String.valueOf(r.status));
            p.setPartNumber(r.partNumber);
            p.setSellBuy(r.sellBuy);
            p.setLocation(r.city);

            // hydrate denormalized user fields
            if (notEmpty(p.getUserId())) {
                try {
                    UserEntity u = userRepo.findById(Long.parseLong(p.getUserId())).orElse(null);
                    if (u != null) {
                        p.setUserName(u.getUsername());
                        p.setUserType(u.getType());
                        p.setLocationId(u.getLocationId());
                        p.setPhoneNumber(u.getMobile());
                        if (!notEmpty(p.getLocation())) p.setLocation(u.getLocation());
                    }
                } catch (NumberFormatException ignored) { }
            }

            p.setCreatedAt(Instant.now());
            p.setLastUpdated(Instant.now());
            lastId = String.valueOf(postRepo.save(p).getId());
        }
        return lastId;
    }

    public void setPostStatus(String postId, String status) {
        postRepo.findById(Long.parseLong(postId)).ifPresent(p -> {
            p.setStatus(status);
            p.setLastUpdated(Instant.now());
            postRepo.save(p);
        });
    }

    private boolean notEmpty(String s) { return s != null && !s.isEmpty(); }
}
