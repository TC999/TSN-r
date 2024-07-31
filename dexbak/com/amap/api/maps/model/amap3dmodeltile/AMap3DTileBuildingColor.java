package com.amap.api.maps.model.amap3dmodeltile;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMap3DTileBuildingColor {
    public int color;
    public String type;

    public AMap3DTileBuildingColor(String str, int i) {
        this.type = str;
        this.color = i;
    }
}
