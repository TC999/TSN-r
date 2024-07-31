package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    public /* bridge */ /* synthetic */ void setAlpha(float f) {
        super.setAlpha(f);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setContext(Context context) {
        super.setContext(context);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setGravity(int i) {
        super.setGravity(i);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setMargins(int i, int i2, int i3, int i4) {
        super.setMargins(i, i2, i3, i4);
    }

    public void setMarkBitmap(Bitmap bitmap) {
        this.mMarkBitmap = bitmap;
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setRotate(int i) {
        super.setRotate(i);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setScale(float f) {
        super.setScale(f);
    }

    @Override // com.umeng.social.tool.UMWaterMark
    public /* bridge */ /* synthetic */ void setTransparent() {
        super.setTransparent();
    }
}
