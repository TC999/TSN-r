package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteOutput;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public void close() throws IOException {
    }

    public void flush() throws IOException {
    }

    ByteBuf getBuffer() {
        return this.buffer;
    }

    public void write(int i4) throws IOException {
        this.buffer.writeByte(i4);
    }

    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.buffer.writeBytes(bArr, i4, i5);
    }
}
