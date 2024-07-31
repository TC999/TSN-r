package com.mbridge.msdk.pluginFramework;

import android.app.Service;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class PluginService extends Service {

    /* renamed from: a */
    protected PluginServiceAgent f31658a = null;

    /* renamed from: a */
    public abstract PluginServiceAgent mo21299a();

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        if (this.f31658a != null) {
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
        if (this.f31658a != null) {
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
            PluginServiceAgent mo21299a = mo21299a();
            this.f31658a = mo21299a;
            try {
                mo21299a.f31659a.f31660a.m21651a(this);
            } catch (Exception e) {
                SameLogTool.m21735b("PluginServiceContext", "invoke onDestroy error", e);
            }
            super.onCreate();
        } catch (Exception e2) {
            SameLogTool.m21735b("Download", "", e2);
        }
    }
}
