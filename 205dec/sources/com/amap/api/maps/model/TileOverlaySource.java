package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TileOverlaySource {
    @JBindingExclude
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;
    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE = 1;
    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;
    @JBindingExclude
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private String attribute;
    private final int id;
    private final int type;
    private final String url;
    private int minZoom = 3;
    private int maxZoom = 20;
    private boolean cacheEnabled = true;

    public TileOverlaySource(int i4, int i5, String str) {
        this.url = str;
        this.type = i5;
        this.id = i4;
    }

    public int getId() {
        return this.id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean z3) {
        this.cacheEnabled = z3;
    }

    public void setMaxZoom(int i4) {
        this.maxZoom = i4;
    }

    public void setMinZoom(int i4) {
        this.minZoom = i4;
    }
}
