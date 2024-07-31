package com.kwad.sdk.core.track;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11015ai;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdTrackLog extends C10482a implements Serializable {
    public static final int NEGATIVE_RESULT = 2;
    public static final int POSITIVE_RESULT = 1;
    private static int sLiveSupportMode = 2;
    private static final long serialVersionUID = 6629369763953107007L;
    public int adLiveComponentReady;
    public int adLiveSwitch;
    public int adTkLiveSwitch;
    public String apiSdkVersion;
    public int isPlugin;
    public int preLandingPageShowType;
    public int preLandingPageSwitch;
    public int rewardAdvanceSwitch;
    public int rewardDetailCallPositionY;
    public int rewardDetailStatusBarHeight;
    public int rewardSkipShowTime;
    public String sceneId;
    public int screenOrientation;
    public int serverCheckSwitch;
    public String templateId;

    private AdTrackLog() {
    }

    @Nullable
    public static AdTrackLog createFromJson(String str) {
        try {
            AdTrackLog adTrackLog = new AdTrackLog();
            adTrackLog.parseJson(new JSONObject(str));
            return adTrackLog;
        } catch (Exception unused) {
            return null;
        }
    }

    private int toReportInt(boolean z) {
        return z ? 1 : 2;
    }

    public void bindABParams(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.adLiveComponentReady = toReportInt(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24341oK());
        this.adLiveSwitch = toReportInt(C10483a.m25842cL(m25641dQ));
        this.adTkLiveSwitch = toReportInt(TextUtils.isEmpty(C10484b.m25720dU(m25641dQ)));
        if (sLiveSupportMode == 2 && ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24341oK()) {
            sLiveSupportMode = 1;
        }
        this.adLiveComponentReady = sLiveSupportMode;
        this.serverCheckSwitch = toReportInt(C10483a.m25828cZ(m25641dQ));
        this.rewardAdvanceSwitch = toReportInt(C10483a.m25799da(m25641dQ));
        this.rewardSkipShowTime = C10483a.m25931ae(m25641dQ);
        this.preLandingPageSwitch = toReportInt(C10484b.m25722dS(m25641dQ));
        this.preLandingPageShowType = C10484b.m25721dT(m25641dQ);
        this.apiSdkVersion = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
        this.isPlugin = toReportInt(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp());
        this.screenOrientation = toReportInt(C11015ai.isOrientationPortrait());
    }

    public AdTrackLog(String str, String str2) {
        this.templateId = str;
        this.sceneId = str2;
    }
}
