package io.netty.handler.traffic;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    public static final long DEFAULT_CHECK_INTERVAL = 1000;
    static final long DEFAULT_MAX_SIZE = 4194304;
    public static final long DEFAULT_MAX_TIME = 15000;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final long MINIMAL_WAIT = 10;
    protected volatile long checkInterval;
    protected volatile long maxTime;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    private volatile long readLimit;
    protected TrafficCounter trafficCounter;
    final int userDefinedWritabilityIndex;
    private volatile long writeLimit;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractTrafficShapingHandler.class);
    static final AttributeKey<Boolean> READ_SUSPENDED = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".READ_SUSPENDED");
    static final AttributeKey<Runnable> REOPEN_TASK = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".REOPEN_TASK");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReopenReadTimerTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            Channel channel = this.ctx.channel();
            ChannelConfig config = channel.config();
            if (!config.isAutoRead() && AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    InternalLogger internalLogger = AbstractTrafficShapingHandler.logger;
                    internalLogger.debug("Not unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
            } else {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if (config.isAutoRead() && !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                            InternalLogger internalLogger2 = AbstractTrafficShapingHandler.logger;
                            internalLogger2.debug("Unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                        }
                    } else if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                        InternalLogger internalLogger3 = AbstractTrafficShapingHandler.logger;
                        internalLogger3.debug("Normal unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
                config.setAutoRead(true);
                channel.read();
            }
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                InternalLogger internalLogger4 = AbstractTrafficShapingHandler.logger;
                internalLogger4.debug("Unsuspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j4, long j5, long j6, long j7) {
        this.maxTime = 15000L;
        this.checkInterval = 1000L;
        this.maxWriteDelay = 4000L;
        this.maxWriteSize = 4194304L;
        if (j7 > 0) {
            this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
            this.writeLimit = j4;
            this.readLimit = j5;
            this.checkInterval = j6;
            this.maxTime = j7;
            return;
        }
        throw new IllegalArgumentException("maxTime must be positive");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isHandlerActive(ChannelHandlerContext channelHandlerContext) {
        Boolean bool = (Boolean) channelHandlerContext.channel().attr(READ_SUSPENDED).get();
        return bool == null || Boolean.FALSE.equals(bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long calculateSize(Object obj) {
        int readableBytes;
        if (obj instanceof ByteBuf) {
            readableBytes = ((ByteBuf) obj).readableBytes();
        } else if (!(obj instanceof ByteBufHolder)) {
            return -1L;
        } else {
            readableBytes = ((ByteBufHolder) obj).content().readableBytes();
        }
        return readableBytes;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext, this.trafficCounter.readTimeToWait(calculateSize, this.readLimit, this.maxTime, milliSecondFromNano), milliSecondFromNano);
            if (checkWaitReadTime >= 10) {
                Channel channel = channelHandlerContext.channel();
                ChannelConfig config = channel.config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read suspend: " + checkWaitReadTime + ':' + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext));
                }
                if (config.isAutoRead() && isHandlerActive(channelHandlerContext)) {
                    config.setAutoRead(false);
                    channel.attr(READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attr = channel.attr(REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new ReopenReadTimerTask(channelHandlerContext);
                        attr.set(runnable);
                    }
                    channelHandlerContext.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + ':' + isHandlerActive(channelHandlerContext) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        }
        informReadOperation(channelHandlerContext, milliSecondFromNano);
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        setUserDefinedWritability(channelHandlerContext, true);
        super.channelRegistered(channelHandlerContext);
    }

    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j4, long j5) {
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkWriteSuspend(ChannelHandlerContext channelHandlerContext, long j4, long j5) {
        if (j5 > this.maxWriteSize || j4 > this.maxWriteDelay) {
            setUserDefinedWritability(channelHandlerContext, false);
        }
    }

    public void configure(long j4, long j5, long j6) {
        configure(j4, j5);
        configure(j6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doAccounting(TrafficCounter trafficCounter) {
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j4) {
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        if (isHandlerActive(channelHandlerContext)) {
            channelHandlerContext.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseReadSuspended(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        channel.attr(READ_SUSPENDED).set(Boolean.FALSE);
        channel.config().setAutoRead(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseWriteSuspended(ChannelHandlerContext channelHandlerContext) {
        setUserDefinedWritability(channelHandlerContext, true);
    }

    public void setCheckInterval(long j4) {
        this.checkInterval = j4;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(j4);
        }
    }

    public void setMaxTimeWait(long j4) {
        if (j4 > 0) {
            this.maxTime = j4;
            return;
        }
        throw new IllegalArgumentException("maxTime must be positive");
    }

    public void setMaxWriteDelay(long j4) {
        if (j4 > 0) {
            this.maxWriteDelay = j4;
            return;
        }
        throw new IllegalArgumentException("maxWriteDelay must be positive");
    }

    public void setMaxWriteSize(long j4) {
        this.maxWriteSize = j4;
    }

    public void setReadLimit(long j4) {
        this.readLimit = j4;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTrafficCounter(TrafficCounter trafficCounter) {
        this.trafficCounter = trafficCounter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserDefinedWritability(ChannelHandlerContext channelHandlerContext, boolean z3) {
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.setUserDefinedWritability(this.userDefinedWritabilityIndex, z3);
        }
    }

    public void setWriteLimit(long j4) {
        this.writeLimit = j4;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    abstract void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j4, long j5, long j6, ChannelPromise channelPromise);

    @Deprecated
    protected void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j4, ChannelPromise channelPromise) {
        submitWrite(channelHandlerContext, obj, calculateSize(obj), j4, TrafficCounter.milliSecondFromNano(), channelPromise);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET);
        sb.append("TrafficShaping with Write Limit: ");
        sb.append(this.writeLimit);
        sb.append(" Read Limit: ");
        sb.append(this.readLimit);
        sb.append(" CheckInterval: ");
        sb.append(this.checkInterval);
        sb.append(" maxDelay: ");
        sb.append(this.maxWriteDelay);
        sb.append(" maxSize: ");
        sb.append(this.maxWriteSize);
        sb.append(" and Counter: ");
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            sb.append(trafficCounter);
        } else {
            sb.append("none");
        }
        return sb.toString();
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    protected int userDefinedWritabilityIndex() {
        return 1;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, this.writeLimit, this.maxTime, milliSecondFromNano);
            if (writeTimeToWait >= 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + ':' + channelHandlerContext.channel().config().isAutoRead() + ':' + isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, milliSecondFromNano, channelPromise);
                return;
            }
        }
        submitWrite(channelHandlerContext, obj, calculateSize, 0L, milliSecondFromNano, channelPromise);
    }

    public void configure(long j4, long j5) {
        this.writeLimit = j4;
        this.readLimit = j5;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public void configure(long j4) {
        this.checkInterval = j4;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(this.checkInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j4, long j5, long j6) {
        this(j4, j5, j6, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j4, long j5) {
        this(j4, j5, 1000L, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler() {
        this(0L, 0L, 1000L, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long j4) {
        this(0L, 0L, j4, 15000L);
    }
}
