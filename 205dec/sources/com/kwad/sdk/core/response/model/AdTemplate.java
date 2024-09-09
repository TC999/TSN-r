package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdTemplate extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -5413539480595883024L;
    public long adLoadTotalTime;
    public long adShowStartTimeStamp;
    public int adStyle;
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public int contentType;
    public long downloadDuration;
    public String extra;
    public String impAdExtra;
    public long llsid;
    public long loadDataTime;
    public int loadType;
    public SceneImpl mAdScene;
    public long mBidEcpm;
    public boolean mClickOpenAppStore;
    public long mCurPlayTime;
    public String mDataCacheTraceElement;
    public String mDataLoadTraceElement;
    public int mInitVoiceStatus;
    public boolean mInstallApkFormUser;
    public boolean mInstallApkFromSDK;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public int mPhotoResponseType;
    public volatile transient boolean mPvReported;
    public transient boolean mTrackUrlReported;
    public boolean notNetworkRequest;
    public long posId;
    public int realShowType;
    public long showStartTime;
    @Nullable
    public TKAdLiveShopItemInfo tkLiveShopItemInfo;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = createPhotoInfo();
    public int positionShow = -1;
    public transient int adxResult = -1;
    private int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean hasEnterAdWebViewLandPageActivity = false;
    public boolean mHasReportVideoLoad = false;
    public String mUniqueId = "";
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mOutClickTimeParam = -1;
    public volatile long mVisibleTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public boolean interactLandingPageShowing = false;
    public boolean mIsForceJumpLandingPage = false;
    public boolean mAdWebVideoPageShowing = false;
    public boolean mIsAudioEnable = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mCheatingFlow = false;
    public boolean mXiaomiAppStoreDetailViewOpen = false;
    public boolean isWebViewDownload = false;
    public boolean watched = false;
    public boolean converted = false;
    public boolean fromCache = false;
    protected transient Map<String, Object> mLocalParams = new HashMap();
    @NonNull
    public AdStatusInfo mAdStatusInfo = new AdStatusInfo();
    public boolean isNativeRewardPreview = false;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            PhotoInfo createPhotoInfo = createPhotoInfo();
            createPhotoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            setPhotoInfo(createPhotoInfo);
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.a(jSONObject, "photoInfo", this.photoInfo);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            u.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e4) {
            c.printStackTraceOnly(e4);
        }
    }

    public AdResultData createAdResultData() {
        AdResultData adResultData = new AdResultData();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        adResultData.setAdTemplateList(arrayList);
        return adResultData;
    }

    protected PhotoInfo createPhotoInfo() {
        return new PhotoInfo();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AdTemplate) {
            return this.mUniqueId.equals(((AdTemplate) obj).mUniqueId);
        }
        return super.equals(obj);
    }

    public long getDownloadFinishTime() {
        return this.mAdStatusInfo.getDownloadFinishTime();
    }

    public long getDownloadSize() {
        return this.mAdStatusInfo.getDownloadSize();
    }

    public int getDownloadStatus() {
        return this.mAdStatusInfo.getDownloadStatus();
    }

    public int getDownloadType() {
        return this.mAdStatusInfo.getDownloadType();
    }

    public long getLoadDataTime() {
        return this.mAdStatusInfo.getLoadDataTime();
    }

    @Nullable
    public <T> T getLocalParams(String str) {
        T t3;
        if (TextUtils.isEmpty(str) || (t3 = (T) this.mLocalParams.get(str)) == null) {
            return null;
        }
        return t3;
    }

    public int getServerPosition() {
        int i4 = this.serverPosition;
        return i4 != -1 ? i4 : getShowPosition();
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public long getmCurPlayTime() {
        return this.mCurPlayTime;
    }

    public int hashCode() {
        String str = this.mUniqueId;
        if (str != null) {
            return str.hashCode();
        }
        return super.hashCode();
    }

    public boolean isCheatingFlow() {
        return this.mCheatingFlow;
    }

    public boolean isLoadFromCache() {
        return this.mAdStatusInfo.isLoadFromCache();
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mLocalParams.put(str, obj);
    }

    public void setCheatingFlow(boolean z3) {
        if (this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z3;
    }

    public void setDownloadFinishTime(long j4) {
        this.mAdStatusInfo.setDownloadFinishTime(j4);
    }

    public void setDownloadSize(long j4) {
        this.mAdStatusInfo.setDownloadSize(j4);
    }

    public void setDownloadStatus(int i4) {
        this.mAdStatusInfo.setDownloadStatus(i4);
    }

    public void setDownloadType(int i4) {
        this.mAdStatusInfo.setDownloadType(i4);
    }

    public void setLoadDataTime(long j4) {
        this.mAdStatusInfo.setLoadDataTime(j4);
    }

    public void setLoadFromCache(boolean z3) {
        this.mAdStatusInfo.setLoadFromCache(z3);
    }

    protected void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setServerPosition(int i4) {
        if (this.serverPosition == -1) {
            this.serverPosition = i4;
        }
    }

    public void setShowPosition(int i4) {
        this.positionShow = i4;
    }

    public void setmCurPlayTime(long j4) {
        this.mCurPlayTime = j4;
    }

    public Map<String, Object> getLocalParams() {
        return this.mLocalParams;
    }
}
