package com.kwad.sdk.p445n;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.n.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10870b extends ContextThemeWrapper implements InterfaceC10869a {
    private final ContextThemeWrapper aTa;
    private Resources.Theme aiP;
    private int aiQ;
    private LayoutInflater mInflater;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C10870b(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.aTa = contextThemeWrapper;
        this.aiQ = C10887l.getThemeResId(contextThemeWrapper);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return C10878i.wrapContextIfNeed(StubApp.getOrigApplicationContext(this.aTa.getApplicationContext()));
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return C10873e.m24602NV().getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return C10878i.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.p445n.InterfaceC10869a
    @NonNull
    public final Context getDelegatedContext() {
        return this.aTa;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return C10873e.m24602NV().getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = C10887l.m24560b(this.aTa, this);
            }
            return this.mInflater;
        }
        return this.aTa.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aiP;
        if (theme2 == null || theme2 == theme) {
            this.aiP = C10878i.replaceTheme(theme, theme2, this.aiQ);
        }
        return this.aiP;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTa.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aiQ = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTa.unregisterComponentCallbacks(componentCallbacks);
    }
}
