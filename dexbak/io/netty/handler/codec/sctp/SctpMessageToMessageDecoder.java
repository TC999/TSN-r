package io.netty.handler.codec.sctp;

import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SctpMessageToMessageDecoder extends MessageToMessageDecoder<SctpMessage> {
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (obj instanceof SctpMessage) {
            if (((SctpMessage) obj).isComplete()) {
                return true;
            }
            throw new CodecException(String.format("Received SctpMessage is not complete, please add %s in the pipeline before this handler", SctpMessageCompletionHandler.class.getSimpleName()));
        }
        return false;
    }
}
