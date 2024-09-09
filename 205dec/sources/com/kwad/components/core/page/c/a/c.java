package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends a {
    private LinearLayout OP;
    private TextView OQ;
    private TextView OR;
    private TextView OS;
    private TextView OT;
    private int OU;
    private boolean OV = false;
    private boolean OW = false;
    private Runnable OX = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.OV) {
                bn.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.OU <= 0) {
                c.this.OQ.setText("\u4efb\u52a1\u5df2\u5b8c\u6210");
                c.this.OR.setVisibility(8);
                c.this.OS.setVisibility(8);
                c.this.OT.setVisibility(8);
                com.kwad.components.ad.b.g gVar = (com.kwad.components.ad.b.g) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.g.class);
                if (gVar != null && !c.this.OW) {
                    gVar.notifyRewardVerify();
                }
            } else {
                c.this.pw();
                bn.runOnUiThreadDelay(this, 1000L);
            }
            c.i(c.this);
        }
    };
    private final com.kwad.sdk.core.c.c wT = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.OV = true;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.OV = false;
        }
    };

    static /* synthetic */ int i(c cVar) {
        int i4 = cVar.OU;
        cVar.OU = i4 - 1;
        return i4;
    }

    private void pv() {
        this.OP.setVisibility(0);
        if (this.OH.mAdTemplate.mRewardVerifyCalled) {
            this.OQ.setText("\u4efb\u52a1\u5df2\u5b8c\u6210");
            this.OR.setVisibility(8);
            this.OS.setVisibility(8);
            this.OT.setVisibility(8);
            return;
        }
        pw();
        bn.runOnUiThreadDelay(this.OX, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        this.OR.setText(px());
        this.OT.setText(py());
    }

    private String px() {
        int i4 = this.OU / 60;
        if (i4 >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            return sb.toString();
        }
        return "0" + i4;
    }

    private String py() {
        int i4 = this.OU % 60;
        if (i4 >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            return sb.toString();
        }
        return "0" + i4;
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(this.wT);
        this.OU = com.kwad.sdk.core.config.d.Cg();
        pv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.OP = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.OQ = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.OR = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.OS = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.OT = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.b(this.wT);
        bn.c(this.OX);
    }
}
