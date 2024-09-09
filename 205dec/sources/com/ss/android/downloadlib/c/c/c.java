package com.ss.android.downloadlib.c.c;

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
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.c.c.xv;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    private static String f48770f = "";

    /* renamed from: r  reason: collision with root package name */
    private static volatile c f48771r = null;
    private static String sr = "";
    private static String ux = "";

    /* renamed from: c  reason: collision with root package name */
    public xv f48773c;

    /* renamed from: k  reason: collision with root package name */
    private Context f48774k;
    private boolean ev = true;
    private boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f48775p = false;

    /* renamed from: a  reason: collision with root package name */
    private final List<Pair<w, sr>> f48772a = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    public final List<InterfaceC0947c> f48777w = new ArrayList();
    private final ServiceConnection bk = new ServiceConnection() { // from class: com.ss.android.downloadlib.c.c.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.xv) {
                c.this.c(false);
                c.this.f48773c = xv.c.c(iBinder);
                c.this.xv();
                for (InterfaceC0947c interfaceC0947c : c.this.f48777w) {
                    interfaceC0947c.c();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.xv) {
                c.this.c(false);
                c cVar = c.this;
                cVar.f48773c = null;
                for (InterfaceC0947c interfaceC0947c : cVar.f48777w) {
                    interfaceC0947c.w();
                }
            }
        }
    };

    /* renamed from: t  reason: collision with root package name */
    private String f48776t = "";
    public final Object xv = new Object();

    /* renamed from: com.ss.android.downloadlib.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC0947c {
        void c();

        void w();
    }

    private c() {
    }

    public static c c() {
        if (f48771r == null) {
            synchronized (c.class) {
                if (f48771r == null) {
                    f48771r = new c();
                }
            }
        }
        return f48771r;
    }

    public boolean sr() {
        return this.f48775p;
    }

    public void w() {
        if (this.f48773c != null) {
            this.f48774k.unbindService(this.bk);
            this.f48773c = null;
        }
        this.f48777w.clear();
        this.f48772a.clear();
    }

    public void xv() {
        for (Pair<w, sr> pair : this.f48772a) {
            try {
                this.f48773c.c((w) pair.first, (sr) pair.second);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
        this.f48772a.clear();
    }

    public boolean c(Context context, boolean z3) {
        if (TextUtils.isEmpty(sr)) {
            JSONObject gd = k.gd();
            String optString = gd.optString("s");
            sr = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString(CampaignEx.JSON_KEY_AD_Q), optString);
            ux = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("u"), optString);
            f48770f = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("w"), optString);
        }
        this.gd = z3;
        if (context != null) {
            this.f48774k = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (TextUtils.isEmpty(f48770f)) {
                f48770f = this.f48774k.getPackageName();
            }
            if (this.f48773c != null || sr()) {
                return true;
            }
            return this.f48774k.bindService(c(context), this.bk, 33);
        }
        return true;
    }

    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction(sr);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (ux.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void c(w wVar, sr srVar) {
        synchronized (this.xv) {
            wVar.ux = f48770f;
            if (TextUtils.isEmpty(wVar.f48782f)) {
                wVar.f48782f = this.f48776t;
            }
            xv xvVar = this.f48773c;
            if (xvVar != null) {
                try {
                    xvVar.c(wVar, srVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            } else if (sr() || c(this.f48774k, this.gd)) {
                this.f48772a.add(Pair.create(wVar, srVar));
            }
        }
    }

    public void c(boolean z3) {
        this.f48775p = z3;
    }
}
