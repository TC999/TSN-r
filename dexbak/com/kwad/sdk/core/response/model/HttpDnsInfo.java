package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HttpDnsInfo extends C10482a implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = -6943205584670122267L;
    public List<IpInfo> recommendList = new ArrayList();
    public List<IpInfo> backUpList = new ArrayList();
    public List<IpInfo> otherList = new ArrayList();

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class IpInfo extends C10482a implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = -6943205584670122266L;

        /* renamed from: ip */
        public String f29585ip = "";
        public int weight;

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public String toString() {
            try {
                return toJson().toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public String toString() {
        try {
            return toJson().toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
