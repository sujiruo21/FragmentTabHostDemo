package com.zl.fragmenttabhostdemo.entity;

/**
 * Created by zl on 17-12-9.
 */

public class Tab {

    private final Class fragment;
    private final int title;
    private final int icon;

    public Tab(Class fragment, int title, int icon){
        this.fragment = fragment;
        this.title = title;
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public int getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

}
