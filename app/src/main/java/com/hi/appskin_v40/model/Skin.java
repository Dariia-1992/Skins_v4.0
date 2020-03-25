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

    public Skin(String id, String title, int[] bigImage, int rating, int description, String url, int [] descriptionImages) {
        this.id = id;
        this.title = title;
        this.bigImages = bigImage;
        this.rating = rating;
        this.description = description;
        this.url = url;
        this.descriptionImages = descriptionImages;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int[] getBigImages() { return bigImages; }
    public int getDescription() { return description; }
    public String getUrl() { return url; }
    public int[] getDescriptionImages() { return descriptionImages; }

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

    public boolean isUpdatedToday() { return true; }
}
