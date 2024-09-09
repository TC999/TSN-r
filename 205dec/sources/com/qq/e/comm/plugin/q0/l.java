package com.qq.e.comm.plugin.q0;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {

    /* renamed from: k  reason: collision with root package name */
    private static final String f45480k = "l";

    /* renamed from: l  reason: collision with root package name */
    private static volatile l f45481l;

    /* renamed from: a  reason: collision with root package name */
    private File f45482a = c();

    /* renamed from: b  reason: collision with root package name */
    private File f45483b = b1.m();

    /* renamed from: c  reason: collision with root package name */
    private volatile Set<String> f45484c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Set<String> f45485d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Set<String> f45486e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Set<String> f45487f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Boolean f45488g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Boolean f45489h;

    /* renamed from: i  reason: collision with root package name */
    private volatile Boolean f45490i;

    /* renamed from: j  reason: collision with root package name */
    private volatile Boolean f45491j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f45494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f45495b;

        b(d dVar, long j4) {
            this.f45494a = dVar;
            this.f45495b = j4;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
            l.this.a(str, this.f45494a, exc, i4);
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            if (!fVar.a()) {
                v.a(9130005, null, 1);
            }
            l.this.a(2060001, fVar.d(), System.currentTimeMillis() - this.f45495b, this.f45494a);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a(File file);

        void a(Exception exc, int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        File f45500a;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    private l() {
    }

    private File c() {
        if (this.f45482a == null) {
            this.f45482a = b1.b();
        }
        if (!this.f45482a.exists()) {
            this.f45482a.mkdirs();
        }
        return this.f45482a;
    }

    public static l d() {
        if (f45481l == null) {
            synchronized (l.class) {
                if (f45481l == null) {
                    f45481l = new l();
                }
            }
        }
        return f45481l;
    }

    private Set<String> e() {
        if (this.f45486e == null) {
            synchronized (this) {
                if (this.f45486e == null) {
                    String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("wimgup", "");
                    if (TextUtils.isEmpty(b4)) {
                        this.f45486e = new HashSet();
                    } else {
                        this.f45486e = new HashSet(Arrays.asList(TextUtils.split(b4, ",")));
                    }
                }
            }
        }
        return this.f45486e;
    }

    private Set<String> h() {
        if (this.f45487f == null) {
            synchronized (this) {
                if (this.f45487f == null) {
                    this.f45487f = new HashSet(Arrays.asList(TextUtils.split(com.qq.e.comm.plugin.d0.a.d().f().b("wupbl", "qzs.gdtimg.com/union/res/union_site/page/ANVideoEndcard/"), ",")));
                }
            }
        }
        return this.f45487f;
    }

    private boolean i() {
        if (this.f45490i == null) {
            synchronized (this) {
                if (this.f45490i == null) {
                    this.f45490i = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("web_proxy_img_cache", 0) == 1);
                }
            }
        }
        return this.f45490i.booleanValue();
    }

    private boolean j() {
        if (this.f45491j == null) {
            synchronized (this) {
                if (this.f45491j == null) {
                    this.f45491j = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("web_proxy_res_cache", 0) == 1);
                }
            }
        }
        return this.f45491j.booleanValue();
    }

    private boolean k() {
        if (this.f45489h == null) {
            synchronized (this) {
                if (this.f45489h == null) {
                    this.f45489h = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("web_proxy_not_hit_event", 0) == 1);
                }
            }
        }
        return this.f45489h.booleanValue();
    }

    public boolean b() {
        if (this.f45488g == null) {
            synchronized (this) {
                if (this.f45488g == null) {
                    this.f45488g = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("web_proxy", 0) == 1);
                }
            }
        }
        return this.f45488g.booleanValue();
    }

    public Set<String> f() {
        if (this.f45485d == null) {
            synchronized (this) {
                if (this.f45485d == null) {
                    String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("web_proxy_img_suffix");
                    if (TextUtils.isEmpty(c4)) {
                        c4 = "jpg,jpeg,png";
                    }
                    this.f45485d = new HashSet(Arrays.asList(TextUtils.split(c4, ",")));
                }
            }
        }
        return this.f45485d;
    }

    public Set<String> g() {
        if (this.f45484c == null) {
            synchronized (this) {
                if (this.f45484c == null) {
                    String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("web_proxy_res_suffix");
                    if (TextUtils.isEmpty(c4)) {
                        c4 = "html,js,css";
                    }
                    this.f45484c = new HashSet(Arrays.asList(TextUtils.split(c4, ",")));
                }
            }
        }
        return this.f45484c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f45492a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f45493b;

        a(l lVar, e eVar, CountDownLatch countDownLatch) {
            this.f45492a = eVar;
            this.f45493b = countDownLatch;
        }

        @Override // com.qq.e.comm.plugin.q0.l.d
        public void a(File file) {
            this.f45492a.f45500a = file;
            this.f45493b.countDown();
        }

        @Override // com.qq.e.comm.plugin.q0.l.d
        public void a(Exception exc, int i4) {
            this.f45493b.countDown();
            d1.a(l.f45480k, exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f45497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f45498b;

        c(String str, d dVar) {
            this.f45497a = str;
            this.f45498b = dVar;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            String str = l.f45480k;
            d1.a(str, "download success, url=" + this.f45497a + ", time = " + j4);
            l.this.a(2060003, file, j4, this.f45498b);
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void b() {
            d dVar = this.f45498b;
            if (dVar != null) {
                dVar.a(new Exception("\u4e0b\u8f7d\u88ab\u53d6\u6d88"), 64);
            }
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            String str = l.f45480k;
            d1.b(str, "download fail, url = " + this.f45497a + " ,errorCode:" + dVar.a() + ", errorMsg:" + dVar.b());
            l.this.a(this.f45497a, this.f45498b, dVar, dVar.a());
        }
    }

    public Pair<FileInputStream, i2.a> a(Uri uri) {
        FileInputStream a4;
        String uri2 = uri.toString();
        if (TextUtils.isEmpty(uri2)) {
            d1.a(f45480k, "url == null or empty");
            return null;
        }
        String a5 = i2.a(uri);
        i2.a a6 = i2.a(a5);
        if (!f().contains(a5) && !c(uri)) {
            if (g().contains(a5)) {
                String str = f45480k;
                d1.a(str, "proxy resource: " + uri2);
                a4 = a(uri2, a6);
            } else if (TextUtils.isEmpty(a5)) {
                a4 = c(uri2);
            } else {
                String str2 = f45480k;
                d1.a(str2, "proxy fail: " + uri2);
                if (k()) {
                    com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(1110105);
                    eVar.a(new com.qq.e.comm.plugin.n0.d().a("url", uri2));
                    v.a(eVar);
                }
                return null;
            }
        } else {
            String str3 = f45480k;
            d1.a(str3, "proxy image: " + uri2);
            a6 = i2.a.f46491g;
            a4 = a(uri2, a6);
        }
        return new Pair<>(a4, a6);
    }

    private boolean c(Uri uri) {
        Set<String> e4 = e();
        if (e4.size() <= 0) {
            return false;
        }
        String str = uri.getHost() + uri.getPath();
        for (String str2 : e4) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(Uri uri) {
        Set<String> h4 = h();
        if (h4.size() <= 0) {
            return false;
        }
        String str = uri.getHost() + uri.getPath();
        for (String str2 : h4) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private FileInputStream c(String str) {
        FileInputStream a4 = a(str, i2.a.f46491g, false);
        String str2 = f45480k;
        Object[] objArr = new Object[2];
        objArr[0] = a4 != null ? "success" : "fail";
        objArr[1] = str;
        d1.a(str2, "tryGetFileInputStream: %s, url = %s", objArr);
        return a4;
    }

    public File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(str, this.f45483b);
    }

    private FileInputStream b(String str, i2.a aVar) {
        int i4 = 1;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        e eVar = new e(null);
        a aVar2 = new a(this, eVar, countDownLatch);
        if (aVar == i2.a.f46491g) {
            a(str, aVar2);
        } else {
            i4 = 2;
            b(str, aVar2);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            countDownLatch.await(3L, TimeUnit.SECONDS);
            if (eVar.f45500a != null) {
                String str2 = f45480k;
                d1.a(str2, "download completed, time = " + (System.currentTimeMillis() - currentTimeMillis));
                try {
                    return new FileInputStream(eVar.f45500a);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
            String str3 = f45480k;
            d1.b(str3, "download TimeoutException, url = " + str);
            v.a(1110107, null, Integer.valueOf(i4), null);
            return null;
        } catch (InterruptedException e4) {
            String str4 = f45480k;
            d1.a(str4, "download InterruptedException, url = " + str, e4);
            return null;
        }
    }

    private FileInputStream a(String str, i2.a aVar) {
        return a(str, aVar, true);
    }

    private FileInputStream a(String str, i2.a aVar, boolean z3) {
        File b4;
        if (aVar == i2.a.f46491g) {
            b4 = a(str);
        } else {
            b4 = b(str);
        }
        if (b4 != null) {
            a(aVar, 1);
            try {
                String str2 = f45480k;
                d1.a(str2, "get response from cache: " + str);
                if (aVar == i2.a.f46491g && t.c(b4)) {
                    return null;
                }
                return new FileInputStream(b4);
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        a(aVar, -1);
        if (z3) {
            if (aVar == i2.a.f46491g && i()) {
                return b(str, aVar);
            }
            if (j()) {
                return b(str, aVar);
            }
        }
        return null;
    }

    public void b(String str, d dVar) {
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().a(this.f45483b).a(b1.d(str)).d(false).b(false).d(str).a(), new c(str, dVar));
    }

    private void a(i2.a aVar, int i4) {
        if (aVar == i2.a.f46491g) {
            v.a(1110108, null, Integer.valueOf(i4), null);
        } else {
            v.a(1110104, null, Integer.valueOf(i4), null);
        }
    }

    private File a(String str) {
        return a(str, this.f45482a);
    }

    private File a(String str, File file) {
        File file2 = new File(file, b1.d(str));
        if (file2.exists()) {
            if (file2.length() > 0) {
                return file2;
            }
            try {
                file2.delete();
            } catch (Exception e4) {
                d1.a(f45480k, "getFileWithUrl ", e4);
            }
        }
        return null;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            d1.a(f45480k, "downloadImage url is empty or null");
            return;
        }
        if (new File(c(), b1.d(str)).exists()) {
            String str2 = f45480k;
            d1.a(str2, str + ": \u5bf9\u5e94\u7684\u6587\u4ef6\u672c\u5730\u5df2\u5b58\u5728");
            return;
        }
        com.qq.e.comm.plugin.b0.b.a().a(str, (com.qq.e.comm.plugin.b0.c) new b(dVar, System.currentTimeMillis()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, File file, long j4, d dVar) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
        hVar.b(j4);
        if (file.exists()) {
            hVar.b((int) (file.length() >> 10));
            if (dVar != null) {
                dVar.a(file);
            }
        } else {
            hVar.b(-1);
            if (dVar != null) {
                dVar.a(new Exception("\u6587\u4ef6\u4e0d\u5b58\u5728"), 32768);
            }
        }
        v.a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Exception exc, int i4) {
        com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
        dVar2.a("url", str);
        dVar2.a("msg", exc.getMessage());
        v.b(1110106, null, Integer.valueOf(i4), dVar2);
        if (dVar != null) {
            dVar.a(exc, i4);
        }
    }
}
