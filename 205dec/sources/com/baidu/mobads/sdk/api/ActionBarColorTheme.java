package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum ActionBarColorTheme {
    ACTION_BAR_WHITE_THEME(-5987164, -6842473, -11113262, -328966),
    ACTION_BAR_RED_THEME(-1, -1, -12510, -1294276),
    ACTION_BAR_GREEN_THEME(-1, -1, -11113262, -14303071),
    ACTION_BAR_NAVYBLUE_THEME(-1, -1, 16764706, -14210226),
    ACTION_BAR_BLUE_THEME(-1, -1, -12510, -13870424),
    ACTION_BAR_COFFEE_THEME(-1, -1, -12510, -11255230),
    ACTION_BAR_BLACK_THEME(-1, -1, -12510, -13749450);
    
    public int mBackgroundColor;
    public int mCloseColor;
    public int mProgressColor;
    public int mTitleColor;

    ActionBarColorTheme(int i4, int i5, int i6, int i7) {
        this.mCloseColor = i4;
        this.mTitleColor = i5;
        this.mProgressColor = i6;
        this.mBackgroundColor = i7;
    }
}
