package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private View DB;
    private KsRotateView DC;
    private TextView DD;
    private TextView DE;
    private com.kwad.sdk.core.g.c DF;
    private com.kwad.components.ad.splashscreen.d DG;
    private long mStartTime;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.kwad.components.ad.splashscreen.widget.c, com.kwad.components.ad.splashscreen.widget.KsRotateView] */
    public final void V(final String str) {
        boolean ud = this.Di.Ct.ud();
        boolean nQ = com.kwad.components.core.e.c.b.nQ();
        if (!ud || nQ) {
            return;
        }
        this.DC.mu();
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            hVar.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dp(str);
                }
            });
        }
        lr();
        lo();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i4) {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.kwad.components.ad.splashscreen.presenter.l$2, java.lang.Runnable] */
    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getRootView().post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2
            public final void doTask() {
                com.kwad.components.ad.splashscreen.h hVar = l.this.Di;
                if (hVar != null) {
                    hVar.CJ = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.DB = viewStub.inflate();
        } else {
            this.DB = findViewById(R.id.ksad_rotate_root);
        }
        this.DD = (TextView) findViewById(R.id.ksad_rotate_text);
        this.DE = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.DC = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void j(int i4, String str) {
        TextView textView = this.DE;
        if (textView != null) {
            if (i4 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("\u6216\u70b9\u51fb" + str);
        }
    }

    public final void kB() {
        com.kwad.sdk.core.g.c cVar = this.DF;
        if (cVar != null) {
            cVar.bw(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void lk() {
        AdTemplate adTemplate = this.Di.mAdTemplate;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.DG = com.kwad.components.ad.splashscreen.d.a(adTemplate, dS, this.Di.mApkDownloadHelper, 1);
        TextView textView = this.DD;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dr(dS));
        }
        TextView textView2 = this.DE;
        if (textView2 != null) {
            textView2.setText("\u6216\u70b9\u51fb" + this.DG.kv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ll() {
        View view = this.DB;
        if (view == null || this.Di == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Di.mAdTemplate, 184, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.d.a.tC().aW(184);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void lm() {
        AdMatrixInfo.RotateInfo cW = com.kwad.sdk.core.response.b.b.cW(this.Di.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.DF;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(cW);
            this.DF = cVar2;
            cVar2.a(this);
            return;
        }
        cVar.a(cW);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ln() {
        com.kwad.sdk.core.g.c cVar = this.DF;
        if (cVar != null) {
            cVar.bv(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void lo() {
        com.kwad.sdk.core.g.c cVar = this.DF;
        if (cVar != null) {
            cVar.bw(getContext());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Runnable, com.kwad.components.ad.splashscreen.presenter.l$1] */
    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void lp() {
        this.DC.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.l.1
            /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.components.ad.splashscreen.widget.c, com.kwad.components.ad.splashscreen.widget.KsRotateView] */
            public final void doTask() {
                l.this.DC.lp();
            }
        });
    }

    public final void ls() {
        com.kwad.sdk.core.adlog.c.bP(this.Di.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Di.c(1, getContext(), 162, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashRotatePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}
