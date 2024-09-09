package com.qq.e.comm.plugin.splash.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.util.z;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends ImageView {

    /* renamed from: f  reason: collision with root package name */
    private static int f46180f;

    /* renamed from: g  reason: collision with root package name */
    private static int f46181g;

    /* renamed from: h  reason: collision with root package name */
    private static float f46182h;

    /* renamed from: c  reason: collision with root package name */
    private int f46183c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f46184d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46185e;

    public a(Context context) {
        super(context);
        if (f46180f == 0) {
            f46180f = f1.a(context, 80);
        }
        if (f46181g == 0) {
            f46181g = f1.a(context, 45);
        }
        if (f46182h == 0.0f) {
            f46182h = (f46180f * 1.0f) / f46181g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        this.f46183c = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        this.f46184d = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FrameLayout frameLayout, boolean z3, int i4, boolean z4) {
        if (frameLayout == null) {
            return;
        }
        Bitmap a4 = t.a(getContext(), this.f46183c);
        if (a4 == null && (a4 = t.a(this.f46184d)) == null) {
            return;
        }
        int width = a4.getWidth();
        int height = a4.getHeight();
        float f4 = (width * 1.0f) / height;
        if (width > f46180f || height > f46181g) {
            if (f4 >= f46182h) {
                width = f46180f;
                height = (int) (width / f4);
            } else {
                height = f46181g;
                width = (int) (height * f4);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        int i5 = d.f46198f;
        layoutParams.leftMargin = i5;
        layoutParams.rightMargin = i5;
        layoutParams.topMargin = i5;
        layoutParams.bottomMargin = i5;
        setImageBitmap(a4);
        if (z3 || i4 == 0 || i4 == 1) {
            layoutParams.gravity = 48;
            layoutParams.topMargin += (f46181g - height) / 2;
        } else if (i4 == 2) {
            layoutParams.gravity = 8388661;
            layoutParams.topMargin += (f46181g - height) / 2;
        } else {
            layoutParams.gravity = 80;
            int i6 = layoutParams.bottomMargin + ((f46181g - height) / 2);
            layoutParams.bottomMargin = i6;
            layoutParams.bottomMargin = i6 + (z4 ? d.f46200h : 0);
            this.f46185e = true;
        }
        if ((layoutParams.gravity & 48) == 48) {
            z.a(this, 2);
        }
        frameLayout.addView(this, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f46185e;
    }
}
