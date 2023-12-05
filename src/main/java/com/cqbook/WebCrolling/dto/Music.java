package com.cqbook.WebCrolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private String name;
    private String artist;
    private String imgUrl;
}
