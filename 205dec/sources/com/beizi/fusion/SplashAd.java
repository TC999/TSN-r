package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.d.g;
import com.beizi.fusion.d.t;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SplashAd {

    /* renamed from: a  reason: collision with root package name */
    private t f14413a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f14414b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14415c = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SplashClickEye {
        public SplashClickEye(Activity activity, String str) {
            g.a().a(activity, str);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface SplashClickEyeListener {
        void isSupportSplashClickEye(boolean z3);

        void onSplashClickEyeAnimationFinish();
    }

    @RequiresPermission("android.permission.INTERNET")
    public SplashAd(Context context, View view, String str, AdListener adListener, long j4) {
        Log.d("BeiZis", " request SplashAd adUnitId:" + str);
        this.f14413a = new t(context, str, view, adListener, j4);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f14414b = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void cancel(Context context) {
        t tVar = this.f14413a;
        if (tVar != null) {
            tVar.n();
        }
    }

    public int getECPM() {
        t tVar = this.f14413a;
        if (tVar != null) {
            return tVar.C();
        }
        return -1;
    }

    public void loadAd(int i4, int i5) {
        t tVar = this.f14413a;
        if (tVar == null || this.f14414b == null) {
            return;
        }
        tVar.b(i4);
        this.f14413a.c(i5);
        this.f14413a.a(this.f14414b);
    }

    public void reportNotShow() {
        t tVar = this.f14413a;
        if (tVar != null) {
            tVar.D();
        }
    }

    public void setSplashClickEyeListener(SplashClickEyeListener splashClickEyeListener) {
        g.a().a(splashClickEyeListener);
    }

    public void setSupportRegionClick(boolean z3) {
        t tVar = this.f14413a;
        if (tVar != null) {
            tVar.a(z3);
        }
    }

    public void show(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.f14415c) {
            return;
        }
        if (viewGroup != null) {
            if (this.f14413a == null || (viewGroup2 = this.f14414b) == null) {
                return;
            }
            try {
                if (!(viewGroup2.getContext() instanceof Activity)) {
                    this.f14413a.a(viewGroup.getContext());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            viewGroup.addView(this.f14414b);
            this.f14413a.B();
            this.f14415c = true;
            return;
        }
        Log.e("BeiZis", "parent can't be null !");
    }

    @Deprecated
    public void loadAd() {
        ViewGroup viewGroup;
        t tVar = this.f14413a;
        if (tVar == null || (viewGroup = this.f14414b) == null) {
            return;
        }
        tVar.a(viewGroup);
    }
}
