package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.C8931c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.request.model.C10474a;
import com.kwad.sdk.core.request.model.C10481g;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11120o;
import com.kwad.sdk.utils.C11124s;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.C11137y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8910a extends AbstractC10418d {

    /* renamed from: Ro */
    private static boolean f28795Ro = true;

    /* renamed from: Mv */
    ImpInfo f28796Mv;

    /* renamed from: Rn */
    private int f28797Rn;

    public C8910a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    /* renamed from: a */
    private static void m29619a(C10481g c10481g, AdLabelImpl adLabelImpl) {
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            c10481g.thirdAge = i;
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            c10481g.thirdGender = i2;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        c10481g.thirdInterest = adLabelImpl.thirdInterest;
    }

    /* renamed from: c */
    private static int m29616c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: d */
    private static String m29615d(ImpInfo impInfo) {
        InterfaceC10968f interfaceC10968f;
        if (f28795Ro && (interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)) != null) {
            try {
                return (String) C11124s.m23689f(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), interfaceC10968f.getContext());
            } catch (Exception unused) {
                f28795Ro = false;
            }
        }
        return "";
    }

    /* renamed from: aF */
    public final void m29617aF(int i) {
        this.f28797Rn = i;
    }

    public final int getAdNum() {
        return this.f28796Mv.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.f28796Mv;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public String getUrl() {
        return C10760g.m24894xW();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10418d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public void onCreate() {
        C11120o.m23753bR(true);
        C8911b.m29612qn().m29611qo();
        super.onCreate();
    }

    private C8910a(ImpInfo impInfo, C8931c c8931c) {
        this(impInfo, null, false, null);
    }

    public C8910a(C8927a c8927a) {
        this(c8927a.f28803Mv, c8927a.f28807Rw, c8927a.f28808Rx, c8927a.f28810Rz);
        this.f28797Rn = c8927a.f28809Ry ? 1 : 0;
    }

    public C8910a(ImpInfo impInfo, @Nullable List<String> list, boolean z, C8931c c8931c) {
        super(m29616c(impInfo), impInfo.adScene);
        this.f28796Mv = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            m29618a(C10474a.m25996EY(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        C11126t.m23679a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", c8931c);
        int i = this.f28797Rn;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        C9861c.m27501f(DevelopMangerComponents.class);
        String mo27499AY = TextUtils.isEmpty("") ? ((DevelopMangerComponents) C9861c.m27501f(DevelopMangerComponents.class)).mo27499AY() : "";
        if (!TextUtils.isEmpty(mo27499AY)) {
            putBody("universeDebugParam", mo27499AY);
        }
        String m29615d = m29615d(impInfo);
        if (!TextUtils.isEmpty(m29615d)) {
            putBody("sdkDebugReqInfo", m29615d);
        }
        C9861c.m27501f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", C11137y.m23634LK());
        C9861c.m27501f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.f28796Mv.getRewardCallbackExtraByKey("thirdUserId");
        C10481g m25982Ff = C10481g.m25982Ff();
        if (rewardCallbackExtraByKey != null) {
            m25982Ff.m25981eo(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            m29619a(m25982Ff, adLabelFromAdScene);
        }
        putBody("userInfo", m25982Ff);
    }

    /* renamed from: a */
    private void m29618a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            C11126t.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            C11126t.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            C11126t.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            C11126t.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        C11126t.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
