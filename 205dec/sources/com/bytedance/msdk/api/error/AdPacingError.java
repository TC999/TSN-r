package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdPacingError extends AdError {

    /* renamed from: a  reason: collision with root package name */
    private String f27458a;

    /* renamed from: b  reason: collision with root package name */
    private String f27459b;

    public AdPacingError(int i4, String str, String str2, String str3) {
        super(i4, str);
        this.f27458a = str2;
        this.f27459b = str3;
    }

    public String getBlockPacing() {
        return this.f27458a;
    }

    public String getRuleId() {
        return this.f27459b;
    }
}
