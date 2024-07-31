package com.mbridge.msdk.shell;

import android.content.Intent;
import android.os.IBinder;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.DownloadProvider;
import com.mbridge.msdk.pluginFramework.PluginService;
import com.mbridge.msdk.pluginFramework.PluginServiceAgent;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBService extends PluginService {
    @Override // com.mbridge.msdk.pluginFramework.PluginService
    /* renamed from: a */
    public final PluginServiceAgent mo21299a() {
        try {
            return new PluginServiceAgent(new PluginServiceAgent.C11550a(new DownloadProvider()));
        } catch (Exception e) {
            SameLogTool.m21735b("Download", "Find Provider Error", e);
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f31658a.f31659a.m21329a(intent);
    }

    @Override // com.mbridge.msdk.pluginFramework.PluginService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f31658a.f31659a.m21330a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f31658a.f31659a.m21327b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return this.f31658a.f31659a.m21328a(intent, i, i2);
    }
}
