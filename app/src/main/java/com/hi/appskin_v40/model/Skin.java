package com.hi.appskin_v40.model;

import androidx.annotation.StringRes;

import com.hi.appskin_v40.utils.MD5;

public class Skin {
    private String id;
    private String title;
    private int[] bigImages;
    private int rating;
    private @StringRes int description;
    private String url;
    private int [] descriptionImages;
    private String favoriteName;


    public Skin(String id, String title, int[] bigImage, int rating, int description, String url, int [] descriptionImages) {
        this.id = id;
        this.title = title;
        this.bigImages = bigImage;
        this.rating = rating;
        this.description = description;
        this.url = url;
        this.descriptionImages = descriptionImages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getBigImages() {
        return bigImages;
    }

    public void setBigImages(int[] bigImages) {
        this.bigImages = bigImages;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getDescriptionImages() {
        return descriptionImages;
    }

    public void setDescriptionImages(int[] descriptionImages) {
        this.descriptionImages = descriptionImages;
    }

    public int getRating() {
        if (rating < 0)
            return 0;

        if (rating > 5)
            return 5;

        return rating;
    }
    public int getFirstImage() {
        return bigImages.length == 0 ? 0 : bigImages[0];
    }

    public String generateKey() {
        return MD5.generate(title + url);
    }
}
