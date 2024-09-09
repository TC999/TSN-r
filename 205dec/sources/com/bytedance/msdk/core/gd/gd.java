package com.bytedance.msdk.core.gd;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends sr {
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private long f27995f;

    /* renamed from: r  reason: collision with root package name */
    private String f27996r;

    public gd(String str, String str2, String str3, String str4, int i4, String str5, String str6) {
        super(str, str2, str3, str4, i4);
        this.ev = 0L;
        this.f27995f = 0L;
        try {
            this.f27995f = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.f27996r = str6;
    }

    public boolean a() {
        return this.ev != 0;
    }

    public void c(long j4) {
        this.ev = j4;
    }

    @Override // com.bytedance.msdk.core.gd.sr
    public boolean ev() {
        return (TextUtils.isEmpty(this.f27996r) || this.f27995f == 0) ? false : true;
    }

    public long gd() {
        return this.f27995f;
    }

    public long k() {
        return this.ev;
    }

    public String p() {
        return this.f27996r;
    }

    @Override // com.bytedance.msdk.core.gd.sr
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f28011c + "', showRulesVersion='" + this.xv + "', timingMode=" + this.ux + "}IntervalPacingBean{pacing=" + this.f27995f + ", pacingRuleId='" + this.f27996r + "', effectiveTime=" + this.ev + '}';
    }

    public gd(String str, String str2, String str3, String str4, int i4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i4, str5, str6);
        this.ev = 0L;
        try {
            this.ev = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }
}
