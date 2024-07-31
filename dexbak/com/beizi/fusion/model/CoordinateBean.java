package com.beizi.fusion.model;

import android.text.TextUtils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CoordinateBean {
    private String bottom;
    private String color;
    private String fontOrCorner;
    private String height;
    private String left;
    private String right;
    private String scale;

    /* renamed from: top  reason: collision with root package name */
    private String f47182top;
    private String width;

    public static CoordinateBean getCoordinate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(":");
        CoordinateBean coordinateBean = new CoordinateBean();
        coordinateBean.setLeft(split[0]);
        coordinateBean.setTop(split[1]);
        coordinateBean.setRight(split[2]);
        coordinateBean.setBottom(split[3]);
        coordinateBean.setWidth(split[4]);
        coordinateBean.setHeight(split[5]);
        coordinateBean.setScale(split[6]);
        coordinateBean.setFontOrCorner(split[7]);
        coordinateBean.setColor(split[8]);
        return coordinateBean;
    }

    public String getBottom() {
        return this.bottom;
    }

    public String getColor() {
        return this.color;
    }

    public String getFontOrCorner() {
        return this.fontOrCorner;
    }

    public String getHeight() {
        return this.height;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }

    public String getScale() {
        return this.scale;
    }

    public String getTop() {
        return this.f47182top;
    }

    public String getWidth() {
        return this.width;
    }

    public void setBottom(String str) {
        this.bottom = str;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setFontOrCorner(String str) {
        this.fontOrCorner = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setLeft(String str) {
        this.left = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setScale(String str) {
        this.scale = str;
    }

    public void setTop(String str) {
        this.f47182top = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }
}
