package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ClientInfo.java */
/* renamed from: com.amap.api.col.3l.h4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h4 {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ClientInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {
        String A;

        /* renamed from: a  reason: collision with root package name */
        String f7960a;

        /* renamed from: b  reason: collision with root package name */
        String f7961b;

        /* renamed from: c  reason: collision with root package name */
        String f7962c;

        /* renamed from: d  reason: collision with root package name */
        String f7963d;

        /* renamed from: e  reason: collision with root package name */
        String f7964e;

        /* renamed from: f  reason: collision with root package name */
        String f7965f;

        /* renamed from: g  reason: collision with root package name */
        String f7966g;

        /* renamed from: h  reason: collision with root package name */
        String f7967h;

        /* renamed from: i  reason: collision with root package name */
        String f7968i;

        /* renamed from: j  reason: collision with root package name */
        String f7969j;

        /* renamed from: k  reason: collision with root package name */
        String f7970k;

        /* renamed from: l  reason: collision with root package name */
        String f7971l;

        /* renamed from: m  reason: collision with root package name */
        String f7972m;

        /* renamed from: n  reason: collision with root package name */
        String f7973n;

        /* renamed from: o  reason: collision with root package name */
        String f7974o;

        /* renamed from: p  reason: collision with root package name */
        String f7975p;

        /* renamed from: q  reason: collision with root package name */
        String f7976q;

        /* renamed from: r  reason: collision with root package name */
        String f7977r;

        /* renamed from: s  reason: collision with root package name */
        String f7978s;

        /* renamed from: t  reason: collision with root package name */
        String f7979t;

        /* renamed from: u  reason: collision with root package name */
        String f7980u;

        /* renamed from: v  reason: collision with root package name */
        String f7981v;

        /* renamed from: w  reason: collision with root package name */
        String f7982w;

        /* renamed from: x  reason: collision with root package name */
        String f7983x;

        /* renamed from: y  reason: collision with root package name */
        String f7984y;

        /* renamed from: z  reason: collision with root package name */
        String f7985z;

        private a() {
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class b extends z7 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7986a;

        b(Context context) {
            this.f7986a = context;
        }

        public final void runTask() {
            h4.g0(this.f7986a);
            h4.d0();
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface c {
        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Cif b(byte[] bArr, Map<String, String> map);

        Map<String, String> b();
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$d */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static Context f7987a;

        /* renamed from: b  reason: collision with root package name */
        private static BroadcastReceiver f7988b;

        /* renamed from: c  reason: collision with root package name */
        private static ConnectivityManager f7989c;

        /* renamed from: d  reason: collision with root package name */
        private static NetworkRequest f7990d;

        /* renamed from: e  reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f7991e;

        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.h4$d$a */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (p4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    h4.b0();
                }
            }
        }

        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.h4$d$b */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        final class b extends ConnectivityManager.NetworkCallback {
            b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                h4.b0();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                h4.b0();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f7988b != null) {
                    return;
                }
                f7988b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(p4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f7988b, intentFilter);
            } else if (h4.u(context, p4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f7989c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f7989c = connectivityManager;
                if (connectivityManager != null) {
                    f7990d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    b bVar = new b();
                    f7991e = bVar;
                    f7989c.registerNetworkCallback(f7990d, bVar);
                    f7987a = context;
                }
            }
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$e */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h4.m(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = e4.d() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            q5.e(th, "CI", "TS");
            return null;
        }
    }

    public static String b(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f7963d = e4.g(context);
            aVar.f7968i = e4.h(context);
            return d(aVar);
        } catch (Throwable th) {
            q5.e(th, "CI", "IX");
            return null;
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            String i4 = e4.i(context);
            return m4.d(i4 + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            q5.e(th, "CI", "Sco");
            return null;
        }
    }

    private static String d(a aVar) {
        return j4.f(j(aVar));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            q4.j(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, q4.o(str));
        } else {
            q4.j(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    public static byte[] f(Context context, boolean z3, boolean z4) {
        try {
            return j(h(context, z3, z4));
        } catch (Throwable th) {
            q5.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return j4.b(bArr);
    }

    private static a h(Context context, boolean z3, boolean z4) {
        a aVar = new a((byte) 0);
        aVar.f7960a = i4.P();
        aVar.f7961b = i4.I();
        String F = i4.F(context);
        if (F == null) {
            F = "";
        }
        aVar.f7962c = F;
        aVar.f7963d = e4.g(context);
        aVar.f7964e = Build.MODEL;
        aVar.f7965f = Build.MANUFACTURER;
        aVar.f7966g = Build.DEVICE;
        aVar.f7967h = e4.e(context);
        aVar.f7968i = e4.h(context);
        aVar.f7969j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f7970k = i4.U();
        aVar.f7971l = i4.T(context);
        StringBuilder sb = new StringBuilder();
        sb.append(i4.M(context));
        aVar.f7972m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4.K(context));
        aVar.f7973n = sb2.toString();
        aVar.f7974o = i4.e0(context);
        aVar.f7975p = i4.J(context);
        aVar.f7976q = "";
        aVar.f7977r = "";
        if (z3) {
            aVar.f7978s = "";
            aVar.f7979t = "";
        } else {
            String[] L2 = i4.L();
            aVar.f7978s = L2[0];
            aVar.f7979t = L2[1];
        }
        aVar.f7982w = i4.n();
        String o4 = i4.o(context);
        if (!TextUtils.isEmpty(o4)) {
            aVar.f7983x = o4;
        } else {
            aVar.f7983x = "";
        }
        aVar.f7984y = "aid=" + i4.G();
        if ((z4 && f5.f7710e) || f5.f7711f) {
            String D = i4.D(context);
            if (!TextUtils.isEmpty(D)) {
                aVar.f7984y += "|oaid=" + D;
            }
        }
        String N = i4.N();
        if (!TextUtils.isEmpty(N)) {
            aVar.f7984y += "|multiImeis=" + N;
        }
        String S = i4.S();
        if (!TextUtils.isEmpty(S)) {
            aVar.f7984y += "|meid=" + S;
        }
        aVar.f7984y += "|serial=" + i4.E();
        String v3 = i4.v();
        if (!TextUtils.isEmpty(v3)) {
            aVar.f7984y += "|adiuExtras=" + v3;
        }
        aVar.f7984y += "|storage=" + i4.W() + "|ram=" + i4.c0(context) + "|arch=" + i4.Y();
        String b4 = p5.a().b();
        if (!TextUtils.isEmpty(b4)) {
            aVar.f7985z = b4;
        } else {
            aVar.f7985z = "";
        }
        if (z3) {
            String b5 = w4.a(context).b();
            if (!TextUtils.isEmpty(b5)) {
                aVar.A = b5;
            }
        }
        return aVar;
    }

    public static String i(Context context) {
        return l(context);
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
            e(byteArrayOutputStream, aVar.f7960a);
            e(byteArrayOutputStream, aVar.f7961b);
            e(byteArrayOutputStream, aVar.f7962c);
            e(byteArrayOutputStream, aVar.f7963d);
            e(byteArrayOutputStream, aVar.f7964e);
            e(byteArrayOutputStream, aVar.f7965f);
            e(byteArrayOutputStream, aVar.f7966g);
            e(byteArrayOutputStream, aVar.f7967h);
            e(byteArrayOutputStream, aVar.f7968i);
            e(byteArrayOutputStream, aVar.f7969j);
            e(byteArrayOutputStream, aVar.f7970k);
            e(byteArrayOutputStream, aVar.f7971l);
            e(byteArrayOutputStream, aVar.f7972m);
            e(byteArrayOutputStream, aVar.f7973n);
            e(byteArrayOutputStream, aVar.f7974o);
            e(byteArrayOutputStream, aVar.f7975p);
            e(byteArrayOutputStream, aVar.f7976q);
            e(byteArrayOutputStream, aVar.f7977r);
            e(byteArrayOutputStream, aVar.f7978s);
            e(byteArrayOutputStream, aVar.f7979t);
            e(byteArrayOutputStream, aVar.f7980u);
            e(byteArrayOutputStream, aVar.f7981v);
            e(byteArrayOutputStream, aVar.f7982w);
            e(byteArrayOutputStream, aVar.f7983x);
            e(byteArrayOutputStream, aVar.f7984y);
            e(byteArrayOutputStream, aVar.f7985z);
            e(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] k4 = k(q4.t(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return k4;
        } catch (Throwable th3) {
            th = th3;
            try {
                q5.e(th, "CI", "gzx");
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
        PublicKey x3 = q4.x();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] c4 = j4.c(bArr2, x3);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy(c4, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return j4.c(bArr, x3);
    }

    private static String l(Context context) {
        try {
            return d(h(context, false, false));
        } catch (Throwable th) {
            q5.e(th, "CI", "gCXi");
            return null;
        }
    }
}
