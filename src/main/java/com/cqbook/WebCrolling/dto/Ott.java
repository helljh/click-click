package com.cqbook.WebCrolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ott {
    private String title;
    private List<String> hashtags;
    private String ImageUrl;
}
