package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class b implements com.kwad.sdk.widget.c {
    private a Dy;
    private ViewStub FL;
    private ViewGroup FM;
    private View FN;
    private TextView FO;
    private boolean FP;
    @Nullable
    private e FQ;
    private f FR;
    @NonNull
    private ViewGroup gS;
    @Nullable
    private AdInfo mAdInfo;
    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z3, com.kwad.components.core.e.d.c cVar) {
        this.gS = viewGroup;
        this.FL = viewStub;
        this.mApkDownloadHelper = cVar;
        this.FP = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        TextView textView = this.FO;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.FN = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.FO = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.FR = new f(this.FN.getContext(), this.FN, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void i(boolean z3, boolean z4) {
        e eVar = this.FQ;
        if (eVar != null) {
            eVar.h(z3, z4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.kwad.sdk.api.KsAppDownloadListener, com.kwad.components.ad.splashscreen.e.a] */
    public final void ai(AdTemplate adTemplate) {
        ?? r02;
        this.mAdTemplate = adTemplate;
        a aVar = this.Dy;
        if (aVar == null) {
            this.Dy = new a(this.gS.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                {
                    super(r3);
                }

                protected final void k(int i4, String str) {
                    b.this.W(str);
                }
            };
        } else {
            aVar.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == 0 || (r02 = this.Dy) == 0) {
            return;
        }
        cVar.b(r02);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (this.FP) {
            i(false, view.equals(this.FN));
        }
    }

    public final void lx() {
        com.kwad.sdk.core.e.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.FL);
        if (this.FM == null) {
            ViewStub viewStub = this.FL;
            if (viewStub != null && viewStub.getParent() != null) {
                this.FM = (ViewGroup) this.FL.inflate();
            } else {
                this.FM = (ViewGroup) this.gS.findViewById(R.id.ksad_splash_actionbar_native_root);
            }
            g(this.FM);
        }
        ViewGroup viewGroup = this.FM;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.kwad.sdk.api.KsAppDownloadListener, com.kwad.components.ad.splashscreen.e.a] */
    public final void onUnbind() {
        ?? r12;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == 0 || (r12 = this.Dy) == 0) {
            return;
        }
        cVar.c((KsAppDownloadListener) r12);
    }

    public final void a(@Nullable e eVar) {
        this.FQ = eVar;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        W(dVar.kv());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        i(true, view.equals(this.FN));
    }
}
