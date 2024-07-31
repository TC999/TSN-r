package com.bytedance.msdk.adapter.config;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTAppDialogClickListener {
    public static final int CANCEL_BUTTON = 2;
    public static final int CONFIRM_BUTTON = 1;
    public static final int INSTALL_APP_DLG = 1;
    public static final int NO_DLG = 0;
    public static final int OPEN_APP_DLG = 2;

    void onButtonClick(int i);
}
