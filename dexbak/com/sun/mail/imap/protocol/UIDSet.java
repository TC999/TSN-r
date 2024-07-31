package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.w */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UIDSet {

    /* renamed from: a */
    public long f36191a;

    /* renamed from: b */
    public long f36192b;

    public UIDSet() {
    }

    /* renamed from: a */
    public static UIDSet[] m16087a(long[] jArr) {
        Vector vector = new Vector();
        int i = 0;
        while (i < jArr.length) {
            UIDSet uIDSet = new UIDSet();
            uIDSet.f36191a = jArr[i];
            do {
                i++;
                if (i >= jArr.length) {
                    break;
                }
                int i2 = i - 1;
                uIDSet.f36192b = jArr[i2];
                vector.addElement(uIDSet);
                i = i2 + 1;
            } while (jArr[i] == jArr[i - 1] + 1);
            int i22 = i - 1;
            uIDSet.f36192b = jArr[i22];
            vector.addElement(uIDSet);
            i = i22 + 1;
        }
        UIDSet[] uIDSetArr = new UIDSet[vector.size()];
        vector.copyInto(uIDSetArr);
        return uIDSetArr;
    }

    /* renamed from: c */
    public static long m16085c(UIDSet[] uIDSetArr) {
        long j = 0;
        if (uIDSetArr == null) {
            return 0L;
        }
        for (UIDSet uIDSet : uIDSetArr) {
            j += uIDSet.m16086b();
        }
        return j;
    }

    /* renamed from: d */
    public static String m16084d(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null || uIDSetArr.length == 0) {
            return null;
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = uIDSetArr.length;
        while (true) {
            long j = uIDSetArr[i].f36191a;
            long j2 = uIDSetArr[i].f36192b;
            if (j2 > j) {
                stringBuffer.append(j);
                stringBuffer.append(':');
                stringBuffer.append(j2);
            } else {
                stringBuffer.append(j);
            }
            i++;
            if (i >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(StringUtil.COMMA);
        }
    }

    /* renamed from: b */
    public long m16086b() {
        return (this.f36192b - this.f36191a) + 1;
    }

    public UIDSet(long j, long j2) {
        this.f36191a = j;
        this.f36192b = j2;
    }
}
