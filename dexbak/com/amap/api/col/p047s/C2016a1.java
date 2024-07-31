package com.amap.api.col.p047s;

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

/* compiled from: ClientInfo.java */
/* renamed from: com.amap.api.col.s.a1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2016a1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientInfo.java */
    /* renamed from: com.amap.api.col.s.a1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2017a {

        /* renamed from: A */
        String f5849A;

        /* renamed from: a */
        String f5850a;

        /* renamed from: b */
        String f5851b;

        /* renamed from: c */
        String f5852c;

        /* renamed from: d */
        String f5853d;

        /* renamed from: e */
        String f5854e;

        /* renamed from: f */
        String f5855f;

        /* renamed from: g */
        String f5856g;

        /* renamed from: h */
        String f5857h;

        /* renamed from: i */
        String f5858i;

        /* renamed from: j */
        String f5859j;

        /* renamed from: k */
        String f5860k;

        /* renamed from: l */
        String f5861l;

        /* renamed from: m */
        String f5862m;

        /* renamed from: n */
        String f5863n;

        /* renamed from: o */
        String f5864o;

        /* renamed from: p */
        String f5865p;

        /* renamed from: q */
        String f5866q;

        /* renamed from: r */
        String f5867r;

        /* renamed from: s */
        String f5868s;

        /* renamed from: t */
        String f5869t;

        /* renamed from: u */
        String f5870u;

        /* renamed from: v */
        String f5871v;

        /* renamed from: w */
        String f5872w;

        /* renamed from: x */
        String f5873x;

        /* renamed from: y */
        String f5874y;

        /* renamed from: z */
        String f5875z;

        private C2017a() {
        }

        /* synthetic */ C2017a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static String m53275a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = C2199x0.m52333c() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "CI", "TS");
            return null;
        }
    }

    /* renamed from: b */
    public static String m53274b(Context context) {
        return m53267i(context);
    }

    /* renamed from: c */
    public static String m53273c(Context context, String str, String str2) {
        try {
            String m52328h = C2199x0.m52328h(context);
            return C2059g1.m52992a(m52328h + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "CI", "Sco");
            return null;
        }
    }

    /* renamed from: d */
    private static String m53272d(C2017a c2017a) {
        return C2040d1.m53091f(m53266j(c2017a));
    }

    /* renamed from: e */
    private static void m53271e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            C2079j1.m52867j(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, C2079j1.m52862o(str));
        } else {
            C2079j1.m52867j(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* renamed from: f */
    public static byte[] m53270f(Context context, boolean z) {
        try {
            return m53266j(m53268h(context, z));
        } catch (Throwable th) {
            C2041d2.m53085e(th, "CI", "gz");
            return null;
        }
    }

    /* renamed from: g */
    public static byte[] m53269g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return C2040d1.m53095b(bArr);
    }

    /* renamed from: h */
    private static C2017a m53268h(Context context, boolean z) {
        C2017a c2017a = new C2017a((byte) 0);
        c2017a.f5850a = C2023c1.m53196H();
        c2017a.f5851b = C2023c1.m53201C();
        String m53149y = C2023c1.m53149y(context);
        if (m53149y == null) {
            m53149y = "";
        }
        c2017a.f5852c = m53149y;
        c2017a.f5853d = C2199x0.m52330f(context);
        c2017a.f5854e = Build.MODEL;
        c2017a.f5855f = Build.MANUFACTURER;
        c2017a.f5856g = Build.DEVICE;
        c2017a.f5857h = C2199x0.m52332d(context);
        c2017a.f5858i = C2199x0.m52329g(context);
        c2017a.f5859j = String.valueOf(Build.VERSION.SDK_INT);
        c2017a.f5860k = C2023c1.m53191M();
        c2017a.f5861l = C2023c1.m53197G(context);
        StringBuilder sb = new StringBuilder();
        sb.append(C2023c1.m53200D(context));
        c2017a.f5862m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C2023c1.m53202B(context));
        c2017a.f5863n = sb2.toString();
        c2017a.f5864o = C2023c1.m53189O(context);
        c2017a.f5865p = C2023c1.m53203A(context);
        c2017a.f5866q = "";
        c2017a.f5867r = "";
        String[] m53199E = C2023c1.m53199E();
        c2017a.f5868s = m53199E[0];
        c2017a.f5869t = m53199E[1];
        c2017a.f5872w = C2023c1.m53165i();
        String m53164j = C2023c1.m53164j(context);
        if (!TextUtils.isEmpty(m53164j)) {
            c2017a.f5873x = m53164j;
        } else {
            c2017a.f5873x = "";
        }
        c2017a.f5874y = "aid=" + C2023c1.m53148z();
        if ((z && C2139s1.f6470e) || C2139s1.f6471f) {
            String m53151w = C2023c1.m53151w(context);
            if (!TextUtils.isEmpty(m53151w)) {
                c2017a.f5874y += "|oaid=" + m53151w;
            }
        }
        String m53198F = C2023c1.m53198F();
        if (!TextUtils.isEmpty(m53198F)) {
            c2017a.f5874y += "|multiImeis=" + m53198F;
        }
        String m53194J = C2023c1.m53194J();
        if (!TextUtils.isEmpty(m53194J)) {
            c2017a.f5874y += "|meid=" + m53194J;
        }
        c2017a.f5874y += "|serial=" + C2023c1.m53150x();
        String m53159o = C2023c1.m53159o();
        if (!TextUtils.isEmpty(m53159o)) {
            c2017a.f5874y += "|adiuExtras=" + m53159o;
        }
        c2017a.f5874y += "|storage=" + C2023c1.m53190N() + "|ram=" + C2023c1.m53192L(context) + "|arch=" + C2023c1.m53188P();
        String m53075b = C2031c2.m53146a().m53075b();
        if (!TextUtils.isEmpty(m53075b)) {
            c2017a.f5875z = m53075b;
        } else {
            c2017a.f5875z = "";
        }
        return c2017a;
    }

    /* renamed from: i */
    private static String m53267i(Context context) {
        try {
            return m53272d(m53268h(context, false));
        } catch (Throwable th) {
            C2041d2.m53085e(th, "CI", "gCXi");
            return null;
        }
    }

    /* renamed from: j */
    private static byte[] m53266j(C2017a c2017a) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            m53271e(byteArrayOutputStream, c2017a.f5850a);
            m53271e(byteArrayOutputStream, c2017a.f5851b);
            m53271e(byteArrayOutputStream, c2017a.f5852c);
            m53271e(byteArrayOutputStream, c2017a.f5853d);
            m53271e(byteArrayOutputStream, c2017a.f5854e);
            m53271e(byteArrayOutputStream, c2017a.f5855f);
            m53271e(byteArrayOutputStream, c2017a.f5856g);
            m53271e(byteArrayOutputStream, c2017a.f5857h);
            m53271e(byteArrayOutputStream, c2017a.f5858i);
            m53271e(byteArrayOutputStream, c2017a.f5859j);
            m53271e(byteArrayOutputStream, c2017a.f5860k);
            m53271e(byteArrayOutputStream, c2017a.f5861l);
            m53271e(byteArrayOutputStream, c2017a.f5862m);
            m53271e(byteArrayOutputStream, c2017a.f5863n);
            m53271e(byteArrayOutputStream, c2017a.f5864o);
            m53271e(byteArrayOutputStream, c2017a.f5865p);
            m53271e(byteArrayOutputStream, c2017a.f5866q);
            m53271e(byteArrayOutputStream, c2017a.f5867r);
            m53271e(byteArrayOutputStream, c2017a.f5868s);
            m53271e(byteArrayOutputStream, c2017a.f5869t);
            m53271e(byteArrayOutputStream, c2017a.f5870u);
            m53271e(byteArrayOutputStream, c2017a.f5871v);
            m53271e(byteArrayOutputStream, c2017a.f5872w);
            m53271e(byteArrayOutputStream, c2017a.f5873x);
            m53271e(byteArrayOutputStream, c2017a.f5874y);
            m53271e(byteArrayOutputStream, c2017a.f5875z);
            m53271e(byteArrayOutputStream, c2017a.f5849A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] m53265k = m53265k(C2079j1.m52858s(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return m53265k;
        } catch (Throwable th3) {
            th = th3;
            try {
                C2041d2.m53085e(th, "CI", "gzx");
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
    private static byte[] m53265k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey m52854w = C2079j1.m52854w();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] m53094c = C2040d1.m53094c(bArr2, m52854w);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(m53094c, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return C2040d1.m53094c(bArr, m52854w);
    }
}
