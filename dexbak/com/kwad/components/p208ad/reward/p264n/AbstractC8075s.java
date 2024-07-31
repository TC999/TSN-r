package com.kwad.components.p208ad.reward.p264n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* renamed from: com.kwad.components.ad.reward.n.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8075s extends AbstractC8041d {

    /* renamed from: sz */
    protected ViewGroup f26932sz;

    /* renamed from: a */
    public final void m31644a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.f26932sz != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.f26932sz = (ViewGroup) viewStub.inflate();
        } else {
            this.f26932sz = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public ViewGroup mo31643gF() {
        return this.f26932sz;
    }
}
