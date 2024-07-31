package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.msdk.api.GDTExtraOption;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.express2.VideoOption2;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GDTAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static VideoOption getVideoOption(GDTExtraOption gDTExtraOption) {
        VideoOption.Builder builder = new VideoOption.Builder();
        if (gDTExtraOption != null) {
            builder.setAutoPlayPolicy(gDTExtraOption.getGDTAutoPlayPolicy());
            builder.setAutoPlayMuted(gDTExtraOption.isGDTAutoPlayMuted());
            builder.setDetailPageMuted(gDTExtraOption.isGDTDetailPageMuted());
            builder.setEnableDetailPage(gDTExtraOption.isGDTEnableDetailPage());
            builder.setEnableUserControl(gDTExtraOption.isGDTEnableUserControl());
        }
        return builder.build();
    }

    public static VideoOption2 getVideoOption2(GDTExtraOption gDTExtraOption) {
        VideoOption2.AutoPlayPolicy autoPlayPolicy;
        VideoOption2.Builder builder = new VideoOption2.Builder();
        if (gDTExtraOption != null) {
            if (gDTExtraOption.getGDTAutoPlayPolicy() == 0) {
                autoPlayPolicy = VideoOption2.AutoPlayPolicy.WIFI;
            } else if (gDTExtraOption.getGDTAutoPlayPolicy() == 1) {
                autoPlayPolicy = VideoOption2.AutoPlayPolicy.ALWAYS;
            } else {
                if (gDTExtraOption.getGDTAutoPlayPolicy() == 2) {
                    autoPlayPolicy = VideoOption2.AutoPlayPolicy.NEVER;
                }
                builder.setAutoPlayMuted(gDTExtraOption.isGDTAutoPlayMuted());
                builder.setDetailPageMuted(gDTExtraOption.isGDTDetailPageMuted());
                builder.setMaxVideoDuration(gDTExtraOption.getGDTMaxVideoDuration());
                builder.setMinVideoDuration(gDTExtraOption.getGDTMinVideoDuration());
            }
            builder.setAutoPlayPolicy(autoPlayPolicy);
            builder.setAutoPlayMuted(gDTExtraOption.isGDTAutoPlayMuted());
            builder.setDetailPageMuted(gDTExtraOption.isGDTDetailPageMuted());
            builder.setMaxVideoDuration(gDTExtraOption.getGDTMaxVideoDuration());
            builder.setMinVideoDuration(gDTExtraOption.getGDTMinVideoDuration());
        }
        return builder.build();
    }

    public static int getVideoPlayPolicy(int i, Context context) {
        if (i == 1) {
            return 1;
        }
        if (i != 0) {
            return i == 2 ? 2 : 0;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return (networkInfo == null || !networkInfo.isConnected()) ? 2 : 1;
    }
}
