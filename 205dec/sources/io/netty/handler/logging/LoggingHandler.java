package io.netty.handler.logging;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LoggingHandler extends ChannelDuplexHandler {
    private static final LogLevel DEFAULT_LEVEL = LogLevel.DEBUG;
    protected final InternalLogLevel internalLevel;
    private final LogLevel level;
    protected final InternalLogger logger;

    public LoggingHandler() {
        this(DEFAULT_LEVEL);
    }

    private static String formatByteBuf(ChannelHandlerContext channelHandlerContext, String str, ByteBuf byteBuf) {
        String obj = channelHandlerContext.channel().toString();
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            StringBuilder sb = new StringBuilder(obj.length() + 1 + str.length() + 4);
            sb.append(obj);
            sb.append(' ');
            sb.append(str);
            sb.append(": 0B");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(obj.length() + 1 + str.length() + 2 + 10 + 1 + 2 + (((readableBytes / 16) + (readableBytes % 15 == 0 ? 0 : 1) + 4) * 80));
        sb2.append(obj);
        sb2.append(' ');
        sb2.append(str);
        sb2.append(": ");
        sb2.append(readableBytes);
        sb2.append('B');
        sb2.append(StringUtil.NEWLINE);
        ByteBufUtil.appendPrettyHexDump(sb2, byteBuf);
        return sb2.toString();
    }

    private static String formatByteBufHolder(ChannelHandlerContext channelHandlerContext, String str, ByteBufHolder byteBufHolder) {
        String obj = channelHandlerContext.channel().toString();
        String obj2 = byteBufHolder.toString();
        ByteBuf content = byteBufHolder.content();
        int readableBytes = content.readableBytes();
        if (readableBytes == 0) {
            StringBuilder sb = new StringBuilder(obj.length() + 1 + str.length() + 2 + obj2.length() + 4);
            sb.append(obj);
            sb.append(' ');
            sb.append(str);
            sb.append(", ");
            sb.append(obj2);
            sb.append(", 0B");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(obj.length() + 1 + str.length() + 2 + obj2.length() + 2 + 10 + 1 + 2 + (((readableBytes / 16) + (readableBytes % 15 == 0 ? 0 : 1) + 4) * 80));
        sb2.append(obj);
        sb2.append(' ');
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj2);
        sb2.append(", ");
        sb2.append(readableBytes);
        sb2.append('B');
        sb2.append(StringUtil.NEWLINE);
        ByteBufUtil.appendPrettyHexDump(sb2, content);
        return sb2.toString();
    }

    private static String formatSimple(ChannelHandlerContext channelHandlerContext, String str, Object obj) {
        String obj2 = channelHandlerContext.channel().toString();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(obj2.length() + 1 + str.length() + 2 + valueOf.length());
        sb.append(obj2);
        sb.append(' ');
        sb.append(str);
        sb.append(": ");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "BIND", socketAddress));
        }
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "ACTIVE"));
        }
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "INACTIVE"));
        }
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "RECEIVED", obj));
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "REGISTERED"));
        }
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "UNREGISTERED"));
        }
        channelHandlerContext.fireChannelUnregistered();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "CLOSE"));
        }
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "CONNECT", socketAddress, socketAddress2));
        }
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "DEREGISTER"));
        }
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "DISCONNECT"));
        }
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "EXCEPTION", th), th);
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "FLUSH"));
        }
        channelHandlerContext.flush();
    }

    protected String format(ChannelHandlerContext channelHandlerContext, String str) {
        String obj = channelHandlerContext.channel().toString();
        StringBuilder sb = new StringBuilder(obj.length() + 1 + str.length());
        sb.append(obj);
        sb.append(' ');
        sb.append(str);
        return sb.toString();
    }

    public LogLevel level() {
        return this.level;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "USER_EVENT", obj));
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.logger.isEnabled(this.internalLevel)) {
            this.logger.log(this.internalLevel, format(channelHandlerContext, "WRITE", obj));
        }
        channelHandlerContext.write(obj, channelPromise);
    }

    public LoggingHandler(LogLevel logLevel) {
        if (logLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(getClass());
            this.level = logLevel;
            this.internalLevel = logLevel.toInternalLevel();
            return;
        }
        throw new NullPointerException("level");
    }

    protected String format(ChannelHandlerContext channelHandlerContext, String str, Object obj) {
        if (obj instanceof ByteBuf) {
            return formatByteBuf(channelHandlerContext, str, (ByteBuf) obj);
        }
        if (obj instanceof ByteBufHolder) {
            return formatByteBufHolder(channelHandlerContext, str, (ByteBufHolder) obj);
        }
        return formatSimple(channelHandlerContext, str, obj);
    }

    public LoggingHandler(Class<?> cls) {
        this(cls, DEFAULT_LEVEL);
    }

    public LoggingHandler(Class<?> cls, LogLevel logLevel) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        }
        if (logLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(cls);
            this.level = logLevel;
            this.internalLevel = logLevel.toInternalLevel();
            return;
        }
        throw new NullPointerException("level");
    }

    protected String format(ChannelHandlerContext channelHandlerContext, String str, Object obj, Object obj2) {
        if (obj2 == null) {
            return formatSimple(channelHandlerContext, str, obj);
        }
        String obj3 = channelHandlerContext.channel().toString();
        String valueOf = String.valueOf(obj);
        String obj4 = obj2.toString();
        return ((obj3.length() + 1) + str + 2 + valueOf.length() + 2 + obj4.length()) + obj3 + ' ' + str + ": " + valueOf + ", " + obj4;
    }

    public LoggingHandler(String str) {
        this(str, DEFAULT_LEVEL);
    }

    public LoggingHandler(String str, LogLevel logLevel) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (logLevel != null) {
            this.logger = InternalLoggerFactory.getInstance(str);
            this.level = logLevel;
            this.internalLevel = logLevel.toInternalLevel();
            return;
        }
        throw new NullPointerException("level");
    }
}
