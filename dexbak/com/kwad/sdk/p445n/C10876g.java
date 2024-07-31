package com.kwad.sdk.p445n;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

/* renamed from: com.kwad.sdk.n.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C10876g extends ContextThemeWrapper {
    private final Context aTc;
    private final C10873e aTl;
    private ApplicationC10875f aTm;
    private LayoutInflater mInflater;

    public C10876g(Context context, C10873e c10873e) {
        super(context, C10887l.getThemeResId(context));
        this.aTc = context;
        this.aTl = c10873e;
    }

    @Override // android.view.ContextThemeWrapper
    public final void applyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createConfigurationContext(Configuration configuration) {
        return C10887l.wrapContextIfNeed(super.createConfigurationContext(configuration));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        ApplicationC10875f applicationC10875f = this.aTm;
        if (applicationC10875f != null) {
            return applicationC10875f;
        }
        Context context = this.aTc;
        if (context instanceof ApplicationC10875f) {
            ApplicationC10875f applicationC10875f2 = (ApplicationC10875f) context;
            this.aTm = applicationC10875f2;
            return applicationC10875f2;
        } else if (context instanceof Application) {
            ApplicationC10875f applicationC10875f3 = (ApplicationC10875f) C10887l.wrapContextIfNeed(context);
            this.aTm = applicationC10875f3;
            return applicationC10875f3;
        } else {
            return C10887l.wrapContextIfNeed(context);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.aTl.getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aTl.getClassLoader();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aTl.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = C10887l.m24560b(this.aTc, this);
            }
            return this.mInflater;
        }
        return this.aTc.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTc.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTc.unregisterComponentCallbacks(componentCallbacks);
    }
}
