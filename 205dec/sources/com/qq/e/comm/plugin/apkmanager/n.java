package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.b;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.apkmanager.d;
import com.qq.e.comm.plugin.apkmanager.e;
import com.qq.e.comm.plugin.apkmanager.r;
import com.qq.e.comm.plugin.apkmanager.x.d;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.plugin.util.y;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class n implements com.qq.e.comm.plugin.apkmanager.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41840a;

    /* renamed from: b  reason: collision with root package name */
    private final ApkDownloadTask f41841b;

    /* renamed from: c  reason: collision with root package name */
    private c.a f41842c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41843d;

    /* renamed from: f  reason: collision with root package name */
    private c.a f41845f = new f();

    /* renamed from: e  reason: collision with root package name */
    private int f41844e = com.qq.e.comm.plugin.apkmanager.x.c.a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements i {
        a() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.n.i
        public void a(boolean z3) {
            n.this.a(z3);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f41847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41848b;

        b(File file, boolean z3) {
            this.f41847a = file;
            this.f41848b = z3;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.n.i
        public void a(boolean z3) {
            n.this.a(z3);
            if (z3) {
                n.this.b(this.f41847a, this.f41848b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements d.InterfaceC0783d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f41850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41851b;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements i {
            a() {
            }

            @Override // com.qq.e.comm.plugin.apkmanager.n.i
            public void a(boolean z3) {
                if (!z3 || n.this.f41844e <= 0) {
                    return;
                }
                c cVar = c.this;
                n.this.b(cVar.f41850a, cVar.f41851b);
            }
        }

        c(File file, boolean z3) {
            this.f41850a = file;
            this.f41851b = z3;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.d.InterfaceC0783d
        public void a() {
            n.this.a(this.f41850a, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f41854a;

        d(i iVar) {
            this.f41854a = iVar;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.n.i
        public void a(boolean z3) {
            i iVar = this.f41854a;
            if (iVar != null) {
                iVar.a(z3);
            }
            if (z3) {
                com.qq.e.comm.plugin.apkmanager.x.d.c(1100905, n.this.f41841b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements r.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.apkmanager.x.f f41856a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f41857b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f41858c;

        e(com.qq.e.comm.plugin.apkmanager.x.f fVar, i iVar, File file) {
            this.f41856a = fVar;
            this.f41857b = iVar;
            this.f41858c = file;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r.d
        public void a(boolean z3) {
            if (z3) {
                this.f41856a.f41950f = 3;
            } else {
                this.f41856a.f41950f = 1;
            }
            this.f41857b.a(n.this.b(this.f41858c));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements c.a {
        f() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i4, String str, boolean z3) {
            if (i4 == 0) {
                n nVar = n.this;
                nVar.a(nVar.f41841b);
            }
            if (n.this.f41842c != null) {
                n.this.f41842c.a(i4, str, z3);
            }
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements p.i {
        g() {
        }

        @Override // com.qq.e.comm.plugin.util.p.i
        public void a() {
            if (!y.d(n.this.f41840a)) {
                c();
            } else {
                com.qq.e.comm.plugin.apkmanager.x.d.b(1100920, n.this.f41841b, 3);
            }
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            com.qq.e.comm.plugin.apkmanager.x.d.g();
            com.qq.e.comm.plugin.apkmanager.x.d.b(1100920, n.this.f41841b, 1);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface i {
        void a(boolean z3);
    }

    public n(Context context, ApkDownloadTask apkDownloadTask) {
        this.f41840a = context.getApplicationContext();
        this.f41841b = apkDownloadTask;
        this.f41843d = apkDownloadTask.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file, boolean z3) {
        this.f41844e--;
        com.qq.e.comm.plugin.apkmanager.d.a().a(file, this.f41843d, z3, new c(file, z3));
    }

    public boolean b(File file) {
        a();
        com.qq.e.comm.plugin.apkmanager.x.d.f();
        Intent a4 = a(this.f41840a, file);
        if (this.f41840a.getPackageManager().resolveActivity(a4, 0) != null) {
            try {
                this.f41840a.startActivity(a4);
                return true;
            } catch (Exception unused) {
                com.qq.e.comm.plugin.apkmanager.x.d.c(1100923, this.f41841b);
                return false;
            }
        }
        com.qq.e.comm.plugin.apkmanager.x.d.c(1100923, this.f41841b);
        return false;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(File file) {
        a(file, new a());
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class h implements e.b, b.InterfaceC0781b, p.h {

        /* renamed from: c  reason: collision with root package name */
        public static final h f41862c = new h();

        /* renamed from: a  reason: collision with root package name */
        private ConcurrentHashMap<String, c.a> f41863a = new ConcurrentHashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private com.qq.e.comm.plugin.apkmanager.b f41864b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f41865c;

            a(h hVar, String str) {
                this.f41865c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.e().a(this.f41865c, 1);
            }
        }

        private h() {
            com.qq.e.comm.plugin.apkmanager.e d4 = com.qq.e.comm.plugin.apkmanager.e.d();
            d4.a(this);
            d4.f();
            this.f41864b = new com.qq.e.comm.plugin.apkmanager.b(this);
            com.qq.e.comm.plugin.util.p.b().a(this);
        }

        public void a(c.a aVar, ApkDownloadTask apkDownloadTask) {
            if (aVar == null) {
                return;
            }
            String r3 = apkDownloadTask.r();
            if (TextUtils.isEmpty(r3)) {
                return;
            }
            this.f41863a.put(r3, new d.a(apkDownloadTask, aVar));
            this.f41864b.a(r3);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.e.b
        public void b(String str) {
            c.a remove;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f41863a.containsKey(str) && (remove = this.f41863a.remove(str)) != null) {
                remove.a(0, "", remove.a());
            }
            d0.f46406b.submit(new a(this, str));
            com.qq.e.comm.plugin.apkmanager.w.b.a().a(str);
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            return false;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.b.InterfaceC0781b
        public boolean c(String str) {
            return this.f41863a.containsKey(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.b.InterfaceC0781b
        public void a(String str) {
            b(str);
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            for (Map.Entry<String, c.a> entry : this.f41863a.entrySet()) {
                this.f41864b.a(entry.getKey());
            }
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(File file, boolean z3) {
        if (!z3) {
            com.qq.e.comm.plugin.apkmanager.f.a(this.f41841b, file);
        }
        com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(this.f41843d);
        boolean z4 = a4.f44822b == 4;
        if (this.f41841b.x()) {
            a4.f41948d = 10;
        } else if (z3) {
            a4.f41948d = z4 ? 12 : 1;
        } else {
            a4.f41948d = z4 ? 13 : 2;
        }
        a(file, new b(file, z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        com.qq.e.comm.plugin.n0.w.b.a(this.f41843d).f44823c = System.currentTimeMillis();
        com.qq.e.comm.plugin.n0.w.b.a(4001010, this.f41841b, 1);
        if (z3) {
            h.f41862c.a(this.f41845f, this.f41841b);
            return;
        }
        c.a aVar = this.f41842c;
        if (aVar != null) {
            aVar.a(1, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, i iVar) {
        d dVar = new d(iVar);
        r.a().c(new e(com.qq.e.comm.plugin.n0.w.b.a(this.f41843d), dVar, file));
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(c.a aVar) {
        this.f41842c = aVar;
    }

    private void a() {
        if (com.qq.e.comm.plugin.util.p.b().a((p.i) new g())) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.x.d.b(1100920, this.f41841b, 2);
    }

    private Intent a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri a4 = com.qq.e.comm.plugin.j.a.a(context, file);
        intent.addFlags(1);
        intent.setDataAndType(a4, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkDownloadTask apkDownloadTask) {
        com.qq.e.comm.plugin.n0.w.b.a(4001011, apkDownloadTask, 1, 0);
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        Intent a5 = u.a(a4, apkDownloadTask.r(), apkDownloadTask.f());
        if (a5 == null) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.u.a aVar = new com.qq.e.comm.plugin.apkmanager.u.a(a4, apkDownloadTask);
        aVar.a(new com.qq.e.comm.plugin.apkmanager.u.b(a5, apkDownloadTask, a4));
        aVar.b();
    }
}
