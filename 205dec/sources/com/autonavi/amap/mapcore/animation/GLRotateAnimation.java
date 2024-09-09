package com.autonavi.amap.mapcore.animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f4, float f5, float f6, float f7, float f8) {
        this.mFromDegrees = f4;
        this.mToDegrees = f5;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f4, GLTransformation gLTransformation) {
        float f5 = this.mFromDegrees;
        gLTransformation.rotate = f5 + ((this.mToDegrees - f5) * f4);
    }
}
