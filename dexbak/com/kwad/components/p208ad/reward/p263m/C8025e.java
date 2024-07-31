package com.kwad.components.p208ad.reward.p263m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.p246j.AbstractC7812a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p253f.C7897a;
import com.kwad.sdk.utils.C11096h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.reward.m.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8025e {

    /* renamed from: qo */
    private C7907g f26746qo;
    @Nullable

    /* renamed from: xT */
    private C7897a f26748xT;
    @Nullable

    /* renamed from: xU */
    private C8021d f26749xU;
    @Nullable

    /* renamed from: xV */
    private C8019b f26750xV;
    @NonNull

    /* renamed from: xW */
    private AbstractC7812a f26751xW;

    /* renamed from: xS */
    private int f26747xS = 0;

    /* renamed from: xX */
    private int f26752xX = 0;

    /* renamed from: xY */
    private List<C9002l> f26753xY = new CopyOnWriteArrayList();

    public C8025e(C7907g c7907g) {
        this.f26746qo = c7907g;
        this.f26751xW = new C8018a(c7907g.mAdTemplate);
    }

    /* renamed from: jL */
    private AbstractC7812a m31822jL() {
        return this.f26751xW;
    }

    /* renamed from: a */
    public final void m31829a(int i, AbstractC7812a abstractC7812a) {
        this.f26747xS = i;
        if (i == 1) {
            this.f26749xU = (C8021d) abstractC7812a;
        } else if (i == 2) {
            this.f26748xT = (C7897a) abstractC7812a;
        } else if (i == 3) {
            this.f26750xV = (C8019b) abstractC7812a;
        }
        this.f26751xW = abstractC7812a;
        for (C9002l c9002l : this.f26753xY) {
            this.f26751xW.mo31843b(c9002l);
        }
        this.f26753xY.clear();
    }

    /* renamed from: b */
    public final void m31826b(@Nullable C9002l c9002l) {
        m31822jL().mo31844a(c9002l);
        if (c9002l != null) {
            this.f26753xY.remove(c9002l);
        }
    }

    public final long getPlayDuration() {
        return m31822jL().getPlayDuration();
    }

    /* renamed from: jI */
    public final void m31824jI() {
        C8021d c8021d = this.f26749xU;
        if (c8021d != null) {
            c8021d.m31832jI();
        } else {
            C8019b c8019b = this.f26750xV;
            if (c8019b != null) {
                c8019b.m31842jI();
            }
        }
        this.f26746qo.m31994fy();
    }

    /* renamed from: jJ */
    public final void m31823jJ() {
        C8021d c8021d = this.f26749xU;
        if (c8021d != null) {
            c8021d.m31831jJ();
        }
    }

    /* renamed from: jM */
    public final boolean m31821jM() {
        return this.f26748xT != null;
    }

    @Nullable
    /* renamed from: jN */
    public final C7897a m31820jN() {
        return this.f26748xT;
    }

    @Nullable
    /* renamed from: jO */
    public final C8019b m31819jO() {
        return this.f26750xV;
    }

    public final void pause() {
        m31822jL().pause();
    }

    public final void release() {
        m31822jL().release();
    }

    public final void resume() {
        int i;
        m31822jL().resume();
        C7897a c7897a = this.f26748xT;
        if (c7897a == null || (i = this.f26752xX) <= 0) {
            return;
        }
        c7897a.setAudioEnabled(i == 2, false);
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f26752xX = z ? 2 : 1;
        m31822jL().setAudioEnabled(z, z2);
    }

    public final void skipToEnd() {
        m31822jL().skipToEnd();
    }

    /* renamed from: b */
    public final void m31825b(C11096h.InterfaceC11099a interfaceC11099a) {
        C8021d c8021d = this.f26749xU;
        if (c8021d != null) {
            c8021d.m31836b(interfaceC11099a);
        }
    }

    /* renamed from: a */
    public final void m31828a(@Nullable C9002l c9002l) {
        if (m31822jL().mo31846jH()) {
            this.f26753xY.add(c9002l);
        } else {
            m31822jL().mo31843b(c9002l);
        }
    }

    /* renamed from: a */
    public final void m31827a(C11096h.InterfaceC11099a interfaceC11099a) {
        C8021d c8021d = this.f26749xU;
        if (c8021d != null) {
            c8021d.m31839a(interfaceC11099a);
        }
    }
}
