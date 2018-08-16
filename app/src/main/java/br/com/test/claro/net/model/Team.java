package br.com.test.claro.net.model;

import java.io.Serializable;

public class Team implements Serializable {
    private static final long serialVersionUID = -5148308186449580379L;

    private String avatar_url;

    public String getUrlAvatar() {
        return avatar_url;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.avatar_url = urlAvatar;
    }
}
