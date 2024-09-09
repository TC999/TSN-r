package com.kwad.components.ad.j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends a<k> {
    public com.kwad.components.core.video.b Hs;
    private boolean Ht;
    private k Hu;
    protected DetailVideoView mDetailVideoView;

    public b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.Ht = false;
        this.Hu = new l() { // from class: com.kwad.components.ad.j.b.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i4, int i5) {
                try {
                    super.onMediaPlayError(i4, i5);
                    if (!b.this.Ht) {
                        b.this.mg();
                    } else if (d.Cx()) {
                        b.this.mg();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j4, long j5) {
                b.this.mAdTemplate.setmCurPlayTime(j5);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.Hs = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        me();
    }

    private void me() {
        this.Hs.c(this.Hu);
    }

    private void mf() {
        k kVar;
        com.kwad.components.core.video.b bVar = this.Hs;
        if (bVar == null || (kVar = this.Hu) == null) {
            return;
        }
        bVar.d(kVar);
        this.Hu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg() {
        com.kwad.components.core.o.a.qi().f(this.mAdTemplate, 21008);
        this.Ht = true;
    }

    @Override // com.kwad.components.ad.j.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.Hs;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.j.a
    public void pause() {
        this.Hs.pause();
    }

    @Override // com.kwad.components.ad.j.a
    @WorkerThread
    public void release() {
        super.release();
        this.Ht = false;
        mf();
        com.kwad.components.core.video.b bVar = this.Hs;
        if (bVar != null) {
            bVar.clear();
            this.Hs.release();
        }
    }

    @Override // com.kwad.components.ad.j.a
    public void resume() {
        this.Hs.resume();
    }

    @Override // com.kwad.components.ad.j.a
    @MainThread
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void b(k kVar) {
        com.kwad.components.core.video.b bVar;
        if (kVar == null || (bVar = this.Hs) == null) {
            return;
        }
        bVar.c(kVar);
    }

    @Override // com.kwad.components.ad.j.a
    @MainThread
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hs.d(kVar);
    }
}
