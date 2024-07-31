package com.kwad.components.p208ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.p208ad.reward.model.C8029d;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.components.ad.reward.monitor.RewardMonitorInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RewardMonitorInfo extends AbstractC9822a implements Serializable {
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
    public boolean enableRewardLayoutOptimise = C7844b.m32191gD();
    public boolean enableFullscreenLayoutOptimise = C7844b.m32190gE();

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i = this.rewardType;
        if (i != -1) {
            C11126t.putValue(jSONObject, "reward_type", i);
        } else {
            jSONObject.remove("reward_type");
        }
        int i2 = this.taskType;
        if (i2 != -1) {
            C11126t.putValue(jSONObject, "task_type", i2);
        } else {
            jSONObject.remove("task_type");
        }
        int i3 = this.taskStep;
        if (i3 != -1) {
            C11126t.putValue(jSONObject, "task_step", i3);
        } else {
            jSONObject.remove("task_step");
        }
    }

    public RewardMonitorInfo setAdCount(int i) {
        this.adCount = i;
        return this;
    }

    public RewardMonitorInfo setAdSceneType(int i) {
        this.adSceneType = i;
        return this;
    }

    public RewardMonitorInfo setCallbackType(String str) {
        this.callbackType = str;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j) {
        this.currentDuration = j;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j) {
        this.dataDownloadInterval = j;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j) {
        this.dataLoadInterval = j;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j) {
        this.downloadDuration = j;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j) {
        this.downloadSize = j;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i) {
        this.downloadType = i;
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

    public RewardMonitorInfo setLoadDataDuration(long j) {
        this.loadDataDuration = j;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i) {
        this.loadStatus = i;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i) {
        this.loadType = i;
        return this;
    }

    public RewardMonitorInfo setMaterialRenderType(String str) {
        this.materialRenderType = str;
        return this;
    }

    public RewardMonitorInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public RewardMonitorInfo setOperationType(int i) {
        this.operationType = i;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i) {
        this.pageStatus = i;
        return this;
    }

    public RewardMonitorInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public RewardMonitorInfo setRewardTaskType(int i) {
        this.rewardTaskType = i;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i) {
        this.rewardType = i;
        return this;
    }

    public RewardMonitorInfo setSubStage(String str) {
        this.subStage = str;
        return this;
    }

    public RewardMonitorInfo setTKRenderType(int i) {
        this.tkRenderType = i;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i) {
        this.taskStep = i;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i) {
        this.taskType = i;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j) {
        this.totalDuration = j;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j) {
        this.videoDuration = j;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public RewardMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        RewardMonitorInfo rewardMonitorInfo = (RewardMonitorInfo) super.setAdTemplate(adTemplate);
        int m25647dK = C10487e.m25647dK(adTemplate);
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        rewardMonitorInfo.setOperationType(C10483a.m25945aQ(m25641dQ));
        rewardMonitorInfo.setMaterialRenderType(C8029d.m31784m(m25641dQ));
        rewardMonitorInfo.setTKRenderType(C10484b.m25792a(m25647dK == 2, m25641dQ));
        return rewardMonitorInfo;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public RewardMonitorInfo setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public RewardMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    public RewardMonitorInfo setPosId(long j) {
        return (RewardMonitorInfo) super.setPosId(j);
    }
}