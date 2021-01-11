package com.tutorial.machinetest.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("albumId")
    public String albumId;

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("url")
    public String url;

    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;
}
