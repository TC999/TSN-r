package com.mbridge.msdk.foundation.download;

import com.mbridge.msdk.foundation.download.utils.Objects;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
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

    public void setCancelled(boolean z3) {
        this._isCancelled = z3;
    }

    public void setError(DownloadError downloadError) {
        this._error = downloadError;
        setSuccessful(false);
    }

    public void setFrom(int i4) {
        this.from = i4;
    }

    public void setSuccessful(boolean z3) {
        this._isSuccessful = z3;
    }

    public void setError(Exception exc) {
        setError(new DownloadError(exc));
    }
}
