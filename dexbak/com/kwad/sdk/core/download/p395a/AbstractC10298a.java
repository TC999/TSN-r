package com.kwad.sdk.core.download.p395a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* renamed from: com.kwad.sdk.core.download.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10298a implements KsAppDownloadListener {
    public String downloadId;

    public AbstractC10298a() {
    }

    /* renamed from: nX */
    public final String m26368nX() {
        return this.downloadId;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public AbstractC10298a(String str) {
        this.downloadId = str;
    }
}
