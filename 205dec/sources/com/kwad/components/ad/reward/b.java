package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> ol;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final b on = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    public static b fb() {
        return a.on;
    }

    private void fc() {
        if (this.ol.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.l lVar : this.ol) {
            lVar.onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.ol.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.ol.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fc();
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.ol = new HashSet();
    }
}
