package com.qq.e.comm.plugin.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.o0.g.b;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: h  reason: collision with root package name */
    private static volatile g f46425h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f46426i = "bGlidGVuY2VudC1hdmlmLnNv";

    /* renamed from: j  reason: collision with root package name */
    private static String f46427j = "bGliZ2R0YXZpZi56aXA";

    /* renamed from: k  reason: collision with root package name */
    private static volatile String[] f46428k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f46429l = com.qq.e.comm.plugin.d0.a.d().f().b("webppv", "imageView2/format/webp=");

    /* renamed from: m  reason: collision with root package name */
    private static final String f46430m = com.qq.e.comm.plugin.d0.a.d().f().b("apv", "imageView2/format/avif");

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f46431a = false;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f46432b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f46433c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f46434d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private int f46435e = -1;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f46436f = -1;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f46437g = -1;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f46438c;

        a(g gVar, boolean z3) {
            this.f46438c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.e().a(this.f46438c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46439c;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f46431a = false;
            }
        }

        b(String str) {
            this.f46439c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.b(this.f46439c)) {
                g.this.c(this.f46439c);
            } else {
                g.this.k();
                p0.a((Runnable) new a());
            }
            g.this.m();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f46432b = true;
        }
    }

    private g() {
        try {
            f46426i = new String(Base64.decode(f46426i, 10), com.qq.e.comm.plugin.k.a.f44515a);
            f46427j = new String(Base64.decode(f46427j, 10), com.qq.e.comm.plugin.k.a.f44515a);
            if (f46428k == null) {
                String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("sach", "pgdt.ugdtimg.com");
                if (!TextUtils.isEmpty(b4)) {
                    f46428k = b4.split(",");
                } else {
                    f46428k = new String[0];
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean c() {
        int d4 = d();
        return d4 == 1 || d4 == 3;
    }

    public static g e() {
        if (f46425h == null) {
            synchronized (g.class) {
                if (f46425h == null) {
                    f46425h = new g();
                }
            }
        }
        return f46425h;
    }

    private boolean g(String str) {
        if (f46428k != null) {
            for (String str2 : f46428k) {
                if (str.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean i() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 0, this);
    }

    private boolean l() {
        if (this.f46436f < 0) {
            this.f46436f = com.qq.e.comm.plugin.d0.a.d().f().a("nuaas", 0);
        }
        return this.f46436f > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f46437g >= 0 || Build.VERSION.SDK_INT < 31 || !l()) {
            return;
        }
        try {
            byte[] decode = Base64.decode("AAAAIGZ0eXBhdmlmAAAAAGF2aWZtaWYxbWlhZk1BMUIAAADybWV0YQAAAAAAAAAoaGRscgAAAAAAAAAAcGljdAAAAAAAAAAAAAAAAGxpYmF2aWYAAAAADnBpdG0AAAAAAAEAAAAeaWxvYwAAAABEAAABAAEAAAABAAABGgAAAhQAAAAoaWluZgAAAAAAAQAAABppbmZlAgAAAAABAABhdjAxQ29sb3IAAAAAamlwcnAAAABLaXBjbwAAABRpc3BlAAAAAAAAADYAAAAwAAAAEHBpeGkAAAAAAwgICAAAAAxhdjFDgQAMAAAAABNjb2xybmNseAACAAIAAoAAAAAXaXBtYQAAAAAAAAABAAEEAQKDBAAAAhxtZGF0EgAKBhgVdbywCDKHBBbABxxxxgAgYAEA3SuoYUMphnnI38E6dVIb9oOdyi//beMUXIww4GZgZUG5fKvt4N3A/X+qgkSvHCtciXtQThCsi5UPd2vfWyHsJg1/XvhsAkzVhraqmLXmntRZNa2rUUI9LqP6ypIS3rlSNm4ZlOGOg2SvBOdPevl806f/BQ6ugskO8Jxup744i6FkJFb+UmjWhsC/i06LRoLneAOvNiIF7RC7+cXs1X/AK85pyRrCMudPN13f1LIIpeWD9Iqr19DPVMlbf1sMM40palTrTkwjKiZN2iSGFumrxj9rsbv/l1hKrwvkbPiw+8SVP6I5s3EJvnHoyfrl2CcCK5CPsQW/XKOTAc1zBSQAcScUh78mDmQkR+vgPmgb7bK6NEG3+rpXYn59RO9Xuclu9v7I5xXGJXU3JD8gV24OPJFQcP5hyb65br2pF65xkxrktBdk1v4OSBXN0ZOtEpqokgzKgNW4g4p6p7ivOduil+h3rzsSlr1goQtc321DW3BIGHlFkSpBYkgfiYeNg2wJD1IR8nC7/nblk0fmxsQpp6yKSxD36To2a15//PO4TLzpNzvMxZIV9lM5tGUIj81I8mAYm50Dpa6au0n6ETmEs0o0DvAtxO8ZP88ErZJjAkpkp3NBOzK1MFB6AJByh6n/txh3etOsS2JkFmutqL2Sl/twejG396rNJwZJgA==", 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null && decodeByteArray.getByteCount() > 0) {
                this.f46437g = 1;
            } else {
                this.f46437g = 0;
                h.a(9130069, 1);
            }
        } catch (Exception e4) {
            this.f46437g = 0;
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("data", Log.getStackTraceString(e4));
            h.a(9130069, 2, dVar);
        }
    }

    public void a(boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 0, this, Boolean.valueOf(z3));
    }

    public String d(String str) {
        if (Build.VERSION.SDK_INT >= 31 && c() && l() && g(str) && this.f46437g > 0) {
            if (str.endsWith(f46429l)) {
                str = str.replace(f46429l, f46430m);
            } else if (!str.endsWith(f46430m)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str.contains("?") ? "&" : "?");
                sb.append(f46430m);
                str = sb.toString();
            }
        }
        d1.a("gdt_tag_avif", "native unified ad avif url is " + str);
        return str;
    }

    public boolean f(String str) {
        if (f() || !c()) {
            return false;
        }
        if (!j()) {
            a(false);
            h.a(9130067);
            return false;
        }
        return g(str);
    }

    public boolean h() {
        return d() == 3;
    }

    public boolean j() {
        return this.f46432b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String e4 = e(str);
        File file = new File(b1.o() + File.separator + f46427j);
        if (file.exists()) {
            file.delete();
        }
        File o4 = b1.o();
        com.qq.e.comm.plugin.o0.g.b a4 = new b.C0867b().a(o4).a(f46427j).d(false).d(e4).b(false).a();
        d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93\u5f00\u59cb\u4e0b\u8f7d\uff0c\u8def\u5f84: %s", o4.getAbsolutePath());
        com.qq.e.comm.plugin.o0.g.a.a().a(a4, new d(str));
    }

    public void b() {
        if (this.f46434d.incrementAndGet() >= this.f46435e) {
            h.a(9130064);
        }
    }

    public boolean g() {
        return d() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String e4 = e(str);
        String substring = e4.substring(e4.lastIndexOf("_") + 1, e4.lastIndexOf("."));
        d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93online MD5\uff1a%s", substring);
        File file = new File(b1.o() + File.separator + f46426i);
        if (file.exists()) {
            String a4 = s0.a(file);
            d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93\u672c\u5730 MD5\uff1a%s", a4);
            if (TextUtils.equals(a4, substring)) {
                return true;
            }
            file.delete();
            h.a(9130063, 1);
        }
        return false;
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
            d1.a("gdt_tag_avif", "\u89e3\u6790config url\u5931\u8d25");
            return null;
        }
    }

    public boolean f() {
        if (this.f46435e < 0) {
            this.f46435e = com.qq.e.comm.plugin.d0.a.d().f().a("adt", 3);
        }
        return this.f46434d.get() >= this.f46435e;
    }

    public int d() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("rap", 0);
        return a4 > 10000 ? com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 0) : a4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46443a;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.util.g$d$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class RunnableC0904a implements Runnable {
                RunnableC0904a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    g.this.f46431a = false;
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.k();
                p0.a((Runnable) new RunnableC0904a());
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f46431a = false;
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f46431a = false;
            }
        }

        d(String str) {
            this.f46443a = str;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            d1.a("gdt_tag_avif", "\u4e0b\u8f7d\u6210\u529f\uff0c\u8017\u65f6\uff1a%s\uff0c\u5f00\u59cb\u89e3\u538bAVIF\u4f9d\u8d56\u5e93", Long.valueOf(j4));
            if (t2.a(file.getAbsolutePath(), b1.o().getAbsolutePath())) {
                d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93\u89e3\u538b\u6210\u529f\uff0c\u8def\u5f84\uff1a%s", file.getAbsolutePath());
                if (g.this.b(this.f46443a)) {
                    d0.f46407c.submit(new a());
                }
            } else {
                d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93\u89e3\u538b\u5931\u8d25");
                p0.a((Runnable) new b());
            }
            d1.a("gdt_tag_avif", "\u5220\u9664\u4e0b\u8f7d\u7684zip\u6587\u4ef6");
            file.delete();
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            d1.a("gdt_tag_avif", "AVIF\u4f9d\u8d56\u5e93\u4e0b\u8f7d\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", dVar.b());
            p0.a((Runnable) new c());
            h.a(9130063, 2);
        }
    }

    public void a() {
        this.f46434d.set(0);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("32");
            String optString2 = jSONObject.optString("64");
            this.f46433c = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(optString) || optString.lastIndexOf("_") == -1 || optString.lastIndexOf(".") == -1 || TextUtils.isEmpty(optString2) || optString2.lastIndexOf("_") == -1) {
                return false;
            }
            return optString2.lastIndexOf(".") != -1;
        } catch (JSONException e4) {
            d1.a("gdt_tag_avif", "\u89e3\u6790download config\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", e4.toString());
            return false;
        }
    }
}
