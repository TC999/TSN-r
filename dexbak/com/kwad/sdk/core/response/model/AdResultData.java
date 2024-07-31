package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.p376e.C9830a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p385a.InterfaceC9890e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdResultData extends BaseResultData implements InterfaceC9914b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public AdGlobalConfigInfo adGlobalConfigInfo;
    public boolean hasMore;
    private String mAdSource;
    private List<AdTemplate> mAdTemplateList;
    @Nullable
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    private SceneImpl mScene;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i) {
        AdVideoPreCacheConfig adVideoPreCacheConfig;
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        return (adGlobalConfigInfo == null || (adVideoPreCacheConfig = adGlobalConfigInfo.adVideoPreCacheConfig) == null) ? new AdVideoPreCacheConfig(i, false) : adVideoPreCacheConfig;
    }

    public SceneImpl getAdScene(long j) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public String getAdSource() {
        String str = this.mAdSource;
        return str != null ? str : "network";
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null || adTemplateList.size() == 0) {
            return null;
        }
        return adTemplateList.get(0);
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    @NonNull
    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null) {
            return arrayList;
        }
        int size = adTemplateList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(adTemplateList.get(i));
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        C11126t.putValue(json, "pcursor", this.pcursor);
        C11126t.m23678a(json, "pageInfo", this.pageInfo);
        C11126t.putValue(json, "impAdInfo", ((InterfaceC9890e) C9861c.m27501f(InterfaceC9890e.class)).mo27426al(C11126t.m23681O(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            C10331c.m26246w(TAG, "adTemplateList is empty");
            return true;
        }
        C10331c.m26254d(TAG, "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            C10331c.m26246w(TAG, "adInfoList is empty");
            return true;
        } else if (list.get(0) == null) {
            C10331c.m26246w(TAG, "adInfo is null");
            return true;
        } else {
            return false;
        }
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && C10487e.m25627ee(proceedTemplateList.get(0)) > 0;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String optString = jSONObject.optString("adGlobalConfigInfo");
            InterfaceC9890e interfaceC9890e = (InterfaceC9890e) C9861c.m27501f(InterfaceC9890e.class);
            if (!C11053bg.isNullString(optString)) {
                String responseData = interfaceC9890e.getResponseData(optString);
                AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                this.adGlobalConfigInfo = adGlobalConfigInfo;
                adGlobalConfigInfo.parseJson(new JSONObject(responseData));
            }
            try {
                String optString2 = jSONObject.optString("pageInfo");
                if (!C11053bg.isNullString(optString2)) {
                    this.pageInfo.parseJson(new JSONObject(interfaceC9890e.getResponseData(optString2)));
                }
            } catch (Exception e) {
                C10331c.m26254d("json bug", e.toString());
                C10331c.printStackTrace(e);
            }
            String optString3 = jSONObject.optString("impAdInfo");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            String responseData2 = interfaceC9890e.getResponseData(optString3);
            if (C11053bg.isNullString(responseData2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(responseData2);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(optJSONObject);
                    adTemplate.llsid = this.llsid;
                    adTemplate.extra = this.extra;
                    adTemplate.mAdScene = getAdScene(adTemplate.posId);
                    adTemplate.mPageInfo = this.pageInfo;
                    this.mAdTemplateList.add(adTemplate);
                    C9830a.m27579bA(adTemplate);
                }
            }
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    public void setAdSource(String str) {
        this.mAdSource = str;
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        C11126t.putValue(json, "pcursor", this.pcursor);
        C11126t.putValue(json, "hasMore", this.hasMore);
        C11126t.m23678a(json, "pageInfo", this.pageInfo);
        C11126t.putValue(json, "impAdInfo", getAdTemplateList());
        C11126t.m23678a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        return json;
    }

    @NonNull
    /* renamed from: clone */
    public AdResultData m60138clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return adResultData;
        }
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        if (sceneImpl != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }
}
