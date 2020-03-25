package com.hi.appskin_v40.model;

import com.hi.appskin_v40.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SkinsRepository {
    private static List<Skin> items;

    public static List<Skin> getItems() {
        if (items == null || items.isEmpty())
            initItems();
        return items;
    }

    public static Skin getItemById(String itemId) {
        if (itemId == null || itemId.isEmpty())
            return null;

        for (Skin info : items) {
            if (info.getId().equals(itemId))
                return info;
        }

        return null;
    }

    private static void initItems() {
        items = new ArrayList<>();

        addItem("Test Title 1",
                new int[]{
                        R.drawable.item_1_1,
                        R.drawable.item_1_2,
                        R.drawable.item_1_3},
                5,
                R.string.text_description_1,
                "https://datazlasaya.sgp1.cdn.digitaloceanspaces.com/mod-blueline/darkglade03-furniture-addon-v3.mcaddon",
                new int[]{
                        R.drawable.item_1_1,
                        R.drawable.item_1_2,
                        R.drawable.item_1_3
                });     // Screenshot

        addItem("Test Title 2",
                new int[]{
                        R.drawable.item_1_1,
                        R.drawable.item_1_2,
                        R.drawable.item_1_3 },
                5,
                R.string.text_description_1,
                "https://datazlasaya.sgp1.cdn.digitaloceanspaces.com/mod-blueline/darkglade03-furniture-addon-v3.mcaddon",
                new int[]{
                        R.drawable.item_1_1,
                        R.drawable.item_1_2,
                        R.drawable.item_1_3
                });
        // Screenshot
        addItem("Test Title 3",
                new int[]{
                        R.drawable.item_1_1},
                4,
                R.string.text_description_1,
                "https://datazlasaya.sgp1.cdn.digitaloceanspaces.com/mod-blueline/darkglade03-furniture-addon-v3.mcaddon",
                new int[]{
                        R.drawable.item_1_1,
                        R.drawable.item_1_2,
                        R.drawable.item_1_3
                });     // Screenshot
    }

    private static void addItem(String title, int [] bigImage, int rating, int description, String url, int [] descriptionImages) {
        items.add(new Skin(UUID.randomUUID().toString(), title, bigImage, rating, description, url, descriptionImages));
    }
}
