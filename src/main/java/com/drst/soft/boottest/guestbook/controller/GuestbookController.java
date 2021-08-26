package com.drst.soft.boottest.guestbook.controller;

import com.drst.soft.boottest.guestbook.dto.GuestbookDTO;
import com.drst.soft.boottest.guestbook.dto.PageRequestDTO;
import com.drst.soft.boottest.guestbook.dto.PageResultDTO;
import com.drst.soft.boottest.guestbook.entity.Guestbook;
import com.drst.soft.boottest.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public PageResultDTO<GuestbookDTO, Guestbook> list(PageRequestDTO pageRequestDTO) {

        log.info("list ...." + pageRequestDTO);

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        return resultDTO;
    }

    @PostMapping("/register")
    @ResponseBody
    public void registerPost(@RequestBody GuestbookDTO dto) {

        log.info("dto...." + dto);

        Long guestNum = service.register(dto);
    }

    @GetMapping({"/read", "/modify"})
    @ResponseBody
    public GuestbookDTO read(@RequestParam("guestNum") long guestNum) {

        GuestbookDTO dto = service.read(guestNum);

        return dto;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody GuestbookDTO dto) {
        log.info("dto...." + dto);

        service.modify(dto);
    }

    @PostMapping("/remove")
    @ResponseBody
    public void remove(@RequestParam("guestNum") Long guestNum) {
        service.remove(guestNum);
    }

}
