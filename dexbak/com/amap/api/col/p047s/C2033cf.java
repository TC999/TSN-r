package com.amap.api.col.p047s;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Privacy.java */
/* renamed from: com.amap.api.col.s.cf */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2033cf {

    /* renamed from: a */
    private static volatile EnumC2035b f5980a = EnumC2035b.Unknow;

    /* renamed from: b */
    private static volatile EnumC2037d f5981b = EnumC2037d.Unknow;

    /* renamed from: c */
    private static volatile String f5982c = "";

    /* renamed from: d */
    private static volatile String f5983d = "";

    /* renamed from: e */
    private static volatile long f5984e = -1;

    /* renamed from: f */
    private static volatile EnumC2034a f5985f = EnumC2034a.Unknow;

    /* renamed from: g */
    private static volatile long f5986g = -1;

    /* renamed from: h */
    private static volatile String f5987h = "";

    /* renamed from: i */
    private static volatile String f5988i = "";

    /* renamed from: j */
    private static volatile long f5989j = 0;

    /* renamed from: k */
    private static volatile long f5990k = 0;

    /* renamed from: l */
    private static volatile boolean f5991l = false;

    /* renamed from: m */
    private static volatile boolean f5992m = true;

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2034a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        

        /* renamed from: d */
        private int f5997d;

        EnumC2034a(int i) {
            this.f5997d = i;
        }

        /* renamed from: a */
        public final int m53106a() {
            return this.f5997d;
        }

        /* renamed from: a */
        public static EnumC2034a m53105a(int i) {
            EnumC2034a enumC2034a = NotAgree;
            if (i == enumC2034a.m53106a()) {
                return enumC2034a;
            }
            EnumC2034a enumC2034a2 = DidAgree;
            return i == enumC2034a2.m53106a() ? enumC2034a2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2035b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        

        /* renamed from: d */
        private int f6002d;

        EnumC2035b(int i) {
            this.f6002d = i;
        }

        /* renamed from: a */
        public final int m53104a() {
            return this.f6002d;
        }

        /* renamed from: a */
        public static EnumC2035b m53103a(int i) {
            EnumC2035b enumC2035b = NotContain;
            if (i == enumC2035b.m53104a()) {
                return enumC2035b;
            }
            EnumC2035b enumC2035b2 = DidContain;
            return i == enumC2035b2.m53104a() ? enumC2035b2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2036c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);
        

        /* renamed from: j */
        private final int f6013j;

        EnumC2036c(int i) {
            this.f6013j = i;
        }

        /* renamed from: a */
        public final int m53102a() {
            return this.f6013j;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2037d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        

        /* renamed from: d */
        private int f6018d;

        EnumC2037d(int i) {
            this.f6018d = i;
        }

        /* renamed from: a */
        public final int m53101a() {
            return this.f6018d;
        }

        /* renamed from: a */
        public static EnumC2037d m53100a(int i) {
            EnumC2037d enumC2037d = NotShow;
            if (i == enumC2037d.m53101a()) {
                return enumC2037d;
            }
            EnumC2037d enumC2037d2 = DidShow;
            return i == enumC2037d2.m53101a() ? enumC2037d2 : Unknow;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2038e extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ Context f6019b;

        C2038e(Context context) {
            this.f6019b = context;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            Iterator it = C2033cf.m53115m(C2033cf.m53108t(this.f6019b)).iterator();
            while (it.hasNext()) {
                C2033cf.m53121g(this.f6019b, ((File) it.next()).getName());
            }
            C2033cf.m53114n(this.f6019b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.s.cf$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2039f extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ boolean f6020b;

        /* renamed from: c */
        final /* synthetic */ Context f6021c;

        /* renamed from: d */
        final /* synthetic */ long f6022d;

        /* renamed from: e */
        final /* synthetic */ JSONObject f6023e;

        C2039f(boolean z, Context context, long j, JSONObject jSONObject) {
            this.f6020b = z;
            this.f6021c = context;
            this.f6022d = j;
            this.f6023e = jSONObject;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            if (this.f6020b) {
                Iterator it = C2033cf.m53115m(C2033cf.m53108t(this.f6021c)).iterator();
                while (it.hasNext()) {
                    C2033cf.m53121g(this.f6021c, ((File) it.next()).getName());
                }
            }
            C2033cf.m53110r(this.f6021c);
            C2033cf.m53120h(this.f6021c, this.f6023e, this.f6022d);
            boolean m53112p = C2033cf.m53112p(this.f6021c, this.f6023e);
            if (m53112p) {
                C2033cf.m53113o(this.f6021c, C2033cf.m53116l(this.f6022d));
            }
            if (this.f6020b) {
                C2033cf.m53114n(this.f6021c);
            }
            if (m53112p) {
                return;
            }
            C2033cf.m53121g(this.f6021c, C2033cf.m53116l(this.f6022d));
        }
    }

    /* renamed from: a */
    public static synchronized C2066h1 m53127a(Context context, C2073i1 c2073i1) {
        boolean z;
        synchronized (C2033cf.class) {
            C2066h1 c2066h1 = null;
            if (context != null && c2073i1 != null) {
                if (!f5991l) {
                    m53109s(context);
                    f5991l = true;
                }
                if (f5981b != EnumC2037d.DidShow) {
                    if (f5981b == EnumC2037d.Unknow) {
                        c2066h1 = new C2066h1(EnumC2036c.ShowUnknowCode, c2073i1);
                    } else if (f5981b == EnumC2037d.NotShow) {
                        c2066h1 = new C2066h1(EnumC2036c.ShowNoShowCode, c2073i1);
                    }
                    z = false;
                } else {
                    z = true;
                }
                if (z && f5980a != EnumC2035b.DidContain) {
                    if (f5980a == EnumC2035b.Unknow) {
                        c2066h1 = new C2066h1(EnumC2036c.InfoUnknowCode, c2073i1);
                    } else if (f5980a == EnumC2035b.NotContain) {
                        c2066h1 = new C2066h1(EnumC2036c.InfoNotContainCode, c2073i1);
                    }
                    z = false;
                }
                if (z && f5985f != EnumC2034a.DidAgree) {
                    if (f5985f == EnumC2034a.Unknow) {
                        c2066h1 = new C2066h1(EnumC2036c.AgreeUnknowCode, c2073i1);
                    } else if (f5985f == EnumC2034a.NotAgree) {
                        c2066h1 = new C2066h1(EnumC2036c.AgreeNotAgreeCode, c2073i1);
                    }
                    z = false;
                }
                if (f5990k != f5989j) {
                    long j = f5989j;
                    f5990k = f5989j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f5980a.m53104a());
                        jSONObject.put("privacyShow", f5981b.m53101a());
                        jSONObject.put("showTime", f5984e);
                        jSONObject.put("show2SDK", f5982c);
                        jSONObject.put("show2SDKVer", f5983d);
                        jSONObject.put("privacyAgree", f5985f.m53106a());
                        jSONObject.put("agreeTime", f5986g);
                        jSONObject.put("agree2SDK", f5987h);
                        jSONObject.put("agree2SDKVer", f5988i);
                        C2225y3.m52184e().m53246c(new C2039f(f5992m, context, j, jSONObject));
                    } catch (Throwable unused) {
                    }
                } else if (f5992m) {
                    C2225y3.m52184e().m53246c(new C2038e(context));
                }
                f5992m = false;
                String m52327i = C2199x0.m52327i(context);
                if (m52327i == null || m52327i.length() <= 0) {
                    c2066h1 = new C2066h1(EnumC2036c.InvaildUserKeyCode, c2073i1);
                    Log.e(c2073i1.m52918d(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(c2066h1.f6148a.m53102a()), c2066h1.f6149b));
                }
                if (z) {
                    c2066h1 = new C2066h1(EnumC2036c.SuccessCode, c2073i1);
                } else {
                    Log.e(c2073i1.m52918d(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(c2066h1.f6148a.m53102a()), c2066h1.f6149b));
                }
                return c2066h1;
            }
            return new C2066h1(EnumC2036c.IllegalArgument, c2073i1);
        }
    }

    /* renamed from: e */
    private static synchronized void m53123e(Context context, EnumC2034a enumC2034a, C2073i1 c2073i1) {
        synchronized (C2033cf.class) {
            if (context == null || c2073i1 == null) {
                return;
            }
            if (!f5991l) {
                m53109s(context);
                f5991l = true;
            }
            if (enumC2034a != f5985f) {
                f5985f = enumC2034a;
                f5987h = c2073i1.m52918d();
                f5988i = c2073i1.m52917e();
                long currentTimeMillis = System.currentTimeMillis();
                f5986g = currentTimeMillis;
                f5989j = currentTimeMillis;
                m53110r(context);
            }
        }
    }

    /* renamed from: f */
    private static synchronized void m53122f(Context context, EnumC2037d enumC2037d, EnumC2035b enumC2035b, C2073i1 c2073i1) {
        synchronized (C2033cf.class) {
            if (context == null || c2073i1 == null) {
                return;
            }
            if (!f5991l) {
                m53109s(context);
                f5991l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (enumC2037d != f5981b) {
                bool = Boolean.TRUE;
                f5981b = enumC2037d;
            }
            if (enumC2035b != f5980a) {
                bool = Boolean.TRUE;
                f5980a = enumC2035b;
            }
            if (bool.booleanValue()) {
                f5982c = c2073i1.m52918d();
                f5983d = c2073i1.m52917e();
                long currentTimeMillis = System.currentTimeMillis();
                f5984e = currentTimeMillis;
                f5989j = currentTimeMillis;
                m53110r(context);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m53121g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String m53108t = m53108t(context);
            File file = new File(m53108t + "/" + str);
            if (file.exists()) {
                String m53107u = m53107u(context);
                File file2 = new File(m53107u + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m53120h(Context context, JSONObject jSONObject, long j) {
        byte[] m52837n;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            m52837n = C2080j2.m52837n(context, jSONObject.toString().getBytes());
            String m53116l = m53116l(j);
            String m53108t = m53108t(context);
            File file = new File(m53108t + "/" + m53116l);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(m52837n);
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

    /* renamed from: i */
    public static void m53119i(Context context, boolean z, C2073i1 c2073i1) {
        EnumC2034a enumC2034a;
        if (z) {
            enumC2034a = EnumC2034a.DidAgree;
        } else {
            enumC2034a = EnumC2034a.NotAgree;
        }
        m53123e(context, enumC2034a, c2073i1);
    }

    /* renamed from: j */
    public static void m53118j(Context context, boolean z, boolean z2, C2073i1 c2073i1) {
        EnumC2037d enumC2037d;
        EnumC2035b enumC2035b;
        if (z2) {
            enumC2037d = EnumC2037d.DidShow;
        } else {
            enumC2037d = EnumC2037d.NotShow;
        }
        if (z) {
            enumC2035b = EnumC2035b.DidContain;
        } else {
            enumC2035b = EnumC2035b.NotContain;
        }
        m53122f(context, enumC2037d, enumC2035b, c2073i1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static String m53116l(long j) {
        return String.format("%d-%s", Long.valueOf(j), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static ArrayList<File> m53115m(String str) {
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

    /* renamed from: n */
    static /* synthetic */ void m53114n(Context context) {
        try {
            Iterator<File> it = m53115m(m53107u(context)).iterator();
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
                        if (m53112p(context, new JSONObject(new String(C2080j2.m52834q(context, bArr))))) {
                            next.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: o */
    static /* synthetic */ void m53113o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String m53108t = m53108t(context);
            File file = new File(m53108t + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static boolean m53112p(Context context, JSONObject jSONObject) {
        try {
            C2075i2 c2075i2 = new C2075i2();
            c2075i2.f6207n = context;
            c2075i2.f6206m = jSONObject;
            new C2163u2();
            C2021b3 m52427d = C2163u2.m52427d(c2075i2);
            if (m52427d != null) {
                JSONObject jSONObject2 = new JSONObject(C2079j1.m52870g(m52427d.f5893a));
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
    /* renamed from: r */
    public static synchronized void m53110r(Context context) {
        synchronized (C2033cf.class) {
            if (context == null) {
                return;
            }
            if (!f5991l) {
                m53109s(context);
                f5991l = true;
            }
            C2080j2.m52846e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f5980a.m53104a()), Integer.valueOf(f5981b.m53101a()), Long.valueOf(f5984e), f5982c, f5983d, Integer.valueOf(f5985f.m53106a()), Long.valueOf(f5986g), f5987h, f5988i, Long.valueOf(f5989j), Long.valueOf(f5990k)));
        }
    }

    /* renamed from: s */
    private static void m53109s(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = C2080j2.m52847d(context, "AMap.privacy.data", "AMap.privacy.data");
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
            f5980a = EnumC2035b.m53103a(Integer.parseInt(split[0]));
            f5981b = EnumC2037d.m53100a(Integer.parseInt(split[1]));
            f5984e = Long.parseLong(split[2]);
            f5983d = split[3];
            f5983d = split[4];
            f5985f = EnumC2034a.m53105a(Integer.parseInt(split[5]));
            f5986g = Long.parseLong(split[6]);
            f5987h = split[7];
            f5988i = split[8];
            f5989j = Long.parseLong(split[9]);
            f5990k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public static String m53108t(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    /* renamed from: u */
    private static String m53107u(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
