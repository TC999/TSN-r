package com.kwad.sdk.core.webview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a aEh;
    private long YZ;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.h.a.b> aEi = new CopyOnWriteArrayList();
    private final List<String> aEj = new CopyOnWriteArrayList();
    private final List<String> aEk = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aEl = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.GX();
            }
        }
    };

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.aEi) {
            bp(this.mContext);
            for (com.kwad.sdk.h.a.b bVar : this.aEi) {
                if (list.contains(bVar)) {
                    if (q.gt(com.kwad.sdk.core.webview.b.c.a.I(this.mContext, bVar.aHY))) {
                        list.remove(bVar);
                    }
                } else {
                    q.aa(new File(bVar.aHZ));
                    this.aEi.remove(bVar);
                }
            }
            bo(this.mContext);
        }
    }

    public static a GV() {
        if (aEh == null) {
            synchronized (a.class) {
                if (aEh == null) {
                    aEh = new a();
                }
            }
        }
        return aEh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.h.a.b> GY() {
        List<com.kwad.sdk.h.a.a> list;
        SdkConfigData Ca = d.Ca();
        if (Ca == null || (list = Ca.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            for (com.kwad.sdk.h.a.b bVar : aVar.aHW) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private WebResourceResponse ab(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aEj.add(str);
            WebResourceResponse a4 = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a4 != null) {
                c.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", currentTimeMillis2);
            } else {
                c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, currentTimeMillis2);
            }
            return a4;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient\u4e2d Exception " + Log.getStackTraceString(th), currentTimeMillis3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x005c, TryCatch #4 {, blocks: (B:7:0x001e, B:16:0x0033, B:17:0x003e, B:19:0x0044, B:21:0x004e, B:22:0x0056, B:24:0x0058, B:25:0x005b, B:15:0x0030), top: B:35:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bo(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aEi
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.bs(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.aEi     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            org.json.JSONArray r2 = com.kwad.sdk.utils.t.O(r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r3.write(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L5c
            goto L33
        L22:
            r5 = move-exception
            r1 = r3
            goto L58
        L25:
            r1 = r3
            goto L29
        L27:
            r5 = move-exception
            goto L58
        L29:
            java.lang.String r5 = "updatePackageIndexFile"
            java.lang.String r2 = "read packageIndex file error"
            com.kwad.sdk.core.e.c.e(r5, r2)     // Catch: java.lang.Throwable -> L27
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
        L33:
            java.util.List<java.lang.String> r5 = r4.aEj     // Catch: java.lang.Throwable -> L5c
            r5.clear()     // Catch: java.lang.Throwable -> L5c
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aEi     // Catch: java.lang.Throwable -> L5c
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5c
        L3e:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L56
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L5c
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L5c
            boolean r2 = r1.aIb     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L3e
            java.util.List<java.lang.String> r2 = r4.aEj     // Catch: java.lang.Throwable -> L5c
            java.lang.String r1 = r1.aHX     // Catch: java.lang.Throwable -> L5c
            r2.add(r1)     // Catch: java.lang.Throwable -> L5c
            goto L3e
        L56:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            return
        L58:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
            throw r5     // Catch: java.lang.Throwable -> L5c
        L5c:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5f:
            throw r5
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.bo(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:43:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:43:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bp(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aEi
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.bs(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            boolean r2 = com.kwad.sdk.utils.q.L(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r2 == 0) goto L29
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r5.<init>(r2)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.lang.String r5 = com.kwad.sdk.crash.utils.h.b(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            com.kwad.sdk.core.webview.b.a$6 r3 = new com.kwad.sdk.core.webview.b.a$6     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r3.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.util.List r5 = a(r5, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r1 = r2
            goto L2a
        L27:
            r5 = move-exception
            goto L33
        L29:
            r5 = r1
        L2a:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            r1 = r5
            goto L39
        L2f:
            r5 = move-exception
            goto L7f
        L31:
            r5 = move-exception
            r2 = r1
        L33:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L7d
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L83
        L39:
            if (r1 == 0) goto L45
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aEi     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aEi     // Catch: java.lang.Throwable -> L83
            r5.addAll(r1)     // Catch: java.lang.Throwable -> L83
        L45:
            java.util.List<java.lang.String> r5 = r4.aEj     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aEi     // Catch: java.lang.Throwable -> L83
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L83
        L50:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L7b
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L83
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L83
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r1.aHY     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = com.kwad.sdk.core.webview.b.c.a.I(r2, r3)     // Catch: java.lang.Throwable -> L83
            boolean r2 = com.kwad.sdk.utils.q.gt(r2)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L6f
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.aEi     // Catch: java.lang.Throwable -> L83
            r2.remove(r1)     // Catch: java.lang.Throwable -> L83
        L6f:
            boolean r2 = r1.aIb     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L50
            java.util.List<java.lang.String> r2 = r4.aEj     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.aHX     // Catch: java.lang.Throwable -> L83
            r2.add(r1)     // Catch: java.lang.Throwable -> L83
            goto L50
        L7b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            return
        L7d:
            r5 = move-exception
            r1 = r2
        L7f:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            throw r5     // Catch: java.lang.Throwable -> L83
        L83:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            goto L87
        L86:
            throw r5
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.bp(android.content.Context):void");
    }

    private WebResourceResponse eM(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aEi) {
                for (String str2 : this.aEj) {
                    WebResourceResponse a4 = a(str2, str, aVar, true);
                    if (a4 != null) {
                        return a4;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.h.a.b eN(String str) {
        List<com.kwad.sdk.h.a.b> GY = GY();
        if (GY != null && !GY.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : GY) {
                if (bg.isEquals(str, bVar.aHX)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.h.a.b eO(String str) {
        synchronized (this.aEi) {
            if (!TextUtils.isEmpty(str) && this.aEi.size() > 0) {
                for (com.kwad.sdk.h.a.b bVar : this.aEi) {
                    if (TextUtils.equals(str, bVar.aHX)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    public final long GW() {
        return this.YZ;
    }

    public final void GX() {
        if (d.Cj()) {
            g.execute(new ay() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    int i4;
                    try {
                        List<com.kwad.sdk.h.a.b> GY = a.this.GY();
                        if (GY != null && !GY.isEmpty()) {
                            a.this.D(GY);
                            for (com.kwad.sdk.h.a.b bVar : GY) {
                                if (bVar.packageType == 1 && ((i4 = bVar.loadType) == 1 || (i4 == 2 && ag.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((e) ServiceProvider.get(e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    @Nullable
    public final WebResourceResponse aa(String str, String str2) {
        if (this.mHasInit) {
            String eR = com.kwad.sdk.core.webview.b.c.a.eR(str);
            if (!TextUtils.isEmpty(eR)) {
                com.kwad.sdk.core.webview.b.c.b.c(str2, eR, str);
                WebResourceResponse ab = ab(eR, str);
                com.kwad.sdk.core.webview.b.c.b.d(str2, eR, str);
                return ab;
            }
            return eM(str);
        }
        return null;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.KO();
            this.mHasInit = true;
            g.execute(new ay() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    try {
                        if (d.b(com.kwad.sdk.core.config.c.arU)) {
                            a.this.YZ = System.currentTimeMillis();
                            a.this.bp(context);
                            a.this.GX();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aEl);
                        }
                    } catch (Throwable th) {
                        ((e) ServiceProvider.get(e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    private void b(@NonNull final com.kwad.sdk.h.a.b bVar) {
        g.execute(new ay() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.h.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.h.a.b bVar) {
        if (this.aEk.contains(bVar.aHX) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0703a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0703a
            public final void c(com.kwad.sdk.h.a.b bVar2) {
                a.this.aEk.add(bVar2.aHX);
                c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0703a
            public final void d(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.aEi.add(bVar2);
                    a aVar = a.this;
                    aVar.bo(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.aEk.remove(bVar2.aHX);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0703a
            public final void e(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aEk.remove(bVar2.aHX);
            }
        });
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z3) {
        com.kwad.sdk.h.a.b eO = eO(str);
        if (eO == null) {
            com.kwad.sdk.h.a.b eN = eN(str);
            if (eN == null) {
                aVar.msg = "\u914d\u7f6e\u6587\u4ef6\u6ca1\u6709\u4e0b\u53d1\u8be5zip\u8d44\u6e90";
                return null;
            }
            aVar.msg = "\u8d44\u6e90\u672a\u4e0b\u8f7d:" + eN.loadType;
            b(eN);
            return null;
        }
        return b.a(this.mContext, str2, eO, aVar, z3);
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.aHX = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String eS = com.kwad.sdk.core.webview.b.c.a.eS(bVar.packageUrl);
        if (TextUtils.isEmpty(eS)) {
            return;
        }
        bVar.aHY = eS;
        bVar.aHZ = com.kwad.sdk.core.webview.b.c.a.G(this.mContext, eS);
    }

    @Deprecated
    private static List<com.kwad.sdk.h.a.b> a(String str, @NonNull com.kwad.sdk.core.c<com.kwad.sdk.h.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                com.kwad.sdk.h.a.b AW = cVar.AW();
                AW.parseJson(jSONObject);
                arrayList.add(AW);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
