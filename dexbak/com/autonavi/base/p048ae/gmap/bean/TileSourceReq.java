package com.autonavi.base.p048ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* renamed from: com.autonavi.base.ae.gmap.bean.TileSourceReq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TileSourceReq {
    public int sourceType;

    /* renamed from: x */
    public int f8416x;

    /* renamed from: y */
    public int f8417y;
    public int zoom;

    @JBindingExclude
    public String toString() {
        return "TileSourceReq{x=" + this.f8416x + ", y=" + this.f8417y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
