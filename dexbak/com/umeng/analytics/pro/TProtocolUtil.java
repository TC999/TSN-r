package com.umeng.analytics.pro;

import com.umeng.analytics.pro.TCompactProtocol;

/* renamed from: com.umeng.analytics.pro.ct */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TProtocolUtil {

    /* renamed from: a */
    private static int f38052a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m14398a(int i) {
        f38052a = i;
    }

    /* renamed from: a */
    public static void m14397a(TProtocol tProtocol, byte b) throws TException {
        m14396a(tProtocol, b, f38052a);
    }

    /* renamed from: a */
    public static void m14396a(TProtocol tProtocol, byte b, int i) throws TException {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    tProtocol.mo14406t();
                    return;
                case 3:
                    tProtocol.mo14405u();
                    return;
                case 4:
                    tProtocol.mo14401y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    tProtocol.mo14404v();
                    return;
                case 8:
                    tProtocol.mo14403w();
                    return;
                case 10:
                    tProtocol.mo14402x();
                    return;
                case 11:
                    tProtocol.mo14442A();
                    return;
                case 12:
                    tProtocol.mo14416j();
                    while (true) {
                        byte b2 = tProtocol.mo14414l().f38029b;
                        if (b2 == 0) {
                            tProtocol.mo14415k();
                            return;
                        } else {
                            m14396a(tProtocol, b2, i - 1);
                            tProtocol.mo14413m();
                        }
                    }
                case 13:
                    TMap mo14412n = tProtocol.mo14412n();
                    while (i2 < mo14412n.f38035c) {
                        int i3 = i - 1;
                        m14396a(tProtocol, mo14412n.f38033a, i3);
                        m14396a(tProtocol, mo14412n.f38034b, i3);
                        i2++;
                    }
                    tProtocol.mo14411o();
                    return;
                case 14:
                    TSet mo14408r = tProtocol.mo14408r();
                    while (i2 < mo14408r.f38054b) {
                        m14396a(tProtocol, mo14408r.f38053a, i - 1);
                        i2++;
                    }
                    tProtocol.mo14407s();
                    return;
                case 15:
                    TList mo14410p = tProtocol.mo14410p();
                    while (i2 < mo14410p.f38032b) {
                        m14396a(tProtocol, mo14410p.f38031a, i - 1);
                        i2++;
                    }
                    tProtocol.mo14409q();
                    return;
            }
        } else {
            throw new TException("Maximum skip depth exceeded");
        }
    }

    /* renamed from: a */
    public static TProtocolFactory m14395a(byte[] bArr, TProtocolFactory tProtocolFactory) {
        if (bArr[0] > 16) {
            return new TCompactProtocol.C13140a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? tProtocolFactory : new TCompactProtocol.C13140a();
    }
}
