package com.amap.api.col.s;

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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Privacy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class cf {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f9708a = b.Unknow;

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f9709b = d.Unknow;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f9710c = "";

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f9711d = "";

    /* renamed from: e  reason: collision with root package name */
    private static volatile long f9712e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f9713f = a.Unknow;

    /* renamed from: g  reason: collision with root package name */
    private static volatile long f9714g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static volatile String f9715h = "";

    /* renamed from: i  reason: collision with root package name */
    private static volatile String f9716i = "";

    /* renamed from: j  reason: collision with root package name */
    private static volatile long f9717j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static volatile long f9718k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f9719l = false;

    /* renamed from: m  reason: collision with root package name */
    private static volatile boolean f9720m = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f9725d;

        a(int i4) {
            this.f9725d = i4;
        }

        public final int a() {
            return this.f9725d;
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
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f9730d;

        b(int i4) {
            this.f9730d = i4;
        }

        public final int a() {
            return this.f9730d;
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
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
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
        private final int f9741j;

        c(int i4) {
            this.f9741j = i4;
        }

        public final int a() {
            return this.f9741j;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f9746d;

        d(int i4) {
            this.f9746d = i4;
        }

        public final int a() {
            return this.f9746d;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class e extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9747b;

        e(Context context) {
            this.f9747b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            Iterator it = cf.m(cf.t(this.f9747b)).iterator();
            while (it.hasNext()) {
                cf.g(this.f9747b, ((File) it.next()).getName());
            }
            cf.n(this.f9747b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Privacy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class f extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f9748b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f9749c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f9750d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ JSONObject f9751e;

        f(boolean z3, Context context, long j4, JSONObject jSONObject) {
            this.f9748b = z3;
            this.f9749c = context;
            this.f9750d = j4;
            this.f9751e = jSONObject;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            if (this.f9748b) {
                Iterator it = cf.m(cf.t(this.f9749c)).iterator();
                while (it.hasNext()) {
                    cf.g(this.f9749c, ((File) it.next()).getName());
                }
            }
            cf.r(this.f9749c);
            cf.h(this.f9749c, this.f9751e, this.f9750d);
            boolean p3 = cf.p(this.f9749c, this.f9751e);
            if (p3) {
                cf.o(this.f9749c, cf.l(this.f9750d));
            }
            if (this.f9748b) {
                cf.n(this.f9749c);
            }
            if (p3) {
                return;
            }
            cf.g(this.f9749c, cf.l(this.f9750d));
        }
    }

    public static synchronized h1 a(Context context, i1 i1Var) {
        boolean z3;
        synchronized (cf.class) {
            h1 h1Var = null;
            if (context != null && i1Var != null) {
                if (!f9719l) {
                    s(context);
                    f9719l = true;
                }
                if (f9709b != d.DidShow) {
                    if (f9709b == d.Unknow) {
                        h1Var = new h1(c.ShowUnknowCode, i1Var);
                    } else if (f9709b == d.NotShow) {
                        h1Var = new h1(c.ShowNoShowCode, i1Var);
                    }
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3 && f9708a != b.DidContain) {
                    if (f9708a == b.Unknow) {
                        h1Var = new h1(c.InfoUnknowCode, i1Var);
                    } else if (f9708a == b.NotContain) {
                        h1Var = new h1(c.InfoNotContainCode, i1Var);
                    }
                    z3 = false;
                }
                if (z3 && f9713f != a.DidAgree) {
                    if (f9713f == a.Unknow) {
                        h1Var = new h1(c.AgreeUnknowCode, i1Var);
                    } else if (f9713f == a.NotAgree) {
                        h1Var = new h1(c.AgreeNotAgreeCode, i1Var);
                    }
                    z3 = false;
                }
                if (f9718k != f9717j) {
                    long j4 = f9717j;
                    f9718k = f9717j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f9708a.a());
                        jSONObject.put("privacyShow", f9709b.a());
                        jSONObject.put("showTime", f9712e);
                        jSONObject.put("show2SDK", f9710c);
                        jSONObject.put("show2SDKVer", f9711d);
                        jSONObject.put("privacyAgree", f9713f.a());
                        jSONObject.put("agreeTime", f9714g);
                        jSONObject.put("agree2SDK", f9715h);
                        jSONObject.put("agree2SDKVer", f9716i);
                        y3.e().c(new f(f9720m, context, j4, jSONObject));
                    } catch (Throwable unused) {
                    }
                } else if (f9720m) {
                    y3.e().c(new e(context));
                }
                f9720m = false;
                String i4 = x0.i(context);
                if (i4 == null || i4.length() <= 0) {
                    h1Var = new h1(c.InvaildUserKeyCode, i1Var);
                    Log.e(i1Var.d(), String.format("\u83b7\u53d6apikey\u5931\u8d25\uff1a\nerrorCode : %d\n\u539f\u56e0\uff1a%s", Integer.valueOf(h1Var.f9876a.a()), h1Var.f9877b));
                }
                if (z3) {
                    h1Var = new h1(c.SuccessCode, i1Var);
                } else {
                    Log.e(i1Var.d(), String.format("\u9690\u79c1\u5408\u89c4\u6821\u9a8c\u5931\u8d25\uff1a\nerrorCode : %d\n\u539f\u56e0\uff1a%s", Integer.valueOf(h1Var.f9876a.a()), h1Var.f9877b));
                }
                return h1Var;
            }
            return new h1(c.IllegalArgument, i1Var);
        }
    }

    private static synchronized void e(Context context, a aVar, i1 i1Var) {
        synchronized (cf.class) {
            if (context == null || i1Var == null) {
                return;
            }
            if (!f9719l) {
                s(context);
                f9719l = true;
            }
            if (aVar != f9713f) {
                f9713f = aVar;
                f9715h = i1Var.d();
                f9716i = i1Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                f9714g = currentTimeMillis;
                f9717j = currentTimeMillis;
                r(context);
            }
        }
    }

    private static synchronized void f(Context context, d dVar, b bVar, i1 i1Var) {
        synchronized (cf.class) {
            if (context == null || i1Var == null) {
                return;
            }
            if (!f9719l) {
                s(context);
                f9719l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (dVar != f9709b) {
                bool = Boolean.TRUE;
                f9709b = dVar;
            }
            if (bVar != f9708a) {
                bool = Boolean.TRUE;
                f9708a = bVar;
            }
            if (bool.booleanValue()) {
                f9710c = i1Var.d();
                f9711d = i1Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                f9712e = currentTimeMillis;
                f9717j = currentTimeMillis;
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
            n4 = j2.n(context, jSONObject.toString().getBytes());
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

    public static void i(Context context, boolean z3, i1 i1Var) {
        a aVar;
        if (z3) {
            aVar = a.DidAgree;
        } else {
            aVar = a.NotAgree;
        }
        e(context, aVar, i1Var);
    }

    public static void j(Context context, boolean z3, boolean z4, i1 i1Var) {
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
        f(context, dVar, bVar, i1Var);
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
                        if (p(context, new JSONObject(new String(j2.q(context, bArr))))) {
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
            i2 i2Var = new i2();
            i2Var.f9935n = context;
            i2Var.f9934m = jSONObject;
            new u2();
            b3 d4 = u2.d(i2Var);
            if (d4 != null) {
                JSONObject jSONObject2 = new JSONObject(j1.g(d4.f9643a));
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
        synchronized (cf.class) {
            if (context == null) {
                return;
            }
            if (!f9719l) {
                s(context);
                f9719l = true;
            }
            j2.e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f9708a.a()), Integer.valueOf(f9709b.a()), Long.valueOf(f9712e), f9710c, f9711d, Integer.valueOf(f9713f.a()), Long.valueOf(f9714g), f9715h, f9716i, Long.valueOf(f9717j), Long.valueOf(f9718k)));
        }
    }

    private static void s(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = j2.d(context, "AMap.privacy.data", "AMap.privacy.data");
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
            f9708a = b.a(Integer.parseInt(split[0]));
            f9709b = d.a(Integer.parseInt(split[1]));
            f9712e = Long.parseLong(split[2]);
            f9711d = split[3];
            f9711d = split[4];
            f9713f = a.a(Integer.parseInt(split[5]));
            f9714g = Long.parseLong(split[6]);
            f9715h = split[7];
            f9716i = split[8];
            f9717j = Long.parseLong(split[9]);
            f9718k = Long.parseLong(split[10]);
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
