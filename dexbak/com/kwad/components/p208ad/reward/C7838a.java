package com.kwad.components.p208ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.components.ad.reward.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7838a {

    /* renamed from: og */
    private final Set<InterfaceC7890j> f26416og;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7842a {

        /* renamed from: ok */
        private static final C7838a f26423ok = new C7838a((byte) 0);
    }

    /* synthetic */ C7838a(byte b) {
        this();
    }

    /* renamed from: eX */
    public static C7838a m32198eX() {
        return C7842a.f26423ok;
    }

    /* renamed from: eZ */
    private void m32196eZ() {
        if (this.f26416og.size() == 0) {
            return;
        }
        for (InterfaceC7890j interfaceC7890j : this.f26416og) {
            interfaceC7890j.mo31048bY();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: b */
    public final void m32203b(InterfaceC7890j interfaceC7890j) {
        this.f26416og.remove(interfaceC7890j);
    }

    /* renamed from: c */
    public final void m32199c(final PlayableSource playableSource, @Nullable final InterfaceC7894n interfaceC7894n) {
        if (isMainThread()) {
            m32201b(playableSource, interfaceC7894n);
        } else {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7838a.this.m32201b(playableSource, interfaceC7894n);
                }
            });
        }
    }

    /* renamed from: eY */
    public final void m32197eY() {
        if (isMainThread()) {
            m32196eZ();
        } else {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7838a.this.m32197eY();
                }
            });
        }
    }

    private C7838a() {
        this.f26416og = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m32201b(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
        if (this.f26416og.size() == 0) {
            return;
        }
        for (InterfaceC7890j interfaceC7890j : this.f26416og) {
            interfaceC7890j.mo31050a(playableSource, interfaceC7894n);
        }
    }

    /* renamed from: a */
    public final void m32205a(InterfaceC7890j interfaceC7890j) {
        if (interfaceC7890j != null) {
            this.f26416og.add(interfaceC7890j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m32200c(PlayableSource playableSource) {
        if (this.f26416og.size() == 0) {
            return;
        }
        for (InterfaceC7890j interfaceC7890j : this.f26416og) {
            interfaceC7890j.mo31047bZ();
        }
    }

    /* renamed from: a */
    public final void m32204a(PlayableSource playableSource) {
        m32199c(playableSource, null);
    }

    /* renamed from: b */
    public final void m32202b(final PlayableSource playableSource) {
        if (isMainThread()) {
            m32200c(playableSource);
        } else {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7838a.this.m32200c(playableSource);
                }
            });
        }
    }
}
