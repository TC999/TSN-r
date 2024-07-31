package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdPacingError extends AdError {

    /* renamed from: a */
    private String f21715a;

    /* renamed from: b */
    private String f21716b;

    public AdPacingError(int i, String str, String str2, String str3) {
        super(i, str);
        this.f21715a = str2;
        this.f21716b = str3;
    }

    public String getBlockPacing() {
        return this.f21715a;
    }

    public String getRuleId() {
        return this.f21716b;
    }
}
