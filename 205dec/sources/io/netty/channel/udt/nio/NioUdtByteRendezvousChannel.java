package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NioUdtByteRendezvousChannel extends NioUdtByteConnectorChannel {
    public NioUdtByteRendezvousChannel() {
        super((SocketChannelUDT) NioUdtProvider.newRendezvousChannelUDT(TypeUDT.STREAM));
    }
}
