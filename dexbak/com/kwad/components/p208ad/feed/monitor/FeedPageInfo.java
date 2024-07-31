package com.kwad.components.p208ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* renamed from: com.kwad.components.ad.feed.monitor.FeedPageInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FeedPageInfo extends AbstractC9822a implements Serializable {
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
    public List<C7599a> materialInfoList = new ArrayList();
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    @KsJson
    /* renamed from: com.kwad.components.ad.feed.monitor.FeedPageInfo$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7599a extends C10482a {
        public long creativeId;
        public int materialType;
        public String materialUrl;

        /* renamed from: d */
        public final C7599a m32828d(long j) {
            this.creativeId = j;
            return this;
        }

        /* renamed from: o */
        public final C7599a m32827o(String str) {
            this.materialUrl = str;
            return this;
        }

        /* renamed from: u */
        public final C7599a m32826u(int i) {
            this.materialType = i;
            return this;
        }
    }

    public FeedPageInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public FeedPageInfo setAdNum(int i) {
        this.adNum = i;
        return this;
    }

    public FeedPageInfo setCallbackType(int i) {
        this.callbackType = i;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j) {
        this.convertDuration = j;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i) {
        this.expectedRenderType = i;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j) {
        this.loadDataDuration = j;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i) {
        this.loadStatus = i;
        return this;
    }

    public FeedPageInfo setLoadType(long j) {
        this.loadType = j;
        return this;
    }

    public FeedPageInfo setMaterialInfoList(List<C7599a> list) {
        this.materialInfoList = list;
        return this;
    }

    public FeedPageInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public FeedPageInfo setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j) {
        this.resourceLoadDuration = j;
        return this;
    }

    public FeedPageInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public FeedPageInfo setType(int i) {
        this.type = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public FeedPageInfo setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public FeedPageInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public FeedPageInfo setPosId(long j) {
        return (FeedPageInfo) super.setPosId(j);
    }
}
