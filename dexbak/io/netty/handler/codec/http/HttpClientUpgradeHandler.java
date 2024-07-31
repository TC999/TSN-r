package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HttpClientUpgradeHandler extends HttpObjectAggregator implements ChannelOutboundHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SourceCodec sourceCodec;
    private final UpgradeCodec upgradeCodec;
    private boolean upgradeRequested;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface SourceCodec {
        void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext);

        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface UpgradeCodec {
        CharSequence protocol();

        Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest);

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception;
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum UpgradeEvent {
        UPGRADE_ISSUED,
        UPGRADE_SUCCESSFUL,
        UPGRADE_REJECTED
    }

    public HttpClientUpgradeHandler(SourceCodec sourceCodec, UpgradeCodec upgradeCodec, int i) {
        super(i);
        if (sourceCodec == null) {
            throw new NullPointerException("sourceCodec");
        }
        if (upgradeCodec != null) {
            this.sourceCodec = sourceCodec;
            this.upgradeCodec = upgradeCodec;
            return;
        }
        throw new NullPointerException("upgradeCodec");
    }

    private static void removeThisHandler(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(channelHandlerContext.name());
    }

    private void setUpgradeRequestHeaders(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        httpRequest.headers().set(HttpHeaderNames.UPGRADE, this.upgradeCodec.protocol());
        LinkedHashSet<CharSequence> linkedHashSet = new LinkedHashSet(2);
        linkedHashSet.addAll(this.upgradeCodec.setUpgradeHeaders(channelHandlerContext, httpRequest));
        StringBuilder sb = new StringBuilder();
        for (CharSequence charSequence : linkedHashSet) {
            sb.append(charSequence);
            sb.append(StringUtil.COMMA);
        }
        sb.append((CharSequence) HttpHeaderValues.UPGRADE);
        httpRequest.headers().set(HttpHeaderNames.CONNECTION, sb.toString());
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator, io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Object obj, List list) throws Exception {
        decode(channelHandlerContext, (HttpObject) obj, (List<Object>) list);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof HttpRequest)) {
            channelHandlerContext.write(obj, channelPromise);
        } else if (this.upgradeRequested) {
            channelPromise.setFailure((Throwable) new IllegalStateException("Attempting to write HTTP request with upgrade in progress"));
        } else {
            this.upgradeRequested = true;
            setUpgradeRequestHeaders(channelHandlerContext, (HttpRequest) obj);
            channelHandlerContext.write(obj, channelPromise);
            channelHandlerContext.fireUserEventTriggered((Object) UpgradeEvent.UPGRADE_ISSUED);
        }
    }

    protected void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpResponse fullHttpResponse;
        FullHttpResponse fullHttpResponse2 = null;
        try {
            if (this.upgradeRequested) {
                if (httpObject instanceof FullHttpResponse) {
                    fullHttpResponse = (FullHttpResponse) httpObject;
                    try {
                        fullHttpResponse.retain();
                        list.add(fullHttpResponse);
                    } catch (Throwable th) {
                        th = th;
                        fullHttpResponse2 = fullHttpResponse;
                        ReferenceCountUtil.release(fullHttpResponse2);
                        channelHandlerContext.fireExceptionCaught(th);
                        removeThisHandler(channelHandlerContext);
                        return;
                    }
                } else {
                    super.decode(channelHandlerContext, (ChannelHandlerContext) httpObject, list);
                    if (list.isEmpty()) {
                        return;
                    }
                    fullHttpResponse = (FullHttpResponse) list.get(0);
                }
                FullHttpResponse fullHttpResponse3 = fullHttpResponse;
                if (!HttpResponseStatus.SWITCHING_PROTOCOLS.equals(fullHttpResponse3.status())) {
                    channelHandlerContext.fireUserEventTriggered((Object) UpgradeEvent.UPGRADE_REJECTED);
                    removeThisHandler(channelHandlerContext);
                    return;
                }
                String str = fullHttpResponse3.headers().get(HttpHeaderNames.UPGRADE);
                if (str != null && !AsciiString.contentEqualsIgnoreCase(this.upgradeCodec.protocol(), str)) {
                    throw new IllegalStateException("Switching Protocols response with unexpected UPGRADE protocol: " + ((Object) str));
                }
                this.sourceCodec.prepareUpgradeFrom(channelHandlerContext);
                this.upgradeCodec.upgradeTo(channelHandlerContext, fullHttpResponse3);
                channelHandlerContext.fireUserEventTriggered((Object) UpgradeEvent.UPGRADE_SUCCESSFUL);
                this.sourceCodec.upgradeFrom(channelHandlerContext);
                fullHttpResponse3.release();
                list.clear();
                removeThisHandler(channelHandlerContext);
                return;
            }
            throw new IllegalStateException("Read HTTP response without requesting protocol switch");
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
