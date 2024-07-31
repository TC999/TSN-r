package com.kwad.library.p355b.p358c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.C11124s;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.library.b.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9599c extends ContextThemeWrapper implements InterfaceC9598b {
    private final ContextThemeWrapper aiO;
    private Resources.Theme aiP;
    private int aiQ;
    private String aiR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9599c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.aiO = contextThemeWrapper;
        this.aiR = str;
        try {
            Object callMethod = C11124s.callMethod(contextThemeWrapper, "getThemeResId", new Object[0]);
            if (callMethod != null) {
                this.aiQ = ((Integer) callMethod).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return C9596a.m28269h(StubApp.getOrigApplicationContext(this.aiO.getApplicationContext()), this.aiR);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aiO;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return C9596a.m28277a(super.getClassLoader(), this.aiR);
    }

    @Override // com.kwad.library.p355b.p358c.InterfaceC9598b
    public final Context getDelegatedContext() {
        return this.aiO;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return C9596a.m28279a(this.aiO.getResources(), this.aiR);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return C9596a.wrapSystemService(this.aiO.getSystemService(str), str, this);
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
            this.aiP = C9596a.m28280a(theme, theme2, this.aiQ, this.aiR);
        }
        return this.aiP;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aiO.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aiQ = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aiO.unregisterComponentCallbacks(componentCallbacks);
    }
}
