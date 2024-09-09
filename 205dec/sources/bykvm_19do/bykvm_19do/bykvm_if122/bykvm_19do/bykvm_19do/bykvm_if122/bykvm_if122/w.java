package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f1436a;

    w(String str) {
        this.f1436a = str;
    }

    public static w a(String str) throws IOException {
        w wVar = HTTP_1_0;
        if (str.equals(wVar.f1436a)) {
            return wVar;
        }
        w wVar2 = HTTP_1_1;
        if (str.equals(wVar2.f1436a)) {
            return wVar2;
        }
        w wVar3 = HTTP_2;
        if (str.equals(wVar3.f1436a)) {
            return wVar3;
        }
        w wVar4 = SPDY_3;
        if (str.equals(wVar4.f1436a)) {
            return wVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1436a;
    }
}
