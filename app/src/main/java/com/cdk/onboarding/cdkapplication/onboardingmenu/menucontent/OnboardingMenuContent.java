package com.cdk.onboarding.cdkapplication.onboardingmenu.menucontent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class OnboardingMenuContent {


    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

    private static final int COUNT = 25;

    static {
        addItem(createDummyItem(1, "HOME"));
        addItem(createDummyItem(2, "ABOUT_CDK"));
        addItem(createDummyItem(3, "RAISE_TICKETS"));
        addItem(createDummyItem(4, "LOGOUT"));
    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MenuItem createDummyItem(int position, String type) {
        MenuItem currentItem = null;
        switch (type) {
            case "HOME":
                currentItem = new MenuItem(String.valueOf(position), "Home", getMenuDetailsByType(position, type) , "http://www.cdkglobal.com");
                break;
            case "ABOUT_CDK":
                currentItem = new MenuItem(String.valueOf(position), "About CDK", getMenuDetailsByType(position, type) , "http://www.cdkglobal.com/company");
                break;
            case "RAISE_TICKETS":
                currentItem = new MenuItem(String.valueOf(position), "Raise tickets", getMenuDetailsByType(position, type));
                break;
            case "LOGOUT":
                currentItem = new MenuItem(String.valueOf(position), "Logout", getMenuDetailsByType(position, type));

        }
        return currentItem;
    }

    private static String getMenuDetailsByType(int position, String type) {
        StringBuilder builder = new StringBuilder();
        switch (type) {
            case "HOME":
                builder.append("Home details");
                break;
            case "ABOUT_CDK":
                builder.append("About CDK details");
                break;
            case "RAISE_TICKETS":
                builder.append("Raise tickets details");
                break;
            case "LOGOUT":
                builder.append("Logout details");

        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MenuItem {
        public final String id;
        public final String content;
        public final String details;
        public String url;
        
        public MenuItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.url = url;
        }

        public MenuItem(String id, String content, String details,String url) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.url = url;
        }
        @Override
        public String toString() {
            return content;
        }
    }
}
