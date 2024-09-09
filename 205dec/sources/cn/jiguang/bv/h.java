package cn.jiguang.bv;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h extends cn.jiguang.cm.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2946a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2947b;

    /* renamed from: c  reason: collision with root package name */
    private cn.jiguang.ca.a f2948c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2949d = false;

    static {
        cn.jiguang.bt.b.a("NetworkingClient");
    }

    public h(Context context) {
        this.f2947b = context;
        this.f2948c = c.d(context) ? new cn.jiguang.ca.b(8128, 20) : new cn.jiguang.ca.c(8128, 20);
        this.f3462h = "NetworkingClient";
    }

    private void a(cn.jiguang.ca.a aVar, ByteBuffer byteBuffer) {
        cn.jiguang.bt.b.a(new q(aVar, this.f2947b, byteBuffer.array()), new int[0]);
    }

    private boolean a(Context context) {
        String str;
        cn.jiguang.bq.d.c("NetworkingClient", "google:false");
        cn.jiguang.cc.a.a(context);
        try {
            this.f2948c = new j(k.a(context)).a(this);
        } catch (Exception e4) {
            if (e4 instanceof cn.jiguang.bx.f) {
                cn.jiguang.bq.d.j("NetworkingClient", "connect failed, errCode: " + ((cn.jiguang.bx.f) e4).a());
            }
            this.f2949d = true;
            a(1);
            str = "sis and connect failed:" + e4;
        }
        if (b(2)) {
            return true;
        }
        str = "login failed";
        cn.jiguang.bq.d.i("NetworkingClient", str);
        return false;
    }

    private boolean b(int i4) {
        int i5;
        if (this.f2946a) {
            return false;
        }
        if (i4 <= 0) {
            cn.jiguang.bq.d.d("NetworkingClient", "login error,retry login too many times");
            f();
            i5 = 4;
        } else {
            cn.jiguang.bq.d.c("NetworkingClient", "loginTimes:" + i4);
            if (!e()) {
                return false;
            }
            cn.jiguang.cf.c a4 = cn.jiguang.cf.c.a();
            cn.jiguang.ca.a aVar = this.f2948c;
            String c4 = a4.c(aVar.f3213h, aVar.f3214i, aVar.f3212g);
            int a5 = c.a(this.f2947b, this.f2948c);
            cn.jiguang.cf.c.a().f(c4, a5);
            if (a5 >= 0) {
                if (a5 <= 0) {
                    cn.jiguang.bx.h.a().a(this.f2947b, "tcp_a10", null);
                    return true;
                }
                f();
                if (a5 == 108) {
                    cn.jiguang.bt.b.a(this.f2947b);
                    return b(i4 - 1);
                }
                c(a5);
                return false;
            }
            i5 = 2;
        }
        a(i5);
        return false;
    }

    private void c(int i4) {
        cn.jiguang.bq.d.a("NetworkingClient", "Action - onLoginFailed - respCode:" + i4);
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", i4);
        cn.jiguang.bx.h.a().a(this.f2947b, "tcp_a12", bundle);
    }

    private boolean e() {
        if (!cn.jiguang.d.b.a(this.f2947b) || TextUtils.isEmpty(cn.jiguang.d.a.i(this.f2947b))) {
            cn.jiguang.cf.c a4 = cn.jiguang.cf.c.a();
            cn.jiguang.ca.a aVar = this.f2948c;
            String b4 = a4.b(aVar.f3213h, aVar.f3214i, aVar.f3212g);
            int b5 = c.b(this.f2947b, this.f2948c);
            cn.jiguang.cf.c.a().e(b4, b5);
            if (b5 == 0) {
                cn.jiguang.bx.h.a().a(this.f2947b, "tcp_a11", null);
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("resCode", b5);
            cn.jiguang.bx.h.a().a(this.f2947b, "tcp_a13", bundle);
            f();
            a(3);
            return false;
        }
        return true;
    }

    private void f() {
        c.b(this.f2947b);
    }

    @Override // cn.jiguang.cm.b
    public void a() {
        cn.jiguang.bq.d.g("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
        } catch (Throwable th) {
            cn.jiguang.bq.d.f("NetworkingClient", "run exception", th);
        }
        if (!a(this.f2947b)) {
            cn.jiguang.bq.d.d("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        while (!this.f2946a) {
            cn.jiguang.bq.d.e("NetworkingClient", "Network listening...");
            try {
                ByteBuffer a4 = this.f2948c.a();
                a(this.f2948c, a4);
                cn.jiguang.bq.d.d("NetworkingClient", "Received bytes - len:" + a4.array().length + ", pkg:" + cn.jiguang.f.a.c(this.f2947b));
            } catch (cn.jiguang.bx.f e4) {
                cn.jiguang.bq.d.k("NetworkingClient", " recv failed with error:" + e4 + " ,No Break!!");
            }
        }
        if (this.f2946a) {
            cn.jiguang.bq.d.d("NetworkingClient", "Break receiving by wantStop");
        }
        a(1);
    }

    public void a(int i4) {
        cn.jiguang.bq.d.d("NetworkingClient", "Action - closeConnection");
        cn.jiguang.f.i.a(this.f2948c);
        Bundle bundle = new Bundle();
        bundle.putBoolean("connect_state", this.f2949d);
        cn.jiguang.bx.h.a().a(this.f2947b, "tcp_a19", bundle);
        cn.jiguang.cf.c a4 = cn.jiguang.cf.c.a();
        cn.jiguang.ca.a aVar = this.f2948c;
        a4.a(aVar.f3213h, aVar.f3214i, aVar.f3212g, i4);
    }

    public synchronized void b() {
        try {
            cn.jiguang.cm.d.a("TCP_CONN_TASK", this);
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("NetworkingClient", "execute networkingClient exception :" + th);
        }
    }

    public synchronized void c() {
        cn.jiguang.bq.d.d("NetworkingClient", "Action - stop");
        cn.jiguang.f.i.a(this.f2948c);
        this.f2946a = true;
        cn.jiguang.cm.d.a("TCP_CONN_TASK");
    }

    public cn.jiguang.ca.a d() {
        return this.f2948c;
    }
}
