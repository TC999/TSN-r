package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    public final String nX() {
        return this.downloadId;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i4) {
    }

    public a(String str) {
        this.downloadId = str;
    }
}
