package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f28803a = new o(null, 0, null, null, null);
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Signature[] f28804b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28805c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final ArraySet<PublicKey> f28806d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Signature[] f28807e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final int[] f28808f;

    public o(Signature[] signatureArr, int i4, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f28804b = signatureArr;
        this.f28805c = i4;
        this.f28806d = arraySet;
        this.f28807e = signatureArr2;
        this.f28808f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f28805c == oVar.f28805c && a(this.f28804b, oVar.f28804b)) {
                ArraySet<PublicKey> arraySet = this.f28806d;
                if (arraySet != null) {
                    if (!arraySet.equals(oVar.f28806d)) {
                        return false;
                    }
                } else if (oVar.f28806d != null) {
                    return false;
                }
                return Arrays.equals(this.f28807e, oVar.f28807e) && Arrays.equals(this.f28808f, oVar.f28808f);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f28804b) * 31) + this.f28805c) * 31;
        ArraySet<PublicKey> arraySet = this.f28806d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f28807e)) * 31) + Arrays.hashCode(this.f28808f);
    }

    public o(Signature[] signatureArr, int i4, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i4, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }
}
