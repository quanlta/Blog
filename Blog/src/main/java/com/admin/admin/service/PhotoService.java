package com.admin.admin.service;

import com.admin.admin.payload.ApiResponse;
import com.admin.admin.payload.PagedResponse;
import com.admin.admin.payload.PhotoRequest;
import com.admin.admin.payload.PhotoResponse;
import com.admin.admin.security.UserPrincipal;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}