package com.kwad.sdk.n;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ay;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {
    private static final AtomicBoolean JB = new AtomicBoolean(false);
    private static a aTo;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aTq;
        public List<C0718a> aTr;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        @KsJson
        /* renamed from: com.kwad.sdk.n.k$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0718a extends com.kwad.sdk.core.response.a.a {
            public String aTs;
            public String aTt;
        }
    }

    public static void NZ() {
        if (JB.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.n.k.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a unused = k.aTo = new a();
                try {
                    k.aTo.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.k.1.1
                        private static JSONObject o(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                jSONObject.optJSONObject("wrapperBlackConfig");
                                return null;
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return o(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static boolean dm(Context context) {
        a aVar = aTo;
        if (aVar == null || ah.I(aVar.aTq) || ah.I(aTo.aTr) || !a(context, aTo)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, aTo)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        for (String str : new CopyOnWriteArrayList(aVar.aTq)) {
            if (ah.a(str, name)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0718a c0718a : new CopyOnWriteArrayList(aVar.aTr)) {
            String str = c0718a.aTs;
            String str2 = c0718a.aTt;
            if (ah.a(str, className) && ah.a(str2, methodName)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
