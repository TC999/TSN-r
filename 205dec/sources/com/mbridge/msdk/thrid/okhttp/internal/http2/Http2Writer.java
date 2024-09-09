package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Writer(BufferedSink bufferedSink, boolean z3) {
        this.sink = bufferedSink;
        this.client = z3;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i4, long j4) throws IOException {
        while (j4 > 0) {
            int min = (int) Math.min(this.maxFrameSize, j4);
            long j5 = min;
            j4 -= j5;
            frameHeader(i4, min, (byte) 9, j4 == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j5);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i4) throws IOException {
        bufferedSink.writeByte((i4 >>> 16) & 255);
        bufferedSink.writeByte((i4 >>> 8) & 255);
        bufferedSink.writeByte(i4 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void data(boolean z3, int i4, Buffer buffer, int i5) throws IOException {
        if (!this.closed) {
            dataFrame(i4, z3 ? (byte) 1 : (byte) 0, buffer, i5);
        } else {
            throw new IOException("closed");
        }
    }

    void dataFrame(int i4, byte b4, Buffer buffer, int i5) throws IOException {
        frameHeader(i4, i5, (byte) 0, b4);
        if (i5 > 0) {
            this.sink.write(buffer, i5);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i4, int i5, byte b4, byte b5) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i4, i5, b4, b5));
        }
        int i6 = this.maxFrameSize;
        if (i5 > i6) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
        }
        if ((Integer.MIN_VALUE & i4) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i4));
        }
        writeMedium(this.sink, i5);
        this.sink.writeByte(b4 & 255);
        this.sink.writeByte(b5 & 255);
        this.sink.writeInt(i4 & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i4, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.writeInt(i4);
                this.sink.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void headers(int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z3, int i4, int i5) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z3 ? (byte) 1 : (byte) 0);
            this.sink.writeInt(i4);
            this.sink.writeInt(i5);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int i4, int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            long j4 = min;
            frameHeader(i4, min + 4, (byte) 5, size == j4 ? (byte) 4 : (byte) 0);
            this.sink.writeInt(i5 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j4);
            if (size > j4) {
                writeContinuationFrames(i4, size - j4);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i4, ErrorCode errorCode) throws IOException {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(i4, 4, (byte) 3, (byte) 0);
                this.sink.writeInt(errorCode.httpCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            int i4 = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i4 < 10) {
                if (settings.isSet(i4)) {
                    this.sink.writeShort(i4 == 4 ? 3 : i4 == 7 ? 4 : i4);
                    this.sink.writeInt(settings.get(i4));
                }
                i4++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synReply(boolean z3, int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z3, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean z3, int i4, int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z3, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void windowUpdate(int i4, long j4) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j4 != 0 && j4 <= 2147483647L) {
            frameHeader(i4, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j4);
            this.sink.flush();
        } else {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
        }
    }

    void headers(boolean z3, int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize, size);
            long j4 = min;
            byte b4 = size == j4 ? (byte) 4 : (byte) 0;
            if (z3) {
                b4 = (byte) (b4 | 1);
            }
            frameHeader(i4, min, (byte) 1, b4);
            this.sink.write(this.hpackBuffer, j4);
            if (size > j4) {
                writeContinuationFrames(i4, size - j4);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
