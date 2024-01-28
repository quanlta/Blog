package com.admin.admin.service;

import com.admin.admin.model.Album;
import com.admin.admin.payload.AlbumResponse;
import com.admin.admin.payload.ApiResponse;
import com.admin.admin.payload.PagedResponse;
import com.admin.admin.payload.request.AlbumRequest;
import com.admin.admin.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest, UserPrincipal currentUser);

	ResponseEntity<Album> getAlbum(Long id);

	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum, UserPrincipal currentUser);

	ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser);

	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
