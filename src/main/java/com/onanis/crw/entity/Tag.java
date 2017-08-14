package com.onanis.crw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Tag {
    public String id;
    public String name;
    public Date createdDate;
    public Date updatedDate;
    public boolean deleted;
}
