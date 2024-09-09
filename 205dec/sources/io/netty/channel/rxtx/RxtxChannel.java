package io.netty.channel.rxtx;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.rxtx.RxtxChannelConfig;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RxtxChannel extends OioByteStreamChannel {
    private static final RxtxDeviceAddress LOCAL_ADDRESS = new RxtxDeviceAddress("localhost");
    private final RxtxChannelConfig config;
    private RxtxDeviceAddress deviceAddress;
    private boolean open;
    private SerialPort serialPort;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class RxtxUnsafe extends AbstractChannel.AbstractUnsafe {
        private RxtxUnsafe() {
            super();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, final ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    final boolean isActive = RxtxChannel.this.isActive();
                    RxtxChannel.this.doConnect(socketAddress, socketAddress2);
                    int intValue = ((Integer) RxtxChannel.this.config().getOption(RxtxChannelOption.WAIT_TIME)).intValue();
                    if (intValue > 0) {
                        RxtxChannel.this.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.rxtx.RxtxChannel.RxtxUnsafe.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    RxtxChannel.this.doInit();
                                    RxtxUnsafe.this.safeSetSuccess(channelPromise);
                                    if (isActive || !RxtxChannel.this.isActive()) {
                                        return;
                                    }
                                    RxtxChannel.this.pipeline().fireChannelActive();
                                } catch (Throwable th) {
                                    RxtxUnsafe.this.safeSetFailure(channelPromise, th);
                                    RxtxUnsafe.this.closeIfClosed();
                                }
                            }
                        }, intValue, TimeUnit.MILLISECONDS);
                    } else {
                        RxtxChannel.this.doInit();
                        safeSetSuccess(channelPromise);
                        if (!isActive && RxtxChannel.this.isActive()) {
                            RxtxChannel.this.pipeline().fireChannelActive();
                        }
                    }
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }
    }

    public RxtxChannel() {
        super(null);
        this.open = true;
        this.config = new DefaultRxtxChannelConfig(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // io.netty.channel.oio.OioByteStreamChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        this.open = false;
        try {
            super.doClose();
            SerialPort serialPort = this.serialPort;
            if (serialPort != null) {
                serialPort.removeEventListener();
                this.serialPort.close();
                this.serialPort = null;
            }
        } catch (Throwable th) {
            if (this.serialPort != null) {
                this.serialPort.removeEventListener();
                this.serialPort.close();
                this.serialPort = null;
            }
            throw th;
        }
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        RxtxDeviceAddress rxtxDeviceAddress = (RxtxDeviceAddress) socketAddress;
        SerialPort open = CommPortIdentifier.getPortIdentifier(rxtxDeviceAddress.value()).open(getClass().getName(), 1000);
        open.enableReceiveTimeout(((Integer) config().getOption(RxtxChannelOption.READ_TIMEOUT)).intValue());
        this.deviceAddress = rxtxDeviceAddress;
        this.serialPort = open;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    protected void doInit() throws Exception {
        this.serialPort.setSerialPortParams(((Integer) config().getOption(RxtxChannelOption.BAUD_RATE)).intValue(), ((RxtxChannelConfig.Databits) config().getOption(RxtxChannelOption.DATA_BITS)).value(), ((RxtxChannelConfig.Stopbits) config().getOption(RxtxChannelOption.STOP_BITS)).value(), ((RxtxChannelConfig.Paritybit) config().getOption(RxtxChannelOption.PARITY_BIT)).value());
        this.serialPort.setDTR(((Boolean) config().getOption(RxtxChannelOption.DTR)).booleanValue());
        this.serialPort.setRTS(((Boolean) config().getOption(RxtxChannelOption.RTS)).booleanValue());
        activate(this.serialPort.getInputStream(), this.serialPort.getOutputStream());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected boolean isInputShutdown() {
        return !this.open;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.open;
    }

    @Override // io.netty.channel.oio.AbstractOioChannel, io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new RxtxUnsafe();
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected ChannelFuture shutdownInput() {
        return newFailedFuture(new UnsupportedOperationException("shutdownInput"));
    }

    @Override // io.netty.channel.Channel
    public RxtxChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public RxtxDeviceAddress localAddress() {
        return (RxtxDeviceAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public RxtxDeviceAddress localAddress0() {
        return LOCAL_ADDRESS;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public RxtxDeviceAddress remoteAddress() {
        return (RxtxDeviceAddress) super.remoteAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public RxtxDeviceAddress remoteAddress0() {
        return this.deviceAddress;
    }
}
