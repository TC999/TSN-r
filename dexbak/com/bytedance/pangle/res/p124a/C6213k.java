package com.bytedance.pangle.res.p124a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.bytedance.pangle.res.a.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6213k {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m36969a(C6209g c6209g) {
        return (int) c6209g.f22173a.m36975a().m36982b();
    }

    /* renamed from: a */
    private static byte[] m36971a(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m36968a(byte[] bArr, int i, int i2, InterfaceC6210h interfaceC6210h) {
        if (i >= 2130706432) {
            int mo36977a = interfaceC6210h.mo36977a(i);
            byte[] m36971a = m36971a(mo36977a);
            bArr[i2] = m36971a[0];
            bArr[i2 + 1] = m36971a[1];
            bArr[i2 + 2] = m36971a[2];
            bArr[i2 + 3] = m36971a[3];
            return mo36977a;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m36967a(byte[] bArr, InterfaceC6210h interfaceC6210h) {
        C6202b c6202b = new C6202b(bArr, interfaceC6210h);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        c6202b.m36995a();
        c6202b.f22149c = new C6209g(new C6211i(new C6207e(byteArrayInputStream)));
        do {
        } while (c6202b.m36994b() != 1);
    }

    /* renamed from: a */
    public static void m36970a(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (hashMap.containsKey(Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                hashMap2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i7, i7 + 20));
                hashMap3.put(Integer.valueOf(hashMap.get(Integer.valueOf(i6)).intValue()), Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) hashMap2.get(Integer.valueOf(((Integer) hashMap3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }
}
