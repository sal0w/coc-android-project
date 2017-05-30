package com.parse.starter;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by salow on 11/21/2015.
 */
@ParseClassName("salow")
public class Base extends ParseObject {

    public Boolean getBase() {
        return getBoolean("Base");
    }

    public void setBase(Boolean base) {
        put("Base",base);
    }

    public String getDescription() {
        return getString("String");
    }

    public void setDescription(String description) {
        put("String",description);
    }

    public ParseFile getImage() {
        return getParseFile("Image");
    }

    public void setImage(ParseFile image) {
        put("Image",image);
    }

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name",name);
    }

    public int getTownhall() {
        return getInt("Townhall");
    }

    public void setTownhall(int townhall) {
        put("Townhall",townhall);
    }

   /* public Date getCreatedAt() {
        return getDate("createdAt");
    }

    public void setCreatedAt(Date createdAt) {
        put("createdAt",createdAt);
    }


    public String getObjectId() {
        return getString("objectId");
    }


    public void setObjectId(String objectId) {
        put("objectId",objectId);
    }*/
    public int getViews() {
        return getInt("Views");
    }

    public void setViews(int views) {
        put("Views",views);
    }


    Boolean Base;
    int Townhall;
    String Name;
    ParseFile Image;
    String Description;




    Date createdAt;
    String objectId;



    int Views;



}
