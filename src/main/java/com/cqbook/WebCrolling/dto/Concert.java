package com.cqbook.WebCrolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concert {
    private String artist;
    private String detail;
    private String name;
    private String imgUrl;

}
