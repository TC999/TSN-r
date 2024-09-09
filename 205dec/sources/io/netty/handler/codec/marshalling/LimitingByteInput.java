package io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;

        TooBigObjectException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LimitingByteInput(ByteInput byteInput, long j4) {
        if (j4 > 0) {
            this.input = byteInput;
            this.limit = j4;
            return;
        }
        throw new IllegalArgumentException("The limit MUST be > 0");
    }

    private int readable(int i4) {
        return (int) Math.min(i4, this.limit - this.read);
    }

    public int available() throws IOException {
        return readable(this.input.available());
    }

    public void close() throws IOException {
    }

    public int read() throws IOException {
        if (readable(1) > 0) {
            int read = this.input.read();
            this.read++;
            return read;
        }
        throw EXCEPTION;
    }

    public long skip(long j4) throws IOException {
        int readable = readable((int) j4);
        if (readable > 0) {
            long skip = this.input.skip(readable);
            this.read += skip;
            return skip;
        }
        throw EXCEPTION;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int readable = readable(i5);
        if (readable > 0) {
            int read = this.input.read(bArr, i4, readable);
            this.read += read;
            return read;
        }
        throw EXCEPTION;
    }
}
