package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdFreqError extends AdError {

    /* renamed from: a */
    private String f21713a;

    /* renamed from: b */
    private String f21714b;

    public AdFreqError(int i, String str, String str2, String str3) {
        super(i, str);
        this.f21713a = str2;
        this.f21714b = str3;
    }

    public String getBlockShowCount() {
        return this.f21713a;
    }

    public String getRuleId() {
        return this.f21714b;
    }
}
