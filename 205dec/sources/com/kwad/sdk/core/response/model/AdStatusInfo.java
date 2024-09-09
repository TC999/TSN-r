package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdStatusInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadStatus;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setDownloadFinishTime(long j4) {
        this.downloadFinishTime = j4;
    }

    public void setDownloadSize(long j4) {
        this.downloadSize = j4;
    }

    public void setDownloadStatus(int i4) {
        this.downloadStatus = i4;
    }

    public void setDownloadType(int i4) {
        this.downloadType = i4;
    }

    public void setLoadDataTime(long j4) {
        this.loadDataTime = j4;
    }

    public void setLoadFromCache(boolean z3) {
        this.loadFromCache = z3;
    }
}
