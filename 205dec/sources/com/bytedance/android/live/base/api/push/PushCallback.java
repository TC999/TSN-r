package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface PushCallback {
    void onFailed(Throwable th);

    void onSuccess(PushData pushData);
}
