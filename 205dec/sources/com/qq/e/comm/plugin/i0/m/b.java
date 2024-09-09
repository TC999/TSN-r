package com.qq.e.comm.plugin.i0.m;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.comm.plugin.i0.k;
import com.qq.e.comm.plugin.i0.m.a;
import com.qq.e.comm.plugin.i0.n.e;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g2;
import com.qq.e.comm.plugin.util.h2;
import com.qq.e.comm.plugin.util.v0;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetConfig;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements com.qq.e.comm.plugin.i0.m.a {

    /* renamed from: b  reason: collision with root package name */
    private f f44369b;

    /* renamed from: c  reason: collision with root package name */
    private TnetQuicRequest f44370c;

    /* renamed from: d  reason: collision with root package name */
    private URL f44371d;

    /* renamed from: e  reason: collision with root package name */
    private e f44372e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f44373f;

    /* renamed from: g  reason: collision with root package name */
    private TnetConfig f44374g;

    /* renamed from: a  reason: collision with root package name */
    private int f44368a = 10;

    /* renamed from: h  reason: collision with root package name */
    private final CountDownLatch f44375h = new CountDownLatch(1);

    /* renamed from: i  reason: collision with root package name */
    private int f44376i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f44377j = 0;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicBoolean f44378k = new AtomicBoolean(false);

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends TnetQuicRequest.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f44379a;

        a(long j4) {
            this.f44379a = j4;
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onClose(int i4, String str) throws Exception {
            d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42close\uff0c\u662f\u5426\u6b63\u5e38\uff1a%s", str);
            b.this.b();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onComplete(int i4) throws Exception {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i4 == 0);
            d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42\u5b8c\u6210\uff0c\u662f\u5426\u6b63\u5e38\uff1a%s", objArr);
            if (i4 == 0) {
                b bVar = b.this;
                bVar.f44373f = bVar.f44372e.d();
                if (!b.this.f44373f) {
                    b.this.a(this.f44379a, 3);
                }
            } else {
                b.this.a(this.f44379a, i4 + 40);
            }
            b.this.b();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onConnect(int i4) throws Exception {
            b.this.f44372e = null;
            b.this.f44373f = false;
            b.this.c();
            if (C0848b.f44381a[b.this.f44369b.getMethod().ordinal()] == 1) {
                byte[] k4 = b.this.f44369b.k();
                if (k4 == null || k4.length <= 0) {
                    b.this.b();
                    return;
                }
                d1.a("gdt_tag_tquic", "\u53d1\u8d77post\u8bf7\u6c42");
                if (g2.a().e()) {
                    k4 = (new String(k4, "UTF-8") + "&use_tcc=1").getBytes("UTF-8");
                }
                b.this.f44370c.sendRequest(k4, k4.length, true);
                return;
            }
            d1.a("gdt_tag_tquic", "\u53d1\u8d77get\u8bf7\u6c42");
            b.this.f44370c.sendRequest(new byte[0], 0, true);
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onDataRecv(byte[] bArr) throws Exception {
            d1.a("gdt_tag_tquic", "recv data");
            if (b.this.f44372e == null) {
                b bVar = b.this;
                bVar.f44372e = new e(bVar.f44369b.j());
            }
            try {
                b.this.f44372e.a(bArr);
            } catch (Exception e4) {
                d1.a("gdt_tag_tquic", "\u89e3\u6790\u6570\u636e\u5f02\u5e38\uff1a%s", e4.toString());
                if (v0.a(b.this.f44372e.getStatusCode())) {
                    b.this.a(this.f44379a, 7);
                } else {
                    b.this.a(this.f44379a, 2);
                }
                b.this.b();
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onHeaderRecv(String str) throws Exception {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onNetworkLinked() throws Exception {
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.i0.m.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class C0848b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44381a;

        static {
            int[] iArr = new int[f.a.values().length];
            f44381a = iArr;
            try {
                iArr[f.a.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44381a[f.a.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            g2.h d4 = fVar.d();
            int i4 = g2.a().c() ? 1 : 2;
            this.f44377j = g2.a().b(d4, fVar.c());
            int a4 = (i4 * 10000) + (this.f44377j * 1000) + ((g2.a().b(d4) ? 1 : 0) * 100) + ((d4 == null ? 0 : d4.a()) * 10);
            this.f44376i = a4;
            d1.a("gdt_tag_tquic", "quic initTrackEventParams mQuicRequestEnumCode\uff1a%d", Integer.valueOf(a4));
        }
    }

    private g c(a.InterfaceC0847a interfaceC0847a) {
        g gVar = null;
        if (interfaceC0847a != null && interfaceC0847a.a() != null) {
            d1.a("gdt_tag_tquic", "in quic tryNotUseQuicFroExp");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                d();
                gVar = interfaceC0847a.a(this.f44369b);
            } catch (Exception unused) {
            }
            if (a(interfaceC0847a.a(), gVar)) {
                b(currentTimeMillis);
            } else {
                a(currentTimeMillis, 0);
            }
        }
        return gVar;
    }

    private void d() {
        d1.a("gdt_tag_tquic", "quic trackQuicStart mQuicRequestEnumCode\uff1a%d", Integer.valueOf(this.f44376i));
        f fVar = this.f44369b;
        if (fVar == null) {
            return;
        }
        g2.h d4 = fVar.d();
        if ((d4 == g2.h.CLICK_CGI_REQ || d4 == g2.h.EXPOSURE_CGI_REQ) && a()) {
            h2.a(9130080, this.f44376i);
        }
    }

    @Override // com.qq.e.comm.plugin.i0.m.a
    public g a(a.InterfaceC0847a interfaceC0847a) throws Exception {
        f a4 = interfaceC0847a.a();
        this.f44369b = a4;
        b(a4);
        if (b(interfaceC0847a)) {
            return c(interfaceC0847a);
        }
        d();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f44374g == null) {
            Pair<Integer, Integer> a5 = a(this.f44369b);
            this.f44374g = new TnetConfig.Builder().setConnectTimeoutMillis(((Integer) a5.first).intValue()).setTotalTimeoutMillis(((Integer) a5.second).intValue()).build();
            this.f44368a = ((Integer) a5.second).intValue() + 2000;
        }
        URL url = new URL(com.qq.e.comm.plugin.i0.e.a(this.f44369b.i(), 1));
        this.f44371d = url;
        d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42url\uff1a%s", url.toString());
        this.f44370c = new TnetQuicRequest(new a(currentTimeMillis), this.f44374g, 0);
        this.f44378k.set(true);
        InetAddress a6 = a(this.f44371d.getHost());
        d1.a("gdt_tag_tquic", "DNS\u89e3\u6790\u7ed3\u679c\uff1a%s", a6.toString());
        this.f44370c.connect(this.f44371d.toString(), a6.getHostAddress());
        boolean await = this.f44375h.await(this.f44368a, TimeUnit.SECONDS);
        if (await && this.f44372e != null && this.f44373f) {
            d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42\u6210\u529f, mQuicRequestEnumCode = %d", Integer.valueOf(this.f44376i));
            d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42\u6210\u529f, mQuicResponse = %s", this.f44372e.b());
            g2.a().a(this.f44369b.d());
            b(currentTimeMillis);
            a(true);
            return this.f44372e;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(await);
        objArr[1] = Boolean.valueOf(this.f44372e == null);
        objArr[2] = Boolean.valueOf(this.f44373f);
        d1.a("gdt_tag_tquic", "quic\u8bf7\u6c42\u5931\u8d25\uff1a%s\uff0c%s\uff0c%s", objArr);
        if (!await) {
            a(currentTimeMillis, 1);
        } else if (this.f44372e == null) {
            a(currentTimeMillis, 5);
        } else if (!this.f44373f) {
            a(currentTimeMillis, 6);
        }
        a(false);
        g a7 = interfaceC0847a.a(this.f44369b);
        if (a(this.f44369b, a7)) {
            g2.a().a(this.f44369b.d(), this.f44376i);
            a(currentTimeMillis);
        }
        return a7;
    }

    private boolean b(a.InterfaceC0847a interfaceC0847a) {
        g2.h d4;
        return (interfaceC0847a == null || interfaceC0847a.a() == null || (d4 = interfaceC0847a.a().d()) == null || d4 == g2.h.AD_REQ || this.f44377j > 1) ? false : true;
    }

    private void b(long j4) {
        d1.a("gdt_tag_tquic", "quic trackQuicSuc mQuicRequestEnumCode\uff1a%d", Integer.valueOf(this.f44376i));
        f fVar = this.f44369b;
        if (fVar == null) {
            return;
        }
        g2.h d4 = fVar.d();
        if (d4 == g2.h.AD_REQ) {
            h2.a(9130019);
        } else if ((d4 == g2.h.CLICK_CGI_REQ || d4 == g2.h.EXPOSURE_CGI_REQ) && a()) {
            h2.a(9130081, this.f44376i, (int) (System.currentTimeMillis() - j4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        f fVar = this.f44369b;
        if (fVar == null || this.f44370c == null || this.f44371d == null) {
            return;
        }
        for (Map.Entry<String, String> entry : fVar.f().entrySet()) {
            this.f44370c.addHeaders(entry.getKey(), entry.getValue());
        }
        this.f44370c.addHeaders(k.b(), k.a());
        this.f44370c.addHeaders("Accept-Encoding", "gzip");
        if (this.f44371d.getPath() != null) {
            String path = this.f44371d.getPath();
            if (this.f44371d.getQuery() != null) {
                path = this.f44371d.getPath() + "?" + this.f44371d.getQuery();
                if (g2.a().e()) {
                    path = path + "&use_tcc=1";
                }
            }
            d1.a("gdt_tag_tquic", "URL path\uff1a%s", path);
            this.f44370c.addHeaders(":path", path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d1.a("gdt_tag_tquic", "\u5f00\u59cb\u91ca\u653eCountDownLatch");
        if (this.f44375h.getCount() > 0) {
            d1.a("gdt_tag_tquic", "\u771f\u6b63\u91ca\u653eCountDownLatch");
            this.f44375h.countDown();
        }
    }

    private boolean a(f fVar, g gVar) {
        if (fVar == null || gVar == null) {
            return false;
        }
        int statusCode = gVar.getStatusCode();
        if (statusCode == 200 || statusCode == 204) {
            return true;
        }
        g2.h d4 = fVar.d();
        return d4 != null && d4 == g2.h.CLICK_CGI_REQ && v0.a(statusCode) && !fVar.j();
    }

    private Pair<Integer, Integer> a(f fVar) {
        if (this.f44377j > 1 && fVar != null && fVar.d() != g2.h.AD_REQ) {
            if (this.f44377j < 4 && fVar.d() == g2.h.CLICK_CGI_REQ && fVar.c() == com.qq.e.comm.plugin.b.g.SPLASH.c()) {
                int h4 = fVar.h() > 0 ? fVar.h() : 30000;
                return new Pair<>(Integer.valueOf(h4), Integer.valueOf(h4 + (fVar.b() > 0 ? fVar.b() : 30000)));
            }
            return new Pair<>(Integer.valueOf(this.f44377j * 1000), Integer.valueOf(this.f44377j * 1000 * 2));
        }
        return new Pair<>(4000, Integer.valueOf((int) AVMDLDataLoader.KeyIsLiveSetLoaderType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4, int i4) {
        d1.a("gdt_tag_tquic", "quic trackQuicFail mQuicRequestEnumCode\uff1a%d, errCode: %d", Integer.valueOf(this.f44376i), Integer.valueOf(i4));
        f fVar = this.f44369b;
        if (fVar == null) {
            return;
        }
        g2.h d4 = fVar.d();
        if (d4 == g2.h.AD_REQ) {
            h2.b(9130016, i4);
        } else if ((d4 == g2.h.CLICK_CGI_REQ || d4 == g2.h.EXPOSURE_CGI_REQ) && a()) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("data", this.f44369b.getUrl());
            h2.a(9130082, this.f44376i + i4, (int) (System.currentTimeMillis() - j4), dVar);
        }
    }

    private void a(long j4) {
        d1.a("gdt_tag_tquic", "quic trackQuicDowngrade mQuicRequestEnumCode\uff1a%d", Integer.valueOf(this.f44376i));
        f fVar = this.f44369b;
        if (fVar == null) {
            return;
        }
        g2.h d4 = fVar.d();
        if (d4 == g2.h.AD_REQ) {
            h2.a(9130017);
        } else if ((d4 == g2.h.CLICK_CGI_REQ || d4 == g2.h.EXPOSURE_CGI_REQ) && a()) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("data", this.f44369b.getUrl());
            h2.a(9130083, this.f44376i, (int) (System.currentTimeMillis() - j4), dVar);
        }
    }

    private boolean a() {
        return this.f44376i > 0;
    }

    private InetAddress a(String str) throws Exception {
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

    private void a(boolean z3) {
        if (this.f44370c == null || !this.f44378k.compareAndSet(true, false)) {
            return;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().a("rdtc", 0) > 0) {
            this.f44370c.destroy();
        } else if (!z3 || com.qq.e.comm.plugin.d0.a.d().f().a("irdtc", 0) <= 0) {
        } else {
            this.f44370c.destroy();
        }
    }
}
