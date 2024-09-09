package com.qq.e.comm.plugin.p.j.o;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.d;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g2;
import com.qq.e.comm.plugin.util.h2;
import com.qq.e.comm.plugin.util.v0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f45275h = Pattern.compile("bytes\\W+(\\d+)-(\\d+)/(\\d+)");

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f45276i = new AtomicInteger(0);

    /* renamed from: j  reason: collision with root package name */
    private static volatile int f45277j = -1;

    /* renamed from: k  reason: collision with root package name */
    private static volatile String[] f45278k = null;

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f45279a;

    /* renamed from: b  reason: collision with root package name */
    private int f45280b;

    /* renamed from: c  reason: collision with root package name */
    private String f45281c;

    /* renamed from: e  reason: collision with root package name */
    private c f45283e;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f45282d = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private int f45284f = 0;

    /* renamed from: g  reason: collision with root package name */
    private final int f45285g = k();

    public a(HttpURLConnection httpURLConnection, int i4, String str) {
        this.f45279a = httpURLConnection;
        this.f45280b = i4;
        this.f45281c = str;
        if (r()) {
            this.f45283e = new c(httpURLConnection, i4, str);
        }
        l();
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.contains("https://pgdt.ugdtimg.com")) {
            return 0;
        }
        return str.contains("https://adsmind.ugdtimg.com") ? 1 : -1;
    }

    private void d() {
        if (f45276i.incrementAndGet() >= f45277j) {
            h2.a(9130018);
        }
    }

    private int k() {
        return g2.a().d(this.f45279a.getURL().toString());
    }

    private void l() {
        if (this.f45285g > 0 && n() && b(this.f45279a.getURL().getHost())) {
            boolean c4 = g2.a().c();
            boolean m4 = m();
            int a4 = a(this.f45279a.getURL().toString());
            if (a4 >= 0) {
                this.f45284f = ((c4 ? 1 : 0) * 10000) + (this.f45285g * 1000) + ((m4 ? 1 : 0) * 100) + (a4 * 10);
            }
        }
    }

    private boolean m() {
        if (f45277j < 0) {
            f45277j = com.qq.e.comm.plugin.d0.a.d().f().a("tcdt", 2);
        }
        return f45276i.get() >= f45277j;
    }

    private boolean n() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("utocct", 1) > 0;
    }

    private void q() {
        int i4 = this.f45284f;
        if (i4 > 0) {
            h2.a(9130050, i4);
        }
    }

    private boolean r() {
        return g2.a().c() && this.f45285g > 1 && !m() && b(this.f45279a.getURL().getHost());
    }

    public void b() {
        c cVar = this.f45283e;
        if (cVar != null) {
            cVar.a();
        }
        HttpURLConnection httpURLConnection = this.f45279a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
        }
    }

    public boolean c() {
        int i4;
        boolean z3;
        if (this.f45282d.compareAndSet(false, true)) {
            q();
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = this.f45283e;
            if (cVar != null) {
                int b4 = cVar.b();
                z3 = b4 == 0;
                if (z3) {
                    i4 = this.f45283e.h();
                    a();
                    c(currentTimeMillis);
                } else {
                    d1.a("gdt_tag_tquic", "CDN quic\u8bf7\u6c42\u5931\u8d25,error " + b4);
                    a(currentTimeMillis, b4);
                    i4 = 0;
                }
                this.f45280b |= this.f45283e.d();
                this.f45281c = this.f45283e.e();
            } else {
                i4 = 0;
                z3 = false;
            }
            if (this.f45283e == null || !z3) {
                try {
                    HttpURLConnection a4 = v0.a(this.f45279a);
                    this.f45279a = a4;
                    i4 = a4.getResponseCode();
                    d1.a("status code = %d", Integer.valueOf(i4));
                } catch (SocketTimeoutException e4) {
                    this.f45280b |= 131072;
                    this.f45281c = "ExceptionWhileMakeupPartitionConnection:" + e4.getMessage();
                } catch (UnknownHostException e5) {
                    this.f45280b |= 65536;
                    this.f45281c = "ExceptionWhileMakeupPartitionConnection:" + v0.e() + " " + e5.getMessage();
                } catch (IOException e6) {
                    this.f45280b |= 4194304;
                    this.f45281c = "ExceptionWhileMakeupPartitionConnection:" + e6.getMessage();
                }
            }
            if (i4 != 0 && i4 != 200 && i4 != 206) {
                int i5 = this.f45280b | 2097152;
                this.f45280b = i5;
                if (i4 == 416) {
                    this.f45280b = i5 | 1048576;
                }
                this.f45281c = "HttpStatusErrWhileMakeupPartitionConnection:" + i4;
            }
            a(currentTimeMillis);
            if (this.f45283e != null && !z3) {
                StringBuilder sb = new StringBuilder();
                sb.append("CDN quic\u964d\u7ea7\u662f\u5426\u6210\u529f ");
                sb.append(o() ? "\u662f" : "\u5426");
                sb.append(" ");
                sb.append(this.f45281c);
                d1.a("gdt_tag_tquic", sb.toString());
                if (o()) {
                    d();
                    b(currentTimeMillis);
                }
                this.f45283e.a();
                this.f45283e = null;
            }
        }
        return o();
    }

    public long e() {
        HttpURLConnection httpURLConnection = this.f45279a;
        if (httpURLConnection == null) {
            return -1L;
        }
        String headerField = httpURLConnection.getHeaderField("X-Cos-Meta-Edgepack-Offset");
        if (TextUtils.isEmpty(headerField)) {
            return -1L;
        }
        try {
            return Long.parseLong(headerField);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public long f() {
        c cVar = this.f45283e;
        if (cVar != null) {
            return cVar.c();
        }
        HttpURLConnection httpURLConnection = this.f45279a;
        if (httpURLConnection != null) {
            return httpURLConnection.getContentLength();
        }
        return -1L;
    }

    public int g() {
        return this.f45280b;
    }

    public String h() {
        return this.f45281c;
    }

    public InputStream i() throws IllegalStateException, IOException {
        c cVar = this.f45283e;
        if (cVar != null) {
            return cVar.f();
        }
        HttpURLConnection httpURLConnection = this.f45279a;
        if (httpURLConnection != null) {
            return httpURLConnection.getInputStream();
        }
        return null;
    }

    public String j() {
        c cVar = this.f45283e;
        if (cVar != null) {
            return cVar.g();
        }
        HttpURLConnection httpURLConnection = this.f45279a;
        return httpURLConnection != null ? httpURLConnection.getContentType() : "";
    }

    public boolean o() {
        return this.f45280b == 0;
    }

    public boolean p() {
        String headerField;
        c cVar = this.f45283e;
        if (cVar != null) {
            headerField = cVar.l();
        } else {
            HttpURLConnection httpURLConnection = this.f45279a;
            headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("Content-Range") : "";
        }
        return !TextUtils.isEmpty(headerField) && f45275h.matcher(headerField).matches() && f() >= 0;
    }

    private boolean b(String str) {
        if (f45278k == null) {
            String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("utocch", "https://pgdt.ugdtimg.com,https://adsmind.ugdtimg.com");
            if (!TextUtils.isEmpty(b4)) {
                f45278k = b4.split(",");
            } else {
                f45278k = new String[0];
            }
        }
        for (String str2 : f45278k) {
            if (str2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private void a() {
        f45276i.set(0);
    }

    private void a(long j4, int i4) {
        if (this.f45284f > 0) {
            d dVar = new d();
            dVar.a("data", this.f45279a.getURL().toString());
            int i5 = this.f45284f + i4;
            this.f45284f = i5;
            h2.a(9130052, i5, (int) (System.currentTimeMillis() - j4), dVar);
        }
    }

    private void a(long j4) {
        if (this.f45284f <= 0 || this.f45285g != 1) {
            return;
        }
        if (o()) {
            h2.a(9130051, this.f45284f, (int) (System.currentTimeMillis() - j4));
            return;
        }
        d dVar = new d();
        dVar.a("data", this.f45279a.getURL().toString());
        h2.a(9130052, this.f45284f, (int) (System.currentTimeMillis() - j4), dVar);
    }

    private void b(long j4) {
        if (this.f45284f > 0) {
            d dVar = new d();
            dVar.a("data", this.f45279a.getURL().toString());
            h2.a(9130053, this.f45284f, (int) (System.currentTimeMillis() - j4), dVar);
        }
    }

    private void c(long j4) {
        int i4 = this.f45284f;
        if (i4 > 0) {
            h2.a(9130051, i4, (int) (System.currentTimeMillis() - j4));
        }
    }
}
