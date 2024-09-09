package com.acse.ottn.banner.util;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {
    public static float a(float f4) {
        return TypedValue.applyDimension(1, f4, Resources.getSystem().getDisplayMetrics());
    }

    public static int a(boolean z3, int i4, int i5) {
        if (z3) {
            if (i4 == 0) {
                return i5 - 1;
            }
            if (i4 == i5 + 1) {
                return 0;
            }
            return i4 - 1;
        }
        return i4;
    }

    public static View a(@NonNull ViewGroup viewGroup, @LayoutRes int i4) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i4, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams.height != -1 || layoutParams.width != -1) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            inflate.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    @RequiresApi(api = 21)
    public static void a(View view, final float f4) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.acse.ottn.banner.util.BannerUtils$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f4);
            }
        });
        view.setClipToOutline(true);
    }
}
