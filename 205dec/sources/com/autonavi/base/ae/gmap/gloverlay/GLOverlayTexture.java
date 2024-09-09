package com.autonavi.base.ae.gmap.gloverlay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i4, int i5, int i6, int i7) {
        this.mResId = i4;
        this.mWidth = i6;
        this.mHeight = i7;
        this.mResWidth = i6;
        this.mResHeight = i7;
        this.mAnchor = i5;
    }

    public GLOverlayTexture(int i4, int i5, float f4, float f5, int i6, int i7) {
        this.mResId = i4;
        this.mWidth = i6;
        this.mHeight = i7;
        this.mResWidth = i6;
        this.mResHeight = i7;
        this.mAnchor = i5;
        this.mAnchorXRatio = f4;
        this.mAnchorYRatio = f5;
    }
}
