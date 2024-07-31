package com.kwad.sdk.core.p397e;

import android.util.Log;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.p379h.C9837a;
import com.kwad.sdk.core.p397e.p398a.InterfaceC10329a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.sdk.core.e.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C10331c {
    public static boolean avj = true;
    private static boolean avk = C10328a.f29548md.booleanValue();
    private static final InterfaceC10329a avl = new C10330b();
    private static final List<InterfaceC10329a> avm = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.e.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10342a {
        /* renamed from: b */
        void mo26243b(InterfaceC10329a interfaceC10329a);
    }

    @ForInvoker(methodId = "registerLogger")
    /* renamed from: DL */
    private static void m26260DL() {
        C9837a.register();
    }

    /* renamed from: R */
    private static void m26259R(final String str, final String str2) {
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.1
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26267d(str, str2);
            }
        });
    }

    /* renamed from: S */
    private static void m26258S(String str, String str2) {
        if (str2 != null && str2.length() > 4000) {
            m26259R(str, str2.substring(0, 4000));
            m26258S(str, str2.substring(4000));
            return;
        }
        m26259R(str, str2);
    }

    /* renamed from: T */
    public static void m26257T(final String str, String str2) {
        final String m26252dN = m26252dN(str2);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.5
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26263v(C10331c.m26253dM(str), m26252dN, true);
            }
        });
    }

    /* renamed from: a */
    public static void m26256a(InterfaceC10329a interfaceC10329a) {
        List<InterfaceC10329a> list = avm;
        if (list.contains(interfaceC10329a)) {
            return;
        }
        list.add(interfaceC10329a);
    }

    /* renamed from: d */
    public static void m26254d(String str, String str2) {
        m26258S(m26253dM(str), m26252dN(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dM */
    public static String m26253dM(String str) {
        return "KSAd_" + str;
    }

    /* renamed from: dN */
    private static String m26252dN(String str) {
        return str + " " + m26244wV();
    }

    /* renamed from: e */
    public static void m26250e(final String str, String str2) {
        final String m26252dN = m26252dN(str2);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.9
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26266e(C10331c.m26253dM(str), m26252dN);
            }
        });
    }

    /* renamed from: i */
    public static void m26248i(final String str, String str2) {
        final String m26252dN = m26252dN(str2);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.6
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26265i(C10331c.m26253dM(str), m26252dN);
            }
        });
    }

    public static void init(boolean z) {
        avj = z;
        List<InterfaceC10329a> list = avm;
        list.clear();
        list.add(avl);
        m26260DL();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.2
                @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
                /* renamed from: b */
                public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                    interfaceC10329a.printStackTraceOnly(th);
                }
            });
        }
        if (C10328a.f29548md.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.3
                @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
                /* renamed from: b */
                public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                    interfaceC10329a.printStackTraceOnly(th);
                }
            });
        }
    }

    /* renamed from: v */
    public static void m26247v(final String str, String str2) {
        final String m26252dN = m26252dN(str2);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.4
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26264v(C10331c.m26253dM(str), m26252dN);
            }
        });
    }

    /* renamed from: w */
    public static void m26246w(final String str, String str2) {
        final String m26252dN = m26252dN(str2);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.7
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26262w(C10331c.m26253dM(str), m26252dN);
            }
        });
    }

    /* renamed from: wV */
    private static String m26244wV() {
        String str;
        int i;
        if (avk) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 3) {
                str = stackTrace[3].getFileName();
                i = stackTrace[3].getLineNumber();
            } else {
                str = "unknown";
                i = -1;
            }
            return "(" + str + ':' + i + ')';
        }
        return "";
    }

    /* renamed from: a */
    private static void m26255a(InterfaceC10342a interfaceC10342a) {
        for (InterfaceC10329a interfaceC10329a : avm) {
            if (interfaceC10329a != null) {
                try {
                    interfaceC10342a.mo26243b(interfaceC10329a);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: e */
    public static void m26249e(final String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        final String m26252dN = m26252dN(str2 + '\n' + stackTraceString);
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.10
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26266e(C10331c.m26253dM(str), m26252dN);
            }
        });
    }

    /* renamed from: w */
    public static void m26245w(final String str, Throwable th) {
        final String m26252dN = m26252dN(Log.getStackTraceString(th));
        m26255a(new InterfaceC10342a() { // from class: com.kwad.sdk.core.e.c.8
            @Override // com.kwad.sdk.core.p397e.C10331c.InterfaceC10342a
            /* renamed from: b */
            public final void mo26243b(InterfaceC10329a interfaceC10329a) {
                interfaceC10329a.mo26261w(C10331c.m26253dM(str), m26252dN, C10328a.f29548md.booleanValue());
            }
        });
    }
}
