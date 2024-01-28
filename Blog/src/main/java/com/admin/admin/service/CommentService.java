package com.admin.admin.service;

import com.admin.admin.model.Comment;
import com.admin.admin.payload.ApiResponse;
import com.admin.admin.payload.CommentRequest;
import com.admin.admin.payload.PagedResponse;
import com.admin.admin.security.UserPrincipal;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
