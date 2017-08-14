package com.onanis.crw.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Movie {
    public String id;
    public String siteId;
    public String title;
    public String url;
    public String innerHtml;
    public Date time;
    public List<String> tags;
    public List<String> actors;
    public int goodNum;
    public int badNum;
    public int viewedNum;
    public int favoriteNum;
    public Date uploadedDate;

    public String siteTitle;
    public String siteUrl;
    public int siteGoodNum;
    public int siteBadNum;
    public int siteViewedNum;
    public int siteFavoriteNum;
    public Date siteUploadedDate;

    public Date createdDate;
    public Date updatedDate;
    public boolean deleted;
}
