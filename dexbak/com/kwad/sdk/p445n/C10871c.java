package com.kwad.sdk.p445n;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.n.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10871c extends ContextThemeWrapper implements InterfaceC10869a {
    private final ContextThemeWrapper aTb;
    private Resources.Theme aiP;
    private int aiQ;
    private LayoutInflater mInflater;

    public C10871c(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.aTb = contextThemeWrapper;
        this.aiQ = C10887l.getThemeResId(contextThemeWrapper);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return C10878i.wrapContextIfNeed(StubApp.getOrigApplicationContext(this.aTb.getApplicationContext()));
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
        return this.aTb;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return C10873e.m24602NV().getResources();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = C10887l.m24560b(this.aTb, this);
            }
            return this.mInflater;
        }
        return this.aTb.getSystemService(str);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
        this.aTb.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aiQ = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aTb.unregisterComponentCallbacks(componentCallbacks);
    }
}
