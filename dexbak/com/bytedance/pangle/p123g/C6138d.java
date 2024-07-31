package com.bytedance.pangle.p123g;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.p115b.p117b.C6068a;
import com.bytedance.pangle.p123g.C6134c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

@RequiresApi(api = 21)
/* renamed from: com.bytedance.pangle.g.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6138d {
    /* renamed from: a */
    public static C6153o m37130a(String str) {
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
                    C6140f.m37124a(str, randomAccessFile, -262969152, 1896449818);
                    try {
                        try {
                            try {
                                C6151m c6151m = C6140f.f22022a.get(str).get(-262969152);
                                if (c6151m != null) {
                                    C6134c.C6137c m37134a = C6134c.m37134a(randomAccessFile, c6151m);
                                    Signature[] m37129a = m37129a(new Certificate[][]{m37134a.f22019a});
                                    C6134c.C6136b c6136b = m37134a.f22020b;
                                    if (c6136b != null) {
                                        int size = c6136b.f22017a.size();
                                        Signature[] signatureArr2 = new Signature[size];
                                        iArr = new int[m37134a.f22020b.f22018b.size()];
                                        for (int i = 0; i < size; i++) {
                                            signatureArr2[i] = new Signature(m37134a.f22020b.f22017a.get(i).getEncoded());
                                            iArr[i] = m37134a.f22020b.f22018b.get(i).intValue();
                                        }
                                        signatureArr = signatureArr2;
                                    } else {
                                        iArr = null;
                                    }
                                    C6153o c6153o = new C6153o(m37129a, 3, signatureArr, iArr);
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused) {
                                    }
                                    return c6153o;
                                }
                                throw new C6152n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            } catch (C6152n unused2) {
                                C6151m c6151m2 = C6140f.f22022a.get(str).get(1896449818);
                                if (c6151m2 != null) {
                                    C6153o c6153o2 = new C6153o(m37129a(C6132b.m37137a(randomAccessFile, c6151m2).f22015a));
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused3) {
                                    }
                                    return c6153o2;
                                }
                                throw new C6152n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            } catch (Exception e) {
                                throw new C6155q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e);
                            }
                        } catch (C6152n unused4) {
                            C6153o m37140a = C6131a.m37140a(str);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused5) {
                            }
                            return m37140a;
                        }
                    } catch (Exception e2) {
                        throw new C6155q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e2);
                    }
                } catch (Exception e3) {
                    throw new C6155q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e3);
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
            throw new C6155q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
        }
    }

    /* renamed from: a */
    public static Signature[] m37129a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21 && i2 <= 28) {
                Constructor m37257a = C6068a.m37257a(Signature.class, Certificate[].class);
                if (m37257a != null) {
                    m37257a.setAccessible(true);
                }
                if (m37257a != null && m37257a.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) m37257a.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
