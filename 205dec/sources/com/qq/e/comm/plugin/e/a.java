package com.qq.e.comm.plugin.e;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f42652b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, com.qq.e.comm.plugin.e.i.a> f42653a = new ConcurrentHashMap();

    private a() {
        com.qq.e.comm.plugin.l0.f.a();
    }

    public static a a() {
        if (f42652b == null) {
            synchronized (a.class) {
                if (f42652b == null) {
                    f42652b = new a();
                }
            }
        }
        return f42652b;
    }

    private String b(View view, String str, int i4) {
        System.currentTimeMillis();
        com.qq.e.comm.plugin.e.l.d a4 = a(view, str, i4);
        String a5 = a4 != null ? a4.a(i4) : "";
        if (TextUtils.isEmpty(a5)) {
            e.a(i4, view == null ? 1 : a4 == null ? 2 : 3);
        }
        if (view != null) {
            e.a(view.getContext(), a5);
        }
        return a5;
    }

    public static int e(View view) {
        return System.identityHashCode(view);
    }

    public String c(View view) {
        return b(view, null, 1);
    }

    public com.qq.e.comm.plugin.e.i.a d(View view) {
        if (view == null) {
            return null;
        }
        com.qq.e.comm.plugin.e.i.a aVar = this.f42653a.get(Integer.valueOf(e(view)));
        if (aVar == null) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", view.toString());
            e.a(dVar);
        }
        return aVar;
    }

    public a a(View view, com.qq.e.comm.plugin.g0.e eVar) {
        return a(view, eVar, (String) null);
    }

    public a a(View view, com.qq.e.comm.plugin.g0.e eVar, String str) {
        if (view != null && eVar != null) {
            int e4 = e(view);
            com.qq.e.comm.plugin.e.i.a aVar = new com.qq.e.comm.plugin.e.i.a(e4, view, eVar);
            this.f42653a.put(Integer.valueOf(e4), aVar);
            if (!TextUtils.isEmpty(str)) {
                aVar.b(str);
            }
            e.a(view, eVar);
        } else {
            e.a(eVar);
        }
        return this;
    }

    public String a(View view) {
        return b(view, null, 2);
    }

    public String a(String str) {
        String b4 = b(null, str, 4);
        d1.a("gdt_tag_net", "gdt_mu_p \u52a0\u5bc6\u524d" + b4);
        return !TextUtils.isEmpty(b4) ? com.qq.e.comm.plugin.e.j.a.a(b4, "request") : b4;
    }

    private com.qq.e.comm.plugin.e.l.d a(View view, String str, int i4) {
        if (i4 != 1 && i4 != 2) {
            if (i4 == 4) {
                return new com.qq.e.comm.plugin.e.l.e(str);
            }
            return null;
        } else if (view == null) {
            return null;
        } else {
            com.qq.e.comm.plugin.e.i.a aVar = this.f42653a.get(Integer.valueOf(e(view)));
            if (aVar != null) {
                return new com.qq.e.comm.plugin.e.l.b(aVar, view);
            }
            return null;
        }
    }

    public void b(View view) {
        if (view != null) {
            int e4 = e(view);
            com.qq.e.comm.plugin.e.i.a aVar = this.f42653a.get(Integer.valueOf(e4));
            if (aVar != null) {
                aVar.g(e4);
                this.f42653a.remove(Integer.valueOf(e4));
            }
        }
    }
}
