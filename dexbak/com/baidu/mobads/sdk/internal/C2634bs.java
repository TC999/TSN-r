package com.baidu.mobads.sdk.internal;

import io.netty.handler.codec.http.HttpConstants;

/* renamed from: com.baidu.mobads.sdk.internal.bs */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2634bs {

    /* renamed from: a */
    public static final String f8731a = "logger";

    /* renamed from: b */
    public static final int f8732b = 2;

    /* renamed from: c */
    public static final int f8733c = 3;

    /* renamed from: d */
    public static final int f8734d = 4;

    /* renamed from: e */
    public static final int f8735e = 5;

    /* renamed from: f */
    public static final int f8736f = 6;

    /* renamed from: g */
    public static final int f8737g = 7;

    /* renamed from: h */
    public static final int f8738h = -1;

    /* renamed from: i */
    private static volatile C2634bs f8739i;

    private C2634bs() {
    }

    /* renamed from: a */
    public static C2634bs m50744a() {
        if (f8739i == null) {
            synchronized (C2634bs.class) {
                if (f8739i == null) {
                    f8739i = new C2634bs();
                }
            }
        }
        return f8739i;
    }

    /* renamed from: e */
    private String m50724e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(HttpConstants.SP_CHAR);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m50741a(String str, int i) {
        return true;
    }

    /* renamed from: b */
    public void m50736b(String str) {
        if (m50743a(5)) {
            try {
                C2607aw.m50919c().mo50864e(str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public void m50728c(Object... objArr) {
        if (m50743a(6)) {
            m50731c(m50724e(objArr));
        }
    }

    /* renamed from: d */
    public void m50727d(String str) {
        m50735b(f8731a, str);
    }

    /* renamed from: d */
    public void m50725d(Object... objArr) {
        if (m50743a(4)) {
            m50727d(m50724e(objArr));
        }
    }

    /* renamed from: b */
    public void m50732b(Object... objArr) {
        if (m50743a(5)) {
            m50736b(m50724e(objArr));
        }
    }

    /* renamed from: c */
    public void m50731c(String str) {
        if (m50743a(6)) {
            try {
                C2607aw.m50919c().mo50860f(str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public void m50726d(String str, Throwable th) {
        if (m50743a(4)) {
            try {
                C2607aw.m50919c().mo50870c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public void m50734b(String str, Throwable th) {
        if (m50743a(5)) {
            try {
                C2607aw.m50919c().mo50866d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public void m50729c(Throwable th) {
        m50730c("", th);
    }

    /* renamed from: c */
    public void m50730c(String str, Throwable th) {
        if (m50743a(6)) {
            try {
                C2607aw.m50919c().mo50862e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public boolean m50743a(int i) {
        return m50741a(f8731a, i);
    }

    /* renamed from: b */
    public void m50733b(Throwable th) {
        m50734b("", th);
    }

    /* renamed from: a */
    public void m50737a(Object... objArr) {
        if (m50743a(3)) {
            m50742a(m50724e(objArr));
        }
    }

    /* renamed from: b */
    public void m50735b(String str, String str2) {
        if (m50743a(4)) {
            try {
                C2607aw.m50919c().mo50869c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public void m50742a(String str) {
        m50740a(f8731a, str);
    }

    /* renamed from: a */
    public void m50740a(String str, String str2) {
        if (m50743a(3)) {
            try {
                C2607aw.m50898h(str).mo50872c(str2);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public void m50738a(Throwable th) {
        m50739a("", th);
    }

    /* renamed from: a */
    public void m50739a(String str, Throwable th) {
        if (m50743a(3)) {
            try {
                C2607aw.m50898h(f8731a).mo50874b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
