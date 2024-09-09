package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LinkcardRequest extends SocializeRequest {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54092a = "/share/linkcard/";

    /* renamed from: b  reason: collision with root package name */
    private String f54093b;

    /* renamed from: c  reason: collision with root package name */
    private BaseMediaObject f54094c;

    public LinkcardRequest(Context context) {
        super(context, "", LinkCardResponse.class, 0, URequest.RequestMethod.POST);
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.f54094c.getTitle());
            jSONObject.put("image", f());
            jSONObject.put("summary", d());
            jSONObject.put("full_image", h());
            jSONObject.put("url", this.f54094c.toUrl());
            jSONObject.put("links", i());
            jSONObject.put("tags", e());
            jSONObject.put("create_at", c());
            jSONObject.put("object_type", b());
        } catch (JSONException e4) {
            SLog.error(e4);
        }
        return jSONObject;
    }

    private String b() {
        BaseMediaObject baseMediaObject = this.f54094c;
        return baseMediaObject instanceof UMWeb ? "webpage" : baseMediaObject instanceof UMVideo ? "video" : baseMediaObject instanceof UMusic ? "audio" : "webpage";
    }

    private String c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    private String d() {
        if (!TextUtils.isEmpty(this.f54094c.getDescription()) && this.f54094c.getDescription().length() > 300) {
            return this.f54094c.getDescription().substring(0, 300);
        }
        return this.f54094c.getDescription();
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
        } catch (JSONException e4) {
            SLog.error(e4);
        }
        return jSONArray;
    }

    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f54094c.getThumbImage();
            if (thumbImage != null && thumbImage.isUrlMedia()) {
                jSONObject.put("url", thumbImage.asUrlImage());
            } else {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            }
            int[] g4 = g();
            jSONObject.put("width", g4[0]);
            jSONObject.put("height", g4[1]);
        } catch (JSONException e4) {
            SLog.error(e4);
        }
        return jSONObject;
    }

    private int[] g() {
        int[] iArr = {120, 120};
        BaseMediaObject baseMediaObject = this.f54094c;
        if (baseMediaObject != null && baseMediaObject.getmExtra() != null) {
            Map<String, Object> map = this.f54094c.getmExtra();
            if (map.containsKey("width")) {
                iArr[0] = ((Integer) map.get("width")).intValue();
            }
            if (map.containsKey("height")) {
                iArr[1] = ((Integer) map.get("height")).intValue();
            }
        }
        return iArr;
    }

    private JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f54094c.getThumbImage();
            if (thumbImage != null && thumbImage.isUrlMedia()) {
                jSONObject.put("url", thumbImage.asUrlImage());
            } else {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            }
            int[] g4 = g();
            jSONObject.put("width", g4[0]);
            jSONObject.put("height", g4[1]);
        } catch (JSONException e4) {
            SLog.error(e4);
        }
        return jSONObject;
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f54094c.toUrl());
        } catch (JSONException e4) {
            SLog.error(e4);
        }
        return jSONObject;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return "/share/linkcard/" + SocializeUtils.getAppkey(this.mContext) + TTPathConst.sSeparator + Config.EntityKey + TTPathConst.sSeparator;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        addStringParams("linkcard_info", a().toString());
    }

    public void setMedia(BaseMediaObject baseMediaObject) {
        this.f54094c = baseMediaObject;
    }
}
