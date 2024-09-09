package com.amap.api.maps.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public void setCongestedColor(int i4) {
        this.congestedColor = i4;
    }

    public void setExtremelySmoothColor(int i4) {
        this.extremelySmoothColor = i4;
    }

    public void setRatio(float f4) {
        this.ratio = f4;
    }

    public void setSeriousCongestedColor(int i4) {
        this.seriousCongestedColor = i4;
    }

    public void setSlowColor(int i4) {
        this.slowColor = i4;
    }

    public void setSmoothColor(int i4) {
        this.smoothColor = i4;
    }

    public void setTrafficRoadBackgroundColor(int i4) {
        this.trafficRoadBackgroundColor = i4;
    }
}
