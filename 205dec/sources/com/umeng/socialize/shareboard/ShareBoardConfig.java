package com.umeng.socialize.shareboard;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.umeng.socialize.utils.ShareBoardlistener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
        setTitleText("\u9009\u62e9\u8981\u5206\u4eab\u5230\u7684\u5e73\u53f0");
        setTitleTextColor(parseColor);
        setMenuItemBackgroundShape(BG_SHAPE_ROUNDED_SQUARE, 5);
        setMenuItemBackgroundColor(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setMenuItemIconPressedColor(Color.parseColor("#22000000"));
        setMenuItemTextColor(parseColor);
        setCancelButtonText("\u53d6\u6d88\u5206\u4eab");
        setCancelButtonTextColor(parseColor);
        setCancelButtonBackground(Color.parseColor("#ffffff"), Color.parseColor("#22000000"));
        setIndicatorColor(Color.parseColor("#C2C9CC"), Color.parseColor("#0086DC"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int calculateMenuHeightInDp(int i4) {
        int i5 = i4 <= this.mMenuColumnNum ? 1 : 2;
        return (i5 * 75) + ((i5 - 1) * 20) + 20;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PopupWindow.OnDismissListener getOnDismissListener() {
        return this.mOnDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareBoardlistener getShareBoardlistener() {
        return this.mShareBoardlistener;
    }

    public ShareBoardConfig setCancelButtonBackground(int i4) {
        setCancelButtonBackground(i4, 0);
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

    public ShareBoardConfig setCancelButtonTextColor(int i4) {
        this.mCancelBtnColor = i4;
        return this;
    }

    public ShareBoardConfig setCancelButtonVisibility(boolean z3) {
        this.mCancelBtnVisibility = z3;
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i4) {
        setIndicatorColor(i4, 0);
        return this;
    }

    public ShareBoardConfig setIndicatorVisibility(boolean z3) {
        this.mIndicatorVisibility = z3;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i4) {
        setMenuItemBackgroundColor(i4, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i4) {
        setMenuItemBackgroundShape(i4, 0);
        return this;
    }

    public ShareBoardConfig setMenuItemIconPressedColor(int i4) {
        this.mMenuIconPressedColor = i4;
        return this;
    }

    public ShareBoardConfig setMenuItemTextColor(int i4) {
        this.mMenuTextColor = i4;
        return this;
    }

    public ShareBoardConfig setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOrientation(boolean z3) {
        if (z3) {
            int i4 = this.mShareboardPosition;
            if (i4 == SHAREBOARD_POSITION_BOTTOM) {
                this.mMenuColumnNum = 6;
                return;
            } else if (i4 == SHAREBOARD_POSITION_CENTER) {
                this.mMenuColumnNum = 5;
                return;
            } else {
                return;
            }
        }
        int i5 = this.mShareboardPosition;
        if (i5 == SHAREBOARD_POSITION_BOTTOM) {
            this.mMenuColumnNum = 4;
        } else if (i5 == SHAREBOARD_POSITION_CENTER) {
            this.mMenuColumnNum = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShareBoardlistener(ShareBoardlistener shareBoardlistener) {
        this.mShareBoardlistener = shareBoardlistener;
    }

    public ShareBoardConfig setShareboardBackgroundColor(int i4) {
        this.mShareboardBgColor = i4;
        return this;
    }

    public ShareBoardConfig setShareboardPostion(int i4) {
        int i5 = SHAREBOARD_POSITION_BOTTOM;
        if (i4 != i5 && i4 != SHAREBOARD_POSITION_CENTER && i4 != SHAREBOARD_POSITION_TOP) {
            i4 = i5;
        }
        this.mShareboardPosition = i4;
        return this;
    }

    public ShareBoardConfig setStatusBarHeight(int i4) {
        this.mTopMargin = i4;
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

    public ShareBoardConfig setTitleTextColor(int i4) {
        this.mTitleTextColor = i4;
        return this;
    }

    public ShareBoardConfig setTitleVisibility(boolean z3) {
        this.mTitleVisibility = z3;
        return this;
    }

    public ShareBoardConfig setCancelButtonBackground(int i4, int i5) {
        this.mCancelBtnBgColor = i4;
        this.mCancelBtnBgPressedColor = i5;
        return this;
    }

    public ShareBoardConfig setIndicatorColor(int i4, int i5) {
        if (i4 != 0) {
            this.mIndicatorNormalColor = i4;
        }
        if (i5 != 0) {
            this.mIndicatorSelectedColor = i5;
        }
        setIndicatorVisibility(true);
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundColor(int i4, int i5) {
        this.mMenuBgColor = i4;
        this.mMenuBgPressedColor = i5;
        return this;
    }

    public ShareBoardConfig setMenuItemBackgroundShape(int i4, int i5) {
        if (i4 != BG_SHAPE_CIRCULAR && i4 != BG_SHAPE_ROUNDED_SQUARE) {
            i4 = BG_SHAPE_NONE;
        }
        this.mMenuBgShape = i4;
        this.mMenuBgShapeAngle = i5;
        return this;
    }
}
