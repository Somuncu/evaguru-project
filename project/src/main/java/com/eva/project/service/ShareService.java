package com.eva.project.service;

import com.eva.project.dto.ShareDto;

import java.util.List;

public interface ShareService {

    ShareDto save(ShareDto shareDto);

    Long delete(Long id);

    List<ShareDto> getAll();
}
