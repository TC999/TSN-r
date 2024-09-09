package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {
    private static long le = 400;
    private com.kwad.components.ad.splashscreen.e.a Dy;
    private Vibrator eh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.kwad.sdk.api.KsAppDownloadListener, com.kwad.components.ad.splashscreen.e.a] */
    private void lq() {
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Dy;
            if (aVar == null) {
                this.Dy = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Di.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(r3);
                    }

                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i4, String str) {
                        i.this.j(i4, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Di.mApkDownloadHelper;
            if (cVar != 0) {
                cVar.b(this.Dy);
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Di.Cw) {
            return;
        }
        ln();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        lo();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar == null) {
            return;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(hVar.mAdTemplate);
        lm();
        lk();
        if (com.kwad.sdk.core.response.b.a.aE(dS)) {
            lq();
        }
        ll();
        lp();
        this.Di.Ct.a(this);
    }

    protected abstract void initView();

    protected abstract void j(int i4, String str);

    protected abstract void lk();

    protected abstract void ll();

    protected abstract void lm();

    protected abstract void ln();

    protected abstract void lo();

    protected abstract void lp();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void lr() {
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        bo.a(getContext(), this.eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Di.Ct.b(this);
        lo();
        bo.b(getContext(), this.eh);
    }
}
