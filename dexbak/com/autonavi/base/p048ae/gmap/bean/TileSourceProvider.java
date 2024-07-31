package com.autonavi.base.p048ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* renamed from: com.autonavi.base.ae.gmap.bean.TileSourceProvider */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TileSourceProvider extends TileProvider {
    @JBindingInclude
    void cancel(TileSourceReq tileSourceReq);

    @JBindingInclude
    Tile getTile(TileSourceReq tileSourceReq);
}
