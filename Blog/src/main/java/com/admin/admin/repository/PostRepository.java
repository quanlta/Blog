package com.admin.admin.repository;

import com.admin.admin.model.Post;
import com.admin.admin.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Page<Post> findByCreatedBy(Long userId, Pageable pageable);

	Page<Post> findByCategory(Long categoryId, Pageable pageable);

	Page<Post> findByTags(List<Tag> tags, Pageable pageable);

	Long countByCreatedBy(Long userId);
}
