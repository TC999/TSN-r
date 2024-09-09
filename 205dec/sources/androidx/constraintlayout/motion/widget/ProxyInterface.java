package androidx.constraintlayout.motion.widget;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DesignTool.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
interface ProxyInterface {
    int designAccess(int i4, String str, Object obj, float[] fArr, int i5, float[] fArr2, int i6);

    float getKeyFramePosition(Object obj, int i4, float f4, float f5);

    Object getKeyframeAtLocation(Object obj, float f4, float f5);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f4, float f5, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i4, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i4, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i4, int i5, float f4, float f5);

    void setToolPosition(float f4);
}
