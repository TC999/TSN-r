package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IntervalPacingBean extends BaseIntervalBean {

    /* renamed from: d */
    private long f474d;

    /* renamed from: e */
    private String f475e;

    /* renamed from: f */
    private long f476f;

    public IntervalPacingBean(String str, String str2, int i, String str3, String str4) {
        super(str, str2, i);
        this.f476f = 0L;
        this.f474d = 0L;
        try {
            this.f474d = Long.parseLong(str3);
        } catch (Exception unused) {
        }
        this.f475e = str4;
    }

    /* renamed from: a */
    public void m59599a(long j) {
        this.f476f = j;
    }

    /* renamed from: e */
    public long m59598e() {
        return this.f474d;
    }

    /* renamed from: f */
    public String m59597f() {
        return this.f475e;
    }

    /* renamed from: g */
    public long m59596g() {
        return this.f476f;
    }

    /* renamed from: h */
    public boolean m59595h() {
        return this.f476f != 0;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f464a + "', showRulesVersion='" + this.f465b + "', timingMode=" + this.f466c + "}IntervalPacingBean{pacing=" + this.f474d + ", pacingRuleId='" + this.f475e + "', effectiveTime=" + this.f476f + '}';
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.BaseIntervalBean
    /* renamed from: a */
    public boolean mo59600a() {
        return (TextUtils.isEmpty(this.f475e) || this.f474d == 0) ? false : true;
    }

    public IntervalPacingBean(String str, String str2, int i, String str3, String str4, String str5) {
        this(str, str2, i, str3, str4);
        this.f476f = 0L;
        try {
            this.f476f = Long.parseLong(str5);
        } catch (Exception unused) {
        }
    }
}
