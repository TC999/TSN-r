package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTLiveAuthCallback extends Serializable {
    void onAuth(TTLiveToken tTLiveToken);

    void onFailed(Throwable th);
}
