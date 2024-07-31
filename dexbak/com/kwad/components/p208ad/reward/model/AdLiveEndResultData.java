package com.kwad.components.p208ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.model.AdLiveEndResultData */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdLiveEndResultData extends BaseResultData {
    private static final long serialVersionUID = 1126369604146892297L;
    public AdLivePushEndInfo mQLivePushEndInfo = new AdLivePushEndInfo();

    /* renamed from: com.kwad.components.ad.reward.model.AdLiveEndResultData$AdLivePushEndInfo */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AdLivePushEndInfo implements InterfaceC9914b, Serializable {
        public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
        public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
        public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
        public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
        public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
        public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
        private static final long serialVersionUID = 7611577990274486211L;
        public int mLikeUserCount;
        public long mLiveDuration;
        public long mTotalWatchingDuration;
        public int mWatchingUserCount;
        public String mDisplayWatchingUserCount = "0";
        public String mDisplayLikeUserCount = "0";

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mTotalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
            this.mWatchingUserCount = jSONObject.optInt("watchingUserCount");
            this.mDisplayWatchingUserCount = jSONObject.optString("displayWatchingUserCount", "0");
            this.mLiveDuration = jSONObject.optLong("liveDuration");
            this.mLikeUserCount = jSONObject.optInt("likeUserCount");
            this.mDisplayLikeUserCount = jSONObject.optString("displayLikeUserCount", "0");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "totalWatchingDuration", this.mTotalWatchingDuration);
            C11126t.putValue(jSONObject, "watchingUserCount", this.mWatchingUserCount);
            C11126t.putValue(jSONObject, "displayWatchingUserCount", this.mDisplayWatchingUserCount);
            C11126t.putValue(jSONObject, "liveDuration", this.mLiveDuration);
            C11126t.putValue(jSONObject, "likeUserCount", this.mLikeUserCount);
            C11126t.putValue(jSONObject, "displayLikeUserCount", this.mDisplayLikeUserCount);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mQLivePushEndInfo.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        return this.mQLivePushEndInfo.toJson();
    }
}
