package com.ss.android.downloadlib.ok.ok;

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
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.ok.ok.bl;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: h  reason: collision with root package name */
    private static volatile ok f48870h = null;
    private static String kf = "";

    /* renamed from: n  reason: collision with root package name */
    private static String f48871n = "";

    /* renamed from: s  reason: collision with root package name */
    private static String f48872s = "";
    public bl ok;

    /* renamed from: r  reason: collision with root package name */
    private Context f48878r;

    /* renamed from: p  reason: collision with root package name */
    private boolean f48876p = true;

    /* renamed from: q  reason: collision with root package name */
    private boolean f48877q = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f48875k = false;

    /* renamed from: j  reason: collision with root package name */
    private final List<Pair<a, s>> f48874j = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0954ok> f48873a = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private final ServiceConnection f48879z = new ServiceConnection() { // from class: com.ss.android.downloadlib.ok.ok.ok.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (ok.this.bl) {
                ok.this.ok(false);
                ok.this.ok = bl.ok.ok(iBinder);
                ok.this.bl();
                for (InterfaceC0954ok interfaceC0954ok : ok.this.f48873a) {
                    interfaceC0954ok.ok();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (ok.this.bl) {
                ok.this.ok(false);
                ok okVar = ok.this;
                okVar.ok = null;
                for (InterfaceC0954ok interfaceC0954ok : okVar.f48873a) {
                    interfaceC0954ok.a();
                }
            }
        }
    };
    private String rh = "";
    public final Object bl = new Object();

    /* renamed from: com.ss.android.downloadlib.ok.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC0954ok {
        void a();

        void ok();
    }

    private ok() {
    }

    public static ok ok() {
        if (f48870h == null) {
            synchronized (ok.class) {
                if (f48870h == null) {
                    f48870h = new ok();
                }
            }
        }
        return f48870h;
    }

    public void a() {
        if (this.ok != null) {
            this.f48878r.unbindService(this.f48879z);
            this.ok = null;
        }
        this.f48873a.clear();
        this.f48874j.clear();
    }

    public void bl() {
        for (Pair<a, s> pair : this.f48874j) {
            try {
                this.ok.ok((a) pair.first, (s) pair.second);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
        this.f48874j.clear();
    }

    public boolean s() {
        return this.f48875k;
    }

    public boolean ok(Context context, boolean z3) {
        if (TextUtils.isEmpty(f48872s)) {
            JSONObject q3 = r.q();
            String optString = q3.optString("s");
            f48872s = com.ss.android.socialbase.appdownloader.kf.bl.ok(q3.optString(CampaignEx.JSON_KEY_AD_Q), optString);
            f48871n = com.ss.android.socialbase.appdownloader.kf.bl.ok(q3.optString("u"), optString);
            kf = com.ss.android.socialbase.appdownloader.kf.bl.ok(q3.optString("w"), optString);
        }
        this.f48877q = z3;
        if (context != null) {
            this.f48878r = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (TextUtils.isEmpty(kf)) {
                kf = this.f48878r.getPackageName();
            }
            if (this.ok != null || s()) {
                return true;
            }
            return this.f48878r.bindService(ok(context), this.f48879z, 33);
        }
        return true;
    }

    public Intent ok(Context context) {
        Intent intent = new Intent();
        intent.setAction(f48872s);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f48871n.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void ok(a aVar, s sVar) {
        synchronized (this.bl) {
            aVar.f48868n = kf;
            if (TextUtils.isEmpty(aVar.kf)) {
                aVar.kf = this.rh;
            }
            bl blVar = this.ok;
            if (blVar != null) {
                try {
                    blVar.ok(aVar, sVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            } else if (s() || ok(this.f48878r, this.f48877q)) {
                this.f48874j.add(Pair.create(aVar, sVar));
            }
        }
    }

    public void ok(boolean z3) {
        this.f48875k = z3;
    }
}
