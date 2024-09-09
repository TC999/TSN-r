package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMQQMini extends BaseMediaObject {

    /* renamed from: f  reason: collision with root package name */
    private String f54074f;

    /* renamed from: g  reason: collision with root package name */
    private String f54075g;

    /* renamed from: h  reason: collision with root package name */
    private String f54076h;

    public UMQQMini(String str) {
        super(str);
        this.f54074f = "";
        this.f54075g = "";
        this.f54076h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f54074f;
    }

    public String getPath() {
        return this.f54075g;
    }

    public String getType() {
        return this.f54076h;
    }

    public void setMiniAppId(String str) {
        this.f54074f = str;
    }

    public void setPath(String str) {
        this.f54075g = str;
    }

    public void setType(String str) {
        this.f54076h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f54038e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f54034a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f54035b);
        }
        return hashMap;
    }
}
