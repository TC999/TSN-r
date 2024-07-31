package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* renamed from: a */
    private static final String f39512a = "/share/multi_add/";

    /* renamed from: b */
    private static final int f39513b = 9;

    /* renamed from: c */
    private String f39514c;

    /* renamed from: d */
    private String f39515d;

    /* renamed from: e */
    private String f39516e;

    /* renamed from: f */
    private String f39517f;

    /* renamed from: g */
    private String f39518g;

    /* renamed from: h */
    private String f39519h;

    /* renamed from: i */
    private String f39520i;

    /* renamed from: j */
    private UMediaObject f39521j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f39515d = str;
        this.f39520i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f39512a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f39515d;
        String str = this.f39514c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String format = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f39517f);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.f39514c);
        addStringParams("ct", this.f39520i);
        if (!TextUtils.isEmpty(this.f39519h)) {
            addStringParams("url", this.f39519h);
        }
        if (!TextUtils.isEmpty(this.f39518g)) {
            addStringParams("title", this.f39518g);
        }
        addMediaParams(this.f39521j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f39521j = uMediaObject;
        } else if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f39518g = uMusic.getTitle();
            this.f39519h = uMusic.toUrl();
            this.f39520i = uMusic.getDescription();
            this.f39521j = uMusic.getThumbImage();
        } else if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f39518g = uMVideo.getTitle();
            this.f39519h = uMVideo.toUrl();
            this.f39520i = uMVideo.getDescription();
            this.f39521j = uMVideo.getThumbImage();
        } else if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f39518g = uMWeb.getTitle();
            this.f39519h = uMWeb.toUrl();
            this.f39520i = uMWeb.getDescription();
            this.f39521j = uMWeb.getThumbImage();
        } else if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f39518g = uMMin.getTitle();
            this.f39519h = uMMin.toUrl();
            this.f39520i = uMMin.getDescription();
            this.f39521j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f39515d = str;
    }

    public void setText(String str) {
        this.f39520i = str;
    }

    public void setType(String str) {
        this.f39517f = str;
    }

    public void setUID(String str) {
        this.f39516e = str;
    }

    public void setmUsid(String str) {
        this.f39514c = str;
    }
}
