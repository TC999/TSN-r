package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AmapWifi.java */
/* renamed from: com.amap.api.col.3l.k9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k9 {

    /* renamed from: a  reason: collision with root package name */
    public long f8253a;

    /* renamed from: b  reason: collision with root package name */
    public String f8254b;

    /* renamed from: d  reason: collision with root package name */
    public int f8256d;

    /* renamed from: e  reason: collision with root package name */
    public long f8257e;

    /* renamed from: g  reason: collision with root package name */
    public short f8259g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8260h;

    /* renamed from: c  reason: collision with root package name */
    public int f8255c = -113;

    /* renamed from: f  reason: collision with root package name */
    public long f8258f = 0;

    public k9(boolean z3) {
        this.f8260h = z3;
    }

    public static long a(String str) {
        long j4;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i4 = 0;
        long j5 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j6 = 97;
                if (charAt < 97 || charAt > 102) {
                    j6 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (charAt != 58 && charAt != 124) {
                            return 0L;
                        }
                    }
                }
                j4 = (charAt - j6) + 10;
            } else {
                j4 = charAt - 48;
            }
            j5 += j4 << i4;
            i4 += 4;
        }
        if (i4 != 48) {
            return 0L;
        }
        return j5;
    }

    public static String c(long j4) {
        if (j4 < 0 || j4 > 281474976710655L) {
            return null;
        }
        return t9.a(t9.b(j4), ":");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public k9 clone() {
        k9 k9Var = new k9(this.f8260h);
        k9Var.f8253a = this.f8253a;
        k9Var.f8254b = this.f8254b;
        k9Var.f8255c = this.f8255c;
        k9Var.f8256d = this.f8256d;
        k9Var.f8257e = this.f8257e;
        k9Var.f8258f = this.f8258f;
        k9Var.f8259g = this.f8259g;
        k9Var.f8260h = this.f8260h;
        return k9Var;
    }

    public final String b() {
        return this.f8260h + "#" + this.f8253a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f8253a + ", ssid='" + this.f8254b + "', rssi=" + this.f8255c + ", frequency=" + this.f8256d + ", timestamp=" + this.f8257e + ", lastUpdateUtcMills=" + this.f8258f + ", freshness=" + ((int) this.f8259g) + ", connected=" + this.f8260h + '}';
    }
}
