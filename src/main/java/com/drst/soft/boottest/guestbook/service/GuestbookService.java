package com.drst.soft.boottest.guestbook.service;

import com.drst.soft.boottest.guestbook.dto.GuestbookDTO;
import com.drst.soft.boottest.guestbook.dto.PageRequestDTO;
import com.drst.soft.boottest.guestbook.dto.PageResultDTO;
import com.drst.soft.boottest.guestbook.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .guestNum(dto.getGuestNum())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDTO(Guestbook entity) {
        GuestbookDTO dto = GuestbookDTO.builder()
                .guestNum(entity.getGuestNum())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
