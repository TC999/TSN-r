package com.kwad.components.p208ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.widget.tailframe.appbar.AbstractC8522a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.widget.tailframe.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8345a implements InterfaceC11145c {

    /* renamed from: BC */
    protected View f27578BC;

    /* renamed from: BD */
    protected ImageView f27579BD;

    /* renamed from: BE */
    private AbstractC8522a f27580BE;

    /* renamed from: BF */
    private TailFrameBarH5View f27581BF;

    /* renamed from: BG */
    private InterfaceC8348b f27582BG;

    /* renamed from: BH */
    private TextProgressBar f27583BH;

    /* renamed from: BI */
    private View f27584BI;

    /* renamed from: BJ */
    private int f27585BJ;

    /* renamed from: dM */
    private TextView f27586dM;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;

    /* renamed from: qo */
    private C7907g f27587qo;

    public AbstractC8345a(int i) {
        this.f27585BJ = i;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new C8619c(this.mAdTemplate, this.mReportExtData, new AbstractC10298a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25957aE(AbstractC8345a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25882bY(AbstractC8345a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25957aE(AbstractC8345a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25933ac(AbstractC8345a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25794dn(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                AbstractC8345a.this.f27580BE.m30423D(AbstractC8345a.this.mAdInfo);
                AbstractC8345a.this.f27583BH.m29709e(C10483a.m25795dm(i), i);
            }
        });
    }

    /* renamed from: ki */
    private void m30920ki() {
        this.f27578BC.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    /* renamed from: kk */
    private void m30918kk() {
        if (!C10483a.m25956aF(this.mAdInfo) && !C10487e.m25654F(this.mAdTemplate)) {
            this.f27581BF.m30939b(this.mAdTemplate);
            TextView h5OpenBtn = this.f27581BF.getH5OpenBtn();
            this.f27586dM = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.f27581BF.setVisibility(0);
            new GestureDetector$OnGestureListenerC11148f(this.f27586dM, this);
            return;
        }
        this.f27580BE.mo30422b(this.mAdTemplate);
        this.f27580BE.setVisibility(0);
        this.f27583BH = this.f27580BE.getTextProgressBar();
        if (!C10487e.m25654F(this.mAdTemplate)) {
            this.f27583BH.setClickable(true);
            new GestureDetector$OnGestureListenerC11148f(this.f27583BH, this);
            bindDownloadListener();
            return;
        }
        View btnInstallContainer = this.f27580BE.getBtnInstallContainer();
        this.f27584BI = btnInstallContainer;
        btnInstallContainer.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f27584BI, this);
    }

    /* renamed from: B */
    public void mo30928B(Context context) {
        View m24563a = C10887l.m24563a(context, this.f27585BJ, null, false);
        this.f27578BC = m24563a;
        this.f27579BD = (ImageView) m24563a.findViewById(C9659R.C9662id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_tf_logo);
        this.f27580BE = (AbstractC8522a) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_app_tail_frame);
        this.f27581BF = (TailFrameBarH5View) this.f27578BC.findViewById(C9659R.C9662id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        AbstractC8522a abstractC8522a = this.f27580BE;
        if (abstractC8522a != null) {
            abstractC8522a.m30421km();
            this.f27580BE.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.f27581BF;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.m30935km();
            this.f27581BF.setVisibility(8);
        }
        m30920ki();
    }

    /* renamed from: f */
    public final void m30922f(boolean z, boolean z2) {
        this.f27581BF.m30937g(z, z2);
    }

    /* renamed from: jQ */
    public final void m30921jQ() {
        AbstractC8522a abstractC8522a = this.f27580BE;
        if (abstractC8522a != null) {
            abstractC8522a.m30421km();
        }
        TailFrameBarH5View tailFrameBarH5View = this.f27581BF;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.m30935km();
        }
    }

    /* renamed from: kj */
    public final View m30919kj() {
        return this.f27578BC;
    }

    public final void setCallerContext(C7907g c7907g) {
        this.f27587qo = c7907g;
    }

    /* renamed from: a */
    public void mo30926a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, InterfaceC8348b interfaceC8348b) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.mReportExtData = jSONObject;
        this.f27582BG = interfaceC8348b;
        this.mLogoView.m28912aD(this.mAdTemplate);
        m30918kk();
        this.f27578BC.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f27578BC, this);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m30925b(view, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m30925b(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.p409b.C10487e.m25654F(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.f27587qo
            android.view.View r3 = r5.f27578BC
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.f27584BI
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.m32060a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.p409b.C10483a.m25956aF(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.f27583BH
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.f27586dM
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.m30198aq(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.m30189b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.m30207am(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.m30209al(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.f27583BH
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.m30202ao(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.m30205an(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.m30216a(r0)
            com.kwad.components.core.p289e.p293d.C8615a.m30233a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.reward.widget.tailframe.AbstractC8345a.m30925b(android.view.View, boolean):void");
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30925b(view, true);
    }
}
