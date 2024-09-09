package com.qq.e.comm.plugin.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.i.b;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    private static final String f46284g = "c";

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.a f46285a;

    /* renamed from: b  reason: collision with root package name */
    private final q f46286b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f46287c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i.d0.b f46288d;

    /* renamed from: e  reason: collision with root package name */
    private ADListener f46289e;

    /* renamed from: f  reason: collision with root package name */
    private String f46290f;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends com.qq.e.comm.plugin.i.d0.d {

        /* renamed from: d  reason: collision with root package name */
        private boolean f46291d;

        /* renamed from: e  reason: collision with root package name */
        private final b.a f46292e;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.u.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0901a implements b.a {
            C0901a() {
            }

            @Override // com.qq.e.comm.plugin.i.b.a
            public void a() {
                if (c.this.f46289e != null) {
                    if (a.this.f46291d) {
                        a.this.a(302);
                    }
                    a.this.a(1003);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class b implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f46295c;

            b(int i4) {
                this.f46295c = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f46289e != null) {
                    c.this.f46289e.onADEvent(new ADEvent(this.f46295c, new Object[0]));
                }
            }
        }

        a(Context context, com.qq.e.comm.plugin.apkmanager.w.a aVar) {
            super(context, aVar);
            this.f46292e = new C0901a();
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void c() {
            super.c();
            a(1007);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public boolean a(String str, com.qq.e.comm.plugin.g0.e eVar) {
            boolean a4 = super.a(str, eVar);
            if (a4) {
                a(1002);
                this.f46291d = false;
                com.qq.e.comm.plugin.i.b.a(this.f46292e);
            }
            return a4;
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(boolean z3) {
            super.a(z3);
            if (z3) {
                a(303);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i4) {
            p0.a((Runnable) new b(i4));
        }
    }

    public c(Context context, com.qq.e.comm.plugin.u.a aVar, q qVar) {
        this.f46287c = context;
        this.f46285a = aVar;
        this.f46286b = qVar;
        a aVar2 = new a(context, aVar);
        aVar2.a(qVar);
        this.f46288d = aVar2;
    }

    private boolean a(int i4) {
        return i4 == 1 || i4 == 2 || i4 == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ADListener aDListener) {
        this.f46289e = aDListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.qq.e.comm.plugin.i.f fVar) {
        this.f46285a.a(200);
        com.qq.e.comm.plugin.u.a aVar = this.f46285a;
        if (aVar.f46248j == null) {
            String str = f46284g;
            d1.b(str, "ExpressAdDataController click error  mAdViewController: " + this.f46285a.f46248j);
            return;
        }
        aVar.a((View) null);
        h.b e4 = new h.b(this.f46286b).a(fVar.f44105b).b(fVar.f44110g).c(fVar.f44106c).a(fVar.f44109f).e(fVar.f44116m);
        if (a(fVar.f44108e)) {
            com.qq.e.comm.plugin.i.g.b(e4.a(), this.f46288d);
        } else {
            com.qq.e.comm.plugin.i.g.a(e4.e(fVar.f44114k).a(fVar.f44115l).a(), this.f46288d);
        }
        l1.a(this.f46285a.e(), this.f46286b, this.f46290f);
        this.f46285a.a(105, new Object[0]);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.qq.e.comm.plugin.u.a aVar = this.f46285a;
            if (aVar.f46248j != null) {
                aVar.a((View) null);
                com.qq.e.comm.plugin.e.a.a().a(this.f46285a.e(), this.f46286b, str);
                com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f46285a.e());
                if (d4 != null) {
                    d4.a(2);
                }
                this.f46290f = com.qq.e.comm.plugin.e.a.a().a(this.f46285a.e());
                com.qq.e.comm.plugin.i.g.a(new h.b(this.f46286b).a(this.f46290f).a(2).a(), this.f46288d);
                l1.a(this.f46285a.e(), this.f46286b, this.f46290f);
                this.f46285a.a(105, new Object[0]);
                return;
            }
        }
        String str2 = f46284g;
        d1.b(str2, "ExpressAdDataController click error params: " + str + " mAdViewController: " + this.f46285a.f46248j);
    }
}
