package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.sdk.utils.v;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o extends e {
    private com.kwad.sdk.core.download.a.a DT;

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.download.a.a aVar = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.c.o.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = o.this.getContext();
                if (context != null) {
                    String bR = com.kwad.sdk.utils.k.bR(context);
                    if (bR != null) {
                        str = bR + ":\u5df2\u5f00\u59cb\u4e0b\u8f7d";
                    } else {
                        str = "\u5df2\u5f00\u59cb\u4e0b\u8f7d";
                    }
                    v.O(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
            }
        };
        this.DT = aVar;
        this.Dg.mApkDownloadHelper.b(aVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.a.a aVar = this.DT;
        if (aVar != null) {
            this.Dg.mApkDownloadHelper.c(aVar);
        }
    }
}
