package com.bxkj.student.v2.common.utils;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.File;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BottomNavigationViewHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {
    public static void a(BottomNavigationView view, String[] imgUrl) {
        com.orhanobut.logger.j.c("\u9996\u9875\u5e95\u90e8\u5bfc\u822a\u6309\u94aeimgUrl:" + Arrays.toString(imgUrl));
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        com.bumptech.glide.request.h hVar = (com.bumptech.glide.request.h) com.bumptech.glide.request.h.r1(true).s(com.bumptech.glide.load.engine.j.f17104b);
        for (int i4 = 0; i4 < bottomNavigationMenuView.getChildCount(); i4++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i4)).findViewById(2131231448);
                if (imgUrl[i4].startsWith("http")) {
                    com.bumptech.glide.d.C(view.getContext()).a(imgUrl[i4]).U0(hVar).j1(imageView);
                } else if (imgUrl[i4].startsWith(TTPathConst.sSeparator)) {
                    com.bumptech.glide.d.C(view.getContext()).f(new File(imgUrl[i4])).U0(hVar).j1(imageView);
                } else {
                    com.bumptech.glide.d.C(view.getContext()).p(Integer.valueOf(Integer.parseInt(imgUrl[i4]))).U0(hVar).j1(imageView);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    public static void b(BottomNavigationView view, int index, @DrawableRes int defaultImg, String gifUrl) {
        try {
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.d.C(view.getContext()).a(gifUrl).x0(defaultImg)).y(defaultImg)).j1((ImageView) ((BottomNavigationItemView) ((BottomNavigationMenuView) view.getChildAt(0)).getChildAt(index)).findViewById(2131231448));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void c(BottomNavigationView view, int marginTop) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i4 = 0; i4 < bottomNavigationMenuView.getChildCount(); i4++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i4)).findViewById(2131231448);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = marginTop;
                imageView.setLayoutParams(marginLayoutParams);
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    public static void d(BottomNavigationView view, int width, int height) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i4 = 0; i4 < bottomNavigationMenuView.getChildCount(); i4++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i4)).findViewById(2131231448);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = width;
                layoutParams.width = height;
                imageView.setLayoutParams(layoutParams);
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
    }
}
