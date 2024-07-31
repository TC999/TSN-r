package com.iab.omid.library.mmadbridge.adsession.media;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum InteractionType {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    
    String interactionType;

    InteractionType(String str) {
        this.interactionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.interactionType;
    }
}
