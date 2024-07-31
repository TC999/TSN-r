package com.bxkj.student.p094v2.common.utils;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.util.Arrays;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.bxkj.student.v2.common.utils.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BottomNavigationViewHelper {
    /* renamed from: a */
    public static void m39134a(BottomNavigationView view, String[] imgUrl) {
        C11792j.m20470c("首页底部导航按钮imgUrl:" + Arrays.toString(imgUrl));
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i)).findViewById(2131231355);
                if (imgUrl[i].startsWith(IDataSource.f43971a)) {
                    Glide.m45751C(view.getContext()).mo45507a(imgUrl[i]).m45551i1(imageView);
                } else if (imgUrl[i].startsWith("/")) {
                    Glide.m45751C(view.getContext()).mo45503f(new File(imgUrl[i])).m45551i1(imageView);
                } else {
                    Glide.m45751C(view.getContext()).mo45499p(Integer.valueOf(Integer.parseInt(imgUrl[i]))).m45551i1(imageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m39133b(BottomNavigationView view, int index, @DrawableRes int defaultImg, String gifUrl) {
        try {
            Glide.m45751C(view.getContext()).mo45507a(gifUrl).m44601w0(defaultImg).m44600x(defaultImg).m45551i1((ImageView) ((BottomNavigationItemView) ((BottomNavigationMenuView) view.getChildAt(0)).getChildAt(index)).findViewById(2131231355));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m39132c(BottomNavigationView view, int marginTop) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i)).findViewById(2131231355);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = marginTop;
                imageView.setLayoutParams(marginLayoutParams);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m39131d(BottomNavigationView view, int width, int height) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
            try {
                ImageView imageView = (ImageView) ((BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i)).findViewById(2131231355);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = width;
                layoutParams.width = height;
                imageView.setLayoutParams(layoutParams);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
