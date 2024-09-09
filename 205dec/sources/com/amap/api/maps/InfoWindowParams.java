package com.amap.api.maps;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class InfoWindowParams {
    public static final int INFOWINDOW_TYPE_IMAGE = 1;
    public static final int INFOWINDOW_TYPE_VIEW = 2;
    private View infoContent;
    private View infoWindow;
    private int infoWindowType = 2;
    private int mInfoWindowUpdateTime;

    public View getInfoContents() {
        return this.infoContent;
    }

    public View getInfoWindow() {
        return this.infoWindow;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }

    public long getInfoWindowUpdateTime() {
        return this.mInfoWindowUpdateTime;
    }

    public void setInfoContent(View view) {
        this.infoContent = view;
    }

    public void setInfoWindow(View view) {
        this.infoWindow = view;
    }

    public void setInfoWindowType(int i4) {
        this.infoWindowType = i4;
    }

    public void setInfoWindowUpdateTime(int i4) {
        this.mInfoWindowUpdateTime = i4;
    }
}
