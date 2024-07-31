package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMQQMini extends BaseMediaObject {

    /* renamed from: f */
    private String f39490f;

    /* renamed from: g */
    private String f39491g;

    /* renamed from: h */
    private String f39492h;

    public UMQQMini(String str) {
        super(str);
        this.f39490f = "";
        this.f39491g = "";
        this.f39492h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f39490f;
    }

    public String getPath() {
        return this.f39491g;
    }

    public String getType() {
        return this.f39492h;
    }

    public void setMiniAppId(String str) {
        this.f39490f = str;
    }

    public void setPath(String str) {
        this.f39491g = str;
    }

    public void setType(String str) {
        this.f39492h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f39454e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f39450a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f39451b);
        }
        return hashMap;
    }
}
