package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DnsRawRecord extends DnsRecord, ByteBufHolder {
    DnsRawRecord copy();

    DnsRawRecord duplicate();

    DnsRawRecord replace(ByteBuf byteBuf);

    DnsRawRecord retain();

    DnsRawRecord retain(int i4);

    DnsRawRecord retainedDuplicate();

    DnsRawRecord touch();

    DnsRawRecord touch(Object obj);
}
