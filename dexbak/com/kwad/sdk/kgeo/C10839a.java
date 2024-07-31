package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.C8911b;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.C10845c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.kgeo.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10839a {
    private static String aIO;
    private static KGeoInfo aIP;
    private static final AtomicBoolean aIQ = new AtomicBoolean();

    @Nullable
    /* renamed from: IS */
    public static KGeoInfo m24663IS() {
        return aIP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IT */
    public static void m24662IT() {
        try {
            if (aIQ.getAndSet(true)) {
                return;
            }
            C10845c.m24652a(ServiceProvider.m24363KO(), new C10845c.InterfaceC10847a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.C10845c.InterfaceC10847a
                /* renamed from: Ho */
                public final void mo24647Ho() {
                    C10839a.m24661IU();
                }

                @Override // com.kwad.sdk.kgeo.C10845c.InterfaceC10847a
                public final void onSuccess(String str) {
                    String unused = C10839a.aIO = str;
                    C10839a.m24661IU();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IU */
    public static void m24661IU() {
        try {
            new AbstractC10436l<InterfaceC10420f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                /* renamed from: fM */
                private static KGeoResultData m24654fM(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.AbstractC10402a
                @NonNull
                public final InterfaceC10420f createRequest() {
                    return new C10844b();
                }

                @Override // com.kwad.sdk.core.network.AbstractC10436l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return m24654fM(str);
                }
            }.request(new AbstractC10439o<InterfaceC10420f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                /* renamed from: a */
                private static void m24653a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = C10839a.aIP = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
                public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                    m24653a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* renamed from: dC */
    public static void m24659dC(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            m24662IT();
        } else if (i == 2) {
            C8911b.m29612qn().m29614a(new C8911b.InterfaceC8912a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.C8911b.InterfaceC8912a
                /* renamed from: qp */
                public final void mo24655qp() {
                    C8911b.m29612qn().m29613b(this);
                    C10839a.m24662IT();
                }
            });
        }
    }

    @Nullable
    /* renamed from: yt */
    public static String m24656yt() {
        return aIO;
    }
}
