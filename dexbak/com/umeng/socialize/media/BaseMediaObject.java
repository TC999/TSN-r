package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* renamed from: a */
    protected String f39450a;

    /* renamed from: b */
    protected String f39451b;

    /* renamed from: c */
    protected Map<String, Object> f39452c;

    /* renamed from: d */
    protected String f39453d;

    /* renamed from: e */
    protected UMImage f39454e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f39450a = "";
        this.f39451b = "";
        this.f39452c = new HashMap();
        this.f39453d = "";
    }

    public String getDescription() {
        return this.f39453d;
    }

    public UMImage getThumbImage() {
        return this.f39454e;
    }

    public String getTitle() {
        return this.f39451b;
    }

    public Map<String, Object> getmExtra() {
        return this.f39452c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f39450a);
    }

    public void setDescription(String str) {
        this.f39453d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f39454e = uMImage;
    }

    public void setTitle(String str) {
        this.f39451b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f39452c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f39450a + ", qzone_title=" + this.f39451b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f39450a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f39450a = "";
        this.f39451b = "";
        this.f39452c = new HashMap();
        this.f39453d = "";
        this.f39450a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f39450a = "";
        this.f39451b = "";
        this.f39452c = new HashMap();
        this.f39453d = "";
        if (parcel != null) {
            this.f39450a = parcel.readString();
            this.f39451b = parcel.readString();
        }
    }
}
