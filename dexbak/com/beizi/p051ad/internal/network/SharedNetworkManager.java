package com.beizi.p051ad.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.internal.utilities.HttpErrorCode;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.beizi.ad.internal.network.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SharedNetworkManager {

    /* renamed from: a */
    private static SharedNetworkManager f10396a;

    /* renamed from: b */
    private ArrayList<C2921a> f10397b = new ArrayList<>();

    /* renamed from: c */
    private Timer f10398c;

    /* renamed from: d */
    private boolean f10399d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SharedNetworkManager.java */
    /* renamed from: com.beizi.ad.internal.network.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2921a {

        /* renamed from: a */
        String f10404a;

        /* renamed from: b */
        int f10405b = 0;

        C2921a(String str) {
            this.f10404a = str;
        }
    }

    private SharedNetworkManager(Context context) {
        if (context != null) {
            this.f10399d = context.getPackageManager().checkPermission(C7282g.f24944b, context.getPackageName()) == 0;
        }
    }

    /* renamed from: c */
    private void m49299c(Context context) {
        if (this.f10398c == null) {
            final WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.f10398c = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.beizi.ad.internal.network.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null) {
                        while (!SharedNetworkManager.this.f10397b.isEmpty() && SharedNetworkManager.this.m49301b(context2)) {
                            final C2921a c2921a = (C2921a) SharedNetworkManager.this.f10397b.remove(0);
                            if (c2921a.f10405b < 3) {
                                new HTTPGet(false, true) { // from class: com.beizi.ad.internal.network.c.1.1
                                    @Override // com.beizi.p051ad.internal.utilities.HTTPGet
                                    protected String getUrl() {
                                        return c2921a.f10404a;
                                    }

                                    /* JADX INFO: Access modifiers changed from: protected */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.beizi.p051ad.internal.utilities.HTTPGet, android.os.AsyncTask
                                    public void onPostExecute(HTTPResponse hTTPResponse) {
                                        if (hTTPResponse == null || (!hTTPResponse.getSucceeded() && hTTPResponse.getErrorCode() == HttpErrorCode.CONNECTION_FAILURE)) {
                                            c2921a.f10405b++;
                                            SharedNetworkManager.this.f10397b.add(c2921a);
                                        }
                                    }
                                }.execute(new Void[0]);
                            }
                        }
                        if (SharedNetworkManager.this.f10397b.isEmpty()) {
                            SharedNetworkManager.this.m49305a();
                            return;
                        }
                        return;
                    }
                    SharedNetworkManager.this.m49305a();
                }
            }, 10000L, 10000L);
        }
    }

    /* renamed from: a */
    public static SharedNetworkManager m49304a(Context context) {
        if (f10396a == null) {
            f10396a = new SharedNetworkManager(context);
        }
        return f10396a;
    }

    /* renamed from: b */
    public boolean m49301b(Context context) {
        try {
            if (this.f10399d) {
                if (context != null) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
                    NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                    if (activeNetworkInfo != null) {
                        if (activeNetworkInfo.isConnected()) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: a */
    public synchronized void m49302a(String str, Context context) {
        this.f10397b.add(new C2921a(str));
        m49299c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49305a() {
        Timer timer = this.f10398c;
        if (timer != null) {
            timer.cancel();
            this.f10398c = null;
        }
    }
}
