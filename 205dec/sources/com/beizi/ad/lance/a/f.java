package com.beizi.ad.lance.a;

import android.graphics.Rect;
import android.view.View;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CheckViewVisibilityUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private View f14371a;

    /* renamed from: b  reason: collision with root package name */
    private NativeAdShownListener f14372b;

    /* renamed from: c  reason: collision with root package name */
    private com.beizi.ad.internal.nativead.d f14373c;

    /* renamed from: d  reason: collision with root package name */
    private ScheduledExecutorService f14374d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f14375e;

    /* renamed from: f  reason: collision with root package name */
    private DecimalFormatSymbols f14376f = new DecimalFormatSymbols(Locale.ENGLISH);

    /* renamed from: g  reason: collision with root package name */
    private Format f14377g = new DecimalFormat("0.00", this.f14376f);

    /* renamed from: h  reason: collision with root package name */
    private boolean f14378h = false;

    public f(View view, NativeAdShownListener nativeAdShownListener, com.beizi.ad.internal.nativead.d dVar) {
        this.f14371a = view;
        this.f14372b = nativeAdShownListener;
        this.f14373c = dVar;
        a();
    }

    public static f a(View view, NativeAdShownListener nativeAdShownListener, com.beizi.ad.internal.nativead.d dVar) {
        if (view == null) {
            return null;
        }
        return new f(view, nativeAdShownListener, dVar);
    }

    private void a() {
        this.f14375e = new Runnable() { // from class: com.beizi.ad.lance.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a(10)) {
                    if (!f.this.f14378h && f.this.f14373c != null) {
                        f.this.f14378h = true;
                        f.this.f14373c.a();
                    }
                    if (f.this.a(50)) {
                        if (f.this.f14372b != null) {
                            f.this.f14372b.onAdShown();
                        }
                        if (f.this.f14374d != null) {
                            f.this.f14374d.shutdownNow();
                        }
                        f.this.f14373c = null;
                        f.this.f14372b = null;
                        f.this.f14371a = null;
                        f.this.f14374d = null;
                    }
                }
            }
        };
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f14374d = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.beizi.ad.lance.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f14371a != null) {
                    f.this.f14371a.post(f.this.f14375e);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i4) {
        try {
            View view = this.f14371a;
            if (view != null && view.getVisibility() == 0 && this.f14371a.getParent() != null) {
                Rect rect = new Rect();
                if (this.f14371a.getGlobalVisibleRect(rect)) {
                    int height = rect.height() * rect.width();
                    int height2 = this.f14371a.getHeight() * this.f14371a.getWidth();
                    return height2 > 0 && height * 100 >= i4 * height2;
                }
                return false;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
