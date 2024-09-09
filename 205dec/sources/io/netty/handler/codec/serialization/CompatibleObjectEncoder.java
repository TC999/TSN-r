package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final AttributeKey<ObjectOutputStream> OOS = AttributeKey.valueOf(CompatibleObjectEncoder.class, "OOS");
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    protected ObjectOutputStream newObjectOutputStream(OutputStream outputStream) throws Exception {
        return new ObjectOutputStream(outputStream);
    }

    public CompatibleObjectEncoder(int i4) {
        if (i4 >= 0) {
            this.resetInterval = i4;
            return;
        }
        throw new IllegalArgumentException("resetInterval: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws Exception {
        Attribute attr = channelHandlerContext.attr(OOS);
        ObjectOutputStream objectOutputStream = (ObjectOutputStream) attr.get();
        if (objectOutputStream == null) {
            objectOutputStream = newObjectOutputStream(new ByteBufOutputStream(byteBuf));
            ObjectOutputStream objectOutputStream2 = (ObjectOutputStream) attr.setIfAbsent(objectOutputStream);
            if (objectOutputStream2 != null) {
                objectOutputStream = objectOutputStream2;
            }
        }
        synchronized (objectOutputStream) {
            int i4 = this.resetInterval;
            if (i4 != 0) {
                int i5 = this.writtenObjects + 1;
                this.writtenObjects = i5;
                if (i5 % i4 == 0) {
                    objectOutputStream.reset();
                }
            }
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
        }
    }
}
