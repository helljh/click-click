package com.cqbook.WebCrolling.service;

import com.cqbook.WebCrolling.dto.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebService {


    public List<String> getIngredients(String url, String targetText) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("tit");

            for (Element element : elements) {
                if (element.text().equals(targetText)) {
                    Element nextElement = element.nextElementSibling();
                    if (nextElement != null) {
                        List<String> result = new ArrayList<>();
                        for(String ingredient : nextElement.text().split(",")){
                            result.add(ingredient.trim());
                        }

                        List<String> result2 = new ArrayList<>();
                        for(String ingredient : result){
                            String[] parts = ingredient.split(" ");
                            if(parts.length > 0){
                                result2.add(parts[0]);
                            }
                        }
                        return result2;
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Ott> getOtt(String url){
        List<Ott> results = new ArrayList<>();


        try {
            Document doc = Jsoup.connect(url).get();
            Elements infoBoxElements = doc.getElementsByClass("info_box");

            // 상위 3개의 info_box 클래스만 처리
            for (int i = 0; i < Math.min(3, infoBoxElements.size()); i++) {
                results.add(new Ott());
                List<String> hashtags = new ArrayList<>();
                Element infoElement = infoBoxElements.get(i);
                Elements titleElements = infoElement.select(".title");
                Elements hashtagBoxElements = infoElement.select(".hashtag_box");



                Elements aElements = infoElement.getElementsByClass("_text");
                System.out.println(aElements.text());
                results.get(i).setTitle(aElements.text());


                for (Element target : hashtagBoxElements) {
                    Elements spanElements = target.select("span");
                    for (Element span : spanElements) {
                        hashtags.add(span.text());
                    }
                }
                results.get(i).setHashtags(hashtags);

                Elements thumbElements = infoElement.select("img");
                String imgUrl = thumbElements.get(0).attr("src");
                results.get(i).setImageUrl(imgUrl);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Movie> getMovies(String url){
        List<Movie> results = new ArrayList<>();


        try {
            Document doc = Jsoup.connect(url).get();
            Element panel = doc.select("._panel").first();

            List<Element> liElements = panel.select("li").subList(0,3);

            for(int i=0; i<liElements.size(); i++){
                results.add(new Movie());
                String title = liElements.get(i).select(".name").text();
                String audience = liElements.get(i).select(".sub_text").text();
                String imgUrl = liElements.get(i).select("img").attr("src");
                results.get(i).setTitle(title);
                results.get(i).setAudience(audience);
                results.get(i).setImgUrl(imgUrl);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Webtoon> getWebtoons(String url){
        List<Webtoon> results = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Element panel = doc.select("._panel").first();

            List<Element> liElements = panel.select("li").subList(0,3);

            for(int i=0; i<liElements.size(); i++){
                results.add(new Webtoon());
                String title = liElements.get(i).select(".name").text();
                String author = liElements.get(i).select(".sub_text").text();
                String imgUrl = liElements.get(i).select("img").attr("src");
                results.get(i).setTitle(title);
                results.get(i).setAuthor(author);
                results.get(i).setImgUrl(imgUrl);
            }


        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Theater> getTheaters(String url){
        List<Theater> results = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Element panel = doc.select("._info").first();

            List<Element> liElements = panel.select("li").subList(0,3);

            for(int i=0; i<liElements.size(); i++){
                results.add(new Theater());
                String title = liElements.get(i).select(".name").text();
                String place = liElements.get(i).select(".sub_text").text();
                String imgUrl = liElements.get(i).select("img").attr("src");
                String state = liElements.get(i).select(".this_text").text();
                results.get(i).setTitle(title);
                results.get(i).setPlace(place);
                results.get(i).setImgUrl(imgUrl);
                results.get(i).setState(state);
            }


        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Concert> getConcerts(String url){
        List<Concert> results = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Element list = doc.select(".issue").first();

            List<Element> listElements = list.select("dt").subList(0,6);
            System.out.println(listElements);

            for(int i=0; i<listElements.size(); i++){
                results.add(new Concert());
                String artist = listElements.get(i).select(".txt1").text();
                String detail = listElements.get(i).select(".txt2").text();
                String name = listElements.get(i).select(".txt3").text();
                String imgUrl = listElements.get(i).select("img").attr("src");
                results.get(i).setArtist(artist);
                results.get(i).setDetail(detail);
                results.get(i).setName(name);
                results.get(i).setImgUrl(imgUrl);
            }


        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Book> getBooks(String url){
        List<Book> results = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Element list = doc.select(".list_area").last();

            List<Element> infoElements = list.select(".info_area").subList(0,3);
            List<Element> imgElements = list.select(".item").subList(0,3);



            for(int i=0; i<infoElements.size(); i++){
                results.add(new Book());
                String title = infoElements.get(i).select("a").text();
                String author = infoElements.get(i).select(".writer").text();
                String publish = infoElements.get(i).select(".publish").text();
                String imgUrl = imgElements.get(i).select("img").attr("src");
                results.get(i).setName(title);
                results.get(i).setAuthor(author);
                results.get(i).setPublish(publish);
                results.get(i).setImgUrl(imgUrl);


            }


        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }

    public List<Music> getMusics(String url){
        List<Music> results = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Element list = doc.select(".chart_list").first();

            List<Element> infoElements = list.select("li").subList(0,3);




            for(int i=0; i<infoElements.size(); i++){
                results.add(new Music());
                Elements imgElements = infoElements.get(i).select(".jacket_area");
                String name = infoElements.get(i).select(".txt").text();
                String artist = infoElements.get(i).select(".name").text();
                //String imgUrl = imgElements.get(0).select("img").attr("src");
                results.get(i).setName(name);
                results.get(i).setArtist(artist);
                //results.get(i).setImgUrl(imgUrl);


            }


        } catch (IOException e) {
            System.out.println(e);
        }
        return results;
    }
}
