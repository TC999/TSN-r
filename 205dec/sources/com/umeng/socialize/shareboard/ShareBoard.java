package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.umeng.socialize.utils.SocializeSpUtils;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ShareBoard extends PopupWindow {
    private ShareBoardConfig mShareBoardConfig;

    public ShareBoard(Context context, List<SnsPlatform> list) {
        this(context, list, null);
    }

    private void saveShareboardConfig(Context context, ShareBoardConfig shareBoardConfig) {
        if (context == null || shareBoardConfig == null) {
            return;
        }
        String str = "0";
        String str2 = shareBoardConfig.mShareboardPosition == ShareBoardConfig.SHAREBOARD_POSITION_BOTTOM ? "0" : "1";
        int i4 = shareBoardConfig.mMenuBgShape;
        if (i4 != ShareBoardConfig.BG_SHAPE_NONE) {
            if (i4 == ShareBoardConfig.BG_SHAPE_CIRCULAR) {
                str = "1";
            } else if (i4 == ShareBoardConfig.BG_SHAPE_ROUNDED_SQUARE) {
                str = shareBoardConfig.mMenuBgShapeAngle != 0 ? "2" : "3";
            } else {
                str = null;
            }
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return;
        }
        SocializeSpUtils.putShareBoardConfig(context, str + ";" + str2);
    }

    public void setShareBoardlistener(final ShareBoardlistener shareBoardlistener) {
        if (this.mShareBoardConfig == null) {
            return;
        }
        this.mShareBoardConfig.setShareBoardlistener(new ShareBoardlistener() { // from class: com.umeng.socialize.shareboard.ShareBoard.3
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                ShareBoard.this.setOnDismissListener(null);
                ShareBoard.this.dismiss();
                ShareBoardlistener shareBoardlistener2 = shareBoardlistener;
                if (shareBoardlistener2 != null) {
                    shareBoardlistener2.onclick(snsPlatform, share_media);
                }
            }
        });
    }

    public ShareBoard(Context context, List<SnsPlatform> list, ShareBoardConfig shareBoardConfig) {
        super(context);
        setWindowLayoutMode(-1, -1);
        boolean z3 = context.getResources().getConfiguration().orientation == 2;
        shareBoardConfig = shareBoardConfig == null ? new ShareBoardConfig() : shareBoardConfig;
        this.mShareBoardConfig = shareBoardConfig;
        shareBoardConfig.setOrientation(z3);
        UMActionFrame uMActionFrame = new UMActionFrame(context);
        uMActionFrame.setSnsPlatformData(list, shareBoardConfig);
        uMActionFrame.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        uMActionFrame.setDismissListener(new PopupWindow.OnDismissListener() { // from class: com.umeng.socialize.shareboard.ShareBoard.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ShareBoard.this.dismiss();
            }
        });
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.umeng.socialize.shareboard.ShareBoard.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow.OnDismissListener onDismissListener = ShareBoard.this.mShareBoardConfig != null ? ShareBoard.this.mShareBoardConfig.getOnDismissListener() : null;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss();
                }
            }
        });
        setContentView(uMActionFrame);
        setFocusable(true);
        saveShareboardConfig(context, shareBoardConfig);
    }
}
