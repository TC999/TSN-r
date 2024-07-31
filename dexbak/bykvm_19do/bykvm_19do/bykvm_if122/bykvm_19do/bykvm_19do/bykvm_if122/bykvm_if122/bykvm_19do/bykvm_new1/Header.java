package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Header {

    /* renamed from: d */
    public static final ByteString f1038d = ByteString.m58937c(":");

    /* renamed from: e */
    public static final ByteString f1039e = ByteString.m58937c(":status");

    /* renamed from: f */
    public static final ByteString f1040f = ByteString.m58937c(":method");

    /* renamed from: g */
    public static final ByteString f1041g = ByteString.m58937c(":path");

    /* renamed from: h */
    public static final ByteString f1042h = ByteString.m58937c(":scheme");

    /* renamed from: i */
    public static final ByteString f1043i = ByteString.m58937c(":authority");

    /* renamed from: a */
    public final ByteString f1044a;

    /* renamed from: b */
    public final ByteString f1045b;

    /* renamed from: c */
    final int f1046c;

    public Header(String str, String str2) {
        this(ByteString.m58937c(str), ByteString.m58937c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            return this.f1044a.equals(header.f1044a) && this.f1045b.equals(header.f1045b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1044a.hashCode() + 527) * 31) + this.f1045b.hashCode();
    }

    public String toString() {
        return C1061c.m58464a("%s: %s", this.f1044a.mo58878h(), this.f1045b.mo58878h());
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.m58937c(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f1044a = byteString;
        this.f1045b = byteString2;
        this.f1046c = byteString.mo58881e() + 32 + byteString2.mo58881e();
    }
}
