package com.admin.admin.service;

import com.admin.admin.model.Tag;
import com.admin.admin.payload.ApiResponse;
import com.admin.admin.payload.PagedResponse;
import com.admin.admin.security.UserPrincipal;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag, UserPrincipal currentUser);

	Tag updateTag(Long id, Tag newTag, UserPrincipal currentUser);

	ApiResponse deleteTag(Long id, UserPrincipal currentUser);

}
