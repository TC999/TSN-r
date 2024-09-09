package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e extends ContextWrapper implements b {
    private Resources.Theme aiP;
    private int aiQ;
    private String aiR;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, String str) {
        super(context);
        this.aiQ = -1;
        this.mContext = context;
        this.aiR = str;
        this.aiQ = a.getThemeResId(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.h(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.aiR);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.aiR);
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.mContext.getResources(), this.aiR);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(super.getSystemService(str), str, this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
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
            this.aiP = a.a(theme, theme2, this.aiQ, this.aiR);
        }
        return this.aiP;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        this.aiQ = i4;
        super.setTheme(i4);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.unregisterComponentCallbacks(componentCallbacks);
    }
}
