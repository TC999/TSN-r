package com.mbridge.msdk.pluginFramework;

import android.content.Intent;
import android.os.IBinder;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.c;

/* compiled from: PluginServiceAgent.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0760a f40430a;

    public a(C0760a c0760a) {
        this.f40430a = c0760a;
    }

    /* compiled from: PluginServiceAgent.java */
    /* renamed from: com.mbridge.msdk.pluginFramework.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0760a {

        /* renamed from: a  reason: collision with root package name */
        c f40431a;

        public C0760a(c cVar) {
            this.f40431a = cVar;
        }

        public final IBinder a(Intent intent) {
            try {
                return this.f40431a.a(intent);
            } catch (Exception e4) {
                x.b("PluginServiceContext", "invoke onBind error", e4);
                return null;
            }
        }

        public final void b() {
            try {
                this.f40431a.b();
            } catch (Exception e4) {
                x.b("PluginServiceContext", "invoke onDestroy error", e4);
            }
        }

        public final int a(Intent intent, int i4, int i5) {
            try {
                return this.f40431a.a(intent, i4, i5);
            } catch (Exception e4) {
                x.b("PluginServiceContext", "invoke onStartCommand error", e4);
                return 0;
            }
        }

        public final void a() {
            try {
                this.f40431a.a();
            } catch (Exception e4) {
                x.b("PluginServiceContext", "invoke onCreate error", e4);
            }
        }
    }
}
