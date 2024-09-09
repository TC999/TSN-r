package com.bxkj.base.view.seal;

import android.graphics.Bitmap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SealView.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b extends a {
    public b(int i4, String str, Bitmap bitmap) {
        super(i4, str, bitmap);
    }

    public static Bitmap g(int i4, String str, int i5) {
        return new b(i4, str, Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888)).c();
    }
}
