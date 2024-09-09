package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;

/* compiled from: IntervalPacingBean.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h extends d {

    /* renamed from: d  reason: collision with root package name */
    private long f467d;

    /* renamed from: e  reason: collision with root package name */
    private String f468e;

    /* renamed from: f  reason: collision with root package name */
    private long f469f;

    public h(String str, String str2, int i4, String str3, String str4) {
        super(str, str2, i4);
        this.f469f = 0L;
        this.f467d = 0L;
        try {
            this.f467d = Long.parseLong(str3);
        } catch (Exception unused) {
        }
        this.f468e = str4;
    }

    public void a(long j4) {
        this.f469f = j4;
    }

    public long e() {
        return this.f467d;
    }

    public String f() {
        return this.f468e;
    }

    public long g() {
        return this.f469f;
    }

    public boolean h() {
        return this.f469f != 0;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f457a + "', showRulesVersion='" + this.f458b + "', timingMode=" + this.f459c + "}IntervalPacingBean{pacing=" + this.f467d + ", pacingRuleId='" + this.f468e + "', effectiveTime=" + this.f469f + '}';
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d
    public boolean a() {
        return (TextUtils.isEmpty(this.f468e) || this.f467d == 0) ? false : true;
    }

    public h(String str, String str2, int i4, String str3, String str4, String str5) {
        this(str, str2, i4, str3, str4);
        this.f469f = 0L;
        try {
            this.f469f = Long.parseLong(str5);
        } catch (Exception unused) {
        }
    }
}
