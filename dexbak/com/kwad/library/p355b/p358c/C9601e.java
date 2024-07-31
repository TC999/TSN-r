package com.kwad.library.p355b.p358c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.library.b.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9601e extends ContextWrapper implements InterfaceC9598b {
    private Resources.Theme aiP;
    private int aiQ;
    private String aiR;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9601e(Context context, String str) {
        super(context);
        this.aiQ = -1;
        this.mContext = context;
        this.aiR = str;
        this.aiQ = C9596a.getThemeResId(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return C9596a.m28269h(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.aiR);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return C9596a.m28277a(super.getClassLoader(), this.aiR);
    }

    @Override // com.kwad.library.p355b.p358c.InterfaceC9598b
    public final Context getDelegatedContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return C9596a.m28279a(this.mContext.getResources(), this.aiR);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return C9596a.wrapSystemService(super.getSystemService(str), str, this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
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
        this.mContext.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aiQ = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.unregisterComponentCallbacks(componentCallbacks);
    }
}
