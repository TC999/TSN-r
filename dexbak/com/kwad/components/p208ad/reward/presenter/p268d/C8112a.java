package com.kwad.components.p208ad.reward.presenter.p268d;

import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.p268d.p270b.InterfaceC8132c;
import com.kwad.components.p208ad.reward.presenter.p268d.p270b.View$OnClickListenerC8128a;
import com.kwad.components.p208ad.reward.presenter.p268d.p270b.View$OnClickListenerC8130b;
import com.kwad.components.p208ad.reward.presenter.p268d.p270b.View$OnClickListenerC8133d;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.presenter.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8112a extends C8094b implements InterfaceC7886g, InterfaceC7890j {
    public C8112a() {
        mo31547ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }

    /* renamed from: ca */
    private void m31548ca() {
        this.f26957qo.m32034b(this);
        C7838a.m32198eX().m32205a(this);
    }

    /* renamed from: dZ */
    private void m31546dZ() {
        List<Presenter> m24614Jw = m24614Jw();
        if (m24614Jw == null) {
            return;
        }
        for (Presenter presenter : m24614Jw) {
            if (presenter instanceof InterfaceC8132c) {
                ((InterfaceC8132c) presenter).mo31491iE();
            }
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m31548ca();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    /* renamed from: bL */
    public final void mo31009bL() {
        m31546dZ();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
        m31546dZ();
    }

    /* renamed from: ch */
    protected void mo31547ch() {
        m24612a(new View$OnClickListenerC8133d());
        m24612a(new View$OnClickListenerC8128a());
        m24612a(new View$OnClickListenerC8130b());
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this);
        C7838a.m32198eX().m32203b(this);
    }
}
