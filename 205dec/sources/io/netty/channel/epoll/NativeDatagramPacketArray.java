package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.util.concurrent.FastThreadLocal;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class NativeDatagramPacketArray implements ChannelOutboundBuffer.MessageProcessor {
    private static final FastThreadLocal<NativeDatagramPacketArray> ARRAY = new FastThreadLocal<NativeDatagramPacketArray>() { // from class: io.netty.channel.epoll.NativeDatagramPacketArray.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public NativeDatagramPacketArray initialValue() throws Exception {
            return new NativeDatagramPacketArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(NativeDatagramPacketArray nativeDatagramPacketArray) throws Exception {
            for (NativeDatagramPacket nativeDatagramPacket : nativeDatagramPacketArray.packets) {
                nativeDatagramPacket.release();
            }
        }
    };
    private int count;
    private final NativeDatagramPacket[] packets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class NativeDatagramPacket {
        private byte[] addr;
        private final IovArray array = new IovArray();
        private int count;
        private long memoryAddress;
        private int port;
        private int scopeId;

        NativeDatagramPacket() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean init(ByteBuf byteBuf, InetSocketAddress inetSocketAddress) {
            this.array.clear();
            if (this.array.add(byteBuf)) {
                this.memoryAddress = this.array.memoryAddress(0);
                this.count = this.array.count();
                InetAddress address = inetSocketAddress.getAddress();
                if (address instanceof Inet6Address) {
                    this.addr = address.getAddress();
                    this.scopeId = ((Inet6Address) address).getScopeId();
                } else {
                    this.addr = NativeInetAddress.ipv4MappedIpv6Address(address.getAddress());
                    this.scopeId = 0;
                }
                this.port = inetSocketAddress.getPort();
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            this.array.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeDatagramPacketArray getInstance(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        NativeDatagramPacketArray nativeDatagramPacketArray = ARRAY.get();
        nativeDatagramPacketArray.count = 0;
        channelOutboundBuffer.forEachFlushedMessage(nativeDatagramPacketArray);
        return nativeDatagramPacketArray;
    }

    boolean add(DatagramPacket datagramPacket) {
        if (this.count == this.packets.length) {
            return false;
        }
        ByteBuf content = datagramPacket.content();
        if (content.readableBytes() == 0) {
            return true;
        }
        if (this.packets[this.count].init(content, datagramPacket.recipient())) {
            this.count++;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int count() {
        return this.count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeDatagramPacket[] packets() {
        return this.packets;
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        return (obj instanceof DatagramPacket) && add((DatagramPacket) obj);
    }

    private NativeDatagramPacketArray() {
        this.packets = new NativeDatagramPacket[Native.UIO_MAX_IOV];
        int i4 = 0;
        while (true) {
            NativeDatagramPacket[] nativeDatagramPacketArr = this.packets;
            if (i4 >= nativeDatagramPacketArr.length) {
                return;
            }
            nativeDatagramPacketArr[i4] = new NativeDatagramPacket();
            i4++;
        }
    }
}
