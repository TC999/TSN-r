package com.mbridge.msdk.pluginFramework;

import android.content.Intent;
import android.os.IBinder;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.DownloadProvider;

/* renamed from: com.mbridge.msdk.pluginFramework.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class PluginServiceAgent {

    /* renamed from: a */
    public C11550a f31659a;

    public PluginServiceAgent(C11550a c11550a) {
        this.f31659a = c11550a;
    }

    /* compiled from: PluginServiceAgent.java */
    /* renamed from: com.mbridge.msdk.pluginFramework.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11550a {

        /* renamed from: a */
        DownloadProvider f31660a;

        public C11550a(DownloadProvider downloadProvider) {
            this.f31660a = downloadProvider;
        }

        /* renamed from: a */
        public final IBinder m21329a(Intent intent) {
            try {
                return this.f31660a.m21650a(intent);
            } catch (Exception e) {
                SameLogTool.m21735b("PluginServiceContext", "invoke onBind error", e);
                return null;
            }
        }

        /* renamed from: b */
        public final void m21327b() {
            try {
                this.f31660a.m21645b();
            } catch (Exception e) {
                SameLogTool.m21735b("PluginServiceContext", "invoke onDestroy error", e);
            }
        }

        /* renamed from: a */
        public final int m21328a(Intent intent, int i, int i2) {
            try {
                return this.f31660a.m21649a(intent, i, i2);
            } catch (Exception e) {
                SameLogTool.m21735b("PluginServiceContext", "invoke onStartCommand error", e);
                return 0;
            }
        }

        /* renamed from: a */
        public final void m21330a() {
            try {
                this.f31660a.m21656a();
            } catch (Exception e) {
                SameLogTool.m21735b("PluginServiceContext", "invoke onCreate error", e);
            }
        }
    }
}
