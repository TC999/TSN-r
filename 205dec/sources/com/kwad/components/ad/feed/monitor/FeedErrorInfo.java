package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FeedErrorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setFeedType(int i4) {
        this.feedType = i4;
        return this;
    }

    public FeedErrorInfo setMaterialType(long j4) {
        this.materialType = j4;
        return this;
    }

    public FeedErrorInfo setWidth(long j4) {
        this.width = j4;
        return this;
    }
}
