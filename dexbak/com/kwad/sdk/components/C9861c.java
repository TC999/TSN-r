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

/* renamed from: com.kwad.sdk.components.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9861c {
    private static final Map<Class, InterfaceC9848a> aoQ = new ConcurrentHashMap();

    /* renamed from: a */
    public static void m27503a(Class cls, InterfaceC9848a interfaceC9848a) {
        aoQ.put(cls, interfaceC9848a);
    }

    @Nullable
    /* renamed from: cP */
    public static DevelopMangerComponents.DevelopValue m27502cP(String str) {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) m27501f(DevelopMangerComponents.class);
        return null;
    }

    @Nullable
    /* renamed from: f */
    public static <T extends InterfaceC9848a> T m27501f(Class<T> cls) {
        Map<Class, InterfaceC9848a> map = aoQ;
        T t = (T) map.get(cls);
        if (t != null) {
            return t;
        }
        try {
            if (DevelopMangerComponents.class.isAssignableFrom(cls)) {
                C9864e c9864e = new C9864e();
                map.put(cls, c9864e);
                return c9864e;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList arrayList = new ArrayList(aoQ.values());
        Collections.sort(arrayList, new Comparator<InterfaceC9848a>() { // from class: com.kwad.sdk.components.c.1
            /* renamed from: a */
            private static int m27500a(InterfaceC9848a interfaceC9848a, InterfaceC9848a interfaceC9848a2) {
                if (interfaceC9848a == null) {
                    return -1;
                }
                if (interfaceC9848a2 == null) {
                    return 1;
                }
                try {
                    try {
                        return interfaceC9848a.priority() - interfaceC9848a2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(InterfaceC9848a interfaceC9848a, InterfaceC9848a interfaceC9848a2) {
                return m27500a(interfaceC9848a, interfaceC9848a2);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC9848a interfaceC9848a = (InterfaceC9848a) it.next();
            if (interfaceC9848a != null) {
                try {
                    interfaceC9848a.init(context);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }
}
