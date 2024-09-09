package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapAppRequestParam {
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
    @JBindingExclude
    private ResourceCallback callback;
    private String url;
    private int resourceType = 0;
    private long contextId = 0;
    private int expectWidth = 0;
    private int expectHeight = 0;

    @JBindingInclude
    public void generateCallback(long j4) {
        this.callback = new ResourceCallback(j4);
    }

    @JBindingExclude
    public ResourceCallback getCallback() {
        return this.callback;
    }

    @JBindingExclude
    public long getContextId() {
        return this.contextId;
    }

    @JBindingExclude
    public int getExpectHeight() {
        return this.expectHeight;
    }

    @JBindingExclude
    public int getExpectWidth() {
        return this.expectWidth;
    }

    @JBindingExclude
    public int getResourceType() {
        return this.resourceType;
    }

    @JBindingExclude
    public String getUrl() {
        return this.url;
    }

    @JBindingExclude
    public void setCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }

    @JBindingExclude
    public void setContextId(long j4) {
        this.contextId = j4;
    }

    @JBindingExclude
    public void setExpectHeight(int i4) {
        this.expectHeight = i4;
    }

    @JBindingExclude
    public void setExpectWidth(int i4) {
        this.expectWidth = i4;
    }

    @JBindingExclude
    public void setResourceType(int i4) {
        this.resourceType = i4;
    }

    @JBindingExclude
    public void setUrl(String str) {
        this.url = str;
    }
}
