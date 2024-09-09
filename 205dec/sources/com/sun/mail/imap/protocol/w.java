package com.sun.mail.imap.protocol;

import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UIDSet.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public long f50601a;

    /* renamed from: b  reason: collision with root package name */
    public long f50602b;

    public w() {
    }

    public static w[] a(long[] jArr) {
        Vector vector = new Vector();
        int i4 = 0;
        while (i4 < jArr.length) {
            w wVar = new w();
            wVar.f50601a = jArr[i4];
            do {
                i4++;
                if (i4 >= jArr.length) {
                    break;
                }
                int i5 = i4 - 1;
                wVar.f50602b = jArr[i5];
                vector.addElement(wVar);
                i4 = i5 + 1;
            } while (jArr[i4] == jArr[i4 - 1] + 1);
            int i52 = i4 - 1;
            wVar.f50602b = jArr[i52];
            vector.addElement(wVar);
            i4 = i52 + 1;
        }
        w[] wVarArr = new w[vector.size()];
        vector.copyInto(wVarArr);
        return wVarArr;
    }

    public static long c(w[] wVarArr) {
        long j4 = 0;
        if (wVarArr == null) {
            return 0L;
        }
        for (w wVar : wVarArr) {
            j4 += wVar.b();
        }
        return j4;
    }

    public static String d(w[] wVarArr) {
        if (wVarArr == null || wVarArr.length == 0) {
            return null;
        }
        int i4 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = wVarArr.length;
        while (true) {
            long j4 = wVarArr[i4].f50601a;
            long j5 = wVarArr[i4].f50602b;
            if (j5 > j4) {
                stringBuffer.append(j4);
                stringBuffer.append(':');
                stringBuffer.append(j5);
            } else {
                stringBuffer.append(j4);
            }
            i4++;
            if (i4 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public long b() {
        return (this.f50602b - this.f50601a) + 1;
    }

    public w(long j4, long j5) {
        this.f50601a = j4;
        this.f50602b = j5;
    }
}
