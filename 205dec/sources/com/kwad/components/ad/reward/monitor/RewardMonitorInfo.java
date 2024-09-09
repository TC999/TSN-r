package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RewardMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_RESPONSE_DATA = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_STATUS_START_CACHE = 7;
    public static final int LOAD_STATUS_START_REQUEST = 5;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_AD_PV = 6;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_PAGE_RESUME = 5;
    public static final int PAGE_STATUS_PREVIEW_H5_ERROR = 9;
    public static final int PAGE_STATUS_PREVIEW_H5_START = 7;
    public static final int PAGE_STATUS_PREVIEW_H5_SUCCESS = 8;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int PAGE_STATUS_SHOW_INTERCEPT = 4;
    public static final int PAGE_STATUS_START_PLAY = 2;
    public static final int PAGE_STATUS_SUB_PAGE_CREATE = 101;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final int SCENE_TYPE_IMAGE = 2;
    public static final int SCENE_TYPE_LIVE = 1;
    public static final int SCENE_TYPE_SCAN_AGGREGATION = 3;
    public static final int SCENE_TYPE_VIDEO = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public int adCount;
    public int adSceneType;
    public String callbackType;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public String interceptReason;
    public String launchFrom;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public String materialRenderType;
    public int materialType;
    public int operationType;
    public int pageStatus;
    public long posId;
    public long renderDuration;
    public int rewardTaskType;
    public String subStage;
    public int tkRenderType;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;
    public int rewardType = -1;
    public int taskType = -1;
    public int taskStep = -1;
    public boolean enableRewardLayoutOptimise = com.kwad.components.ad.reward.a.b.gD();
    public boolean enableFullscreenLayoutOptimise = com.kwad.components.ad.reward.a.b.gE();

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i4 = this.rewardType;
        if (i4 != -1) {
            t.putValue(jSONObject, "reward_type", i4);
        } else {
            jSONObject.remove("reward_type");
        }
        int i5 = this.taskType;
        if (i5 != -1) {
            t.putValue(jSONObject, "task_type", i5);
        } else {
            jSONObject.remove("task_type");
        }
        int i6 = this.taskStep;
        if (i6 != -1) {
            t.putValue(jSONObject, "task_step", i6);
        } else {
            jSONObject.remove("task_step");
        }
    }

    public RewardMonitorInfo setAdCount(int i4) {
        this.adCount = i4;
        return this;
    }

    public RewardMonitorInfo setAdSceneType(int i4) {
        this.adSceneType = i4;
        return this;
    }

    public RewardMonitorInfo setCallbackType(String str) {
        this.callbackType = str;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j4) {
        this.creativeId = j4;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j4) {
        this.currentDuration = j4;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j4) {
        this.dataDownloadInterval = j4;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j4) {
        this.dataLoadInterval = j4;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j4) {
        this.downloadDuration = j4;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j4) {
        this.downloadSize = j4;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i4) {
        this.downloadType = i4;
        return this;
    }

    public RewardMonitorInfo setInterceptReason(String str) {
        this.interceptReason = str;
        return this;
    }

    public RewardMonitorInfo setLaunchFrom(String str) {
        this.launchFrom = str;
        return this;
    }

    public RewardMonitorInfo setLoadDataDuration(long j4) {
        this.loadDataDuration = j4;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i4) {
        this.loadStatus = i4;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i4) {
        this.loadType = i4;
        return this;
    }

    public RewardMonitorInfo setMaterialRenderType(String str) {
        this.materialRenderType = str;
        return this;
    }

    public RewardMonitorInfo setMaterialType(int i4) {
        this.materialType = i4;
        return this;
    }

    public RewardMonitorInfo setOperationType(int i4) {
        this.operationType = i4;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i4) {
        this.pageStatus = i4;
        return this;
    }

    public RewardMonitorInfo setRenderDuration(long j4) {
        this.renderDuration = j4;
        return this;
    }

    public RewardMonitorInfo setRewardTaskType(int i4) {
        this.rewardTaskType = i4;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i4) {
        this.rewardType = i4;
        return this;
    }

    public RewardMonitorInfo setSubStage(String str) {
        this.subStage = str;
        return this;
    }

    public RewardMonitorInfo setTKRenderType(int i4) {
        this.tkRenderType = i4;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i4) {
        this.taskStep = i4;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i4) {
        this.taskType = i4;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j4) {
        this.totalDuration = j4;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j4) {
        this.videoDuration = j4;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        RewardMonitorInfo rewardMonitorInfo = (RewardMonitorInfo) super.setAdTemplate(adTemplate);
        int dK = e.dK(adTemplate);
        AdInfo dQ = e.dQ(adTemplate);
        rewardMonitorInfo.setOperationType(com.kwad.sdk.core.response.b.a.aQ(dQ));
        rewardMonitorInfo.setMaterialRenderType(com.kwad.components.ad.reward.model.d.m(dQ));
        rewardMonitorInfo.setTKRenderType(com.kwad.sdk.core.response.b.b.a(dK == 2, dQ));
        return rewardMonitorInfo;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorCode(int i4) {
        super.setErrorCode(i4);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setPosId(long j4) {
        return (RewardMonitorInfo) super.setPosId(j4);
    }
}
