package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class s extends d {
    protected ViewGroup sz;

    public final void a(ViewGroup viewGroup, @IdRes int i4, @IdRes int i5) {
        if (this.sz != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i4);
        if (viewStub != null) {
            this.sz = (ViewGroup) viewStub.inflate();
        } else {
            this.sz = (ViewGroup) viewGroup.findViewById(i5);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup gF() {
        return this.sz;
    }
}
