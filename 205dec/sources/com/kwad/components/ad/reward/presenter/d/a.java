package com.kwad.components.ad.reward.presenter.d;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    public a() {
        ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    private void ca() {
        this.qo.b(this);
        com.kwad.components.ad.reward.a.eX().a(this);
    }

    private void dZ() {
        List<Presenter> Jw = Jw();
        if (Jw == null) {
            return;
        }
        for (Presenter presenter : Jw) {
            if (presenter instanceof c) {
                ((c) presenter).iE();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        dZ();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        dZ();
    }

    protected void ch() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this);
        com.kwad.components.ad.reward.a.eX().b(this);
    }
}
