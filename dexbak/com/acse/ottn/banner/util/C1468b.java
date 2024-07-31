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

/* renamed from: com.acse.ottn.banner.util.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1468b {
    /* renamed from: a */
    public static float m56703a(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m56700a(boolean z, int i, int i2) {
        if (z) {
            if (i == 0) {
                return i2 - 1;
            }
            if (i == i2 + 1) {
                return 0;
            }
            return i - 1;
        }
        return i;
    }

    /* renamed from: a */
    public static View m56701a(@NonNull ViewGroup viewGroup, @LayoutRes int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams.height != -1 || layoutParams.width != -1) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            inflate.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    @RequiresApi(api = 21)
    /* renamed from: a */
    public static void m56702a(View view, final float f) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.acse.ottn.banner.util.BannerUtils$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
            }
        });
        view.setClipToOutline(true);
    }
}
