package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* compiled from: RetryUrlRecordData.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f38823a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f38824b = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f38825c;

    /* renamed from: d  reason: collision with root package name */
    private int f38826d;

    /* renamed from: e  reason: collision with root package name */
    private HashSet<String> f38827e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private long f38828f = System.currentTimeMillis();

    /* renamed from: g  reason: collision with root package name */
    private CampaignEx f38829g;

    /* renamed from: h  reason: collision with root package name */
    private String f38830h;

    /* renamed from: i  reason: collision with root package name */
    private int f38831i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f38832j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f38833k;

    /* renamed from: l  reason: collision with root package name */
    private int f38834l;

    public b(String str, String str2) {
        this.f38825c = str;
        b(str2);
    }

    public final boolean a() {
        return this.f38832j;
    }

    public final boolean b() {
        return this.f38833k;
    }

    public final int c() {
        return this.f38834l;
    }

    public final int d() {
        return this.f38831i;
    }

    public final String e() {
        return this.f38830h;
    }

    public final CampaignEx f() {
        return this.f38829g;
    }

    public final String g() {
        return this.f38825c;
    }

    public final int h() {
        return this.f38826d;
    }

    public final HashSet<String> i() {
        return this.f38827e;
    }

    public final long j() {
        return this.f38828f;
    }

    public final void a(boolean z3) {
        this.f38832j = z3;
    }

    public final void b(boolean z3) {
        this.f38833k = z3;
    }

    public final void a(int i4) {
        this.f38834l = i4;
    }

    public final void b(int i4) {
        this.f38831i = i4;
    }

    public final void a(String str) {
        this.f38830h = str;
    }

    public final void b(String str) {
        this.f38826d++;
        this.f38827e.add(str);
    }

    public final void a(CampaignEx campaignEx) {
        this.f38829g = campaignEx;
    }
}
