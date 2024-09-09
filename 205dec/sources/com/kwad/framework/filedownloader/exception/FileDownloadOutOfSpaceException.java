package com.kwad.framework.filedownloader.exception;

import android.annotation.TargetApi;
import com.kwad.framework.filedownloader.f.f;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j4, long j5, long j6, Throwable th) {
        super(f.b("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)), th);
        init(j4, j5, j6);
    }

    private void init(long j4, long j5, long j6) {
        this.freeSpaceBytes = j4;
        this.requiredSpaceBytes = j5;
        this.breakpointBytes = j6;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }

    public FileDownloadOutOfSpaceException(long j4, long j5, long j6) {
        super(f.b("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)));
        init(j4, j5, j6);
    }
}
