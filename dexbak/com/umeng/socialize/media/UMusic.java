package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMusic extends BaseMediaObject {

    /* renamed from: f */
    private String f39499f;

    /* renamed from: g */
    private String f39500g;

    /* renamed from: h */
    private String f39501h;

    /* renamed from: i */
    private String f39502i;

    /* renamed from: j */
    private int f39503j;

    /* renamed from: k */
    private String f39504k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f39503j;
    }

    public String getH5Url() {
        return this.f39501h;
    }

    public String getHighBandDataUrl() {
        return this.f39500g;
    }

    public String getLowBandDataUrl() {
        return this.f39499f;
    }

    public String getLowBandUrl() {
        return this.f39502i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f39454e;
    }

    public String getmTargetUrl() {
        return this.f39504k;
    }

    public void setDuration(int i) {
        this.f39503j = i;
    }

    public void setH5Url(String str) {
        this.f39501h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f39500g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f39499f = str;
    }

    public void setLowBandUrl(String str) {
        this.f39502i = str;
    }

    public void setmTargetUrl(String str) {
        this.f39504k = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f39454e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMusic [title=" + this.f39451b + "media_url=" + this.f39450a + ", qzone_title=" + this.f39451b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f39450a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f39451b);
        }
        return hashMap;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }
}
