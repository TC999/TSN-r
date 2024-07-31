package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mbridge.msdk.foundation.tools.af */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class StringSetEncoder implements FastKV.InterfaceC11395a<Set<String>> {

    /* renamed from: a */
    static final StringSetEncoder f30995a = new StringSetEncoder();

    private StringSetEncoder() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.InterfaceC11395a
    /* renamed from: a */
    public final String mo21960a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.InterfaceC11395a
    /* renamed from: a */
    public final /* synthetic */ byte[] mo21959a(Set<String> set) {
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set2) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int m21851b = FastBuffer.m21851b(str);
                strArr[i2] = str;
                iArr[i2] = m21851b;
                i += ((m21851b >> 7) == 0 ? 1 : (m21851b >> 14) == 0 ? 2 : (m21851b >> 21) == 0 ? 3 : (m21851b >> 28) == 0 ? 4 : 5) + m21851b;
            }
            i2++;
        }
        FastBuffer fastBuffer = new FastBuffer(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            int i5 = fastBuffer.f31085b;
            int i6 = i4;
            while ((i6 & (-128)) != 0) {
                fastBuffer.f31084a[i5] = (byte) ((i6 & 127) | 128);
                i6 >>>= 7;
                i5++;
            }
            fastBuffer.f31084a[i5] = (byte) i6;
            fastBuffer.f31085b = i5 + 1;
            if (i4 >= 0) {
                fastBuffer.m21857a(strArr[i3]);
            }
        }
        return fastBuffer.f31084a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.InterfaceC11395a
    /* renamed from: a */
    public final /* synthetic */ Set<String> mo21958a(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            FastBuffer fastBuffer = new FastBuffer(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = fastBuffer.f31085b;
                if (i3 >= i4) {
                    break;
                }
                byte[] bArr2 = fastBuffer.f31084a;
                int i5 = i3 + 1;
                fastBuffer.f31085b = i5;
                int i6 = bArr2[i3];
                if ((i6 >> 7) != 0) {
                    int i7 = i5 + 1;
                    fastBuffer.f31085b = i7;
                    i6 = (i6 & 127) | (bArr2[i5] << 7);
                    if ((i6 >> 14) != 0) {
                        int i8 = i7 + 1;
                        fastBuffer.f31085b = i8;
                        i6 = (i6 & 16383) | (bArr2[i7] << 14);
                        if ((i6 >> 21) != 0) {
                            int i9 = i8 + 1;
                            fastBuffer.f31085b = i9;
                            i6 = (i6 & 2097151) | (bArr2[i8] << 21);
                            if ((i6 >> 28) != 0) {
                                fastBuffer.f31085b = i9 + 1;
                                i6 = (i6 & 268435455) | (bArr2[i9] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(fastBuffer.m21853b(i6));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
