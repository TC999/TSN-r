package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1(ApplicationProtocolNames.HTTP_1_1),
    SPDY_3(ApplicationProtocolNames.SPDY_3_1),
    HTTP_2(ApplicationProtocolNames.HTTP_2);
    

    /* renamed from: a */
    private final String f1446a;

    Protocol(String str) {
        this.f1446a = str;
    }

    /* renamed from: a */
    public static Protocol m58224a(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.f1446a)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.f1446a)) {
            return protocol2;
        }
        Protocol protocol3 = HTTP_2;
        if (str.equals(protocol3.f1446a)) {
            return protocol3;
        }
        Protocol protocol4 = SPDY_3;
        if (str.equals(protocol4.f1446a)) {
            return protocol4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1446a;
    }
}
