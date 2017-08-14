package com.onanis.crw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CrawlSettings {
    public String id;
    public String siteId;
    public String userId;
    public String password;

    public Date createdDate;
    public Date updatedDate;
    public boolean deleted;
}
