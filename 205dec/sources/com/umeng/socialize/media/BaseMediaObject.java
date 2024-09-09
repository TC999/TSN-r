package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* renamed from: a  reason: collision with root package name */
    protected String f54034a;

    /* renamed from: b  reason: collision with root package name */
    protected String f54035b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, Object> f54036c;

    /* renamed from: d  reason: collision with root package name */
    protected String f54037d;

    /* renamed from: e  reason: collision with root package name */
    protected UMImage f54038e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f54034a = "";
        this.f54035b = "";
        this.f54036c = new HashMap();
        this.f54037d = "";
    }

    public String getDescription() {
        return this.f54037d;
    }

    public UMImage getThumbImage() {
        return this.f54038e;
    }

    public String getTitle() {
        return this.f54035b;
    }

    public Map<String, Object> getmExtra() {
        return this.f54036c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f54034a);
    }

    public void setDescription(String str) {
        this.f54037d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f54038e = uMImage;
    }

    public void setTitle(String str) {
        this.f54035b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f54036c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f54034a + ", qzone_title=" + this.f54035b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f54034a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f54034a = "";
        this.f54035b = "";
        this.f54036c = new HashMap();
        this.f54037d = "";
        this.f54034a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f54034a = "";
        this.f54035b = "";
        this.f54036c = new HashMap();
        this.f54037d = "";
        if (parcel != null) {
            this.f54034a = parcel.readString();
            this.f54035b = parcel.readString();
        }
    }
}
