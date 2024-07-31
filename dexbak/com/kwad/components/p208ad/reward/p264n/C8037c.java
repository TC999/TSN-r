package com.kwad.components.p208ad.reward.p264n;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.p237i.C7680a;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.widget.KsAppTagsView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.n.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8037c extends AbstractC10298a implements InterfaceC11145c {
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: xZ */
    private View f26771xZ;

    /* renamed from: ya */
    private View f26772ya;

    /* renamed from: yb */
    private Button f26773yb;

    /* renamed from: yc */
    private Button f26774yc;

    /* renamed from: yd */
    private TextView f26775yd;

    /* renamed from: ye */
    private ImageView f26776ye;

    /* renamed from: yf */
    private TextView f26777yf;

    /* renamed from: yg */
    private TextView f26778yg;

    /* renamed from: yh */
    private KSRatingBar f26779yh;

    /* renamed from: yi */
    private KsAppTagsView f26780yi;

    /* renamed from: yj */
    private InterfaceC8039a f26781yj;

    /* renamed from: yk */
    private volatile boolean f26782yk = false;

    /* renamed from: yl */
    private C7680a f26783yl;

    /* renamed from: ym */
    private Runnable f26784ym;

    /* renamed from: com.kwad.components.ad.reward.n.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8039a {
        /* renamed from: d */
        void mo31291d(boolean z, int i);
    }

    /* renamed from: com.kwad.components.ad.reward.n.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8040b {
        private String appName;

        /* renamed from: qa */
        private String f26786qa;

        /* renamed from: qb */
        private String f26787qb;

        /* renamed from: yo */
        private float f26788yo;

        /* renamed from: yp */
        private List<String> f26789yp;

        /* renamed from: yq */
        private int f26790yq = 15;

        /* renamed from: yr */
        private String f26791yr;

        C8040b() {
        }

        /* renamed from: P */
        public static C8040b m31733P(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            C8040b c8040b = new C8040b();
            if (C10487e.m25654F(adTemplate)) {
                c8040b.appName = C10483a.m25912ax(m25641dQ);
            } else {
                c8040b.appName = C10483a.m25914av(m25641dQ);
            }
            c8040b.f26788yo = C10483a.m25959aC(m25641dQ);
            c8040b.f26787qb = C10483a.m25915au(m25641dQ);
            if (C10487e.m25654F(adTemplate)) {
                c8040b.f26786qa = C10483a.m25845cI(m25641dQ);
            } else {
                c8040b.f26786qa = C10483a.m25820cf(m25641dQ);
            }
            if (C10487e.m25624i(adTemplate, C7844b.m32176k(C10487e.m25641dQ(adTemplate)))) {
                c8040b.f26790yq = C7844b.m32187gr();
                c8040b.f26791yr = "安装并体验%s秒  可领取奖励";
            } else {
                c8040b.f26790yq = C10251d.m26548Cg();
                c8040b.f26791yr = "浏览详情页%s秒，领取奖励";
            }
            c8040b.f26789yp = C10486d.m25655dH(adTemplate);
            return c8040b;
        }

        /* renamed from: jR */
        public final String m31727jR() {
            return String.format(this.f26791yr, Integer.valueOf(this.f26790yq));
        }
    }

    public C8037c(View view) {
        this.f26771xZ = view;
        initView();
        this.f26783yl = new C7680a(view);
    }

    private void initView() {
        this.f26773yb = (Button) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_action);
        this.f26774yc = (Button) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_start);
        this.f26772ya = this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_container);
        this.f26776ye = (ImageView) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_icon);
        this.f26775yd = (TextView) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_name);
        this.f26777yf = (TextView) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_desc);
        this.f26779yh = (KSRatingBar) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_score);
        this.f26780yi = (KsAppTagsView) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_tags);
    }

    /* renamed from: jP */
    public final void m31736jP() {
        Runnable runnable;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this);
        }
        C7680a c7680a = this.f26783yl;
        if (c7680a != null) {
            c7680a.m32653jP();
        }
        View view = this.f26772ya;
        if (view == null || (runnable = this.f26784ym) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.f26784ym = null;
    }

    /* renamed from: jQ */
    public final void m31735jQ() {
        this.f26783yl.m32651mc();
    }

    /* renamed from: k */
    public final void m31734k(String str, int i) {
        Button button = this.f26774yc;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f26774yc.setText(adTemplate != null ? C10483a.m25957aE(C10487e.m25641dQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f26774yc.setText(adTemplate == null ? "" : C10483a.m25882bY(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f26774yc.setText(adTemplate != null ? C10483a.m25957aE(C10487e.m25641dQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f26774yc.setText(adTemplate != null ? C10483a.m25933ac(C10487e.m25641dQ(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.f26783yl.m32651mc();
            this.f26774yc.setText(C10483a.m25794dn(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.f26783yl.m32651mc();
            this.f26774yc.setText(C10483a.m25795dm(i));
        }
    }

    /* renamed from: a */
    public final void m31741a(C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
        if (c8619c != null) {
            c8619c.m30151b(this);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m31739c(view, false);
        }
    }

    /* renamed from: c */
    public final void m31737c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        C8040b m31733P = C8040b.m31733P(adTemplate);
        if (m31733P == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.f26776ye, m31733P.f26786qa, adTemplate, 12);
        this.f26775yd.setText(m31733P.appName);
        this.f26777yf.setText(m31733P.f26787qb);
        this.f26779yh.setStar(m31733P.f26788yo);
        if (C10487e.m25624i(adTemplate, C7844b.m32176k(C10487e.m25641dQ(adTemplate)))) {
            this.f26774yc.setText(C10483a.m25957aE(C10487e.m25641dQ(adTemplate)));
            this.f26779yh.setVisibility(0);
        } else {
            this.f26774yc.setText("查看详情");
            this.f26779yh.setVisibility(8);
        }
        this.f26773yb.setText(m31733P.m31727jR());
        this.f26773yb.setClickable(true);
        this.f26774yc.setClickable(true);
        this.f26772ya.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f26773yb, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26774yc, this);
        new GestureDetector$OnGestureListenerC11148f(this.f26772ya, this);
        List<String> list = m31733P.f26789yp;
        if (z && list.size() == 0) {
            this.f26777yf.setVisibility(8);
            TextView textView = (TextView) this.f26771xZ.findViewById(C9659R.C9662id.ksad_reward_apk_info_desc_2);
            this.f26778yg = textView;
            textView.setVisibility(0);
            this.f26778yg.setText(m31733P.f26787qb);
        }
        if (list.size() == 0) {
            this.f26780yi.setVisibility(8);
        }
        this.f26780yi.setAppTags(list);
        if (this.f26784ym == null) {
            this.f26784ym = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int height = C8037c.this.f26772ya.getHeight();
                    C10331c.m26254d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                    if (C8037c.this.f26782yk) {
                        return;
                    }
                    C8037c.this.f26783yl.m32654hT();
                }
            };
        }
        this.f26772ya.postDelayed(this.f26784ym, 1600L);
    }

    /* renamed from: a */
    public final void m31743a(InterfaceC8039a interfaceC8039a) {
        this.f26781yj = interfaceC8039a;
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m31739c(view, true);
    }

    /* renamed from: c */
    private void m31739c(View view, boolean z) {
        int id = view.getId();
        if (id == C9659R.C9662id.ksad_reward_apk_info_install_container || id == C9659R.C9662id.ksad_reward_apk_info_install_action || id == C9659R.C9662id.ksad_reward_apk_info_install_start) {
            C10331c.m26254d("ApkInfoCardViewHelper", "onClick install");
            this.f26782yk = true;
            InterfaceC8039a interfaceC8039a = this.f26781yj;
            if (interfaceC8039a != null) {
                interfaceC8039a.mo31291d(z, 1);
            }
        }
    }
}
