package com.bytedance.sdk.openadsdk.mediation.manager;

import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface MediationNativeManager extends MediationBaseManager {
    boolean hasDislike();

    boolean isExpress();

    void onPause();

    void onResume();

    void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener);

    void setUseCustomVideo(boolean z3);
}
