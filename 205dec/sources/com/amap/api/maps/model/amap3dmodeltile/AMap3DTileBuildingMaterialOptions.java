package com.amap.api.maps.model.amap3dmodeltile;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMap3DTileBuildingMaterialOptions {
    public float metallicFactor;
    public float roughnessFactor;
    public String type;

    public AMap3DTileBuildingMaterialOptions(String str, float f4, float f5) {
        this.type = str;
        this.metallicFactor = f4;
        this.roughnessFactor = f5;
    }
}
