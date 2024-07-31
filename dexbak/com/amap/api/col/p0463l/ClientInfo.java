package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3l.g4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ClientInfo {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientInfo.java */
    /* renamed from: com.amap.api.col.3l.g4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1818a {

        /* renamed from: A */
        String f4244A;

        /* renamed from: a */
        String f4245a;

        /* renamed from: b */
        String f4246b;

        /* renamed from: c */
        String f4247c;

        /* renamed from: d */
        String f4248d;

        /* renamed from: e */
        String f4249e;

        /* renamed from: f */
        String f4250f;

        /* renamed from: g */
        String f4251g;

        /* renamed from: h */
        String f4252h;

        /* renamed from: i */
        String f4253i;

        /* renamed from: j */
        String f4254j;

        /* renamed from: k */
        String f4255k;

        /* renamed from: l */
        String f4256l;

        /* renamed from: m */
        String f4257m;

        /* renamed from: n */
        String f4258n;

        /* renamed from: o */
        String f4259o;

        /* renamed from: p */
        String f4260p;

        /* renamed from: q */
        String f4261q;

        /* renamed from: r */
        String f4262r;

        /* renamed from: s */
        String f4263s;

        /* renamed from: t */
        String f4264t;

        /* renamed from: u */
        String f4265u;

        /* renamed from: v */
        String f4266v;

        /* renamed from: w */
        String f4267w;

        /* renamed from: x */
        String f4268x;

        /* renamed from: y */
        String f4269y;

        /* renamed from: z */
        String f4270z;

        private C1818a() {
        }

        /* synthetic */ C1818a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static String m54933a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = C1780e4.m55246d() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "CI", "TS");
            return null;
        }
    }

    /* renamed from: b */
    public static String m54932b(Context context) {
        try {
            C1818a c1818a = new C1818a((byte) 0);
            c1818a.f4248d = C1780e4.m55243g(context);
            c1818a.f4253i = C1780e4.m55242h(context);
            return m54930d(c1818a);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "CI", "IX");
            return null;
        }
    }

    /* renamed from: c */
    public static String m54931c(Context context, String str, String str2) {
        try {
            String m55241i = C1780e4.m55241i(context);
            return C1849l4.m54583d(m55241i + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "CI", "Sco");
            return null;
        }
    }

    /* renamed from: d */
    private static String m54930d(C1818a c1818a) {
        return Encrypt.m54719f(m54924j(c1818a));
    }

    /* renamed from: e */
    private static void m54929e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            C1925p4.m54194j(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, C1925p4.m54189o(str));
        } else {
            C1925p4.m54194j(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* renamed from: f */
    public static byte[] m54928f(Context context, boolean z, boolean z2) {
        try {
            return m54924j(m54926h(context, z, z2));
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "CI", "gz");
            return null;
        }
    }

    /* renamed from: g */
    public static byte[] m54927g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return Encrypt.m54723b(bArr);
    }

    /* renamed from: h */
    private static C1818a m54926h(Context context, boolean z, boolean z2) {
        C1818a c1818a = new C1818a((byte) 0);
        c1818a.f4245a = DeviceInfo.m54806P();
        c1818a.f4246b = DeviceInfo.m54813I();
        String m54816F = DeviceInfo.m54816F(context);
        if (m54816F == null) {
            m54816F = "";
        }
        c1818a.f4247c = m54816F;
        c1818a.f4248d = C1780e4.m55243g(context);
        c1818a.f4249e = Build.MODEL;
        c1818a.f4250f = Build.MANUFACTURER;
        c1818a.f4251g = Build.DEVICE;
        c1818a.f4252h = C1780e4.m55245e(context);
        c1818a.f4253i = C1780e4.m55242h(context);
        c1818a.f4254j = String.valueOf(Build.VERSION.SDK_INT);
        c1818a.f4255k = DeviceInfo.m54801U();
        c1818a.f4256l = DeviceInfo.m54802T(context);
        StringBuilder sb = new StringBuilder();
        sb.append(DeviceInfo.m54809M(context));
        c1818a.f4257m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DeviceInfo.m54811K(context));
        c1818a.f4258n = sb2.toString();
        c1818a.f4259o = DeviceInfo.m54786e0(context);
        c1818a.f4260p = DeviceInfo.m54812J(context);
        c1818a.f4261q = "";
        c1818a.f4262r = "";
        if (z) {
            c1818a.f4263s = "";
            c1818a.f4264t = "";
        } else {
            String[] m54810L = DeviceInfo.m54810L();
            c1818a.f4263s = m54810L[0];
            c1818a.f4264t = m54810L[1];
        }
        c1818a.f4267w = DeviceInfo.m54770n();
        String m54769o = DeviceInfo.m54769o(context);
        if (!TextUtils.isEmpty(m54769o)) {
            c1818a.f4268x = m54769o;
        } else {
            c1818a.f4268x = "";
        }
        c1818a.f4269y = "aid=" + DeviceInfo.m54815G();
        if ((z2 && ConstConfig.f3921e) || ConstConfig.f3922f) {
            String m54818D = DeviceInfo.m54818D(context);
            if (!TextUtils.isEmpty(m54818D)) {
                c1818a.f4269y += "|oaid=" + m54818D;
            }
        }
        String m54808N = DeviceInfo.m54808N();
        if (!TextUtils.isEmpty(m54808N)) {
            c1818a.f4269y += "|multiImeis=" + m54808N;
        }
        String m54803S = DeviceInfo.m54803S();
        if (!TextUtils.isEmpty(m54803S)) {
            c1818a.f4269y += "|meid=" + m54803S;
        }
        c1818a.f4269y += "|serial=" + DeviceInfo.m54817E();
        String m54762v = DeviceInfo.m54762v();
        if (!TextUtils.isEmpty(m54762v)) {
            c1818a.f4269y += "|adiuExtras=" + m54762v;
        }
        c1818a.f4269y += "|storage=" + DeviceInfo.m54799W() + "|ram=" + DeviceInfo.m54790c0(context) + "|arch=" + DeviceInfo.m54797Y();
        String m54870b = RomIdentifier.m54381a().m54870b();
        if (!TextUtils.isEmpty(m54870b)) {
            c1818a.f4270z = m54870b;
        } else {
            c1818a.f4270z = "";
        }
        if (z) {
            String m53659b = AAIDManager.m53660a(context).m53659b();
            if (!TextUtils.isEmpty(m53659b)) {
                c1818a.f4244A = m53659b;
            }
        }
        return c1818a;
    }

    /* renamed from: i */
    public static String m54925i(Context context) {
        return m54922l(context);
    }

    /* renamed from: j */
    private static byte[] m54924j(C1818a c1818a) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            m54929e(byteArrayOutputStream, c1818a.f4245a);
            m54929e(byteArrayOutputStream, c1818a.f4246b);
            m54929e(byteArrayOutputStream, c1818a.f4247c);
            m54929e(byteArrayOutputStream, c1818a.f4248d);
            m54929e(byteArrayOutputStream, c1818a.f4249e);
            m54929e(byteArrayOutputStream, c1818a.f4250f);
            m54929e(byteArrayOutputStream, c1818a.f4251g);
            m54929e(byteArrayOutputStream, c1818a.f4252h);
            m54929e(byteArrayOutputStream, c1818a.f4253i);
            m54929e(byteArrayOutputStream, c1818a.f4254j);
            m54929e(byteArrayOutputStream, c1818a.f4255k);
            m54929e(byteArrayOutputStream, c1818a.f4256l);
            m54929e(byteArrayOutputStream, c1818a.f4257m);
            m54929e(byteArrayOutputStream, c1818a.f4258n);
            m54929e(byteArrayOutputStream, c1818a.f4259o);
            m54929e(byteArrayOutputStream, c1818a.f4260p);
            m54929e(byteArrayOutputStream, c1818a.f4261q);
            m54929e(byteArrayOutputStream, c1818a.f4262r);
            m54929e(byteArrayOutputStream, c1818a.f4263s);
            m54929e(byteArrayOutputStream, c1818a.f4264t);
            m54929e(byteArrayOutputStream, c1818a.f4265u);
            m54929e(byteArrayOutputStream, c1818a.f4266v);
            m54929e(byteArrayOutputStream, c1818a.f4267w);
            m54929e(byteArrayOutputStream, c1818a.f4268x);
            m54929e(byteArrayOutputStream, c1818a.f4269y);
            m54929e(byteArrayOutputStream, c1818a.f4270z);
            m54929e(byteArrayOutputStream, c1818a.f4244A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] m54923k = m54923k(C1925p4.m54184t(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return m54923k;
        } catch (Throwable th3) {
            th = th3;
            try {
                BasicLogHandler.m54177e(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private static byte[] m54923k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey m54180x = C1925p4.m54180x();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] m54722c = Encrypt.m54722c(bArr2, m54180x);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(m54722c, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return Encrypt.m54722c(bArr, m54180x);
    }

    /* renamed from: l */
    private static String m54922l(Context context) {
        try {
            return m54930d(m54926h(context, false, false));
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "CI", "gCXi");
            return null;
        }
    }
}
