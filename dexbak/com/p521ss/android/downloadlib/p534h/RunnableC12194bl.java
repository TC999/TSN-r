package com.p521ss.android.downloadlib.p534h;

import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.C12265s;
import java.lang.ref.SoftReference;

/* renamed from: com.ss.android.downloadlib.h.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC12194bl<P, R> implements Runnable {

    /* renamed from: a */
    private R f34466a;

    /* renamed from: bl */
    private int f34467bl;

    /* renamed from: kf */
    private RunnableC12194bl<R, ?> f34468kf;

    /* renamed from: n */
    private RunnableC12194bl<?, P> f34469n;

    /* renamed from: ok */
    private P f34470ok;

    /* renamed from: s */
    private SoftReference<InterfaceC12195ok<P, R>> f34471s;

    /* renamed from: com.ss.android.downloadlib.h.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12195ok<PARAM, RESULT> {
        /* renamed from: ok */
        RESULT mo18812ok(PARAM param);
    }

    private RunnableC12194bl(int i, InterfaceC12195ok<P, R> interfaceC12195ok, P p) {
        this.f34467bl = i;
        this.f34471s = new SoftReference<>(interfaceC12195ok);
        this.f34470ok = p;
    }

    /* renamed from: a */
    private R m18817a() {
        return this.f34466a;
    }

    /* renamed from: ok */
    public static <P, R> RunnableC12194bl<P, R> m18813ok(InterfaceC12195ok<P, R> interfaceC12195ok, P p) {
        return new RunnableC12194bl<>(2, interfaceC12195ok, p);
    }

    @Override // java.lang.Runnable
    public void run() {
        RunnableC12194bl<?, P> runnableC12194bl;
        if (this.f34467bl == 0 && !C12197j.m18809a()) {
            C12184h.m18835ok().m18841a().post(this);
        } else if (this.f34467bl == 1 && C12197j.m18809a()) {
            C12265s.m18554ok().m18553ok(this);
        } else if (this.f34467bl == 2 && C12197j.m18809a()) {
            C12265s.m18554ok().m18558a(this);
        } else {
            if (this.f34470ok == null && (runnableC12194bl = this.f34469n) != null) {
                this.f34470ok = runnableC12194bl.m18817a();
            }
            InterfaceC12195ok<P, R> interfaceC12195ok = this.f34471s.get();
            if (interfaceC12195ok == null) {
                return;
            }
            this.f34466a = interfaceC12195ok.mo18812ok(this.f34470ok);
            RunnableC12194bl<R, ?> runnableC12194bl2 = this.f34468kf;
            if (runnableC12194bl2 != null) {
                runnableC12194bl2.run();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ok */
    public <NR> RunnableC12194bl<R, NR> m18815ok(int i, InterfaceC12195ok<R, NR> interfaceC12195ok) {
        RunnableC12194bl runnableC12194bl = (RunnableC12194bl<R, ?>) new RunnableC12194bl(i, interfaceC12195ok, null);
        this.f34468kf = runnableC12194bl;
        runnableC12194bl.f34469n = this;
        return runnableC12194bl;
    }

    /* renamed from: ok */
    public <NR> RunnableC12194bl<R, NR> m18814ok(InterfaceC12195ok<R, NR> interfaceC12195ok) {
        return m18815ok(0, interfaceC12195ok);
    }

    /* renamed from: ok */
    public void m18816ok() {
        RunnableC12194bl<?, P> runnableC12194bl = this.f34469n;
        if (runnableC12194bl != null) {
            runnableC12194bl.m18816ok();
        } else {
            run();
        }
    }
}
