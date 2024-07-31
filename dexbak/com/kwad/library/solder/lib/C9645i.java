package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.C9628a;
import com.kwad.library.solder.lib.ext.C9633c;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p360a.InterfaceC9609f;
import com.kwad.sdk.utils.C11064bn;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.library.solder.lib.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9645i {
    private static volatile C9645i ajl;
    private static Set<String> ajn = new HashSet();
    @Nullable
    private static InterfaceC9651a ajo;
    private C9622e ajm;
    private volatile boolean mHasInit = false;

    /* renamed from: com.kwad.library.solder.lib.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9651a {
        /* renamed from: b */
        void mo24667b(String str, File file);

        /* renamed from: d */
        void mo24666d(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();

        /* renamed from: xh */
        boolean mo24665xh();
    }

    private C9645i() {
    }

    /* renamed from: bN */
    private static ExecutorService m28109bN(int i) {
        return new ThreadPoolExecutor(i, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    C9645i.ajn.add(thread.getName());
                } catch (Throwable th) {
                    C9603a.m28252e("Sodler", Log.getStackTraceString(th));
                }
                return thread;
            }
        });
    }

    private synchronized void init(Context context) {
        if (this.mHasInit) {
            return;
        }
        C9633c.C9634a m28145bP = new C9633c.C9634a().m28145bP("sodler");
        InterfaceC9651a interfaceC9651a = ajo;
        C9633c.C9634a m28142bh = m28145bP.m28144bQ(interfaceC9651a != null ? interfaceC9651a.getMaxRetryCount() : 1).m28142bh(false);
        InterfaceC9651a interfaceC9651a2 = ajo;
        C9633c.C9634a m28141bi = m28142bh.m28141bi(interfaceC9651a2 != null && interfaceC9651a2.mo24665xh());
        InterfaceC9651a interfaceC9651a3 = ajo;
        C9633c.C9634a m28146a = m28141bi.m28146a(m28109bN(interfaceC9651a3 != null ? interfaceC9651a3.getCorePoolSize() : 0));
        InterfaceC9651a interfaceC9651a4 = ajo;
        C9633c m28140xJ = m28146a.m28143bR(interfaceC9651a4 != null ? interfaceC9651a4.getCorePoolSize() : 0).m28140xJ();
        C9618d c9618d = new C9618d(context);
        C9615c c9615c = new C9615c(context, m28140xJ);
        C9642f c9642f = new C9642f(context);
        c9642f.mo28123a(new InterfaceC9609f.InterfaceC9610a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.p360a.InterfaceC9609f.InterfaceC9610a
            /* renamed from: a */
            public final void mo28102a(AbstractC9608e abstractC9608e, File file) {
                if (C9645i.ajo != null) {
                    try {
                        C9645i.ajo.mo24667b(abstractC9608e.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        C9645i.ajo.mo24666d(abstractC9608e.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), 2010);
                    }
                }
            }
        });
        this.ajm = new C9622e(c9618d, c9642f, c9615c, m28140xJ, new C9628a());
        this.mHasInit = true;
    }

    /* renamed from: xe */
    public static C9645i m28105xe() {
        if (ajl == null) {
            synchronized (C9645i.class) {
                if (ajl == null) {
                    ajl = new C9645i();
                }
            }
        }
        return ajl;
    }

    /* renamed from: j */
    public final void m28108j(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (m28106wY() == null || m28106wY().m28148xI() == null) {
            return;
        }
        m28106wY().m28148xI().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C9645i.this.ajm.mo28174xb().mo28206bE(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }

    @Nullable
    /* renamed from: k */
    public final AbstractC9604a m28107k(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        C9622e c9622e = this.ajm;
        if (c9622e != null) {
            return c9622e.mo28176wZ().mo28193bG(str);
        }
        return null;
    }

    /* renamed from: wY */
    public final C9633c m28106wY() {
        if (this.mHasInit) {
            return this.ajm.mo28177wY();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    /* renamed from: a */
    public static void m28111a(InterfaceC9651a interfaceC9651a) {
        ajo = interfaceC9651a;
    }

    /* renamed from: a */
    public final <P extends AbstractC9604a, R extends AbstractC9608e<P>> void m28112a(Context context, @NonNull R r, InterfaceC9629b<P, R> interfaceC9629b) {
        init(context);
        r.m28232bP(this.ajm.mo28177wY().getRetryCount());
        r.m28239a(new C9611b<P, R>(interfaceC9629b, new InterfaceC9629b.C9631b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.C9611b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final void mo24650a(final AbstractC9608e abstractC9608e, PluginError pluginError) {
                super.mo24650a((C96483<P, R>) abstractC9608e, pluginError);
                C9603a.m28252e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                C9645i.this.ajm.m28178i(abstractC9608e);
                C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (abstractC9608e.m28226xo()) {
                            C9645i.this.ajm.m28184a(abstractC9608e, 16);
                        }
                    }
                }, abstractC9608e.m28227xn() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.ajm.m28184a(r, 16);
    }
}
