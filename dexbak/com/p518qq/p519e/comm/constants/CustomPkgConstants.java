package com.p518qq.p519e.comm.constants;

import android.text.TextUtils;
import com.p518qq.p519e.ads.ADActivity;
import com.p518qq.p519e.ads.LandscapeADActivity;
import com.p518qq.p519e.ads.PortraitADActivity;
import com.p518qq.p519e.ads.RewardvideoLandscapeADActivity;
import com.p518qq.p519e.ads.RewardvideoPortraitADActivity;
import com.p518qq.p519e.comm.DownloadService;
import com.p518qq.p519e.comm.managers.setting.GlobalSetting;

/* renamed from: com.qq.e.comm.constants.CustomPkgConstants */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CustomPkgConstants {

    /* renamed from: a */
    private static final String f32880a = DownloadService.class.getName();

    /* renamed from: b */
    private static final String f32881b = ADActivity.class.getName();

    /* renamed from: c */
    private static final String f32882c = PortraitADActivity.class.getName();

    /* renamed from: d */
    private static final String f32883d = RewardvideoPortraitADActivity.class.getName();

    /* renamed from: e */
    private static final String f32884e = LandscapeADActivity.class.getName();

    /* renamed from: f */
    private static final String f32885f = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !TextUtils.isEmpty(customADActivityClassName) ? customADActivityClassName : f32881b;
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f32880a;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !TextUtils.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : f32884e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !TextUtils.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f32882c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f32885f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f32883d;
    }
}
