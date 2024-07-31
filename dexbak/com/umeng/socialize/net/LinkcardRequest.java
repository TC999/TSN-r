package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LinkcardRequest extends SocializeRequest {

    /* renamed from: a */
    private static final String f39508a = "/share/linkcard/";

    /* renamed from: b */
    private String f39509b;

    /* renamed from: c */
    private BaseMediaObject f39510c;

    public LinkcardRequest(Context context) {
        super(context, "", LinkCardResponse.class, 0, URequest.RequestMethod.POST);
    }

    /* renamed from: a */
    private JSONObject m13269a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.f39510c.getTitle());
            jSONObject.put(SocializeProtocolConstants.IMAGE, m13264f());
            jSONObject.put("summary", m13266d());
            jSONObject.put(SocializeProtocolConstants.FULL_IMAGE, m13262h());
            jSONObject.put("url", this.f39510c.toUrl());
            jSONObject.put(SocializeProtocolConstants.LINKS, m13261i());
            jSONObject.put("tags", m13265e());
            jSONObject.put(SocializeProtocolConstants.CREATE_AT, m13267c());
            jSONObject.put(SocializeProtocolConstants.OBJECT_TYPE, m13268b());
        } catch (JSONException e) {
            SLog.error(e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private String m13268b() {
        BaseMediaObject baseMediaObject = this.f39510c;
        return baseMediaObject instanceof UMWeb ? "webpage" : baseMediaObject instanceof UMVideo ? "video" : baseMediaObject instanceof UMusic ? "audio" : "webpage";
    }

    /* renamed from: c */
    private String m13267c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: d */
    private String m13266d() {
        if (!TextUtils.isEmpty(this.f39510c.getDescription()) && this.f39510c.getDescription().length() > 300) {
            return this.f39510c.getDescription().substring(0, 300);
        }
        return this.f39510c.getDescription();
    }

    /* renamed from: e */
    private JSONArray m13265e() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            SLog.error(e);
        }
        return jSONArray;
    }

    /* renamed from: f */
    private JSONObject m13264f() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f39510c.getThumbImage();
            if (thumbImage != null && thumbImage.isUrlMedia()) {
                jSONObject.put("url", thumbImage.asUrlImage());
            } else {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            }
            int[] m13263g = m13263g();
            jSONObject.put("width", m13263g[0]);
            jSONObject.put("height", m13263g[1]);
        } catch (JSONException e) {
            SLog.error(e);
        }
        return jSONObject;
    }

    /* renamed from: g */
    private int[] m13263g() {
        int[] iArr = {120, 120};
        BaseMediaObject baseMediaObject = this.f39510c;
        if (baseMediaObject != null && baseMediaObject.getmExtra() != null) {
            Map<String, Object> map = this.f39510c.getmExtra();
            if (map.containsKey("width")) {
                iArr[0] = ((Integer) map.get("width")).intValue();
            }
            if (map.containsKey("height")) {
                iArr[1] = ((Integer) map.get("height")).intValue();
            }
        }
        return iArr;
    }

    /* renamed from: h */
    private JSONObject m13262h() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f39510c.getThumbImage();
            if (thumbImage != null && thumbImage.isUrlMedia()) {
                jSONObject.put("url", thumbImage.asUrlImage());
            } else {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            }
            int[] m13263g = m13263g();
            jSONObject.put("width", m13263g[0]);
            jSONObject.put("height", m13263g[1]);
        } catch (JSONException e) {
            SLog.error(e);
        }
        return jSONObject;
    }

    /* renamed from: i */
    private JSONObject m13261i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f39510c.toUrl());
        } catch (JSONException e) {
            SLog.error(e);
        }
        return jSONObject;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f39508a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        addStringParams("linkcard_info", m13269a().toString());
    }

    public void setMedia(BaseMediaObject baseMediaObject) {
        this.f39510c = baseMediaObject;
    }
}
