package com.bytedance.sdk.openadsdk.core.p;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.core.p.xv.f {

    /* renamed from: a  reason: collision with root package name */
    private HashSet<Integer> f34221a;
    private final String bk;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<Context> f34222c;
    private Map<String, Object> fp;
    private AdDownloadController gd;

    /* renamed from: p  reason: collision with root package name */
    private DownloadModel f34225p;
    com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w sr;

    /* renamed from: t  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.p.xv.xv.xv f34226t;

    /* renamed from: w  reason: collision with root package name */
    protected me f34227w;
    protected String xv;
    private volatile Runnable ys;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicBoolean f34224k = new AtomicBoolean(false);
    protected volatile boolean ux = false;
    private List<u> ia = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    protected Bridge f34223f = k.sr().u();

    public c(Context context, me meVar, String str) {
        this.f34222c = new WeakReference<>(context);
        this.f34227w = meVar;
        str = TextUtils.isEmpty(str) ? wv.c(this.f34227w) : str;
        this.xv = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        String str2 = this.f34227w.hashCode() + this.f34227w.xq();
        this.bk = str2;
        com.bytedance.sdk.openadsdk.core.u.sr ix = this.f34227w.ix();
        if (ix == null) {
            return;
        }
        if (ls.getContext() == null) {
            ls.c(context);
        }
        this.sr = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w(str2, ix.xv());
        this.f34225p = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.xv, this.f34227w, null).build();
        this.gd = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.f34227w).build();
        Map<String, Object> c4 = com.bytedance.sdk.component.p.ux.c.c().c(str2);
        this.fp = c4;
        c4.put("download_model", this.f34225p);
        this.fp.put("download_controller", this.gd);
        this.fp.put(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL, ix.w());
        this.fp.put("download_status_listener", this.sr);
        this.fp.put("event_tag", this.xv);
        this.fp.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.ev.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.p.c.1
            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
            public boolean c(Map<String, Object> map) {
                c cVar = c.this;
                Context context2 = cVar.getContext();
                c cVar2 = c.this;
                return cVar.c(context2, cVar2.f34227w, cVar2.xv);
            }
        });
        this.fp.put("download_popup_manager", c());
        xv();
    }

    private synchronized void a() {
        AtomicBoolean atomicBoolean = this.f34224k;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.f34224k.set(false);
            if (this.f34223f != null) {
                this.f34223f.call(4, b.b(1).h(0, new y().c("hashCode", Integer.valueOf(hashCode())).c("downloadUrl", this.f34225p.getDownloadUrl())).l(), Void.class);
            }
        }
        k();
    }

    private synchronized void bk() {
        this.f34224k.set(true);
        if (this.f34223f != null) {
            this.f34223f.call(5, b.a().h(0, new y().c("hashCode", Integer.valueOf(hashCode())).c("downloadStatusChangeListener", this.sr).c("downloadModel", this.f34225p)).l(), Void.class);
        }
    }

    private void k() {
        if (this.f34222c == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && k.sr().c(activity)) {
            w(activity);
        } else {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.c.5
                @Override // java.lang.Runnable
                public void run() {
                    ia c4 = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(3));
                    try {
                        synchronized (c.this.ia) {
                            if (c4 != null && c.this.ia.size() > 0) {
                                for (u uVar : c.this.ia) {
                                    c4.w(c.this.bk, uVar);
                                }
                                c.this.ia.clear();
                            }
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean c(boolean z3) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean ev() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void f() {
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w wVar = this.sr;
        if (wVar != null) {
            wVar.w();
        }
        Map<String, Object> map = this.fp;
        if (map != null) {
            map.clear();
        }
        a();
        HashSet<Integer> hashSet = this.f34221a;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.f34221a);
            this.f34221a.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.n.f.c(new p("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.p.c.2
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        Bridge bridge = c.this.f34223f;
                        if (bridge != null) {
                            bridge.call(3, b.b(1).h(0, new y().c("hid", Integer.valueOf(intValue))).l(), Void.class);
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.f34222c;
        if (weakReference != null) {
            weakReference.clear();
            this.f34222c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean gd() {
        return false;
    }

    protected Context getContext() {
        try {
            WeakReference<Context> weakReference = this.f34222c;
            if (weakReference == null) {
                return ls.getContext();
            }
            Context context = weakReference.get();
            return context == null ? ls.getContext() : context;
        } catch (Throwable unused) {
            return ls.getContext();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public int p() {
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w wVar = this.sr;
        if (wVar == null) {
            return 1;
        }
        return wVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void r() {
        AtomicBoolean atomicBoolean = this.f34224k;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        if (this.f34223f != null) {
            this.f34223f.call(8, b.a().h(0, new y().c("downloadUrl", this.f34225p.getDownloadUrl()).c("force", Boolean.TRUE)).l(), Void.class);
        }
        bk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr() {
        if (ls.getContext() == null) {
            ls.c(getContext());
        }
        bk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void ux() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean w() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean xv(JSONObject jSONObject) {
        return false;
    }

    private void w(Activity activity) {
        com.bytedance.sdk.openadsdk.core.eq.c xv = k.sr().xv();
        if (xv != null && this.ys == null) {
            this.ys = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.t();
                    c.this.ys = null;
                }
            };
            xv.c(activity, this.ys);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void xv() {
        bk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void xv(boolean z3) {
        this.ux = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c() {
        if (this.f34226t == null) {
            synchronized (this) {
                if (this.f34226t == null) {
                    this.f34226t = new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(getContext(), this.f34227w);
                }
            }
        }
        return this.f34226t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr(boolean z3) {
        this.fp.put("is_open_oppo_market_auto_download", Boolean.valueOf(z3));
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void w(JSONObject jSONObject) {
        if (getContext() == null) {
            return;
        }
        c(jSONObject);
    }

    private void w(final com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv() || cVar == null) {
            return;
        }
        com.bytedance.sdk.component.gd.ev.xv().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.c c4 = com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f fVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.f(cVar);
                ia c5 = ia.c.c(c4.c(3));
                if (c5 != null) {
                    try {
                        c5.c(c.this.bk, fVar);
                        synchronized (c.this.ia) {
                            c.this.ia.add(fVar);
                        }
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f34222c = new WeakReference<>(activity);
        bk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.f
    public void w(boolean z3) {
        this.fp.put("convert_from_landing_page", Boolean.valueOf(z3));
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
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w wVar = this.sr;
        if (wVar != null) {
            wVar.c(cVar);
        }
        if (z3) {
            w(cVar);
        }
        bk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (this.f34221a == null) {
            this.f34221a = new HashSet<>();
        }
        this.f34221a.add(Integer.valueOf(i4));
        if (this.f34223f != null) {
            this.f34223f.call(9, b.a().h(0, new y().c("id", Integer.valueOf(i4)).c("onEventLogHandler", onEventLogHandler)).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4) {
        this.fp.put("need_check_compliance", Integer.valueOf(i4));
    }
}
