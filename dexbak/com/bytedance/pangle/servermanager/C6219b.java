package com.bytedance.pangle.servermanager;

import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.InterfaceC6069c;
import com.bytedance.pangle.InterfaceC6091e;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.pangle.servermanager.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6219b {

    /* renamed from: a */
    private static final Object f22175a = new Object();

    /* renamed from: b */
    private static final Object f22176b = new Object();

    /* renamed from: c */
    private static final Object f22177c = new Object();

    /* renamed from: d */
    private static final Map<String, Boolean> f22178d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final Map<String, InterfaceC6091e> f22179e = new ConcurrentHashMap();

    /* renamed from: f */
    private static InterfaceC6069c f22180f;

    /* renamed from: a */
    public static InterfaceC6091e m36963a(String str) {
        Boolean bool = f22178d.get(str);
        if (bool == null || !bool.booleanValue()) {
            f22179e.remove(str);
        }
        Map<String, InterfaceC6091e> map = f22179e;
        if (map.get(str) == null) {
            synchronized (f22176b) {
                InterfaceC6091e interfaceC6091e = (InterfaceC6091e) m36962a(NotificationCompat.CATEGORY_SERVICE, str);
                if (interfaceC6091e == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, interfaceC6091e);
            }
        }
        return map.get(str);
    }

    /* renamed from: a */
    public static InterfaceC6069c m36964a() {
        Boolean bool = f22178d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f22180f = null;
        }
        if (f22180f == null) {
            synchronized (f22177c) {
                InterfaceC6069c interfaceC6069c = (InterfaceC6069c) m36962a("package", "main");
                if (interfaceC6069c == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f22180f = interfaceC6069c;
            }
        }
        return f22180f;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: RemoteException -> 0x009a, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:15:0x0056, B:30:0x0090, B:32:0x0095, B:20:0x0077, B:23:0x0081), top: B:41:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095 A[Catch: RemoteException -> 0x009a, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:15:0x0056, B:30:0x0090, B:32:0x0095, B:20:0x0077, B:23:0x0081), top: B:41:0x0056 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface m36962a(java.lang.String r6, final java.lang.String r7) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto Lb3
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r7)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto La3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r2 = "query_binder"
            r3 = 0
            android.os.Bundle r0 = r1.call(r0, r2, r6, r3)
            if (r0 == 0) goto L4d
            java.lang.Class<com.bytedance.pangle.servermanager.AbsServerManager> r1 = com.bytedance.pangle.servermanager.AbsServerManager.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            java.lang.String r1 = "binder"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.bytedance.pangle.servermanager.a r0 = (com.bytedance.pangle.servermanager.C6217a) r0
            if (r0 == 0) goto L4d
            android.os.IBinder r0 = r0.f22174a
            goto L4e
        L4d:
            r0 = r3
        L4e:
            if (r0 == 0) goto La2
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto La2
            com.bytedance.pangle.servermanager.b$1 r1 = new com.bytedance.pangle.servermanager.b$1     // Catch: android.os.RemoteException -> L9a
            r1.<init>()     // Catch: android.os.RemoteException -> L9a
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L9a
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.C6219b.f22178d     // Catch: android.os.RemoteException -> L9a
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L9a
            r1.put(r7, r4)     // Catch: android.os.RemoteException -> L9a
            r7 = -1
            int r1 = r6.hashCode()     // Catch: android.os.RemoteException -> L9a
            r4 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r5 = 1
            if (r1 == r4) goto L81
            r2 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r1 == r2) goto L77
            goto L8a
        L77:
            java.lang.String r1 = "service"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L9a
            if (r6 == 0) goto L8a
            r2 = 1
            goto L8b
        L81:
            java.lang.String r1 = "package"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L9a
            if (r6 == 0) goto L8a
            goto L8b
        L8a:
            r2 = -1
        L8b:
            if (r2 == 0) goto L95
            if (r2 == r5) goto L90
            goto La2
        L90:
            com.bytedance.pangle.e r6 = com.bytedance.pangle.InterfaceC6091e.AbstractBinderC6092a.m37202a(r0)     // Catch: android.os.RemoteException -> L9a
            return r6
        L95:
            com.bytedance.pangle.c r6 = com.bytedance.pangle.InterfaceC6069c.AbstractBinderC6070a.m37255a(r0)     // Catch: android.os.RemoteException -> L9a
            return r6
        L9a:
            r6 = move-exception
            java.lang.String r7 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r7, r0, r6)
        La2:
            return r3
        La3:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        Lb3:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.C6219b.m36962a(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
