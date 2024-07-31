package com.kwad.components.core.p296g;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.core.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8649b extends KSFrameLayout {

    /* renamed from: LE */
    private ImageView f28296LE;

    public C8649b(@NonNull Context context) {
        super(context);
    }

    /* renamed from: oB */
    private ImageView m30076oB() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    /* renamed from: a */
    public final void m30077a(String str, ImageLoadingListener imageLoadingListener) {
        ImageView imageView = this.f28296LE;
        if (imageView != null) {
            ImageLoaderProxy.INSTANCE.load(imageView, str, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.f28296LE = m30076oB();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f28296LE, layoutParams);
    }

    public final void setImageGravity(int i) {
        FrameLayout.LayoutParams layoutParams;
        ImageView imageView = this.f28296LE;
        if (imageView == null || (layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.gravity = i;
        this.f28296LE.setLayoutParams(layoutParams);
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.f28296LE;
        if (imageView == null || scaleType == null) {
            return;
        }
        imageView.setScaleType(scaleType);
    }
}
