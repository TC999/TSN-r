package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.p066d.ClickEyeManager;
import com.beizi.fusion.p066d.SplashManager;
import com.kuaishou.weapon.p205p0.C7282g;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SplashAd {

    /* renamed from: a */
    private SplashManager f10849a;

    /* renamed from: b */
    private ViewGroup f10850b;

    /* renamed from: c */
    private boolean f10851c = false;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SplashClickEye {
        public SplashClickEye(Activity activity, String str) {
            ClickEyeManager.m48654a().m48652a(activity, str);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface SplashClickEyeListener {
        void isSupportSplashClickEye(boolean z);

        void onSplashClickEyeAnimationFinish();
    }

    @RequiresPermission(C7282g.f24943a)
    public SplashAd(Context context, View view, String str, AdListener adListener, long j) {
        Log.d("BeiZis", " request SplashAd adUnitId:" + str);
        this.f10849a = new SplashManager(context, str, view, adListener, j);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f10850b = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void cancel(Context context) {
        SplashManager splashManager = this.f10849a;
        if (splashManager != null) {
            splashManager.m48673n();
        }
    }

    public int getECPM() {
        SplashManager splashManager = this.f10849a;
        if (splashManager != null) {
            return splashManager.m48600C();
        }
        return -1;
    }

    public void loadAd(int i, int i2) {
        SplashManager splashManager = this.f10849a;
        if (splashManager == null || this.f10850b == null) {
            return;
        }
        splashManager.m48597b(i);
        this.f10849a.m48595c(i2);
        this.f10849a.m48751a(this.f10850b);
    }

    public void reportNotShow() {
        SplashManager splashManager = this.f10849a;
        if (splashManager != null) {
            splashManager.m48599D();
        }
    }

    public void setSplashClickEyeListener(SplashClickEyeListener splashClickEyeListener) {
        ClickEyeManager.m48654a().m48651a(splashClickEyeListener);
    }

    public void setSupportRegionClick(boolean z) {
        SplashManager splashManager = this.f10849a;
        if (splashManager != null) {
            splashManager.m48718a(z);
        }
    }

    public void show(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.f10851c) {
            return;
        }
        if (viewGroup != null) {
            if (this.f10849a == null || (viewGroup2 = this.f10850b) == null) {
                return;
            }
            viewGroup.addView(viewGroup2);
            this.f10849a.m48601B();
            this.f10851c = true;
            return;
        }
        Log.e("BeiZis", "parent can't be null !");
    }

    @Deprecated
    public void loadAd() {
        ViewGroup viewGroup;
        SplashManager splashManager = this.f10849a;
        if (splashManager == null || (viewGroup = this.f10850b) == null) {
            return;
        }
        splashManager.m48751a(viewGroup);
    }
}
