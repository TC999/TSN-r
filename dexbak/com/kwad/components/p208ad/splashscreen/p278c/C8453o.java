package com.kwad.components.p208ad.splashscreen.p278c;

import android.content.Context;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.C11128v;

/* renamed from: com.kwad.components.ad.splashscreen.c.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8453o extends C8421e {

    /* renamed from: DT */
    private AbstractC10298a f27797DT;

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AbstractC10298a abstractC10298a = new AbstractC10298a() { // from class: com.kwad.components.ad.splashscreen.c.o.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = C8453o.this.getContext();
                if (context != null) {
                    String m23779bR = C11102k.m23779bR(context);
                    if (m23779bR != null) {
                        str = m23779bR + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    C11128v.m23672O(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }
        };
        this.f27797DT = abstractC10298a;
        this.f27734Dg.mApkDownloadHelper.m30151b(abstractC10298a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        AbstractC10298a abstractC10298a = this.f27797DT;
        if (abstractC10298a != null) {
            this.f27734Dg.mApkDownloadHelper.m30148c(abstractC10298a);
        }
    }
}
