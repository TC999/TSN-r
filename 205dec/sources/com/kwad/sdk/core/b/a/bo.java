package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bo implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(baseInfo.sdkExtraData)) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(baseInfo.title)) {
            baseInfo.title = "";
        }
        baseInfo.photoDescribeSize = jSONObject.optInt("photoDescribeSize");
        baseInfo.photoTitleSize = jSONObject.optInt("photoTitleSize");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (JSONObject.NULL.toString().equals(baseInfo.shareUrl)) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.waterMarkShowDuration = jSONObject.optLong("waterMarkShowDuration", new Long("-1").longValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (JSONObject.NULL.toString().equals(baseInfo.recoExt)) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (JSONObject.NULL.toString().equals(baseInfo.videoDesc)) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
        baseInfo.toolbarDisable = jSONObject.optBoolean("toolbarDisable");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = baseInfo.photoId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j4);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", baseInfo.title);
        }
        int i4 = baseInfo.photoDescribeSize;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDescribeSize", i4);
        }
        int i5 = baseInfo.photoTitleSize;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoTitleSize", i5);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.t.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j5 = baseInfo.likeCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeCount", j5);
        }
        long j6 = baseInfo.commentCount;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "commentCount", j6);
        }
        long j7 = baseInfo.viewCount;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewCount", j7);
        }
        long j8 = baseInfo.createTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "createTime", j8);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j9 = baseInfo.playTimes;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playTimes", j9);
        }
        long j10 = baseInfo.videoUrlCacheTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoUrlCacheTime", j10);
        }
        int i6 = baseInfo.contentSourceType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", i6);
        }
        boolean z3 = baseInfo.toolbarDisable;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "toolbarDisable", z3);
        }
        return jSONObject;
    }
}
