package com.bxkj.base.view.seal;

import android.graphics.Bitmap;

/* renamed from: com.bxkj.base.view.seal.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SealView extends CreateSeal {
    public SealView(int i, String str, Bitmap bitmap) {
        super(i, str, bitmap);
    }

    /* renamed from: g */
    public static Bitmap m43476g(int i, String str, int i2) {
        return new SealView(i, str, Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888)).m43480c();
    }
}
