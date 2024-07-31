package com.p518qq.p519e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.p518qq.p519e.comm.managers.C11815a;
import com.p518qq.p519e.comm.p520pi.SVSD;
import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.DownloadService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadService extends Service {

    /* renamed from: a */
    private SVSD f32871a;

    /* renamed from: a */
    private boolean m20363a() {
        if (this.f32871a == null) {
            try {
                if (C11815a.m20349b().m20347d()) {
                    SVSD aPKDownloadServiceDelegate = C11815a.m20349b().m20348c().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f32871a = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                }
            } catch (Throwable th) {
                GDTLogger.m20306e("初始化Service发生异常", th);
            }
        }
        return this.f32871a != null;
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.m20307e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("GDT_APPID", C11815a.m20349b().m20354a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.m20308d("DownloadService.onBind");
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.m20308d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !m20363a()) {
            return null;
        }
        return this.f32871a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f32871a;
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
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        } else if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !m20363a()) {
            GDTLogger.m20304w("Service onStartCommand 出现异常");
            return 2;
        } else {
            return this.f32871a.onStartCommand(intent, i, i2);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.f32871a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f32871a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
