package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb = new StringBuilder(128);
        int i4 = this.mTrackType;
        if (i4 == 1) {
            sb.append("VIDEO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getResolutionInline());
        } else if (i4 == 2) {
            sb.append("AUDIO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getSampleRateInline());
        } else if (i4 == 3) {
            sb.append("TIMEDTEXT");
            sb.append(", ");
            sb.append(this.mStreamMeta.mLanguage);
        } else if (i4 != 4) {
            sb.append("UNKNOWN");
        } else {
            sb.append("SUBTITLE");
        }
        return sb.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        return (ijkStreamMeta == null || TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i4) {
        this.mTrackType = i4;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }
}
