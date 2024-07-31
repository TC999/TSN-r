package com.baidu.idl.face.platform;

import android.graphics.Rect;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IDetectStrategy {
    void detectStrategy(byte[] bArr);

    void reset();

    void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback);

    void setDetectStrategySoundEnable(boolean z);

    void setPreviewDegree(int i);
}
