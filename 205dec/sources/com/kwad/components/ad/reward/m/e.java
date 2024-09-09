package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private g qo;
    @Nullable
    private com.kwad.components.ad.reward.f.a xT;
    @Nullable
    private d xU;
    @Nullable
    private b xV;
    @NonNull
    private com.kwad.components.ad.j.a xW;
    private int xS = 0;
    private int xX = 0;
    private List<l> xY = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.qo = gVar;
        this.xW = new a(gVar.mAdTemplate);
    }

    private com.kwad.components.ad.j.a jL() {
        return this.xW;
    }

    public final void a(int i4, com.kwad.components.ad.j.a aVar) {
        this.xS = i4;
        if (i4 == 1) {
            this.xU = (d) aVar;
        } else if (i4 == 2) {
            this.xT = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i4 == 3) {
            this.xV = (b) aVar;
        }
        this.xW = aVar;
        for (l lVar : this.xY) {
            this.xW.b(lVar);
        }
        this.xY.clear();
    }

    public final void b(@Nullable l lVar) {
        jL().a(lVar);
        if (lVar != null) {
            this.xY.remove(lVar);
        }
    }

    public final long getPlayDuration() {
        return jL().getPlayDuration();
    }

    public final void jI() {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.jI();
        } else {
            b bVar = this.xV;
            if (bVar != null) {
                bVar.jI();
            }
        }
        this.qo.fy();
    }

    public final void jJ() {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.jJ();
        }
    }

    public final boolean jM() {
        return this.xT != null;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a jN() {
        return this.xT;
    }

    @Nullable
    public final b jO() {
        return this.xV;
    }

    public final void pause() {
        jL().pause();
    }

    public final void release() {
        jL().release();
    }

    public final void resume() {
        int i4;
        jL().resume();
        com.kwad.components.ad.reward.f.a aVar = this.xT;
        if (aVar == null || (i4 = this.xX) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i4 == 2, false);
    }

    public final void setAudioEnabled(boolean z3, boolean z4) {
        this.xX = z3 ? 2 : 1;
        jL().setAudioEnabled(z3, z4);
    }

    public final void skipToEnd() {
        jL().skipToEnd();
    }

    public final void b(h.a aVar) {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void a(@Nullable l lVar) {
        if (jL().jH()) {
            this.xY.add(lVar);
        } else {
            jL().b(lVar);
        }
    }

    public final void a(h.a aVar) {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }
}
