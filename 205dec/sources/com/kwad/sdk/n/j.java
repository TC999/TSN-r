package com.kwad.sdk.n;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context aq(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ar(Context context) {
        return context instanceof ResContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context dl(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(unwrapContextIfNeed(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (ar(origApplicationContext)) {
                origApplicationContext = aq(origApplicationContext);
            }
        }
        return origApplicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context unwrapContextIfNeed(Context context) {
        if (ar(context)) {
            context = aq(context);
        }
        if (ar(context)) {
            RuntimeException runtimeException = null;
            for (int i4 = 0; i4 < 10; i4++) {
                if (runtimeException == null) {
                    boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
                    RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ys);
                    ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                    runtimeException = runtimeException2;
                }
                context = aq(context);
                if (!ar(context)) {
                    return context;
                }
            }
            return context;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}
