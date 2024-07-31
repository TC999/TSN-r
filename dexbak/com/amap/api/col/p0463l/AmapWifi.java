package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.j9 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AmapWifi {

    /* renamed from: a */
    public long f4584a;

    /* renamed from: b */
    public String f4585b;

    /* renamed from: d */
    public int f4587d;

    /* renamed from: e */
    public long f4588e;

    /* renamed from: g */
    public short f4590g;

    /* renamed from: h */
    public boolean f4591h;

    /* renamed from: c */
    public int f4586c = -113;

    /* renamed from: f */
    public long f4589f = 0;

    public AmapWifi(boolean z) {
        this.f4591h = z;
    }

    /* renamed from: a */
    public static long m54648a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j3 = 97;
                if (charAt < 97 || charAt > 102) {
                    j3 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (charAt != 58 && charAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (charAt - j3) + 10;
            } else {
                j = charAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }

    /* renamed from: c */
    public static String m54646c(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return DataTypeUtil.m53904a(DataTypeUtil.m53903b(j), ":");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public AmapWifi clone() {
        AmapWifi amapWifi = new AmapWifi(this.f4591h);
        amapWifi.f4584a = this.f4584a;
        amapWifi.f4585b = this.f4585b;
        amapWifi.f4586c = this.f4586c;
        amapWifi.f4587d = this.f4587d;
        amapWifi.f4588e = this.f4588e;
        amapWifi.f4589f = this.f4589f;
        amapWifi.f4590g = this.f4590g;
        amapWifi.f4591h = this.f4591h;
        return amapWifi;
    }

    /* renamed from: b */
    public final String m54647b() {
        return this.f4591h + "#" + this.f4584a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f4584a + ", ssid='" + this.f4585b + "', rssi=" + this.f4586c + ", frequency=" + this.f4587d + ", timestamp=" + this.f4588e + ", lastUpdateUtcMills=" + this.f4589f + ", freshness=" + ((int) this.f4590g) + ", connected=" + this.f4591h + '}';
    }
}
