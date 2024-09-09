package com.kwad.components.ad.splashscreen.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bn;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {
    private static long le = 400;
    private com.kwad.components.ad.splashscreen.f.a Dt;
    private Vibrator eh;

    private void lp() {
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.f.a aVar = this.Dt;
            if (aVar == null) {
                this.Dt = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.ad.splashscreen.f.a
                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i4, String str) {
                        i.this.j(i4, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Dg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Dt);
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Dg.Cv) {
            return;
        }
        lm();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        ln();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar == null) {
            return;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(hVar.mAdTemplate);
        ll();
        lj();
        if (com.kwad.sdk.core.response.b.a.aF(dQ)) {
            lp();
        }
        lk();
        lo();
        this.Dg.Cs.a(this);
    }

    protected abstract void initView();

    protected abstract void j(int i4, String str);

    protected abstract void lj();

    protected abstract void lk();

    protected abstract void ll();

    protected abstract void lm();

    protected abstract void ln();

    protected abstract void lo();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void lq() {
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        bn.a(getContext(), this.eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Dg.Cs.b(this);
        ln();
        bn.b(getContext(), this.eh);
    }
}
