package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;
    private volatile InetSocketAddress local;
    private volatile InetSocketAddress remote;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Object> readBuf;

        EpollDatagramChannelUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            boolean isActive;
            boolean z3 = false;
            try {
                try {
                    isActive = EpollDatagramChannel.this.isActive();
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
                    if (socketAddress2 != null) {
                        EpollDatagramChannel.this.doBind((InetSocketAddress) socketAddress2);
                    }
                    AbstractEpollChannel.checkResolvable(inetSocketAddress);
                    EpollDatagramChannel.this.remote = inetSocketAddress;
                    EpollDatagramChannel epollDatagramChannel = EpollDatagramChannel.this;
                    epollDatagramChannel.local = epollDatagramChannel.fd().localAddress();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    channelPromise.trySuccess();
                    if (!isActive && EpollDatagramChannel.this.isActive()) {
                        EpollDatagramChannel.this.pipeline().fireChannelActive();
                    }
                    EpollDatagramChannel.this.connected = true;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = true;
                    if (!z3) {
                        EpollDatagramChannel.this.doClose();
                    } else {
                        EpollDatagramChannel.this.connected = true;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                channelPromise.tryFailure(th3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x007e, code lost:
            r1.lastBytesRead(-1);
            r5.release();
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cb A[Catch: all -> 0x00bf, LOOP:1: B:29:0x00c9->B:30:0x00cb, LOOP_END, TryCatch #2 {all -> 0x00bf, blocks: (B:28:0x00c1, B:30:0x00cb, B:31:0x00d9, B:33:0x00e6, B:25:0x00bb), top: B:43:0x00bb }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e6 A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #2 {all -> 0x00bf, blocks: (B:28:0x00c1, B:30:0x00cb, B:31:0x00d9, B:33:0x00e6, B:25:0x00bb), top: B:43:0x00bb }] */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void epollInReady() {
            /*
                r11 = this;
                io.netty.channel.epoll.EpollDatagramChannel r0 = io.netty.channel.epoll.EpollDatagramChannel.this
                io.netty.channel.unix.Socket r0 = r0.fd()
                boolean r0 = r0.isInputShutdown()
                if (r0 == 0) goto L10
                r11.clearEpollIn0()
                return
            L10:
                io.netty.channel.epoll.EpollDatagramChannel r0 = io.netty.channel.epoll.EpollDatagramChannel.this
                io.netty.channel.epoll.EpollDatagramChannelConfig r0 = r0.config()
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r1 = r11.recvBufAllocHandle()
                io.netty.channel.epoll.EpollDatagramChannel r2 = io.netty.channel.epoll.EpollDatagramChannel.this
                int r3 = io.netty.channel.epoll.Native.EPOLLET
                boolean r2 = r2.isFlagSet(r3)
                r1.edgeTriggered(r2)
                io.netty.channel.epoll.EpollDatagramChannel r2 = io.netty.channel.epoll.EpollDatagramChannel.this
                io.netty.channel.ChannelPipeline r2 = r2.pipeline()
                io.netty.buffer.ByteBufAllocator r3 = r0.getAllocator()
                r1.reset(r0)
                r11.epollInBefore()
            L35:
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r1.allocate(r3)     // Catch: java.lang.Throwable -> Lb6
                int r6 = r5.writableBytes()     // Catch: java.lang.Throwable -> Lb4
                r1.attemptedBytesRead(r6)     // Catch: java.lang.Throwable -> Lb4
                boolean r6 = r5.hasMemoryAddress()     // Catch: java.lang.Throwable -> Lb4
                if (r6 == 0) goto L5e
                io.netty.channel.epoll.EpollDatagramChannel r6 = io.netty.channel.epoll.EpollDatagramChannel.this     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.unix.Socket r6 = r6.fd()     // Catch: java.lang.Throwable -> Lb4
                long r7 = r5.memoryAddress()     // Catch: java.lang.Throwable -> Lb4
                int r9 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lb4
                int r10 = r5.capacity()     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.unix.DatagramSocketAddress r6 = r6.recvFromAddress(r7, r9, r10)     // Catch: java.lang.Throwable -> Lb4
                goto L7c
            L5e:
                int r6 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lb4
                int r7 = r5.writableBytes()     // Catch: java.lang.Throwable -> Lb4
                java.nio.ByteBuffer r6 = r5.internalNioBuffer(r6, r7)     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.epoll.EpollDatagramChannel r7 = io.netty.channel.epoll.EpollDatagramChannel.this     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.unix.Socket r7 = r7.fd()     // Catch: java.lang.Throwable -> Lb4
                int r8 = r6.position()     // Catch: java.lang.Throwable -> Lb4
                int r9 = r6.limit()     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.unix.DatagramSocketAddress r6 = r7.recvFrom(r6, r8, r9)     // Catch: java.lang.Throwable -> Lb4
            L7c:
                if (r6 != 0) goto L86
                r3 = -1
                r1.lastBytesRead(r3)     // Catch: java.lang.Throwable -> Lb4
                r5.release()     // Catch: java.lang.Throwable -> Lb4
                goto Lc1
            L86:
                r7 = 1
                r1.incMessagesRead(r7)     // Catch: java.lang.Throwable -> Lb4
                int r7 = r6.receivedAmount()     // Catch: java.lang.Throwable -> Lb4
                r1.lastBytesRead(r7)     // Catch: java.lang.Throwable -> Lb4
                int r7 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lb4
                int r8 = r1.lastBytesRead()     // Catch: java.lang.Throwable -> Lb4
                int r7 = r7 + r8
                r5.writerIndex(r7)     // Catch: java.lang.Throwable -> Lb4
                java.util.List<java.lang.Object> r7 = r11.readBuf     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.socket.DatagramPacket r8 = new io.netty.channel.socket.DatagramPacket     // Catch: java.lang.Throwable -> Lb4
                java.net.SocketAddress r9 = r11.localAddress()     // Catch: java.lang.Throwable -> Lb4
                java.net.InetSocketAddress r9 = (java.net.InetSocketAddress) r9     // Catch: java.lang.Throwable -> Lb4
                r8.<init>(r5, r9, r6)     // Catch: java.lang.Throwable -> Lb4
                r7.add(r8)     // Catch: java.lang.Throwable -> Lb4
                boolean r5 = r1.continueReading()     // Catch: java.lang.Throwable -> Lb6
                if (r5 != 0) goto L35
                goto Lc1
            Lb4:
                r3 = move-exception
                goto Lb8
            Lb6:
                r3 = move-exception
                r5 = r4
            Lb8:
                r4 = r3
                if (r5 == 0) goto Lc1
                r5.release()     // Catch: java.lang.Throwable -> Lbf
                goto Lc1
            Lbf:
                r1 = move-exception
                goto Led
            Lc1:
                java.util.List<java.lang.Object> r3 = r11.readBuf     // Catch: java.lang.Throwable -> Lbf
                int r3 = r3.size()     // Catch: java.lang.Throwable -> Lbf
                r5 = 0
                r6 = 0
            Lc9:
                if (r6 >= r3) goto Ld9
                r11.readPending = r5     // Catch: java.lang.Throwable -> Lbf
                java.util.List<java.lang.Object> r7 = r11.readBuf     // Catch: java.lang.Throwable -> Lbf
                java.lang.Object r7 = r7.get(r6)     // Catch: java.lang.Throwable -> Lbf
                r2.fireChannelRead(r7)     // Catch: java.lang.Throwable -> Lbf
                int r6 = r6 + 1
                goto Lc9
            Ld9:
                java.util.List<java.lang.Object> r3 = r11.readBuf     // Catch: java.lang.Throwable -> Lbf
                r3.clear()     // Catch: java.lang.Throwable -> Lbf
                r1.readComplete()     // Catch: java.lang.Throwable -> Lbf
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> Lbf
                if (r4 == 0) goto Le9
                r2.fireExceptionCaught(r4)     // Catch: java.lang.Throwable -> Lbf
            Le9:
                r11.epollInFinally(r0)
                return
            Led:
                r11.epollInFinally(r0)
                goto Lf2
            Lf1:
                throw r1
            Lf2:
                goto Lf1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.EpollDatagramChannelUnsafe.epollInReady():void");
        }
    }

    public EpollDatagramChannel() {
        super(Socket.newSocketDgram(), Native.EPOLLIN);
        this.config = new EpollDatagramChannelConfig(this);
    }

    private boolean doWriteMessage(Object obj) throws Exception {
        ByteBuf byteBuf;
        InetSocketAddress inetSocketAddress;
        int sendTo;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            byteBuf = (ByteBuf) addressedEnvelope.content();
            inetSocketAddress = (InetSocketAddress) addressedEnvelope.recipient();
        } else {
            byteBuf = (ByteBuf) obj;
            inetSocketAddress = null;
        }
        if (byteBuf.readableBytes() == 0) {
            return true;
        }
        if (inetSocketAddress == null && (inetSocketAddress = this.remote) == null) {
            throw new NotYetConnectedException();
        }
        if (byteBuf.hasMemoryAddress()) {
            sendTo = fd().sendToAddress(byteBuf.memoryAddress(), byteBuf.readerIndex(), byteBuf.writerIndex(), inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } else if (byteBuf instanceof CompositeByteBuf) {
            IovArray cleanArray = ((EpollEventLoop) eventLoop()).cleanArray();
            cleanArray.add(byteBuf);
            sendTo = fd().sendToAddresses(cleanArray.memoryAddress(0), cleanArray.count(), inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            sendTo = fd().sendTo(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit(), inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        }
        return sendTo > 0;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        AbstractEpollChannel.checkResolvable(inetSocketAddress);
        fd().bind(inetSocketAddress);
        this.local = fd().localAddress();
        this.active = true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.connected = false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        NativeDatagramPacketArray nativeDatagramPacketArray;
        int count;
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearFlag(Native.EPOLLOUT);
                return;
            }
            try {
                boolean z3 = false;
                if (Native.IS_SUPPORTING_SENDMMSG && channelOutboundBuffer.size() > 1 && (count = (nativeDatagramPacketArray = NativeDatagramPacketArray.getInstance(channelOutboundBuffer)).count()) >= 1) {
                    NativeDatagramPacketArray.NativeDatagramPacket[] packets = nativeDatagramPacketArray.packets();
                    int i4 = 0;
                    while (count > 0) {
                        int sendmmsg = Native.sendmmsg(fd().intValue(), packets, i4, count);
                        if (sendmmsg == 0) {
                            setFlag(Native.EPOLLOUT);
                            return;
                        }
                        for (int i5 = 0; i5 < sendmmsg; i5++) {
                            channelOutboundBuffer.remove();
                        }
                        count -= sendmmsg;
                        i4 += sendmmsg;
                    }
                    continue;
                } else {
                    int writeSpinCount = config().getWriteSpinCount() - 1;
                    while (true) {
                        if (writeSpinCount < 0) {
                            break;
                        } else if (doWriteMessage(current)) {
                            z3 = true;
                            break;
                        } else {
                            writeSpinCount--;
                        }
                    }
                    if (z3) {
                        channelOutboundBuffer.remove();
                    } else {
                        setFlag(Native.EPOLLOUT);
                        return;
                    }
                }
            } catch (IOException e4) {
                channelOutboundBuffer.remove(e4);
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf content = datagramPacket.content();
            if (content.hasMemoryAddress()) {
                return obj;
            }
            if (content.isDirect() && (content instanceof CompositeByteBuf)) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) content;
                if (compositeByteBuf.isDirect() && compositeByteBuf.nioBufferCount() <= Native.IOV_MAX) {
                    return obj;
                }
            }
            return new DatagramPacket(newDirectBuffer(datagramPacket, content), datagramPacket.recipient());
        } else if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (byteBuf.hasMemoryAddress()) {
                return byteBuf;
            }
            if (PlatformDependent.hasUnsafe() || !byteBuf.isDirect()) {
                if (byteBuf instanceof CompositeByteBuf) {
                    CompositeByteBuf compositeByteBuf2 = (CompositeByteBuf) byteBuf;
                    return (!compositeByteBuf2.isDirect() || compositeByteBuf2.nioBufferCount() > Native.IOV_MAX) ? newDirectBuffer(byteBuf) : byteBuf;
                }
                return newDirectBuffer(byteBuf);
            }
            return byteBuf;
        } else {
            if (obj instanceof AddressedEnvelope) {
                AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
                if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                    ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                    if (byteBuf2.hasMemoryAddress()) {
                        return addressedEnvelope;
                    }
                    if (byteBuf2 instanceof CompositeByteBuf) {
                        CompositeByteBuf compositeByteBuf3 = (CompositeByteBuf) byteBuf2;
                        if (compositeByteBuf3.isDirect() && compositeByteBuf3.nioBufferCount() <= Native.IOV_MAX) {
                            return addressedEnvelope;
                        }
                    }
                    return new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), (InetSocketAddress) addressedEnvelope.recipient());
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public boolean isActive() {
        return fd().isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress != null) {
            if (inetAddress2 != null) {
                if (networkInterface != null) {
                    channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
                    return channelPromise;
                }
                throw new NullPointerException("networkInterface");
            }
            throw new NullPointerException("sourceToBlock");
        }
        throw new NullPointerException("multicastAddress");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return joinGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e4) {
            channelPromise.setFailure((Throwable) e4);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e4) {
            channelPromise.setFailure((Throwable) e4);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public InetSocketAddress localAddress0() {
        return this.local;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return this.remote;
    }

    @Deprecated
    public EpollDatagramChannel(FileDescriptor fileDescriptor) {
        this(new Socket(fileDescriptor.intValue()));
    }

    public EpollDatagramChannel(Socket socket) {
        super(null, socket, Native.EPOLLIN, true);
        this.local = socket.localAddress();
        this.config = new EpollDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress != null) {
            if (networkInterface != null) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
                return channelPromise;
            }
            throw new NullPointerException("networkInterface");
        }
        throw new NullPointerException("multicastAddress");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress != null) {
            if (networkInterface != null) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
                return channelPromise;
            }
            throw new NullPointerException("networkInterface");
        }
        throw new NullPointerException("multicastAddress");
    }
}
