package com.qq.e.comm.plugin.i0.l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {

    /* renamed from: m  reason: collision with root package name */
    private static final String f44303m = f.class.getSimpleName();

    /* renamed from: n  reason: collision with root package name */
    private static volatile j f44304n;

    /* renamed from: b  reason: collision with root package name */
    private String f44306b;

    /* renamed from: c  reason: collision with root package name */
    private int f44307c;

    /* renamed from: k  reason: collision with root package name */
    private volatile long f44315k;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f44305a = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f44308d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f44309e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f44310f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f44311g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private int f44312h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f44313i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f44314j = -1;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f44316l = new b();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f44317a;

        a(String str) {
            this.f44317a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.equals("null", this.f44317a) && j.this.f44309e.contains(str)) {
                return true;
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f44317a, sSLSession);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.c();
        }
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        pro.getVresult(211, 0, this);
    }

    public void a(String str, boolean z3) {
        pro.getVresult(212, 0, this, str, Boolean.valueOf(z3));
    }

    public static j a() {
        if (f44304n == null) {
            synchronized (j.class) {
                if (f44304n == null) {
                    f44304n = new j();
                }
            }
        }
        return f44304n;
    }

    private boolean b() {
        if (this.f44314j < 0) {
            this.f44314j = com.qq.e.comm.plugin.d0.a.d().f().a("hdrcdt", 10) * 1000;
        }
        return SystemClock.elapsedRealtime() - this.f44315k > ((long) this.f44314j);
    }

    private void a(int i4, int i5, Exception exc) {
        String str = f44303m;
        StringBuilder sb = new StringBuilder();
        sb.append("request error ");
        Object obj = exc;
        if (exc == null) {
            obj = "";
        }
        sb.append(obj);
        d1.a(str, sb.toString());
        if (f.c().m()) {
            if (i4 == 0) {
                if (this.f44310f.incrementAndGet() >= this.f44308d.size() - 1) {
                    this.f44310f.set(0);
                    h.b(i5, 5, null);
                }
            } else if (i4 != 1 || this.f44311g.incrementAndGet() < this.f44309e.size() - 1) {
            } else {
                this.f44311g.set(0);
                h.b(i5, 6, null);
            }
        }
    }
}
