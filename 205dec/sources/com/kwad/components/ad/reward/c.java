package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> oo;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final c or = new c((byte) 0);
    }

    /* synthetic */ c(byte b4) {
        this();
    }

    public static c fe() {
        return a.or;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.oo.remove(mVar);
    }

    public final void c(@Nullable final q qVar) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                c.this.b(qVar);
            }
        });
    }

    private c() {
        this.oo = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable q qVar) {
        if (this.oo.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.m mVar : this.oo) {
            mVar.a(qVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.oo.add(mVar);
        }
    }
}
