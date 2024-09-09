package com.amap.api.col.p0003l;

import android.content.Context;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Privacy.java */
/* renamed from: com.amap.api.col.3l.ft  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ft {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f7748a = b.Unknow;

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f7749b = d.Unknow;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f7750c = "";

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f7751d = "";

    /* renamed from: e  reason: collision with root package name */
    private static volatile long f7752e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f7753f = a.Unknow;

    /* renamed from: g  reason: collision with root package name */
    private static volatile long f7754g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static volatile String f7755h = "";

    /* renamed from: i  reason: collision with root package name */
    private static volatile String f7756i = "";

    /* renamed from: j  reason: collision with root package name */
    private static volatile long f7757j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static volatile long f7758k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f7759l = false;

    /* renamed from: m  reason: collision with root package name */
    private static volatile boolean f7760m = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f7765d;

        a(int i4) {
            this.f7765d = i4;
        }

        public final int a() {
            return this.f7765d;
        }

        public static a a(int i4) {
            a aVar = NotAgree;
            if (i4 == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            return i4 == aVar2.a() ? aVar2 : Unknow;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f7770d;

        b(int i4) {
            this.f7770d = i4;
        }

        public final int a() {
            return this.f7770d;
        }

        public static b a(int i4) {
            b bVar = NotContain;
            if (i4 == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            return i4 == bVar2.a() ? bVar2 : Unknow;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);
        

        /* renamed from: j  reason: collision with root package name */
        private final int f7781j;

        c(int i4) {
            this.f7781j = i4;
        }

        public final int a() {
            return this.f7781j;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f7786d;

        d(int i4) {
            this.f7786d = i4;
        }

        public final int a() {
            return this.f7786d;
        }

        public static d a(int i4) {
            d dVar = NotShow;
            if (i4 == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            return i4 == dVar2.a() ? dVar2 : Unknow;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class e extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7787a;

        e(Context context) {
            this.f7787a = context;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            Iterator it = ft.m(ft.t(this.f7787a)).iterator();
            while (it.hasNext()) {
                ft.g(this.f7787a, ((File) it.next()).getName());
            }
            ft.n(this.f7787a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class f extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f7788a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f7789b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f7790c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f7791d;

        f(boolean z3, Context context, long j4, JSONObject jSONObject) {
            this.f7788a = z3;
            this.f7789b = context;
            this.f7790c = j4;
            this.f7791d = jSONObject;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            if (this.f7788a) {
                Iterator it = ft.m(ft.t(this.f7789b)).iterator();
                while (it.hasNext()) {
                    ft.g(this.f7789b, ((File) it.next()).getName());
                }
            }
            ft.r(this.f7789b);
            ft.h(this.f7789b, this.f7791d, this.f7790c);
            boolean p3 = ft.p(this.f7789b, this.f7791d);
            if (p3) {
                ft.o(this.f7789b, ft.l(this.f7790c));
            }
            if (this.f7788a) {
                ft.n(this.f7789b);
            }
            if (p3) {
                return;
            }
            ft.g(this.f7789b, ft.l(this.f7790c));
        }
    }

    public static synchronized n4 a(Context context, p4 p4Var) {
        boolean z3;
        synchronized (ft.class) {
            n4 n4Var = null;
            if (context != null && p4Var != null) {
                if (!f7759l) {
                    s(context);
                    f7759l = true;
                }
                if (f7749b != d.DidShow) {
                    if (f7749b == d.Unknow) {
                        n4Var = new n4(c.ShowUnknowCode, p4Var);
                    } else if (f7749b == d.NotShow) {
                        n4Var = new n4(c.ShowNoShowCode, p4Var);
                    }
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3 && f7748a != b.DidContain) {
                    if (f7748a == b.Unknow) {
                        n4Var = new n4(c.InfoUnknowCode, p4Var);
                    } else if (f7748a == b.NotContain) {
                        n4Var = new n4(c.InfoNotContainCode, p4Var);
                    }
                    z3 = false;
                }
                if (z3 && f7753f != a.DidAgree) {
                    if (f7753f == a.Unknow) {
                        n4Var = new n4(c.AgreeUnknowCode, p4Var);
                    } else if (f7753f == a.NotAgree) {
                        n4Var = new n4(c.AgreeNotAgreeCode, p4Var);
                    }
                    z3 = false;
                }
                if (f7758k != f7757j) {
                    long j4 = f7757j;
                    f7758k = f7757j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f7748a.a());
                        jSONObject.put("privacyShow", f7749b.a());
                        jSONObject.put("showTime", f7752e);
                        jSONObject.put("show2SDK", f7750c);
                        jSONObject.put("show2SDKVer", f7751d);
                        jSONObject.put("privacyAgree", f7753f.a());
                        jSONObject.put("agreeTime", f7754g);
                        jSONObject.put("agree2SDK", f7755h);
                        jSONObject.put("agree2SDKVer", f7756i);
                        z7.h().b(new f(f7760m, context, j4, jSONObject));
                    } catch (Throwable unused) {
                    }
                } else if (f7760m) {
                    z7.h().b(new e(context));
                }
                f7760m = false;
                String j5 = e4.j(context);
                if (j5 == null || j5.length() <= 0) {
                    n4Var = new n4(c.InvaildUserKeyCode, p4Var);
                    Log.e(p4Var.a(), String.format("\u83b7\u53d6apikey\u5931\u8d25\uff1a\nerrorCode : %d\n\u539f\u56e0\uff1a%s", Integer.valueOf(n4Var.f8385a.a()), n4Var.f8386b));
                }
                if (z3) {
                    n4Var = new n4(c.SuccessCode, p4Var);
                } else {
                    Log.e(p4Var.a(), String.format("\u9690\u79c1\u5408\u89c4\u6821\u9a8c\u5931\u8d25\uff1a\nerrorCode : %d\n\u539f\u56e0\uff1a%s", Integer.valueOf(n4Var.f8385a.a()), n4Var.f8386b));
                }
                return n4Var;
            }
            return new n4(c.IllegalArgument, p4Var);
        }
    }

    private static synchronized void e(Context context, a aVar, p4 p4Var) {
        synchronized (ft.class) {
            if (context == null || p4Var == null) {
                return;
            }
            if (!f7759l) {
                s(context);
                f7759l = true;
            }
            if (aVar != f7753f) {
                f7753f = aVar;
                f7755h = p4Var.a();
                f7756i = p4Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                f7754g = currentTimeMillis;
                f7757j = currentTimeMillis;
                r(context);
            }
        }
    }

    private static synchronized void f(Context context, d dVar, b bVar, p4 p4Var) {
        synchronized (ft.class) {
            if (context == null || p4Var == null) {
                return;
            }
            if (!f7759l) {
                s(context);
                f7759l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (dVar != f7749b) {
                bool = Boolean.TRUE;
                f7749b = dVar;
            }
            if (bVar != f7748a) {
                bool = Boolean.TRUE;
                f7748a = bVar;
            }
            if (bool.booleanValue()) {
                f7750c = p4Var.a();
                f7751d = p4Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                f7752e = currentTimeMillis;
                f7757j = currentTimeMillis;
                r(context);
            }
        }
    }

    static /* synthetic */ void g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String t3 = t(context);
            File file = new File(t3 + TTPathConst.sSeparator + str);
            if (file.exists()) {
                String u3 = u(context);
                File file2 = new File(u3 + TTPathConst.sSeparator + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void h(Context context, JSONObject jSONObject, long j4) {
        byte[] n4;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            n4 = f6.n(context, jSONObject.toString().getBytes());
            String l4 = l(j4);
            String t3 = t(context);
            File file = new File(t3 + TTPathConst.sSeparator + l4);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(n4);
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            fileOutputStream2 = fileOutputStream;
            th = th3;
            try {
                th.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    public static void i(Context context, boolean z3, p4 p4Var) {
        a aVar;
        if (z3) {
            aVar = a.DidAgree;
        } else {
            aVar = a.NotAgree;
        }
        e(context, aVar, p4Var);
    }

    public static void j(Context context, boolean z3, boolean z4, p4 p4Var) {
        d dVar;
        b bVar;
        if (z4) {
            dVar = d.DidShow;
        } else {
            dVar = d.NotShow;
        }
        if (z3) {
            bVar = b.DidContain;
        } else {
            bVar = b.NotContain;
        }
        f(context, dVar, bVar, p4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(long j4) {
        return String.format("%d-%s", Long.valueOf(j4), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> m(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void n(Context context) {
        try {
            Iterator<File> it = m(u(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                String name = next.getName();
                if (!name.endsWith("-privacy.data")) {
                    next.delete();
                } else {
                    String[] split = name.split("-");
                    if (split == null && split.length != 2) {
                        next.delete();
                    } else if (Long.parseLong(split[0]) <= 0) {
                        next.delete();
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(next);
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        if (p(context, new JSONObject(new String(f6.q(context, bArr))))) {
                            next.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String t3 = t(context);
            File file = new File(t3 + TTPathConst.sSeparator + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(Context context, JSONObject jSONObject) {
        try {
            b6 b6Var = new b6();
            b6Var.f7263j = context;
            b6Var.f7262i = jSONObject;
            new q6();
            y6 d4 = q6.d(b6Var);
            if (d4 != null) {
                JSONObject jSONObject2 = new JSONObject(q4.g(d4.f9524a));
                if (jSONObject2.has("status")) {
                    return jSONObject2.getInt("status") == 1;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void r(Context context) {
        synchronized (ft.class) {
            if (context == null) {
                return;
            }
            if (!f7759l) {
                s(context);
                f7759l = true;
            }
            f6.e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f7748a.a()), Integer.valueOf(f7749b.a()), Long.valueOf(f7752e), f7750c, f7751d, Integer.valueOf(f7753f.a()), Long.valueOf(f7754g), f7755h, f7756i, Long.valueOf(f7757j), Long.valueOf(f7758k)));
        }
    }

    private static void s(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = f6.d(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str == null) {
            return;
        }
        String[] split = str.split("&");
        if (split.length != 11) {
            return;
        }
        try {
            f7748a = b.a(Integer.parseInt(split[0]));
            f7749b = d.a(Integer.parseInt(split[1]));
            f7752e = Long.parseLong(split[2]);
            f7751d = split[3];
            f7751d = split[4];
            f7753f = a.a(Integer.parseInt(split[5]));
            f7754g = Long.parseLong(split[6]);
            f7755h = split[7];
            f7756i = split[8];
            f7757j = Long.parseLong(split[9]);
            f7758k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String u(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
