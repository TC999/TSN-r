package com.bytedance.msdk.core.corelogic;

import com.bytedance.msdk.api.AdError;

/* renamed from: com.bytedance.msdk.core.corelogic.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InterAdError extends AdError {
    public InterAdError(AdError adError) {
        super(adError.code, adError.message, adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
    }

    /* renamed from: a */
    public void m37365a(String str) {
    }
}
