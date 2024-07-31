package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ContextBoundUnmarshallerProvider extends DefaultUnmarshallerProvider {
    private static final AttributeKey<Unmarshaller> UNMARSHALLER = AttributeKey.valueOf(ContextBoundUnmarshallerProvider.class, "UNMARSHALLER");

    public ContextBoundUnmarshallerProvider(MarshallerFactory marshallerFactory, MarshallingConfiguration marshallingConfiguration) {
        super(marshallerFactory, marshallingConfiguration);
    }

    @Override // io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider, io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext channelHandlerContext) throws Exception {
        Attribute attr = channelHandlerContext.attr(UNMARSHALLER);
        Unmarshaller unmarshaller = (Unmarshaller) attr.get();
        if (unmarshaller == null) {
            Unmarshaller unmarshaller2 = super.getUnmarshaller(channelHandlerContext);
            attr.set(unmarshaller2);
            return unmarshaller2;
        }
        return unmarshaller;
    }
}
