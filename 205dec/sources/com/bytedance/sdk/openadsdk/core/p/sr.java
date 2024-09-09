package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends p {

        /* renamed from: c  reason: collision with root package name */
        private TTDownloadEventModel f34249c;
        private boolean sr;
        private Bridge ux;

        /* renamed from: w  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.core.p.xv.w.c f34250w;
        private me xv;

        private c(TTDownloadEventModel tTDownloadEventModel, boolean z3) {
            super("LogTask");
            JSONObject materialMeta;
            me c4;
            this.f34249c = tTDownloadEventModel;
            this.sr = z3;
            this.ux = k.sr().u();
            TTDownloadEventModel tTDownloadEventModel2 = this.f34249c;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null) {
                return;
            }
            String optString = this.f34249c.getExtJson().optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra");
                com.bytedance.sdk.openadsdk.core.p.xv.w.c c5 = com.bytedance.sdk.openadsdk.core.p.xv.w.c.c(optJSONObject);
                this.f34250w = c5;
                c5.c(tTDownloadEventModel.getTag());
                this.f34250w.w(this.f34249c.getLabel());
                com.bytedance.sdk.openadsdk.core.p.xv.w.c cVar = this.f34250w;
                if (cVar != null) {
                    this.xv = cVar.f34380c;
                    if (eq.f33190w < 4400 || (materialMeta = tTDownloadEventModel.getMaterialMeta()) == null || (c4 = com.bytedance.sdk.openadsdk.core.w.c(materialMeta)) == null || TextUtils.isEmpty(c4.xq()) || TextUtils.isEmpty(c4.jr()) || this.xv == null || TextUtils.equals(c4.xq(), this.xv.xq()) || !TextUtils.equals(c4.jr(), this.xv.jr()) || optJSONObject == null) {
                        return;
                    }
                    optJSONObject.put("material_meta", materialMeta);
                    com.bytedance.sdk.openadsdk.core.p.xv.w.c c6 = com.bytedance.sdk.openadsdk.core.p.xv.w.c.c(optJSONObject);
                    this.f34250w = c6;
                    c6.w(this.f34249c.getLabel());
                    String tag = this.f34249c.getTag();
                    String label = this.f34249c.getLabel();
                    JSONObject materialMeta2 = this.f34249c.getMaterialMeta();
                    JSONObject extJson = this.f34249c.getExtJson();
                    JSONObject jSONObject = new JSONObject(extJson.optString("ad_extra_data"));
                    jSONObject.getJSONObject("open_ad_sdk_download_extra").put("material_meta", this.f34250w.f34380c.mo());
                    extJson.put("ad_extra_data", jSONObject.toString());
                    this.f34249c = TTDownloadEventModel.builder().setTag(tag).setLabel(label).setMaterialMeta(materialMeta2).setExtJson(extJson);
                    com.bytedance.sdk.openadsdk.core.p.xv.w.c cVar2 = this.f34250w;
                    if (cVar2 != null) {
                        this.xv = cVar2.f34380c;
                    }
                }
            } catch (Exception unused) {
            }
        }

        public static c c(TTDownloadEventModel tTDownloadEventModel, boolean z3) {
            return new c(tTDownloadEventModel, z3);
        }

        private Context getContext() {
            return ls.getContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTDownloadEventModel tTDownloadEventModel = this.f34249c;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                a.f("LibEventLogger", "tag " + tag);
                a.f("LibEventLogger", "label " + this.f34249c.getLabel());
                com.bytedance.sdk.openadsdk.core.p.xv.w.c cVar = this.f34250w;
                if (cVar != null && !TextUtils.isEmpty(cVar.f34381w)) {
                    tag = this.f34250w.f34381w;
                }
                if (this.ux != null) {
                    if (((Boolean) this.ux.call(2, b.b(1).h(0, new y().c("tagIntercept", tag).c("label", this.f34249c.getLabel()).c("meta", this.xv.mo().toString())).l(), Boolean.class)).booleanValue()) {
                        return;
                    }
                }
                if (this.f34250w != null && this.xv != null && !TextUtils.isEmpty(this.f34249c.getTag()) && !TextUtils.isEmpty(this.f34249c.getLabel())) {
                    JSONObject c4 = sr.c(this.f34249c.getExtJson());
                    String str = this.f34250w.f34381w;
                    if (!c(this.f34249c.getTag()) || "click".equals(this.f34249c.getLabel())) {
                        return;
                    }
                    c4.remove("open_ad_sdk_download_extra");
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, str, this.f34249c.getLabel(), c4);
                }
            } catch (Throwable th) {
                a.c("LibEventLogger", "upload event log error", th);
            }
        }

        private boolean c(String str) {
            return this.sr || sr.xv(str);
        }
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            try {
                return new JSONObject(optString);
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xv(String str) {
        return !TextUtils.isEmpty(str) && ("embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "feed_video_middle_page".equals(str) || "stream".equals(str));
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("open_ad_sdk_download_extra");
    }
}
