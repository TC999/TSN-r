package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ShareContent {
    public static final int EMOJI_STYLE = 64;
    public static final int ERROR_STYLE = 0;
    public static final int FILE_STYLE = 32;
    public static final int IMAGE_STYLE = 2;
    public static final int IMAGE_VIDEO = 11;
    public static final int MINAPP_STYLE = 128;
    public static final int MUSIC_STYLE = 4;
    public static final int QQMINI_STYLE = 256;
    public static final int TEXT_IMAGE_STYLE = 3;
    public static final int TEXT_STYLE = 1;
    public static final int VIDEO_STYLE = 8;
    public static final int WEB_STYLE = 16;
    public UMVideo[] Video_mMedias;
    public File app;
    public boolean bySystem;
    public File file;
    public UMediaObject mExtra;
    public String mFollow;
    public UMediaObject mMedia;
    public UMImage[] mMedias;
    public String subject = "";
    public String mText = "";

    public int getShareType() {
        UMediaObject uMediaObject = this.mMedia;
        if (uMediaObject == null && this.mExtra == null && this.file == null) {
            return TextUtils.isEmpty(this.mText) ? 0 : 1;
        } else if (this.file != null) {
            return 32;
        } else {
            if (uMediaObject != null) {
                if (uMediaObject instanceof UMEmoji) {
                    return 64;
                }
                if ((uMediaObject instanceof UMImage) && this.Video_mMedias != null) {
                    return 11;
                }
                if (uMediaObject instanceof UMImage) {
                    return TextUtils.isEmpty(this.mText) ? 2 : 3;
                } else if (uMediaObject instanceof UMusic) {
                    return 4;
                } else {
                    if (uMediaObject instanceof UMVideo) {
                        return 8;
                    }
                    if (uMediaObject instanceof UMWeb) {
                        return 16;
                    }
                    if (uMediaObject instanceof UMMin) {
                        return 128;
                    }
                    if (uMediaObject instanceof UMQQMini) {
                        return 256;
                    }
                }
            }
            return 0;
        }
    }
}
