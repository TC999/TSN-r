package com.kwad.sdk.core.p385a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.InterfaceC9866g;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9889d {
    private static InterfaceC9892g auZ;

    /* renamed from: a */
    public static void m27430a(String str, Map<String, String> map, String str2) {
        m27427ox().mo27421a(str, map, str2);
    }

    /* renamed from: al */
    public static String m27429al(String str) {
        return m27427ox().mo27420al(str);
    }

    /* renamed from: f */
    public static void m27428f(@NonNull Map<String, String> map) {
        m27427ox().mo27419f(map);
    }

    public static String getResponseData(String str) {
        C9861c.m27501f(DevelopMangerComponents.class);
        return m27427ox().getResponseData(str);
    }

    /* renamed from: ox */
    private static InterfaceC9892g m27427ox() {
        InterfaceC9892g interfaceC9892g = auZ;
        if (interfaceC9892g != null) {
            return interfaceC9892g;
        }
        InterfaceC9866g interfaceC9866g = (InterfaceC9866g) C9861c.m27501f(InterfaceC9866g.class);
        if (interfaceC9866g != null) {
            interfaceC9866g.mo27495ox();
            auZ = interfaceC9866g.mo27495ox();
        } else {
            auZ = new C9884a();
        }
        return auZ;
    }
}
