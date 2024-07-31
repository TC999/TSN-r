package com.kwad.sdk.core.p385a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11048bc;
import com.kwad.sdk.utils.C11121p;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9884a implements InterfaceC9892g {
    private static String auL;

    /* renamed from: Dr */
    private static String m27452Dr() {
        Context context;
        if (!TextUtils.isEmpty(auL)) {
            return auL;
        }
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return "";
        }
        String str = context.getPackageName() + C11048bc.m23953cT(context);
        auL = str;
        return str;
    }

    @Override // com.kwad.sdk.core.p385a.InterfaceC9892g
    /* renamed from: a */
    public final void mo27421a(String str, Map<String, String> map, String str2) {
        C9891f.m27424a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.p385a.InterfaceC9892g
    /* renamed from: al */
    public final String mo27420al(String str) {
        try {
            String m23751dY = C11121p.m23751dY(0);
            return new String(C9886c.m27444Ds().encode(C9885b.m27449d(m23751dY.getBytes("UTF-8"), C9885b.m27446f(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.p385a.InterfaceC9892g
    /* renamed from: f */
    public final void mo27419f(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", m27452Dr());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.p385a.InterfaceC9892g
    public final String getResponseData(String str) {
        try {
            return new String(C9885b.m27445g(C9885b.m27451a(C11121p.m23751dY(0), C9886c.m27442Du().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
