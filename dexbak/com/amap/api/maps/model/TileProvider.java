package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.obtain(-1, -1, null);

    @JBindingInclude
    Tile getTile(int i, int i2, int i3);

    @JBindingInclude
    int getTileHeight();

    @JBindingInclude
    int getTileWidth();
}
