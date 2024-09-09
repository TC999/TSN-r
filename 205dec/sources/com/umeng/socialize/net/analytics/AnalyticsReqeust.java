package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54096a = "/share/multi_add/";

    /* renamed from: b  reason: collision with root package name */
    private static final int f54097b = 9;

    /* renamed from: c  reason: collision with root package name */
    private String f54098c;

    /* renamed from: d  reason: collision with root package name */
    private String f54099d;

    /* renamed from: e  reason: collision with root package name */
    private String f54100e;

    /* renamed from: f  reason: collision with root package name */
    private String f54101f;

    /* renamed from: g  reason: collision with root package name */
    private String f54102g;

    /* renamed from: h  reason: collision with root package name */
    private String f54103h;

    /* renamed from: i  reason: collision with root package name */
    private String f54104i;

    /* renamed from: j  reason: collision with root package name */
    private UMediaObject f54105j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f54099d = str;
        this.f54104i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return "/share/multi_add/" + SocializeUtils.getAppkey(this.mContext) + TTPathConst.sSeparator + Config.EntityKey + TTPathConst.sSeparator;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f54099d;
        String str = this.f54098c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String format = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams("dc", Config.Descriptor);
        addStringParams("to", format);
        addStringParams("sns", format);
        addStringParams("ak", appkey);
        addStringParams("type", this.f54101f);
        addStringParams("usid", this.f54098c);
        addStringParams("ct", this.f54104i);
        if (!TextUtils.isEmpty(this.f54103h)) {
            addStringParams("url", this.f54103h);
        }
        if (!TextUtils.isEmpty(this.f54102g)) {
            addStringParams("title", this.f54102g);
        }
        addMediaParams(this.f54105j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f54105j = uMediaObject;
        } else if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f54102g = uMusic.getTitle();
            this.f54103h = uMusic.toUrl();
            this.f54104i = uMusic.getDescription();
            this.f54105j = uMusic.getThumbImage();
        } else if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f54102g = uMVideo.getTitle();
            this.f54103h = uMVideo.toUrl();
            this.f54104i = uMVideo.getDescription();
            this.f54105j = uMVideo.getThumbImage();
        } else if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f54102g = uMWeb.getTitle();
            this.f54103h = uMWeb.toUrl();
            this.f54104i = uMWeb.getDescription();
            this.f54105j = uMWeb.getThumbImage();
        } else if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f54102g = uMMin.getTitle();
            this.f54103h = uMMin.toUrl();
            this.f54104i = uMMin.getDescription();
            this.f54105j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f54099d = str;
    }

    public void setText(String str) {
        this.f54104i = str;
    }

    public void setType(String str) {
        this.f54101f = str;
    }

    public void setUID(String str) {
        this.f54100e = str;
    }

    public void setmUsid(String str) {
        this.f54098c = str;
    }
}
