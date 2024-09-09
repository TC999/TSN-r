package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.udt.UdtChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NioUdtByteAcceptorChannel extends NioUdtAcceptorChannel {
    public NioUdtByteAcceptorChannel() {
        super(TypeUDT.STREAM);
    }

    @Override // io.netty.channel.udt.nio.NioUdtAcceptorChannel
    protected UdtChannel newConnectorChannel(SocketChannelUDT socketChannelUDT) {
        return new NioUdtByteConnectorChannel(this, socketChannelUDT);
    }
}
