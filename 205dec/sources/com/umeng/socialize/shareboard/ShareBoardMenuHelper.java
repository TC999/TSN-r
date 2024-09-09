package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class ShareBoardMenuHelper {
    private static String TAG = "ShareBoardMenuHelper";
    private ShareBoardConfig mShareBoardConfig;

    public ShareBoardMenuHelper(ShareBoardConfig shareBoardConfig) {
        this.mShareBoardConfig = shareBoardConfig;
    }

    private View createBtnView(Context context, final SnsPlatform snsPlatform) {
        String str;
        LinearLayout linearLayout = new LinearLayout(context);
        int i4 = 0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        if (snsPlatform != null) {
            ResContainer resContainer = ResContainer.get(context);
            View inflate = LayoutInflater.from(context).inflate(resContainer.layout("socialize_share_menu_item"), (ViewGroup) null);
            SocializeImageView socializeImageView = (SocializeImageView) inflate.findViewById(resContainer.id("socialize_image_view"));
            TextView textView = (TextView) inflate.findViewById(resContainer.id("socialize_text_view"));
            ShareBoardConfig shareBoardConfig = this.mShareBoardConfig;
            int i5 = shareBoardConfig.mMenuBgColor;
            if (i5 != 0 && shareBoardConfig.mMenuBgShape != ShareBoardConfig.BG_SHAPE_NONE) {
                socializeImageView.setBackgroundColor(i5, shareBoardConfig.mMenuBgPressedColor);
                ShareBoardConfig shareBoardConfig2 = this.mShareBoardConfig;
                socializeImageView.setBackgroundShape(shareBoardConfig2.mMenuBgShape, shareBoardConfig2.mMenuBgShapeAngle);
            } else {
                socializeImageView.setPadding(0, 0, 0, 0);
            }
            int i6 = this.mShareBoardConfig.mMenuIconPressedColor;
            if (i6 != 0) {
                socializeImageView.setPressedColor(i6);
            }
            try {
                str = snsPlatform.mShowWord;
            } catch (Exception e4) {
                SHARE_MEDIA share_media = snsPlatform.mPlatform;
                String share_media2 = share_media == null ? "" : share_media.toString();
                SLog.error(UmengText.SHAREBOARD.NULLNAME + share_media2, e4);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(snsPlatform.mShowWord);
            }
            textView.setGravity(17);
            try {
                i4 = ResContainer.getResourceId(context, "drawable", snsPlatform.mIcon);
            } catch (Exception e5) {
                SHARE_MEDIA share_media3 = snsPlatform.mPlatform;
                String share_media4 = share_media3 != null ? share_media3.toString() : "";
                SLog.error(UmengText.SHAREBOARD.NULLNAME + share_media4, e5);
            }
            if (i4 != 0) {
                socializeImageView.setImageResource(i4);
            }
            int i7 = this.mShareBoardConfig.mMenuTextColor;
            if (i7 != 0) {
                textView.setTextColor(i7);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.shareboard.ShareBoardMenuHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SHARE_MEDIA share_media5 = snsPlatform.mPlatform;
                    if (ShareBoardMenuHelper.this.mShareBoardConfig == null || ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener() == null) {
                        return;
                    }
                    ShareBoardMenuHelper.this.mShareBoardConfig.getShareBoardlistener().onclick(snsPlatform, share_media5);
                }
            });
            linearLayout.addView(inflate);
        }
        return linearLayout;
    }

    private View createRowLayout(Context context, SnsPlatform[] snsPlatformArr, boolean z3) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z3) {
            layoutParams.topMargin = dip2px(context, 20.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        for (SnsPlatform snsPlatform : snsPlatformArr) {
            linearLayout.addView(createBtnView(context, snsPlatform));
        }
        return linearLayout;
    }

    private int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View createPageLayout(Context context, SnsPlatform[][] snsPlatformArr) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i4 = 0;
        while (i4 < snsPlatformArr.length) {
            linearLayout.addView(createRowLayout(context, snsPlatformArr[i4], i4 != 0));
            i4++;
        }
        return linearLayout;
    }

    public List<SnsPlatform[][]> formatPageData(List<SnsPlatform> list) {
        int i4;
        SnsPlatform[][] snsPlatformArr;
        int i5 = this.mShareBoardConfig.mMenuColumnNum * 2;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i6 = this.mShareBoardConfig.mMenuColumnNum;
        if (size < i6) {
            SnsPlatform[][] snsPlatformArr2 = (SnsPlatform[][]) Array.newInstance(SnsPlatform.class, 1, size);
            for (int i7 = 0; i7 < list.size(); i7++) {
                snsPlatformArr2[0][i7] = list.get(i7);
            }
            arrayList.add(snsPlatformArr2);
            return arrayList;
        }
        int i8 = size / i5;
        int i9 = size % i5;
        if (i9 != 0) {
            i4 = (i9 / i6) + (i9 % i6 != 0 ? 1 : 0);
            i8++;
        } else {
            i4 = -1;
        }
        int i10 = 0;
        while (i10 < i8) {
            arrayList.add((SnsPlatform[][]) Array.newInstance(SnsPlatform.class, (i10 != i8 + (-1) || i4 == -1) ? 2 : i4, this.mShareBoardConfig.mMenuColumnNum));
            i10++;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            for (SnsPlatform[] snsPlatformArr3 : (SnsPlatform[][]) arrayList.get(i12)) {
                for (int i13 = 0; i13 < snsPlatformArr3.length; i13++) {
                    if (i11 < size) {
                        snsPlatformArr3[i13] = list.get(i11);
                    }
                    i11++;
                }
            }
        }
        return arrayList;
    }
}
