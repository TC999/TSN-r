package com.amap.api.col.p047s;

import com.amap.api.col.p047s.C2129r2;
import com.baidu.mobads.sdk.api.IAdInterListener;
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

/* compiled from: LogEngine.java */
/* renamed from: com.amap.api.col.s.d3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2042d3 {
    /* renamed from: a */
    public static int m53084a(C2032c3 c2032c3) {
        C2129r2 c2129r2 = null;
        try {
            try {
                if (c2032c3.f5976f.m52378e()) {
                    c2032c3.f5976f.mo52380b(true);
                    C2129r2 m52615b = C2129r2.m52615b(new File(c2032c3.f5971a), c2032c3.f5972b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] m53080e = m53080e(m52615b, c2032c3, arrayList);
                        if (m53080e != null && m53080e.length != 0) {
                            C2055f2 c2055f2 = new C2055f2(m53080e, c2032c3.f5973c);
                            C2163u2.m52429b();
                            JSONObject jSONObject = new JSONObject(new String(C2163u2.m52427d(c2055f2).f5893a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                AbstractC2189v3 abstractC2189v3 = c2032c3.f5976f;
                                if (abstractC2189v3 != null) {
                                    abstractC2189v3.mo52381a(m53080e.length);
                                }
                                if (c2032c3.f5976f.mo52379d() < Integer.MAX_VALUE) {
                                    m53083b(m52615b, arrayList);
                                } else {
                                    m52615b.m52602p();
                                }
                                return m53080e.length;
                            }
                            c2129r2 = m52615b;
                        }
                        try {
                            m52615b.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        c2129r2 = m52615b;
                        try {
                            C2060g2.m52972o(th, "leg", "uts");
                            if (c2129r2 != null) {
                                c2129r2.close();
                            }
                            return -1;
                        } catch (Throwable th3) {
                            if (c2129r2 != null) {
                                try {
                                    c2129r2.close();
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
            if (c2129r2 != null) {
                c2129r2.close();
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    /* renamed from: b */
    private static void m53083b(C2129r2 c2129r2, List<String> list) {
        if (c2129r2 != null) {
            try {
                for (String str : list) {
                    c2129r2.m52600r(str);
                }
                c2129r2.close();
            } catch (Throwable th) {
                C2060g2.m52972o(th, "ofm", "dlo");
            }
        }
    }

    /* renamed from: c */
    public static void m53082c(String str, byte[] bArr, C2032c3 c2032c3) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        C2129r2 c2129r2;
        OutputStream outputStream = null;
        try {
            if (m53081d(c2032c3.f5971a, str)) {
                return;
            }
            File file = new File(c2032c3.f5971a);
            if (!file.exists()) {
                file.mkdirs();
            }
            c2129r2 = C2129r2.m52615b(file, c2032c3.f5972b);
            try {
                c2129r2.m52612e(c2032c3.f5974d);
                byte[] m52733b = c2032c3.f5975e.m52733b(bArr);
                C2129r2.C2133d m52606k = c2129r2.m52606k(str);
                outputStream = m52606k.m52596b();
                outputStream.write(m52733b);
                m52606k.m52595c();
                c2129r2.m52605l();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    c2129r2.close();
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
                if (c2129r2 != null) {
                    try {
                        c2129r2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            c2129r2 = null;
        }
    }

    /* renamed from: d */
    private static boolean m53081d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            C2060g2.m52972o(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }

    /* renamed from: e */
    private static byte[] m53080e(C2129r2 c2129r2, C2032c3 c2032c3, List<String> list) {
        String[] list2;
        try {
            File m52614c = c2129r2.m52614c();
            if (m52614c != null && m52614c.exists()) {
                int i = 0;
                for (String str : m52614c.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] m52896f = C2076i3.m52896f(c2129r2, str2);
                        i += m52896f.length;
                        list.add(str2);
                        if (i > c2032c3.f5976f.mo52379d()) {
                            break;
                        }
                        c2032c3.f5977g.mo52692c(m52896f);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return c2032c3.f5977g.m52693a();
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
