package com.cqbook.WebCrolling.controller;

import com.cqbook.WebCrolling.dto.*;
import com.cqbook.WebCrolling.service.WebService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WebController {


    private final WebService webService;

    @GetMapping("/crawler")
    public List<String> showIngredients(){
        String menu = "참치김치찌개";
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=" + menu + "+레시피";
        List<String> ingredients = webService.getIngredients(url, "재료");

        return ingredients;
    }

    @GetMapping("/ott")
    public List<Ott> showOtt(){
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=tab_etc&mra=bkdJ&qvt=0&query=%EB%84%B7%ED%94%8C%EB%A6%AD%EC%8A%A4%20%EC%B6%94%EC%B2%9C";
        List<Ott> result = webService.getOtt(url);
        return result;
    }

    @GetMapping("/movie")
    public List<Movie> showMovie(){
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%B0%95%EC%8A%A4%EC%98%A4%ED%94%BC%EC%8A%A4+%EA%B4%80%EA%B0%9D%EC%88%98";
        List<Movie> result = webService.getMovies(url);
        return result;
    }

    @GetMapping("/webtoon")
    public List<Webtoon> showWebtoon(){
        String day = "목요일";
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=" + day +"+웹툰";
        List<Webtoon> result = webService.getWebtoons(url);
        return result;
    }


    @GetMapping("/theater")
    public List<Theater> showTheater(){
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=연극+예매현황";
        List<Theater> result = webService.getTheaters(url);
        return result;
    }

    @GetMapping("/musical")
    public List<Theater> showMusical(){
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=뮤지컬+예매현황";
        List<Theater> result = webService.getTheaters(url);
        return result;
    }

    @GetMapping("/concert")
    public List<Concert> showConcert(){
        String url = "https://ticket.interpark.com/ConcertIndex.asp";
        List<Concert> result = webService.getConcerts(url);
        return result;
    }

    @GetMapping("/book")
    public List<Book> showBook(){
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=베스트셀러";
        List<Book> result = webService.getBooks(url);
        return result;
    }

    @GetMapping("/music")
    public List<Music> showMusic(@RequestParam String genre){
        String genre1 = genre;
        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query="+ genre1 +"+인기순위";
        List<Music> result = webService.getMusics(url);
        return result;
    }
}
