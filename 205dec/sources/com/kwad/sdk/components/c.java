package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static final Map<Class, a> aoQ = new ConcurrentHashMap();

    public static void a(Class cls, a aVar) {
        aoQ.put(cls, aVar);
    }

    @Nullable
    public static DevelopMangerComponents.DevelopValue cP(String str) {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) f(DevelopMangerComponents.class);
        return null;
    }

    @Nullable
    public static <T extends a> T f(Class<T> cls) {
        Map<Class, a> map = aoQ;
        T t3 = (T) map.get(cls);
        if (t3 != null) {
            return t3;
        }
        try {
            if (DevelopMangerComponents.class.isAssignableFrom(cls)) {
                e eVar = new e();
                map.put(cls, eVar);
                return eVar;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList arrayList = new ArrayList(aoQ.values());
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.kwad.sdk.components.c.1
            private static int a(a aVar, a aVar2) {
                if (aVar == null) {
                    return -1;
                }
                if (aVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return aVar.priority() - aVar2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                return a(aVar, aVar2);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                try {
                    aVar.init(context);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }
}
