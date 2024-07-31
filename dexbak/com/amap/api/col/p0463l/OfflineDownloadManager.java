package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* renamed from: com.amap.api.col.3l.b0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class OfflineDownloadManager {

    /* renamed from: o */
    public static String f3613o = "";

    /* renamed from: p */
    public static boolean f3614p = false;

    /* renamed from: q */
    private static volatile OfflineDownloadManager f3615q = null;

    /* renamed from: r */
    public static String f3616r = "";

    /* renamed from: a */
    private Context f3617a;

    /* renamed from: d */
    private InterfaceC1747d f3620d;

    /* renamed from: e */
    private TaskManager f3621e;

    /* renamed from: f */
    private OfflineDBOperation f3622f;

    /* renamed from: k */
    public OfflineMapDownloadList f3627k;

    /* renamed from: l */
    OfflineMapRemoveTask f3628l;

    /* renamed from: b */
    private boolean f3618b = true;

    /* renamed from: c */
    List<CityObject> f3619c = new Vector();

    /* renamed from: g */
    private ThreadPool f3623g = null;

    /* renamed from: h */
    private ThreadPool f3624h = null;

    /* renamed from: i */
    private ThreadPool f3625i = null;

    /* renamed from: j */
    HandlerC1748e f3626j = null;

    /* renamed from: m */
    OfflineMapDataVerify f3629m = null;

    /* renamed from: n */
    private boolean f3630n = true;

    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1744a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ String f3631a;

        C1744a(String str) {
            this.f3631a = str;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            CityObject m55602I = OfflineDownloadManager.this.m55602I(this.f3631a);
            if (m55602I != null) {
                try {
                    if (!m55602I.m55618s().equals(m55602I.f3575h) && !m55602I.m55618s().equals(m55602I.f3577j)) {
                        String pinyin = m55602I.getPinyin();
                        if (pinyin.length() > 0) {
                            String m54073n = OfflineDownloadManager.this.f3622f.m54073n(pinyin);
                            if (m54073n == null) {
                                m54073n = m55602I.getVersion();
                            }
                            if (OfflineDownloadManager.f3616r.length() > 0 && m54073n != null && OfflineDownloadManager.m55582n(OfflineDownloadManager.f3616r, m54073n)) {
                                m55602I.m55635E();
                            }
                        }
                    }
                    if (OfflineDownloadManager.this.f3620d != null) {
                        synchronized (OfflineDownloadManager.this) {
                            try {
                                OfflineDownloadManager.this.f3620d.mo51983b(m55602I);
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    if (OfflineDownloadManager.this.f3620d != null) {
                        synchronized (OfflineDownloadManager.this) {
                            try {
                                OfflineDownloadManager.this.f3620d.mo51983b(m55602I);
                                return;
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (OfflineDownloadManager.this.f3620d != null) {
                        synchronized (OfflineDownloadManager.this) {
                            try {
                                OfflineDownloadManager.this.f3620d.mo51983b(m55602I);
                            }
                        }
                    }
                    throw th;
                }
            }
            OfflineDownloadManager.this.m55599L();
            OfflineInitBean m55751f = new OfflineInitHandlerAbstract(OfflineDownloadManager.this.f3617a, OfflineDownloadManager.f3616r).m55751f();
            if (OfflineDownloadManager.this.f3620d != null) {
                if (m55751f == null) {
                    if (OfflineDownloadManager.this.f3620d != null) {
                        synchronized (OfflineDownloadManager.this) {
                            try {
                                OfflineDownloadManager.this.f3620d.mo51983b(m55602I);
                            }
                        }
                        return;
                    }
                    return;
                } else if (m55751f.m55516c()) {
                    OfflineDownloadManager.this.m55580p();
                }
            }
            if (OfflineDownloadManager.this.f3620d != null) {
                synchronized (OfflineDownloadManager.this) {
                    try {
                        OfflineDownloadManager.this.f3620d.mo51983b(m55602I);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1745b extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ CityObject f3633a;

        /* renamed from: b */
        final /* synthetic */ boolean f3634b;

        C1745b(CityObject cityObject, boolean z) {
            this.f3633a = cityObject;
            this.f3634b = z;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                if (this.f3633a.m55618s().equals(this.f3633a.f3573f)) {
                    if (OfflineDownloadManager.this.f3620d != null) {
                        OfflineDownloadManager.this.f3620d.mo51982c(this.f3633a);
                        return;
                    }
                    return;
                }
                if (this.f3633a.getState() != 7 && this.f3633a.getState() != -1) {
                    OfflineDownloadManager.this.f3628l.m54736a(this.f3633a);
                    if (OfflineDownloadManager.this.f3620d != null) {
                        OfflineDownloadManager.this.f3620d.mo51982c(this.f3633a);
                        return;
                    }
                    return;
                }
                OfflineDownloadManager.this.f3628l.m54736a(this.f3633a);
                if (!this.f3634b || OfflineDownloadManager.this.f3620d == null) {
                    return;
                }
                OfflineDownloadManager.this.f3620d.mo51982c(this.f3633a);
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1746c extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ CityObject f3636a;

        C1746c(CityObject cityObject) {
            this.f3636a = cityObject;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                if (OfflineDownloadManager.this.f3618b) {
                    OfflineDownloadManager.this.m55599L();
                    OfflineInitBean m55751f = new OfflineInitHandlerAbstract(OfflineDownloadManager.this.f3617a, OfflineDownloadManager.f3616r).m55751f();
                    if (m55751f != null) {
                        OfflineDownloadManager.m55607D(OfflineDownloadManager.this);
                        if (m55751f.m55516c()) {
                            OfflineDownloadManager.this.m55580p();
                        }
                    }
                }
                this.f3636a.setVersion(OfflineDownloadManager.f3616r);
                this.f3636a.m55639A();
            } catch (AMapException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1747d {
        /* renamed from: a */
        void mo51985a();

        /* renamed from: a */
        void mo51984a(CityObject cityObject);

        /* renamed from: b */
        void mo51983b(CityObject cityObject);

        /* renamed from: c */
        void mo51982c(CityObject cityObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineDownloadManager.java */
    /* renamed from: com.amap.api.col.3l.b0$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class HandlerC1748e extends Handler {
        public HandlerC1748e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof CityObject) {
                    CityObject cityObject = (CityObject) obj;
                    cityObject.getCity();
                    cityObject.getcompleteCode();
                    cityObject.getState();
                    if (OfflineDownloadManager.this.f3620d != null) {
                        OfflineDownloadManager.this.f3620d.mo51984a(cityObject);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private OfflineDownloadManager(Context context) {
        this.f3617a = context;
    }

    /* renamed from: B */
    private void m55609B(CityObject cityObject) throws AMapException {
        m55599L();
        if (cityObject != null) {
            if (this.f3625i == null) {
                this.f3625i = ThreadUtilPoolFactory.m53336b("AMapOfflineDownload");
            }
            try {
                this.f3625i.m55654b(new C1746c(cityObject));
                return;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: D */
    static /* synthetic */ boolean m55607D(OfflineDownloadManager offlineDownloadManager) {
        offlineDownloadManager.f3618b = false;
        return false;
    }

    /* renamed from: F */
    private void m55605F() {
        try {
            UpdateItem m54086a = this.f3622f.m54086a("000001");
            if (m54086a != null) {
                this.f3622f.m54074m("000001");
                m54086a.m54255b("100000");
                this.f3622f.m54082e(m54086a);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    /* renamed from: G */
    private void m55604G() {
        String m53340n;
        if ("".equals(C1732a3.m55707f0(this.f3617a))) {
            return;
        }
        File file = new File(C1732a3.m55707f0(this.f3617a) + "offlinemapv4.png");
        if (!file.exists()) {
            m53340n = Utility.m53350d(this.f3617a, "offlinemapv4.png");
        } else {
            m53340n = Utility.m53340n(file);
        }
        if (m53340n != null) {
            try {
                m55603H(m53340n);
            } catch (JSONException e) {
                if (file.exists()) {
                    file.delete();
                }
                SDKLogHandler.m53863p(e, "MapDownloadManager", "paseJson io");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: H */
    private void m55603H(String str) throws JSONException {
        OfflineMapDownloadList offlineMapDownloadList;
        List<OfflineMapProvince> m53348f = Utility.m53348f(str, StubApp.getOrigApplicationContext(this.f3617a.getApplicationContext()));
        if (m53348f == null || m53348f.size() == 0 || (offlineMapDownloadList = this.f3627k) == null) {
            return;
        }
        offlineMapDownloadList.m54957i(m53348f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[Catch: all -> 0x0037, TryCatch #0 {, blocks: (B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0029, B:16:0x0033, B:18:0x0035), top: B:24:0x000d }] */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.col.p0463l.CityObject m55602I(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L3a
            int r1 = r6.length()
            if (r1 > 0) goto La
            goto L3a
        La:
            java.util.List<com.amap.api.col.3l.ax> r1 = r5.f3619c
            monitor-enter(r1)
            java.util.List<com.amap.api.col.3l.ax> r2 = r5.f3619c     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L37
        L13:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L35
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L37
            com.amap.api.col.3l.ax r3 = (com.amap.api.col.p0463l.CityObject) r3     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = r3.getCity()     // Catch: java.lang.Throwable -> L37
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 != 0) goto L33
            java.lang.String r4 = r3.getPinyin()     // Catch: java.lang.Throwable -> L37
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L13
        L33:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return r3
        L35:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return r0
        L37:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            throw r6
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.OfflineDownloadManager.m55602I(java.lang.String):com.amap.api.col.3l.ax");
    }

    /* renamed from: J */
    private void m55601J() {
        Iterator<UpdateItem> it = this.f3622f.m54084c().iterator();
        while (it.hasNext()) {
            UpdateItem next = it.next();
            if (next != null && next.m54256a() != null && next.m54252e().length() > 0) {
                int i = next.f5038l;
                if (i != 4 && i != 7 && i >= 0) {
                    next.f5038l = 3;
                }
                CityObject m55602I = m55602I(next.m54256a());
                if (m55602I != null) {
                    String m54254c = next.m54254c();
                    if (m54254c != null && m55582n(f3616r, m54254c)) {
                        m55602I.m55623i(7);
                    } else {
                        m55602I.m55623i(next.f5038l);
                        m55602I.setCompleteCode(next.m54248i());
                    }
                    if (next.m54254c().length() > 0) {
                        m55602I.setVersion(next.m54254c());
                    }
                    List<String> m54077j = this.f3622f.m54077j(next.m54252e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : m54077j) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    m55602I.m55620l(stringBuffer.toString());
                    OfflineMapDownloadList offlineMapDownloadList = this.f3627k;
                    if (offlineMapDownloadList != null) {
                        offlineMapDownloadList.m54963c(m55602I);
                    }
                }
            }
        }
    }

    /* renamed from: K */
    private CityObject m55600K(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f3619c) {
            for (CityObject cityObject : this.f3619c) {
                if (str.equals(cityObject.getCode())) {
                    return cityObject;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m55599L() throws AMapException {
        if (!C1732a3.m55703h0(this.f3617a)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    /* renamed from: M */
    private static void m55598M() {
        f3615q = null;
        f3614p = true;
    }

    /* renamed from: N */
    private static void m55597N(String str) {
        f3613o = str;
    }

    /* renamed from: O */
    private void m55596O() {
        synchronized (this) {
            this.f3620d = null;
        }
    }

    /* renamed from: b */
    public static OfflineDownloadManager m55594b(Context context) {
        if (f3615q == null) {
            synchronized (OfflineDownloadManager.class) {
                if (f3615q == null && !f3614p) {
                    f3615q = new OfflineDownloadManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f3615q;
    }

    /* renamed from: f */
    private void m55590f(CityObject cityObject, boolean z) {
        if (this.f3628l == null) {
            this.f3628l = new OfflineMapRemoveTask(this.f3617a);
        }
        if (this.f3624h == null) {
            this.f3624h = ThreadUtilPoolFactory.m53336b("AMapOfflineRemove");
        }
        try {
            this.f3624h.m55654b(new C1745b(cityObject, z));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static boolean m55582n(String str, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: A */
    public final void m55610A() {
        ThreadPool threadPool = this.f3623g;
        if (threadPool != null) {
            threadPool.m55649g();
        }
        ThreadPool threadPool2 = this.f3625i;
        if (threadPool2 != null) {
            threadPool2.m55649g();
            this.f3625i = null;
        }
        OfflineMapDataVerify offlineMapDataVerify = this.f3629m;
        if (offlineMapDataVerify != null) {
            if (offlineMapDataVerify.isAlive()) {
                this.f3629m.interrupt();
            }
            this.f3629m = null;
        }
        HandlerC1748e handlerC1748e = this.f3626j;
        if (handlerC1748e != null) {
            handlerC1748e.removeCallbacksAndMessages(null);
            this.f3626j = null;
        }
        TaskManager taskManager = this.f3621e;
        if (taskManager != null) {
            taskManager.m54591d();
            this.f3621e = null;
        }
        OfflineMapDownloadList offlineMapDownloadList = this.f3627k;
        if (offlineMapDownloadList != null) {
            offlineMapDownloadList.m54943w();
        }
        m55598M();
        this.f3618b = true;
        m55596O();
    }

    /* renamed from: C */
    public final void m55608C(String str) throws AMapException {
        CityObject m55600K = m55600K(str);
        if (m55600K != null) {
            m55609B(m55600K);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: E */
    public final String m55606E(String str) {
        CityObject m55602I;
        return (str == null || (m55602I = m55602I(str)) == null) ? "" : m55602I.getAdcode();
    }

    /* renamed from: d */
    public final void m55592d() {
        this.f3622f = OfflineDBOperation.m54085b(StubApp.getOrigApplicationContext(this.f3617a.getApplicationContext()));
        m55605F();
        this.f3626j = new HandlerC1748e(this.f3617a.getMainLooper());
        this.f3627k = new OfflineMapDownloadList(this.f3617a);
        this.f3621e = TaskManager.m54594a();
        m55597N(C1732a3.m55707f0(this.f3617a));
        try {
            m55604G();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f3619c) {
            Iterator<OfflineMapProvince> it = this.f3627k.m54964b().iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.f3619c.add(new CityObject(this.f3617a, next));
                    }
                }
            }
        }
        OfflineMapDataVerify offlineMapDataVerify = new OfflineMapDataVerify(this.f3617a);
        this.f3629m = offlineMapDataVerify;
        offlineMapDataVerify.start();
    }

    /* renamed from: e */
    public final void m55591e(CityObject cityObject) {
        m55590f(cityObject, false);
    }

    /* renamed from: g */
    public final void m55589g(InterfaceC1747d interfaceC1747d) {
        this.f3620d = interfaceC1747d;
    }

    /* renamed from: h */
    public final void m55588h(String str) {
        try {
            if (str == null) {
                InterfaceC1747d interfaceC1747d = this.f3620d;
                if (interfaceC1747d != null) {
                    interfaceC1747d.mo51983b(null);
                    return;
                }
                return;
            }
            if (this.f3623g == null) {
                this.f3623g = ThreadUtilPoolFactory.m53336b("AMapOfflineCheckUpdate");
            }
            this.f3623g.m55654b(new C1744a(str));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    /* renamed from: j */
    public final void m55586j() {
        m55601J();
        InterfaceC1747d interfaceC1747d = this.f3620d;
        if (interfaceC1747d != null) {
            try {
                interfaceC1747d.mo51985a();
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    /* renamed from: k */
    public final void m55585k(CityObject cityObject) {
        try {
            TaskManager taskManager = this.f3621e;
            if (taskManager != null) {
                taskManager.m54592c(cityObject, this.f3617a);
            }
        } catch (AMapCoreException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    public final boolean m55583m(String str) {
        return m55602I(str) != null;
    }

    /* renamed from: p */
    protected final void m55580p() throws AMapException {
        if (this.f3627k == null) {
            return;
        }
        OfflineUpdateCityHandlerAbstract offlineUpdateCityHandlerAbstract = new OfflineUpdateCityHandlerAbstract(this.f3617a, "");
        offlineUpdateCityHandlerAbstract.m54688h(this.f3617a);
        List<OfflineMapProvince> m55751f = offlineUpdateCityHandlerAbstract.m55751f();
        if (this.f3619c != null) {
            this.f3627k.m54957i(m55751f);
        }
        List<CityObject> list = this.f3619c;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> it = this.f3627k.m54964b().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        for (CityObject cityObject : this.f3619c) {
                            if (next.getPinyin().equals(cityObject.getPinyin())) {
                                String version = cityObject.getVersion();
                                if (cityObject.getState() == 4 && f3616r.length() > 0 && m55582n(f3616r, version)) {
                                    cityObject.m55635E();
                                    cityObject.setUrl(next.getUrl());
                                    cityObject.m55632H();
                                } else {
                                    cityObject.setCity(next.getCity());
                                    cityObject.setUrl(next.getUrl());
                                    cityObject.m55632H();
                                    cityObject.setAdcode(next.getAdcode());
                                    cityObject.setVersion(next.getVersion());
                                    cityObject.setSize(next.getSize());
                                    cityObject.setCode(next.getCode());
                                    cityObject.setJianpin(next.getJianpin());
                                    cityObject.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: q */
    public final void m55579q(CityObject cityObject) {
        OfflineMapDownloadList offlineMapDownloadList = this.f3627k;
        if (offlineMapDownloadList != null) {
            offlineMapDownloadList.m54963c(cityObject);
        }
        HandlerC1748e handlerC1748e = this.f3626j;
        if (handlerC1748e != null) {
            Message obtainMessage = handlerC1748e.obtainMessage();
            obtainMessage.obj = cityObject;
            this.f3626j.sendMessage(obtainMessage);
        }
    }

    /* renamed from: r */
    public final void m55578r(String str) {
        CityObject m55602I = m55602I(str);
        if (m55602I == null) {
            InterfaceC1747d interfaceC1747d = this.f3620d;
            if (interfaceC1747d != null) {
                try {
                    interfaceC1747d.mo51982c(m55602I);
                    return;
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        m55575u(m55602I);
        m55590f(m55602I, true);
    }

    /* renamed from: t */
    public final void m55576t() {
        synchronized (this.f3619c) {
            for (CityObject cityObject : this.f3619c) {
                if (cityObject.m55618s().equals(cityObject.f3575h) || cityObject.m55618s().equals(cityObject.f3574g)) {
                    m55575u(cityObject);
                    cityObject.m55638B();
                }
            }
        }
    }

    /* renamed from: u */
    public final void m55575u(CityObject cityObject) {
        TaskManager taskManager = this.f3621e;
        if (taskManager != null) {
            taskManager.m54593b(cityObject);
        }
    }

    /* renamed from: v */
    public final void m55574v(String str) {
        CityObject m55602I = m55602I(str);
        if (m55602I != null) {
            m55602I.m55639A();
        }
    }

    /* renamed from: w */
    public final void m55573w() {
        synchronized (this.f3619c) {
            Iterator<CityObject> it = this.f3619c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CityObject next = it.next();
                if (next.m55618s().equals(next.f3575h)) {
                    next.m55638B();
                    break;
                }
            }
        }
    }

    /* renamed from: x */
    public final void m55572x(CityObject cityObject) {
        TaskManager taskManager = this.f3621e;
        if (taskManager != null) {
            taskManager.m54590e(cityObject);
        }
    }

    /* renamed from: y */
    public final void m55571y(String str) throws AMapException {
        CityObject m55602I = m55602I(str);
        if (str != null && str.length() > 0 && m55602I != null) {
            m55609B(m55602I);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
