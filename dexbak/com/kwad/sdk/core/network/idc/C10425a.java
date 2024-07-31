package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.idc.p407a.C10431a;
import com.kwad.sdk.core.network.idc.p407a.C10432b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11095g;
import com.stub.StubApp;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.network.idc.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10425a {
    private static final int awE;
    private final C10432b awA;
    private final Random awB;
    private final Map<String, AtomicBoolean> awC;
    private final Map<String, C10431a> awD;
    private volatile int awF;
    private volatile boolean awG;
    private final Map<String, String> awz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.network.idc.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10430a {
        private static final C10425a awJ = new C10425a((byte) 0);
    }

    static {
        awE = C9425a.f29473md.booleanValue() ? 0 : 60000;
    }

    /* synthetic */ C10425a(byte b) {
        this();
    }

    /* renamed from: DU */
    public static C10425a m26107DU() {
        return C10430a.awJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: DV */
    public void m26106DV() {
        C10432b m26070ba = C10433b.m26070ba(this.mContext);
        if (m26070ba.isEmpty()) {
            m26070ba = C10433b.m26071aZ(this.mContext);
        }
        this.awA.m26076a(m26070ba);
    }

    @WorkerThread
    /* renamed from: V */
    private void m26104V(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> m26075dV = this.awA.m26075dV(str2);
        if (m26075dV.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        C10331c.m26254d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.awC.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String m26086dT = m26086dT(str2);
                if ((TextUtils.isEmpty(m26086dT) || host.equals(m26086dT)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = m26075dV.size();
                    int indexOf = m26075dV.indexOf(host);
                    boolean z = indexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.awB.nextInt(size) + 1;
                        if (z) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % m26075dV.size();
                        String str3 = m26075dV.get(size2);
                        C10331c.m26254d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + m26075dV + ", key = " + size2);
                        m26102X(str2, str3);
                        if (m26083q(str2, size2)) {
                            m26089dQ(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                C10331c.m26254d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                C10331c.m26254d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    /* renamed from: X */
    private void m26102X(String str, String str2) {
        C10331c.m26254d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.awz.put(str, str2);
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10433b.m26072a(C10425a.this.mContext, C10425a.this.awz);
            }
        });
    }

    /* renamed from: dQ */
    private void m26089dQ(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C10331c.m26254d("IdcManager", "save switched host, type = " + str);
        this.awD.put(str, new C10431a(elapsedRealtime, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: dS */
    public boolean m26087dS(String str) {
        boolean m24129gD;
        String m26086dT = m26086dT(str);
        List<String> m26075dV = this.awA.m26075dV(str);
        if (m26075dV.isEmpty()) {
            return false;
        }
        String str2 = m26075dV.get(0);
        if (TextUtils.equals(str2, m26086dT)) {
            return true;
        }
        if ("api".equals(str)) {
            m24129gD = m26091c(C9425a.f29473md.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            m24129gD = C11013ag.m24129gD(str2);
        }
        C10331c.m26254d("IdcManager", "perform ping action for " + str + ",mainHost = " + str2 + ",isSuccess = " + m24129gD);
        if (m24129gD) {
            m26102X(str, str2);
        }
        return m24129gD;
    }

    /* renamed from: dT */
    private String m26086dT(String str) {
        return this.awz.get(str);
    }

    /* renamed from: q */
    private boolean m26083q(String str, int i) {
        return "api".equals(str) && i > 0 && !this.awD.containsKey(str) && this.awF > 0;
    }

    /* renamed from: DW */
    public final boolean m26105DW() {
        return !this.awD.isEmpty();
    }

    @Nullable
    /* renamed from: W */
    public final String m26103W(String str, String str2) {
        String str3 = this.awz.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: Y */
    public final String m26101Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String m26086dT = m26086dT(str2);
        if (m26086dT == null || m26086dT.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || m26086dT.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(m26086dT);
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

    /* renamed from: dR */
    public final void m26088dR(String str) {
        int i = this.awF;
        if (!this.awG && i > 0) {
            C10431a c10431a = this.awD.get(str);
            if (c10431a != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - c10431a.m26080DZ();
                boolean z = elapsedRealtime > ((long) Math.max(i, awE));
                C10331c.m26254d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
                if (z) {
                    AtomicBoolean atomicBoolean = this.awC.get(str);
                    try {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            boolean m26081DY = c10431a.m26081DY();
                            C10331c.m26254d("IdcManager", "handleHostRollback: isInRollback = " + m26081DY);
                            if (!m26081DY) {
                                c10431a.m26079bm(true);
                                if (m26087dS(str)) {
                                    this.awD.remove(str);
                                    C10331c.m26254d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    C10331c.m26254d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    m26089dQ(str);
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        C10331c.m26250e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                        return;
                    } finally {
                        atomicBoolean.set(false);
                        C10331c.m26254d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    }
                }
                return;
            }
            return;
        }
        C10331c.m26254d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.awG + ",rollbackInterval = " + i);
    }

    /* renamed from: dU */
    public final String m26085dU(String str) {
        return m26101Y(str, "cdn");
    }

    /* renamed from: g */
    public final void m26084g(String str, Throwable th) {
        m26094a(str, "cdn", new DomainException(th));
    }

    public final void init(final Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.awG = true;
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10425a.this.awz.putAll(C10433b.m26069bb(context));
                C10425a.this.m26106DV();
                if (!C10425a.this.awA.isEmpty()) {
                    for (String str : C10425a.this.awA.m26077Eb()) {
                        C10425a.this.m26087dS(str);
                    }
                }
                C10331c.m26254d("IdcManager", "idc prepare done.");
                C10425a.m26096a(C10425a.this, false);
            }
        });
    }

    private C10425a() {
        this.awz = new ConcurrentHashMap(8);
        this.awA = new C10432b();
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
    /* renamed from: c */
    private static boolean m26091c(final String str, Context context) {
        boolean isNetworkConnected = C11013ag.isNetworkConnected(context);
        C10331c.m26254d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy m24902xT = C10756f.m24902xT();
            AbstractC10418d abstractC10418d = new AbstractC10418d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.AbstractC10418d, com.kwad.sdk.core.network.AbstractC10410b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.AbstractC10418d, com.kwad.sdk.core.network.AbstractC10410b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
                public final String getUrl() {
                    return C10760g.m24896bU("https://" + str);
                }
            };
            C10415c doGet = m24902xT.doGet(abstractC10418d.getUrl(), Collections.emptyMap());
            C10331c.m26254d("IdcManager", "perform connect host:" + abstractC10418d.getUrl());
            if (doGet != null) {
                C10331c.m26254d("IdcManager", "connect host response, rawCode = " + doGet.avq + ",body = " + doGet.avs);
                if (doGet.avq == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m26096a(C10425a c10425a, boolean z) {
        c10425a.awG = false;
        return false;
    }

    /* renamed from: a */
    public final void m26099a(C10432b c10432b, int i) {
        this.awF = i * 1000;
        C10331c.m26254d("IdcManager", "updateIdcData,rollback interval = " + i);
        if (i == 0) {
            this.awD.clear();
        }
        this.awA.m26076a(c10432b);
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10433b.m26073a(C10425a.this.mContext, C10425a.this.awA);
            }
        });
    }

    /* renamed from: a */
    public final void m26095a(String str, int i, Throwable th) {
        m26094a(str, "ulog", new DomainException(i, th));
    }

    /* renamed from: a */
    public final void m26094a(String str, String str2, DomainException domainException) {
        if (str != null && m26100a(domainException)) {
            m26104V(str, str2);
        }
    }

    /* renamed from: a */
    private static boolean m26100a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
