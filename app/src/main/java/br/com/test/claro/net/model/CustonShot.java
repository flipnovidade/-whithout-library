package br.com.test.claro.net.model;

import java.io.Serializable;

public class CustonShot implements Serializable{
    private static final long serialVersionUID = -8005217082358960607L;

    private int id;
    private String title;
    private String description;
    private String publishedAt;
    private String updatedAt;
    private String urlAvatar;
    private String urlImage;
    private String linkPage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String url_avatar) {
        this.urlAvatar = url_avatar;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String url_image) {
        this.urlImage = url_image;
    }

    public String getLinkPage() {
        return linkPage;
    }

    public void setLinkPage(String link_page) {
        this.linkPage = link_page;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
