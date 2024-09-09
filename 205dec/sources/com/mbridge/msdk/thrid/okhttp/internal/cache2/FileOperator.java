package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j4, Buffer buffer, long j5) throws IOException {
        if (j5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j5 > 0) {
            long transferTo = this.fileChannel.transferTo(j4, j5, buffer);
            j4 += transferTo;
            j5 -= transferTo;
        }
    }

    public void write(long j4, Buffer buffer, long j5) throws IOException {
        if (j5 < 0 || j5 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j6 = j4;
        long j7 = j5;
        while (j7 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j6, j7);
            j6 += transferFrom;
            j7 -= transferFrom;
        }
    }
}
