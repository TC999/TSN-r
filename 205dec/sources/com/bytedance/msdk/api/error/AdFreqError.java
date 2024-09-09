package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdFreqError extends AdError {

    /* renamed from: a  reason: collision with root package name */
    private String f27456a;

    /* renamed from: b  reason: collision with root package name */
    private String f27457b;

    public AdFreqError(int i4, String str, String str2, String str3) {
        super(i4, str);
        this.f27456a = str2;
        this.f27457b = str3;
    }

    public String getBlockShowCount() {
        return this.f27456a;
    }

    public String getRuleId() {
        return this.f27457b;
    }
}
