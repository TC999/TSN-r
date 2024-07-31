package com.beizi.p051ad.lance.p062a;

import android.graphics.Rect;
import android.view.View;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.nativead.ShowMonitorListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.beizi.ad.lance.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CheckViewVisibilityUtil {

    /* renamed from: a */
    private View f10806a;

    /* renamed from: b */
    private NativeAdShownListener f10807b;

    /* renamed from: c */
    private ShowMonitorListener f10808c;

    /* renamed from: d */
    private ScheduledExecutorService f10809d;

    /* renamed from: e */
    private Runnable f10810e;

    /* renamed from: f */
    private DecimalFormatSymbols f10811f = new DecimalFormatSymbols(Locale.ENGLISH);

    /* renamed from: g */
    private Format f10812g = new DecimalFormat("0.00", this.f10811f);

    /* renamed from: h */
    private boolean f10813h = false;

    public CheckViewVisibilityUtil(View view, NativeAdShownListener nativeAdShownListener, ShowMonitorListener showMonitorListener) {
        this.f10806a = view;
        this.f10807b = nativeAdShownListener;
        this.f10808c = showMonitorListener;
        m49080a();
    }

    /* renamed from: a */
    public static CheckViewVisibilityUtil m49078a(View view, NativeAdShownListener nativeAdShownListener, ShowMonitorListener showMonitorListener) {
        if (view == null) {
            return null;
        }
        return new CheckViewVisibilityUtil(view, nativeAdShownListener, showMonitorListener);
    }

    /* renamed from: a */
    private void m49080a() {
        this.f10810e = new Runnable() { // from class: com.beizi.ad.lance.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (CheckViewVisibilityUtil.this.m49079a(10)) {
                    if (!CheckViewVisibilityUtil.this.f10813h && CheckViewVisibilityUtil.this.f10808c != null) {
                        CheckViewVisibilityUtil.this.f10813h = true;
                        CheckViewVisibilityUtil.this.f10808c.mo49367a();
                    }
                    if (CheckViewVisibilityUtil.this.m49079a(50)) {
                        if (CheckViewVisibilityUtil.this.f10807b != null) {
                            CheckViewVisibilityUtil.this.f10807b.onAdShown();
                        }
                        if (CheckViewVisibilityUtil.this.f10809d != null) {
                            CheckViewVisibilityUtil.this.f10809d.shutdownNow();
                        }
                        CheckViewVisibilityUtil.this.f10808c = null;
                        CheckViewVisibilityUtil.this.f10807b = null;
                        CheckViewVisibilityUtil.this.f10806a = null;
                        CheckViewVisibilityUtil.this.f10809d = null;
                    }
                }
            }
        };
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f10809d = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.beizi.ad.lance.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (CheckViewVisibilityUtil.this.f10806a != null) {
                    CheckViewVisibilityUtil.this.f10806a.post(CheckViewVisibilityUtil.this.f10810e);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m49079a(int i) {
        try {
            View view = this.f10806a;
            if (view != null && view.getVisibility() == 0 && this.f10806a.getParent() != null) {
                Rect rect = new Rect();
                if (this.f10806a.getGlobalVisibleRect(rect)) {
                    int height = rect.height() * rect.width();
                    int height2 = this.f10806a.getHeight() * this.f10806a.getWidth();
                    return height2 > 0 && height * 100 >= i * height2;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
