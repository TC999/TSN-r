package com.kwad.components.p208ad.reward.presenter;

import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.widget.KsToastView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8293q extends C8094b {

    /* renamed from: sC */
    private float f27362sC;

    /* renamed from: sE */
    private C8297r f27363sE;

    /* renamed from: sL */
    private KsToastView f27365sL;

    /* renamed from: sO */
    private Runnable f27368sO;

    /* renamed from: sM */
    private boolean f27366sM = false;

    /* renamed from: sN */
    private boolean f27367sN = false;

    /* renamed from: sP */
    private boolean f27369sP = false;

    /* renamed from: sF */
    private boolean f27364sF = false;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C8293q.this.f27365sL.setVisibility(8);
        }
    };

    public C8293q(C8297r c8297r) {
        this.f27363sE = c8297r;
    }

    /* renamed from: hC */
    private void m31057hC() {
        this.f27368sO = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (C8293q.this.f27369sP) {
                    return;
                }
                if (C8293q.this.f27365sL != null) {
                    C8293q.this.f27365sL.setVisibility(8);
                }
                C7838a.m32198eX().m32204a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    /* renamed from: hD */
    private void m31056hD() {
        C11064bn.m23858c(this.f27368sO);
        this.f27368sO = null;
    }

    /* renamed from: hx */
    private synchronized void m31055hx() {
        if (this.f27364sF) {
            return;
        }
        C9908c.m27309d(this.f26957qo.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(Opcodes.CHECKCAST).m27269ah(this.f26957qo.f26529oJ.getPlayDuration()));
        this.f27364sF = true;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f27365sL == null) {
            KsToastView ksToastView = (KsToastView) findViewById(C9659R.C9662id.ksad_toast_view);
            this.f27365sL = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C8293q.m31061a(C8293q.this, true);
                    C8293q.this.f27365sL.setVisibility(8);
                    C7838a.m32198eX().m32204a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.f26957qo.m32034b(this.mPlayEndPageListener);
    }

    /* renamed from: hA */
    public final void m31059hA() {
        if (this.f27367sN) {
            return;
        }
        m31055hx();
        this.f27367sN = true;
        this.f27365sL.setVisibility(0);
        this.f27365sL.m30980U(3);
        m31057hC();
        C11064bn.m23862a(this.f27368sO, null, 3000L);
    }

    /* renamed from: hB */
    public final void m31058hB() {
        this.f27367sN = false;
        this.f27365sL.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27362sC = C7844b.m32183gv();
        this.f27366sM = C7844b.m32182gw() && C7844b.m32181gx();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m31056hD();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31061a(C8293q c8293q, boolean z) {
        c8293q.f27369sP = true;
        return true;
    }
}
