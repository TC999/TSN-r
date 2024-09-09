package com.beizi.fusion.g;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.widget.ScrollClickView;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SDCardHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static String f14848a = "extra";

    /* compiled from: ScrollClickUtil.java */
    /* renamed from: com.beizi.fusion.g.ap$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ap.this.a();
        }
    }

    /* compiled from: ScrollClickUtil.java */
    /* renamed from: com.beizi.fusion.g.ap$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14851b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f14852c;

        AnonymousClass2(int i4, int i5, FrameLayout.LayoutParams layoutParams) {
            this.f14850a = i4;
            this.f14851b = i5;
            this.f14852c = layoutParams;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScrollClickView scrollClickView = ap.this.a;
            if (scrollClickView == null) {
                return;
            }
            scrollClickView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int measuredWidth = ap.this.a.getMeasuredWidth();
            ap apVar = ap.this;
            if (apVar.c == 0) {
                apVar.c = av.a(ap.a(apVar), this.f14850a) / 2;
            }
            ap apVar2 = ap.this;
            if (apVar2.b == 0) {
                apVar2.b = av.a(ap.a(apVar2), this.f14851b) / 2;
            }
            FrameLayout.LayoutParams layoutParams = this.f14852c;
            ap apVar3 = ap.this;
            layoutParams.topMargin = apVar3.c;
            layoutParams.leftMargin = apVar3.b - (measuredWidth / 2);
            apVar3.a.setLayoutParams(layoutParams);
            af.a("ScrollClickUtil", "topMargin = " + this.f14852c.topMargin + ",leftMargin = " + this.f14852c.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
        }
    }

    /* compiled from: ScrollClickUtil.java */
    /* renamed from: com.beizi.fusion.g.ap$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ScrollClickView scrollClickView = ap.this.a;
                if (scrollClickView != null) {
                    scrollClickView.startAnim();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* compiled from: ScrollClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void c_();
    }

    public static void a(File file) {
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                }
                file.delete();
            } else if (file.exists()) {
                file.delete();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
