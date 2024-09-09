package com.mbridge.msdk.out;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Campaign implements c, NoProGuard, Serializable {
    public static final int TYPE_BIG = 3;
    public static final int TYPE_ICON = 2;
    public static final int TYPE_MB = 1;
    private static final long serialVersionUID = 1;
    public String adCall;
    private ApkDisplayInfo apkDisplayInfo;
    private Drawable bigDrawable;
    private Drawable iconDrawable;
    private OnImageLoadListener mOnImageLoadListener;
    private Object nativead;
    private double rating;
    private String subType;
    private String id = "";
    private String packageName = "";
    private String appName = "";
    private String appDesc = "";
    private String size = "";
    private String iconUrl = "";
    private String imageUrl = "";
    private long timestamp = 0;
    private int numberRating = 33333;
    private int type = 1;
    private int adchoiceSizeWidth = 0;
    private int adchoiceSizeHeight = 0;
    private int videoLength = 0;

    private Drawable BitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public String getAdCall() {
        return this.adCall;
    }

    public int getAdchoiceSizeHeight() {
        return this.adchoiceSizeHeight;
    }

    public int getAdchoiceSizeWidth() {
        return this.adchoiceSizeWidth;
    }

    public ApkDisplayInfo getApkDisplayInfo() {
        return this.apkDisplayInfo;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    public String getAppName() {
        return this.appName;
    }

    public Drawable getBigDrawable() {
        return this.bigDrawable;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Object getNativead() {
        return this.nativead;
    }

    public int getNumberRating() {
        return this.numberRating;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public double getRating() {
        return this.rating;
    }

    public String getSize() {
        return this.size;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public void loadIconUrlAsyncWithBlock(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
        if (TextUtils.isEmpty(getIconUrl())) {
            return;
        }
        b.a(a.f().j()).a(getIconUrl(), this);
    }

    public void loadImageUrlAsyncWithBlock(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
        if (TextUtils.isEmpty(getImageUrl())) {
            return;
        }
        b.a(a.f().j()).a(getImageUrl(), this);
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onFailedLoad(String str, String str2) {
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        if (!TextUtils.isEmpty(getImageUrl()) && getImageUrl().equals(str) && bitmap != null) {
            setBigDrawable(BitmapToDrawable(bitmap));
            OnImageLoadListener onImageLoadListener = this.mOnImageLoadListener;
            if (onImageLoadListener != null) {
                onImageLoadListener.loadSuccess(BitmapToDrawable(bitmap), 3);
            }
        }
        if (TextUtils.isEmpty(getIconUrl()) || getIconUrl() == null || !getIconUrl().equals(str) || bitmap == null) {
            return;
        }
        setIconDrawable(BitmapToDrawable(bitmap));
        OnImageLoadListener onImageLoadListener2 = this.mOnImageLoadListener;
        if (onImageLoadListener2 != null) {
            onImageLoadListener2.loadSuccess(BitmapToDrawable(bitmap), 2);
        }
    }

    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.adCall = str;
    }

    public void setAdchoiceSizeHeight(int i4) {
        this.adchoiceSizeHeight = i4;
    }

    public void setAdchoiceSizeWidth(int i4) {
        this.adchoiceSizeWidth = i4;
    }

    public void setApkDisplayInfo(ApkDisplayInfo apkDisplayInfo) {
        this.apkDisplayInfo = apkDisplayInfo;
    }

    public void setAppDesc(String str) {
        this.appDesc = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setBigDrawable(Drawable drawable) {
        this.bigDrawable = drawable;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setNativead(Object obj) {
        this.nativead = obj;
    }

    public void setNumberRating(int i4) {
        this.numberRating = i4;
    }

    public void setOnImageLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRating(double d4) {
        this.rating = d4;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setTimestamp(long j4) {
        this.timestamp = j4;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public void setVideoLength(int i4) {
        this.videoLength = i4;
    }
}
