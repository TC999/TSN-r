package com.amap.api.col.p0463l;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.ft */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Privacy {

    /* renamed from: a */
    private static volatile EnumC1811b f4183a = EnumC1811b.Unknow;

    /* renamed from: b */
    private static volatile EnumC1813d f4184b = EnumC1813d.Unknow;

    /* renamed from: c */
    private static volatile String f4185c = "";

    /* renamed from: d */
    private static volatile String f4186d = "";

    /* renamed from: e */
    private static volatile long f4187e = -1;

    /* renamed from: f */
    private static volatile EnumC1810a f4188f = EnumC1810a.Unknow;

    /* renamed from: g */
    private static volatile long f4189g = -1;

    /* renamed from: h */
    private static volatile String f4190h = "";

    /* renamed from: i */
    private static volatile String f4191i = "";

    /* renamed from: j */
    private static volatile long f4192j = 0;

    /* renamed from: k */
    private static volatile long f4193k = 0;

    /* renamed from: l */
    private static volatile boolean f4194l = false;

    /* renamed from: m */
    private static volatile boolean f4195m = true;

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1810a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        

        /* renamed from: d */
        private int f4200d;

        EnumC1810a(int i) {
            this.f4200d = i;
        }

        /* renamed from: a */
        public final int m54974a() {
            return this.f4200d;
        }

        /* renamed from: a */
        public static EnumC1810a m54973a(int i) {
            EnumC1810a enumC1810a = NotAgree;
            if (i == enumC1810a.m54974a()) {
                return enumC1810a;
            }
            EnumC1810a enumC1810a2 = DidAgree;
            return i == enumC1810a2.m54974a() ? enumC1810a2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1811b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        

        /* renamed from: d */
        private int f4205d;

        EnumC1811b(int i) {
            this.f4205d = i;
        }

        /* renamed from: a */
        public final int m54972a() {
            return this.f4205d;
        }

        /* renamed from: a */
        public static EnumC1811b m54971a(int i) {
            EnumC1811b enumC1811b = NotContain;
            if (i == enumC1811b.m54972a()) {
                return enumC1811b;
            }
            EnumC1811b enumC1811b2 = DidContain;
            return i == enumC1811b2.m54972a() ? enumC1811b2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1812c {
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
        private final int f4216j;

        EnumC1812c(int i) {
            this.f4216j = i;
        }

        /* renamed from: a */
        public final int m54970a() {
            return this.f4216j;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1813d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        

        /* renamed from: d */
        private int f4221d;

        EnumC1813d(int i) {
            this.f4221d = i;
        }

        /* renamed from: a */
        public final int m54969a() {
            return this.f4221d;
        }

        /* renamed from: a */
        public static EnumC1813d m54968a(int i) {
            EnumC1813d enumC1813d = NotShow;
            if (i == enumC1813d.m54969a()) {
                return enumC1813d;
            }
            EnumC1813d enumC1813d2 = DidShow;
            return i == enumC1813d2.m54969a() ? enumC1813d2 : Unknow;
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1814e extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f4222a;

        C1814e(Context context) {
            this.f4222a = context;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            Iterator it = Privacy.m54983m(Privacy.m54976t(this.f4222a)).iterator();
            while (it.hasNext()) {
                Privacy.m54989g(this.f4222a, ((File) it.next()).getName());
            }
            Privacy.m54982n(this.f4222a);
        }
    }

    /* compiled from: Privacy.java */
    /* renamed from: com.amap.api.col.3l.ft$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1815f extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ boolean f4223a;

        /* renamed from: b */
        final /* synthetic */ Context f4224b;

        /* renamed from: c */
        final /* synthetic */ long f4225c;

        /* renamed from: d */
        final /* synthetic */ JSONObject f4226d;

        C1815f(boolean z, Context context, long j, JSONObject jSONObject) {
            this.f4223a = z;
            this.f4224b = context;
            this.f4225c = j;
            this.f4226d = jSONObject;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            if (this.f4223a) {
                Iterator it = Privacy.m54983m(Privacy.m54976t(this.f4224b)).iterator();
                while (it.hasNext()) {
                    Privacy.m54989g(this.f4224b, ((File) it.next()).getName());
                }
            }
            Privacy.m54978r(this.f4224b);
            Privacy.m54988h(this.f4224b, this.f4226d, this.f4225c);
            boolean m54980p = Privacy.m54980p(this.f4224b, this.f4226d);
            if (m54980p) {
                Privacy.m54981o(this.f4224b, Privacy.m54984l(this.f4225c));
            }
            if (this.f4223a) {
                Privacy.m54982n(this.f4224b);
            }
            if (m54980p) {
                return;
            }
            Privacy.m54989g(this.f4224b, Privacy.m54984l(this.f4225c));
        }
    }

    /* renamed from: a */
    public static synchronized PrivacyError m54995a(Context context, SDKInfo sDKInfo) {
        boolean z;
        synchronized (Privacy.class) {
            PrivacyError privacyError = null;
            if (context != null && sDKInfo != null) {
                if (!f4194l) {
                    m54977s(context);
                    f4194l = true;
                }
                if (f4184b != EnumC1813d.DidShow) {
                    if (f4184b == EnumC1813d.Unknow) {
                        privacyError = new PrivacyError(EnumC1812c.ShowUnknowCode, sDKInfo);
                    } else if (f4184b == EnumC1813d.NotShow) {
                        privacyError = new PrivacyError(EnumC1812c.ShowNoShowCode, sDKInfo);
                    }
                    z = false;
                } else {
                    z = true;
                }
                if (z && f4183a != EnumC1811b.DidContain) {
                    if (f4183a == EnumC1811b.Unknow) {
                        privacyError = new PrivacyError(EnumC1812c.InfoUnknowCode, sDKInfo);
                    } else if (f4183a == EnumC1811b.NotContain) {
                        privacyError = new PrivacyError(EnumC1812c.InfoNotContainCode, sDKInfo);
                    }
                    z = false;
                }
                if (z && f4188f != EnumC1810a.DidAgree) {
                    if (f4188f == EnumC1810a.Unknow) {
                        privacyError = new PrivacyError(EnumC1812c.AgreeUnknowCode, sDKInfo);
                    } else if (f4188f == EnumC1810a.NotAgree) {
                        privacyError = new PrivacyError(EnumC1812c.AgreeNotAgreeCode, sDKInfo);
                    }
                    z = false;
                }
                if (f4193k != f4192j) {
                    long j = f4192j;
                    f4193k = f4192j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f4183a.m54972a());
                        jSONObject.put("privacyShow", f4184b.m54969a());
                        jSONObject.put("showTime", f4187e);
                        jSONObject.put("show2SDK", f4185c);
                        jSONObject.put("show2SDKVer", f4186d);
                        jSONObject.put("privacyAgree", f4188f.m54974a());
                        jSONObject.put("agreeTime", f4189g);
                        jSONObject.put("agree2SDK", f4190h);
                        jSONObject.put("agree2SDKVer", f4191i);
                        ThreadPool.m53398h().m55654b(new C1815f(f4195m, context, j, jSONObject));
                    } catch (Throwable unused) {
                    }
                } else if (f4195m) {
                    ThreadPool.m53398h().m55654b(new C1814e(context));
                }
                f4195m = false;
                String m55240j = C1780e4.m55240j(context);
                if (m55240j == null || m55240j.length() <= 0) {
                    privacyError = new PrivacyError(EnumC1812c.InvaildUserKeyCode, sDKInfo);
                    Log.e(sDKInfo.m54400a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(privacyError.f4676a.m54970a()), privacyError.f4677b));
                }
                if (z) {
                    privacyError = new PrivacyError(EnumC1812c.SuccessCode, sDKInfo);
                } else {
                    Log.e(sDKInfo.m54400a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(privacyError.f4676a.m54970a()), privacyError.f4677b));
                }
                return privacyError;
            }
            return new PrivacyError(EnumC1812c.IllegalArgument, sDKInfo);
        }
    }

    /* renamed from: e */
    private static synchronized void m54991e(Context context, EnumC1810a enumC1810a, SDKInfo sDKInfo) {
        synchronized (Privacy.class) {
            if (context == null || sDKInfo == null) {
                return;
            }
            if (!f4194l) {
                m54977s(context);
                f4194l = true;
            }
            if (enumC1810a != f4188f) {
                f4188f = enumC1810a;
                f4190h = sDKInfo.m54400a();
                f4191i = sDKInfo.m54396e();
                long currentTimeMillis = System.currentTimeMillis();
                f4189g = currentTimeMillis;
                f4192j = currentTimeMillis;
                m54978r(context);
            }
        }
    }

    /* renamed from: f */
    private static synchronized void m54990f(Context context, EnumC1813d enumC1813d, EnumC1811b enumC1811b, SDKInfo sDKInfo) {
        synchronized (Privacy.class) {
            if (context == null || sDKInfo == null) {
                return;
            }
            if (!f4194l) {
                m54977s(context);
                f4194l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (enumC1813d != f4184b) {
                bool = Boolean.TRUE;
                f4184b = enumC1813d;
            }
            if (enumC1811b != f4183a) {
                bool = Boolean.TRUE;
                f4183a = enumC1811b;
            }
            if (bool.booleanValue()) {
                f4185c = sDKInfo.m54400a();
                f4186d = sDKInfo.m54396e();
                long currentTimeMillis = System.currentTimeMillis();
                f4187e = currentTimeMillis;
                f4192j = currentTimeMillis;
                m54978r(context);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m54989g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String m54976t = m54976t(context);
            File file = new File(m54976t + "/" + str);
            if (file.exists()) {
                String m54975u = m54975u(context);
                File file2 = new File(m54975u + "/" + str);
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
    static /* synthetic */ void m54988h(Context context, JSONObject jSONObject, long j) {
        byte[] m55221n;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            m55221n = SPUtil.m55221n(context, jSONObject.toString().getBytes());
            String m54984l = m54984l(j);
            String m54976t = m54976t(context);
            File file = new File(m54976t + "/" + m54984l);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(m55221n);
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
    public static void m54987i(Context context, boolean z, SDKInfo sDKInfo) {
        EnumC1810a enumC1810a;
        if (z) {
            enumC1810a = EnumC1810a.DidAgree;
        } else {
            enumC1810a = EnumC1810a.NotAgree;
        }
        m54991e(context, enumC1810a, sDKInfo);
    }

    /* renamed from: j */
    public static void m54986j(Context context, boolean z, boolean z2, SDKInfo sDKInfo) {
        EnumC1813d enumC1813d;
        EnumC1811b enumC1811b;
        if (z2) {
            enumC1813d = EnumC1813d.DidShow;
        } else {
            enumC1813d = EnumC1813d.NotShow;
        }
        if (z) {
            enumC1811b = EnumC1811b.DidContain;
        } else {
            enumC1811b = EnumC1811b.NotContain;
        }
        m54990f(context, enumC1813d, enumC1811b, sDKInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static String m54984l(long j) {
        return String.format("%d-%s", Long.valueOf(j), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static ArrayList<File> m54983m(String str) {
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
    static /* synthetic */ void m54982n(Context context) {
        try {
            Iterator<File> it = m54983m(m54975u(context)).iterator();
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
                        if (m54980p(context, new JSONObject(new String(SPUtil.m55218q(context, bArr))))) {
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
    static /* synthetic */ void m54981o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String m54976t = m54976t(context);
            File file = new File(m54976t + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static boolean m54980p(Context context, JSONObject jSONObject) {
        try {
            PrivacyUploadRequest privacyUploadRequest = new PrivacyUploadRequest();
            privacyUploadRequest.f3553j = context;
            privacyUploadRequest.f3552i = jSONObject;
            new BaseNetManager();
            ResponseEntity m54173d = BaseNetManager.m54173d(privacyUploadRequest);
            if (m54173d != null) {
                JSONObject jSONObject2 = new JSONObject(C1925p4.m54197g(m54173d.f5682a));
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
    public static synchronized void m54978r(Context context) {
        synchronized (Privacy.class) {
            if (context == null) {
                return;
            }
            if (!f4194l) {
                m54977s(context);
                f4194l = true;
            }
            SPUtil.m55230e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f4183a.m54972a()), Integer.valueOf(f4184b.m54969a()), Long.valueOf(f4187e), f4185c, f4186d, Integer.valueOf(f4188f.m54974a()), Long.valueOf(f4189g), f4190h, f4191i, Long.valueOf(f4192j), Long.valueOf(f4193k)));
        }
    }

    /* renamed from: s */
    private static void m54977s(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = SPUtil.m55231d(context, "AMap.privacy.data", "AMap.privacy.data");
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
            f4183a = EnumC1811b.m54971a(Integer.parseInt(split[0]));
            f4184b = EnumC1813d.m54968a(Integer.parseInt(split[1]));
            f4187e = Long.parseLong(split[2]);
            f4186d = split[3];
            f4186d = split[4];
            f4188f = EnumC1810a.m54973a(Integer.parseInt(split[5]));
            f4189g = Long.parseLong(split[6]);
            f4190h = split[7];
            f4191i = split[8];
            f4192j = Long.parseLong(split[9]);
            f4193k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public static String m54976t(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    /* renamed from: u */
    private static String m54975u(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
