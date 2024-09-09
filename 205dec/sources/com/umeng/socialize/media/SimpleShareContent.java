package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SimpleShareContent {

    /* renamed from: a  reason: collision with root package name */
    private UMImage f54039a;

    /* renamed from: b  reason: collision with root package name */
    private UMImage[] f54040b;

    /* renamed from: c  reason: collision with root package name */
    private String f54041c;

    /* renamed from: d  reason: collision with root package name */
    private UMVideo f54042d;

    /* renamed from: e  reason: collision with root package name */
    private UMVideo[] f54043e;

    /* renamed from: f  reason: collision with root package name */
    private UMEmoji f54044f;

    /* renamed from: g  reason: collision with root package name */
    private UMusic f54045g;

    /* renamed from: h  reason: collision with root package name */
    private UMMin f54046h;

    /* renamed from: i  reason: collision with root package name */
    private UMQQMini f54047i;

    /* renamed from: j  reason: collision with root package name */
    private UMWeb f54048j;

    /* renamed from: k  reason: collision with root package name */
    private File f54049k;

    /* renamed from: l  reason: collision with root package name */
    private BaseMediaObject f54050l;

    /* renamed from: m  reason: collision with root package name */
    private int f54051m;

    /* renamed from: n  reason: collision with root package name */
    private String f54052n;

    /* renamed from: o  reason: collision with root package name */
    private String f54053o;

    /* renamed from: p  reason: collision with root package name */
    private CompressListener f54054p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "\u8fd9\u91cc\u662f\u6807\u9898";
    public final String DEFAULT_DESCRIPTION = "\u8fd9\u91cc\u662f\u63cf\u8ff0";

    public SimpleShareContent(ShareContent shareContent) {
        UMVideo[] uMVideoArr;
        this.f54041c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null && (uMediaObject instanceof UMImage) && (uMVideoArr = shareContent.Video_mMedias) != null) {
            UMImage uMImage = (UMImage) uMediaObject;
            this.f54039a = uMImage;
            this.f54050l = uMImage;
            UMImage[] uMImageArr = shareContent.mMedias;
            if (uMImageArr != null && uMImageArr.length > 0) {
                this.f54040b = uMImageArr;
            }
            this.f54050l = this.f54042d;
            if (uMVideoArr != null && uMVideoArr.length > 0) {
                this.f54043e = uMVideoArr;
            }
        } else {
            if (uMediaObject != null && (uMediaObject instanceof UMImage)) {
                UMImage uMImage2 = (UMImage) uMediaObject;
                this.f54039a = uMImage2;
                this.f54050l = uMImage2;
                UMImage[] uMImageArr2 = shareContent.mMedias;
                if (uMImageArr2 != null && uMImageArr2.length > 0) {
                    this.f54040b = uMImageArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMusic)) {
                UMusic uMusic = (UMusic) uMediaObject;
                this.f54045g = uMusic;
                this.f54050l = uMusic;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMVideo)) {
                UMVideo uMVideo = (UMVideo) uMediaObject;
                this.f54042d = uMVideo;
                this.f54050l = uMVideo;
                UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
                if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                    this.f54043e = uMVideoArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMEmoji)) {
                UMEmoji uMEmoji = (UMEmoji) uMediaObject;
                this.f54044f = uMEmoji;
                this.f54050l = uMEmoji;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMWeb)) {
                UMWeb uMWeb = (UMWeb) uMediaObject;
                this.f54048j = uMWeb;
                this.f54050l = uMWeb;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMMin)) {
                this.f54046h = (UMMin) uMediaObject;
                this.f54050l = this.f54048j;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMQQMini)) {
                this.f54047i = (UMQQMini) uMediaObject;
                this.f54050l = this.f54048j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f54049k = file;
            }
        }
        this.f54053o = shareContent.subject;
        this.f54051m = shareContent.getShareType();
        this.f54052n = a();
    }

    private String a() {
        int i4 = this.f54051m;
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 8 ? i4 != 16 ? i4 != 32 ? i4 != 64 ? i4 != 128 ? i4 != 256 ? "error" : "qqMini" : "minapp" : "emoji" : "file" : "web" : "video" : "music" : "textandimage" : "image" : "text";
    }

    private byte[] b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = a.a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.f54053o) ? "umengshare" : this.f54053o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f54050l;
    }

    public File getFile() {
        return this.f54049k;
    }

    public UMImage getImage() {
        return this.f54039a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() != null) {
            byte[] a4 = a.a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
            if (a4 == null || a4.length <= 0) {
                SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return b();
            }
            return a4;
        }
        return b();
    }

    public UMusic getMusic() {
        return this.f54045g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        if (TextUtils.isEmpty(uMusic.getmTargetUrl())) {
            return uMusic.toUrl();
        }
        return uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f54047i;
    }

    public String getStrStyle() {
        return this.f54052n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) > 491520) {
            byte[] a4 = a.a(getImage(), 491520);
            if (a4 == null || a4.length <= 0) {
                SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return null;
            }
            return a4;
        }
        return getImageData(uMImage);
    }

    public String getSubject() {
        return this.f54053o;
    }

    public String getText() {
        return this.f54041c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return a.a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f54044f;
    }

    public UMMin getUmMin() {
        return this.f54046h;
    }

    public UMVideo[] getUmVideos() {
        return this.f54043e;
    }

    public UMWeb getUmWeb() {
        return this.f54048j;
    }

    public UMVideo getVideo() {
        return this.f54042d;
    }

    public UMImage[] getmImages() {
        return this.f54040b;
    }

    public int getmStyle() {
        return this.f54051m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "\u8fd9\u91cc\u662f\u63cf\u8ff0";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f54054p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                return (asBinImage == null || a.a(thumbImage) > this.WX_MIN_LIMIT) ? this.f54054p.compressThumb(asBinImage) : asBinImage;
            }
            byte[] a4 = a.a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
            if (a4 == null || a4.length <= 0) {
                SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return a4;
            }
            return a4;
        }
        return DefaultClass.getBytes();
    }

    public String objectSetText(String str, int i4) {
        return TextUtils.isEmpty(str) ? "\u8fd9\u91cc\u662f\u63cf\u8ff0" : str.length() > i4 ? str.substring(0, i4) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f54054p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                return (asBinImage == null || a.a(thumbImage) > this.THUMB_LIMIT) ? this.f54054p.compressThumb(asBinImage) : asBinImage;
            }
            byte[] a4 = a.a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
            if (a4 == null || a4.length <= 0) {
                SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return b();
            }
            return a4;
        }
        return b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "\u8fd9\u91cc\u662f\u6807\u9898";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.f54054p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f54039a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f54045g = uMusic;
    }

    public void setText(String str) {
        this.f54041c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f54042d = uMVideo;
    }

    public String subString(String str, int i4) {
        return (!TextUtils.isEmpty(str) || str.length() <= i4) ? str : str.substring(0, i4);
    }

    public String objectSetText(String str) {
        return objectSetText(str, 10240);
    }
}
