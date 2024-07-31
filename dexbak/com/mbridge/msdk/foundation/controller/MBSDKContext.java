package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.entity.InstallApp;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.InstallAppManager;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.controller.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBSDKContext {

    /* renamed from: a */
    public static final String f30250a = "a";

    /* renamed from: d */
    private static MBSDKContext f30253d;

    /* renamed from: e */
    private Context f30255e;

    /* renamed from: f */
    private String f30256f;

    /* renamed from: g */
    private String f30257g;

    /* renamed from: h */
    private String f30258h;

    /* renamed from: i */
    private String f30259i;

    /* renamed from: j */
    private int f30260j;

    /* renamed from: k */
    private WeakReference<Context> f30261k;

    /* renamed from: l */
    private WeakReference<Activity> f30262l;

    /* renamed from: n */
    private JSONObject f30264n;

    /* renamed from: o */
    private int f30265o;

    /* renamed from: s */
    private String f30268s;

    /* renamed from: b */
    public static HashMap<String, String> f30251b = new HashMap<>();

    /* renamed from: c */
    public static List<String> f30252c = new ArrayList();

    /* renamed from: r */
    private static CopyOnWriteArraySet<InstallApp> f30254r = new CopyOnWriteArraySet<>();

    /* renamed from: m */
    private int f30263m = 0;

    /* renamed from: p */
    private boolean f30266p = false;

    /* renamed from: q */
    private List<String> f30267q = null;

    /* compiled from: MBSDKContext.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11266b {
        /* renamed from: a */
        void mo22815a();
    }

    private MBSDKContext() {
    }

    /* renamed from: e */
    public static Set<InstallApp> m22867e() {
        return f30254r;
    }

    /* renamed from: f */
    public static MBSDKContext m22865f() {
        if (f30253d == null) {
            synchronized (MBSDKContext.class) {
                if (f30253d == null) {
                    f30253d = new MBSDKContext();
                }
            }
        }
        return f30253d;
    }

    /* renamed from: g */
    public static synchronized void m22864g() {
        Setting m23252b;
        synchronized (MBSDKContext.class) {
            try {
                if (!TextUtils.isEmpty(m22865f().m22860k()) && (m23252b = SettingManager.m23261a().m23252b(m22865f().m22860k())) != null) {
                    String m23361ak = m23252b.m23361ak();
                    if (!TextUtils.isEmpty(m23361ak)) {
                        String m21812b = SameBase64Tool.m21812b(m23361ak);
                        if (!TextUtils.isEmpty(m21812b)) {
                            JSONArray jSONArray = new JSONArray(m21812b);
                            if (jSONArray.length() > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                m22865f().f30267q = arrayList;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public final Context m22872c() {
        WeakReference<Context> weakReference = this.f30261k;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: d */
    public final String m22869d() {
        try {
            Context context = this.f30255e;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public final void m22863h() {
        try {
            CopyOnWriteArraySet<InstallApp> copyOnWriteArraySet = f30254r;
            if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
                return;
            }
            InstallAppManager.m21846a(this.f30255e).m21844a(f30254r);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public final List<Long> m22862i() {
        try {
            CopyOnWriteArraySet<InstallApp> copyOnWriteArraySet = f30254r;
            if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
                return null;
            }
            Iterator<InstallApp> it = f30254r.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                InstallApp next = it.next();
                if (!arrayList.contains(next.m22542a())) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(next.m22542a())));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: j */
    public final Context m22861j() {
        return this.f30255e;
    }

    /* renamed from: k */
    public final String m22860k() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f30257g)) {
            return this.f30257g;
        }
        Context context = this.f30255e;
        if (context != null) {
            return (String) C11400ae.m21961b(context, "sp_appId", "");
        }
        return "";
    }

    /* renamed from: l */
    public final String m22859l() {
        if (!TextUtils.isEmpty(this.f30258h)) {
            return this.f30258h;
        }
        Context context = this.f30255e;
        if (context != null) {
            return (String) C11400ae.m21961b(context, "sp_appKey", "");
        }
        return null;
    }

    /* renamed from: m */
    public final String m22858m() {
        if (!TextUtils.isEmpty(this.f30259i)) {
            return this.f30259i;
        }
        Context context = this.f30255e;
        if (context != null) {
            return (String) C11400ae.m21961b(context, "sp_wx_appKey", "");
        }
        return null;
    }

    /* renamed from: n */
    public final int m22857n() {
        return this.f30263m;
    }

    /* renamed from: o */
    public final JSONObject m22856o() {
        return this.f30264n;
    }

    /* renamed from: a */
    public final WeakReference<Activity> m22888a() {
        return this.f30262l;
    }

    /* renamed from: b */
    public final int m22877b() {
        return this.f30260j;
    }

    /* renamed from: c */
    public final void m22870c(String str) {
        Context context;
        try {
            this.f30257g = str;
            if (TextUtils.isEmpty(str) || (context = this.f30255e) == null) {
                return;
            }
            C11400ae.m21963a(context, "sp_appId", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public final void m22866e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f30259i = str;
            Context context = this.f30255e;
            if (context != null) {
                C11400ae.m21963a(context, "sp_wx_appKey", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m22880a(WeakReference<Activity> weakReference) {
        this.f30262l = weakReference;
    }

    /* renamed from: b */
    public final void m22876b(int i) {
        this.f30265o = i;
    }

    /* renamed from: a */
    public final void m22887a(int i) {
        this.f30260j = i;
    }

    /* renamed from: b */
    public final void m22875b(Context context) {
        this.f30255e = context;
    }

    /* renamed from: d */
    public final void m22868d(String str) {
        Context context;
        try {
            this.f30258h = str;
            if (TextUtils.isEmpty(str) || (context = this.f30255e) == null) {
                return;
            }
            C11400ae.m21963a(context, "sp_appKey", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m22886a(Context context) {
        this.f30261k = new WeakReference<>(context);
    }

    /* renamed from: b */
    public final void m22873b(String str) {
        this.f30256f = str;
    }

    /* renamed from: a */
    public final void m22881a(String str) {
        Context context;
        try {
            this.f30268s = str;
            if (TextUtils.isEmpty(str) || (context = this.f30255e) == null) {
                return;
            }
            C11400ae.m21963a(context, "applicationIds", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m22871c(int i) {
        this.f30263m = i;
    }

    /* renamed from: a */
    public final void m22884a(final InterfaceC11266b interfaceC11266b, final Handler handler) {
        if (this.f30266p) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.f30264n = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Object m21961b = C11400ae.m21961b(this.f30255e, "ga_id", "-1");
            if (m21961b != null && (m21961b instanceof String)) {
                String str = (String) m21961b;
                if (StringUtils.m21956b(str) && !"-1".equals(str)) {
                    String str2 = f30250a;
                    SameLogTool.m21736b(str2, "sp init gaid:" + str);
                    if (SDKAuthorityController.m22828g() && SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        SameDiTool.m21778h(str);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    if (SDKAuthorityController.m22828g()) {
                        try {
                            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(MBSDKContext.this.f30255e);
                            SameDiTool.m21778h(advertisingIdInfo.getId());
                            MBSDKContext.m22882a(MBSDKContext.this, advertisingIdInfo.getId());
                        } catch (Exception unused) {
                            SameLogTool.m21734c(MBSDKContext.f30250a, "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                            try {
                                C11262a.C11263a m22855a = new C11262a().m22855a(MBSDKContext.this.f30255e);
                                SameDiTool.m21778h(m22855a.m22854a());
                                MBSDKContext.m22882a(MBSDKContext.this, m22855a.m22854a());
                            } catch (Exception unused2) {
                                SameLogTool.m21734c(MBSDKContext.f30250a, "GET ADID FROM GOOGLE PLAY APP ERROR");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    try {
                        SameDiTool.m21782b(MBSDKContext.this.f30255e.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused3) {
                        SameDiTool.m21782b(0);
                    } catch (Throwable th2) {
                        SameLogTool.m21733d(MBSDKContext.f30250a, th2.getMessage());
                    }
                }
                try {
                    Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                    if (m23252b == null) {
                        m23252b = SettingManager.m23261a().m23253b();
                    }
                    Message obtain = Message.obtain();
                    obtain.obj = m23252b;
                    obtain.what = 9;
                    handler.sendMessage(obtain);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    SameDiTool.m21775q(MBSDKContext.this.f30255e);
                    MBSDKContext.m22864g();
                    SettingManager.m23260a(MBSDKContext.this.f30255e, MBSDKContext.this.f30257g);
                    MBSDKContext.this.m22878a(false);
                    MBSDKContext.this.m22885a(interfaceC11266b);
                } catch (Exception unused4) {
                }
            }
        }).start();
    }

    /* compiled from: MBSDKContext.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C11262a {

        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public final class C11263a {

            /* renamed from: b */
            private final String f30274b;

            /* renamed from: c */
            private final boolean f30275c;

            C11263a(String str, boolean z) {
                this.f30274b = str;
                this.f30275c = z;
            }

            /* renamed from: a */
            public final String m22854a() {
                return this.f30274b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$b */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public final class ServiceConnectionC11264b implements ServiceConnection {

            /* renamed from: a */
            boolean f30276a;

            /* renamed from: c */
            private final LinkedBlockingQueue<IBinder> f30278c;

            private ServiceConnectionC11264b() {
                this.f30276a = false;
                this.f30278c = new LinkedBlockingQueue<>(1);
            }

            /* renamed from: a */
            public final IBinder m22853a() throws InterruptedException {
                if (!this.f30276a) {
                    this.f30276a = true;
                    return this.f30278c.take();
                }
                throw new IllegalStateException();
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.f30278c.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
            }
        }

        public C11262a() {
        }

        /* renamed from: a */
        public final C11263a m22855a(Context context) throws Exception {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    ServiceConnectionC11264b serviceConnectionC11264b = new ServiceConnectionC11264b();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (context.bindService(intent, serviceConnectionC11264b, 1)) {
                        try {
                            try {
                                C11265c c11265c = new C11265c(serviceConnectionC11264b.m22853a());
                                return new C11263a(c11265c.m22852a(), c11265c.m22851a(true));
                            } catch (Exception e) {
                                throw e;
                            }
                        } finally {
                            context.unbindService(serviceConnectionC11264b);
                        }
                    }
                    throw new IOException("Google Play connection failed");
                } catch (Exception e2) {
                    throw e2;
                }
            }
            throw new IllegalStateException("Cannot be called from the main thread");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$c */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public final class C11265c implements IInterface {

            /* renamed from: b */
            private IBinder f30280b;

            public C11265c(IBinder iBinder) {
                this.f30280b = iBinder;
            }

            /* renamed from: a */
            public final String m22852a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f30280b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f30280b;
            }

            /* renamed from: a */
            public final boolean m22851a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z2 = false;
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f30280b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                } finally {
                    try {
                        return z2;
                    } finally {
                    }
                }
                return z2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
        r8.mo22815a();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m22885a(com.mbridge.msdk.foundation.controller.MBSDKContext.InterfaceC11266b r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.content.Context r0 = r7.f30255e     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.tools.l r0 = com.mbridge.msdk.foundation.tools.InstallAppManager.m21846a(r0)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r7.f30257g     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet r0 = r0.m21845a(r1)     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.controller.MBSDKContext.f30254r = r0     // Catch: java.lang.Throwable -> La1
            if (r0 == 0) goto L9a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> La1
            if (r0 != 0) goto L19
            goto L9a
        L19:
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet     // Catch: java.lang.Throwable -> La1
            r0.<init>()     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30254r     // Catch: java.lang.Throwable -> La1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L77
        L26:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L77
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.entity.i r2 = (com.mbridge.msdk.foundation.entity.InstallApp) r2     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.util.List<java.lang.String> r3 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30252c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 == 0) goto L26
            int r3 = r3.size()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 <= 0) goto L26
            if (r2 == 0) goto L26
            r3 = 0
        L3f:
            java.util.List<java.lang.String> r4 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30252c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            int r4 = r4.size()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 >= r4) goto L26
            java.util.List<java.lang.String> r4 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30252c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.String r5 = r2.m22539b()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r6 != 0) goto L68
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r6 != 0) goto L68
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r4 == 0) goto L68
            r0.add(r2)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
        L68:
            int r3 = r3 + 1
            goto L3f
        L6b:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30250a     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "remove list error"
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r2, r3)     // Catch: java.lang.Throwable -> La1
            goto L26
        L77:
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30254r     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L7e
            r1.clear()     // Catch: java.lang.Throwable -> La1
        L7e:
            int r1 = r0.size()     // Catch: java.lang.Throwable -> La1
            if (r1 <= 0) goto L89
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30254r     // Catch: java.lang.Throwable -> La1
            r1.addAll(r0)     // Catch: java.lang.Throwable -> La1
        L89:
            android.content.Context r0 = r7.f30255e     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.tools.l r0 = com.mbridge.msdk.foundation.tools.InstallAppManager.m21846a(r0)     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.f30254r     // Catch: java.lang.Throwable -> La1
            r0.m21844a(r1)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto La1
            r8.mo22815a()     // Catch: java.lang.Throwable -> La1
            goto La1
        L9a:
            if (r8 == 0) goto L9f
            r8.mo22815a()     // Catch: java.lang.Throwable -> La1
        L9f:
            monitor-exit(r7)
            return
        La1:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.MBSDKContext.m22885a(com.mbridge.msdk.foundation.controller.a$b):void");
    }

    /* renamed from: a */
    public final List<String> m22878a(boolean z) {
        try {
            List<String> list = m22865f().f30267q;
            if (z) {
                return f30252c;
            }
            List<String> list2 = f30252c;
            if (list2 != null && list2.size() > 0) {
                return f30252c;
            }
            return f30252c;
        } catch (Exception unused) {
            SameLogTool.m21733d(f30250a, "get package info list error");
            return null;
        }
    }

    /* renamed from: a */
    public final void m22879a(JSONObject jSONObject) {
        this.f30264n = jSONObject;
    }

    /* renamed from: a */
    static /* synthetic */ void m22882a(MBSDKContext mBSDKContext, String str) {
        try {
            if (StringUtils.m21956b(str)) {
                String str2 = f30250a;
                SameLogTool.m21736b(str2, "saveGAID gaid:" + str);
                C11400ae.m21963a(mBSDKContext.f30255e, "ga_id", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
