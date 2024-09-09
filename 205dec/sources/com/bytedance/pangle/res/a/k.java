package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(g gVar) {
        return (int) gVar.f28934a.a().b();
    }

    private static byte[] a(int i4) {
        return new byte[]{(byte) (i4 >> 0), (byte) (i4 >> 8), (byte) (i4 >> 16), (byte) (i4 >> 24)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i4, int i5, h hVar) {
        if (i4 >= 2130706432) {
            int a4 = hVar.a(i4);
            byte[] a5 = a(a4);
            bArr[i5] = a5[0];
            bArr[i5 + 1] = a5[1];
            bArr[i5 + 2] = a5[2];
            bArr[i5 + 3] = a5[3];
            return a4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, h hVar) {
        b bVar = new b(bArr, hVar);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bVar.a();
        bVar.f28910c = new g(new i(new e(byteArrayInputStream)));
        do {
        } while (bVar.b() != 1);
    }

    public static void a(int i4, byte[] bArr, int[] iArr, int i5, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i6 = -1;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * 5;
            int i9 = iArr[i8 + 1];
            if (hashMap.containsKey(Integer.valueOf(i9))) {
                if (i6 == -1) {
                    i6 = i7;
                }
                int i10 = (i8 * 4) + i4;
                hashMap2.put(Integer.valueOf(i7), Arrays.copyOfRange(bArr, i10, i10 + 20));
                hashMap3.put(Integer.valueOf(hashMap.get(Integer.valueOf(i9)).intValue()), Integer.valueOf(i7));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) hashMap2.get(Integer.valueOf(((Integer) hashMap3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i11 + i6) * 5 * 4) + i4, bArr2.length);
            i11++;
        }
    }
}
