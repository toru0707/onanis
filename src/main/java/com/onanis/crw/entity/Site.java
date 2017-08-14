package com.onanis.crw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Site {
    public String id;
    public String title;

    public Date createdDate;
    public Date updatedDate;
    public boolean deleted;
}
