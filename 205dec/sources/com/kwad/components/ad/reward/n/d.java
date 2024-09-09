package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d {
    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab(boolean z3) {
    }

    public final void b(@NonNull r rVar) {
        a(rVar);
        gF().getContext();
        ab(ai.LZ());
    }

    public abstract ViewGroup gF();

    public void onUnbind() {
    }
}
