package com.bytedance.sdk.component.f.w.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.a;
import com.bytedance.keva.b;
import com.bytedance.keva.d;
import com.bytedance.sdk.component.f.xv;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.f.w.c {

    /* renamed from: c  reason: collision with root package name */
    private a f29793c;

    /* renamed from: w  reason: collision with root package name */
    private static final Map<String, com.bytedance.sdk.component.f.c> f29792w = new HashMap();
    private static volatile boolean xv = false;
    private static volatile boolean sr = true;

    private c(String str, boolean z3, int i4) {
        if (i4 != 1) {
            sr(str, z3);
        } else {
            xv(str, z3);
        }
    }

    private void sr(String str, boolean z3) {
        if (z3) {
            this.f29793c = a.u(str, 1);
        } else {
            this.f29793c = a.u(str, 0);
        }
    }

    private void xv(String str, boolean z3) {
        if (z3) {
            this.f29793c = a.r(str, 1);
        } else {
            this.f29793c = a.r(str, 0);
        }
    }

    @Override // com.bytedance.sdk.component.f.c
    public int w(String str, int i4) {
        return this.f29793c.o(str, i4);
    }

    public static com.bytedance.sdk.component.f.c c(Context context, String str, boolean z3, int i4) {
        if (sr) {
            try {
                if (!xv) {
                    xv = c(context);
                }
                if (TextUtils.isEmpty(str)) {
                    str = "tt_ad_sdk_keva";
                }
                Map<String, com.bytedance.sdk.component.f.c> map = f29792w;
                com.bytedance.sdk.component.f.c cVar = map.get(str);
                if (cVar == null) {
                    c cVar2 = new c(str, z3, i4);
                    map.put(str, cVar2);
                    return cVar2;
                }
                return cVar;
            } catch (Throwable unused) {
                sr = false;
                return null;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.c
    public long w(String str, long j4) {
        return this.f29793c.p(str, j4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public float w(String str, float f4) {
        return this.f29793c.n(str, f4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public boolean w(String str, boolean z3) {
        return this.f29793c.j(str, z3);
    }

    @Override // com.bytedance.sdk.component.f.c
    public String w(String str, String str2) {
        return this.f29793c.v(str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Set<String> w(String str, Set<String> set) {
        return this.f29793c.z(str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void w() {
        this.f29793c.c();
    }

    private static boolean c(Context context) {
        if (context == null) {
            context = xv.getContext();
        }
        if (context == null) {
            return false;
        }
        b b4 = b.b();
        b4.e(new d() { // from class: com.bytedance.sdk.component.f.w.c.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.keva.d
            public void loadLibrary(String str) {
                try {
                    super.loadLibrary(str);
                } catch (Throwable th) {
                    boolean unused = c.sr = false;
                    reportThrowable(1, null, null, null, th);
                }
            }

            @Override // com.bytedance.keva.d
            protected void logDebug(String str) {
            }

            @Override // com.bytedance.keva.d
            protected void onLoadRepo(String str, int i4) {
            }

            @Override // com.bytedance.keva.d
            protected void reportThrowable(int i4, String str, String str2, Object obj, Throwable th) {
            }

            @Override // com.bytedance.keva.d
            protected void reportWarning(int i4, String str, String str2, Object obj, String str3) {
            }
        });
        b4.c(context);
        return true;
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, int i4) {
        this.f29793c.J(str, i4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, long j4) {
        this.f29793c.K(str, j4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, float f4) {
        this.f29793c.I(str, f4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, boolean z3) {
        this.f29793c.E(str, z3);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, String str2) {
        this.f29793c.L(str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, Set<String> set) {
        this.f29793c.P(str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Map<String, ?> c() {
        return this.f29793c.i();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str) {
        this.f29793c.g(str);
    }
}
