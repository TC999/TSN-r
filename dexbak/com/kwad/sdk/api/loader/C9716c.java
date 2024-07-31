package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.api.loader.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9716c {

    /* renamed from: com.kwad.sdk.api.loader.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class ApplicationC9717a extends Application {
        private final Context amb;

        ApplicationC9717a(Context context) {
            this.amb = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.amb;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.amb.getApplicationInfo();
        }
    }

    /* renamed from: ax */
    public static Context m27948ax(Context context) {
        if (context == null) {
            return null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext == null) {
            return context;
        }
        if (!origApplicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new ApplicationC9717a(context);
        }
        return StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
