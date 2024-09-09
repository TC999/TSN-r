package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ForwardingSink;
import com.mbridge.msdk.thrid.okio.Sink;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e4) {
            this.hasErrors = true;
            onException(e4);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e4) {
            this.hasErrors = true;
            onException(e4);
        }
    }

    protected void onException(IOException iOException) {
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j4) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j4);
            return;
        }
        try {
            super.write(buffer, j4);
        } catch (IOException e4) {
            this.hasErrors = true;
            onException(e4);
        }
    }
}
