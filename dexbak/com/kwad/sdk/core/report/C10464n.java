package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10972j;
import com.kwad.sdk.utils.C11126t;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.sdk.core.report.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10464n extends AbstractC10453e {

    /* renamed from: IB */
    public String f29562IB;

    /* renamed from: IC */
    public String f29563IC;

    /* renamed from: IE */
    public long f29564IE;

    /* renamed from: KG */
    public String f29565KG;

    /* renamed from: Ra */
    public String f29566Ra;

    /* renamed from: Rh */
    public long f29567Rh;

    /* renamed from: Ri */
    public long f29568Ri;

    /* renamed from: Rj */
    public long f29569Rj;

    /* renamed from: Sd */
    public long f29570Sd;

    /* renamed from: VU */
    public long f29571VU;

    /* renamed from: WQ */
    public String f29572WQ;

    /* renamed from: Xt */
    public int f29573Xt;
    public long actionType;
    public transient SceneImpl adScene;
    public long auc;
    public long axI;
    public JSONObject axJ;
    public JSONObject axK;
    public long axL;
    public long axM;
    public long axN;
    public long axO;
    public long axP;
    public long axR;
    public URLPackage axS;
    public String axT;
    public JSONArray axU;
    public JSONArray axV;
    public C10465a axW;
    public int axX;
    public int axY;
    public int axZ;
    public long ayA;
    public long ayB;
    public JSONArray ayC;
    public String ayD;
    public String ayE;
    public String ayF;
    public String ayG;
    public String ayH;
    public String ayJ;
    public String ayK;
    public int ayL;
    public long ayO;
    public long ayP;
    public String ayQ;
    public int aya;
    public String ayb;
    public int ayc;
    public int ayd;
    public String aye;
    public JSONObject ayf;
    public JSONArray ayg;
    public int ayh;
    public int ayi;
    public int ayj;
    public JSONArray ayl;
    public boolean aym;
    public String ayn;
    public long ayq;
    public int ayr;
    public String ays;
    public long ayt;
    public long ayu;
    public long ayv;
    public long ayw;
    public String ayx;
    public int ayy;
    public JSONArray ayz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long axQ = -1;
    public int apY = 0;
    public long ayk = 0;
    public int ayo = 0;
    public int ayp = -1;
    public int ayI = 0;
    public int ayM = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String ayN = BuildConfig.VERSION_NAME;

    @KsJson
    /* renamed from: com.kwad.sdk.core.report.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10465a extends C10482a {
        public int ayR;
        public int ayS;

        /* renamed from: EO */
        public static C10465a m26013EO() {
            C10465a c10465a = new C10465a();
            c10465a.ayR = C10466b.ayR;
            c10465a.ayS = C10466b.ayS;
            return c10465a;
        }
    }

    /* renamed from: com.kwad.sdk.core.report.n$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10466b {
        public static int ayR;
        public static int ayS;
    }

    public C10464n(long j) {
        this.f29572WQ = ServiceProvider.get(InterfaceC10968f.class) == null ? "" : ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j;
    }

    /* renamed from: bX */
    private void m26014bX(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.axY = 3;
            InterfaceC10471s interfaceC10471s = (InterfaceC10471s) ServiceProvider.get(InterfaceC10471s.class);
            if (interfaceC10471s != null) {
                this.ayo = interfaceC10471s.mo24873tA();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = C10472t.m26005ET();
            try {
                this.f29564IE = C10472t.m26004EU();
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            this.axI = C10472t.m26003EV();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.axL = adTemplate.getServerPosition() + 1;
                this.llsid = C10487e.m25644dN(adTemplate);
                String m25643dO = C10487e.m25643dO(adTemplate);
                if (!TextUtils.isEmpty(m25643dO)) {
                    try {
                        this.axJ = new JSONObject(m25643dO);
                    } catch (Exception e2) {
                        C10331c.printStackTraceOnly(e2);
                    }
                }
                String m25642dP = C10487e.m25642dP(adTemplate);
                if (!TextUtils.isEmpty(m25642dP)) {
                    try {
                        this.axK = new JSONObject(m25642dP);
                    } catch (Exception e3) {
                        C10331c.printStackTraceOnly(e3);
                    }
                }
                this.posId = C10487e.m25648dJ(adTemplate);
                this.contentType = C10487e.m25645dM(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = C10487e.m25635dW(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
                    this.creativeId = m25641dQ.adBaseInfo.creativeId;
                    this.axM = C10483a.m25976L(m25641dQ) * 1000;
                    this.f29570Sd = m25641dQ.advertiserInfo.userId;
                }
                this.axX = adTemplate.mMediaPlayerType;
                this.axZ = adTemplate.mIsLeftSlipStatus;
                this.aya = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = C10487e.m25634dX(adTemplate);
            }
            this.axW = C10465a.m26013EO();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            C10331c.printStackTraceOnly(e4);
        }
    }

    /* renamed from: EM */
    public final C10464n m26016EM() {
        m26014bX(this.mAdTemplate);
        return this;
    }

    /* renamed from: EN */
    public final void m26015EN() {
        InterfaceC10972j interfaceC10972j = (InterfaceC10972j) ServiceProvider.get(InterfaceC10972j.class);
        this.ayh = interfaceC10972j.mo24298qB() ? 1 : 0;
        this.ayi = interfaceC10972j.mo24297qC();
        this.ayj = interfaceC10972j.mo24296qD();
    }

    @Override // com.kwad.sdk.core.report.AbstractC10453e, com.kwad.sdk.core.response.p408a.C10482a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.axY = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.ayd = jSONObject.optInt("num");
        this.ayc = jSONObject.optInt("state");
        this.ayk = jSONObject.optLong("timeSpend");
        this.ayA = jSONObject.optLong("loadingDuration");
        this.ayB = jSONObject.optLong("loadingDurationLimt");
        this.ayp = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.AbstractC10453e, com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        C11126t.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            C11126t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.ayd;
        if (i2 > 0) {
            C11126t.putValue(jSONObject, "num", i2);
        }
        int i3 = this.ayc;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "state", i3);
        }
        long j = this.ayk;
        if (j > 0) {
            C11126t.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.ayA;
        if (j2 > 0) {
            C11126t.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.ayB;
        if (j3 > 0) {
            C11126t.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        C11126t.putValue(jSONObject, "playerTypeInfo", this.ayp);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.ayQ)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.ayQ + '}';
    }

    public C10464n(long j, @Nullable AdTemplate adTemplate) {
        this.f29572WQ = ServiceProvider.get(InterfaceC10968f.class) == null ? "" : ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public C10464n(long j, @Nullable AdTemplate adTemplate, String str) {
        this.f29572WQ = ServiceProvider.get(InterfaceC10968f.class) == null ? "" : ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.f29565KG = str;
    }

    public C10464n(String str, String str2, boolean z) {
        this.f29572WQ = ServiceProvider.get(InterfaceC10968f.class) == null ? "" : ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
        this.sdkType = 1;
        this.actionId = str;
        this.ayQ = str2;
    }
}
