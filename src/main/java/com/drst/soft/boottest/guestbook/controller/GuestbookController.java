package com.drst.soft.boottest.guestbook.controller;

import com.drst.soft.boottest.guestbook.dto.GuestbookDTO;
import com.drst.soft.boottest.guestbook.dto.PageRequestDTO;
import com.drst.soft.boottest.guestbook.dto.PageResultDTO;
import com.drst.soft.boottest.guestbook.entity.Guestbook;
import com.drst.soft.boottest.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping({"/"})
    public void list() {
        log.info("guestbook list...");
    }

    @GetMapping("/list")
    @ResponseBody
    public List<GuestbookDTO> list(PageRequestDTO pageRequestDTO) {
        List<GuestbookDTO> dtoList = new ArrayList<>();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        dtoList.clear();

        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {

            guestbookDTO.setTotalPage(resultDTO.getTotalPage());
            guestbookDTO.setPage(resultDTO.getPage());
            guestbookDTO.setSize(resultDTO.getSize());
            guestbookDTO.setStart(resultDTO.getStart());
            guestbookDTO.setEnd(resultDTO.getEnd());
            guestbookDTO.setPrev(resultDTO.isPrev());
            guestbookDTO.setNext(resultDTO.isNext());
            guestbookDTO.setPageList(resultDTO.getPageList());

            dtoList.add(guestbookDTO);
        }

        return dtoList;
    }

}
