package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.rxtx.RxtxChannelConfig;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class DefaultRxtxChannelConfig extends DefaultChannelConfig implements RxtxChannelConfig {
    private volatile int baudrate;
    private volatile RxtxChannelConfig.Databits databits;
    private volatile boolean dtr;
    private volatile RxtxChannelConfig.Paritybit paritybit;
    private volatile int readTimeout;
    private volatile boolean rts;
    private volatile RxtxChannelConfig.Stopbits stopbits;
    private volatile int waitTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultRxtxChannelConfig(RxtxChannel rxtxChannel) {
        super(rxtxChannel);
        this.baudrate = 115200;
        this.stopbits = RxtxChannelConfig.Stopbits.STOPBITS_1;
        this.databits = RxtxChannelConfig.Databits.DATABITS_8;
        this.paritybit = RxtxChannelConfig.Paritybit.NONE;
        this.readTimeout = 1000;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getBaudrate() {
        return this.baudrate;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Databits getDatabits() {
        return this.databits;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == RxtxChannelOption.BAUD_RATE) {
            return (T) Integer.valueOf(getBaudrate());
        }
        if (channelOption == RxtxChannelOption.DTR) {
            return (T) Boolean.valueOf(isDtr());
        }
        if (channelOption == RxtxChannelOption.RTS) {
            return (T) Boolean.valueOf(isRts());
        }
        if (channelOption == RxtxChannelOption.STOP_BITS) {
            return (T) getStopbits();
        }
        if (channelOption == RxtxChannelOption.DATA_BITS) {
            return (T) getDatabits();
        }
        if (channelOption == RxtxChannelOption.PARITY_BIT) {
            return (T) getParitybit();
        }
        if (channelOption == RxtxChannelOption.WAIT_TIME) {
            return (T) Integer.valueOf(getWaitTimeMillis());
        }
        if (channelOption == RxtxChannelOption.READ_TIMEOUT) {
            return (T) Integer.valueOf(getReadTimeout());
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), RxtxChannelOption.BAUD_RATE, RxtxChannelOption.DTR, RxtxChannelOption.RTS, RxtxChannelOption.STOP_BITS, RxtxChannelOption.DATA_BITS, RxtxChannelOption.PARITY_BIT, RxtxChannelOption.WAIT_TIME);
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Paritybit getParitybit() {
        return this.paritybit;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getReadTimeout() {
        return this.readTimeout;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Stopbits getStopbits() {
        return this.stopbits;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getWaitTimeMillis() {
        return this.waitTime;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public boolean isDtr() {
        return this.dtr;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public boolean isRts() {
        return this.rts;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setBaudrate(int i4) {
        this.baudrate = i4;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setDatabits(RxtxChannelConfig.Databits databits) {
        this.databits = databits;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setDtr(boolean z3) {
        this.dtr = z3;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t3) {
        validate(channelOption, t3);
        if (channelOption == RxtxChannelOption.BAUD_RATE) {
            setBaudrate(((Integer) t3).intValue());
            return true;
        } else if (channelOption == RxtxChannelOption.DTR) {
            setDtr(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == RxtxChannelOption.RTS) {
            setRts(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == RxtxChannelOption.STOP_BITS) {
            setStopbits((RxtxChannelConfig.Stopbits) t3);
            return true;
        } else if (channelOption == RxtxChannelOption.DATA_BITS) {
            setDatabits((RxtxChannelConfig.Databits) t3);
            return true;
        } else if (channelOption == RxtxChannelOption.PARITY_BIT) {
            setParitybit((RxtxChannelConfig.Paritybit) t3);
            return true;
        } else if (channelOption == RxtxChannelOption.WAIT_TIME) {
            setWaitTimeMillis(((Integer) t3).intValue());
            return true;
        } else if (channelOption == RxtxChannelOption.READ_TIMEOUT) {
            setReadTimeout(((Integer) t3).intValue());
            return true;
        } else {
            return super.setOption(channelOption, t3);
        }
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setParitybit(RxtxChannelConfig.Paritybit paritybit) {
        this.paritybit = paritybit;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setReadTimeout(int i4) {
        if (i4 >= 0) {
            this.readTimeout = i4;
            return this;
        }
        throw new IllegalArgumentException("readTime must be >= 0");
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setRts(boolean z3) {
        this.rts = z3;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setStopbits(RxtxChannelConfig.Stopbits stopbits) {
        this.stopbits = stopbits;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setWaitTimeMillis(int i4) {
        if (i4 >= 0) {
            this.waitTime = i4;
            return this;
        }
        throw new IllegalArgumentException("Wait time must be >= 0");
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAutoClose(boolean z3) {
        super.setAutoClose(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAutoRead(boolean z3) {
        super.setAutoRead(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setConnectTimeoutMillis(int i4) {
        super.setConnectTimeoutMillis(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public RxtxChannelConfig setMaxMessagesPerRead(int i4) {
        super.setMaxMessagesPerRead(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public RxtxChannelConfig setWriteBufferHighWaterMark(int i4) {
        super.setWriteBufferHighWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public RxtxChannelConfig setWriteBufferLowWaterMark(int i4) {
        super.setWriteBufferLowWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteSpinCount(int i4) {
        super.setWriteSpinCount(i4);
        return this;
    }
}
