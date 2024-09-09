package com.qq.e.comm.plugin.t;

import android.content.SharedPreferences;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.n0.g;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46239a = String.valueOf(Integer.MIN_VALUE);

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b<T> {
        void a(boolean z3, T t3, boolean z4, T t4);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.t.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0896c {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f46240a;

        private void b() {
            if (this.f46240a == null) {
                this.f46240a = c.b().edit();
            }
        }

        public C0896c a(e eVar, String str, int i4) {
            return a(eVar, str, i4, (b<Integer>) null);
        }

        private C0896c() {
        }

        public C0896c a(e eVar, String str, int i4, b<Integer> bVar) {
            return a(eVar, (String) null, str, i4, bVar);
        }

        public C0896c a(e eVar, String str, String str2, int i4) {
            return a(eVar, str, str2, i4, (b<Integer>) null);
        }

        public C0896c a(e eVar, String str, String str2, int i4, b<Integer> bVar) {
            String q02 = eVar.q0();
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(str2, q02, i4);
            if (a4 < 10000) {
                if (bVar != null) {
                    bVar.a(false, Integer.valueOf(a4), false, null);
                }
                return this;
            }
            int a5 = com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), Integer.MIN_VALUE);
            boolean z3 = a5 != Integer.MIN_VALUE;
            if (z3) {
                b();
                this.f46240a.putInt(c.b(str2, q02, str), a5);
            } else if (Integer.MIN_VALUE != c.a(str2, str, q02, Integer.MIN_VALUE, (b<Integer>) null)) {
                b();
                this.f46240a.remove(c.b(str2, q02, str));
            }
            if (bVar != null) {
                bVar.a(true, Integer.valueOf(a4), z3, Integer.valueOf(a5));
            }
            return this;
        }

        public C0896c a(e eVar, String str, String str2, String str3) {
            return a(eVar, str, str2, str3, (b<String>) null);
        }

        public C0896c a(e eVar, String str, String str2, String str3, b<String> bVar) {
            String q02 = eVar.q0();
            String a4 = com.qq.e.comm.plugin.d0.a.d().f().a(str2, q02, str3);
            if (c.b(a4)) {
                if (bVar != null) {
                    bVar.a(false, a4, false, null);
                }
                return this;
            }
            String a5 = com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), c.f46239a);
            boolean z3 = !c.f46239a.equals(a5);
            if (z3) {
                b();
                this.f46240a.putString(c.b(str2, q02, str), a5);
            } else if (!c.f46239a.equals(c.a(str2, str, q02, c.f46239a, (b<String>) null))) {
                b();
                this.f46240a.remove(c.b(str2, q02, str));
            }
            if (bVar != null) {
                bVar.a(true, a4, z3, a5);
            }
            return this;
        }

        public void a() {
            SharedPreferences.Editor editor = this.f46240a;
            if (editor != null) {
                editor.apply();
            }
        }
    }

    static /* synthetic */ SharedPreferences b() {
        return c();
    }

    private static SharedPreferences c() {
        return com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences("com_qq_e_sp_exp_cache", 0);
    }

    public static C0896c d() {
        return new C0896c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        try {
            return Integer.parseInt(str) < 10000;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, String str3) {
        if (str3 != null) {
            return String.format("%s_%s", str, str3);
        }
        return String.format("%s_%s", str, str2);
    }

    public static int a(String str, String str2, int i4) {
        return a(str, (String) null, str2, i4, true, (b0) null, (b<Integer>) null);
    }

    public static int a(String str, String str2, int i4, b<Integer> bVar) {
        return a(str, (String) null, str2, i4, true, (b0) null, bVar);
    }

    public static int a(String str, String str2, String str3, int i4) {
        return a(str, str2, str3, i4, true, (b0) null, (b<Integer>) null);
    }

    public static int a(String str, String str2, String str3, int i4, b<Integer> bVar) {
        return a(str, str2, str3, i4, true, (b0) null, bVar);
    }

    public static int a(String str, String str2, int i4, b0 b0Var) {
        return a(str, (String) null, str2, i4, false, b0Var, (b<Integer>) null);
    }

    public static int a(String str, String str2, int i4, b0 b0Var, b<Integer> bVar) {
        return a(str, (String) null, str2, i4, false, b0Var, bVar);
    }

    private static int a(String str, String str2, String str3, int i4, boolean z3, b0 b0Var, b<Integer> bVar) {
        int a4;
        int a5 = com.qq.e.comm.plugin.d0.a.d().f().a(str, str3, i4);
        if (a5 < 10000) {
            if (bVar != null) {
                bVar.a(false, Integer.valueOf(a5), false, null);
            }
            return a5;
        }
        if (z3) {
            a4 = c().getInt(b(str, str3, str2), Integer.MIN_VALUE);
        } else {
            a4 = com.qq.e.comm.plugin.t.a.b().a(b0Var, String.valueOf(a5), Integer.MIN_VALUE);
        }
        boolean z4 = a4 != Integer.MIN_VALUE;
        if (bVar != null) {
            bVar.a(true, Integer.valueOf(a5), z4, Integer.valueOf(a4));
        }
        if (z4) {
            g.a(String.valueOf(a5), String.valueOf(a4));
            return a4;
        }
        return i4;
    }

    public static String a(String str, String str2, String str3, String str4) {
        return a(str, str2, str3, str4, true, (b0) null, (b<String>) null);
    }

    public static String a(String str, String str2, String str3, String str4, b<String> bVar) {
        return a(str, str2, str3, str4, true, (b0) null, bVar);
    }

    public static String a(String str, String str2, String str3, b0 b0Var) {
        return a(str, (String) null, str2, str3, false, b0Var, (b<String>) null);
    }

    private static String a(String str, String str2, String str3, String str4, boolean z3, b0 b0Var, b<String> bVar) {
        String a4;
        String a5 = com.qq.e.comm.plugin.d0.a.d().f().a(str, str3, str4);
        if (b(a5)) {
            if (bVar != null) {
                bVar.a(false, a5, false, null);
            }
            return a5;
        }
        if (z3) {
            a4 = c().getString(b(str, str3, str2), f46239a);
        } else {
            a4 = com.qq.e.comm.plugin.t.a.b().a(b0Var, a5, f46239a);
        }
        boolean z4 = !f46239a.equals(a4);
        if (bVar != null) {
            bVar.a(true, a5, z4, a4);
        }
        if (z4) {
            g.a(a5, a4);
            return a4;
        }
        return str4;
    }
}
