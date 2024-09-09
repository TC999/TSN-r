package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMVideo extends BaseMediaObject {

    /* renamed from: f  reason: collision with root package name */
    private String f54077f;

    /* renamed from: g  reason: collision with root package name */
    private String f54078g;

    /* renamed from: h  reason: collision with root package name */
    private String f54079h;

    /* renamed from: i  reason: collision with root package name */
    private String f54080i;

    /* renamed from: j  reason: collision with root package name */
    private int f54081j;

    /* renamed from: k  reason: collision with root package name */
    private File f54082k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f54081j;
    }

    public String getH5Url() {
        return this.f54080i;
    }

    public String getHighBandDataUrl() {
        return this.f54079h;
    }

    public File getLocalVideoFile() {
        return this.f54082k;
    }

    public String getLowBandDataUrl() {
        return this.f54078g;
    }

    public String getLowBandUrl() {
        return this.f54077f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i4) {
        this.f54081j = i4;
    }

    public void setH5Url(String str) {
        this.f54080i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f54079h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f54078g = str;
    }

    public void setLowBandUrl(String str) {
        this.f54077f = str;
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
        return "UMVedio [media_url=" + this.f54034a + ", qzone_title=" + this.f54035b + ", qzone_thumb=media_url=" + this.f54034a + ", qzone_title=" + this.f54035b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f54034a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    public UMVideo(File file) {
        this.f54082k = file;
    }
}
