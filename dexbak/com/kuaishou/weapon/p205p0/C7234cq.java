package com.kuaishou.weapon.p205p0;

import android.os.Build;

/* renamed from: com.kuaishou.weapon.p0.cq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7234cq {

    /* renamed from: a */
    static C7234cq f24716a;

    /* renamed from: b */
    static C7234cq f24717b;

    /* renamed from: c */
    static C7234cq f24718c;

    /* renamed from: d */
    private long f24719d;

    /* renamed from: e */
    private EnumC7235a f24720e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kuaishou.weapon.p0.cq$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum EnumC7235a {
        DWORD(4),
        QWORD(8);
        

        /* renamed from: c */
        int f24724c;

        EnumC7235a(int i) {
            this.f24724c = i;
        }
    }

    static {
        m34043c();
    }

    /* renamed from: c */
    private static void m34043c() {
        f24716a = new C7234cq();
        f24717b = new C7234cq();
        f24718c = new C7234cq();
        C7234cq c7234cq = f24717b;
        EnumC7235a enumC7235a = EnumC7235a.DWORD;
        c7234cq.m34045a(enumC7235a);
        int i = Build.VERSION.SDK_INT;
        if (C7236cr.m34042a()) {
            C7234cq c7234cq2 = f24716a;
            EnumC7235a enumC7235a2 = EnumC7235a.QWORD;
            c7234cq2.m34045a(enumC7235a2);
            f24718c.m34045a(enumC7235a2);
            switch (i) {
                case 19:
                    f24716a.m34046a(32L);
                    f24717b.m34046a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    f24716a.m34046a(40L);
                    f24716a.m34045a(enumC7235a2);
                    f24718c.m34046a(32L);
                    f24718c.m34045a(enumC7235a2);
                    f24717b.m34046a(56L);
                    return;
                case 22:
                    f24716a.m34046a(52L);
                    f24718c.m34046a(44L);
                    f24717b.m34046a(20L);
                    return;
                case 23:
                    f24716a.m34046a(48L);
                    f24718c.m34046a(40L);
                    f24717b.m34046a(12L);
                    return;
                case 24:
                case 25:
                    f24716a.m34046a(48L);
                    f24718c.m34046a(40L);
                    f24717b.m34046a(4L);
                    return;
                case 26:
                case 27:
                    f24716a.m34046a(40L);
                    f24718c.m34046a(32L);
                    f24717b.m34046a(4L);
                    return;
                case 28:
                case 29:
                    f24716a.m34046a(32L);
                    f24718c.m34046a(24L);
                    f24717b.m34046a(4L);
                    return;
            }
        }
        f24716a.m34045a(enumC7235a);
        f24718c.m34045a(enumC7235a);
        switch (i) {
            case 19:
                f24716a.m34046a(32L);
                f24717b.m34046a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            case 21:
                f24716a.m34046a(40L);
                C7234cq c7234cq3 = f24716a;
                EnumC7235a enumC7235a3 = EnumC7235a.QWORD;
                c7234cq3.m34045a(enumC7235a3);
                f24718c.m34046a(32L);
                f24718c.m34045a(enumC7235a3);
                f24717b.m34046a(56L);
                return;
            case 22:
                f24716a.m34046a(44L);
                f24718c.m34046a(40L);
                f24717b.m34046a(20L);
                return;
            case 23:
                f24716a.m34046a(36L);
                f24718c.m34046a(32L);
                f24717b.m34046a(12L);
                return;
            case 24:
            case 25:
                f24716a.m34046a(32L);
                f24718c.m34046a(28L);
                f24717b.m34046a(4L);
                return;
            case 26:
            case 27:
                f24716a.m34046a(28L);
                f24718c.m34046a(24L);
                f24717b.m34046a(4L);
                return;
            case 28:
            case 29:
                f24716a.m34046a(24L);
                f24718c.m34046a(20L);
                f24717b.m34046a(4L);
                return;
        }
    }

    /* renamed from: a */
    public long m34047a() {
        return this.f24719d;
    }

    /* renamed from: b */
    public EnumC7235a m34044b() {
        return this.f24720e;
    }

    /* renamed from: a */
    public void m34046a(long j) {
        this.f24719d = j;
    }

    /* renamed from: a */
    public void m34045a(EnumC7235a enumC7235a) {
        this.f24720e = enumC7235a;
    }
}
