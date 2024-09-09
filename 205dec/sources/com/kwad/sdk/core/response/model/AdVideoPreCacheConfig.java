package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig(int i4, boolean z3) {
        this.adVideoPreCacheSize = i4;
        this.continueLoadingAll = z3;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setAdVideoPreCacheSize(int i4) {
        this.adVideoPreCacheSize = i4;
    }

    public void setContinueLoadingAll(boolean z3) {
        this.continueLoadingAll = z3;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }
}
