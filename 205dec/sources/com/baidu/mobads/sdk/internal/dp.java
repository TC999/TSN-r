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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dp {

    /* renamed from: f  reason: collision with root package name */
    private static final int f12803f = 5;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f12806c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12807d;

    /* renamed from: e  reason: collision with root package name */
    private CountDownTimer f12808e;

    /* renamed from: g  reason: collision with root package name */
    private ds f12809g;

    /* renamed from: j  reason: collision with root package name */
    private Activity f12812j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f12813k;

    /* renamed from: a  reason: collision with root package name */
    public final String f12804a = "html5_intersitial";

    /* renamed from: h  reason: collision with root package name */
    private boolean f12810h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12811i = false;

    /* renamed from: b  reason: collision with root package name */
    protected final bv f12805b = bv.a();

    public dp(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.f12808e = new dr(this, 6000L, 1000L).start();
        return this.f12806c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f12806c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f12806c.getParent()).removeView(this.f12806c);
        }
        if (this.f12808e != null) {
            this.f12805b.a("cancel countDownTimer before it finished");
            try {
                this.f12808e.cancel();
            } catch (Exception e4) {
                this.f12805b.a(e4);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i4, int i5) {
    }

    public boolean a(int i4, KeyEvent keyEvent) {
        return true;
    }

    protected boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Activity activity = this.f12812j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dq(this));
    }

    public boolean d() {
        return this.f12810h;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f12805b.a("showInterstitialAdInit");
            boolean z3 = this.f12810h;
            if (z3 && !this.f12811i) {
                this.f12811i = true;
                this.f12810h = false;
                this.f12812j = activity;
                a();
                c();
            } else if (this.f12811i) {
                this.f12805b.b("interstitial ad is showing now");
            } else if (z3) {
            } else {
                this.f12805b.b("interstitial ad is not ready");
            }
        } catch (Exception e4) {
            this.f12805b.a(e4);
        }
    }
}
