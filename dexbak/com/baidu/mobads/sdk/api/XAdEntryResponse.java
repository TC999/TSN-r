package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.internal.C2573a;
import com.baidu.mobads.sdk.internal.C2670cp;
import com.baidu.mobads.sdk.internal.C2692dj;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XAdEntryResponse implements EntryResponse {
    private static final String TAG = "XAdEntryResponse";
    private boolean isDownloadApp;
    private C2573a mAdInfo;
    private EntryResponse.EntryAdInteractionListener mAdInteractionListener;
    private Context mCxt;
    private C2692dj mFeedsProd;
    private C2670cp mUriUtils;

    public XAdEntryResponse(Context context, C2692dj c2692dj, C2573a c2573a) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mFeedsProd = c2692dj;
        this.mAdInfo = c2573a;
        if (c2573a.m51087p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = C2670cp.m50608a();
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getAdLogoUrl() {
        C2573a c2573a = this.mAdInfo;
        return c2573a != null ? c2573a.m51095h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getBaiduLogoUrl() {
        C2573a c2573a = this.mAdInfo;
        return c2573a != null ? c2573a.m51094i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getTitle() {
        C2573a c2573a = this.mAdInfo;
        return c2573a != null ? c2573a.m51107a() : "";
    }

    public String getUniqueId() {
        C2573a c2573a = this.mAdInfo;
        return c2573a != null ? c2573a.m51122H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isAdAvailable() {
        return this.mAdInfo != null && System.currentTimeMillis() - this.mAdInfo.m51078y() <= this.mAdInfo.m51124F();
    }

    public void onADExposed() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposureFailed(i);
        }
    }

    public void onAdClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdClick();
        }
    }

    public void onAdUnionClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdUnionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryResponse.EntryAdInteractionListener entryAdInteractionListener) {
        this.mAdInteractionListener = entryAdInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.m50818a(jSONObject, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void unionLogoClick() {
        C2670cp c2670cp;
        if (this.mFeedsProd == null || (c2670cp = this.mUriUtils) == null) {
            return;
        }
        String m50598c = c2670cp.m50598c("http://union.baidu.com/");
        JSONObject m51110T = this.mAdInfo.m51110T();
        try {
            m51110T.put("unionUrl", m50598c);
            m51110T.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.m50819a(m51110T);
    }
}
