package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import androidx.core.app.NotificationCompat;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.CacheInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.BridgeInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.CallServerInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RealInterceptorChain;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RetryAndFollowUpInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.ConnectInterceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealCall implements Call {

    /* renamed from: a */
    final OkHttpClient f1447a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f1448b;

    /* renamed from: c */
    private EventListener f1449c;

    /* renamed from: d */
    final Request f1450d;

    /* renamed from: e */
    final boolean f1451e;

    /* renamed from: f */
    private boolean f1452f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.x$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1082a extends NamedRunnable {

        /* renamed from: b */
        private final Callback f1453b;

        C1082a(Callback callback) {
            super("OkHttp %s", RealCall.this.m58217c());
            this.f1453b = callback;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        protected void mo58214b() {
            IOException e;
            Response m58222a;
            boolean z = true;
            try {
                try {
                    m58222a = RealCall.this.m58222a();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (RealCall.this.f1448b.m58746a()) {
                        this.f1453b.mo58423a(RealCall.this, new IOException("Canceled"));
                    } else {
                        this.f1453b.mo58424a(RealCall.this, m58222a);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (!z) {
                        RealCall.this.f1449c.m58361a(RealCall.this, e);
                        this.f1453b.mo58423a(RealCall.this, e);
                    } else {
                        Platform m58485b = Platform.m58485b();
                        m58485b.mo58493a(4, "Callback failure for " + RealCall.this.m58216d(), e);
                    }
                }
            } finally {
                RealCall.this.f1447a.m58258g().m58372b(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public String m58213c() {
            return RealCall.this.f1450d.m58205g().m58307g();
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f1447a = okHttpClient;
        this.f1450d = request;
        this.f1451e = z;
        this.f1448b = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    /* renamed from: e */
    private void m58215e() {
        this.f1448b.m58740a(Platform.m58485b().mo58492a("response.body().close()"));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call
    /* renamed from: A */
    public Response mo58223A() throws IOException {
        synchronized (this) {
            if (!this.f1452f) {
                this.f1452f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m58215e();
        this.f1449c.m58354b(this);
        try {
            try {
                this.f1447a.m58258g().m58375a(this);
                Response m58222a = m58222a();
                if (m58222a != null) {
                    return m58222a;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                this.f1449c.m58361a(this, e);
                throw e;
            }
        } finally {
            this.f1447a.m58258g().m58371b(this);
        }
    }

    /* renamed from: b */
    public boolean m58218b() {
        return this.f1448b.m58746a();
    }

    /* renamed from: c */
    String m58217c() {
        return this.f1450d.m58205g().m58302l();
    }

    /* renamed from: d */
    String m58216d() {
        StringBuilder sb = new StringBuilder();
        sb.append(m58218b() ? "canceled " : "");
        sb.append(this.f1451e ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(m58217c());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static RealCall m58220a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.f1449c = okHttpClient.m58256i().mo58346a(realCall);
        return realCall;
    }

    /* renamed from: clone */
    public RealCall m60087clone() {
        return m58220a(this.f1447a, this.f1450d, this.f1451e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call
    /* renamed from: a */
    public void mo58221a(Callback callback) {
        synchronized (this) {
            if (!this.f1452f) {
                this.f1452f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m58215e();
        this.f1449c.m58354b(this);
        this.f1447a.m58258g().m58376a(new C1082a(callback));
    }

    /* renamed from: a */
    Response m58222a() throws IOException {
        ArrayList arrayList = new ArrayList(this.f1447a.m58252m());
        arrayList.add(this.f1448b);
        arrayList.add(new BridgeInterceptor(this.f1447a.m58259f()));
        arrayList.add(new CacheInterceptor(this.f1447a.m58251n()));
        arrayList.add(new ConnectInterceptor(this.f1447a));
        if (!this.f1451e) {
            arrayList.addAll(this.f1447a.m58250o());
        }
        arrayList.add(new CallServerInterceptor(this.f1451e));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.f1450d, this, this.f1449c, this.f1447a.m58262c(), this.f1447a.m58245t(), this.f1447a.m58241x()).mo58273a(this.f1450d);
    }
}
