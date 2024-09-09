package com.bytedance.msdk.f.sr;

import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.xv.w.n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Object> f28359c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements gd {
        private t w(gd.c cVar) {
            try {
                Field field = cVar.getClass().getDeclaredFields()[0];
                field.setAccessible(true);
                Object obj = field.get(cVar);
                Field declaredField = obj.getClass().getDeclaredField("request");
                declaredField.setAccessible(true);
                declaredField.set(obj, ((n) declaredField.get(obj)).f().c(String.valueOf(cVar.c().w().r().w("b4oil169.fn.bytedance.net").c("http").w())).w("case-id", (String) xv.f28359c.get("case_id")).c());
                return cVar.c();
            } catch (Throwable th) {
                th.printStackTrace();
                return cVar.c();
            }
        }

        @Override // com.bytedance.sdk.component.w.c.gd
        public fp c(gd.c cVar) throws IOException {
            t c4 = cVar.c();
            String rVar = c4.w().toString();
            if (rVar.contains("/api/ad/union/mediation/config") || rVar.contains("/api/ad/union/mediation/exchange")) {
                c4 = w(cVar);
            }
            return cVar.c(c4);
        }
    }

    public static void c(Map map) {
        f28359c = map;
    }

    public static boolean c() {
        return com.bytedance.msdk.core.w.k().n();
    }
}
