package com.kwad.components.p208ad.interstitial.p242e;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.video.C8994f;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.e.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7783f extends C7760b implements InterfaceC11145c {

    /* renamed from: cB */
    private List<Integer> f26272cB;
    @NonNull

    /* renamed from: dU */
    private KsAdVideoPlayConfig f26273dU;

    /* renamed from: eM */
    private ImageView f26274eM;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f26275eN;

    /* renamed from: jK */
    private C7761c f26277jK;

    /* renamed from: kK */
    private KSFrameLayout f26278kK;

    /* renamed from: kL */
    private KSFrameLayout f26279kL;

    /* renamed from: kM */
    private C8994f f26280kM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    @NonNull
    protected Context mContext;
    @Nullable
    private boolean mIsAudioEnable = false;

    /* renamed from: eS */
    private final View$OnClickListenerC8966a.InterfaceC8968a f26276eS = new View$OnClickListenerC8966a.InterfaceC8968a() { // from class: com.kwad.components.ad.interstitial.e.f.3
        /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8968a
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void mo28932a(int r11, com.kwad.sdk.utils.C11008ac.C11009a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L15
                if (r11 == r0) goto L12
                r3 = 3
                if (r11 == r3) goto Ld
                r11 = 108(0x6c, float:1.51E-43)
                goto L17
            Ld:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L18
            L12:
                r11 = 82
                goto L17
            L15:
                r11 = 13
            L17:
                r3 = 2
            L18:
                com.kwad.components.ad.interstitial.e.f r4 = com.kwad.components.p208ad.interstitial.p242e.C7783f.this
                com.kwad.components.p208ad.interstitial.p242e.C7783f.m32393d(r4)
                boolean r4 = com.kwad.sdk.utils.C11015ai.m24123LZ()
                if (r4 == 0) goto L24
                goto L25
            L24:
                r0 = 1
            L25:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.p208ad.interstitial.report.C7802a.m32299dM()
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.m32397b(r5)
                r6 = 1
                long r8 = (long) r11
                r4.m32302a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.this
                android.content.Context r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.m32390f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.m32397b(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.m30198aq(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.p208ad.interstitial.p242e.C7783f.m32391e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.m30189b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.m30205an(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.m30202ao(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.m30197aq(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.m30207am(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.m30185d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.m30203ao(r0)
                com.kwad.components.ad.interstitial.e.f$3$1 r0 = new com.kwad.components.ad.interstitial.e.f$3$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.m30216a(r0)
                com.kwad.components.core.p289e.p293d.C8615a.m30233a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.interstitial.p242e.C7783f.C77863.mo28932a(int, com.kwad.sdk.utils.ac$a):void");
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* renamed from: dv */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m32392dv() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.interstitial.p242e.C7783f.m32392dv():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m32389h(long j) {
        C7761c c7761c = this.f26277jK;
        c7761c.f26204jM = true;
        c7761c.m32456b(1L, j);
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7761c c7761c = (C7761c) m24613Jx();
        this.f26277jK = c7761c;
        this.f26273dU = c7761c.f26197dU;
        AdTemplate adTemplate = c7761c.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        List<Integer> m25867bm = C10483a.m25867bm(m25641dQ);
        this.f26272cB = m25867bm;
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f26277jK.f26198eN;
        this.f26275eN = textureView$SurfaceTextureListenerC10537a;
        textureView$SurfaceTextureListenerC10537a.setTag(m25867bm);
        C8994f c8994f = new C8994f(this.mContext, this.mAdTemplate, this.f26275eN);
        this.f26280kM = c8994f;
        c8994f.setDataFlowAutoStart(this.f26273dU.isDataFlowAutoStart());
        this.f26280kM.setAdClickListener(this.f26276eS);
        this.f26280kM.m29498rr();
        this.mApkDownloadHelper = this.f26277jK.mApkDownloadHelper;
        m32392dv();
        float dimension = getContext().getResources().getDimension(C9659R.dimen.ksad_interstitial_card_radius);
        this.f26279kL.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26278kK = (KSFrameLayout) getRootView().findViewById(C9659R.C9662id.ksad_container);
        this.f26279kL = (KSFrameLayout) getRootView().findViewById(C9659R.C9662id.ksad_video_container);
        this.f26274eM = (ImageView) getRootView().findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.f26279kL.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26277jK.f26211jT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m32395c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f26272cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f26272cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    private C7761c.C7769b m32400a(View view, boolean z) {
        return new C7761c.C7769b(view.getContext()).m32435k(z).m32444a(this.f26278kK.getTouchCoords()).m32432z(3).m32445A(85);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        this.f26277jK.m32461a(m32400a(view, false));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        this.f26277jK.m32461a(m32400a(view, true));
    }
}
