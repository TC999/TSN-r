package com.kwad.components.p208ad.p246j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.video.C8978b;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.ad.j.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7813b extends AbstractC7812a<InterfaceC9001k> {

    /* renamed from: Hs */
    public C8978b f26355Hs;

    /* renamed from: Ht */
    private boolean f26356Ht;

    /* renamed from: Hu */
    private InterfaceC9001k f26357Hu;
    protected DetailVideoView mDetailVideoView;

    public C7813b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.f26356Ht = false;
        this.f26357Hu = new C9002l() { // from class: com.kwad.components.ad.j.b.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C7813b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!C7813b.this.f26356Ht) {
                        C7813b.this.m32255mg();
                    } else if (C10251d.m26531Cx()) {
                        C7813b.this.m32255mg();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                C7813b.this.mAdTemplate.setmCurPlayTime(j2);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.f26355Hs = new C8978b(this.mDetailVideoView, adTemplate);
        m32257me();
    }

    /* renamed from: me */
    private void m32257me() {
        this.f26355Hs.m29464c(this.f26357Hu);
    }

    /* renamed from: mf */
    private void m32256mf() {
        InterfaceC9001k interfaceC9001k;
        C8978b c8978b = this.f26355Hs;
        if (c8978b == null || (interfaceC9001k = this.f26357Hu) == null) {
            return;
        }
        c8978b.m29461d(interfaceC9001k);
        this.f26357Hu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mg */
    public void m32255mg() {
        C8766a.m29888qi().m29895f(this.mAdTemplate, 21008);
        this.f26356Ht = true;
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public long getPlayDuration() {
        C8978b c8978b = this.f26355Hs;
        if (c8978b != null) {
            return c8978b.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public void pause() {
        this.f26355Hs.pause();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    @WorkerThread
    public void release() {
        super.release();
        this.f26356Ht = false;
        m32256mf();
        C8978b c8978b = this.f26355Hs;
        if (c8978b != null) {
            c8978b.clear();
            this.f26355Hs.release();
        }
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public void resume() {
        this.f26355Hs.resume();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    @MainThread
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void mo31843b(InterfaceC9001k interfaceC9001k) {
        C8978b c8978b;
        if (interfaceC9001k == null || (c8978b = this.f26355Hs) == null) {
            return;
        }
        c8978b.m29464c(interfaceC9001k);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    @MainThread
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final void mo31844a(InterfaceC9001k interfaceC9001k) {
        if (interfaceC9001k == null) {
            return;
        }
        this.f26355Hs.m29461d(interfaceC9001k);
    }
}
