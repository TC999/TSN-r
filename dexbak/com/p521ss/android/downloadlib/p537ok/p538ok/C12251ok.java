package com.p521ss.android.downloadlib.p537ok.p538ok;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p537ok.p538ok.InterfaceC12248bl;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12251ok {

    /* renamed from: h */
    private static volatile C12251ok f34549h = null;

    /* renamed from: kf */
    private static String f34550kf = "";

    /* renamed from: n */
    private static String f34551n = "";

    /* renamed from: s */
    private static String f34552s = "";

    /* renamed from: ok */
    public InterfaceC12248bl f34557ok;

    /* renamed from: r */
    private Context f34560r;

    /* renamed from: p */
    private boolean f34558p = true;

    /* renamed from: q */
    private boolean f34559q = false;

    /* renamed from: k */
    private volatile boolean f34556k = false;

    /* renamed from: j */
    private final List<Pair<C12246a, InterfaceC12254s>> f34555j = new ArrayList();

    /* renamed from: a */
    public final List<InterfaceC12253ok> f34553a = new ArrayList();

    /* renamed from: z */
    private final ServiceConnection f34562z = new ServiceConnection() { // from class: com.ss.android.downloadlib.ok.ok.ok.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (C12251ok.this.f34554bl) {
                C12251ok.this.m18589ok(false);
                C12251ok.this.f34557ok = InterfaceC12248bl.AbstractBinderC12249ok.m18598ok(iBinder);
                C12251ok.this.m18594bl();
                for (InterfaceC12253ok interfaceC12253ok : C12251ok.this.f34553a) {
                    interfaceC12253ok.m18586ok();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (C12251ok.this.f34554bl) {
                C12251ok.this.m18589ok(false);
                C12251ok c12251ok = C12251ok.this;
                c12251ok.f34557ok = null;
                for (InterfaceC12253ok interfaceC12253ok : c12251ok.f34553a) {
                    interfaceC12253ok.m18587a();
                }
            }
        }
    };

    /* renamed from: rh */
    private String f34561rh = "";

    /* renamed from: bl */
    public final Object f34554bl = new Object();

    /* renamed from: com.ss.android.downloadlib.ok.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12253ok {
        /* renamed from: a */
        void m18587a();

        /* renamed from: ok */
        void m18586ok();
    }

    private C12251ok() {
    }

    /* renamed from: ok */
    public static C12251ok m18593ok() {
        if (f34549h == null) {
            synchronized (C12251ok.class) {
                if (f34549h == null) {
                    f34549h = new C12251ok();
                }
            }
        }
        return f34549h;
    }

    /* renamed from: a */
    public void m18595a() {
        if (this.f34557ok != null) {
            this.f34560r.unbindService(this.f34562z);
            this.f34557ok = null;
        }
        this.f34553a.clear();
        this.f34555j.clear();
    }

    /* renamed from: bl */
    public void m18594bl() {
        for (Pair<C12246a, InterfaceC12254s> pair : this.f34555j) {
            try {
                this.f34557ok.mo18596ok((C12246a) pair.first, (InterfaceC12254s) pair.second);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.f34555j.clear();
    }

    /* renamed from: s */
    public boolean m18588s() {
        return this.f34556k;
    }

    /* renamed from: ok */
    public boolean m18591ok(Context context, boolean z) {
        if (TextUtils.isEmpty(f34552s)) {
            JSONObject m18946q = C12128r.m18946q();
            String optString = m18946q.optString("s");
            f34552s = C12315bl.m18260ok(m18946q.optString(CampaignEx.JSON_KEY_AD_Q), optString);
            f34551n = C12315bl.m18260ok(m18946q.optString("u"), optString);
            f34550kf = C12315bl.m18260ok(m18946q.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.f34559q = z;
        if (context != null) {
            this.f34560r = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (TextUtils.isEmpty(f34550kf)) {
                f34550kf = this.f34560r.getPackageName();
            }
            if (this.f34557ok != null || m18588s()) {
                return true;
            }
            return this.f34560r.bindService(m18592ok(context), this.f34562z, 33);
        }
        return true;
    }

    /* renamed from: ok */
    public Intent m18592ok(Context context) {
        Intent intent = new Intent();
        intent.setAction(f34552s);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f34551n.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public void m18590ok(C12246a c12246a, InterfaceC12254s interfaceC12254s) {
        synchronized (this.f34554bl) {
            c12246a.f34544n = f34550kf;
            if (TextUtils.isEmpty(c12246a.f34543kf)) {
                c12246a.f34543kf = this.f34561rh;
            }
            InterfaceC12248bl interfaceC12248bl = this.f34557ok;
            if (interfaceC12248bl != null) {
                try {
                    interfaceC12248bl.mo18596ok(c12246a, interfaceC12254s);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (m18588s() || m18591ok(this.f34560r, this.f34559q)) {
                this.f34555j.add(Pair.create(c12246a, interfaceC12254s));
            }
        }
    }

    /* renamed from: ok */
    public void m18589ok(boolean z) {
        this.f34556k = z;
    }
}
