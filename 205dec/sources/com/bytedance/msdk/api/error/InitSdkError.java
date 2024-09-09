package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InitSdkError extends AdError {
    public int thirdSdkErrorCode;
    public String thirdSdkErrorMessage;

    public InitSdkError(int i4, String str) {
        super(i4, AdError.messageFormat(AdError.AD_THIRD_SDK_ADAPTER_INITIALIZATION_SUCCESS_MSG, "\u3010" + str + "\u3011", new String[0]));
        this.thirdSdkErrorCode = i4;
        this.thirdSdkErrorMessage = AdError.messageFormat(AdError.AD_THIRD_SDK_ADAPTER_INITIALIZATION_SUCCESS_MSG, "\u3010" + str + "\u3011", new String[0]);
    }

    public String printMsg() {
        return this.thirdSdkErrorMessage;
    }

    @Override // com.bytedance.msdk.api.AdError
    public String toString() {
        return "InitSdkError{thirdSdkErrorCode=" + this.thirdSdkErrorCode + ", thirdSdkErrorMessage='" + this.thirdSdkErrorMessage + "'}";
    }
}
