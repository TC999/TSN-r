package com.qq.e.comm.plugin.p.j.o;

import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.n.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.h2;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetConfig;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: l  reason: collision with root package name */
    private static volatile int f45290l;

    /* renamed from: a  reason: collision with root package name */
    private int f45291a;

    /* renamed from: b  reason: collision with root package name */
    private String f45292b;

    /* renamed from: c  reason: collision with root package name */
    private final TnetQuicRequest f45293c;

    /* renamed from: d  reason: collision with root package name */
    private final URL f45294d;

    /* renamed from: e  reason: collision with root package name */
    private e f45295e;

    /* renamed from: i  reason: collision with root package name */
    private final HttpURLConnection f45299i;

    /* renamed from: j  reason: collision with root package name */
    private String f45300j;

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f45296f = new CountDownLatch(1);

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f45297g = false;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f45298h = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private final TnetQuicRequest.Callback f45301k = new a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends TnetQuicRequest.Callback {
        a() {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onClose(int i4, String str) throws Exception {
            d1.a("gdt_tag_tquic", "CDN quic\u8bf7\u6c42close\uff0c\u662f\u5426\u6b63\u5e38\uff1a%s", str);
            c.this.j();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onComplete(int i4) throws Exception {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i4 == 0);
            d1.a("gdt_tag_tquic", "CDN quic\u8bf7\u6c42\u5b8c\u6210\uff0c\u662f\u5426\u6b63\u5e38\uff1a%s", objArr);
            if (i4 == 0) {
                if (TextUtils.equals("HEAD", c.this.f45300j)) {
                    c cVar = c.this;
                    cVar.f45297g = cVar.f45295e.e();
                } else {
                    c cVar2 = c.this;
                    cVar2.f45297g = cVar2.f45295e.d();
                }
                if (!c.this.f45297g) {
                    h2.b(9130016, 3);
                }
            } else {
                h2.b(9130016, 4);
            }
            c.this.j();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onConnect(int i4) throws Exception {
            c.this.f45295e = null;
            c.this.k();
            d1.a("gdt_tag_tquic", "CDN\u53d1\u8d77\u8bf7\u6c42");
            if (c.this.f45299i.getRequestMethod().equalsIgnoreCase("HEAD")) {
                d1.a("gdt_tag_tquic", "CDN\u8bf7\u6c42\u65b9\u6cd5\u8bbe\u7f6e\u4e3aHEAD");
                c.this.f45293c.addHeaders(":method", "HEAD");
                c.this.f45300j = "HEAD";
            }
            c.this.f45293c.sendRequest(new byte[0], 0, true);
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onDataRecv(byte[] bArr) throws Exception {
            if (c.this.f45295e == null) {
                d1.a("gdt_tag_tquic", "CDN recv data");
                c.this.f45295e = new e();
            }
            try {
                c.this.f45295e.a(bArr);
            } catch (Exception e4) {
                d1.a("gdt_tag_tquic", "CDN \u89e3\u6790\u6570\u636e\u5f02\u5e38\uff1a%s", e4.toString());
                h2.b(9130016, 2);
                c.this.j();
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onHeaderRecv(String str) throws Exception {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onNetworkLinked() throws Exception {
        }
    }

    public c(HttpURLConnection httpURLConnection, int i4, String str) {
        this.f45299i = httpURLConnection;
        this.f45291a = i4;
        this.f45292b = str;
        this.f45294d = httpURLConnection.getURL();
        d1.a("gdt_tag_tquic", "\u547d\u4e2dCDN\u57df\u540d " + this.f45294d.getHost());
        this.f45293c = new TnetQuicRequest(this.f45301k, new TnetConfig.Builder().setConnectTimeoutMillis(5000).setTotalTimeoutMillis(10000).build(), 0);
        this.f45298h.set(true);
        if (f45290l == 0) {
            f45290l = com.qq.e.comm.plugin.d0.a.d().f().a("utocctt", 30);
        }
    }

    private boolean i() {
        return (this.f45293c == null || this.f45295e == null || !this.f45297g) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d1.a("gdt_tag_tquic", "CDN\u5f00\u59cb\u91ca\u653eCountDownLatch");
        if (this.f45296f.getCount() > 0) {
            d1.a("gdt_tag_tquic", "CDN\u771f\u6b63\u91ca\u653eCountDownLatch");
            this.f45296f.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        HttpURLConnection httpURLConnection;
        if (this.f45293c == null || (httpURLConnection = this.f45299i) == null || this.f45294d == null) {
            return;
        }
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        if (requestProperties != null) {
            for (String str : requestProperties.keySet()) {
                this.f45293c.addHeaders(str, this.f45299i.getRequestProperty(str));
            }
        }
        this.f45293c.addHeaders("Accept-Encoding", "gzip");
        if (this.f45294d.getPath() != null) {
            String path = this.f45294d.getQuery() == null ? this.f45294d.getPath() : this.f45294d.getPath() + "?" + this.f45294d.getQuery();
            d1.a("gdt_tag_tquic", "CDN URL path\uff1a%s", path);
            this.f45293c.addHeaders(":path", path);
        }
    }

    public int h() {
        if (i()) {
            return this.f45295e.getStatusCode();
        }
        return 0;
    }

    public String l() {
        return i() ? this.f45295e.a("Content-Range") : "";
    }

    public int b() {
        int i4;
        try {
            InetAddress a4 = a(this.f45294d.getHost());
            boolean z3 = true;
            if (a4 == null) {
                return 1;
            }
            d1.a("gdt_tag_tquic", "CDN DNS\u89e3\u6790\u7ed3\u679c\uff1a%s", a4.toString());
            this.f45293c.connect(this.f45294d.toString(), a4.getHostAddress());
            boolean await = this.f45296f.await(f45290l, TimeUnit.SECONDS);
            if (i()) {
                i4 = 0;
            } else if (!await) {
                i4 = 2;
            } else if (this.f45295e == null) {
                i4 = 3;
            } else {
                i4 = !this.f45297g ? 4 : 1;
            }
            if (i4 != 0) {
                z3 = false;
            }
            a(z3);
            return i4;
        } catch (UnknownHostException e4) {
            this.f45291a |= 65536;
            this.f45292b = "ExceptionWhileMakeupPartitionConnection:" + e4.getMessage();
            return 5;
        } catch (Exception e5) {
            this.f45291a |= 4194304;
            this.f45292b = "ExceptionWhileMakeupPartitionConnection:" + e5.getMessage();
            return 6;
        }
    }

    public long c() {
        if (i()) {
            String a4 = this.f45295e.a("Content-Length");
            if (TextUtils.isEmpty(a4)) {
                return -1L;
            }
            return Long.parseLong(a4);
        }
        return -1L;
    }

    public int d() {
        return this.f45291a;
    }

    public String e() {
        return this.f45292b;
    }

    public InputStream f() throws IllegalStateException, IOException {
        if (i()) {
            return this.f45295e.a();
        }
        return null;
    }

    public String g() {
        if (i()) {
            String a4 = this.f45295e.a("content-type");
            return TextUtils.isEmpty(a4) ? "" : a4;
        }
        return "";
    }

    private void a(boolean z3) {
        if (this.f45293c == null || !this.f45298h.compareAndSet(true, false)) {
            return;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().a("rdtcc", 0) > 0) {
            this.f45293c.destroy();
        } else if (!z3 || com.qq.e.comm.plugin.d0.a.d().f().a("irdtcc", 0) <= 0) {
        } else {
            this.f45293c.destroy();
        }
    }

    private InetAddress a(String str) throws UnknownHostException {
        InetAddress inetAddress;
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int length = allByName.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                inetAddress = null;
                break;
            }
            inetAddress = allByName[i4];
            if (inetAddress instanceof Inet4Address) {
                break;
            }
            i4++;
        }
        return (inetAddress != null || allByName.length <= 0) ? inetAddress : allByName[0];
    }

    public void a() {
        a(false);
    }
}
