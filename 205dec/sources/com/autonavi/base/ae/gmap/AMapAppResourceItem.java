package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapAppResourceItem {
    @JBindingExclude
    public static final int RESOURCE_TYPE_ABSPATH = 4;
    @JBindingExclude
    public static final int RESOURCE_TYPE_BINARY = 3;
    @JBindingExclude
    public static final int RESOURCE_TYPE_IMAGE = 1;
    @JBindingExclude
    public static final int RESOURCE_TYPE_NONE = 0;
    @JBindingExclude
    public static final int RESOURCE_TYPE_SVG = 2;
    private byte[] data;
    private long size;
    private int resourceType = 0;
    private boolean preAlpha = false;
    private int imageWidth = 0;
    private int imageHeight = 0;
    private float imageScale = 1.0f;

    @JBindingExclude
    public byte[] getData() {
        return this.data;
    }

    @JBindingExclude
    public int getImageHeight() {
        return this.imageHeight;
    }

    @JBindingExclude
    public float getImageScale() {
        return this.imageScale;
    }

    @JBindingExclude
    public int getImageWidth() {
        return this.imageWidth;
    }

    @JBindingExclude
    public int getResourceType() {
        return this.resourceType;
    }

    @JBindingExclude
    public long getSize() {
        return this.size;
    }

    @JBindingExclude
    public boolean isPreAlpha() {
        return this.preAlpha;
    }

    @JBindingExclude
    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    @JBindingExclude
    public void setImageHeight(int i4) {
        this.imageHeight = i4;
    }

    @JBindingExclude
    public void setImageScale(float f4) {
        this.imageScale = f4;
    }

    @JBindingExclude
    public void setImageWidth(int i4) {
        this.imageWidth = i4;
    }

    @JBindingExclude
    public void setPreAlpha(boolean z3) {
        this.preAlpha = z3;
    }

    @JBindingExclude
    public void setResourceType(int i4) {
        this.resourceType = i4;
    }

    @JBindingExclude
    public void setSize(long j4) {
        this.size = j4;
    }
}
