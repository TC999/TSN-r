package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.n6;
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
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LogEngine.java */
/* renamed from: com.amap.api.col.3l.c7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c7 {

    /* compiled from: MarkInfoManager.java */
    /* renamed from: com.amap.api.col.3l.c7$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7323a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f7324b;

        a(String str, Context context) {
            this.f7323a = str;
            this.f7324b = context;
        }

        /* JADX WARN: Type inference failed for: r3v8, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.h6] */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.k6] */
        /* JADX WARN: Type inference failed for: r5v3, types: [com.amap.api.col.3l.i6, com.amap.api.col.3l.j6] */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (c7.class) {
                try {
                    String b4 = l4.b(p4.o(this.f7323a));
                    a7 a4 = h7.a(c7.a);
                    h7.f(this.f7324b, a4, q5.j, 50, 102400, "10");
                    if (a4.e == null) {
                        a4.e = new h6((i6) new k6((i6) new j6()));
                    }
                    String c4 = p4.c(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                    b7.c(b4, p4.o(" \"timestamp\":\"" + c4 + "\",\"details\":" + this.f7323a), a4);
                }
            }
        }
    }

    public static int a(b7 b7Var) {
        n6 n6Var = null;
        try {
            try {
                if (b7Var.f7269f.e()) {
                    b7Var.f7269f.c(true);
                    n6 b4 = n6.b(new File(b7Var.f7264a), b7Var.f7265b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] e4 = e(b4, b7Var, arrayList);
                        if (e4 != null && e4.length != 0) {
                            s5 s5Var = new s5(e4, b7Var.f7266c);
                            q6.b();
                            JSONObject jSONObject = new JSONObject(new String(q6.d(s5Var).f9524a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                w7 w7Var = b7Var.f7269f;
                                if (w7Var != null) {
                                    w7Var.b(e4.length);
                                }
                                if (b7Var.f7269f.a() < Integer.MAX_VALUE) {
                                    b(b4, arrayList);
                                } else {
                                    b4.s();
                                }
                                return e4.length;
                            }
                            n6Var = b4;
                        }
                        try {
                            b4.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        n6Var = b4;
                        try {
                            u5.p(th, "leg", "uts");
                            if (n6Var != null) {
                                n6Var.close();
                            }
                            return -1;
                        } catch (Throwable th3) {
                            if (n6Var != null) {
                                try {
                                    n6Var.close();
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
            if (n6Var != null) {
                n6Var.close();
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    private static void b(n6 n6Var, List<String> list) {
        if (n6Var != null) {
            try {
                for (String str : list) {
                    n6Var.q(str);
                }
                n6Var.close();
            } catch (Throwable th) {
                u5.p(th, "ofm", "dlo");
            }
        }
    }

    public static void c(String str, byte[] bArr, b7 b7Var) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        n6 n6Var;
        OutputStream outputStream = null;
        try {
            if (d(b7Var.f7264a, str)) {
                return;
            }
            File file = new File(b7Var.f7264a);
            if (!file.exists()) {
                file.mkdirs();
            }
            n6Var = n6.b(file, b7Var.f7265b);
            try {
                n6Var.e(b7Var.f7267d);
                byte[] b4 = b7Var.f7268e.b(bArr);
                n6.d k4 = n6Var.k(str);
                outputStream = k4.b();
                outputStream.write(b4);
                k4.c();
                n6Var.o();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    n6Var.close();
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
                if (n6Var != null) {
                    try {
                        n6Var.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            n6Var = null;
        }
    }

    private static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            u5.p(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] e(n6 n6Var, b7 b7Var, List<String> list) {
        String[] list2;
        try {
            File l4 = n6Var.l();
            if (l4 != null && l4.exists()) {
                int i4 = 0;
                for (String str : l4.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] g4 = i7.g(n6Var, str2);
                        i4 += g4.length;
                        list.add(str2);
                        if (i4 > b7Var.f7269f.a()) {
                            break;
                        }
                        b7Var.f7270g.c(g4);
                    }
                }
                if (i4 <= 0) {
                    return null;
                }
                return b7Var.f7270g.a();
            }
        } catch (Throwable th) {
            u5.p(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
