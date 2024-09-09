package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public ColorLatLng(List<LatLng> list, int i4) {
        ArrayList arrayList = new ArrayList();
        this.latLngs = arrayList;
        arrayList.clear();
        this.latLngs.addAll(list);
        this.color = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorLatLng colorLatLng = (ColorLatLng) obj;
            if (this.color == colorLatLng.color && androidx.core.graphics.a.a(this.latLngs, colorLatLng.latLngs)) {
                return true;
            }
        }
        return false;
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.latLngs, Integer.valueOf(this.color)});
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + this.latLngs + ", color=" + this.color + '}';
    }
}
