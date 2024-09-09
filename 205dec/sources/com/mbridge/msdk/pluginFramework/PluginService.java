package com.mbridge.msdk.pluginFramework;

import android.app.Service;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.mbridge.msdk.foundation.tools.x;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class PluginService extends Service {

    /* renamed from: a  reason: collision with root package name */
    protected a f40429a = null;

    public abstract a a();

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        if (this.f40429a != null) {
            return null;
        }
        return super.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f40429a != null) {
            try {
                return super.getResources();
            } catch (Exception unused) {
                return super.getResources();
            }
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            a a4 = a();
            this.f40429a = a4;
            try {
                a4.f40430a.f40431a.a(this);
            } catch (Exception e4) {
                x.b("PluginServiceContext", "invoke onDestroy error", e4);
            }
            super.onCreate();
        } catch (Exception e5) {
            x.b("Download", "", e5);
        }
    }
}
