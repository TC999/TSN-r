package com.amap.api.col.s;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ClientInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ClientInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {
        String A;

        /* renamed from: a  reason: collision with root package name */
        String f9600a;

        /* renamed from: b  reason: collision with root package name */
        String f9601b;

        /* renamed from: c  reason: collision with root package name */
        String f9602c;

        /* renamed from: d  reason: collision with root package name */
        String f9603d;

        /* renamed from: e  reason: collision with root package name */
        String f9604e;

        /* renamed from: f  reason: collision with root package name */
        String f9605f;

        /* renamed from: g  reason: collision with root package name */
        String f9606g;

        /* renamed from: h  reason: collision with root package name */
        String f9607h;

        /* renamed from: i  reason: collision with root package name */
        String f9608i;

        /* renamed from: j  reason: collision with root package name */
        String f9609j;

        /* renamed from: k  reason: collision with root package name */
        String f9610k;

        /* renamed from: l  reason: collision with root package name */
        String f9611l;

        /* renamed from: m  reason: collision with root package name */
        String f9612m;

        /* renamed from: n  reason: collision with root package name */
        String f9613n;

        /* renamed from: o  reason: collision with root package name */
        String f9614o;

        /* renamed from: p  reason: collision with root package name */
        String f9615p;

        /* renamed from: q  reason: collision with root package name */
        String f9616q;

        /* renamed from: r  reason: collision with root package name */
        String f9617r;

        /* renamed from: s  reason: collision with root package name */
        String f9618s;

        /* renamed from: t  reason: collision with root package name */
        String f9619t;

        /* renamed from: u  reason: collision with root package name */
        String f9620u;

        /* renamed from: v  reason: collision with root package name */
        String f9621v;

        /* renamed from: w  reason: collision with root package name */
        String f9622w;

        /* renamed from: x  reason: collision with root package name */
        String f9623x;

        /* renamed from: y  reason: collision with root package name */
        String f9624y;

        /* renamed from: z  reason: collision with root package name */
        String f9625z;

        private a() {
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = x0.c() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            d2.e(th, "CI", "TS");
            return null;
        }
    }

    public static String b(Context context) {
        return i(context);
    }

    public static String c(Context context, String str, String str2) {
        try {
            String h4 = x0.h(context);
            return g1.a(h4 + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            d2.e(th, "CI", "Sco");
            return null;
        }
    }

    private static String d(a aVar) {
        return d1.f(j(aVar));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            j1.j(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, j1.o(str));
        } else {
            j1.j(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    public static byte[] f(Context context, boolean z3) {
        try {
            return j(h(context, z3));
        } catch (Throwable th) {
            d2.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return d1.b(bArr);
    }

    private static a h(Context context, boolean z3) {
        a aVar = new a((byte) 0);
        aVar.f9600a = c1.H();
        aVar.f9601b = c1.C();
        String y3 = c1.y(context);
        if (y3 == null) {
            y3 = "";
        }
        aVar.f9602c = y3;
        aVar.f9603d = x0.f(context);
        aVar.f9604e = Build.MODEL;
        aVar.f9605f = Build.MANUFACTURER;
        aVar.f9606g = Build.DEVICE;
        aVar.f9607h = x0.d(context);
        aVar.f9608i = x0.g(context);
        aVar.f9609j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f9610k = c1.M();
        aVar.f9611l = c1.G(context);
        StringBuilder sb = new StringBuilder();
        sb.append(c1.D(context));
        aVar.f9612m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c1.B(context));
        aVar.f9613n = sb2.toString();
        aVar.f9614o = c1.O(context);
        aVar.f9615p = c1.A(context);
        aVar.f9616q = "";
        aVar.f9617r = "";
        String[] E = c1.E();
        aVar.f9618s = E[0];
        aVar.f9619t = E[1];
        aVar.f9622w = c1.i();
        String j4 = c1.j(context);
        if (!TextUtils.isEmpty(j4)) {
            aVar.f9623x = j4;
        } else {
            aVar.f9623x = "";
        }
        aVar.f9624y = "aid=" + c1.z();
        if ((z3 && s1.f10198e) || s1.f10199f) {
            String w3 = c1.w(context);
            if (!TextUtils.isEmpty(w3)) {
                aVar.f9624y += "|oaid=" + w3;
            }
        }
        String F = c1.F();
        if (!TextUtils.isEmpty(F)) {
            aVar.f9624y += "|multiImeis=" + F;
        }
        String J = c1.J();
        if (!TextUtils.isEmpty(J)) {
            aVar.f9624y += "|meid=" + J;
        }
        aVar.f9624y += "|serial=" + c1.x();
        String o4 = c1.o();
        if (!TextUtils.isEmpty(o4)) {
            aVar.f9624y += "|adiuExtras=" + o4;
        }
        aVar.f9624y += "|storage=" + c1.N() + "|ram=" + c1.L(context) + "|arch=" + c1.P();
        String b4 = c2.a().b();
        if (!TextUtils.isEmpty(b4)) {
            aVar.f9625z = b4;
        } else {
            aVar.f9625z = "";
        }
        return aVar;
    }

    private static String i(Context context) {
        try {
            return d(h(context, false));
        } catch (Throwable th) {
            d2.e(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] j(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            e(byteArrayOutputStream, aVar.f9600a);
            e(byteArrayOutputStream, aVar.f9601b);
            e(byteArrayOutputStream, aVar.f9602c);
            e(byteArrayOutputStream, aVar.f9603d);
            e(byteArrayOutputStream, aVar.f9604e);
            e(byteArrayOutputStream, aVar.f9605f);
            e(byteArrayOutputStream, aVar.f9606g);
            e(byteArrayOutputStream, aVar.f9607h);
            e(byteArrayOutputStream, aVar.f9608i);
            e(byteArrayOutputStream, aVar.f9609j);
            e(byteArrayOutputStream, aVar.f9610k);
            e(byteArrayOutputStream, aVar.f9611l);
            e(byteArrayOutputStream, aVar.f9612m);
            e(byteArrayOutputStream, aVar.f9613n);
            e(byteArrayOutputStream, aVar.f9614o);
            e(byteArrayOutputStream, aVar.f9615p);
            e(byteArrayOutputStream, aVar.f9616q);
            e(byteArrayOutputStream, aVar.f9617r);
            e(byteArrayOutputStream, aVar.f9618s);
            e(byteArrayOutputStream, aVar.f9619t);
            e(byteArrayOutputStream, aVar.f9620u);
            e(byteArrayOutputStream, aVar.f9621v);
            e(byteArrayOutputStream, aVar.f9622w);
            e(byteArrayOutputStream, aVar.f9623x);
            e(byteArrayOutputStream, aVar.f9624y);
            e(byteArrayOutputStream, aVar.f9625z);
            e(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] k4 = k(j1.s(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return k4;
        } catch (Throwable th3) {
            th = th3;
            try {
                d2.e(th, "CI", "gzx");
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

    private static byte[] k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey w3 = j1.w();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] c4 = d1.c(bArr2, w3);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(c4, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return d1.c(bArr, w3);
    }
}
