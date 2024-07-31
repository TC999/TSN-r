package com.kwad.sdk.p445n;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.p434g.AbstractC10762b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11014ah;
import com.kwad.sdk.utils.C11095g;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.n.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10882k {

    /* renamed from: JB */
    private static final AtomicBoolean f29667JB = new AtomicBoolean(false);
    private static C10885a aTo;

    @KsJson
    /* renamed from: com.kwad.sdk.n.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10885a extends C10482a {
        public List<String> aTq;
        public List<C10886a> aTr;

        @KsJson
        /* renamed from: com.kwad.sdk.n.k$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C10886a extends C10482a {
            public String aTs;
            public String aTt;
        }
    }

    /* renamed from: NZ */
    public static void m24574NZ() {
        if (f29667JB.getAndSet(true)) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.n.k.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10885a unused = C10882k.aTo = new C10885a();
                try {
                    C10882k.aTo.parseJson((JSONObject) ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).getAppConfigData(null, new AbstractC10762b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.k.1.1
                        /* renamed from: o */
                        private static JSONObject m24568o(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                jSONObject.optJSONObject("wrapperBlackConfig");
                                return null;
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.p434g.AbstractC10762b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return m24568o(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* renamed from: dm */
    public static boolean m24569dm(Context context) {
        C10885a c10885a = aTo;
        if (c10885a == null || C11014ah.m24126I(c10885a.aTq) || C11014ah.m24126I(aTo.aTr) || !m24572a(context, aTo)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (m24570a(stackTraceElement, aTo)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m24572a(Context context, C10885a c10885a) {
        String name = context.getClass().getName();
        for (String str : new CopyOnWriteArrayList(c10885a.aTq)) {
            if (C11014ah.m24124a(str, name)) {
                C10331c.m26254d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m24570a(StackTraceElement stackTraceElement, C10885a c10885a) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (C10885a.C10886a c10886a : new CopyOnWriteArrayList(c10885a.aTr)) {
            String str = c10886a.aTs;
            String str2 = c10886a.aTt;
            if (C11014ah.m24124a(str, className) && C11014ah.m24124a(str2, methodName)) {
                C10331c.m26254d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
