package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g implements c.b<Set<String>> {
    static final g aSg = new g();

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i4 = 0;
        int i5 = 0;
        for (String str : set) {
            if (str == null) {
                i4 += 5;
                iArr[i5] = -1;
            } else {
                int he = b.he(str);
                strArr[i5] = str;
                iArr[i5] = he;
                i4 += b.eg(he) + he;
            }
            i5++;
        }
        b bVar = new b(i4);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            bVar.ef(i7);
            if (i7 >= 0) {
                bVar.hd(strArr[i6]);
            }
        }
        return bVar.aRo;
    }

    private static Set<String> h(byte[] bArr, int i4, int i5) {
        int i6;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i5 > 0) {
            b bVar = new b(bArr, i4);
            int i7 = i4 + i5;
            while (true) {
                i6 = bVar.position;
                if (i6 >= i7) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Nt()));
            }
            if (i6 != i7) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String NN() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i4, int i5) {
        return h(bArr, i4, i5);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] m(Set<String> set) {
        return e(set);
    }
}
