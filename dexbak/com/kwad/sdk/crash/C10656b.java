package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.threads.C10506a;
import com.kwad.sdk.crash.C10674g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.C10684a;
import com.kwad.sdk.crash.handler.C10687c;
import com.kwad.sdk.crash.handler.C10689d;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.p426a.C10655a;
import com.kwad.sdk.crash.p427b.C10666a;
import com.kwad.sdk.crash.report.AbstractC10713c;
import com.kwad.sdk.crash.report.C10712b;
import com.kwad.sdk.crash.report.C10718f;
import com.kwad.sdk.crash.report.C10719g;
import com.kwad.sdk.crash.utils.C10741e;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11137y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.crash.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10656b {
    private static volatile boolean aFc;
    private static volatile boolean aFd;

    /* renamed from: WA */
    private static Handler f29654WA = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aFe = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aFf = false;
    private static boolean aFg = false;

    /* renamed from: Hd */
    public static boolean m25224Hd() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aFe) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: He */
    public static void m25223He() {
        AnrHandler.getInstance().init(C10655a.m25227HG(), new InterfaceC10673f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.InterfaceC10673f
            /* renamed from: a */
            public final void mo25125a(int i, ExceptionMessage exceptionMessage) {
                C10671e.m25134Hu().m25127b(i, exceptionMessage);
            }
        }, new AbstractC10713c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.InterfaceC10717e
            /* renamed from: Hp */
            public final File mo25040Hp() {
                return new File(C10655a.m25229HE(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.InterfaceC10717e
            /* renamed from: a */
            public final void mo25039a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                C10331c.m26254d("AdExceptionCollector", "ANR upload");
                m25054a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    /* renamed from: Hf */
    private static synchronized void m25222Hf() {
        synchronized (C10656b.class) {
            if (!aFc) {
                aFc = true;
                C10506a.m25587Fy().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            C10656b.m25221Hg();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(C10670d.aFI));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Hg */
    public static void m25221Hg() {
        m25220Hh();
        if (aFf) {
            m25219Hi();
        }
        if (aFg) {
            m25218Hj();
        }
    }

    /* renamed from: Hh */
    private static void m25220Hh() {
        C10331c.m26254d("AdExceptionCollector", "reportJavaException");
        C10718f c10718f = new C10718f();
        c10718f.m25046a(C10687c.m25109HK().getUploader());
        c10718f.m25048C(C10655a.m25228HF());
    }

    /* renamed from: Hi */
    private static void m25219Hi() {
        C10331c.m26254d("AdExceptionCollector", "reportAnrException");
        C10712b c10712b = new C10712b();
        c10712b.m25046a(AnrHandler.getInstance().getUploader());
        c10712b.m25048C(C10655a.m25227HG());
    }

    /* renamed from: Hj */
    private static void m25218Hj() {
        C10331c.m26254d("AdExceptionCollector", "reportNativeException");
        C10719g c10719g = new C10719g();
        c10719g.m25046a(NativeCrashHandler.getInstance().getUploader());
        c10719g.m25048C(C10655a.m25226HH());
    }

    /* renamed from: a */
    public static void m25214a(@NonNull C10668c c10668c) {
        if (c10668c.context == null || aFd) {
            return;
        }
        aFd = true;
        aFf = c10668c.aFf;
        aFg = c10668c.aFg;
        try {
            C10741e.init(c10668c.context);
            C10655a.init(c10668c.context, c10668c.aFt);
            C10671e.m25134Hu().m25128a(c10668c);
            m25212bu(c10668c.context);
            if (!m25213bt(c10668c.context) && (aFf || aFg)) {
                C10674g.m25123a(c10668c, new C10674g.InterfaceC10676a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.C10674g.InterfaceC10676a
                    /* renamed from: Hn */
                    public final void mo25116Hn() {
                        C10656b.f29654WA.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                C10331c.m26246w("AdExceptionCollector", "ExceptionSoLoadHelper.init onLoad");
                                if (C10656b.aFf) {
                                    C10656b.m25223He();
                                }
                                if (C10656b.aFg) {
                                    C10656b.m25211c(false, "/sdcard/");
                                }
                            }
                        });
                    }

                    @Override // com.kwad.sdk.crash.C10674g.InterfaceC10676a
                    /* renamed from: Ho */
                    public final void mo25115Ho() {
                        C10331c.m26246w("AdExceptionCollector", "ExceptionSoLoadHelper.init fail");
                    }
                });
            }
            m25222Hf();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: bt */
    private static boolean m25213bt(Context context) {
        return context == null || C11137y.m23585cb(context) >= 3;
    }

    /* renamed from: bu */
    private static void m25212bu(Context context) {
        C10687c.m25109HK().init(C10655a.m25228HF(), new InterfaceC10673f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.InterfaceC10673f
            /* renamed from: a */
            public final void mo25125a(int i, ExceptionMessage exceptionMessage) {
                C10671e.m25134Hu().m25127b(i, exceptionMessage);
            }
        }, new AbstractC10713c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.InterfaceC10717e
            /* renamed from: Hp */
            public final File mo25040Hp() {
                return new File(C10655a.m25229HE(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.InterfaceC10717e
            /* renamed from: a */
            public final void mo25039a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                m25054a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new C10689d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m25211c(boolean z, String str) {
        if (C10655a.m25230A(C10655a.m25226HH())) {
            NativeCrashHandler.getInstance().init(C10655a.m25226HH(), z, str, new AbstractC10713c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.InterfaceC10717e
                /* renamed from: Hp */
                public final File mo25040Hp() {
                    return new File(C10655a.m25229HE(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.InterfaceC10717e
                /* renamed from: a */
                public final void mo25039a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    C10331c.m26254d("AdExceptionCollector", "Native upload");
                    m25054a(exceptionMessage, 4, countDownLatch);
                }
            });
        }
    }

    /* renamed from: n */
    public static void m25209n(@NonNull final Throwable th) {
        C11095g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (C10666a.m25204o(th)) {
                        C10684a.m25110p(th);
                    }
                } catch (Throwable th2) {
                    C10331c.printStackTrace(th2);
                }
            }
        });
    }
}
