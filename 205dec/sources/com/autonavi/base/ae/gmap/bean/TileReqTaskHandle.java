package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TileReqTaskHandle {
    @JBindingInclude
    long nativeObj;
    @JBindingInclude
    int status;
    @JBindingInclude
    Tile tile;

    public void finish(Tile tile) {
        this.tile = tile;
    }
}
