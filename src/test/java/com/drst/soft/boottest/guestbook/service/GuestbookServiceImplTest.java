package com.drst.soft.boottest.guestbook.service;

import com.drst.soft.boottest.guestbook.dto.GuestbookDTO;
import com.drst.soft.boottest.guestbook.dto.PageRequestDTO;
import com.drst.soft.boottest.guestbook.dto.PageResultDTO;
import com.drst.soft.boottest.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceImplTest {

    @Autowired
    private GuestbookService service;

    @Test
    public void testregister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("sample")
                .content("sample content")
                .writer("user0")
                .build();
        System.out.println(service.register(guestbookDTO));

    }

    @Test
    void getList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());

        System.out.println("resultDTO : "+resultDTO);

        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println("guestbookDTO : "+guestbookDTO);
        }

        System.out.println("=========================================");

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
