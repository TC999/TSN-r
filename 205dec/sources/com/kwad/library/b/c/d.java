package com.kwad.library.b.c;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.utils.s;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"RestrictedApi"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends ContextThemeWrapper implements b {
    private Resources.Theme aiP;
    private int aiQ;
    private String aiR;
    private final ContextThemeWrapper aiS;

    public d(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.aiS = contextThemeWrapper;
        this.aiR = str;
        try {
            Object callMethod = s.callMethod(contextThemeWrapper, "getThemeResId", new Object[0]);
            if (callMethod != null) {
                this.aiQ = ((Integer) callMethod).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.h(StubApp.getOrigApplicationContext(this.aiS.getApplicationContext()), this.aiR);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aiS;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.aiR);
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.aiS;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.aiS.getResources(), this.aiR);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aiS.getSystemService(str), str, this);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
        this.aiS.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        this.aiQ = i4;
        super.setTheme(i4);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aiS.unregisterComponentCallbacks(componentCallbacks);
    }
}
