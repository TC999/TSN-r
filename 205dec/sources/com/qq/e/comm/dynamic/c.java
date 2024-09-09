package com.qq.e.comm.dynamic;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.g1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.s0;
import com.qq.e.comm.plugin.util.t2;
import com.qq.e.comm.plugin.util.w1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    private static volatile c f41612g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f41613h = "bGliZ2R0cWpzLnNv";

    /* renamed from: i  reason: collision with root package name */
    private static String f41614i = "bGlicXVpY2tqcy5zbw";

    /* renamed from: j  reason: collision with root package name */
    private static String f41615j = "bGlicXVpY2tqcy56aXA";

    /* renamed from: k  reason: collision with root package name */
    private static String f41616k = "eyd2JzoxLCdhJzoxLCczMic6J2h0dHBzOi8vcXpzLmdkdGltZy5jb20vdW5pb24vcmVzL3VuaW9uX2Nkbi9wYWdlL2FuZHJvaWQvcXVpY2tqcy9saWJxdWlja2pzXzNlYWViOWZlZmE2Yzk3NjJhYzYxY2JhN2UxZTk1MzZmLnppcCcsJzY0JzonaHR0cHM6Ly9xenMuZ2R0aW1nLmNvbS91bmlvbi9yZXMvdW5pb25fY2RuL3BhZ2UvYW5kcm9pZC9xdWlja2pzL2xpYnF1aWNranNfYjRkY2IwMTFhODkwMTcyNTI0ZmU5M2Q5MzBlODY3MGMuemlwJ30";

    /* renamed from: c  reason: collision with root package name */
    private String f41619c;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f41617a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f41618b = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private int f41620d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<e> f41621e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private int f41622f = 999;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f41623c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f41624d;

        a(c cVar, e eVar, boolean z3) {
            this.f41623c = eVar;
            this.f41624d = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a().a(this.f41623c, this.f41624d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.e();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.dynamic.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0776c implements Runnable {
        RunnableC0776c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f41621e.iterator();
            while (it.hasNext()) {
                ((e) it.next()).c();
            }
            c.this.f41621e.clear();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface e {
        void c();
    }

    private c() {
        try {
            f41613h = new String(Base64.decode(f41613h, 10), com.qq.e.comm.plugin.k.a.f44515a);
            f41614i = new String(Base64.decode(f41614i, 10), com.qq.e.comm.plugin.k.a.f44515a);
            f41615j = new String(Base64.decode(f41615j, 10), com.qq.e.comm.plugin.k.a.f44515a);
            f41616k = new String(Base64.decode(f41616k, 10), com.qq.e.comm.plugin.k.a.f44515a);
        } catch (Exception unused) {
        }
    }

    private void a(boolean z3, boolean z4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME, 0, this, Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        pro.getVresult(568, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        pro.getVresult(569, 0, this);
    }

    private void g() {
        this.f41618b.compareAndSet(false, true);
        p0.a((Runnable) new RunnableC0776c());
    }

    private void c(String str) {
        String d4 = d(str);
        File file = new File(b1.o() + File.separator + f41615j);
        if (file.exists()) {
            file.delete();
        }
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().a(b1.o()).a(f41615j).d(false).d(d4).b(false).a(), new d(str));
    }

    public int b() {
        return this.f41622f;
    }

    public boolean d() {
        return this.f41618b.get();
    }

    public static c a() {
        if (f41612g == null) {
            synchronized (c.class) {
                if (f41612g == null) {
                    f41612g = new c();
                }
            }
        }
        return f41612g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String d4 = d(str);
        String substring = d4.substring(d4.lastIndexOf("_") + 1, d4.lastIndexOf("."));
        File file = new File(b1.o() + File.separator + f41613h);
        if (file.exists()) {
            if (TextUtils.equals(s0.a(file), substring)) {
                return true;
            }
            file.delete();
        }
        File file2 = new File(b1.o() + File.separator + f41614i);
        if (file2.exists()) {
            if (TextUtils.equals(s0.a(file2), substring) && file2.renameTo(file)) {
                return true;
            }
            file2.delete();
            return false;
        }
        return false;
    }

    private String d(String str) {
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (w1.c()) {
                optString = jSONObject.optString("64");
            } else {
                optString = jSONObject.optString("32");
            }
            return optString;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a(boolean z3) {
        if (z3 && !c() && !d()) {
            a(true, true);
        } else {
            a((e) null, z3);
        }
    }

    private boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a(e eVar, boolean z3) {
        if (!c()) {
            p0.a((Runnable) new a(this, eVar, z3));
        } else if (d()) {
            if (eVar != null) {
                eVar.c();
            }
        } else {
            if (eVar != null) {
                this.f41621e.add(eVar);
            }
            a(z3, false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41627a;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f();
                c.this.f41617a.compareAndSet(true, false);
            }
        }

        d(String str) {
            this.f41627a = str;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            if (!t2.a(file.getAbsolutePath(), b1.o().getAbsolutePath())) {
                c.this.f41617a.compareAndSet(true, false);
            } else if (c.this.b(this.f41627a)) {
                d0.f46407c.submit(new a());
            }
            file.delete();
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            c.this.f41617a.compareAndSet(true, false);
            g1.a(9130029, c.this.f41622f, 4);
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f41622f = jSONObject.optInt("v", 0);
            String optString = jSONObject.optString("32");
            String optString2 = jSONObject.optString("64");
            this.f41620d = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(optString) || optString.lastIndexOf("_") == -1 || optString.lastIndexOf(".") == -1 || TextUtils.isEmpty(optString2) || optString2.lastIndexOf("_") == -1) {
                return false;
            }
            return optString2.lastIndexOf(".") != -1;
        } catch (JSONException unused) {
            return false;
        }
    }
}
