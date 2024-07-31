package com.mbridge.msdk.foundation.download;

import com.mbridge.msdk.foundation.download.utils.Objects;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadResponse {
    private static final String UN_KNOWN = "unknown";
    private DownloadError _error;
    private boolean _isCancelled;
    private boolean _isSuccessful;
    private int from = 0;

    public DownloadError getError() {
        return this._error;
    }

    public String getErrorMessage() {
        return (Objects.isNull(getError()) || Objects.isNull(getError().getException())) ? "unknown" : getError().getException().getMessage();
    }

    public int getFrom() {
        return this.from;
    }

    public boolean isCancelled() {
        return this._isCancelled;
    }

    public boolean isSuccessful() {
        return this._isSuccessful;
    }

    public void setCancelled(boolean z) {
        this._isCancelled = z;
    }

    public void setError(DownloadError downloadError) {
        this._error = downloadError;
        setSuccessful(false);
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setSuccessful(boolean z) {
        this._isSuccessful = z;
    }

    public void setError(Exception exc) {
        setError(new DownloadError(exc));
    }
}
