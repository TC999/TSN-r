package com.kwad.components.p208ad.reward;

import android.os.Looper;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.components.ad.reward.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7845b {

    /* renamed from: ol */
    private final Set<InterfaceC7892l> f26442ol;

    /* renamed from: com.kwad.components.ad.reward.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7847a {

        /* renamed from: on */
        private static final C7845b f26444on = new C7845b((byte) 0);
    }

    /* synthetic */ C7845b(byte b) {
        this();
    }

    /* renamed from: fb */
    public static C7845b m32173fb() {
        return C7847a.f26444on;
    }

    /* renamed from: fc */
    private void m32172fc() {
        if (this.f26442ol.size() == 0) {
            return;
        }
        for (InterfaceC7892l interfaceC7892l : this.f26442ol) {
            interfaceC7892l.onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: a */
    public final void m32175a(InterfaceC7892l interfaceC7892l) {
        if (interfaceC7892l != null) {
            this.f26442ol.add(interfaceC7892l);
        }
    }

    /* renamed from: b */
    public final void m32174b(InterfaceC7892l interfaceC7892l) {
        this.f26442ol.remove(interfaceC7892l);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            m32172fc();
        } else {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C7845b.this.notifyRewardVerify();
                }
            });
        }
    }

    private C7845b() {
        this.f26442ol = new HashSet();
    }
}
