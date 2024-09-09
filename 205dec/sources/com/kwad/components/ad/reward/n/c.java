package com.kwad.components.ad.reward.n;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private View xZ;
    private View ya;
    private Button yb;
    private Button yc;
    private TextView yd;
    private ImageView ye;
    private TextView yf;
    private TextView yg;
    private KSRatingBar yh;
    private KsAppTagsView yi;
    private a yj;
    private volatile boolean yk = false;
    private com.kwad.components.ad.i.a yl;
    private Runnable ym;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void d(boolean z3, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b {
        private String appName;

        /* renamed from: qa  reason: collision with root package name */
        private String f38645qa;
        private String qb;
        private float yo;
        private List<String> yp;
        private int yq = 15;
        private String yr;

        b() {
        }

        public static b P(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.ax(dQ);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.av(dQ);
            }
            bVar.yo = com.kwad.sdk.core.response.b.a.aC(dQ);
            bVar.qb = com.kwad.sdk.core.response.b.a.au(dQ);
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.f38645qa = com.kwad.sdk.core.response.b.a.cI(dQ);
            } else {
                bVar.f38645qa = com.kwad.sdk.core.response.b.a.cf(dQ);
            }
            if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)))) {
                bVar.yq = com.kwad.components.ad.reward.a.b.gr();
                bVar.yr = "\u5b89\u88c5\u5e76\u4f53\u9a8c%s\u79d2  \u53ef\u9886\u53d6\u5956\u52b1";
            } else {
                bVar.yq = com.kwad.sdk.core.config.d.Cg();
                bVar.yr = "\u6d4f\u89c8\u8be6\u60c5\u9875%s\u79d2\uff0c\u9886\u53d6\u5956\u52b1";
            }
            bVar.yp = com.kwad.sdk.core.response.b.d.dH(adTemplate);
            return bVar;
        }

        public final String jR() {
            return String.format(this.yr, Integer.valueOf(this.yq));
        }
    }

    public c(View view) {
        this.xZ = view;
        initView();
        this.yl = new com.kwad.components.ad.i.a(view);
    }

    private void initView() {
        this.yb = (Button) this.xZ.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yc = (Button) this.xZ.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.ya = this.xZ.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.ye = (ImageView) this.xZ.findViewById(R.id.ksad_reward_apk_info_icon);
        this.yd = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_name);
        this.yf = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_desc);
        this.yh = (KSRatingBar) this.xZ.findViewById(R.id.ksad_reward_apk_info_score);
        this.yi = (KsAppTagsView) this.xZ.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void jP() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.i.a aVar = this.yl;
        if (aVar != null) {
            aVar.jP();
        }
        View view = this.ya;
        if (view == null || (runnable = this.ym) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.ym = null;
    }

    public final void jQ() {
        this.yl.mc();
    }

    public final void k(String str, int i4) {
        Button button = this.yc;
        if (button == null || str == null || i4 == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "\u7acb\u5373\u4e0b\u8f7d");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yc.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bY(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "\u7acb\u5373\u4e0b\u8f7d");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "\u7acb\u5373\u6253\u5f00");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i4) {
        super.onPaused(i4);
        if (i4 != 0) {
            this.yl.mc();
            this.yc.setText(com.kwad.sdk.core.response.b.a.dn(i4));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i4) {
        if (i4 != 0) {
            this.yl.mc();
            this.yc.setText(com.kwad.sdk.core.response.b.a.dm(i4));
        }
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            c(view, false);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z3) {
        this.mAdTemplate = adTemplate;
        b P = b.P(adTemplate);
        if (P == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.ye, P.f38645qa, adTemplate, 12);
        this.yd.setText(P.appName);
        this.yf.setText(P.qb);
        this.yh.setStar(P.yo);
        if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)))) {
            this.yc.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
            this.yh.setVisibility(0);
        } else {
            this.yc.setText("\u67e5\u770b\u8be6\u60c5");
            this.yh.setVisibility(8);
        }
        this.yb.setText(P.jR());
        this.yb.setClickable(true);
        this.yc.setClickable(true);
        this.ya.setClickable(true);
        new com.kwad.sdk.widget.f(this.yb, this);
        new com.kwad.sdk.widget.f(this.yc, this);
        new com.kwad.sdk.widget.f(this.ya, this);
        List<String> list = P.yp;
        if (z3 && list.size() == 0) {
            this.yf.setVisibility(8);
            TextView textView = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.yg = textView;
            textView.setVisibility(0);
            this.yg.setText(P.qb);
        }
        if (list.size() == 0) {
            this.yi.setVisibility(8);
        }
        this.yi.setAppTags(list);
        if (this.ym == null) {
            this.ym = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int height = c.this.ya.getHeight();
                    com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                    if (c.this.yk) {
                        return;
                    }
                    c.this.yl.hT();
                }
            };
        }
        this.ya.postDelayed(this.ym, 1600L);
    }

    public final void a(a aVar) {
        this.yj = aVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    private void c(View view, boolean z3) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", "onClick install");
            this.yk = true;
            a aVar = this.yj;
            if (aVar != null) {
                aVar.d(z3, 1);
            }
        }
    }
}
