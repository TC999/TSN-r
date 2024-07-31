package com.umeng.socialize.net.analytics;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.base.SocializeReseponse;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AnalyticsResponse extends SocializeReseponse {
    public Map<SHARE_MEDIA, Integer> mInfoMap;
    public String mWeiboId;
    public SHARE_MEDIA platform;

    public AnalyticsResponse(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public String toString() {
        return "ShareMultiResponse [mInfoMap=" + this.mInfoMap + ", mWeiboId=" + this.mWeiboId + ", mMsg=" + this.mMsg + ", mStCode=" + this.mStCode + "]";
    }
}
