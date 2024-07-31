package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* renamed from: com.baidu.mobads.sdk.internal.dm */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2695dm {

    /* renamed from: f */
    private static final int f9002f = 5;

    /* renamed from: c */
    private RelativeLayout f9005c;

    /* renamed from: d */
    private TextView f9006d;

    /* renamed from: e */
    private CountDownTimer f9007e;

    /* renamed from: g */
    private C2698dp f9008g;

    /* renamed from: j */
    private Activity f9011j;

    /* renamed from: k */
    private Boolean f9012k;

    /* renamed from: a */
    public final String f9003a = "html5_intersitial";

    /* renamed from: h */
    private boolean f9009h = false;

    /* renamed from: i */
    private boolean f9010i = false;

    /* renamed from: b */
    protected final C2634bs f9004b = C2634bs.m50744a();

    public C2695dm(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    /* renamed from: e */
    private boolean m50488e() {
        return m50491b();
    }

    /* renamed from: f */
    private View m50487f() {
        this.f9007e = new CountDownTimerC2697do(this, 6000L, 1000L).start();
        return this.f9005c;
    }

    /* renamed from: g */
    private void m50486g() {
        RelativeLayout relativeLayout = this.f9005c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f9005c.getParent()).removeView(this.f9005c);
        }
        if (this.f9007e != null) {
            this.f9004b.m50742a("cancel countDownTimer before it finished");
            try {
                this.f9007e.cancel();
            } catch (Exception e) {
                this.f9004b.m50738a(e);
            }
        }
    }

    /* renamed from: h */
    private RelativeLayout.LayoutParams m50485h() {
        return null;
    }

    /* renamed from: a */
    public void m50496a() {
    }

    /* renamed from: a */
    public void m50495a(int i, int i2) {
    }

    /* renamed from: a */
    public boolean m50494a(int i, KeyEvent keyEvent) {
        return true;
    }

    /* renamed from: b */
    protected boolean m50491b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m50490c() {
        Activity activity = this.f9011j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new RunnableC2696dn(this));
    }

    /* renamed from: d */
    public boolean m50489d() {
        return this.f9009h;
    }

    /* renamed from: a */
    public void m50493a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f9004b.m50742a("showInterstitialAdInit");
            boolean z = this.f9009h;
            if (z && !this.f9010i) {
                this.f9010i = true;
                this.f9009h = false;
                this.f9011j = activity;
                m50496a();
                m50490c();
            } else if (this.f9010i) {
                this.f9004b.m50736b("interstitial ad is showing now");
            } else if (z) {
            } else {
                this.f9004b.m50736b("interstitial ad is not ready");
            }
        } catch (Exception e) {
            this.f9004b.m50738a(e);
        }
    }
}
