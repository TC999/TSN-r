package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMVideo extends BaseMediaObject {

    /* renamed from: f */
    private String f39493f;

    /* renamed from: g */
    private String f39494g;

    /* renamed from: h */
    private String f39495h;

    /* renamed from: i */
    private String f39496i;

    /* renamed from: j */
    private int f39497j;

    /* renamed from: k */
    private File f39498k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f39497j;
    }

    public String getH5Url() {
        return this.f39496i;
    }

    public String getHighBandDataUrl() {
        return this.f39495h;
    }

    public File getLocalVideoFile() {
        return this.f39498k;
    }

    public String getLowBandDataUrl() {
        return this.f39494g;
    }

    public String getLowBandUrl() {
        return this.f39493f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i) {
        this.f39497j = i;
    }

    public void setH5Url(String str) {
        this.f39496i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f39495h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f39494g = str;
    }

    public void setLowBandUrl(String str) {
        this.f39493f = str;
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
        return "UMVedio [media_url=" + this.f39450a + ", qzone_title=" + this.f39451b + ", qzone_thumb=media_url=" + this.f39450a + ", qzone_title=" + this.f39451b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f39450a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    public UMVideo(File file) {
        this.f39498k = file;
    }
}
