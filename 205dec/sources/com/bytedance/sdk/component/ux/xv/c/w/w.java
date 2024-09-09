package com.bytedance.sdk.component.ux.xv.c.w;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.sdk.component.ux.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements s {

    /* renamed from: c  reason: collision with root package name */
    private int f30284c;
    private com.bytedance.sdk.component.ux.xv.c.xv<String, Bitmap> sr;

    /* renamed from: w  reason: collision with root package name */
    private int f30285w;
    private int xv;

    public w(int i4, int i5) {
        this.xv = i4;
        this.f30284c = i5;
        this.sr = new com.bytedance.sdk.component.ux.xv.c.xv<String, Bitmap>(i4) { // from class: com.bytedance.sdk.component.ux.xv.c.w.w.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ux.xv.c.xv
            /* renamed from: c */
            public int w(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return w.c(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean w(String str) {
        return this.sr.c((com.bytedance.sdk.component.ux.xv.c.xv<String, Bitmap>) str) != null;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public boolean c(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.sr.c(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.ux.c
    public Bitmap c(String str) {
        return this.sr.c((com.bytedance.sdk.component.ux.xv.c.xv<String, Bitmap>) str);
    }

    @Override // com.bytedance.sdk.component.ux.c
    public void c(double d4) {
        com.bytedance.sdk.component.ux.xv.c.xv<String, Bitmap> xvVar = this.sr;
        double d5 = this.xv;
        Double.isNaN(d5);
        xvVar.c((int) (d5 * d4));
    }

    public static int c(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
