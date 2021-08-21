package com.drst.soft.boottest.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {

    private Long guestNum;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;
}
