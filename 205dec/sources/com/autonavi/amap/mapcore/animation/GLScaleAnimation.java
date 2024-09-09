package com.autonavi.amap.mapcore.animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f4, float f5, float f6, float f7) {
        this.mFromX = f4;
        this.mToX = f5;
        this.mFromY = f6;
        this.mToY = f7;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f4, GLTransformation gLTransformation) {
        float f5 = this.mFromX;
        float f6 = 1.0f;
        float f7 = (f5 == 1.0f && this.mToX == 1.0f) ? 1.0f : f5 + ((this.mToX - f5) * f4);
        float f8 = this.mFromY;
        if (f8 != 1.0f || this.mToY != 1.0f) {
            f6 = ((this.mToY - f8) * f4) + f8;
        }
        gLTransformation.scaleX = f7;
        gLTransformation.scaleY = f6;
    }
}
