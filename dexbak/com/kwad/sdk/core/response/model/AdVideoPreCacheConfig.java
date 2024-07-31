package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdVideoPreCacheConfig extends C10482a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig(int i, boolean z) {
        this.adVideoPreCacheSize = i;
        this.continueLoadingAll = z;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setAdVideoPreCacheSize(int i) {
        this.adVideoPreCacheSize = i;
    }

    public void setContinueLoadingAll(boolean z) {
        this.continueLoadingAll = z;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }
}
