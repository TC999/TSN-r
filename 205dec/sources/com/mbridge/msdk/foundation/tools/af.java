package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringSetEncoder.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class af implements FastKV.a<Set<String>> {

    /* renamed from: a  reason: collision with root package name */
    static final af f39768a = new af();

    private af() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final String a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ byte[] a(Set<String> set) {
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i4 = 0;
        int i5 = 0;
        for (String str : set2) {
            if (str == null) {
                i4 += 5;
                iArr[i5] = -1;
            } else {
                int b4 = j.b(str);
                strArr[i5] = str;
                iArr[i5] = b4;
                i4 += ((b4 >> 7) == 0 ? 1 : (b4 >> 14) == 0 ? 2 : (b4 >> 21) == 0 ? 3 : (b4 >> 28) == 0 ? 4 : 5) + b4;
            }
            i5++;
        }
        j jVar = new j(i4);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            int i8 = jVar.f39858b;
            int i9 = i7;
            while ((i9 & (-128)) != 0) {
                jVar.f39857a[i8] = (byte) ((i9 & 127) | 128);
                i9 >>>= 7;
                i8++;
            }
            jVar.f39857a[i8] = (byte) i9;
            jVar.f39858b = i8 + 1;
            if (i7 >= 0) {
                jVar.a(strArr[i6]);
            }
        }
        return jVar.f39857a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ Set<String> a(byte[] bArr, int i4, int i5) {
        int i6;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i5 > 0) {
            j jVar = new j(bArr, i4);
            int i7 = i4 + i5;
            while (true) {
                i6 = jVar.f39858b;
                if (i6 >= i7) {
                    break;
                }
                byte[] bArr2 = jVar.f39857a;
                int i8 = i6 + 1;
                jVar.f39858b = i8;
                int i9 = bArr2[i6];
                if ((i9 >> 7) != 0) {
                    int i10 = i8 + 1;
                    jVar.f39858b = i10;
                    i9 = (i9 & 127) | (bArr2[i8] << 7);
                    if ((i9 >> 14) != 0) {
                        int i11 = i10 + 1;
                        jVar.f39858b = i11;
                        i9 = (i9 & 16383) | (bArr2[i10] << 14);
                        if ((i9 >> 21) != 0) {
                            int i12 = i11 + 1;
                            jVar.f39858b = i12;
                            i9 = (i9 & 2097151) | (bArr2[i11] << 21);
                            if ((i9 >> 28) != 0) {
                                jVar.f39858b = i12 + 1;
                                i9 = (i9 & 268435455) | (bArr2[i12] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(jVar.b(i9));
            }
            if (i6 != i7) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
