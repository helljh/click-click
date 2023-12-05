package com.cqbook.WebCrolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    private String title;
    private String place;
    private String imgUrl;
    private String state;
}
