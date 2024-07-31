package com.kwad.components.core.webview.tachikoma.p334b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.mbridge.msdk.foundation.entity.CampaignEx;

@KsJson
/* renamed from: com.kwad.components.core.webview.tachikoma.b.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9263x extends C10482a {
    public String aaw;
    public int errorCode;
    public String errorReason;

    /* renamed from: nE */
    public int f29320nE;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.aaw);
    }

    /* renamed from: sR */
    public final boolean m29165sR() {
        return TextUtils.equals(CampaignEx.JSON_NATIVE_VIDEO_START, this.aaw);
    }

    /* renamed from: sS */
    public final boolean m29164sS() {
        return TextUtils.equals("end", this.aaw);
    }

    /* renamed from: sT */
    public final boolean m29163sT() {
        return TextUtils.equals(NotificationCompat.CATEGORY_PROGRESS, this.aaw);
    }

    /* renamed from: sU */
    public final int m29162sU() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            C10331c.printStackTrace(e);
            return 0;
        }
    }
}
