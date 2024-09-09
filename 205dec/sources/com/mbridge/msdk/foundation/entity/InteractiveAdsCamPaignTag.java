package com.mbridge.msdk.foundation.entity;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class InteractiveAdsCamPaignTag implements NoProGuard, Serializable {
    private long campaignCreateTime;
    private String id;
    private int isClick;
    private int resourceType;

    public InteractiveAdsCamPaignTag() {
    }

    public long getCampaignCreateTime() {
        return this.campaignCreateTime;
    }

    public String getId() {
        return this.id;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public void setCampaignCreateTime(long j4) {
        this.campaignCreateTime = j4;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsClick(int i4) {
        this.isClick = i4;
    }

    public void setResourceType(int i4) {
        this.resourceType = i4;
    }

    public InteractiveAdsCamPaignTag(String str, int i4, long j4, int i5) {
        this.id = str;
        this.resourceType = i4;
        this.campaignCreateTime = j4;
        this.isClick = i5;
    }
}
