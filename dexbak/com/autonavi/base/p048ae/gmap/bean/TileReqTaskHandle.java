package com.autonavi.base.p048ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* renamed from: com.autonavi.base.ae.gmap.bean.TileReqTaskHandle */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
