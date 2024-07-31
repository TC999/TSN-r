package com.kwad.sdk.core.webview.p418b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.p418b.p420b.C10616a;
import com.kwad.sdk.core.webview.p418b.p420b.C10619b;
import com.kwad.sdk.core.webview.p418b.p421c.C10620a;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.p435h.p436a.C10771a;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10606a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile C10606a aEh;

    /* renamed from: YZ */
    private long f29622YZ;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<C10772b> aEi = new CopyOnWriteArrayList();
    private final List<String> aEj = new CopyOnWriteArrayList();
    private final List<String> aEk = new CopyOnWriteArrayList();
    private final NetworkMonitor.InterfaceC9881a aEl = new NetworkMonitor.InterfaceC9881a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.InterfaceC9881a
        /* renamed from: a */
        public final void mo24766a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                C10606a.this.m25318GX();
            }
        }
    };

    private C10606a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m25321D(List<C10772b> list) {
        synchronized (this.aEi) {
            m25301bp(this.mContext);
            for (C10772b c10772b : this.aEi) {
                if (list.contains(c10772b)) {
                    if (C11122q.m23717gt(C10620a.m25274I(this.mContext, c10772b.aHY))) {
                        list.remove(c10772b);
                    }
                } else {
                    C11122q.m23727aa(new File(c10772b.aHZ));
                    this.aEi.remove(c10772b);
                }
            }
            m25302bo(this.mContext);
        }
    }

    /* renamed from: GV */
    public static C10606a m25320GV() {
        if (aEh == null) {
            synchronized (C10606a.class) {
                if (aEh == null) {
                    aEh = new C10606a();
                }
            }
        }
        return aEh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: GY */
    public List<C10772b> m25317GY() {
        List<C10771a> list;
        SdkConfigData m26554Ca = C10251d.m26554Ca();
        if (m26554Ca == null || (list = m26554Ca.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C10771a c10771a : list) {
            for (C10772b c10772b : c10771a.aHW) {
                m25310a(c10772b, c10771a);
                if (c10772b.isValid()) {
                    arrayList.add(c10772b);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ab */
    private WebResourceResponse m25306ab(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C10621b.C10622a c10622a = new C10621b.C10622a();
            this.aEj.add(str);
            WebResourceResponse m25308a = m25308a(str, str2, c10622a, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (m25308a != null) {
                C10331c.m26254d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                C10621b.m25263a(str2, str, 1, "", currentTimeMillis2);
            } else {
                C10331c.m26254d("HybridPackageManager", "load fail errorMsg:" + c10622a.msg + "-url:" + str2);
                C10621b.m25263a(str2, str, 2, c10622a.msg, currentTimeMillis2);
            }
            return m25308a;
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            C10621b.m25263a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), currentTimeMillis3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x005c, TryCatch #4 {, blocks: (B:7:0x001e, B:16:0x0033, B:17:0x003e, B:19:0x0044, B:21:0x004e, B:22:0x0056, B:24:0x0058, B:25:0x005b, B:15:0x0030), top: B:35:0x0004 }] */
    /* renamed from: bo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m25302bo(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aEi
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.p418b.p421c.C10620a.m25271bs(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.aEi     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            org.json.JSONArray r2 = com.kwad.sdk.utils.C11126t.m23681O(r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r3.write(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L5c
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
            com.kwad.sdk.core.p397e.C10331c.m26250e(r5, r2)     // Catch: java.lang.Throwable -> L27
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
        L33:
            java.util.List<java.lang.String> r5 = r4.aEj     // Catch: java.lang.Throwable -> L5c
            r5.clear()     // Catch: java.lang.Throwable -> L5c
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aEi     // Catch: java.lang.Throwable -> L5c
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5c
        L3e:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L56
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L5c
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.p435h.p436a.C10772b) r1     // Catch: java.lang.Throwable -> L5c
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
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.p418b.C10606a.m25302bo(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:43:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:43:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /* renamed from: bp */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m25301bp(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aEi
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.p418b.p421c.C10620a.m25271bs(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            boolean r2 = com.kwad.sdk.utils.C11122q.m23750L(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r2 == 0) goto L29
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r5.<init>(r2)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.lang.String r5 = com.kwad.sdk.crash.utils.C10747h.m24945b(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            com.kwad.sdk.core.webview.b.a$6 r3 = new com.kwad.sdk.core.webview.b.a$6     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r3.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.util.List r5 = m25309a(r5, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r1 = r2
            goto L2a
        L27:
            r5 = move-exception
            goto L33
        L29:
            r5 = r1
        L2a:
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
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
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L83
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
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.p435h.p436a.C10772b) r1     // Catch: java.lang.Throwable -> L83
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r1.aHY     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = com.kwad.sdk.core.webview.p418b.p421c.C10620a.m25274I(r2, r3)     // Catch: java.lang.Throwable -> L83
            boolean r2 = com.kwad.sdk.utils.C11122q.m23717gt(r2)     // Catch: java.lang.Throwable -> L83
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
            com.kwad.sdk.crash.utils.C10738b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.p418b.C10606a.m25301bp(android.content.Context):void");
    }

    /* renamed from: eM */
    private WebResourceResponse m25297eM(String str) {
        try {
            C10621b.C10622a c10622a = new C10621b.C10622a();
            synchronized (this.aEi) {
                for (String str2 : this.aEj) {
                    WebResourceResponse m25308a = m25308a(str2, str, c10622a, true);
                    if (m25308a != null) {
                        return m25308a;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: eN */
    private C10772b m25296eN(String str) {
        List<C10772b> m25317GY = m25317GY();
        if (m25317GY != null && !m25317GY.isEmpty()) {
            for (C10772b c10772b : m25317GY) {
                if (C11053bg.isEquals(str, c10772b.aHX)) {
                    return c10772b;
                }
            }
        }
        return null;
    }

    /* renamed from: eO */
    private C10772b m25295eO(String str) {
        synchronized (this.aEi) {
            if (!TextUtils.isEmpty(str) && this.aEi.size() > 0) {
                for (C10772b c10772b : this.aEi) {
                    if (TextUtils.equals(str, c10772b.aHX)) {
                        return c10772b;
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* renamed from: GW */
    public final long m25319GW() {
        return this.f29622YZ;
    }

    /* renamed from: GX */
    public final void m25318GX() {
        if (C10251d.m26545Cj()) {
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    int i;
                    try {
                        List<C10772b> m25317GY = C10606a.this.m25317GY();
                        if (m25317GY != null && !m25317GY.isEmpty()) {
                            C10606a.this.m25321D(m25317GY);
                            for (C10772b c10772b : m25317GY) {
                                if (c10772b.packageType == 1 && ((i = c10772b.loadType) == 1 || (i == 2 && C11013ag.isWifiConnected(C10606a.this.mContext)))) {
                                    C10606a.this.m25311a(c10772b);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    @Nullable
    /* renamed from: aa */
    public final WebResourceResponse m25307aa(String str, String str2) {
        if (this.mHasInit) {
            String m25270eR = C10620a.m25270eR(str);
            if (!TextUtils.isEmpty(m25270eR)) {
                C10621b.m25258c(str2, m25270eR, str);
                WebResourceResponse m25306ab = m25306ab(m25270eR, str);
                C10621b.m25257d(str2, m25270eR, str);
                return m25306ab;
            }
            return m25297eM(str);
        }
        return null;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.m24363KO();
            this.mHasInit = true;
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    try {
                        if (C10251d.m26519b(C10250c.arU)) {
                            C10606a.this.f29622YZ = System.currentTimeMillis();
                            C10606a.this.m25301bp(context);
                            C10606a.this.m25318GX();
                            NetworkMonitor.getInstance().m27465a(C10606a.this.mContext, C10606a.this.aEl);
                        }
                    } catch (Throwable th) {
                        ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m25303b(@NonNull final C10772b c10772b) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10772b c10772b2 = c10772b;
                if (c10772b2 != null) {
                    C10606a.this.m25311a(c10772b2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25311a(@NonNull C10772b c10772b) {
        if (this.aEk.contains(c10772b.aHX) || TextUtils.isEmpty(c10772b.packageUrl)) {
            return;
        }
        C10616a.m25284a(c10772b, new C10616a.InterfaceC10618a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.p418b.p420b.C10616a.InterfaceC10618a
            /* renamed from: c */
            public final void mo25281c(C10772b c10772b2) {
                C10606a.this.aEk.add(c10772b2.aHX);
                C10331c.m26254d("HybridPackageManager", "download onStart: " + c10772b2.toString());
            }

            @Override // com.kwad.sdk.core.webview.p418b.p420b.C10616a.InterfaceC10618a
            /* renamed from: d */
            public final void mo25280d(C10772b c10772b2) {
                C10331c.m26254d("HybridPackageManager", "download success: " + c10772b2.toString());
                if (C10619b.m25278a(C10606a.this.mContext, c10772b2)) {
                    C10331c.m26254d("HybridPackageManager", "install success: " + c10772b2.toString());
                    C10606a.this.aEi.add(c10772b2);
                    C10606a c10606a = C10606a.this;
                    c10606a.m25302bo(c10606a.mContext);
                    C10621b.m25266a(c10772b2, 4);
                }
                C10606a.this.aEk.remove(c10772b2.aHX);
            }

            @Override // com.kwad.sdk.core.webview.p418b.p420b.C10616a.InterfaceC10618a
            /* renamed from: e */
            public final void mo25279e(C10772b c10772b2) {
                C10331c.m26254d("HybridPackageManager", "download failure: " + c10772b2.toString());
                C10606a.this.aEk.remove(c10772b2.aHX);
            }
        });
    }

    /* renamed from: a */
    private WebResourceResponse m25308a(@NonNull String str, String str2, C10621b.C10622a c10622a, boolean z) {
        C10772b m25295eO = m25295eO(str);
        if (m25295eO == null) {
            C10772b m25296eN = m25296eN(str);
            if (m25296eN == null) {
                c10622a.msg = "配置文件没有下发该zip资源";
                return null;
            }
            c10622a.msg = "资源未下载:" + m25296eN.loadType;
            m25303b(m25296eN);
            return null;
        }
        return C10615b.m25292a(this.mContext, str2, m25295eO, c10622a, z);
    }

    /* renamed from: a */
    private void m25310a(C10772b c10772b, C10771a c10771a) {
        c10772b.aHX = c10771a.sceneId;
        if (TextUtils.isEmpty(c10772b.packageUrl)) {
            return;
        }
        String m25269eS = C10620a.m25269eS(c10772b.packageUrl);
        if (TextUtils.isEmpty(m25269eS)) {
            return;
        }
        c10772b.aHY = m25269eS;
        c10772b.aHZ = C10620a.m25276G(this.mContext, m25269eS);
    }

    @Deprecated
    /* renamed from: a */
    private static List<C10772b> m25309a(String str, @NonNull InterfaceC10229c<C10772b> interfaceC10229c) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C10772b mo23794AW = interfaceC10229c.mo23794AW();
                mo23794AW.parseJson(jSONObject);
                arrayList.add(mo23794AW);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
