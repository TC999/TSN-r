package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import kotlin.UByte;
import org.jboss.marshalling.ByteInput;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelBufferByteInput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public int available() throws IOException {
        return this.buffer.readableBytes();
    }

    public void close() throws IOException {
    }

    public int read() throws IOException {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & UByte.f41242c;
        }
        return -1;
    }

    public long skip(long j) throws IOException {
        ByteBuf byteBuf;
        long readableBytes = this.buffer.readableBytes();
        if (readableBytes < j) {
            j = readableBytes;
        }
        this.buffer.readerIndex((int) (byteBuf.readerIndex() + j));
        return j;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i2);
        this.buffer.readBytes(bArr, i, min);
        return min;
    }
}
