package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i4, List<Object> list) throws Exception;

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        boolean z3;
        CodecOutputList codecOutputList = null;
        int i4 = 0;
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
                    } catch (EncoderException e4) {
                        throw e4;
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
                        z3 = channelPromise == voidPromise;
                        while (i4 < size) {
                            channelHandlerContext.write(codecOutputList.getUnsafe(i4), z3 ? voidPromise : channelHandlerContext.newPromise());
                            i4++;
                        }
                        channelHandlerContext.write(codecOutputList.getUnsafe(size), channelPromise);
                    }
                    codecOutputList.recycle();
                }
            } catch (EncoderException e5) {
                throw e5;
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
                    z3 = channelPromise == voidPromise2;
                    while (i4 < size2) {
                        channelHandlerContext.write(codecOutputList.getUnsafe(i4), z3 ? voidPromise2 : channelHandlerContext.newPromise());
                        i4++;
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
