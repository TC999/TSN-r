package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.amap.api.col.p0463l.AmapCell;
import com.amap.api.col.p0463l.AmapLocationGnss;
import com.amap.api.col.p0463l.AmapWifi;
import com.amap.api.col.p0463l.BaseNetManager;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.CollectionData;
import com.amap.api.col.p0463l.DeviceInfo;
import com.amap.api.col.p0463l.DiskLruCache;
import com.amap.api.col.p0463l.Encrypt;
import com.amap.api.col.p0463l.FpsCollector;
import com.amap.api.col.p0463l.HttpRequest;
import com.amap.api.col.p0463l.HttpResponse;
import com.amap.api.col.p0463l.INetwork;
import com.amap.api.col.p0463l.Log;
import com.amap.api.col.p0463l.LogConfig;
import com.amap.api.col.p0463l.LogEngine;
import com.amap.api.col.p0463l.MobileUpdateStrategy;
import com.amap.api.col.p0463l.NoneEncryptProcessor;
import com.amap.api.col.p0463l.OpenSdkCollectionManagerProxy;
import com.amap.api.col.p0463l.ResponseEntity;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.ThreadPool;
import com.amap.api.col.p0463l.ThreadTask;
import com.amap.api.col.p0463l.TimeUpdateStrategy;
import com.amap.api.col.p0463l.Utils;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.SystemApiWrapper;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.security.C2422a;
import com.autonavi.aps.amapapi.trans.C2426b;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;
import kotlin.UByte;

