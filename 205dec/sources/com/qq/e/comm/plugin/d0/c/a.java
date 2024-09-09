package com.qq.e.comm.plugin.d0.c;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.edgeanalytics.g;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.j2;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.u1;
import com.qq.e.comm.plugin.util.x1;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f42214l = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");

    /* renamed from: b  reason: collision with root package name */
    private e f42216b;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f42220f;

    /* renamed from: g  reason: collision with root package name */
    private volatile String f42221g;

    /* renamed from: h  reason: collision with root package name */
    private volatile long f42222h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f42223i;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f42217c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f42218d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private int f42219e = new Random(System.currentTimeMillis()).nextInt(10000);

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f42224j = new AtomicBoolean(true);

    /* renamed from: k  reason: collision with root package name */
    private final g f42225k = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f42215a = com.qq.e.comm.plugin.d0.a.d().a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.d0.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0798a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42226c;

        RunnableC0798a(int i4) {
            this.f42226c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.d0.c.b bVar = new com.qq.e.comm.plugin.d0.c.b(com.qq.e.comm.plugin.d0.c.c.b(a.this.f42215a), com.qq.e.comm.plugin.d0.c.c.c(a.this.f42215a));
            if (bVar.a(this.f42226c)) {
                bVar.a(com.qq.e.comm.plugin.d0.c.c.d(a.this.f42215a), com.qq.e.comm.plugin.d0.c.c.e(a.this.f42215a));
            }
            a.this.f42217c.set(false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements g {
        b() {
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(int i4) {
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(boolean z3, JSONObject jSONObject) {
            if (z3) {
                a.this.f42222h = 0L;
                a.this.a();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final a f42229a = new a();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface e {
        void a();

        void a(String str);
    }

    protected a() {
        this.f42223i = com.qq.e.comm.plugin.d0.a.d().f().a("nmpupfl", 1) == 1;
    }

    public static a b() {
        return c.f42229a;
    }

    private boolean d(int i4) {
        if (!this.f42223i || o.c()) {
            return false;
        }
        if (this.f42224j.compareAndSet(true, false)) {
            if (com.qq.e.comm.plugin.d0.c.c.a(this.f42215a).exists()) {
                d0.f46407c.submit(new RunnableC0798a(i4));
                return true;
            }
            return false;
        }
        return true;
    }

    protected boolean c(int i4) {
        try {
            int c4 = c() * 100;
            d1.a("\u63d2\u4ef6\u4e0b\u8f7d\u6982\u7387" + c4 + " " + this.f42219e, new Object[0]);
            if (c4 > this.f42219e) {
                return true;
            }
            com.qq.e.comm.plugin.edgeanalytics.c a4 = com.qq.e.comm.plugin.edgeanalytics.d.a(u1.a(b(i4), 0L), this.f42225k);
            if (c4 + com.qq.e.comm.plugin.edgeanalytics.e.a(a4) > this.f42219e) {
                v.a(9120040, null, Integer.valueOf(i4));
                return true;
            }
            com.qq.e.comm.plugin.edgeanalytics.b.c().e(a4);
            return false;
        } catch (Exception e4) {
            d1.a(e4.getMessage());
            return true;
        }
    }

    private String b(int i4) {
        return String.format("%s_%d", "puocg", Integer.valueOf(i4));
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.f42217c.compareAndSet(false, true)) {
            return;
        }
        int a4 = a(str2);
        if (a(a4)) {
            if (d(a4)) {
                d1.a("update plugin from local", new Object[0]);
            } else if (!c(a4)) {
                this.f42220f = str;
                this.f42221g = str2;
                this.f42217c.set(false);
                a(a4, System.currentTimeMillis());
            } else {
                this.f42220f = null;
                this.f42221g = null;
                com.qq.e.comm.plugin.edgeanalytics.b.c().a("puor");
                a(a4, 0L);
                GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
                com.qq.e.comm.plugin.i0.d.a().a(new com.qq.e.comm.plugin.i0.n.c(str2, f.a.GET, (byte[]) null), c.a.f44221d, new d(str, a4));
            }
        }
    }

    private int c() {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("plucfg");
        int i4 = 100;
        if (TextUtils.isEmpty(c4)) {
            return 100;
        }
        String[] split = c4.split(",");
        if (split != null && split.length > 0) {
            Date date = new Date();
            int hours = date.getHours();
            int minutes = date.getMinutes();
            for (String str : split) {
                int indexOf = str.indexOf("_");
                int indexOf2 = str.indexOf(":");
                if (indexOf > 0 && indexOf2 > 0) {
                    int parseInt = Integer.parseInt(str.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    if (hours >= parseInt && hours <= parseInt2) {
                        String substring = str.substring(indexOf2 + 1);
                        int indexOf3 = substring.indexOf("_");
                        if (indexOf3 > 0) {
                            int parseInt3 = Integer.parseInt(substring.substring(0, indexOf3));
                            i4 = (((Integer.parseInt(substring.substring(indexOf3 + 1)) - parseInt3) * (((hours - parseInt) * 60) + minutes)) / (((parseInt2 - parseInt) + 1) * 60)) + parseInt3;
                        } else {
                            i4 = Integer.parseInt(substring);
                        }
                        d1.a("\u63d2\u4ef6\u4e0b\u8f7d\u6982\u7387" + i4, new Object[0]);
                    }
                }
            }
        }
        return i4;
    }

    public void a() {
        if (TextUtils.isEmpty(this.f42220f) || TextUtils.isEmpty(this.f42221g) || System.currentTimeMillis() - this.f42222h < 600000) {
            return;
        }
        this.f42222h = System.currentTimeMillis();
        a(this.f42220f, this.f42221g);
    }

    private void a(int i4, long j4) {
        String b4 = b(i4);
        if (j4 <= 0) {
            u1.a(b4);
        } else if (u1.a(b4, 0L) <= 0) {
            u1.b(b4, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f42230a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42231b;

        public d(String str, int i4) {
            this.f42230a = str;
            this.f42231b = i4;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int statusCode = gVar.getStatusCode();
            if (statusCode == 200) {
                File g4 = com.qq.e.comm.plugin.d0.c.c.g(a.this.f42215a);
                File h4 = com.qq.e.comm.plugin.d0.c.c.h(a.this.f42215a);
                try {
                    String a4 = b1.a(gVar, g4);
                    if (j2.a().a(this.f42230a, a4)) {
                        boolean z3 = a(h4) && a(g4, h4);
                        GDTLogger.d("PluginUpdateSucc:" + z3);
                        a();
                        if (z3) {
                            a.this.f42218d.set(this.f42231b);
                            a(0, "");
                        } else {
                            a(6000, "Rename file error");
                        }
                    } else {
                        g4.delete();
                        String str = "Verify error:sig=" + this.f42230a + "md5=" + a4 + "version=" + this.f42231b;
                        a(6000, str);
                        GDTLogger.d(str);
                        a(str);
                    }
                } catch (Throwable th) {
                    g4.delete();
                    GDTLogger.d("UnknownException While Update Plugin");
                    a(th.getMessage());
                    a(6000, th.getMessage());
                }
            } else {
                String str2 = "Status code error:" + statusCode;
                a(3005, str2);
                GDTLogger.d(str2);
                a(str2);
            }
            a.this.f42217c.set(false);
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, Exception exc) {
            GDTLogger.w("\u66f4\u65b0\u63d2\u4ef6\u51fa\u73b0\u5f02\u5e38", exc);
            a(exc.getMessage());
            a(3001, exc.getMessage());
            a.this.f42217c.set(false);
        }

        private void a(int i4, String str) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            if (!TextUtils.isEmpty(str)) {
                dVar.a("msg", str);
            }
            v.a(9120030, null, Integer.valueOf(this.f42231b), Integer.valueOf(i4), dVar);
        }

        private void a() {
            if (a.this.f42216b != null) {
                a.this.f42216b.a();
            }
        }

        private void a(String str) {
            if (a.this.f42216b != null) {
                a.this.f42216b.a(str);
            }
        }

        private boolean a(File file, File file2) {
            return b1.b(file, com.qq.e.comm.plugin.d0.c.c.d(a.this.f42215a)) && b1.b(file2, com.qq.e.comm.plugin.d0.c.c.e(a.this.f42215a));
        }

        private boolean a(File file) {
            return b1.c(file, this.f42231b + "#####" + this.f42230a);
        }
    }

    private boolean a(int i4) {
        int a4 = e1.a();
        if (i4 >= a4 && i4 != this.f42218d.get()) {
            if (i4 == this.f42218d.get()) {
                GDTLogger.i("Same Version plugin has downloaded " + i4);
                return false;
            }
            return true;
        }
        GDTLogger.i("online plugin version is smaller than asset plugin version" + i4 + "," + a4 + ".download give up");
        return false;
    }

    private int a(String str) {
        Matcher matcher = f42214l.matcher(str);
        return x1.a(matcher.matches() ? matcher.group(1) : "0", 0);
    }
}
