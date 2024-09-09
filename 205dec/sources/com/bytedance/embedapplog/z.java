package com.bytedance.embedapplog;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z extends i {
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context) {
        super(true, false);
        this.ux = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.ux.getResources().getDisplayMetrics();
        int i4 = displayMetrics.densityDpi;
        switch (i4) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO /* 340 */:
            case 360:
            case 400:
            case 420:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ /* 560 */:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i4);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
