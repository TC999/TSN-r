package com.mbridge.msdk.foundation.entity;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class InteractiveAdsCamPaignTag implements NoProGuard, Serializable {
    private long campaignCreateTime;

    /* renamed from: id */
    private String f30414id;
    private int isClick;
    private int resourceType;

    public InteractiveAdsCamPaignTag() {
    }

    public long getCampaignCreateTime() {
        return this.campaignCreateTime;
    }

    public String getId() {
        return this.f30414id;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public void setCampaignCreateTime(long j) {
        this.campaignCreateTime = j;
    }

    public void setId(String str) {
        this.f30414id = str;
    }

    public void setIsClick(int i) {
        this.isClick = i;
    }

    public void setResourceType(int i) {
        this.resourceType = i;
    }

    public InteractiveAdsCamPaignTag(String str, int i, long j, int i2) {
        this.f30414id = str;
        this.resourceType = i;
        this.campaignCreateTime = j;
        this.isClick = i2;
    }
}
