package com.bytedance.msdk.api;

import com.bytedance.msdk.api.BaiduExtraOptions;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTVideoOption;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTVideoOptionUtil {
    public static TTVideoOption getTTVideoOption() {
        GDTExtraOption build = new GDTExtraOption.Builder().setGDTAutoPlayMuted(true).setGDTDetailPageMuted(false).setGDTEnableDetailPage(true).setGDTEnableUserControl(false).setGDTMaxVideoDuration(0).setGDTMinVideoDuration(0).setAutoPlayPolicy(0).setDownAPPConfirmPolicy(0).setBrowserType(0).build();
        return new TTVideoOption.Builder().setMuted(false).setAdmobAppVolume(1.0f).setGDTExtraOption(build).setBaiduExtraOption(new BaiduExtraOptions.Builder().setGDTExtraOption(2).setShowDialogOnSkip(true).setUseRewardCountdown(true).setAppSid(null).setCacheVideoOnlyWifi(true).build()).build();
    }

    public static TTVideoOption getTTVideoOption2() {
        GDTExtraOption build = new GDTExtraOption.Builder().setGDTAutoPlayMuted(true).setGDTDetailPageMuted(false).setGDTEnableDetailPage(true).setGDTEnableUserControl(false).setGDTMaxVideoDuration(0).setGDTMinVideoDuration(0).setFeedExpressType(2).setAutoPlayPolicy(0).setDownAPPConfirmPolicy(0).setBrowserType(0).build();
        return new TTVideoOption.Builder().setMuted(false).setAdmobAppVolume(1.0f).setGDTExtraOption(build).setBaiduExtraOption(new BaiduExtraOptions.Builder().setGDTExtraOption(2).setShowDialogOnSkip(true).setUseRewardCountdown(true).setAppSid(null).setCacheVideoOnlyWifi(true).build()).build();
    }

    public static void setFeedTTVideoOptionIfNeed(AdSlot adSlot) {
        if (adSlot == null || adSlot.getTTVideoOption() != null) {
            return;
        }
        adSlot.setTTVideoOption(getTTVideoOption());
    }

    public static void setFullTTVideoOptionIfNeed(AdSlot adSlot) {
        if (adSlot == null || adSlot.getTTVideoOption() != null) {
            return;
        }
        adSlot.setTTVideoOption(getTTVideoOption());
    }

    public static void setRewardTTVideoOptionIfNeed(AdSlot adSlot) {
        if (adSlot == null || adSlot.getTTVideoOption() != null) {
            return;
        }
        adSlot.setTTVideoOption(new TTVideoOption.Builder().setMuted(false).setAdmobAppVolume(1.0f).build());
    }
}
