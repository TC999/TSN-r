package com.autonavi.base.p048ae.gmap.style;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.autonavi.base.ae.gmap.style.StyleItem */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements = new HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleItem(int i) {
        this.styleTypeId = i;
    }

    public StyleElement get(int i) {
        return this.styleElements.get(Integer.valueOf(i));
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

    public void put(int i, StyleElement styleElement) {
        this.styleElements.put(Integer.valueOf(i), styleElement);
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + ShellAdbUtils.f33810d + "styleElements.size :" + this.styleElements.size();
    }
}
