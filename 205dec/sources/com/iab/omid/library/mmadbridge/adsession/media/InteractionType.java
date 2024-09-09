package com.iab.omid.library.mmadbridge.adsession.media;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum InteractionType {
    CLICK("click"),
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
