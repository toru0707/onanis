package com.onanis.crw.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class SiteMovie {
    public String id;
    public String siteId;
    public String title;
    public String url;
    public String innerHtml;
    public Date playTime;
    public List<String> tags;
    public List<String> actors;
    public int goodNum;
    public int badNum;
    public int viewedNum;
    public int favoriteNum;
    public Date uploadedDate;
    public Date createdDate;
    public Date updatedDate;
    public boolean deleted;

}
