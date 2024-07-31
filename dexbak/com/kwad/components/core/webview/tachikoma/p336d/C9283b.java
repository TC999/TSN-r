package com.kwad.components.core.webview.tachikoma.p336d;

import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.kwad.components.core.webview.tachikoma.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9283b {
    private final Set<AbstractC9293e> aaW;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9286a {
        private static final C9283b abc = new C9283b((byte) 0);
    }

    /* synthetic */ C9283b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m29109r(String str, String str2) {
        if (this.aaW.size() == 0) {
            return;
        }
        for (AbstractC9293e abstractC9293e : new HashSet(this.aaW)) {
            abstractC9293e.mo29101q(str2);
        }
    }

    /* renamed from: tc */
    public static C9283b m29107tc() {
        return C9286a.abc;
    }

    /* renamed from: b */
    public final void m29112b(AbstractC9293e abstractC9293e) {
        this.aaW.remove(abstractC9293e);
    }

    /* renamed from: c */
    public final void m29110c(final String str, final long j, final long j2, final long j3) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9283b.this.m29111b(str, j, j2, j3);
            }
        });
    }

    /* renamed from: s */
    public final void m29108s(final String str, final String str2) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9283b.this.m29109r(str, str2);
            }
        });
    }

    /* renamed from: td */
    public final void m29106td() {
        this.aaW.clear();
    }

    private C9283b() {
        this.aaW = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29111b(String str, long j, long j2, long j3) {
        if (this.aaW.size() == 0) {
            return;
        }
        for (AbstractC9293e abstractC9293e : new HashSet(this.aaW)) {
            abstractC9293e.mo29094a(str, j, j2, j3);
        }
    }

    /* renamed from: a */
    public final void m29113a(AbstractC9293e abstractC9293e) {
        if (abstractC9293e != null) {
            this.aaW.add(abstractC9293e);
        }
    }
}
