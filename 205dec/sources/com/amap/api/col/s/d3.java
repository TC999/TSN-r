package com.amap.api.col.s;

import com.amap.api.col.s.r2;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LogEngine.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d3 {
    public static int a(c3 c3Var) {
        r2 r2Var = null;
        try {
            try {
                if (c3Var.f9704f.e()) {
                    c3Var.f9704f.b(true);
                    r2 b4 = r2.b(new File(c3Var.f9699a), c3Var.f9700b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] e4 = e(b4, c3Var, arrayList);
                        if (e4 != null && e4.length != 0) {
                            f2 f2Var = new f2(e4, c3Var.f9701c);
                            u2.b();
                            JSONObject jSONObject = new JSONObject(new String(u2.d(f2Var).f9643a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                v3 v3Var = c3Var.f9704f;
                                if (v3Var != null) {
                                    v3Var.a(e4.length);
                                }
                                if (c3Var.f9704f.d() < Integer.MAX_VALUE) {
                                    b(b4, arrayList);
                                } else {
                                    b4.q();
                                }
                                return e4.length;
                            }
                            r2Var = b4;
                        }
                        try {
                            b4.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        r2Var = b4;
                        try {
                            g2.o(th, "leg", "uts");
                            if (r2Var != null) {
                                r2Var.close();
                            }
                            return -1;
                        } catch (Throwable th3) {
                            if (r2Var != null) {
                                try {
                                    r2Var.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
            if (r2Var != null) {
                r2Var.close();
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    private static void b(r2 r2Var, List<String> list) {
        if (r2Var != null) {
            try {
                for (String str : list) {
                    r2Var.s(str);
                }
                r2Var.close();
            } catch (Throwable th) {
                g2.o(th, "ofm", "dlo");
            }
        }
    }

    public static void c(String str, byte[] bArr, c3 c3Var) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        r2 r2Var;
        OutputStream outputStream = null;
        try {
            if (d(c3Var.f9699a, str)) {
                return;
            }
            File file = new File(c3Var.f9699a);
            if (!file.exists()) {
                file.mkdirs();
            }
            r2Var = r2.b(file, c3Var.f9700b);
            try {
                r2Var.f(c3Var.f9702d);
                byte[] b4 = c3Var.f9703e.b(bArr);
                r2.d l4 = r2Var.l(str);
                outputStream = l4.b();
                outputStream.write(b4);
                l4.c();
                r2Var.m();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    r2Var.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (r2Var != null) {
                    try {
                        r2Var.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r2Var = null;
        }
    }

    private static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            g2.o(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] e(r2 r2Var, c3 c3Var, List<String> list) {
        String[] list2;
        try {
            File d4 = r2Var.d();
            if (d4 != null && d4.exists()) {
                int i4 = 0;
                for (String str : d4.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] f4 = i3.f(r2Var, str2);
                        i4 += f4.length;
                        list.add(str2);
                        if (i4 > c3Var.f9704f.d()) {
                            break;
                        }
                        c3Var.f9705g.c(f4);
                    }
                }
                if (i4 <= 0) {
                    return null;
                }
                return c3Var.f9705g.a();
            }
        } catch (Throwable th) {
            g2.o(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
