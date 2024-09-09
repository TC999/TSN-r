package com.bytedance.msdk.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTAdConstant {
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final int DOWNLOAD_TYPE_NO_POPUP = 0;
    public static final int DOWNLOAD_TYPE_POPUP = 1;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final int PERMISSION_LOCATION = 1;
    public static final int PERMISSION_PHONE_STATE = 2;
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 3;
    public static final int PLUGIN_UPDATE = 2;
    public static final int PLUGIN_WIFI_UPDATE = 1;
    public static final int SPLASH_BUTTON_TYPE_DOWNLOAD_BAR = 2;
    public static final int SPLASH_BUTTON_TYPE_FULL_SCREEN = 1;
    public static final String TAG = "TT_Mediation_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final int VERTICAL = 1;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public enum GroMoreExtraKey {
        CUSTOMIZE_RIT_SCENES("groMore_key_customize_rit_scenes"),
        RIT_SCENES("groMore_key_rit_scenes");
        

        /* renamed from: a  reason: collision with root package name */
        final String f27414a;

        GroMoreExtraKey(String str) {
            this.f27414a = str;
        }

        public String getExtraKey() {
            return this.f27414a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public enum GroMoreRitScenes {
        CUSTOMIZE_SCENES("customize_scenes"),
        HOME_OPEN_BONUS("home_open_bonus"),
        HOME_SVIP_BONUS("home_svip_bonus"),
        HOME_GET_PROPS("home_get_props"),
        HOME_TRY_PROPS("home_try_props"),
        HOME_GET_BONUS("home_get_bonus"),
        HOME_GIFT_BONUS("home_gift_bonus"),
        GAME_START_BONUS("game_start_bonus"),
        GAME_REDUCE_WAITING("geme_reduce_waiting"),
        GAME_MORE_KLLKRTUNITIES("game_more_kllkrtunities"),
        GAME_FINISH_REWARDS("game_finish_rewards"),
        GAME_GIFT_BONUS("game_gift_bonus");
        

        /* renamed from: a  reason: collision with root package name */
        final String f27416a;

        GroMoreRitScenes(String str) {
            this.f27416a = str;
        }

        public String getScenesName() {
            return this.f27416a;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public @interface ORIENTATION_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public @interface TITLE_BAR_THEME {
    }
}
