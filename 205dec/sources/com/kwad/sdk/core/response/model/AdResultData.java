package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
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

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i4) {
        AdVideoPreCacheConfig adVideoPreCacheConfig;
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        return (adGlobalConfigInfo == null || (adVideoPreCacheConfig = adGlobalConfigInfo.adVideoPreCacheConfig) == null) ? new AdVideoPreCacheConfig(i4, false) : adVideoPreCacheConfig;
    }

    public SceneImpl getAdScene(long j4) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j4)) : null;
        return sceneImpl == null ? new SceneImpl(j4) : sceneImpl;
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
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(adTemplateList.get(i4));
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.a(json, "pageInfo", this.pageInfo);
        t.putValue(json, "impAdInfo", ((e) c.f(e.class)).al(t.O(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            com.kwad.sdk.core.e.c.w("AdResultData", "adTemplateList is empty");
            return true;
        }
        com.kwad.sdk.core.e.c.d("AdResultData", "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            com.kwad.sdk.core.e.c.w("AdResultData", "adInfoList is empty");
            return true;
        } else if (list.get(0) == null) {
            com.kwad.sdk.core.e.c.w("AdResultData", "adInfo is null");
            return true;
        } else {
            return false;
        }
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && com.kwad.sdk.core.response.b.e.ee(proceedTemplateList.get(0)) > 0;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String optString = jSONObject.optString("adGlobalConfigInfo");
            e eVar = (e) c.f(e.class);
            if (!bg.isNullString(optString)) {
                String responseData = eVar.getResponseData(optString);
                AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                this.adGlobalConfigInfo = adGlobalConfigInfo;
                adGlobalConfigInfo.parseJson(new JSONObject(responseData));
            }
            try {
                String optString2 = jSONObject.optString("pageInfo");
                if (!bg.isNullString(optString2)) {
                    this.pageInfo.parseJson(new JSONObject(eVar.getResponseData(optString2)));
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.d("json bug", e4.toString());
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
            String optString3 = jSONObject.optString("impAdInfo");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            String responseData2 = eVar.getResponseData(optString3);
            if (bg.isNullString(responseData2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(responseData2);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(optJSONObject);
                    adTemplate.llsid = this.llsid;
                    adTemplate.extra = this.extra;
                    adTemplate.mAdScene = getAdScene(adTemplate.posId);
                    adTemplate.mPageInfo = this.pageInfo;
                    this.mAdTemplateList.add(adTemplate);
                    com.kwad.sdk.commercial.e.a.bA(adTemplate);
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
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

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.putValue(json, "hasMore", this.hasMore);
        t.a(json, "pageInfo", this.pageInfo);
        t.putValue(json, "impAdInfo", getAdTemplateList());
        t.a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        return json;
    }

    @NonNull
    /* renamed from: clone */
    public AdResultData m94clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
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
