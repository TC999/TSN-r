package com.bytedance.msdk.adapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTAdConstant {
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final int HORIZONTAL = 2;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final String TAG = "TT_AD_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final String TT_ADMOB_NATIVE_VIEW_ROOT_TAG = "tt_admob_native_view_root_tag";
    public static final String TT_ADMOB_NATIVE_VIEW_TAG = "tt_admob_native_view_tag";
    public static final String TT_GDT_NATIVE_LOGO_VIEW_TAG = "tt_gdt_developer_view_logo";
    public static final String TT_GDT_NATIVE_ROOT_VIEW_TAG = "tt_gdt_developer_view_root";
    public static final String TT_GDT_NATIVE_VIEW_TAG = "tt_gdt_developer_view";
    public static final int VERTICAL = 1;

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
