package com.baidu.idl.face.platform;

import android.graphics.Rect;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ILivenessStrategy {
    void livenessStrategy(byte[] bArr);

    void reset();

    void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback);

    void setLivenessStrategySoundEnable(boolean z);

    void setPreviewDegree(int i);
}
