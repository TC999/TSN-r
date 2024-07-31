package com.umeng.socialize.shareboard;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.umeng.socialize.utils.ShareBoardlistener;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShareBoardConfig {
    public static int BG_SHAPE_CIRCULAR = 1;
    public static int BG_SHAPE_NONE = 0;
    public static int BG_SHAPE_ROUNDED_SQUARE = 2;
    static final int CANCEL_BTN_HEIGHT = 50;
    static final int CANCEL_BTN_TEXT_SIZE_IN_SP = 15;
    static final int CENTER_MENU_LEFT_PADDING = 36;
    static final int INDICATOR_BOTTOM_MARGIN = 20;
    static final int INDICATOR_SIZE = 3;
    static final int INDICATOR_SPACE = 5;
    private static final int MENU_COLUMN_NUM = 4;
    private static final int MENU_COLUMN_NUM_CENTER = 3;
    private static final int MENU_COLUMN_NUM_HORIZONTAL = 6;
    private static final int MENU_COLUMN_NUM_HORIZONTAL_CENTER = 5;
    static final int MENU_ROW_MARGIN = 20;
    static final int MENU_ROW_NUM = 2;
    static final int MENU_TOP_MARGIN = 20;
    public static int SHAREBOARD_POSITION_BOTTOM = 3;
    public static int SHAREBOARD_POSITION_CENTER = 2;
    static int SHAREBOARD_POSITION_TOP = 1;
    static final int TITLE_TEXT_SIZE_IN_SP = 16;
    static final int TITLE_TOP_MARGIN = 20;
    static final int VIEW_PAGER_LEFT_MARGIN = 10;
    int mCancelBtnBgColor;
    int mCancelBtnBgPressedColor;
    int mCancelBtnColor;
    String mCancelBtnText;
    boolean mCancelBtnVisibility;
    int mIndicatorNormalColor;
    int mIndicatorSelectedColor;
    boolean mIndicatorVisibility;
    int mMenuBgColor;
    int mMenuBgPressedColor;
    int mMenuBgShape;
    int mMenuBgShapeAngle;
    int mMenuColumnNum;
    int mMenuIconPressedColor;
    int mMenuTextColor;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private ShareBoardlistener mShareBoardlistener;
    int mShareboardBgColor;
    int mShareboardPosition;
    String mTitleText;
    int mTitleTextColor;
    boolean mTitleVisibility;
    int mTopMargin;

    public ShareBoardConfig() {
        setDefaultValue();
    }

    private void setDefaultValue() {
        int parseColor = Color.parseColor("#575A5C");
        setShareboardBackgroundColor(Color.parseColor("#E9EFF2"));
        setShareboardPostion(SHAREBOARD_POSITION_BOTTOM);
        setTitleText("选择要分享到的平台");
        setTitleTextColor(parseColor);
        setMenuItemBackgroundShape(BG_SHAPE_ROUNDED_SQUARE, 5);
        setMenuItemBackgroundColor(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setMenuItemIconPressedColor(Color.parseColor("#22000000"));
        setMenuItemTextColor(parseColor);
        setCancelButtonText("取消分享");
        setCancelButtonTextColor(parseColor);
        setCancelButtonBackground(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setIndicatorColor(Color.parseColor("#C2C9CC"), Color.parseColor("#0086DC"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int calculateMenuHeightInDp(int i) {
        int i2 = i <= this.mMenuColumnNum ? 1 : 2;
        return (i2 * 75) + ((i2 - 1) * 20) + 20;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PopupWindow.OnDismissListener getOnDismissListener() {
        return this.mOnDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareBoardlistener getShareBoardlistener() {
        return this.mShareBoardlistener;
    }

    public ShareBoardConfig setCancelButtonBackground(int i) {
        setCancelButtonBackground(i, 0);
        return this;
    }

    public ShareBoardConfig setCancelButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            setCancelButtonVisibility(false);
        } else {
            setCancelButtonVisibility(true);
            this.mCancelBtnText = str;
        }
        return this;
    }

    public ShareBoardConfig setCancelButtonTextColor(int i) {
        this.mCancelBtnColor = i;
        return this;
    }

    public ShareBoardConfig setCancelButtonVisibility(boolean z) {
        this.mCancelBtnVisibility = z;
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i) {
        setIndicatorColor(i, 0);
        return this;
    }

    public ShareBoardConfig setIndicatorVisibility(boolean z) {
        this.mIndicatorVisibility = z;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i) {
        setMenuItemBackgroundColor(i, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i) {
        setMenuItemBackgroundShape(i, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemIconPressedColor(int i) {
        this.mMenuIconPressedColor = i;
        return this;
    }

    public ShareBoardConfig setMenuItemTextColor(int i) {
        this.mMenuTextColor = i;
        return this;
    }

    public ShareBoardConfig setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOrientation(boolean z) {
        if (z) {
            int i = this.mShareboardPosition;
            if (i == SHAREBOARD_POSITION_BOTTOM) {
                this.mMenuColumnNum = 6;
                return;
            } else if (i == SHAREBOARD_POSITION_CENTER) {
                this.mMenuColumnNum = 5;
                return;
            } else {
                return;
            }
        }
        int i2 = this.mShareboardPosition;
        if (i2 == SHAREBOARD_POSITION_BOTTOM) {
            this.mMenuColumnNum = 4;
        } else if (i2 == SHAREBOARD_POSITION_CENTER) {
            this.mMenuColumnNum = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShareBoardlistener(ShareBoardlistener shareBoardlistener) {
        this.mShareBoardlistener = shareBoardlistener;
    }

    public ShareBoardConfig setShareboardBackgroundColor(int i) {
        this.mShareboardBgColor = i;
        return this;
    }

    public ShareBoardConfig setShareboardPostion(int i) {
        int i2 = SHAREBOARD_POSITION_BOTTOM;
        if (i != i2 && i != SHAREBOARD_POSITION_CENTER && i != SHAREBOARD_POSITION_TOP) {
            i = i2;
        }
        this.mShareboardPosition = i;
        return this;
    }

    public ShareBoardConfig setStatusBarHeight(int i) {
        this.mTopMargin = i;
        return this;
    }

    public ShareBoardConfig setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            setTitleVisibility(false);
        } else {
            setTitleVisibility(true);
            this.mTitleText = str;
        }
        return this;
    }

    public ShareBoardConfig setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        return this;
    }

    public ShareBoardConfig setTitleVisibility(boolean z) {
        this.mTitleVisibility = z;
        return this;
    }

    public ShareBoardConfig setCancelButtonBackground(int i, int i2) {
        this.mCancelBtnBgColor = i;
        this.mCancelBtnBgPressedColor = i2;
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i, int i2) {
        if (i != 0) {
            this.mIndicatorNormalColor = i;
        }
        if (i2 != 0) {
            this.mIndicatorSelectedColor = i2;
        }
        setIndicatorVisibility(true);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i, int i2) {
        this.mMenuBgColor = i;
        this.mMenuBgPressedColor = i2;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i, int i2) {
        if (i != BG_SHAPE_CIRCULAR && i != BG_SHAPE_ROUNDED_SQUARE) {
            i = BG_SHAPE_NONE;
        }
        this.mMenuBgShape = i;
        this.mMenuBgShapeAngle = i2;
        return this;
    }
}
