package com.autonavi.amap.mapcore.animation;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromDegrees;
        gLTransformation.rotate = f2 + ((this.mToDegrees - f2) * f);
    }
}
