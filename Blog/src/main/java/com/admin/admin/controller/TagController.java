package com.admin.admin.controller;

import com.admin.admin.model.Tag;
import com.admin.admin.payload.ApiResponse;
import com.admin.admin.payload.PagedResponse;
import com.admin.admin.security.CurrentUser;
import com.admin.admin.security.UserPrincipal;
import com.admin.admin.service.TagService;
import com.admin.admin.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tags")
public class TagController {
	@Autowired
	private TagService tagService;

	@GetMapping
	public ResponseEntity<PagedResponse<Tag>> getAllTags(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<Tag> response = tagService.getAllTags(page, size);

		return new ResponseEntity< >(response, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Tag> addTag(@Valid @RequestBody Tag tag, @CurrentUser UserPrincipal currentUser) {
		Tag newTag = tagService.addTag(tag, currentUser);

		return new ResponseEntity< >(newTag, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tag> getTag(@PathVariable(name = "id") Long id) {
		Tag tag = tagService.getTag(id);

		return new ResponseEntity< >(tag, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Tag> updateTag(@PathVariable(name = "id") Long id, @Valid @RequestBody Tag tag, @CurrentUser UserPrincipal currentUser) {

		Tag updatedTag = tagService.updateTag(id, tag, currentUser);

		return new ResponseEntity< >(updatedTag, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteTag(@PathVariable(name = "id") Long id, @CurrentUser UserPrincipal currentUser) {
		ApiResponse apiResponse = tagService.deleteTag(id, currentUser);

		return new ResponseEntity< >(apiResponse, HttpStatus.OK);
	}

}
