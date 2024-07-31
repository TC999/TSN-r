package com.kwad.sdk.core.adlog.p386a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.adlog.C9901b;
import com.kwad.sdk.core.adlog.p387b.C9904a;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11014ah;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11126t;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.adlog.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9896b {
    private final C9900c apv;
    private final List<C9895a> apw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.adlog.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9899a {
        private static final C9896b apy = new C9896b((byte) 0);
    }

    /* synthetic */ C9896b(byte b) {
        this();
    }

    /* renamed from: Bi */
    public static C9896b m27405Bi() {
        return C9899a.apy;
    }

    @Nullable
    /* renamed from: Bk */
    private synchronized C9895a m27403Bk() {
        if (C11014ah.m24126I(this.apw)) {
            return null;
        }
        return this.apw.remove(0);
    }

    /* renamed from: Bm */
    private boolean m27401Bm() {
        C9900c c9900c = this.apv;
        return c9900c == null || !c9900c.apz;
    }

    /* renamed from: Bj */
    public final void m27404Bj() {
        try {
            if (m27401Bm() || C11014ah.m24126I(this.apw)) {
                return;
            }
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C9901b.m27396Bf();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    /* renamed from: Bl */
    public final C9895a m27402Bl() {
        C9895a m27403Bk = m27403Bk();
        if (m27403Bk == null) {
            return null;
        }
        C9904a.m27384d(m27403Bk, this.apv, this.apw.size());
        long currentTimeMillis = System.currentTimeMillis() - m27403Bk.aps;
        C9900c c9900c = this.apv;
        if (currentTimeMillis > c9900c.apB * 1000) {
            C9904a.m27386b(m27403Bk, c9900c, this.apw.size(), currentTimeMillis);
            C10331c.m26248i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + m27403Bk);
            return null;
        }
        m27403Bk.retryCount++;
        C9904a.m27390a(m27403Bk, c9900c, this.apw.size(), currentTimeMillis);
        C10331c.m26248i("AdLogCacheManager", "getCache success：" + m27403Bk);
        return m27403Bk;
    }

    /* renamed from: a */
    public final void m27399a(@Nullable C9895a c9895a, String str, JSONObject jSONObject, C9912a c9912a, int i, String str2) {
        try {
            if (m27401Bm()) {
                return;
            }
            if (c9895a == null) {
                c9895a = C9895a.m27413Bh().m27409cX(str).m27406i(jSONObject).m27410c(c9912a).m27411ad(System.currentTimeMillis());
            }
            c9895a.m27407cr(i).m27408cY(str2);
            C9904a.m27391a(c9895a, this.apv, this.apw.size());
            int i2 = c9895a.retryCount;
            C9900c c9900c = this.apv;
            if (i2 >= c9900c.apA) {
                C9904a.m27385c(c9895a, c9900c, this.apw.size());
                C10331c.m26248i("AdLogCacheManager", "addCache fail limit retryCount: " + c9895a.retryCount + ", log: " + c9895a);
                return;
            }
            if (this.apw.size() >= this.apv.apC) {
                C9895a m27403Bk = m27403Bk();
                C10331c.m26248i("AdLogCacheManager", "addCache limit size: " + this.apw.size() + ", remove log：" + m27403Bk);
                C9904a.m27383e(m27403Bk, this.apv, this.apw.size());
            }
            m27400a(c9895a);
            C10331c.m26248i("AdLogCacheManager", "addCache success size: " + this.apw.size() + ", log: " + c9895a);
            C9904a.m27387b(c9895a, this.apv, this.apw.size());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private C9896b() {
        this.apw = new CopyOnWriteArrayList();
        this.apv = (C9900c) C11126t.m23677b(((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24299yY(), new InterfaceC10229c<C9900c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            /* renamed from: Bn */
            private static C9900c m27398Bn() {
                return new C9900c();
            }

            @Override // com.kwad.sdk.core.InterfaceC10229c
            /* renamed from: AW */
            public final /* synthetic */ C9900c mo23794AW() {
                return m27398Bn();
            }
        });
    }

    /* renamed from: a */
    private synchronized void m27400a(C9895a c9895a) {
        this.apw.add(c9895a);
    }
}
