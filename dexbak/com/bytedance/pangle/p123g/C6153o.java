package com.bytedance.pangle.p123g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import com.bytedance.pangle.util.C6248d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* renamed from: com.bytedance.pangle.g.o */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6153o {

    /* renamed from: a */
    public static final C6153o f22042a = new C6153o(null, 0, null, null, null);
    @Nullable

    /* renamed from: b */
    public final Signature[] f22043b;

    /* renamed from: c */
    public final int f22044c;
    @Nullable

    /* renamed from: d */
    public final ArraySet<PublicKey> f22045d;
    @Nullable

    /* renamed from: e */
    public final Signature[] f22046e;
    @Nullable

    /* renamed from: f */
    public final int[] f22047f;

    public C6153o(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f22043b = signatureArr;
        this.f22044c = i;
        this.f22045d = arraySet;
        this.f22046e = signatureArr2;
        this.f22047f = iArr;
    }

    /* renamed from: a */
    private static ArraySet<PublicKey> m37096a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C6153o) {
            C6153o c6153o = (C6153o) obj;
            if (this.f22044c == c6153o.f22044c && m37095a(this.f22043b, c6153o.f22043b)) {
                ArraySet<PublicKey> arraySet = this.f22045d;
                if (arraySet != null) {
                    if (!arraySet.equals(c6153o.f22045d)) {
                        return false;
                    }
                } else if (c6153o.f22045d != null) {
                    return false;
                }
                return Arrays.equals(this.f22046e, c6153o.f22046e) && Arrays.equals(this.f22047f, c6153o.f22047f);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f22043b) * 31) + this.f22044c) * 31;
        ArraySet<PublicKey> arraySet = this.f22045d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22046e)) * 31) + Arrays.hashCode(this.f22047f);
    }

    public C6153o(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, m37096a(signatureArr), signatureArr2, iArr);
    }

    public C6153o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    /* renamed from: a */
    public static boolean m37095a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && C6248d.m36904a((Object[]) signatureArr, (Object[]) signatureArr2) && C6248d.m36904a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    /* renamed from: a */
    public static boolean m37097a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
