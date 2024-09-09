package io.netty.handler.codec.memcache;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;
import io.netty.handler.codec.memcache.MemcacheMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractMemcacheObjectAggregator<H extends MemcacheMessage> extends MessageAggregator<MemcacheObject, H, MemcacheContent, FullMemcacheMessage> {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMemcacheObjectAggregator(int i4) {
        super(i4);
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    protected boolean isContentLengthInvalid(H h4, int i4) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageAggregator
    protected /* bridge */ /* synthetic */ boolean isContentLengthInvalid(Object obj, int i4) throws Exception {
        return isContentLengthInvalid((AbstractMemcacheObjectAggregator<H>) ((MemcacheMessage) obj), i4);
    }

    protected Object newContinueResponse(H h4, int i4, ChannelPipeline channelPipeline) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageAggregator
    protected /* bridge */ /* synthetic */ Object newContinueResponse(Object obj, int i4, ChannelPipeline channelPipeline) throws Exception {
        return newContinueResponse((AbstractMemcacheObjectAggregator<H>) ((MemcacheMessage) obj), i4, channelPipeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof FullMemcacheMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof MemcacheContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(MemcacheContent memcacheContent) throws Exception {
        return memcacheContent instanceof LastMemcacheContent;
    }
}
