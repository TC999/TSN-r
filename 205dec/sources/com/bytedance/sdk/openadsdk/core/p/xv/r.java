package com.bytedance.sdk.openadsdk.core.p.xv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.bytedance.sdk.openadsdk.core.w.c.w.p;
import com.bytedance.sdk.openadsdk.core.w.c.w.sr;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends f {

    /* renamed from: a  reason: collision with root package name */
    protected Bridge f34341a;
    private final AtomicBoolean bk;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<Context> f34342c;

    /* renamed from: f  reason: collision with root package name */
    protected final AtomicBoolean f34343f;
    private final n fp;
    private volatile com.bytedance.sdk.openadsdk.core.p.xv.xv.xv fz;
    protected boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private int f34344i;
    private boolean ia;

    /* renamed from: j  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.n.c.c.w f34345j;

    /* renamed from: k  reason: collision with root package name */
    protected volatile boolean f34346k;
    private List<u> ls;

    /* renamed from: p  reason: collision with root package name */
    protected volatile boolean f34347p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f34348q;

    /* renamed from: s  reason: collision with root package name */
    private final String f34349s;
    protected String sr;

    /* renamed from: t  reason: collision with root package name */
    private HashSet<Integer> f34350t;

    /* renamed from: u  reason: collision with root package name */
    private volatile Runnable f34351u;
    protected final AtomicInteger ux;

    /* renamed from: w  reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.u.sr f34352w;
    protected me xv;
    private com.bytedance.sdk.openadsdk.core.p.w.ux ys;

    private void a() {
        if (this.f34342c == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && com.bytedance.sdk.openadsdk.core.k.sr().c(activity)) {
            w(activity);
        } else {
            s();
        }
    }

    private synchronized void bk() {
        if (this.f34352w == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.bk;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.bk.set(false);
            if (this.f34341a != null) {
                this.f34341a.call(4, b.b(1).h(0, new y().c("hashCode", Integer.valueOf(hashCode()))).l(), Void.class);
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.c fp() {
        if (w()) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.ux();
        }
        if (this.f34347p) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.sr();
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.xv.w();
    }

    private void fz() {
        if (eq.f33190w >= 5400 && w() && !this.f34348q) {
            com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(false);
        }
    }

    private boolean ia() {
        if (this.f34352w == null || !ev()) {
            return false;
        }
        boolean c4 = com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(getContext(), this.f34352w.c(), this.xv, this.sr, this.f34347p);
        if (c4) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.fp.sendMessageDelayed(obtain, 3000L);
        } else {
            f(false);
        }
        return c4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.6
                @Override // java.lang.Runnable
                public void run() {
                    ia c4 = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(3));
                    try {
                        synchronized (r.this.ls) {
                            if (c4 != null && r.this.ls.size() > 0) {
                                for (u uVar : r.this.ls) {
                                    c4.w(r.this.f34349s, uVar);
                                }
                                r.this.ls.clear();
                            }
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
    }

    private synchronized void t() {
        if (this.f34352w == null) {
            return;
        }
        this.bk.set(true);
        if (this.f34341a != null) {
            this.f34341a.call(5, b.a().h(0, new y().c("hashCode", Integer.valueOf(hashCode())).c("downloadStatusChangeListener", this.f34345j)).l(), Void.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(final JSONObject jSONObject) {
        TTLiveCommerceHelper tTLiveCommerceHelper = TTLiveCommerceHelper.getInstance();
        if (tTLiveCommerceHelper.canOpenGoodsDetailPage(this.xv) == 1) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("event_tag", this.sr);
        int canOpenLive = tTLiveCommerceHelper.canOpenLive(getContext(), this.xv, hashMap) & 255;
        w(canOpenLive);
        if (canOpenLive == 0) {
            return;
        }
        c().c(fp(), this.xv);
        if (!"feed_video_middle_page".equals(this.sr)) {
            TTMiddlePageActivity.w(getContext(), this.xv);
        }
        if (jSONObject != null && jSONObject.optBoolean("needJumpWechat", true)) {
            jSONObject.remove("needJumpWechat");
            if (new com.bytedance.sdk.openadsdk.core.w.c.w.p(this.xv, getContext()).c(this.sr).w(this.f34347p).c(new p.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.3
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
                public void w() {
                    r.this.f(jSONObject);
                }
            })) {
                return;
            }
            f(jSONObject);
            return;
        }
        f(jSONObject);
    }

    private boolean ys() {
        if (this.f34341a == null || com.bytedance.sdk.openadsdk.core.u.ia.ia(this.xv) == 1 || com.bytedance.sdk.openadsdk.core.u.ia.ev(this.xv)) {
            return true;
        }
        if (((Boolean) this.f34341a.call(6, b.a().h(0, new y().c("downloadUrl", this.f34352w.w())).l(), Boolean.class)).booleanValue()) {
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.10
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(r.this.getContext(), "\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d...", 0).show();
                }
            });
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean ev() {
        me meVar = this.xv;
        return (meVar == null || this.f34352w == null || com.bytedance.sdk.openadsdk.core.u.ia.sr(meVar) != 3 || this.f34352w.c() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void f() {
        com.bytedance.sdk.openadsdk.core.p.w.ux uxVar = this.ys;
        if (uxVar != null) {
            uxVar.w();
        }
        bk();
        HashSet<Integer> hashSet = this.f34350t;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.f34350t);
            this.f34350t.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.7
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        Bridge bridge = r.this.f34341a;
                        if (bridge != null) {
                            bridge.call(3, b.b(1).h(0, new y().c("hid", Integer.valueOf(intValue))).l(), Void.class);
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.f34342c;
        if (weakReference != null) {
            weakReference.clear();
            this.f34342c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean gd() {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f34352w;
        boolean z3 = false;
        if (srVar == null) {
            return false;
        }
        String sr = srVar.sr();
        if (!TextUtils.isEmpty(sr) && c(getContext(), sr)) {
            z3 = true;
            this.f34343f.set(true);
            if (!c(this.sr, "click_open", this.xv)) {
                com.bytedance.sdk.openadsdk.core.a.xv.gd(this.xv, this.sr, wv.r(this.xv), null);
            }
        }
        return z3;
    }

    protected Context getContext() {
        try {
            WeakReference<Context> weakReference = this.f34342c;
            if (weakReference == null) {
                return ls.getContext();
            }
            Context context = weakReference.get();
            return context == null ? ls.getContext() : context;
        } catch (Throwable unused) {
            return ls.getContext();
        }
    }

    public boolean k() {
        if (this.xv.qu() != null) {
            String c4 = this.xv.qu().c();
            if (!TextUtils.isEmpty(c4)) {
                ys.c((String) null);
                Uri parse = Uri.parse(c4);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(parse);
                if (this.f34347p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", c(c4));
                }
                if (wv.c(getContext(), intent)) {
                    try {
                        wv.c(this.f34347p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                        if (!c(this.sr, "open_url_app", this.xv)) {
                            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, "open_url_app", null);
                        }
                        getContext().startActivity(intent);
                        com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, this.f34347p);
                        if (this.f34347p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, this.sr, "lp_openurl");
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, this.sr, "lp_deeplink_success_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, this.sr, "deeplink_success_realtime");
                        }
                        return true;
                    } catch (Throwable unused) {
                        if (!TextUtils.isEmpty(this.xv.pu())) {
                            pr.c(getContext(), this.xv.pu(), this.xv, wv.c(this.sr), this.sr, (Map<String, Object>) null);
                        }
                        if (this.f34347p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                            c(this.xv, this.sr, "lp_deeplink_fail_realtime");
                        } else {
                            c(this.xv, this.sr, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.f34347p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                    c(this.xv, this.sr, "lp_deeplink_fail_realtime");
                } else {
                    c(this.xv, this.sr, "deeplink_fail_realtime");
                }
            }
            if (this.ux.get() != 4 && this.ux.get() != 3 && (!this.gd || this.f34343f.get())) {
                this.gd = true;
                if (!c(this.sr, "open_fallback_url", this.xv)) {
                    com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public int p() {
        return this.ux.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void r() {
        if (this.f34352w == null) {
            return;
        }
        this.bk.set(false);
        if (this.f34341a != null) {
            this.f34341a.call(8, b.a().h(0, new y().c("force", Boolean.TRUE)).l(), Void.class);
        }
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void ux() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr() {
        if (ls.getContext() == null) {
            ls.c(getContext());
        }
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void xv() {
        t();
    }

    private void ev(JSONObject jSONObject) {
        c(jSONObject);
    }

    private void w(Activity activity) {
        com.bytedance.sdk.openadsdk.core.eq.c xv = com.bytedance.sdk.openadsdk.core.k.sr().xv();
        if (xv != null && this.f34351u == null) {
            this.f34351u = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.8
                @Override // java.lang.Runnable
                public void run() {
                    r.this.s();
                    r.this.f34351u = null;
                }
            };
            xv.c(activity, this.f34351u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(final Map<String, Object> map) {
        int i4 = this.f34344i;
        if (i4 == 1) {
            return;
        }
        if (i4 == 2) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.14
                @Override // java.lang.Runnable
                public void run() {
                    ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                    r rVar = r.this;
                    com.bytedance.sdk.openadsdk.core.u.xv c5 = c4.c(rVar.xv, rVar.f34352w.w());
                    if (c5 == null || !c5.ux()) {
                        return;
                    }
                    q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                            r.this.c((com.bytedance.sdk.openadsdk.core.n.c.c.c) null, map);
                        }
                    });
                }
            });
        } else {
            c((com.bytedance.sdk.openadsdk.core.n.c.c.c) null, map);
        }
    }

    private void sr(JSONObject jSONObject) {
        fz();
        if (getContext() == null || this.f34352w == null || !ys()) {
            return;
        }
        String str = this.sr;
        com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(str, str, jSONObject);
        final y<String, Object> c4 = new y().c("downloadUrl", this.f34352w.w()).c("action_type_button", 2);
        me meVar = this.xv;
        if (meVar != null && !TextUtils.isEmpty(meVar.jr())) {
            c4.c("id", Long.valueOf(Double.valueOf(this.xv.jr()).longValue()));
        }
        if (w()) {
            com.bytedance.sdk.openadsdk.core.n.c.c.c cVar = new com.bytedance.sdk.openadsdk.core.n.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.9
                @Override // com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z3) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (c4 == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(0);
                    r.this.c().c(r.this.fp());
                    c4.remove("downloadButtonClickListener");
                    if (r.this.c((com.bytedance.sdk.openadsdk.core.u.xv) null, (com.bytedance.sdk.openadsdk.core.n.c.c.c) null, c4)) {
                        return;
                    }
                    r.this.xv(c4);
                }
            };
            com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(c4, cVar);
            if (c((com.bytedance.sdk.openadsdk.core.u.xv) null, cVar, c4)) {
                return;
            }
            c(c4, cVar);
            return;
        }
        w(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean xv(JSONObject jSONObject) {
        if (this.ux.get() == 1) {
            if (com.bytedance.sdk.component.utils.ys.xv(getContext()) == 0) {
                try {
                    Toast.makeText(getContext(), i.c(getContext(), "tt_no_network"), 0).show();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
            if (wv.f(getContext())) {
                wv.c(this.f34347p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
            }
            r(jSONObject);
            return true;
        }
        if (wv.f(getContext())) {
            wv.c(this.f34347p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
        }
        c(jSONObject);
        if (this.ux.get() != 3 && this.ux.get() != 4) {
            if (this.ux.get() == 6) {
                this.f34343f.set(true);
            }
        } else {
            this.f34343f.set(false);
        }
        return false;
    }

    private void r(JSONObject jSONObject) {
        ev(jSONObject);
        this.f34343f.set(true);
    }

    private void w(com.bytedance.sdk.openadsdk.core.n.c.c.c cVar, Map<String, Object> map) {
        if (this.f34341a == null) {
            return;
        }
        final y<String, Object> c4 = new y().c("itemClickListener", null).c("downloadButtonClickListener", cVar).c(map);
        if (eq.f33190w < 4500) {
            this.f34341a.call(17, b.a().h(0, c4).l(), Void.class);
            return;
        }
        c4.put("itemClickListener", new com.bytedance.sdk.openadsdk.core.n.c.c.xv() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.12
            @Override // com.bytedance.sdk.openadsdk.core.n.c.c.xv
            public void c(Bridge bridge, Bridge bridge2, Bridge bridge3) {
                if (!r.this.f34347p && !r.this.xv.ds()) {
                    Context context = r.this.getContext();
                    String pu = r.this.xv.pu();
                    r rVar = r.this;
                    pr.c(context, pu, rVar.xv, wv.c(rVar.sr), r.this.sr, (Map<String, Object>) null);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.p.xv.w.w.w(1);
                c4.remove("itemClickListener");
                r.this.f34341a.call(17, b.a().h(0, c4).l(), Void.class);
            }
        });
        this.f34341a.call(17, b.a().h(0, c4).l(), Void.class);
    }

    private void gd(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f34352w;
        if (srVar == null || srVar.w() == null) {
            return;
        }
        xv(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c() {
        if (this.fz == null) {
            synchronized (this) {
                if (this.fz == null) {
                    this.fz = new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(getContext(), this.xv);
                }
            }
        }
        return this.fz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(JSONObject jSONObject) {
        if (k()) {
            this.f34343f.set(true);
        } else if ((!this.f34347p || this.f34346k) && this.xv.ix() == null && this.xv.pu() != null && !this.xv.ja()) {
            pr.c(getContext(), this.xv.pu(), this.xv, wv.c(this.sr), this.sr, (Map<String, Object>) null);
        } else if (gd()) {
        } else {
            if (ia()) {
                this.f34343f.set(true);
            } else if (this.xv.ja()) {
            } else {
                gd(jSONObject);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f34342c = new WeakReference<>(activity);
        t();
    }

    private void w(final Map<String, Object> map) {
        int i4 = this.f34344i;
        if (i4 == 1) {
            if (gd()) {
                return;
            }
            k.c(ls.getContext());
        } else if (i4 != 2) {
            c((com.bytedance.sdk.openadsdk.core.u.xv) null, map);
        } else {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.13
                @Override // java.lang.Runnable
                public void run() {
                    ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                    r rVar = r.this;
                    com.bytedance.sdk.openadsdk.core.u.xv c5 = c4.c(rVar.xv, rVar.f34352w.w());
                    if (c5 == null || !c5.ux()) {
                        if (r.this.gd()) {
                            return;
                        }
                        k.c(ls.getContext());
                        return;
                    }
                    r.this.c(c5, map);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(JSONObject jSONObject) {
        sr(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.n.c.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.p.ev.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.11
            @Override // java.lang.Runnable
            public void run() {
                r.this.c(cVar, map);
            }
        }, this.xv);
        this.f34348q = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void xv(boolean z3) {
        this.f34346k = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr(boolean z3) {
        if (eq.f33190w >= 5400 && z3) {
            this.f34348q = z3;
            if (w()) {
                com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.n.c.c.c cVar, Map<String, Object> map) {
        try {
            if (cVar == null) {
                c(map);
                this.f34348q = false;
                return;
            }
            w(cVar, map);
            this.f34348q = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean w() {
        Bridge bridge = this.f34341a;
        return bridge != null && com.bytedance.sdk.openadsdk.core.p.xv.w.w.c(bridge) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void w(final JSONObject jSONObject) {
        if (getContext() == null) {
            return;
        }
        me c4 = com.bytedance.sdk.openadsdk.core.w.c(jSONObject);
        this.xv = c4;
        if (com.bytedance.sdk.openadsdk.core.w.c.w.sr.c(c4, getContext()) && !com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.xv) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.xv)) {
            new com.bytedance.sdk.openadsdk.core.w.c.w.sr(this.xv, getContext()).c(this.sr).c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.2
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
                public void c() {
                    r.this.ux(jSONObject);
                }
            });
        } else {
            ux(jSONObject);
        }
    }

    private void c(Map<String, Object> map) {
        Bridge bridge = this.f34341a;
        if (bridge != null) {
            bridge.call(16, b.a().h(0, map).l(), Void.class);
        }
    }

    private void f(boolean z3) {
        if (z3) {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.sdk.openadsdk.core.u.xv xvVar, final Map<String, Object> map) {
        c(new com.bytedance.sdk.openadsdk.core.n.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.1
            @Override // com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z3) {
                if (z3 && r.this.c(xvVar, (com.bytedance.sdk.openadsdk.core.n.c.c.c) null, map)) {
                    return;
                }
                r.this.c((com.bytedance.sdk.openadsdk.core.n.c.c.c) null, map);
            }

            @Override // com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        }, map);
    }

    void c(me meVar, String str, String str2) {
        if (w()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, str, str2);
    }

    private void w(int i4) {
        TTLiveCommerceHelper.getInstance().reportLiveRoomJumpResult(this.xv, this.sr, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean c(boolean z3) {
        this.ia = z3;
        return ia();
    }

    private void w(final com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv() || cVar == null) {
            return;
        }
        com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f fVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f(cVar);
                ia c5 = ia.c.c(c4.c(3));
                if (c5 != null) {
                    try {
                        c5.c(r.this.f34349s, fVar);
                        synchronized (r.this.ls) {
                            r.this.ls.add(fVar);
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, final com.bytedance.sdk.openadsdk.core.n.c.c.c cVar, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c4 = c();
        if (c4.c()) {
            if (c(getContext(), this.xv, this.sr)) {
                return true;
            }
            c4.c(xvVar, this.sr, this.f34352w.w(), new com.bytedance.sdk.openadsdk.core.p.xv.c.w() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.r.4
                @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.w
                public void c() {
                    if (r.this.w()) {
                        r.this.sr(true);
                        r.this.c(map, cVar);
                        return;
                    }
                    r.this.c(cVar, map);
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void w(boolean z3) {
        this.f34347p = z3;
    }

    public boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (this.f34347p) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", str);
            }
            try {
                if (wv.xv(context, str)) {
                    try {
                        Intent w3 = wv.w(context, str);
                        if (w3 == null) {
                            return false;
                        }
                        wv.c(this.f34347p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                        w3.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(w3);
                        if (this.f34347p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl");
                        }
                        if (this.f34347p) {
                            com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.xv.pu() != null) {
                            pr.c(getContext(), this.xv.pu(), this.xv, wv.c(this.sr), this.sr, (Map<String, Object>) null);
                        }
                        if (this.f34347p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                        }
                        return true;
                    }
                } else if (this.f34347p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    protected boolean c(String str, String str2, me meVar) {
        if (this.f34341a != null) {
            return ((Boolean) this.f34341a.call(2, b.a().h(0, new y().c("tagIntercept", str).c("label", str2).c("meta", meVar.mo().toString())).l(), Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        c(cVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar, boolean z3) {
        if (cVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.ux uxVar = this.ys;
        if (uxVar != null) {
            uxVar.c(cVar);
        }
        if (z3) {
            w(cVar);
        }
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (this.f34350t == null) {
            this.f34350t = new HashSet<>();
        }
        this.f34350t.add(Integer.valueOf(i4));
        if (this.f34341a != null) {
            this.f34341a.call(9, b.a().h(0, new y().c("id", Integer.valueOf(i4)).c("onEventLogHandler", onEventLogHandler)).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4) {
        this.f34344i = i4;
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.k.sr() != null && !com.bytedance.sdk.openadsdk.core.k.sr().c()) {
            f(false);
            if (this.ia) {
                gd(me.ux(this.xv));
                return;
            }
            return;
        }
        f(true);
    }

    protected String c(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }
}
