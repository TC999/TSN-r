package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> og;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.reward.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0586a {
        private static final a ok = new a((byte) 0);
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    public static a eX() {
        return C0586a.ok;
    }

    private void eZ() {
        if (this.og.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.og) {
            jVar.bY();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.og.remove(jVar);
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void eY() {
        if (isMainThread()) {
            eZ();
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.eY();
                }
            });
        }
    }

    private a() {
        this.og = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.og.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.og) {
            jVar.a(playableSource, nVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.og.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.og.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.og) {
            jVar.bZ();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
