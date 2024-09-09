package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FeedPageInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public String abParams;
    public int adNum;
    public int callbackType;
    public long convertDuration;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public long loadType;
    public List<a> materialInfoList = new ArrayList();
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId;
        public int materialType;
        public String materialUrl;

        public final a d(long j4) {
            this.creativeId = j4;
            return this;
        }

        public final a o(String str) {
            this.materialUrl = str;
            return this;
        }

        public final a u(int i4) {
            this.materialType = i4;
            return this;
        }
    }

    public FeedPageInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public FeedPageInfo setAdNum(int i4) {
        this.adNum = i4;
        return this;
    }

    public FeedPageInfo setCallbackType(int i4) {
        this.callbackType = i4;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j4) {
        this.convertDuration = j4;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i4) {
        this.expectedRenderType = i4;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j4) {
        this.loadDataDuration = j4;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i4) {
        this.loadStatus = i4;
        return this;
    }

    public FeedPageInfo setLoadType(long j4) {
        this.loadType = j4;
        return this;
    }

    public FeedPageInfo setMaterialInfoList(List<a> list) {
        this.materialInfoList = list;
        return this;
    }

    public FeedPageInfo setMaterialType(int i4) {
        this.materialType = i4;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j4) {
        this.renderDuration = j4;
        return this;
    }

    public FeedPageInfo setRenderType(int i4) {
        this.renderType = i4;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j4) {
        this.resourceLoadDuration = j4;
        return this;
    }

    public FeedPageInfo setStatus(int i4) {
        this.status = i4;
        return this;
    }

    public FeedPageInfo setType(int i4) {
        this.type = i4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorCode(int i4) {
        super.setErrorCode(i4);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setPosId(long j4) {
        return (FeedPageInfo) super.setPosId(j4);
    }
}
