package com.mbridge.msdk.mbjscommon.mraid;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* renamed from: com.mbridge.msdk.mbjscommon.mraid.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IMraidJSBridge {
    void close();

    void expand(String str, boolean z);

    CampaignEx getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z);
}
