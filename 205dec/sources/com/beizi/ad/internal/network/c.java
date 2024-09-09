package com.beizi.ad.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.beizi.ad.internal.utilities.HTTPGet;
import com.beizi.ad.internal.utilities.HTTPResponse;
import com.beizi.ad.internal.utilities.HttpErrorCode;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SharedNetworkManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f14005a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<a> f14006b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Timer f14007c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14008d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SharedNetworkManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f14013a;

        /* renamed from: b  reason: collision with root package name */
        int f14014b = 0;

        a(String str) {
            this.f14013a = str;
        }
    }

    private c(Context context) {
        if (context != null) {
            this.f14008d = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        }
    }

    private void c(Context context) {
        if (this.f14007c == null) {
            final WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.f14007c = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.beizi.ad.internal.network.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null) {
                        while (!c.this.f14006b.isEmpty() && c.this.b(context2)) {
                            final a aVar = (a) c.this.f14006b.remove(0);
                            if (aVar.f14014b < 3) {
                                new HTTPGet(false, true) { // from class: com.beizi.ad.internal.network.c.1.1
                                    @Override // com.beizi.ad.internal.utilities.HTTPGet
                                    protected String getUrl() {
                                        return aVar.f14013a;
                                    }

                                    /* JADX INFO: Access modifiers changed from: protected */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.beizi.ad.internal.utilities.HTTPGet, android.os.AsyncTask
                                    public void onPostExecute(HTTPResponse hTTPResponse) {
                                        if (hTTPResponse == null || (!hTTPResponse.getSucceeded() && hTTPResponse.getErrorCode() == HttpErrorCode.CONNECTION_FAILURE)) {
                                            aVar.f14014b++;
                                            c.this.f14006b.add(aVar);
                                        }
                                    }
                                }.execute(new Void[0]);
                            }
                        }
                        if (c.this.f14006b.isEmpty()) {
                            c.this.a();
                            return;
                        }
                        return;
                    }
                    c.this.a();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    public static c a(Context context) {
        if (f14005a == null) {
            f14005a = new c(context);
        }
        return f14005a;
    }

    public boolean b(Context context) {
        try {
            if (this.f14008d) {
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

    public synchronized void a(String str, Context context) {
        this.f14006b.add(new a(str));
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.f14007c;
        if (timer != null) {
            timer.cancel();
            this.f14007c = null;
        }
    }
}
