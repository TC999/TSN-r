package com.kwad.components.ad.interstitial.e;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends Presenter {
    public c jK;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.jK = (c) Jx();
    }

    public void cP() {
        List<Presenter> Jw = Jw();
        if (Jw == null) {
            return;
        }
        for (Presenter presenter : Jw) {
            if (presenter instanceof b) {
                ((b) presenter).cP();
            }
        }
    }

    public void cQ() {
        List<Presenter> Jw = Jw();
        if (Jw == null) {
            return;
        }
        for (Presenter presenter : Jw) {
            if (presenter instanceof b) {
                ((b) presenter).cQ();
            }
        }
    }
}
