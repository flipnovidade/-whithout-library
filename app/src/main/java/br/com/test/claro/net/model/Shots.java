package br.com.test.claro.net.model;

import java.io.Serializable;

public class Shots implements Serializable {
    private static final long serialVersionUID = 8464531271271783035L;

    private int id;
    private String title;
    private String description;
    private int views_count;
    private int likes_count;
    private int comments_count;
    private Team team;
    private MyImages images;

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

    public int getCommentCount() {
        return comments_count;
    }

    public void setCommentCount(int commentCount) {
        this.comments_count = commentCount;
    }

    public int getLikesCount() {
        return likes_count;
    }

    public void setLikesCount(int likesCount) {
        this.likes_count = likesCount;
    }

    public int getViewsCount() {
        return views_count;
    }

    public void setViewsCount(int viewsCount) {
        this.views_count = viewsCount;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public MyImages getImages() {
        return images;
    }

    public void setImages(MyImages images) {
        this.images = images;
    }
}