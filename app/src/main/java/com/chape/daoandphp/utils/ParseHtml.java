package com.chape.daoandphp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/3.
 */

public class ParseHtml {

    private static List<String> listImgSrc = new ArrayList<>();
    // 获取img标签正则
    //private static final String IMAGE_URL_TAG = "<img.*src=(.*?)[^>]*?>";
    private static final String IMAGE_URL_TAG = "name=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMAGE_URL_CONTENT = "http:\"?(.*?)(\"|>|\\s+)";
    public static List<String> getAllImageUrlFromHtml(String html) {
        Matcher matcher = Pattern.compile(IMAGE_URL_TAG).matcher(html);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        //从图片对应的地址对象中解析出 src 标签对应的内容
        listImgUrl=getAllImageUrlFormSrcObject(listImgUrl);
        return listImgUrl;
    }
    public static List<String> getAllImageUrlFormSrcObject(List<String> listImageUrl) {
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMAGE_URL_CONTENT).matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return listImgSrc;
    }
    public static String getHtmlString(String html){
        String str=html.substring(html.indexOf("<div id=\"tu\" class=\"tu\">")+1, html.lastIndexOf("</div> <div class=\"tub\">"));
        return str;
    }
}
