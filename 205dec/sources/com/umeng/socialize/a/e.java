package com.umeng.socialize.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.socialize.utils.ContextUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SharedPrefs.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53891a = "Prefs";

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f53892c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f53893b;

    /* renamed from: d  reason: collision with root package name */
    private final a f53894d = new a("AZX");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: SharedPrefs.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final String f53896b;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f53896b = str;
        }

        private String b(String str) {
            return this.f53896b + str;
        }

        private String c(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    return b.a().b(str, str2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return str2;
        }

        private void d(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str, str2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        public void a(String str, int i4) {
            d(b(str), String.valueOf(i4));
        }

        public void a(String str, long j4) {
            d(b(str), String.valueOf(j4));
        }

        public int b(String str, int i4) {
            try {
                return Integer.parseInt(c(b(str), String.valueOf(i4)));
            } catch (Exception unused) {
                return i4;
            }
        }

        public void a(String str, float f4) {
            d(b(str), String.valueOf(f4));
        }

        public void a(String str, String str2) {
            d(b(str), String.valueOf(str2));
        }

        public long b(String str, long j4) {
            try {
                return Long.parseLong(c(b(str), String.valueOf(j4)));
            } catch (Exception unused) {
                return j4;
            }
        }

        public void a(String str, boolean z3) {
            d(b(str), String.valueOf(z3));
        }

        private void c(String str) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void a(String str) {
            c(b(str));
        }

        public float b(String str, float f4) {
            try {
                return Float.parseFloat(c(b(str), String.valueOf(f4)));
            } catch (Exception unused) {
                return f4;
            }
        }

        public boolean b(String str, boolean z3) {
            try {
                return Boolean.parseBoolean(c(b(str), String.valueOf(z3)));
            } catch (Exception unused) {
                return z3;
            }
        }

        public String b(String str, String str2) {
            return c(b(str), str2);
        }
    }

    private e(Context context) {
        this.f53893b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static e a(Context context) {
        if (f53892c == null) {
            synchronized (e.class) {
                if (f53892c == null) {
                    f53892c = new e(context);
                }
            }
        }
        return f53892c;
    }

    public boolean b() {
        return a("smart_");
    }

    public int c() {
        return this.f53894d.b("smart_lt", 0);
    }

    public long d() {
        return this.f53894d.b("smart_lc", 0L);
    }

    public void e() {
        if (c.a(this.f53893b)) {
            this.f53894d.a("smart_lc", d() + 1);
        }
    }

    private void b(String str) {
        a aVar = this.f53894d;
        aVar.a(str + "interval");
        a aVar2 = this.f53894d;
        aVar2.a(str + "ts");
    }

    public void a(long j4) {
        a("smart_", j4);
    }

    public long a() {
        return this.f53894d.b("smart_ts", 0L);
    }

    public void a(int i4) {
        this.f53894d.a("smart_lt", i4);
    }

    private void a(String str, long j4) {
        a aVar = this.f53894d;
        aVar.a(str + "interval", j4);
        a aVar2 = this.f53894d;
        aVar2.a(str + "ts", System.currentTimeMillis());
    }

    private boolean a(String str) {
        a aVar = this.f53894d;
        long b4 = aVar.b(str + "interval", 0L);
        if (b4 > 0) {
            a aVar2 = this.f53894d;
            long abs = Math.abs(System.currentTimeMillis() - aVar2.b(str + "ts", 0L)) / 1000;
            boolean z3 = abs >= b4;
            if (!z3 && com.umeng.socialize.a.a.f53878c) {
                m.a("Prefs", "interval deny ", str, " config:", Long.valueOf(b4), " current:", Long.valueOf(abs));
            }
            return z3;
        }
        return true;
    }
}
