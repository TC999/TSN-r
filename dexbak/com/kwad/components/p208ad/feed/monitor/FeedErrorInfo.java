package com.kwad.components.p208ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;

@KsJson
/* renamed from: com.kwad.components.ad.feed.monitor.FeedErrorInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FeedErrorInfo extends AbstractC9822a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setFeedType(int i) {
        this.feedType = i;
        return this;
    }

    public FeedErrorInfo setMaterialType(long j) {
        this.materialType = j;
        return this;
    }

    public FeedErrorInfo setWidth(long j) {
        this.width = j;
        return this;
    }
}
