package com.qq.e.comm.plugin.o0.h;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b0.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class RunnableC0868a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewGroup f45114c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f45115d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f45116e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f45117f;

        RunnableC0868a(ViewGroup viewGroup, f fVar, String str, int i4) {
            this.f45114c = viewGroup;
            this.f45115d = fVar;
            this.f45116e = str;
            this.f45117f = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = this.f45114c.getMeasuredWidth();
            int measuredHeight = this.f45115d.getMeasuredHeight();
            d1.a("BGBlurHelper", "containWidth : " + measuredWidth + " ,containHeight : " + measuredHeight);
            int measuredWidth2 = this.f45115d.getMeasuredWidth();
            int measuredHeight2 = this.f45115d.getMeasuredHeight();
            d1.a("BGBlurHelper", "videoWidth : " + measuredWidth2 + " ,videoHeight : " + measuredHeight2);
            if (measuredWidth > measuredWidth2 || measuredHeight > measuredHeight2) {
                a.b(this.f45114c, this.f45116e, this.f45117f);
            } else {
                d1.a("BGBlurHelper", "no need blur");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f45118a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f45119b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f45120c;

        b(ImageView imageView, ViewGroup viewGroup, long j4) {
            this.f45118a = imageView;
            this.f45119b = viewGroup;
            this.f45120c = j4;
        }

        @Override // com.qq.e.comm.plugin.b0.a.c
        public void a(com.qq.e.comm.plugin.b0.f fVar) {
            a.b(this.f45118a, fVar.b(), this.f45119b, this.f45120c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ViewGroup viewGroup, String str, int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag("blurImage");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = new ImageView(viewGroup.getContext());
        imageView2.setTag("blurBG");
        imageView2.setLayoutParams(layoutParams);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setBackgroundColor(i4);
        viewGroup.addView(imageView2, 0);
        com.qq.e.comm.plugin.b0.a.a(str, 3.0f, new b(imageView, viewGroup, currentTimeMillis));
    }

    public static void a(ViewGroup viewGroup, String str, f fVar) {
        a(viewGroup, str, fVar, false);
    }

    public static void a(ViewGroup viewGroup, String str, f fVar, boolean z3) {
        a(viewGroup, str, fVar, Color.parseColor("#88444444"), z3);
    }

    public static void a(ViewGroup viewGroup, String str, f fVar, int i4, boolean z3) {
        if (a()) {
            d1.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT < 17) {
                d1.a("BGBlurHelper", "RenderScript nonsupport SDK level");
                return;
            }
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null && findViewWithTag2 != null) {
                findViewWithTag.setVisibility(0);
                findViewWithTag2.setVisibility(0);
                d1.a("BGBlurHelper", "already do blur, just show.");
            } else if (z3) {
                b(viewGroup, str, i4);
            } else if (fVar == null) {
            } else {
                viewGroup.postDelayed(new RunnableC0868a(viewGroup, fVar, str, i4), 50L);
            }
        } else {
            d1.a("BGBlurHelper", "viewGroup or imgUrl null");
        }
    }

    public static void b(ViewGroup viewGroup) {
        if (a()) {
            d1.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup == null) {
        } else {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(0);
            }
            if (findViewWithTag2 != null) {
                findViewWithTag2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageView imageView, Bitmap bitmap, ViewGroup viewGroup, long j4) {
        if (bitmap == null || bitmap.isRecycled() || viewGroup == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(imageView, 0);
        long currentTimeMillis = System.currentTimeMillis() - j4;
        d1.a("BGBlurHelper", "BG Blur cost : " + currentTimeMillis);
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2030019);
        hVar.b(currentTimeMillis);
        v.a(hVar);
    }

    public static void a(ViewGroup viewGroup) {
        if (a()) {
            d1.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup == null) {
        } else {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(4);
            }
            if (findViewWithTag2 != null) {
                findViewWithTag2.setVisibility(4);
            }
        }
    }

    private static boolean a() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("videoBGBlur", 1) == 0;
    }
}
