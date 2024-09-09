package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMImageMark extends UMWaterMark {
    private Bitmap mMarkBitmap;

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void bringToFront() {
        super.bringToFront();
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ Bitmap compound(Bitmap bitmap) {
        return super.compound(bitmap);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    Bitmap getMarkBitmap() {
        return this.mMarkBitmap;
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setAlpha(float f4) {
        super.setAlpha(f4);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setContext(Context context) {
        super.setContext(context);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setGravity(int i4) {
        super.setGravity(i4);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setMargins(int i4, int i5, int i6, int i7) {
        super.setMargins(i4, i5, i6, i7);
    }

    public void setMarkBitmap(Bitmap bitmap) {
        this.mMarkBitmap = bitmap;
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setRotate(int i4) {
        super.setRotate(i4);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setScale(float f4) {
        super.setScale(f4);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setTransparent() {
        super.setTransparent();
    }
}
