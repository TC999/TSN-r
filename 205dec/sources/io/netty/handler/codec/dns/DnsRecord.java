package io.netty.handler.codec.dns;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DnsRecord {
    public static final int CLASS_ANY = 255;
    public static final int CLASS_CHAOS = 3;
    public static final int CLASS_CSNET = 2;
    public static final int CLASS_HESIOD = 4;
    public static final int CLASS_IN = 1;
    public static final int CLASS_NONE = 254;

    int dnsClass();

    String name();

    long timeToLive();

    DnsRecordType type();
}
