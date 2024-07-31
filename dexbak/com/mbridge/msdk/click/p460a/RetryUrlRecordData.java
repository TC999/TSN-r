package com.mbridge.msdk.click.p460a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* renamed from: com.mbridge.msdk.click.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RetryUrlRecordData {

    /* renamed from: a */
    public static int f29996a = 0;

    /* renamed from: b */
    public static int f29997b = 1;

    /* renamed from: c */
    private String f29998c;

    /* renamed from: d */
    private int f29999d;

    /* renamed from: e */
    private HashSet<String> f30000e = new HashSet<>();

    /* renamed from: f */
    private long f30001f = System.currentTimeMillis();

    /* renamed from: g */
    private CampaignEx f30002g;

    /* renamed from: h */
    private String f30003h;

    /* renamed from: i */
    private int f30004i;

    /* renamed from: j */
    private boolean f30005j;

    /* renamed from: k */
    private boolean f30006k;

    /* renamed from: l */
    private int f30007l;

    public RetryUrlRecordData(String str, String str2) {
        this.f29998c = str;
        m23147b(str2);
    }

    /* renamed from: a */
    public final boolean m23154a() {
        return this.f30005j;
    }

    /* renamed from: b */
    public final boolean m23149b() {
        return this.f30006k;
    }

    /* renamed from: c */
    public final int m23145c() {
        return this.f30007l;
    }

    /* renamed from: d */
    public final int m23144d() {
        return this.f30004i;
    }

    /* renamed from: e */
    public final String m23143e() {
        return this.f30003h;
    }

    /* renamed from: f */
    public final CampaignEx m23142f() {
        return this.f30002g;
    }

    /* renamed from: g */
    public final String m23141g() {
        return this.f29998c;
    }

    /* renamed from: h */
    public final int m23140h() {
        return this.f29999d;
    }

    /* renamed from: i */
    public final HashSet<String> m23139i() {
        return this.f30000e;
    }

    /* renamed from: j */
    public final long m23138j() {
        return this.f30001f;
    }

    /* renamed from: a */
    public final void m23150a(boolean z) {
        this.f30005j = z;
    }

    /* renamed from: b */
    public final void m23146b(boolean z) {
        this.f30006k = z;
    }

    /* renamed from: a */
    public final void m23153a(int i) {
        this.f30007l = i;
    }

    /* renamed from: b */
    public final void m23148b(int i) {
        this.f30004i = i;
    }

    /* renamed from: a */
    public final void m23151a(String str) {
        this.f30003h = str;
    }

    /* renamed from: b */
    public final void m23147b(String str) {
        this.f29999d++;
        this.f30000e.add(str);
    }

    /* renamed from: a */
    public final void m23152a(CampaignEx campaignEx) {
        this.f30002g = campaignEx;
    }
}
