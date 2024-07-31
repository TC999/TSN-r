package com.kwad.components.p208ad.reward.presenter.p272f;

import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9180v;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7958a;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p434g.InterfaceC10761a;

/* renamed from: com.kwad.components.ad.reward.presenter.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8149a extends AbstractDialogInterface$OnDismissListenerC8159d {

    /* renamed from: wd */
    private C9216o f27058wd;

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d
    /* renamed from: iM */
    protected final boolean mo31374iM() {
        return true;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
        this.f27058wd = c9216o;
        c9216o.m29180a(new C9216o.InterfaceC9217a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9216o.InterfaceC9217a
            public final boolean isMuted() {
                return !AbstractC8149a.this.f26957qo.mVideoPlayConfig.isVideoSoundEnable() || (!C10251d.m26517gs() && C8932a.m29575ah(AbstractC8149a.this.getContext()).m29573qW());
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C10751a.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C10751a.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(new C9180v() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: a */
            public final void mo29216a(C9263x c9263x) {
                super.mo29216a(c9263x);
                AbstractC8149a.this.f26957qo.f26528oI.onVideoPlayStart();
                C8032c.m31757b(AbstractC8149a.this.f26957qo.f26544oY, AbstractC8149a.this.f26957qo.mAdTemplate, AbstractC8149a.this.f26957qo.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: b */
            public final void mo29215b(C9263x c9263x) {
                super.mo29215b(c9263x);
                long m29162sU = c9263x.m29162sU();
                AbstractC8149a.this.f26957qo.f26528oI.onVideoPlayError(c9263x.errorCode, (int) m29162sU);
                C8032c.m31767a(AbstractC8149a.this.f26957qo.f26544oY, AbstractC8149a.this.f26957qo.mAdTemplate, AbstractC8149a.this.f26957qo.f26573pv, c9263x.errorCode, m29162sU);
                C8031b.m31778c(AbstractC8149a.this.f26957qo.f26544oY, AbstractC8149a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: c */
            public final void mo29214c(C9263x c9263x) {
                super.mo29214c(c9263x);
                AbstractC8149a.this.f26957qo.f26528oI.onVideoPlayEnd();
                AbstractC8149a.this.f26957qo.mAdTemplate.setmCurPlayTime(-1L);
                C8141f.m31459s(AbstractC8149a.this.f26957qo);
                if (c9263x.m29164sS()) {
                    C7907g unused = AbstractC8149a.this.f26957qo;
                    C7907g.m32038a(AbstractC8149a.this.f26957qo.f26537oR, new InterfaceC10761a<InterfaceC7958a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.p434g.InterfaceC10761a
                        /* renamed from: c */
                        public void accept(InterfaceC7958a interfaceC7958a) {
                            C7907g unused2 = AbstractC8149a.this.f26957qo;
                            interfaceC7958a.mo31477iK();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: d */
            public final void mo29213d(C9263x c9263x) {
                super.mo29213d(c9263x);
                AbstractC8149a.this.f26957qo.mAdTemplate.setmCurPlayTime(c9263x.f29320nE);
            }
        });
    }
}
