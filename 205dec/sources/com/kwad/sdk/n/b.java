package com.kwad.sdk.n;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends ContextThemeWrapper implements a {
    private final ContextThemeWrapper aTa;
    private Resources.Theme aiP;
    private int aiQ;
    private LayoutInflater mInflater;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.aTa = contextThemeWrapper;
        this.aiQ = l.getThemeResId(contextThemeWrapper);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return i.wrapContextIfNeed(StubApp.getOrigApplicationContext(this.aTa.getApplicationContext()));
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return e.NV().getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return i.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.n.a
    @NonNull
    public final Context getDelegatedContext() {
        return this.aTa;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return e.NV().getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = l.b(this.aTa, this);
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
        } catch (Exception e4) {
            e4.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aiP;
        if (theme2 == null || theme2 == theme) {
            this.aiP = i.replaceTheme(theme, theme2, this.aiQ);
        }
        return this.aiP;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTa.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        this.aiQ = i4;
        super.setTheme(i4);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTa.unregisterComponentCallbacks(componentCallbacks);
    }
}
