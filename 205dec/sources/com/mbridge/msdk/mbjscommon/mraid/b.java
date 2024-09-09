package com.mbridge.msdk.mbjscommon.mraid;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: IMraidJSBridge.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface b {
    void close();

    void expand(String str, boolean z3);

    CampaignEx getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z3);
}
