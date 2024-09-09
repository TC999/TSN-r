package com.sun.mail.imap.protocol;

import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MessageSet.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f50576a;

    /* renamed from: b  reason: collision with root package name */
    public int f50577b;

    public o() {
    }

    public static o[] a(int[] iArr) {
        Vector vector = new Vector();
        int i4 = 0;
        while (i4 < iArr.length) {
            o oVar = new o();
            oVar.f50576a = iArr[i4];
            do {
                i4++;
                if (i4 >= iArr.length) {
                    break;
                }
                int i5 = i4 - 1;
                oVar.f50577b = iArr[i5];
                vector.addElement(oVar);
                i4 = i5 + 1;
            } while (iArr[i4] == iArr[i4 - 1] + 1);
            int i52 = i4 - 1;
            oVar.f50577b = iArr[i52];
            vector.addElement(oVar);
            i4 = i52 + 1;
        }
        o[] oVarArr = new o[vector.size()];
        vector.copyInto(oVarArr);
        return oVarArr;
    }

    public static int c(o[] oVarArr) {
        if (oVarArr == null) {
            return 0;
        }
        int i4 = 0;
        for (o oVar : oVarArr) {
            i4 += oVar.b();
        }
        return i4;
    }

    public static String d(o[] oVarArr) {
        if (oVarArr == null || oVarArr.length == 0) {
            return null;
        }
        int i4 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = oVarArr.length;
        while (true) {
            int i5 = oVarArr[i4].f50576a;
            int i6 = oVarArr[i4].f50577b;
            if (i6 > i5) {
                stringBuffer.append(i5);
                stringBuffer.append(':');
                stringBuffer.append(i6);
            } else {
                stringBuffer.append(i5);
            }
            i4++;
            if (i4 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public int b() {
        return (this.f50577b - this.f50576a) + 1;
    }

    public o(int i4, int i5) {
        this.f50576a = i4;
        this.f50577b = i5;
    }
}
