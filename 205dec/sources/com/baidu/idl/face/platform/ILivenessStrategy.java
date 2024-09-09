package com.baidu.idl.face.platform;

import android.graphics.Rect;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ILivenessStrategy {
    void livenessStrategy(byte[] bArr);

    void reset();

    void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback);

    void setLivenessStrategySoundEnable(boolean z3);

    void setPreviewDegree(int i4);
}
