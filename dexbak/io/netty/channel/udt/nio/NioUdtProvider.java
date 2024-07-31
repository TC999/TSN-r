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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    /* renamed from: io.netty.channel.udt.nio.NioUdtProvider$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C137601 {
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
            return ((NioUdtByteAcceptorChannel) channel).mo60146javaChannel();
        }
        if (channel instanceof NioUdtByteRendezvousChannel) {
            return ((NioUdtByteRendezvousChannel) channel).mo60146javaChannel();
        }
        if (channel instanceof NioUdtByteConnectorChannel) {
            return ((NioUdtByteConnectorChannel) channel).mo60146javaChannel();
        }
        if (channel instanceof NioUdtMessageAcceptorChannel) {
            return ((NioUdtMessageAcceptorChannel) channel).mo60146javaChannel();
        }
        if (channel instanceof NioUdtMessageRendezvousChannel) {
            return ((NioUdtMessageRendezvousChannel) channel).mo60146javaChannel();
        }
        if (channel instanceof NioUdtMessageConnectorChannel) {
            return ((NioUdtMessageConnectorChannel) channel).mo60146javaChannel();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ServerSocketChannelUDT newAcceptorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openServerSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a server socket channel", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SocketChannelUDT newConnectorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a socket channel", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RendezvousChannelUDT newRendezvousChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openRendezvousChannel();
        } catch (IOException e) {
            throw new ChannelException("failed to open a rendezvous channel", e);
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
        int i = C137601.$SwitchMap$com$barchart$udt$nio$KindUDT[this.kind.ordinal()];
        if (i == 1) {
            int i2 = C137601.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return new NioUdtByteAcceptorChannel();
                }
                throw new IllegalStateException("wrong type=" + this.type);
            }
            return new NioUdtMessageAcceptorChannel();
        } else if (i == 2) {
            int i3 = C137601.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return new NioUdtByteConnectorChannel();
                }
                throw new IllegalStateException("wrong type=" + this.type);
            }
            return new NioUdtMessageConnectorChannel();
        } else if (i == 3) {
            int i4 = C137601.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
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
