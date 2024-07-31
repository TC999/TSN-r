package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdStatusInfo extends C10482a implements Serializable {
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

    public void setDownloadFinishTime(long j) {
        this.downloadFinishTime = j;
    }

    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public void setLoadDataTime(long j) {
        this.loadDataTime = j;
    }

    public void setLoadFromCache(boolean z) {
        this.loadFromCache = z;
    }
}
