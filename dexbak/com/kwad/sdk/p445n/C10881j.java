package com.kwad.sdk.p445n;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.n.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10881j {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aq */
    public static Context m24577aq(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ar */
    public static boolean m24576ar(Context context) {
        return context instanceof ResContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dl */
    public static Context m24575dl(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(unwrapContextIfNeed(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i = 0; i < 10; i++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (m24576ar(origApplicationContext)) {
                origApplicationContext = m24577aq(origApplicationContext);
            }
        }
        return origApplicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context unwrapContextIfNeed(Context context) {
        if (m24576ar(context)) {
            context = m24577aq(context);
        }
        if (m24576ar(context)) {
            RuntimeException runtimeException = null;
            for (int i = 0; i < 10; i++) {
                if (runtimeException == null) {
                    boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
                    RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys);
                    ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(runtimeException2);
                    runtimeException = runtimeException2;
                }
                context = m24577aq(context);
                if (!m24576ar(context)) {
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
