package com.autonavi.base.ae.gmap.style;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements = new HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleItem(int i4) {
        this.styleTypeId = i4;
    }

    public StyleElement get(int i4) {
        return this.styleElements.get(Integer.valueOf(i4));
    }

    public StyleElement[] getStyleElements() {
        Map<Integer, StyleElement> map = this.styleElements;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return (StyleElement[]) this.styleElements.values().toArray(new StyleElement[this.styleElements.size()]);
    }

    public boolean isValid() {
        return this.styleElements.size() > 0 && this.styleTypeId >= 0;
    }

    public void put(int i4, StyleElement styleElement) {
        this.styleElements.put(Integer.valueOf(i4), styleElement);
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + "\nstyleElements.size :" + this.styleElements.size();
    }
}
