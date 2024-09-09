package com.mbridge.msdk.shell;

import android.content.Intent;
import android.os.IBinder;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.c;
import com.mbridge.msdk.pluginFramework.PluginService;
import com.mbridge.msdk.pluginFramework.a;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBService extends PluginService {
    @Override // com.mbridge.msdk.pluginFramework.PluginService
    public final a a() {
        try {
            return new a(new a.C0760a(new c()));
        } catch (Exception e4) {
            x.b("Download", "Find Provider Error", e4);
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f40429a.f40430a.a(intent);
    }

    @Override // com.mbridge.msdk.pluginFramework.PluginService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f40429a.f40430a.a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f40429a.f40430a.b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return this.f40429a.f40430a.a(intent, i4, i5);
    }
}
