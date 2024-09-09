package com.github.barteksc.pdfviewer.util;

import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ArrayUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {
    private a() {
    }

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i4 = 0; i4 < iArr.length; i4++) {
            sb.append(iArr[i4]);
            if (i4 != iArr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[] b(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length == 0) {
            return iArr2;
        }
        int i4 = 0;
        iArr2[0] = 0;
        for (int i5 = 1; i5 < iArr.length; i5++) {
            if (iArr[i5] != iArr[i5 - 1]) {
                i4++;
            }
            iArr2[i5] = i4;
        }
        return iArr2;
    }

    public static int[] c(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        for (int i5 : iArr) {
            Integer valueOf = Integer.valueOf(i5);
            if (i4 != valueOf.intValue()) {
                arrayList.add(valueOf);
            }
            i4 = valueOf.intValue();
        }
        int[] iArr2 = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }
}
