package com.madonasyombua.growwithgoogleteamproject.models;

import android.media.Image;
import android.net.Uri;
import android.widget.ImageView;

import com.madonasyombua.growwithgoogleteamproject.R;

import java.net.URL;

/**
 * Created by jantz on 2/18/2018.
 */

public class Project extends FirebaseObject {
    private String title, shortDescription, longDescription;
    private int portfolioImage;
    private String url;
    private String userKey;

    public Project() {
    }

    public Project(String title, String shortDescription, String longDescription, int portfolioImage, String url) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.portfolioImage = portfolioImage;
        this.url = url;
    }

    @Override
    public String getPath() {
        return getBase() + Paths.SL + getKey();
    }

    @Override
    public String getBase() {
        return Paths.USER + Paths.SL + userKey + Paths.SL + Paths.PROJECT;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getPortfolioImage() {
        return portfolioImage;
    }

    public void setPortfolioImage(int portfolioImage) {
        this.portfolioImage = portfolioImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}