package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list) throws Exception;

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        boolean z;
        CodecOutputList codecOutputList = null;
        int i = 0;
        try {
            try {
                if (acceptOutboundMessage(obj)) {
                    try {
                        CodecOutputList newInstance = CodecOutputList.newInstance();
                        try {
                            encode(channelHandlerContext, obj, newInstance);
                            ReferenceCountUtil.release(obj);
                            if (newInstance.isEmpty()) {
                                newInstance.recycle();
                                throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                            }
                            codecOutputList = newInstance;
                        } catch (Throwable th) {
                            ReferenceCountUtil.release(obj);
                            throw th;
                        }
                    } catch (EncoderException e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        throw new EncoderException(th);
                    }
                } else {
                    channelHandlerContext.write(obj, channelPromise);
                }
                if (codecOutputList != null) {
                    int size = codecOutputList.size() - 1;
                    if (size == 0) {
                        channelHandlerContext.write(codecOutputList.get(0), channelPromise);
                    } else if (size > 0) {
                        ChannelPromise voidPromise = channelHandlerContext.voidPromise();
                        z = channelPromise == voidPromise;
                        while (i < size) {
                            channelHandlerContext.write(codecOutputList.getUnsafe(i), z ? voidPromise : channelHandlerContext.newPromise());
                            i++;
                        }
                        channelHandlerContext.write(codecOutputList.getUnsafe(size), channelPromise);
                    }
                    codecOutputList.recycle();
                }
            } catch (EncoderException e2) {
                throw e2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                int size2 = codecOutputList.size() - 1;
                if (size2 == 0) {
                    channelHandlerContext.write(codecOutputList.get(0), channelPromise);
                } else if (size2 > 0) {
                    ChannelPromise voidPromise2 = channelHandlerContext.voidPromise();
                    z = channelPromise == voidPromise2;
                    while (i < size2) {
                        channelHandlerContext.write(codecOutputList.getUnsafe(i), z ? voidPromise2 : channelHandlerContext.newPromise());
                        i++;
                    }
                    channelHandlerContext.write(codecOutputList.getUnsafe(size2), channelPromise);
                }
                codecOutputList.recycle();
            }
            throw th4;
        }
    }

    protected MessageToMessageEncoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
