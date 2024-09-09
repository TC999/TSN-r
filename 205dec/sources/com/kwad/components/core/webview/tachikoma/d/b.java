package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private final Set<e> aaW;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final b abc = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        if (this.aaW.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.aaW)) {
            eVar.q(str2);
        }
    }

    public static b tc() {
        return a.abc;
    }

    public final void b(e eVar) {
        this.aaW.remove(eVar);
    }

    public final void c(final String str, final long j4, final long j5, final long j6) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.b(str, j4, j5, j6);
            }
        });
    }

    public final void s(final String str, final String str2) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.r(str, str2);
            }
        });
    }

    public final void td() {
        this.aaW.clear();
    }

    private b() {
        this.aaW = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j4, long j5, long j6) {
        if (this.aaW.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.aaW)) {
            eVar.a(str, j4, j5, j6);
        }
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.aaW.add(eVar);
        }
    }
}
