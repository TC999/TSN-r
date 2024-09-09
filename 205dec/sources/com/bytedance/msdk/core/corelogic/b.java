package com.bytedance.msdk.core.corelogic;

import com.bytedance.msdk.api.AdError;

/* compiled from: InterAdError.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b extends AdError {
    public b(AdError adError) {
        super(adError.code, adError.message, adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
    }

    public void a(String str) {
    }
}
