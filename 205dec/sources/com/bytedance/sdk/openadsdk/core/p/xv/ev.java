package com.bytedance.sdk.openadsdk.core.p.xv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
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
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends f {

    /* renamed from: a  reason: collision with root package name */
    protected ia f34269a;
    protected Bridge bk;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<Context> f34270c;
    private DownloadModel fp;
    private HashSet<Integer> fz;
    private volatile com.bytedance.sdk.openadsdk.core.p.xv.xv.xv gb;

    /* renamed from: j  reason: collision with root package name */
    private final String f34273j;

    /* renamed from: n  reason: collision with root package name */
    private volatile Runnable f34275n;
    protected String sr;

    /* renamed from: t  reason: collision with root package name */
    private AdDownloadController f34279t;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.ux f34280u;

    /* renamed from: w  reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.u.sr f34281w;
    protected me xv;
    private DownloadEventConfig ys;

    /* renamed from: z  reason: collision with root package name */
    private volatile boolean f34283z;
    protected final AtomicInteger ux = new AtomicInteger(1);

    /* renamed from: f  reason: collision with root package name */
    protected final AtomicBoolean f34271f = new AtomicBoolean(false);
    protected boolean gd = false;
    private final AtomicBoolean ia = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    private boolean f34278s = false;

    /* renamed from: i  reason: collision with root package name */
    private final n f34272i = new n(Looper.getMainLooper(), this);

    /* renamed from: q  reason: collision with root package name */
    private boolean f34277q = true;

    /* renamed from: p  reason: collision with root package name */
    protected volatile boolean f34276p = false;

    /* renamed from: k  reason: collision with root package name */
    protected volatile boolean f34274k = false;
    private c ls = new c();
    private int ck = 0;
    private final DownloadStatusChangeListener ba = new DownloadStatusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.1
        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i4) {
            ev.this.ux.set(3);
            ev.this.f34271f.set(false);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.c(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ev.this.f34281w.xv());
                    return;
                }
                return;
            }
            ev evVar = ev.this;
            evVar.c("onDownloadActive", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, evVar.f34281w.xv());
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
            ev.this.ux.set(5);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.xv(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ev.this.f34281w.xv());
                    return;
                }
                return;
            }
            ev evVar = ev.this;
            evVar.c("onDownloadFailed", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, evVar.f34281w.xv());
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
            ev.this.ux.set(6);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.c(downloadShortInfo.totalBytes, downloadShortInfo.fileName, ev.this.f34281w.xv());
                    return;
                }
                return;
            }
            ev evVar = ev.this;
            evVar.c("onDownloadFinished", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, evVar.f34281w.xv());
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i4) {
            ev.this.ux.set(4);
            ev.this.f34271f.set(false);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.w(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, ev.this.f34281w.xv());
                    return;
                }
                return;
            }
            ev evVar = ev.this;
            evVar.c("onDownloadPaused", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, evVar.f34281w.xv());
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
            ev.this.ux.set(2);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.c();
                    return;
                }
                return;
            }
            ev.this.c("onIdle", 0L, 0L, null, null);
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onIdle() {
            ev.this.ux.set(1);
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.c();
                    return;
                }
                return;
            }
            ev.this.c("onIdle", 0L, 0L, null, null);
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onInstalled(DownloadShortInfo downloadShortInfo) {
            ev.this.ux.set(7);
            ev.this.f34271f.set(true);
            String str = !TextUtils.isEmpty(downloadShortInfo.fileName) ? downloadShortInfo.fileName : "";
            if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                if (ev.this.f34280u != null) {
                    ev.this.f34280u.c(str, ev.this.f34281w.xv());
                    return;
                }
                return;
            }
            ev evVar = ev.this;
            evVar.c("onInstalled", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str, evVar.f34281w.xv());
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private List<u> f34282y = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends com.bytedance.sdk.component.gd.p {

        /* renamed from: c  reason: collision with root package name */
        String f34311c;
        String sr;
        String ux;

        /* renamed from: w  reason: collision with root package name */
        long f34313w;
        long xv;

        c() {
            super("DownloadCallbackRunnable");
        }

        public void c(String str) {
            this.f34311c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ev.this.a().c(ev.this.f34273j, this.f34311c, this.f34313w, this.xv, this.sr, this.ux);
            } catch (Throwable unused) {
            }
        }

        public void w(long j4) {
            this.xv = j4;
        }

        public void xv(String str) {
            this.ux = str;
        }

        public void c(long j4) {
            this.f34313w = j4;
        }

        public void w(String str) {
            this.sr = str;
        }

        c(String str, long j4, long j5, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.f34311c = str;
            this.f34313w = j4;
            this.xv = j5;
            this.sr = str2;
            this.ux = str3;
        }
    }

    public ev(Context context, me meVar, String str) {
        this.f34270c = new WeakReference<>(context);
        this.xv = meVar;
        com.bytedance.sdk.openadsdk.core.u.sr ix = meVar.ix();
        this.f34281w = ix;
        str = TextUtils.isEmpty(str) ? wv.c(this.xv) : str;
        this.sr = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.f34273j = this.xv.hashCode() + this.xv.xq();
        this.bk = com.bytedance.sdk.openadsdk.core.k.sr().u();
        if (ix == null) {
            return;
        }
        if (ls.getContext() == null) {
            ls.c(context);
        }
        this.f34280u = new com.bytedance.sdk.openadsdk.core.p.w.ux();
        this.fp = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.sr, this.xv, null).build();
        this.f34279t = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.xv).build();
        this.ys = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.sr).build();
        xv();
    }

    private void bk() {
    }

    private synchronized void fp() {
        if (this.f34281w == null) {
            return;
        }
        this.ia.set(true);
        if (this.bk != null) {
            this.bk.call(5, b.a().h(0, new y().c("hashCode", Integer.valueOf(hashCode())).c("downloadStatusChangeListener", this.ba).c("downloadModel", this.fp)).l(), Void.class);
        }
    }

    private boolean fz() {
        if (this.f34281w == null || !ev()) {
            return false;
        }
        boolean c4 = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(getContext(), this.f34281w.c(), this.xv, this.sr, this.f34276p);
        if (c4) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.f34272i.sendMessageDelayed(obtain, 3000L);
        } else {
            f(false);
        }
        return c4;
    }

    private void i() {
        AdDownloadController adDownloadController;
        if (eq.f33190w < 5400 || !w() || this.f34283z || this.fp == null || (adDownloadController = this.f34279t) == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(false);
        } catch (Throwable unused) {
        }
    }

    private boolean ia() {
        if (this.bk == null || com.bytedance.sdk.openadsdk.core.u.ia.ia(this.xv) == 1 || com.bytedance.sdk.openadsdk.core.u.ia.ev(this.xv)) {
            return true;
        }
        if (((Boolean) this.bk.call(6, b.a().h(0, new y().c("downloadUrl", this.f34281w.w())).l(), Boolean.class)).booleanValue()) {
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.11
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ev.this.getContext(), "\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d...", 0).show();
                }
            });
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.c s() {
        if (w()) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.ux();
        }
        if (this.f34276p) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.sr();
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.xv.w();
    }

    private void t() {
        if (this.f34270c == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && com.bytedance.sdk.openadsdk.core.k.sr().c(activity)) {
            w(activity);
        } else {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.7
                @Override // java.lang.Runnable
                public void run() {
                    ia c4 = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(3));
                    try {
                        synchronized (ev.this.f34282y) {
                            if (c4 != null && ev.this.f34282y.size() > 0) {
                                for (u uVar : ev.this.f34282y) {
                                    c4.w(ev.this.f34273j, uVar);
                                }
                                ev.this.f34282y.clear();
                            }
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
    }

    private synchronized void ys() {
        if (this.f34281w == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.ia;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.ia.set(false);
            if (this.bk != null) {
                this.bk.call(4, b.b(1).h(0, new y().c("hashCode", Integer.valueOf(hashCode())).c("downloadUrl", this.fp.getDownloadUrl())).l(), Void.class);
            }
        }
        t();
    }

    protected ia a() {
        if (this.f34269a == null) {
            this.f34269a = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(3));
        }
        return this.f34269a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean ev() {
        me meVar = this.xv;
        return (meVar == null || this.f34281w == null || com.bytedance.sdk.openadsdk.core.u.ia.sr(meVar) != 3 || this.f34281w.c() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean gd() {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f34281w;
        boolean z3 = false;
        if (srVar == null) {
            return false;
        }
        String sr = srVar.sr();
        if (!TextUtils.isEmpty(sr) && c(getContext(), sr)) {
            z3 = true;
            this.f34271f.set(true);
            if (!c(this.sr, "click_open", this.xv)) {
                com.bytedance.sdk.openadsdk.core.a.xv.gd(this.xv, this.sr, wv.r(this.xv), null);
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.f34270c;
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
                intent.setData(parse);
                wv.w(intent);
                if (this.f34276p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", c(c4));
                }
                if (wv.c(getContext(), intent)) {
                    try {
                        wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                        if (!c(this.sr, "open_url_app", this.xv)) {
                            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, "open_url_app", null);
                        }
                        getContext().startActivity(intent);
                        com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, this.f34276p);
                        if (this.f34276p) {
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
                        if (this.f34276p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                            c(this.xv, this.sr, "lp_deeplink_fail_realtime");
                        } else {
                            c(this.xv, this.sr, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.f34276p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                    c(this.xv, this.sr, "lp_deeplink_fail_realtime");
                } else {
                    c(this.xv, this.sr, "deeplink_fail_realtime");
                }
            }
            if (this.ux.get() != 4 && this.ux.get() != 3 && (!this.gd || this.f34271f.get())) {
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
        AtomicInteger atomicInteger = this.ux;
        if (atomicInteger == null) {
            return 1;
        }
        return atomicInteger.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void r() {
        c(0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void ux() {
    }

    private void r(JSONObject jSONObject) {
        ev(jSONObject);
        this.f34271f.set(true);
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
        c().c(s(), this.xv);
        if (!"feed_video_middle_page".equals(this.sr)) {
            TTMiddlePageActivity.w(getContext(), this.xv);
        }
        boolean c4 = com.bytedance.sdk.openadsdk.core.w.c.w.p.c();
        if (c4) {
            com.bytedance.sdk.openadsdk.core.w.c.w.p.c(false);
        }
        if (!c4) {
            if (new com.bytedance.sdk.openadsdk.core.w.c.w.p(this.xv, getContext()).c(this.sr).w(this.f34276p).c(new p.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.4
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
                public void w() {
                    ev.this.f(jSONObject);
                }
            })) {
                return;
            }
            f(jSONObject);
            return;
        }
        f(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void f() {
        com.bytedance.sdk.openadsdk.core.p.w.ux uxVar = this.f34280u;
        if (uxVar != null) {
            uxVar.w();
        }
        ys();
        HashSet<Integer> hashSet = this.fz;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.fz);
            this.fz.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.8
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        Bridge bridge = ev.this.bk;
                        if (bridge != null) {
                            bridge.call(3, b.b(1).h(0, new y().c("hid", Integer.valueOf(intValue))).l(), Void.class);
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.f34270c;
        if (weakReference != null) {
            weakReference.clear();
            this.f34270c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr() {
        if (ls.getContext() == null) {
            ls.c(getContext());
        }
        fp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void xv() {
        fp();
        bk();
    }

    private void ev(JSONObject jSONObject) {
        c(jSONObject);
    }

    private void w(Activity activity) {
        com.bytedance.sdk.openadsdk.core.eq.c xv = com.bytedance.sdk.openadsdk.core.k.sr().xv();
        if (xv != null && this.f34275n == null) {
            this.f34275n = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.9
                @Override // java.lang.Runnable
                public void run() {
                    ev.this.u();
                    ev.this.f34275n = null;
                }
            };
            xv.c(activity, this.f34275n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(final Map<String, Object> map) {
        int i4 = this.ck;
        if (i4 == 1) {
            return;
        }
        if (i4 == 2) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.15
                @Override // java.lang.Runnable
                public void run() {
                    ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                    ev evVar = ev.this;
                    com.bytedance.sdk.openadsdk.core.u.xv c5 = c4.c(evVar.xv, evVar.f34281w.w());
                    if (c5 == null || !c5.ux()) {
                        return;
                    }
                    q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                            ev.this.c((IDownloadButtonClickListener) null, map);
                        }
                    });
                }
            });
        } else {
            c((IDownloadButtonClickListener) null, map);
        }
    }

    private void sr(JSONObject jSONObject) {
        i();
        if (getContext() == null || this.f34281w == null || !ia()) {
            return;
        }
        final y<String, Object> c4 = new y().c("downloadUrl", this.f34281w.w()).c("id", Long.valueOf(this.fp.getId())).c("action_type_button", 2).c("downloadEventConfig", com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.ys, jSONObject)).c("downloadController", this.f34279t);
        if (w()) {
            IDownloadButtonClickListener iDownloadButtonClickListener = new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.10
                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z3) {
                }

                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (c4 == null || ev.this.f34279t == null) {
                        return;
                    }
                    ev.this.f34279t.setDownloadMode(0);
                    ev.this.c().c(ev.this.s());
                    c4.remove("downloadButtonClickListener");
                    if (ev.this.c((com.bytedance.sdk.openadsdk.core.u.xv) null, (IDownloadButtonClickListener) null, c4)) {
                        return;
                    }
                    ev.this.xv(c4);
                }
            };
            com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(c4, iDownloadButtonClickListener);
            if (c((com.bytedance.sdk.openadsdk.core.u.xv) null, iDownloadButtonClickListener, c4)) {
                return;
            }
            c(c4, iDownloadButtonClickListener);
            return;
        }
        w(c4);
    }

    private void w(IDownloadButtonClickListener iDownloadButtonClickListener, final Map<String, Object> map) {
        if (this.bk == null) {
            return;
        }
        final y<String, Object> c4 = new y().c("itemClickListener", null).c("downloadButtonClickListener", iDownloadButtonClickListener).c(map);
        if (eq.f33190w < 4500) {
            this.bk.call(17, b.a().h(0, c4).l(), Void.class);
            return;
        }
        c4.put("itemClickListener", new OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.13
            @Override // com.ss.android.download.api.config.OnItemClickListener
            public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                if (!ev.this.f34276p && !ev.this.xv.ds()) {
                    Context context = ev.this.getContext();
                    String pu = ev.this.xv.pu();
                    ev evVar = ev.this;
                    pr.c(context, pu, evVar.xv, wv.c(evVar.sr), ev.this.sr, (Map<String, Object>) null);
                    return;
                }
                Object obj = map.get("downloadEventConfig");
                if (obj instanceof DownloadEventConfig) {
                    ((DownloadEventConfig) obj).setDownloadScene(1);
                    c4.remove("itemClickListener");
                    ev.this.bk.call(17, b.a().h(0, c4).l(), Void.class);
                }
            }
        });
        this.bk.call(17, b.a().h(0, c4).l(), Void.class);
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
                wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
            }
            r(jSONObject);
            return true;
        }
        if (wv.f(getContext())) {
            wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
        }
        c(jSONObject);
        if (this.ux.get() != 3 && this.ux.get() != 4) {
            if (this.ux.get() == 6) {
                this.f34271f.set(true);
            }
        } else {
            this.f34271f.set(false);
        }
        return false;
    }

    private void gd(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f34281w;
        if (srVar == null || srVar.w() == null) {
            return;
        }
        xv(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, long j4, long j5, String str2, String str3) {
        c cVar = this.ls;
        if (cVar == null) {
            this.ls = new c(str, j4, j5, str2, str3);
        } else {
            cVar.c(str);
            this.ls.c(j4);
            this.ls.w(j5);
            this.ls.w(str2);
            this.ls.xv(str3);
        }
        com.bytedance.sdk.component.gd.ev.xv().execute(this.ls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(JSONObject jSONObject) {
        if (k()) {
            this.f34271f.set(true);
        } else if ((!this.f34276p || this.f34274k) && this.xv.ix() == null && this.xv.pu() != null && !this.xv.ja()) {
            pr.c(getContext(), this.xv.pu(), this.xv, wv.c(this.sr), this.sr, (Map<String, Object>) null);
        } else if (gd()) {
        } else {
            if (fz()) {
                this.f34271f.set(true);
            } else if (this.xv.ja()) {
            } else {
                gd(jSONObject);
            }
        }
    }

    private void w(final Map<String, Object> map) {
        int i4 = this.ck;
        if (i4 == 1) {
            if (gd()) {
                return;
            }
            k.c(ls.getContext());
        } else if (i4 != 2) {
            c((com.bytedance.sdk.openadsdk.core.u.xv) null, map);
        } else {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.14
                @Override // java.lang.Runnable
                public void run() {
                    ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                    ev evVar = ev.this;
                    com.bytedance.sdk.openadsdk.core.u.xv c5 = c4.c(evVar.xv, evVar.f34281w.w());
                    if (c5 != null && c5.ux()) {
                        ev.this.c(c5, map);
                    } else if (ev.this.gd()) {
                    } else {
                        k.c(ls.getContext());
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c() {
        if (this.gb == null) {
            synchronized (this) {
                if (this.gb == null) {
                    this.gb = new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(getContext(), this.xv);
                }
            }
        }
        return this.gb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void xv(boolean z3) {
        this.f34274k = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr(boolean z3) {
        AdDownloadController adDownloadController;
        if (eq.f33190w >= 5400 && z3) {
            this.f34283z = z3;
            if (w() && (adDownloadController = this.f34279t) != null) {
                try {
                    adDownloadController.setEnableOppoAutoDownload(true);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean w() {
        AdDownloadController adDownloadController = this.f34279t;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void w(final JSONObject jSONObject) {
        if (getContext() == null) {
            return;
        }
        me c4 = com.bytedance.sdk.openadsdk.core.w.c(jSONObject);
        this.xv = c4;
        if (com.bytedance.sdk.openadsdk.core.w.c.w.sr.c(c4, getContext()) && !com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.xv) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.xv)) {
            new com.bytedance.sdk.openadsdk.core.w.c.w.sr(this.xv, getContext()).c(this.sr).c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.3
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
                public void c() {
                    ev.this.ux(jSONObject);
                }
            });
        } else {
            ux(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f34270c = new WeakReference<>(activity);
        fp();
    }

    private void f(boolean z3) {
        if (z3) {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_fail");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(JSONObject jSONObject) {
        sr(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Map<String, Object> map, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.bytedance.sdk.openadsdk.core.p.ev.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.12
            @Override // java.lang.Runnable
            public void run() {
                ev.this.c(iDownloadButtonClickListener, map);
            }
        }, this.xv);
        this.f34283z = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IDownloadButtonClickListener iDownloadButtonClickListener, Map<String, Object> map) {
        try {
            if (iDownloadButtonClickListener == null) {
                c(map);
                this.f34283z = false;
                return;
            }
            w(iDownloadButtonClickListener, map);
            this.f34283z = false;
        } catch (Throwable unused) {
        }
    }

    private void w(int i4) {
        TTLiveCommerceHelper.getInstance().reportLiveRoomJumpResult(this.xv, this.sr, i4);
    }

    private void w(final com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv() || cVar == null) {
            return;
        }
        com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f fVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f(cVar);
                ia c5 = ia.c.c(c4.c(3));
                if (c5 != null) {
                    try {
                        c5.c(ev.this.f34273j, fVar);
                        synchronized (ev.this.f34282y) {
                            ev.this.f34282y.add(fVar);
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    private void c(Map<String, Object> map) {
        Bridge bridge = this.bk;
        if (bridge != null) {
            bridge.call(16, b.a().h(0, map).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void w(boolean z3) {
        this.f34276p = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.sdk.openadsdk.core.u.xv xvVar, final Map<String, Object> map) {
        c(new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.2
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z3) {
                if (z3 && ev.this.c(xvVar, (IDownloadButtonClickListener) null, map)) {
                    return;
                }
                ev.this.c((IDownloadButtonClickListener) null, map);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        }, map);
    }

    public void c(long j4) {
        if (this.f34281w == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.ia;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        if (this.bk != null) {
            this.bk.call(8, b.a().h(0, new y().c("downloadUrl", this.fp.getDownloadUrl()).c("force", Boolean.TRUE)).l(), Void.class);
        }
        fp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(me meVar, String str, String str2) {
        if (w()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean c(boolean z3) {
        this.f34277q = z3;
        return fz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, final IDownloadButtonClickListener iDownloadButtonClickListener, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c4 = c();
        if (c4.c()) {
            if (c(getContext(), this.xv, this.sr)) {
                return true;
            }
            c4.c(xvVar, this.sr, this.f34281w.w(), new com.bytedance.sdk.openadsdk.core.p.xv.c.w() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.ev.5
                @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.w
                public void c() {
                    if (ev.this.w()) {
                        ev.this.sr(true);
                        ev.this.c(map, iDownloadButtonClickListener);
                        return;
                    }
                    ev.this.c(iDownloadButtonClickListener, map);
                }
            });
            return true;
        }
        return false;
    }

    public boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (this.f34276p) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", str);
            }
            try {
                if (wv.xv(context, str)) {
                    try {
                        Intent w3 = wv.w(context, str);
                        if (w3 == null) {
                            return false;
                        }
                        wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                        w3.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(w3);
                        if (this.f34276p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl");
                        }
                        if (this.f34276p) {
                            com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.xv.pu() != null) {
                            pr.c(getContext(), this.xv.pu(), this.xv, wv.c(this.sr), this.sr, (Map<String, Object>) null);
                        }
                        if (this.f34276p) {
                            com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                        }
                        return true;
                    }
                } else if (this.f34276p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(String str, String str2, me meVar) {
        if (this.bk != null) {
            return ((Boolean) this.bk.call(2, b.a().h(0, new y().c("tagIntercept", str).c("label", str2).c("meta", meVar.mo().toString())).l(), Boolean.class)).booleanValue();
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
        com.bytedance.sdk.openadsdk.core.p.w.ux uxVar = this.f34280u;
        if (uxVar != null) {
            uxVar.c(cVar);
        }
        if (z3) {
            w(cVar);
        }
        fp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (this.fz == null) {
            this.fz = new HashSet<>();
        }
        this.fz.add(Integer.valueOf(i4));
        if (this.bk != null) {
            this.bk.call(9, b.a().h(0, new y().c("id", Integer.valueOf(i4)).c("onEventLogHandler", onEventLogHandler)).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4) {
        this.ck = i4;
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.k.sr() != null && !com.bytedance.sdk.openadsdk.core.k.sr().c()) {
            f(false);
            if (this.f34277q) {
                gd(me.ux(this.xv));
                return;
            }
            return;
        }
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }
}
