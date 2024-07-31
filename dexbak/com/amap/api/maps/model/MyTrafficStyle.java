package com.amap.api.maps.model;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MyTrafficStyle {
    private int extremelySmoothColor = -15229099;
    private int smoothColor = -16735735;
    private int slowColor = -35576;
    private int congestedColor = -1441006;
    private int seriousCongestedColor = -7208950;
    private float ratio = 0.8f;
    private int trafficRoadBackgroundColor = -1;

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public int getExtremelySmoothColor() {
        return this.extremelySmoothColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int i) {
        this.congestedColor = i;
    }

    public void setExtremelySmoothColor(int i) {
        this.extremelySmoothColor = i;
    }

    public void setRatio(float f) {
        this.ratio = f;
    }

    public void setSeriousCongestedColor(int i) {
        this.seriousCongestedColor = i;
    }

    public void setSlowColor(int i) {
        this.slowColor = i;
    }

    public void setSmoothColor(int i) {
        this.smoothColor = i;
    }

    public void setTrafficRoadBackgroundColor(int i) {
        this.trafficRoadBackgroundColor = i;
    }
}
