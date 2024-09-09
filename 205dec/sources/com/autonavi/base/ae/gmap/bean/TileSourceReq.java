package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TileSourceReq {
    public int sourceType;

    /* renamed from: x  reason: collision with root package name */
    public int f12054x;

    /* renamed from: y  reason: collision with root package name */
    public int f12055y;
    public int zoom;

    @JBindingExclude
    public String toString() {
        return "TileSourceReq{x=" + this.f12054x + ", y=" + this.f12055y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
