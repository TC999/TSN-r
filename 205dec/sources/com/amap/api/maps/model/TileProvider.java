package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.obtain(-1, -1, null);

    @JBindingInclude
    Tile getTile(int i4, int i5, int i6);

    @JBindingInclude
    int getTileHeight();

    @JBindingInclude
    int getTileWidth();
}
