package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private SVSD f41586a;

    private boolean a() {
        if (this.f41586a == null) {
            try {
                if (com.qq.e.comm.managers.a.b().d()) {
                    SVSD aPKDownloadServiceDelegate = com.qq.e.comm.managers.a.b().c().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f41586a = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                }
            } catch (Throwable th) {
                GDTLogger.e("\u521d\u59cb\u5316Service\u53d1\u751f\u5f02\u5e38", th);
            }
        }
        return this.f41586a != null;
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage \u8c03\u7528\u5f02\u5e38\uff0ccontext\u4e3a\u7a7a");
            return;
        }
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !a()) {
            return null;
        }
        return this.f41586a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (intent == null) {
            stopSelf(i5);
            return 2;
        } else if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !a()) {
            GDTLogger.w("Service onStartCommand \u51fa\u73b0\u5f02\u5e38");
            return 2;
        } else {
            return this.f41586a.onStartCommand(intent, i4, i5);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        SVSD svsd = this.f41586a;
        if (svsd != null) {
            svsd.onTrimMemory(i4);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f41586a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
