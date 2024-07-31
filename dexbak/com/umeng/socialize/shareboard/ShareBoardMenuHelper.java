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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class ShareBoardMenuHelper {
    private static String TAG = "ShareBoardMenuHelper";
    private ShareBoardConfig mShareBoardConfig;

    public ShareBoardMenuHelper(ShareBoardConfig shareBoardConfig) {
        this.mShareBoardConfig = shareBoardConfig;
    }

    private View createBtnView(Context context, final SnsPlatform snsPlatform) {
        String str;
        LinearLayout linearLayout = new LinearLayout(context);
        int i = 0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        if (snsPlatform != null) {
            ResContainer resContainer = ResContainer.get(context);
            View inflate = LayoutInflater.from(context).inflate(resContainer.layout("socialize_share_menu_item"), (ViewGroup) null);
            SocializeImageView socializeImageView = (SocializeImageView) inflate.findViewById(resContainer.m13290id("socialize_image_view"));
            TextView textView = (TextView) inflate.findViewById(resContainer.m13290id("socialize_text_view"));
            ShareBoardConfig shareBoardConfig = this.mShareBoardConfig;
            int i2 = shareBoardConfig.mMenuBgColor;
            if (i2 != 0 && shareBoardConfig.mMenuBgShape != ShareBoardConfig.BG_SHAPE_NONE) {
                socializeImageView.setBackgroundColor(i2, shareBoardConfig.mMenuBgPressedColor);
                ShareBoardConfig shareBoardConfig2 = this.mShareBoardConfig;
                socializeImageView.setBackgroundShape(shareBoardConfig2.mMenuBgShape, shareBoardConfig2.mMenuBgShapeAngle);
            } else {
                socializeImageView.setPadding(0, 0, 0, 0);
            }
            int i3 = this.mShareBoardConfig.mMenuIconPressedColor;
            if (i3 != 0) {
                socializeImageView.setPressedColor(i3);
            }
            try {
                str = snsPlatform.mShowWord;
            } catch (Exception e) {
                SHARE_MEDIA share_media = snsPlatform.mPlatform;
                String share_media2 = share_media == null ? "" : share_media.toString();
                SLog.error(UmengText.SHAREBOARD.NULLNAME + share_media2, e);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(snsPlatform.mShowWord);
            }
            textView.setGravity(17);
            try {
                i = ResContainer.getResourceId(context, "drawable", snsPlatform.mIcon);
            } catch (Exception e2) {
                SHARE_MEDIA share_media3 = snsPlatform.mPlatform;
                String share_media4 = share_media3 != null ? share_media3.toString() : "";
                SLog.error(UmengText.SHAREBOARD.NULLNAME + share_media4, e2);
            }
            if (i != 0) {
                socializeImageView.setImageResource(i);
            }
            int i4 = this.mShareBoardConfig.mMenuTextColor;
            if (i4 != 0) {
                textView.setTextColor(i4);
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

    private View createRowLayout(Context context, SnsPlatform[] snsPlatformArr, boolean z) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            layoutParams.topMargin = dip2px(context, 20.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        for (SnsPlatform snsPlatform : snsPlatformArr) {
            linearLayout.addView(createBtnView(context, snsPlatform));
        }
        return linearLayout;
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View createPageLayout(Context context, SnsPlatform[][] snsPlatformArr) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i = 0;
        while (i < snsPlatformArr.length) {
            linearLayout.addView(createRowLayout(context, snsPlatformArr[i], i != 0));
            i++;
        }
        return linearLayout;
    }

    public List<SnsPlatform[][]> formatPageData(List<SnsPlatform> list) {
        int i;
        SnsPlatform[][] snsPlatformArr;
        int i2 = this.mShareBoardConfig.mMenuColumnNum * 2;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i3 = this.mShareBoardConfig.mMenuColumnNum;
        if (size < i3) {
            SnsPlatform[][] snsPlatformArr2 = (SnsPlatform[][]) Array.newInstance(SnsPlatform.class, 1, size);
            for (int i4 = 0; i4 < list.size(); i4++) {
                snsPlatformArr2[0][i4] = list.get(i4);
            }
            arrayList.add(snsPlatformArr2);
            return arrayList;
        }
        int i5 = size / i2;
        int i6 = size % i2;
        if (i6 != 0) {
            i = (i6 / i3) + (i6 % i3 != 0 ? 1 : 0);
            i5++;
        } else {
            i = -1;
        }
        int i7 = 0;
        while (i7 < i5) {
            arrayList.add((SnsPlatform[][]) Array.newInstance(SnsPlatform.class, (i7 != i5 + (-1) || i == -1) ? 2 : i, this.mShareBoardConfig.mMenuColumnNum));
            i7++;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            for (SnsPlatform[] snsPlatformArr3 : (SnsPlatform[][]) arrayList.get(i9)) {
                for (int i10 = 0; i10 < snsPlatformArr3.length; i10++) {
                    if (i8 < size) {
                        snsPlatformArr3[i10] = list.get(i8);
                    }
                    i8++;
                }
            }
        }
        return arrayList;
    }
}
