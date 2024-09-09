package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMusic extends BaseMediaObject {

    /* renamed from: f  reason: collision with root package name */
    private String f54083f;

    /* renamed from: g  reason: collision with root package name */
    private String f54084g;

    /* renamed from: h  reason: collision with root package name */
    private String f54085h;

    /* renamed from: i  reason: collision with root package name */
    private String f54086i;

    /* renamed from: j  reason: collision with root package name */
    private int f54087j;

    /* renamed from: k  reason: collision with root package name */
    private String f54088k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f54087j;
    }

    public String getH5Url() {
        return this.f54085h;
    }

    public String getHighBandDataUrl() {
        return this.f54084g;
    }

    public String getLowBandDataUrl() {
        return this.f54083f;
    }

    public String getLowBandUrl() {
        return this.f54086i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f54038e;
    }

    public String getmTargetUrl() {
        return this.f54088k;
    }

    public void setDuration(int i4) {
        this.f54087j = i4;
    }

    public void setH5Url(String str) {
        this.f54085h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f54084g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f54083f = str;
    }

    public void setLowBandUrl(String str) {
        this.f54086i = str;
    }

    public void setmTargetUrl(String str) {
        this.f54088k = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f54038e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMusic [title=" + this.f54035b + "media_url=" + this.f54034a + ", qzone_title=" + this.f54035b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f54034a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f54035b);
        }
        return hashMap;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }
}
