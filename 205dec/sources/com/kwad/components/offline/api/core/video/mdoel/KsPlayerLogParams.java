package com.kwad.components.offline.api.core.video.mdoel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsPlayerLogParams {
    public long adStyle;
    public long clickTime = -1;
    public int contentType;
    public long photoId;

    public KsPlayerLogParams setAdStyle(long j4) {
        this.adStyle = j4;
        return this;
    }

    public KsPlayerLogParams setClickTime(long j4) {
        this.clickTime = j4;
        return this;
    }

    public KsPlayerLogParams setContentType(int i4) {
        this.contentType = i4;
        return this;
    }

    public KsPlayerLogParams setPhotoId(long j4) {
        this.photoId = j4;
        return this;
    }
}
