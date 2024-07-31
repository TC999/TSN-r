package com.mbridge.msdk.foundation.download;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadError {
    private Exception exception;

    public DownloadError(Exception exc) {
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
