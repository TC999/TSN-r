package com.baidu.idl.face.platform;

import android.graphics.Rect;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IDetectStrategy {
    void detectStrategy(byte[] bArr);

    void reset();

    void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback);

    void setDetectStrategySoundEnable(boolean z3);

    void setPreviewDegree(int i4);
}
