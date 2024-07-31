package com.kwad.sdk.p433f;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10758b implements InterfaceC10757a {
    private static volatile C10758b aHT;
    private static InterfaceC10759c aHU;

    private C10758b() {
    }

    /* renamed from: Is */
    public static synchronized C10758b m24900Is() {
        C10758b c10758b;
        synchronized (C10758b.class) {
            if (aHT == null) {
                synchronized (C10758b.class) {
                    if (aHT == null) {
                        aHT = new C10758b();
                    }
                }
            }
            c10758b = aHT;
        }
        return c10758b;
    }

    /* renamed from: It */
    private static String m24899It() {
        return m24897a(false, "", 2);
    }

    /* renamed from: a */
    public static void m24898a(InterfaceC10759c interfaceC10759c) {
        aHU = interfaceC10759c;
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ig */
    public final String mo24010Ig() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24010Ig();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ih */
    public final String mo24009Ih() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24009Ih();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ii */
    public final String mo24008Ii() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24008Ii();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ij */
    public final String mo24007Ij() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24007Ij();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ik */
    public final String mo24006Ik() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24006Ik();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Il */
    public final String mo24005Il() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24005Il();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Im */
    public final String mo24004Im() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24004Im();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: In */
    public final String mo24003In() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24003In();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Io */
    public final String mo24002Io() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24002Io();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ip */
    public final String mo24001Ip() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24001Ip();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Iq */
    public final String mo24000Iq() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo24000Iq();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    /* renamed from: Ir */
    public final String mo23999Ir() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.mo23999Ir();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getAppId() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getAppId();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getDeviceId() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getDeviceId();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getIccId() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getIccId();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getIp() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getIp();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getLocation() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getLocation();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getOaid() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getOaid();
        }
        return m24899It();
    }

    @Override // com.kwad.sdk.p433f.InterfaceC10757a
    public final String getSdkVersion() {
        InterfaceC10759c interfaceC10759c = aHU;
        if (interfaceC10759c != null) {
            return interfaceC10759c.getSdkVersion();
        }
        return m24899It();
    }

    /* renamed from: a */
    public static String m24897a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put(DomainCampaignEx.LOOPBACK_VALUE, obj);
        hashMap.put("errorCode", String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }
}
