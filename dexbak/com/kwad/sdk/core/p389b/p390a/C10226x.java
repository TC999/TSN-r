package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10226x implements InterfaceC10273d<AdMatrixInfo.AdInteractionInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        m26636a(adInteractionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        return m26635b(adInteractionInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26636a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        AdMatrixInfo.ShakeInfo shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo = shakeInfo;
        shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        AdMatrixInfo.RotateInfo rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo = rotateInfo;
        rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo = splashSlideInfo;
        splashSlideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        AdMatrixInfo.SplashActionBarInfo splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo = splashActionBarInfo;
        splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adInteractionInfo.tkDefaultTimeout = jSONObject.optLong("tkDefaultTimeout", new Long("1500").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26635b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adInteractionInfo.interactiveStyle;
        if (i != 0) {
            C11126t.putValue(jSONObject, "interactiveStyle", i);
        }
        C11126t.putValue(jSONObject, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        boolean z = adInteractionInfo.isMediaDisable;
        if (z) {
            C11126t.putValue(jSONObject, "isMediaDisable", z);
        }
        C11126t.putValue(jSONObject, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        C11126t.m23678a(jSONObject, "shakeInfo", adInteractionInfo.shakeInfo);
        C11126t.m23678a(jSONObject, "rotateInfo", adInteractionInfo.rotateInfo);
        C11126t.m23678a(jSONObject, "slideInfo", adInteractionInfo.slideInfo);
        C11126t.m23678a(jSONObject, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        C11126t.putValue(jSONObject, "tkDefaultTimeout", adInteractionInfo.tkDefaultTimeout);
        return jSONObject;
    }
}
