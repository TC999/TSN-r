package com.mbridge.msdk.out;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Frame {
    private List<CampaignEx> campaigns;
    private String parentSessionId;
    private String sessionId;
    private int template;

    public List<CampaignEx> getCampaigns() {
        return this.campaigns;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.campaigns = list;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTemplate(int i4) {
        this.template = i4;
    }
}
