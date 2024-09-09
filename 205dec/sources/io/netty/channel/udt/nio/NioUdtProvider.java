package io.netty.channel.udt.nio;

import com.barchart.udt.SocketUDT;
import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ChannelUDT;
import com.barchart.udt.nio.KindUDT;
import com.barchart.udt.nio.RendezvousChannelUDT;
import com.barchart.udt.nio.SelectorProviderUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFactory;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannel;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class NioUdtProvider<T extends UdtChannel> implements ChannelFactory<T> {
    public static final ChannelFactory<UdtServerChannel> BYTE_ACCEPTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> BYTE_CONNECTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.CONNECTOR);
    public static final SelectorProvider BYTE_PROVIDER = SelectorProviderUDT.STREAM;
    public static final ChannelFactory<UdtChannel> BYTE_RENDEZVOUS = new NioUdtProvider(TypeUDT.STREAM, KindUDT.RENDEZVOUS);
    public static final ChannelFactory<UdtServerChannel> MESSAGE_ACCEPTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> MESSAGE_CONNECTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.CONNECTOR);
    public static final SelectorProvider MESSAGE_PROVIDER = SelectorProviderUDT.DATAGRAM;
    public static final ChannelFactory<UdtChannel> MESSAGE_RENDEZVOUS = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.RENDEZVOUS);
    private final KindUDT kind;
    private final TypeUDT type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.channel.udt.nio.NioUdtProvider$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$TypeUDT;
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$nio$KindUDT;

        static {
            int[] iArr = new int[KindUDT.values().length];
            $SwitchMap$com$barchart$udt$nio$KindUDT = iArr;
            try {
                iArr[KindUDT.ACCEPTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$barchart$udt$nio$KindUDT[KindUDT.CONNECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$barchart$udt$nio$KindUDT[KindUDT.RENDEZVOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TypeUDT.values().length];
            $SwitchMap$com$barchart$udt$TypeUDT = iArr2;
            try {
                iArr2[TypeUDT.DATAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$barchart$udt$TypeUDT[TypeUDT.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private NioUdtProvider(TypeUDT typeUDT, KindUDT kindUDT) {
        this.type = typeUDT;
        this.kind = kindUDT;
    }

    public static ChannelUDT channelUDT(Channel channel) {
        if (channel instanceof NioUdtByteAcceptorChannel) {
            return ((NioUdtByteAcceptorChannel) channel).mo104javaChannel();
        }
        if (channel instanceof NioUdtByteRendezvousChannel) {
            return ((NioUdtByteRendezvousChannel) channel).mo104javaChannel();
        }
        if (channel instanceof NioUdtByteConnectorChannel) {
            return ((NioUdtByteConnectorChannel) channel).mo104javaChannel();
        }
        if (channel instanceof NioUdtMessageAcceptorChannel) {
            return ((NioUdtMessageAcceptorChannel) channel).mo104javaChannel();
        }
        if (channel instanceof NioUdtMessageRendezvousChannel) {
            return ((NioUdtMessageRendezvousChannel) channel).mo104javaChannel();
        }
        if (channel instanceof NioUdtMessageConnectorChannel) {
            return ((NioUdtMessageConnectorChannel) channel).mo104javaChannel();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ServerSocketChannelUDT newAcceptorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openServerSocketChannel();
        } catch (IOException e4) {
            throw new ChannelException("failed to open a server socket channel", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SocketChannelUDT newConnectorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openSocketChannel();
        } catch (IOException e4) {
            throw new ChannelException("failed to open a socket channel", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RendezvousChannelUDT newRendezvousChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openRendezvousChannel();
        } catch (IOException e4) {
            throw new ChannelException("failed to open a rendezvous channel", e4);
        }
    }

    public static SocketUDT socketUDT(Channel channel) {
        ChannelUDT channelUDT = channelUDT(channel);
        if (channelUDT == null) {
            return null;
        }
        return channelUDT.socketUDT();
    }

    public KindUDT kind() {
        return this.kind;
    }

    public TypeUDT type() {
        return this.type;
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        int i4 = AnonymousClass1.$SwitchMap$com$barchart$udt$nio$KindUDT[this.kind.ordinal()];
        if (i4 == 1) {
            int i5 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    return new NioUdtByteAcceptorChannel();
                }
                throw new IllegalStateException("wrong type=" + this.type);
            }
            return new NioUdtMessageAcceptorChannel();
        } else if (i4 == 2) {
            int i6 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    return new NioUdtByteConnectorChannel();
                }
                throw new IllegalStateException("wrong type=" + this.type);
            }
            return new NioUdtMessageConnectorChannel();
        } else if (i4 == 3) {
            int i7 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    return new NioUdtByteRendezvousChannel();
                }
                throw new IllegalStateException("wrong type=" + this.type);
            }
            return new NioUdtMessageRendezvousChannel();
        } else {
            throw new IllegalStateException("wrong kind=" + this.kind);
        }
    }
}
