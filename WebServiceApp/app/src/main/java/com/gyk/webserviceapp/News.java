package com.gyk.webserviceapp;

public class News {
    private String title;
    private String url;
    private String photoUrl;

    public News() {
    }

    public News(String title, String url, String photoUrl) {
        this.title = title;
        this.url = url;
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
