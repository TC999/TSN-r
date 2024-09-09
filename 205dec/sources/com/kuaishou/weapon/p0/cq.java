package com.kuaishou.weapon.p0;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cq {

    /* renamed from: a  reason: collision with root package name */
    static cq f38212a;

    /* renamed from: b  reason: collision with root package name */
    static cq f38213b;

    /* renamed from: c  reason: collision with root package name */
    static cq f38214c;

    /* renamed from: d  reason: collision with root package name */
    private long f38215d;

    /* renamed from: e  reason: collision with root package name */
    private a f38216e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum a {
        DWORD(4),
        QWORD(8);
        

        /* renamed from: c  reason: collision with root package name */
        int f38220c;

        a(int i4) {
            this.f38220c = i4;
        }
    }

    static {
        c();
    }

    private static void c() {
        f38212a = new cq();
        f38213b = new cq();
        f38214c = new cq();
        cq cqVar = f38213b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i4 = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f38212a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            f38214c.a(aVar2);
            switch (i4) {
                case 19:
                    f38212a.a(32L);
                    f38213b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i4 + " is not supported now : (");
                case 21:
                    f38212a.a(40L);
                    f38212a.a(aVar2);
                    f38214c.a(32L);
                    f38214c.a(aVar2);
                    f38213b.a(56L);
                    return;
                case 22:
                    f38212a.a(52L);
                    f38214c.a(44L);
                    f38213b.a(20L);
                    return;
                case 23:
                    f38212a.a(48L);
                    f38214c.a(40L);
                    f38213b.a(12L);
                    return;
                case 24:
                case 25:
                    f38212a.a(48L);
                    f38214c.a(40L);
                    f38213b.a(4L);
                    return;
                case 26:
                case 27:
                    f38212a.a(40L);
                    f38214c.a(32L);
                    f38213b.a(4L);
                    return;
                case 28:
                case 29:
                    f38212a.a(32L);
                    f38214c.a(24L);
                    f38213b.a(4L);
                    return;
            }
        }
        f38212a.a(aVar);
        f38214c.a(aVar);
        switch (i4) {
            case 19:
                f38212a.a(32L);
                f38213b.a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i4 + " is not supported now : (");
            case 21:
                f38212a.a(40L);
                cq cqVar3 = f38212a;
                a aVar3 = a.QWORD;
                cqVar3.a(aVar3);
                f38214c.a(32L);
                f38214c.a(aVar3);
                f38213b.a(56L);
                return;
            case 22:
                f38212a.a(44L);
                f38214c.a(40L);
                f38213b.a(20L);
                return;
            case 23:
                f38212a.a(36L);
                f38214c.a(32L);
                f38213b.a(12L);
                return;
            case 24:
            case 25:
                f38212a.a(32L);
                f38214c.a(28L);
                f38213b.a(4L);
                return;
            case 26:
            case 27:
                f38212a.a(28L);
                f38214c.a(24L);
                f38213b.a(4L);
                return;
            case 28:
            case 29:
                f38212a.a(24L);
                f38214c.a(20L);
                f38213b.a(4L);
                return;
        }
    }

    public long a() {
        return this.f38215d;
    }

    public a b() {
        return this.f38216e;
    }

    public void a(long j4) {
        this.f38215d = j4;
    }

    public void a(a aVar) {
        this.f38216e = aVar;
    }
}
