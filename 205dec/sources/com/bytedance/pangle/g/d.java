package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.g.c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@RequiresApi(api = 21)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d {
    public static o a(String str) {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    f.a(str, randomAccessFile, -262969152, 1896449818);
                    try {
                        try {
                            try {
                                m mVar = f.f28783a.get(str).get(-262969152);
                                if (mVar != null) {
                                    c.C0429c a4 = c.a(randomAccessFile, mVar);
                                    Signature[] a5 = a(new Certificate[][]{a4.f28780a});
                                    c.b bVar = a4.f28781b;
                                    if (bVar != null) {
                                        int size = bVar.f28778a.size();
                                        Signature[] signatureArr2 = new Signature[size];
                                        iArr = new int[a4.f28781b.f28779b.size()];
                                        for (int i4 = 0; i4 < size; i4++) {
                                            signatureArr2[i4] = new Signature(a4.f28781b.f28778a.get(i4).getEncoded());
                                            iArr[i4] = a4.f28781b.f28779b.get(i4).intValue();
                                        }
                                        signatureArr = signatureArr2;
                                    } else {
                                        iArr = null;
                                    }
                                    o oVar = new o(a5, 3, signatureArr, iArr);
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused) {
                                    }
                                    return oVar;
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            } catch (n unused2) {
                                m mVar2 = f.f28783a.get(str).get(1896449818);
                                if (mVar2 != null) {
                                    o oVar2 = new o(a(b.a(randomAccessFile, mVar2).f28776a));
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused3) {
                                    }
                                    return oVar2;
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            } catch (Exception e4) {
                                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
                            }
                        } catch (n unused4) {
                            o a6 = a.a(str);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused5) {
                            }
                            return a6;
                        }
                    } catch (Exception e5) {
                        throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e5);
                    }
                } catch (Exception e6) {
                    throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e6);
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception unused7) {
            throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i4 = 0; i4 < certificateArr.length; i4++) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21 && i5 <= 28) {
                Constructor a4 = com.bytedance.pangle.b.b.a.a(Signature.class, Certificate[].class);
                if (a4 != null) {
                    a4.setAccessible(true);
                }
                if (a4 != null && a4.isAccessible()) {
                    try {
                        signatureArr[i4] = (Signature) a4.newInstance(certificateArr[i4]);
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InstantiationException e5) {
                        e5.printStackTrace();
                    } catch (InvocationTargetException e6) {
                        e6.printStackTrace();
                    }
                }
            } else {
                signatureArr[i4] = new Signature(certificateArr[i4][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
