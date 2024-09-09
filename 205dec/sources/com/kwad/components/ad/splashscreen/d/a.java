package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.splashscreen.a.a {

    /* renamed from: com.kwad.components.ad.splashscreen.d.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 implements OfflineOnAudioConflictListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            synchronized (a.a(a.this)) {
                for (h.a aVar : a.a(a.this)) {
                    aVar.onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.a(a.this)) {
                for (h.a aVar : a.a(a.this)) {
                    aVar.onAudioBeReleased();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.d.a$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass2 implements c.e {
        final /* synthetic */ DetailVideoView FJ;

        AnonymousClass2(DetailVideoView detailVideoView) {
            this.FJ = detailVideoView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.components.ad.splashscreen.d.a$2$1, java.lang.Runnable] */
        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(c cVar) {
            com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared");
            this.FJ.post(new az() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                public final void doTask() {
                    boolean a4 = br.a(AnonymousClass2.this.FJ, 50, true);
                    com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared" + a4);
                    if (a4) {
                        a.b(a.this).start();
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.a.a
    public final KsFragment a(AdResultData adResultData, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return b.b(adResultData, bVar, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.splashscreen.a.a.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }
}
