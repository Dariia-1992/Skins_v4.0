package com.hi.appskin_v40.model;

import androidx.annotation.StringRes;

import com.hi.appskin_v40.utils.MD5;

public class Skin {
    private String id;
    private String title;
    private int[] bigImages;
    private int rating;
    private int intName;
    private boolean isFavorite;
    private boolean isNumber;
    private @StringRes int description;
    private String url;
    private int [] descriptionImages;


    public Skin(String id, String title, int[] bigImage, int rating, int description, String url, int [] descriptionImages, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.bigImages = bigImage;
        this.rating = rating;
        this.description = description;
        this.url = url;
        this.descriptionImages = descriptionImages;
        this.isFavorite = isFavorite;
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

    public void setIntName(int intName) {
        this.intName = intName;
    }

    public void setNumber(boolean number) {
        isNumber = number;
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }


    public int getIntName() {
        return intName;
    }

    public boolean isNumber() {
        return isNumber;
    }

    private void parseName() {
        try {
            intName = Integer.parseInt(title);
            isNumber = true;
        } catch (NumberFormatException e) { }
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
