package com.kwad.components.core.webview.tachikoma.b;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class x extends com.kwad.sdk.core.response.a.a {
    public String aaw;
    public int errorCode;
    public String errorReason;
    public int nE;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.aaw);
    }

    public final boolean sR() {
        return TextUtils.equals(CampaignEx.JSON_NATIVE_VIDEO_START, this.aaw);
    }

    public final boolean sS() {
        return TextUtils.equals("end", this.aaw);
    }

    public final boolean sT() {
        return TextUtils.equals("progress", this.aaw);
    }

    public final int sU() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return 0;
        }
    }
}
