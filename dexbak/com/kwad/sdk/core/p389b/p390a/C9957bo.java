package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9957bo implements InterfaceC10273d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        m27160a(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return m27159b(baseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27160a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
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
    private static JSONObject m27159b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = baseInfo.photoId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "photoId", j);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "title", baseInfo.title);
        }
        int i = baseInfo.photoDescribeSize;
        if (i != 0) {
            C11126t.putValue(jSONObject, "photoDescribeSize", i);
        }
        int i2 = baseInfo.photoTitleSize;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "photoTitleSize", i2);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        C11126t.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        C11126t.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j2 = baseInfo.likeCount;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "likeCount", j2);
        }
        long j3 = baseInfo.commentCount;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "commentCount", j3);
        }
        long j4 = baseInfo.viewCount;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "viewCount", j4);
        }
        long j5 = baseInfo.createTime;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "createTime", j5);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j6 = baseInfo.playTimes;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "playTimes", j6);
        }
        long j7 = baseInfo.videoUrlCacheTime;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "videoUrlCacheTime", j7);
        }
        int i3 = baseInfo.contentSourceType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "contentSourceType", i3);
        }
        boolean z = baseInfo.toolbarDisable;
        if (z) {
            C11126t.putValue(jSONObject, "toolbarDisable", z);
        }
        return jSONObject;
    }
}