/* renamed from: com.autonavi.aps.amapapi.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CollectionManager implements INetwork {

    /* renamed from: k */
    private static long f8037k;

    /* renamed from: a */
    Context f8038a;

    /* renamed from: d */
    OpenSdkCollectionManagerProxy f8041d;

    /* renamed from: e */
    LogConfig f8042e;

    /* renamed from: g */
    private Handler f8044g;

    /* renamed from: h */
    private LocationManager f8045h;

    /* renamed from: i */
    private C2414a f8046i;

    /* renamed from: f */
    private ArrayList<CollectionData> f8043f = new ArrayList<>();

    /* renamed from: b */
    WifiManagerWrapper f8039b = null;

    /* renamed from: c */
    CgiManager f8040c = null;

    /* renamed from: j */
    private volatile boolean f8047j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectionManager.java */
    /* renamed from: com.autonavi.aps.amapapi.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2414a implements LocationListener {

        /* renamed from: a */
        private CollectionManager f8049a;

        C2414a(CollectionManager collectionManager) {
            this.f8049a = collectionManager;
        }

        /* renamed from: a */
        final void m51653a(CollectionManager collectionManager) {
            this.f8049a = collectionManager;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                CollectionManager collectionManager = this.f8049a;
                if (collectionManager != null) {
                    collectionManager.m51673a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        /* renamed from: a */
        final void m51654a() {
            this.f8049a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollectionManager(Context context) {
        this.f8038a = null;
        this.f8038a = context;
        LogConfig logConfig = new LogConfig();
        this.f8042e = logConfig;
        Utils.m54745f(this.f8038a, logConfig, Log.f5128k, 100, 1024000, "0");
        LogConfig logConfig2 = this.f8042e;
        int i = AuthUtil.f8346g;
        boolean z = AuthUtil.f8344e;
        int i2 = AuthUtil.f8345f;
        logConfig2.f3559f = new TimeUpdateStrategy(context, i, "kKey", new MobileUpdateStrategy(context, z, i2, i2 * 10, "carrierLocKey"));
        this.f8042e.f3558e = new NoneEncryptProcessor();
    }

    /* renamed from: b */
    private static byte[] m51665b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: c */
    private static byte[] m51660c(int i) {
        return new byte[]{(byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    /* renamed from: f */
    static /* synthetic */ byte[] m51656f() {
        return m51675a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m51655g() {
        try {
            DebugUtils.m51285a();
            if (C2432j.m51154m(this.f8038a)) {
                DebugUtils.m51285a();
                return;
            }
            ArrayList<CollectionData> arrayList = this.f8043f;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f8043f) {
                    arrayList2.addAll(this.f8043f);
                    this.f8043f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] m51675a = m51675a(256);
                if (m51675a == null) {
                    return;
                }
                byteArrayOutputStream.write(m51660c(m51675a.length));
                byteArrayOutputStream.write(m51675a);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    CollectionData collectionData = (CollectionData) it.next();
                    byte[] m54649b = collectionData.m54649b();
                    if (m54649b.length >= 10 && m54649b.length <= 65535) {
                        byte[] m54717h = Encrypt.m54717h(m51675a, m54649b, C1925p4.m54182v());
                        byteArrayOutputStream.write(m51660c(m54717h.length));
                        byteArrayOutputStream.write(m54717h);
                        byteArrayOutputStream.write(m51665b(collectionData.m54650a()));
                    }
                }
                LogEngine.m55539c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.f8042e);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "clm", "wtD");
        }
    }

    /* renamed from: d */
    public final void m51658d() {
        try {
            if (C2432j.m51154m(this.f8038a)) {
                DebugUtils.m51285a();
            } else if (System.currentTimeMillis() - f8037k < 60000) {
            } else {
                ThreadPool.m53398h().m55654b(new C2415b(2));
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public final void m51657e() {
        try {
            ThreadPool.m53398h().m55654b(new C2415b(3));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectionManager.java */
    /* renamed from: com.autonavi.aps.amapapi.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2415b extends ThreadTask {

        /* renamed from: b */
        private int f8051b;

        /* renamed from: c */
        private Location f8052c;

        C2415b(int i) {
            this.f8051b = i;
        }

        /* renamed from: a */
        private void m51652a() {
            try {
                DebugUtils.m51285a();
                if (this.f8052c != null && CollectionManager.this.f8047j) {
                    if (C2432j.m51154m(CollectionManager.this.f8038a)) {
                        DebugUtils.m51285a();
                        return;
                    }
                    Bundle extras = this.f8052c.getExtras();
                    int i = extras != null ? extras.getInt("satellites") : 0;
                    if (C2432j.m51201a(this.f8052c, i)) {
                        return;
                    }
                    WifiManagerWrapper wifiManagerWrapper = CollectionManager.this.f8039b;
                    if (wifiManagerWrapper != null && !wifiManagerWrapper.f8213s) {
                        wifiManagerWrapper.m51478f();
                    }
                    ArrayList<AmapWifi> m51492a = CollectionManager.this.f8039b.m51492a();
                    List<AmapCell> m51573a = CollectionManager.this.f8040c.m51573a();
                    FpsCollector.C1836a c1836a = new FpsCollector.C1836a();
                    AmapLocationGnss amapLocationGnss = new AmapLocationGnss();
                    amapLocationGnss.f4483i = this.f8052c.getAccuracy();
                    amapLocationGnss.f4480f = this.f8052c.getAltitude();
                    amapLocationGnss.f4478d = this.f8052c.getLatitude();
                    amapLocationGnss.f4482h = this.f8052c.getBearing();
                    amapLocationGnss.f4479e = this.f8052c.getLongitude();
                    amapLocationGnss.f4484j = this.f8052c.isFromMockProvider();
                    amapLocationGnss.f4475a = this.f8052c.getProvider();
                    amapLocationGnss.f4481g = this.f8052c.getSpeed();
                    amapLocationGnss.f4515l = (byte) i;
                    amapLocationGnss.f4476b = System.currentTimeMillis();
                    amapLocationGnss.f4477c = this.f8052c.getTime();
                    amapLocationGnss.f4514k = this.f8052c.getTime();
                    c1836a.f4465a = amapLocationGnss;
                    c1836a.f4466b = m51492a;
                    WifiInfo m51483c = CollectionManager.this.f8039b.m51483c();
                    if (m51483c != null) {
                        c1836a.f4467c = AmapWifi.m54648a(SystemApiWrapper.m51511a(m51483c));
                    }
                    c1836a.f4468d = WifiManagerWrapper.f8194z;
                    c1836a.f4470f = this.f8052c.getTime();
                    c1836a.f4471g = (byte) DeviceInfo.m54811K(CollectionManager.this.f8038a);
                    c1836a.f4472h = DeviceInfo.m54800V(CollectionManager.this.f8038a);
                    c1836a.f4469e = CollectionManager.this.f8039b.m51473k();
                    c1836a.f4474j = C2432j.m51204a(CollectionManager.this.f8038a);
                    c1836a.f4473i = m51573a;
                    CollectionData m55211a = OpenSdkCollectionManagerProxy.m55211a(c1836a);
                    if (m55211a == null) {
                        return;
                    }
                    synchronized (CollectionManager.this.f8043f) {
                        CollectionManager.this.f8043f.add(m55211a);
                        if (CollectionManager.this.f8043f.size() >= 5) {
                            CollectionManager.this.m51657e();
                        }
                    }
                    CollectionManager.this.m51658d();
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "cl", "coll");
            }
        }

        /* renamed from: b */
        private void m51651b() {
            DebugUtils.m51285a();
            if (!C2432j.m51154m(CollectionManager.this.f8038a)) {
                DiskLruCache diskLruCache = null;
                try {
                    long unused = CollectionManager.f8037k = System.currentTimeMillis();
                    if (CollectionManager.this.f8042e.f3559f.m53643e()) {
                        diskLruCache = DiskLruCache.m54503b(new File(CollectionManager.this.f8042e.f3554a), CollectionManager.this.f8042e.f3555b);
                        ArrayList arrayList = new ArrayList();
                        byte[] m51656f = CollectionManager.m51656f();
                        if (m51656f != null) {
                            List m51664b = CollectionManager.m51664b(diskLruCache, CollectionManager.this.f8042e, arrayList, m51656f);
                            if (m51664b != null && m51664b.size() != 0) {
                                CollectionManager.this.f8042e.f3559f.mo53644c(true);
                                if (OpenSdkCollectionManagerProxy.m55206f(C1925p4.m54184t(OpenSdkCollectionManagerProxy.m55204h(C2422a.m51454a(m51656f), Encrypt.m54717h(m51656f, OpenSdkCollectionManagerProxy.m55205g(), C1925p4.m54182v()), m51664b)))) {
                                    CollectionManager.m51663b(diskLruCache, arrayList);
                                }
                            }
                            try {
                                diskLruCache.close();
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        try {
                            diskLruCache.close();
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                    if (diskLruCache != null) {
                        try {
                            diskLruCache.close();
                            return;
                        } catch (Throwable unused4) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        SDKLogHandler.m53863p(th, "leg", "uts");
                        if (diskLruCache != null) {
                            try {
                                diskLruCache.close();
                                return;
                            } catch (Throwable unused5) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (diskLruCache != null) {
                            try {
                                diskLruCache.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        throw th2;
                    }
                }
            }
            DebugUtils.m51285a();
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            int i = this.f8051b;
            if (i == 1) {
                m51652a();
            } else if (i == 2) {
                m51651b();
            } else if (i == 3) {
                CollectionManager.this.m51655g();
            }
        }

        C2415b(CollectionManager collectionManager, Location location) {
            this(1);
            this.f8052c = location;
        }
    }

    /* renamed from: b */
    public final void m51666b() {
        try {
            DebugUtils.m51285a();
            Handler handler = this.f8044g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WifiManagerWrapper wifiManagerWrapper;
                        try {
                            CollectionManager collectionManager = CollectionManager.this;
                            if (collectionManager.f8041d == null || (wifiManagerWrapper = collectionManager.f8039b) == null) {
                                return;
                            }
                            OpenSdkCollectionManagerProxy.m55201k(wifiManagerWrapper.m51492a());
                        } catch (Throwable th) {
                            C2428b.m51299a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "cl", "upw");
        }
    }

    /* renamed from: c */
    public final void m51661c() {
        CgiManager cgiManager;
        try {
            DebugUtils.m51285a();
            if (this.f8041d == null || (cgiManager = this.f8040c) == null) {
                return;
            }
            OpenSdkCollectionManagerProxy.m55207e(cgiManager.m51573a());
        } catch (Throwable th) {
            C2428b.m51299a(th, "cl", "upc");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m51676a() {
        LocationManager locationManager;
        if (C2432j.m51154m(this.f8038a)) {
            DebugUtils.m51285a();
            return;
        }
        try {
            C2414a c2414a = this.f8046i;
            if (c2414a != null && (locationManager = this.f8045h) != null) {
                locationManager.removeUpdates(c2414a);
            }
            C2414a c2414a2 = this.f8046i;
            if (c2414a2 != null) {
                c2414a2.m51654a();
            }
            if (this.f8047j) {
                m51655g();
                this.f8039b.m51489a((CollectionManager) null);
                this.f8040c.m51564a((CollectionManager) null);
                this.f8040c = null;
                this.f8039b = null;
                this.f8044g = null;
                this.f8047j = false;
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m51663b(DiskLruCache diskLruCache, List<String> list) {
        if (diskLruCache != null) {
            try {
                for (String str : list) {
                    diskLruCache.m54488r(str);
                }
                diskLruCache.close();
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, C7304t.f25060p, "dlo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.amap.api.col.p0463l.CollectionData> m51664b(com.amap.api.col.p0463l.DiskLruCache r17, com.amap.api.col.p0463l.LogConfig r18, java.util.List<java.lang.String> r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.CollectionManager.m51664b(com.amap.api.col.3l.m6, com.amap.api.col.3l.a7, java.util.List, byte[]):java.util.List");
    }

    /* renamed from: a */
    public final void m51668a(CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, Handler handler) {
        LocationManager locationManager;
        DebugUtils.m51285a();
        if (this.f8047j || cgiManager == null || wifiManagerWrapper == null || handler == null) {
            return;
        }
        if (C2432j.m51154m(this.f8038a)) {
            DebugUtils.m51285a();
            return;
        }
        this.f8047j = true;
        this.f8040c = cgiManager;
        this.f8039b = wifiManagerWrapper;
        wifiManagerWrapper.m51489a(this);
        this.f8040c.m51564a(this);
        this.f8044g = handler;
        try {
            if (this.f8045h == null) {
                this.f8045h = (LocationManager) this.f8038a.getSystemService(SocializeConstants.KEY_LOCATION);
            }
            if (this.f8046i == null) {
                this.f8046i = new C2414a(this);
            }
            this.f8046i.m51653a(this);
            C2414a c2414a = this.f8046i;
            if (c2414a != null && (locationManager = this.f8045h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, c2414a);
            }
            if (this.f8041d == null) {
                OpenSdkCollectionManagerProxy openSdkCollectionManagerProxy = new OpenSdkCollectionManagerProxy("6.4.3", C1780e4.m55240j(this.f8038a), "S128DF1572465B890OE3F7A13167KLEI", C1780e4.m55243g(this.f8038a), this);
                this.f8041d = openSdkCollectionManagerProxy;
                openSdkCollectionManagerProxy.m55208d(DeviceInfo.m54806P()).m55203i(DeviceInfo.m54816F(this.f8038a)).m55200l(DeviceInfo.m54769o(this.f8038a)).m55199m(DeviceInfo.m54818D(this.f8038a)).m55198n(DeviceInfo.m54801U()).m55197o(DeviceInfo.m54817E()).m55196p(Build.MODEL).m55195q(Build.MANUFACTURER).m55194r(Build.BRAND).m55210b(Build.VERSION.SDK_INT).m55193s(Build.VERSION.RELEASE).m55209c(AmapWifi.m54648a(DeviceInfo.m54813I())).m55192t(DeviceInfo.m54813I());
                OpenSdkCollectionManagerProxy.m55202j();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "col", "init");
        }
    }

    /* renamed from: a */
    public final void m51673a(Location location) {
        try {
            Handler handler = this.f8044g;
            if (handler != null) {
                handler.post(new C2415b(this, location));
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0463l.INetwork
    /* renamed from: a */
    public final HttpResponse mo51670a(HttpRequest httpRequest) {
        try {
            C2426b c2426b = new C2426b();
            c2426b.m51389a(httpRequest.f4759b);
            c2426b.m51390a(httpRequest.f4758a);
            c2426b.m51388a(httpRequest.f4761d);
            BaseNetManager.m54175b();
            ResponseEntity m54173d = BaseNetManager.m54173d(c2426b);
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.f5084c = m54173d.f5682a;
            httpResponse.f5083b = m54173d.f5683b;
            httpResponse.f5082a = 200;
            return httpResponse;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m51675a(int i) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static int m51667a(byte[] bArr) {
        return ((bArr[0] & UByte.f41242c) << 24) | (bArr[3] & UByte.f41242c) | ((bArr[2] & UByte.f41242c) << 8) | ((bArr[1] & UByte.f41242c) << 16);
    }
}
