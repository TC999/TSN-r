package com.mbridge.msdk.out;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Campaign implements CommonImageLoaderListener, NoProGuard, Serializable {
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

    /* renamed from: id */
    private String f31656id = "";
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
        return this.f31656id;
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
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(getIconUrl(), this);
    }

    public void loadImageUrlAsyncWithBlock(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
        if (TextUtils.isEmpty(getImageUrl())) {
            return;
        }
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(getImageUrl(), this);
    }

    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
    public void onFailedLoad(String str, String str2) {
    }

    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
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

    public void setAdchoiceSizeHeight(int i) {
        this.adchoiceSizeHeight = i;
    }

    public void setAdchoiceSizeWidth(int i) {
        this.adchoiceSizeWidth = i;
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
        this.f31656id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setNativead(Object obj) {
        this.nativead = obj;
    }

    public void setNumberRating(int i) {
        this.numberRating = i;
    }

    public void setOnImageLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRating(double d) {
        this.rating = d;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVideoLength(int i) {
        this.videoLength = i;
    }
}
