package com.qq.e.comm.plugin.util;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.o0.g.b;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g2 {

    /* renamed from: m  reason: collision with root package name */
    private static volatile g2 f46452m = null;

    /* renamed from: n  reason: collision with root package name */
    private static String f46453n = "bGlidHF1aWNfam5pLnNv";

    /* renamed from: o  reason: collision with root package name */
    private static String f46454o = "bGlicXVpYy56aXA";

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f46455a = false;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f46456b = false;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f46457c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    private int f46458d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f46459e = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f46460f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private int f46461g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final HashSet<String> f46462h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private final HashSet<String> f46463i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    private final g f46464j = new g(64);

    /* renamed from: k  reason: collision with root package name */
    private int f46465k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f46466l = 999;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f46467c;

        a(g2 g2Var, boolean z3) {
            this.f46467c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            g2.a().a(this.f46467c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46468c;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g2.this.f46455a = false;
            }
        }

        b(String str) {
            this.f46468c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g2.this.b(this.f46468c)) {
                g2.this.c(this.f46468c);
                return;
            }
            g2.this.d();
            p0.a((Runnable) new a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g2.this.f46456b = true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g2.this.f46456b = true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46479a;

        static {
            int[] iArr = new int[h.values().length];
            f46479a = iArr;
            try {
                iArr[h.AD_REQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46479a[h.EXPOSURE_CGI_REQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46479a[h.CLICK_CGI_REQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class g extends LinkedHashMap<String, Integer> {

        /* renamed from: c  reason: collision with root package name */
        private int f46480c;

        public g(int i4) {
            this.f46480c = 32;
            if (i4 > 0) {
                this.f46480c = i4;
            }
        }

        public synchronized void a(String str, int i4) {
            put(str, Integer.valueOf(i4));
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
            return size() > this.f46480c;
        }

        public synchronized int a(String str) {
            Integer num;
            num = get(str);
            return num == null ? 0 : num.intValue();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum h {
        AD_REQ("adRequest", 1),
        EXPOSURE_CGI_REQ("exposureCGIReq", 2),
        CLICK_CGI_REQ("clickCGIReq", 3);
        

        /* renamed from: c  reason: collision with root package name */
        private int f46485c;

        h(String str, int i4) {
            this.f46485c = i4;
        }

        public int a() {
            return this.f46485c;
        }
    }

    private g2() {
        try {
            f46453n = new String(Base64.decode(f46453n, 10), com.qq.e.comm.plugin.k.a.f44515a);
            f46454o = new String(Base64.decode(f46454o, 10), com.qq.e.comm.plugin.k.a.f44515a);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 0, this);
    }

    public void a(boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 0, this, Boolean.valueOf(z3));
    }

    public boolean c() {
        return this.f46456b;
    }

    public int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.f46464j.a(str);
    }

    public boolean e() {
        return com.qq.e.comm.plugin.t.c.a("uttc", "APP", "", 0) > 0;
    }

    private Pair<String, Integer> c(h hVar, int i4) {
        String str;
        if (hVar == h.EXPOSURE_CGI_REQ) {
            if (i4 == com.qq.e.comm.plugin.b.g.SPLASH.c()) {
                str = "utfe";
            } else if (i4 == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.c()) {
                str = "eutfe";
            } else if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.c()) {
                str = "ihutfe";
            } else if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.c()) {
                str = "ifutfe";
            } else if (i4 == com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.c()) {
                str = "rvutfe";
            } else if (i4 == com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.c()) {
                str = "nutfe";
            } else {
                if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.c()) {
                    str = "butfe";
                }
                str = "";
            }
        } else {
            if (hVar == h.CLICK_CGI_REQ) {
                if (i4 == com.qq.e.comm.plugin.b.g.SPLASH.c()) {
                    str = "utfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.c()) {
                    str = "eutfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.c()) {
                    str = "ihutfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.c()) {
                    str = "ifutfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.c()) {
                    str = "rvutfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.c()) {
                    str = "nutfc";
                } else if (i4 == com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.c()) {
                    str = "butfc";
                }
            }
            str = "";
        }
        return new Pair<>(str, 0);
    }

    private String e(String str) {
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
            d1.a("gdt_tag_tquic", "\u89e3\u6790config url\u5931\u8d25");
            return null;
        }
    }

    public boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        int i4 = f.f46479a[hVar.ordinal()];
        if (i4 == 1) {
            if (this.f46458d < 0) {
                this.f46458d = com.qq.e.comm.plugin.d0.a.d().f().a("tdt", 2);
            }
            return this.f46457c.get() >= this.f46458d;
        } else if (i4 == 2) {
            if (this.f46461g < 0) {
                this.f46461g = com.qq.e.comm.plugin.d0.a.d().f().a("tdtec", 1);
            }
            return this.f46459e.get() >= this.f46461g;
        } else if (i4 != 3) {
            return false;
        } else {
            if (this.f46461g < 0) {
                this.f46461g = com.qq.e.comm.plugin.d0.a.d().f().a("tdtec", 1);
            }
            return this.f46460f.get() >= this.f46461g;
        }
    }

    public static g2 a() {
        if (f46452m == null) {
            synchronized (g2.class) {
                if (f46452m == null) {
                    f46452m = new g2();
                }
            }
        }
        return f46452m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends com.qq.e.comm.plugin.p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46473a;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.util.g2$e$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class RunnableC0905a implements Runnable {
                RunnableC0905a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    g2.this.f46455a = false;
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g2.this.d();
                p0.a((Runnable) new RunnableC0905a());
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g2.this.f46455a = false;
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g2.this.f46455a = false;
            }
        }

        e(String str) {
            this.f46473a = str;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            d1.a("gdt_tag_tquic", "\u4e0b\u8f7d\u6210\u529f\uff0c\u8017\u65f6\uff1a%s\uff0c\u5f00\u59cb\u89e3\u538bTquic\u4f9d\u8d56\u5e93", Long.valueOf(j4));
            if (t2.a(file.getAbsolutePath(), b1.o().getAbsolutePath())) {
                d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93\u89e3\u538b\u6210\u529f\uff0c\u8def\u5f84\uff1a%s", file.getAbsolutePath());
                if (g2.this.b(this.f46473a)) {
                    d0.f46407c.submit(new a());
                }
            } else {
                d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93\u89e3\u538b\u5931\u8d25");
                p0.a((Runnable) new b());
            }
            d1.a("gdt_tag_tquic", "\u5220\u9664\u4e0b\u8f7d\u7684zip\u6587\u4ef6");
            file.delete();
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93\u4e0b\u8f7d\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", dVar.b());
            p0.a((Runnable) new c());
            h2.b(9130013, 4);
        }
    }

    private boolean b(com.qq.e.comm.plugin.b.g gVar, String str) {
        return a(gVar, str) > 1;
    }

    public int b(h hVar, int i4) {
        if (hVar == null) {
            return 0;
        }
        Pair<String, Integer> c4 = c(hVar, i4);
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a((String) c4.first, ((Integer) c4.second).intValue());
        return a4 > 10000 ? com.qq.e.comm.plugin.t.a.b().a(i4, String.valueOf(a4), ((Integer) c4.second).intValue()) : a4;
    }

    public void b(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.b.g o4 = eVar.o();
        if (o4.k()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "sutoc", 0).a();
        } else if (o4.f()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "eutoc", 0).a();
        } else if (o4.h()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "ihsutoc", 0).a();
        } else if (o4.g()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "ifsutoc", 0).a();
        } else if (o4.j()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "rvutoc", 0).a();
        } else if (o4.i()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "nutoc", 0).a();
        } else if (o4.e()) {
            com.qq.e.comm.plugin.t.c.d().a(eVar, "butoc", 0).a();
        }
        a(eVar);
    }

    public boolean a(com.qq.e.comm.plugin.b.g gVar) {
        if (this.f46462h.size() == 0) {
            String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("utat", "");
            if (!TextUtils.isEmpty(b4)) {
                synchronized (g2.class) {
                    this.f46462h.addAll(Arrays.asList(b4.split(",")));
                }
            }
        }
        if (this.f46462h.size() == 0) {
            return false;
        }
        return this.f46462h.contains(String.valueOf(gVar.f42000e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String e4 = e(str);
        File file = new File(b1.o() + File.separator + f46454o);
        if (file.exists()) {
            file.delete();
        }
        File o4 = b1.o();
        com.qq.e.comm.plugin.o0.g.b a4 = new b.C0867b().a(o4).a(f46454o).d(false).d(e4).b(false).a();
        d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93\u5f00\u59cb\u4e0b\u8f7d\uff0c\u8def\u5f84: %s", o4.getAbsolutePath());
        com.qq.e.comm.plugin.o0.g.a.a().a(a4, new e(str));
    }

    public boolean a(int i4) {
        if (this.f46463i.size() == 0) {
            String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("utatec", "");
            if (!TextUtils.isEmpty(b4)) {
                synchronized (g2.class) {
                    this.f46463i.addAll(Arrays.asList(b4.split(",")));
                }
            }
        }
        if (this.f46463i.size() == 0) {
            return false;
        }
        return this.f46463i.contains(String.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String e4 = e(str);
        String substring = e4.substring(e4.lastIndexOf("_") + 1, e4.lastIndexOf("."));
        d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93online MD5\uff1a%s", substring);
        File file = new File(b1.o() + File.separator + f46453n);
        if (file.exists()) {
            String a4 = s0.a(file);
            d1.a("gdt_tag_tquic", "Tquic\u4f9d\u8d56\u5e93local MD5\uff1a%s", a4);
            if (TextUtils.equals(a4, substring)) {
                return true;
            }
            file.delete();
        }
        return false;
    }

    public void a(h hVar, int i4) {
        if (hVar == null) {
            return;
        }
        int i5 = f.f46479a[hVar.ordinal()];
        if (i5 == 1) {
            if (this.f46457c.incrementAndGet() >= this.f46458d) {
                h2.a(9130018);
            }
        } else if (i5 != 2) {
            if (i5 == 3 && this.f46460f.incrementAndGet() >= this.f46461g) {
                h2.a(9130018, i4);
            }
        } else if (this.f46459e.incrementAndGet() >= this.f46461g) {
            h2.a(9130018, i4);
        }
    }

    private boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        int i4 = f.f46479a[hVar.ordinal()];
        if (i4 == 1) {
            this.f46457c.set(0);
        } else if (i4 == 2) {
            this.f46459e.set(0);
        } else if (i4 != 3) {
        } else {
            this.f46460f.set(0);
        }
    }

    public boolean a(h hVar, com.qq.e.comm.plugin.b.g gVar, int i4, String str) {
        if (hVar == null) {
            return false;
        }
        int i5 = f.f46479a[hVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                if (gVar != null) {
                    i4 = gVar.c();
                }
                return b(hVar, i4) >= 1;
            }
            return false;
        }
        return b(gVar, str);
    }

    public int a(com.qq.e.comm.plugin.b.g gVar, String str) {
        if (gVar.k()) {
            return com.qq.e.comm.plugin.t.c.a("sutoc", str, 0);
        }
        if (gVar.f()) {
            return com.qq.e.comm.plugin.t.c.a("eutoc", str, 0);
        }
        if (gVar.h()) {
            return com.qq.e.comm.plugin.t.c.a("ihsutoc", str, 0);
        }
        if (gVar.g()) {
            return com.qq.e.comm.plugin.t.c.a("ifsutoc", str, 0);
        }
        if (gVar.j()) {
            return com.qq.e.comm.plugin.t.c.a("rvutoc", str, 0);
        }
        if (gVar.i()) {
            return com.qq.e.comm.plugin.t.c.a("nutoc", str, 0);
        }
        if (gVar.e()) {
            return com.qq.e.comm.plugin.t.c.a("butoc", str, 0);
        }
        return 0;
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.b.g o4 = eVar.o();
        int i4 = 0;
        if (o4.k()) {
            i4 = a("utocc", 0);
        } else if (o4.f()) {
            i4 = a("utoccfe", 0);
        } else if (o4.j()) {
            i4 = a("utoccfr", 0);
        } else if (o4.h()) {
            i4 = a("utoccfihs", 0);
        } else if (o4.g()) {
            i4 = a("utoccfifs", 0);
        } else if (o4.e()) {
            i4 = a("utoccfb", 0);
        } else if (o4.i()) {
            i4 = a("utoccfn", 0);
        }
        if (i4 > 0) {
            a(eVar, i4);
        }
    }

    private int a(String str, int i4) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(str, i4);
        return a4 > 10000 ? com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), i4) : a4;
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        if (!TextUtils.isEmpty(eVar.L0())) {
            this.f46464j.a(eVar.L0(), i4);
        }
        if (!TextUtils.isEmpty(eVar.X())) {
            this.f46464j.a(eVar.X(), i4);
        }
        if (TextUtils.isEmpty(eVar.Y())) {
            return;
        }
        this.f46464j.a(eVar.Y(), i4);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f46466l = jSONObject.optInt("v", 0);
            String optString = jSONObject.optString("32");
            String optString2 = jSONObject.optString("64");
            this.f46465k = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(optString) || optString.lastIndexOf("_") == -1 || optString.lastIndexOf(".") == -1 || TextUtils.isEmpty(optString2) || optString2.lastIndexOf("_") == -1) {
                return false;
            }
            return optString2.lastIndexOf(".") != -1;
        } catch (JSONException e4) {
            d1.a("gdt_tag_tquic", "\u89e3\u6790download config\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", e4.toString());
            return false;
        }
    }
}
