package com.bytedance.msdk.api.xv;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface c {
    float getAmount();

    @Nullable
    Map<String, Object> getCustomData();

    @Nullable
    String getRewardName();

    boolean rewardVerify();
}
