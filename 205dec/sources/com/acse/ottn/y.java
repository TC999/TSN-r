package com.acse.ottn;

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

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y {

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f7001a;

        public a(float f4) {
            this.f7001a = f4;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f7001a);
        }
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

    public static float a(float f4) {
        return TypedValue.applyDimension(1, f4, Resources.getSystem().getDisplayMetrics());
    }

    @RequiresApi(api = 21)
    public static void a(View view, float f4) {
        view.setOutlineProvider(new a(f4));
        view.setClipToOutline(true);
    }
}
