package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2573a;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.p571c.p572a.ImageImpl;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SimpleShareContent {

    /* renamed from: a */
    private UMImage f39455a;

    /* renamed from: b */
    private UMImage[] f39456b;

    /* renamed from: c */
    private String f39457c;

    /* renamed from: d */
    private UMVideo f39458d;

    /* renamed from: e */
    private UMVideo[] f39459e;

    /* renamed from: f */
    private UMEmoji f39460f;

    /* renamed from: g */
    private UMusic f39461g;

    /* renamed from: h */
    private UMMin f39462h;

    /* renamed from: i */
    private UMQQMini f39463i;

    /* renamed from: j */
    private UMWeb f39464j;

    /* renamed from: k */
    private File f39465k;

    /* renamed from: l */
    private BaseMediaObject f39466l;

    /* renamed from: m */
    private int f39467m;

    /* renamed from: n */
    private String f39468n;

    /* renamed from: o */
    private String f39469o;

    /* renamed from: p */
    private CompressListener f39470p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "这里是标题";
    public final String DEFAULT_DESCRIPTION = "这里是描述";

    public SimpleShareContent(ShareContent shareContent) {
        UMVideo[] uMVideoArr;
        this.f39457c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null && (uMediaObject instanceof UMImage) && (uMVideoArr = shareContent.Video_mMedias) != null) {
            UMImage uMImage = (UMImage) uMediaObject;
            this.f39455a = uMImage;
            this.f39466l = uMImage;
            UMImage[] uMImageArr = shareContent.mMedias;
            if (uMImageArr != null && uMImageArr.length > 0) {
                this.f39456b = uMImageArr;
            }
            this.f39466l = this.f39458d;
            if (uMVideoArr != null && uMVideoArr.length > 0) {
                this.f39459e = uMVideoArr;
            }
        } else {
            if (uMediaObject != null && (uMediaObject instanceof UMImage)) {
                UMImage uMImage2 = (UMImage) uMediaObject;
                this.f39455a = uMImage2;
                this.f39466l = uMImage2;
                UMImage[] uMImageArr2 = shareContent.mMedias;
                if (uMImageArr2 != null && uMImageArr2.length > 0) {
                    this.f39456b = uMImageArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMusic)) {
                UMusic uMusic = (UMusic) uMediaObject;
                this.f39461g = uMusic;
                this.f39466l = uMusic;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMVideo)) {
                UMVideo uMVideo = (UMVideo) uMediaObject;
                this.f39458d = uMVideo;
                this.f39466l = uMVideo;
                UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
                if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                    this.f39459e = uMVideoArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMEmoji)) {
                UMEmoji uMEmoji = (UMEmoji) uMediaObject;
                this.f39460f = uMEmoji;
                this.f39466l = uMEmoji;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMWeb)) {
                UMWeb uMWeb = (UMWeb) uMediaObject;
                this.f39464j = uMWeb;
                this.f39466l = uMWeb;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMMin)) {
                this.f39462h = (UMMin) uMediaObject;
                this.f39466l = this.f39464j;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMQQMini)) {
                this.f39463i = (UMQQMini) uMediaObject;
                this.f39466l = this.f39464j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f39465k = file;
            }
        }
        this.f39469o = shareContent.subject;
        this.f39467m = shareContent.getShareType();
        this.f39468n = m13280a();
    }

    /* renamed from: a */
    private String m13280a() {
        int i = this.f39467m;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? "error" : "qqMini" : "minapp" : "emoji" : IDataSource.f43973c : "web" : "video" : "music" : "textandimage" : SocializeProtocolConstants.IMAGE : C2573a.f8443b;
    }

    /* renamed from: b */
    private byte[] m13279b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = ImageImpl.m13313a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.m13211E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.f39469o) ? "umengshare" : this.f39469o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f39466l;
    }

    public File getFile() {
        return this.f39465k;
    }

    public UMImage getImage() {
        return this.f39455a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() != null) {
            byte[] m13313a = ImageImpl.m13313a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
            if (m13313a == null || m13313a.length <= 0) {
                SLog.m13211E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return m13279b();
            }
            return m13313a;
        }
        return m13279b();
    }

    public UMusic getMusic() {
        return this.f39461g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        if (TextUtils.isEmpty(uMusic.getmTargetUrl())) {
            return uMusic.toUrl();
        }
        return uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f39463i;
    }

    public String getStrStyle() {
        return this.f39468n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) > 491520) {
            byte[] m13313a = ImageImpl.m13313a(getImage(), 491520);
            if (m13313a == null || m13313a.length <= 0) {
                SLog.m13211E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return null;
            }
            return m13313a;
        }
        return getImageData(uMImage);
    }

    public String getSubject() {
        return this.f39469o;
    }

    public String getText() {
        return this.f39457c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return ImageImpl.m13314a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f39460f;
    }

    public UMMin getUmMin() {
        return this.f39462h;
    }

    public UMVideo[] getUmVideos() {
        return this.f39459e;
    }

    public UMWeb getUmWeb() {
        return this.f39464j;
    }

    public UMVideo getVideo() {
        return this.f39458d;
    }

    public UMImage[] getmImages() {
        return this.f39456b;
    }

    public int getmStyle() {
        return this.f39467m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f39470p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                return (asBinImage == null || ImageImpl.m13314a(thumbImage) > this.WX_MIN_LIMIT) ? this.f39470p.compressThumb(asBinImage) : asBinImage;
            }
            byte[] m13308a = ImageImpl.m13308a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
            if (m13308a == null || m13308a.length <= 0) {
                SLog.m13211E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return m13308a;
            }
            return m13308a;
        }
        return DefaultClass.getBytes();
    }

    public String objectSetText(String str, int i) {
        return TextUtils.isEmpty(str) ? "这里是描述" : str.length() > i ? str.substring(0, i) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f39470p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                return (asBinImage == null || ImageImpl.m13314a(thumbImage) > this.THUMB_LIMIT) ? this.f39470p.compressThumb(asBinImage) : asBinImage;
            }
            byte[] m13313a = ImageImpl.m13313a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
            if (m13313a == null || m13313a.length <= 0) {
                SLog.m13211E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
                return m13279b();
            }
            return m13313a;
        }
        return m13279b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.f39470p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f39455a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f39461g = uMusic;
    }

    public void setText(String str) {
        this.f39457c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f39458d = uMVideo;
    }

    public String subString(String str, int i) {
        return (!TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public String objectSetText(String str) {
        return objectSetText(str, 10240);
    }
}
