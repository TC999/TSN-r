package com.autonavi.amap.mapcore.animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f4, float f5) {
        this.mFromAlpha = f4;
        this.mToAlpha = f5;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f4, GLTransformation gLTransformation) {
        float f5 = this.mFromAlpha;
        float f6 = f5 + ((this.mToAlpha - f5) * f4);
        this.mCurAlpha = f6;
        gLTransformation.alpha = f6;
    }
}
