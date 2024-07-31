package com.kwad.sdk.utils.p450a;

import com.kwad.sdk.utils.p450a.C10990c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.utils.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11003g implements C10990c.InterfaceC10994b<Set<String>> {
    static final C11003g aSg = new C11003g();

    private C11003g() {
    }

    /* renamed from: e */
    private static byte[] m24169e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int m24248he = C10989b.m24248he(str);
                strArr[i2] = str;
                iArr[i2] = m24248he;
                i += C10989b.m24255eg(m24248he) + m24248he;
            }
            i2++;
        }
        C10989b c10989b = new C10989b(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            c10989b.m24256ef(i4);
            if (i4 >= 0) {
                c10989b.m24249hd(strArr[i3]);
            }
        }
        return c10989b.aRo;
    }

    /* renamed from: h */
    private static Set<String> m24167h(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            C10989b c10989b = new C10989b(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = c10989b.position;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(c10989b.getString(c10989b.m24261Nt()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10994b
    /* renamed from: NN */
    public final String mo24170NN() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10994b
    /* renamed from: g */
    public final /* synthetic */ Set<String> mo24168g(byte[] bArr, int i, int i2) {
        return m24167h(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.p450a.C10990c.InterfaceC10994b
    /* renamed from: m */
    public final /* synthetic */ byte[] mo24166m(Set<String> set) {
        return m24169e(set);
    }
}
