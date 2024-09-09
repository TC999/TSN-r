package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.stub.StubApp;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static final int awE;
    private final com.kwad.sdk.core.network.idc.a.b awA;
    private final Random awB;
    private final Map<String, AtomicBoolean> awC;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> awD;
    private volatile int awF;
    private volatile boolean awG;
    private final Map<String, String> awz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.network.idc.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0700a {
        private static final a awJ = new a((byte) 0);
    }

    static {
        awE = com.kwad.framework.a.a.md.booleanValue() ? 0 : 60000;
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    public static a DU() {
        return C0700a.awJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void DV() {
        com.kwad.sdk.core.network.idc.a.b ba = b.ba(this.mContext);
        if (ba.isEmpty()) {
            ba = b.aZ(this.mContext);
        }
        this.awA.a(ba);
    }

    @WorkerThread
    private void V(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> dV = this.awA.dV(str2);
        if (dV.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.awC.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String dT = dT(str2);
                if ((TextUtils.isEmpty(dT) || host.equals(dT)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = dV.size();
                    int indexOf = dV.indexOf(host);
                    boolean z3 = indexOf >= 0;
                    if (z3) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.awB.nextInt(size) + 1;
                        if (z3) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % dV.size();
                        String str3 = dV.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + dV + ", key = " + size2);
                        X(str2, str3);
                        if (q(str2, size2)) {
                            dQ(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                c.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void X(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.awz.put(str, str2);
        g.execute(new ay() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.a(a.this.mContext, a.this.awz);
            }
        });
    }

    private void dQ(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.awD.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public boolean dS(String str) {
        boolean gD;
        String dT = dT(str);
        List<String> dV = this.awA.dV(str);
        if (dV.isEmpty()) {
            return false;
        }
        String str2 = dV.get(0);
        if (TextUtils.equals(str2, dT)) {
            return true;
        }
        if ("api".equals(str)) {
            gD = c(com.kwad.framework.a.a.md.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            gD = ag.gD(str2);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str2 + ",isSuccess = " + gD);
        if (gD) {
            X(str, str2);
        }
        return gD;
    }

    private String dT(String str) {
        return this.awz.get(str);
    }

    private boolean q(String str, int i4) {
        return "api".equals(str) && i4 > 0 && !this.awD.containsKey(str) && this.awF > 0;
    }

    public final boolean DW() {
        return !this.awD.isEmpty();
    }

    @Nullable
    public final String W(String str, String str2) {
        String str3 = this.awz.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String dT = dT(str2);
        if (dT == null || dT.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || dT.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(dT);
        if (TextUtils.isEmpty(parse.getScheme())) {
            builder.scheme("https");
        } else {
            builder.scheme(parse.getScheme());
        }
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void dR(String str) {
        int i4 = this.awF;
        if (!this.awG && i4 > 0) {
            com.kwad.sdk.core.network.idc.a.a aVar = this.awD.get(str);
            if (aVar != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.DZ();
                boolean z3 = elapsedRealtime > ((long) Math.max(i4, awE));
                c.d("IdcManager", "handleHostRollback: isAvailable = " + z3 + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i4 + ",hostType = hostType");
                if (z3) {
                    AtomicBoolean atomicBoolean = this.awC.get(str);
                    try {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            boolean DY = aVar.DY();
                            c.d("IdcManager", "handleHostRollback: isInRollback = " + DY);
                            if (!DY) {
                                aVar.bm(true);
                                if (dS(str)) {
                                    this.awD.remove(str);
                                    c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    dQ(str);
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception e4) {
                        c.e("IdcManager", "handleHostRollback failed by " + e4.getMessage());
                        return;
                    } finally {
                        atomicBoolean.set(false);
                        c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    }
                }
                return;
            }
            return;
        }
        c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.awG + ",rollbackInterval = " + i4);
    }

    public final String dU(String str) {
        return Y(str, "cdn");
    }

    public final void g(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void init(final Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.awG = true;
        g.execute(new ay() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.awz.putAll(b.bb(context));
                a.this.DV();
                if (!a.this.awA.isEmpty()) {
                    for (String str : a.this.awA.Eb()) {
                        a.this.dS(str);
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    private a() {
        this.awz = new ConcurrentHashMap(8);
        this.awA = new com.kwad.sdk.core.network.idc.a.b();
        this.awB = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.awC = hashMap;
        this.awD = new ConcurrentHashMap(4);
        this.awF = 0;
        this.awG = false;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    @WorkerThread
    private static boolean c(final String str, Context context) {
        boolean isNetworkConnected = ag.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy xT = f.xT();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.g.bU(JPushConstants.HTTPS_PRE + str);
                }
            };
            com.kwad.sdk.core.network.c doGet = xT.doGet(dVar.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.avq + ",body = " + doGet.avs);
                if (doGet.avq == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.awG = false;
        return false;
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i4) {
        this.awF = i4 * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i4);
        if (i4 == 0) {
            this.awD.clear();
        }
        this.awA.a(bVar);
        g.execute(new ay() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.a(a.this.mContext, a.this.awA);
            }
        });
    }

    public final void a(String str, int i4, Throwable th) {
        a(str, "ulog", new DomainException(i4, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            V(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
