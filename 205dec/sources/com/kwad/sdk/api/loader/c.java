package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a extends Application {
        private final Context amb;

        a(Context context) {
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

    public static Context ax(Context context) {
        if (context == null) {
            return null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext == null) {
            return context;
        }
        if (!origApplicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new a(context);
        }
        return StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
