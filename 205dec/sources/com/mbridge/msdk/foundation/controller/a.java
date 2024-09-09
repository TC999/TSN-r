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
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
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

/* compiled from: MBSDKContext.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39077a = "a";

    /* renamed from: d  reason: collision with root package name */
    private static a f39080d;

    /* renamed from: e  reason: collision with root package name */
    private Context f39082e;

    /* renamed from: f  reason: collision with root package name */
    private String f39083f;

    /* renamed from: g  reason: collision with root package name */
    private String f39084g;

    /* renamed from: h  reason: collision with root package name */
    private String f39085h;

    /* renamed from: i  reason: collision with root package name */
    private String f39086i;

    /* renamed from: j  reason: collision with root package name */
    private int f39087j;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<Context> f39088k;

    /* renamed from: l  reason: collision with root package name */
    private WeakReference<Activity> f39089l;

    /* renamed from: n  reason: collision with root package name */
    private JSONObject f39091n;

    /* renamed from: o  reason: collision with root package name */
    private int f39092o;

    /* renamed from: s  reason: collision with root package name */
    private String f39095s;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f39078b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f39079c = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private static CopyOnWriteArraySet<i> f39081r = new CopyOnWriteArraySet<>();

    /* renamed from: m  reason: collision with root package name */
    private int f39090m = 0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f39093p = false;

    /* renamed from: q  reason: collision with root package name */
    private List<String> f39094q = null;

    /* compiled from: MBSDKContext.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void a();
    }

    private a() {
    }

    public static Set<i> e() {
        return f39081r;
    }

    public static a f() {
        if (f39080d == null) {
            synchronized (a.class) {
                if (f39080d == null) {
                    f39080d = new a();
                }
            }
        }
        return f39080d;
    }

    public static synchronized void g() {
        com.mbridge.msdk.c.a b4;
        synchronized (a.class) {
            try {
                if (!TextUtils.isEmpty(f().k()) && (b4 = com.mbridge.msdk.c.b.a().b(f().k())) != null) {
                    String ak = b4.ak();
                    if (!TextUtils.isEmpty(ak)) {
                        String b5 = s.b(ak);
                        if (!TextUtils.isEmpty(b5)) {
                            JSONArray jSONArray = new JSONArray(b5);
                            if (jSONArray.length() > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                    arrayList.add(jSONArray.optString(i4));
                                }
                                f().f39094q = arrayList;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final Context c() {
        WeakReference<Context> weakReference = this.f39088k;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final String d() {
        try {
            Context context = this.f39082e;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void h() {
        try {
            CopyOnWriteArraySet<i> copyOnWriteArraySet = f39081r;
            if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
                return;
            }
            l.a(this.f39082e).a(f39081r);
        } catch (Throwable unused) {
        }
    }

    public final List<Long> i() {
        try {
            CopyOnWriteArraySet<i> copyOnWriteArraySet = f39081r;
            if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
                return null;
            }
            Iterator<i> it = f39081r.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                i next = it.next();
                if (!arrayList.contains(next.a())) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(next.a())));
                    } catch (NumberFormatException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context j() {
        return this.f39082e;
    }

    public final String k() {
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f39084g)) {
            return this.f39084g;
        }
        Context context = this.f39082e;
        if (context != null) {
            return (String) ae.b(context, "sp_appId", "");
        }
        return "";
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f39085h)) {
            return this.f39085h;
        }
        Context context = this.f39082e;
        if (context != null) {
            return (String) ae.b(context, "sp_appKey", "");
        }
        return null;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.f39086i)) {
            return this.f39086i;
        }
        Context context = this.f39082e;
        if (context != null) {
            return (String) ae.b(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final int n() {
        return this.f39090m;
    }

    public final JSONObject o() {
        return this.f39091n;
    }

    public final WeakReference<Activity> a() {
        return this.f39089l;
    }

    public final int b() {
        return this.f39087j;
    }

    public final void c(String str) {
        Context context;
        try {
            this.f39084g = str;
            if (TextUtils.isEmpty(str) || (context = this.f39082e) == null) {
                return;
            }
            ae.a(context, "sp_appId", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f39086i = str;
            Context context = this.f39082e;
            if (context != null) {
                ae.a(context, "sp_wx_appKey", str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.f39089l = weakReference;
    }

    public final void b(int i4) {
        this.f39092o = i4;
    }

    public final void a(int i4) {
        this.f39087j = i4;
    }

    public final void b(Context context) {
        this.f39082e = context;
    }

    public final void d(String str) {
        Context context;
        try {
            this.f39085h = str;
            if (TextUtils.isEmpty(str) || (context = this.f39082e) == null) {
                return;
            }
            ae.a(context, "sp_appKey", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(Context context) {
        this.f39088k = new WeakReference<>(context);
    }

    public final void b(String str) {
        this.f39083f = str;
    }

    public final void a(String str) {
        Context context;
        try {
            this.f39095s = str;
            if (TextUtils.isEmpty(str) || (context = this.f39082e) == null) {
                return;
            }
            ae.a(context, "applicationIds", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void c(int i4) {
        this.f39090m = i4;
    }

    public final void a(final b bVar, final Handler handler) {
        if (this.f39093p) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.f39091n = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            Object b4 = ae.b(this.f39082e, "ga_id", "-1");
            if (b4 != null && (b4 instanceof String)) {
                String str = (String) b4;
                if (ag.b(str) && !"-1".equals(str)) {
                    String str2 = f39077a;
                    x.b(str2, "sp init gaid:" + str);
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        t.h(str);
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                        try {
                            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.f39082e);
                            t.h(advertisingIdInfo.getId());
                            a.a(a.this, advertisingIdInfo.getId());
                        } catch (Exception unused) {
                            x.c(a.f39077a, "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                            try {
                                C0737a.C0738a a4 = new C0737a().a(a.this.f39082e);
                                t.h(a4.a());
                                a.a(a.this, a4.a());
                            } catch (Exception unused2) {
                                x.c(a.f39077a, "GET ADID FROM GOOGLE PLAY APP ERROR");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    try {
                        t.b(a.this.f39082e.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused3) {
                        t.b(0);
                    } catch (Throwable th2) {
                        x.d(a.f39077a, th2.getMessage());
                    }
                }
                try {
                    com.mbridge.msdk.c.a b5 = com.mbridge.msdk.c.b.a().b(a.f().k());
                    if (b5 == null) {
                        b5 = com.mbridge.msdk.c.b.a().b();
                    }
                    Message obtain = Message.obtain();
                    obtain.obj = b5;
                    obtain.what = 9;
                    handler.sendMessage(obtain);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                try {
                    t.q(a.this.f39082e);
                    a.g();
                    com.mbridge.msdk.c.b.a(a.this.f39082e, a.this.f39084g);
                    a.this.a(false);
                    a.this.a(bVar);
                } catch (Exception unused4) {
                }
            }
        }).start();
    }

    /* compiled from: MBSDKContext.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class C0737a {

        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public final class C0738a {

            /* renamed from: b  reason: collision with root package name */
            private final String f39101b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f39102c;

            C0738a(String str, boolean z3) {
                this.f39101b = str;
                this.f39102c = z3;
            }

            public final String a() {
                return this.f39101b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$b */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public final class b implements ServiceConnection {

            /* renamed from: a  reason: collision with root package name */
            boolean f39103a;

            /* renamed from: c  reason: collision with root package name */
            private final LinkedBlockingQueue<IBinder> f39105c;

            private b() {
                this.f39103a = false;
                this.f39105c = new LinkedBlockingQueue<>(1);
            }

            public final IBinder a() throws InterruptedException {
                if (!this.f39103a) {
                    this.f39103a = true;
                    return this.f39105c.take();
                }
                throw new IllegalStateException();
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.f39105c.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
            }
        }

        public C0737a() {
        }

        public final C0738a a(Context context) throws Exception {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    b bVar = new b();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (context.bindService(intent, bVar, 1)) {
                        try {
                            try {
                                c cVar = new c(bVar.a());
                                return new C0738a(cVar.a(), cVar.a(true));
                            } catch (Exception e4) {
                                throw e4;
                            }
                        } finally {
                            context.unbindService(bVar);
                        }
                    }
                    throw new IOException("Google Play connection failed");
                } catch (Exception e5) {
                    throw e5;
                }
            }
            throw new IllegalStateException("Cannot be called from the main thread");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MBSDKContext.java */
        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$c */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public final class c implements IInterface {

            /* renamed from: b  reason: collision with root package name */
            private IBinder f39107b;

            public c(IBinder iBinder) {
                this.f39107b = iBinder;
            }

            public final String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f39107b.transact(1, obtain, obtain2, 0);
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
                return this.f39107b;
            }

            public final boolean a(boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z4 = false;
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z3 ? 1 : 0);
                    this.f39107b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                } finally {
                    try {
                        return z4;
                    } finally {
                    }
                }
                return z4;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
        r8.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(com.mbridge.msdk.foundation.controller.a.b r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.content.Context r0 = r7.f39082e     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.tools.l r0 = com.mbridge.msdk.foundation.tools.l.a(r0)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r7.f39084g     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet r0 = r0.a(r1)     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.controller.a.f39081r = r0     // Catch: java.lang.Throwable -> La1
            if (r0 == 0) goto L9a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> La1
            if (r0 != 0) goto L19
            goto L9a
        L19:
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet     // Catch: java.lang.Throwable -> La1
            r0.<init>()     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.a.f39081r     // Catch: java.lang.Throwable -> La1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L77
        L26:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto L77
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.entity.i r2 = (com.mbridge.msdk.foundation.entity.i) r2     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.util.List<java.lang.String> r3 = com.mbridge.msdk.foundation.controller.a.f39079c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 == 0) goto L26
            int r3 = r3.size()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 <= 0) goto L26
            if (r2 == 0) goto L26
            r3 = 0
        L3f:
            java.util.List<java.lang.String> r4 = com.mbridge.msdk.foundation.controller.a.f39079c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            int r4 = r4.size()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            if (r3 >= r4) goto L26
            java.util.List<java.lang.String> r4 = com.mbridge.msdk.foundation.controller.a.f39079c     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
            java.lang.String r5 = r2.b()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> La1
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
            java.lang.String r2 = com.mbridge.msdk.foundation.controller.a.f39077a     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "remove list error"
            com.mbridge.msdk.foundation.tools.x.d(r2, r3)     // Catch: java.lang.Throwable -> La1
            goto L26
        L77:
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.a.f39081r     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L7e
            r1.clear()     // Catch: java.lang.Throwable -> La1
        L7e:
            int r1 = r0.size()     // Catch: java.lang.Throwable -> La1
            if (r1 <= 0) goto L89
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.a.f39081r     // Catch: java.lang.Throwable -> La1
            r1.addAll(r0)     // Catch: java.lang.Throwable -> La1
        L89:
            android.content.Context r0 = r7.f39082e     // Catch: java.lang.Throwable -> La1
            com.mbridge.msdk.foundation.tools.l r0 = com.mbridge.msdk.foundation.tools.l.a(r0)     // Catch: java.lang.Throwable -> La1
            java.util.concurrent.CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> r1 = com.mbridge.msdk.foundation.controller.a.f39081r     // Catch: java.lang.Throwable -> La1
            r0.a(r1)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto La1
            r8.a()     // Catch: java.lang.Throwable -> La1
            goto La1
        L9a:
            if (r8 == 0) goto L9f
            r8.a()     // Catch: java.lang.Throwable -> La1
        L9f:
            monitor-exit(r7)
            return
        La1:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.a.a(com.mbridge.msdk.foundation.controller.a$b):void");
    }

    public final List<String> a(boolean z3) {
        try {
            List<String> list = f().f39094q;
            if (z3) {
                return f39079c;
            }
            List<String> list2 = f39079c;
            if (list2 != null && list2.size() > 0) {
                return f39079c;
            }
            return f39079c;
        } catch (Exception unused) {
            x.d(f39077a, "get package info list error");
            return null;
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f39091n = jSONObject;
    }

    static /* synthetic */ void a(a aVar, String str) {
        try {
            if (ag.b(str)) {
                String str2 = f39077a;
                x.b(str2, "saveGAID gaid:" + str);
                ae.a(aVar.f39082e, "ga_id", str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
