package com.eva.project.service.impl;

import com.eva.project.dto.ShareDto;
import com.eva.project.entity.Share;
import com.eva.project.repo.ShareRepository;
import com.eva.project.service.ShareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ShareServiceImpl implements ShareService {

    private ShareRepository shareRepository;

    @Override
    @Transactional
    public ShareDto save(ShareDto shareDto) {
        Share share = new Share();
        share.setName(shareDto.getName());
        share.setPrice(shareDto.getPrice());
        final Share shareDb = shareRepository.save(share);
        shareDto.setId(shareDb.getId());
        return shareDto;
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        shareRepository.deleteById(id);
        return id;
    }

    @Override
    public List<ShareDto> getAll() {
        List<Share> shares = shareRepository.findAll();
        List<ShareDto> shareDtos = new ArrayList<>();

        shares.forEach(it -> {
            ShareDto shareDto =new ShareDto();
            shareDto.setId(it.getId());
            shareDto.setName(it.getName());
            shareDto.setPrice(it.getPrice());
            shareDtos.add(shareDto);
        });
        return shareDtos;
    }
}
