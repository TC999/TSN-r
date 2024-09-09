package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.x;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f41090a;

    /* renamed from: b  reason: collision with root package name */
    private String f41091b;

    public MBImageView(Context context) {
        super(context);
        this.f41090a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f41090a;
        if (bitmap != null && bitmap.isRecycled()) {
            x.d("mb-widget-imageview", "onDraw bitmap recycled");
            if (getContext() != null) {
                b.a(getContext()).a(this.f41091b, new c() { // from class: com.mbridge.msdk.widget.MBImageView.1
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onFailedLoad(String str, String str2) {
                        x.d("mb-widget-imageview", str2 + " load failed:" + str);
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onSuccessLoad(Bitmap bitmap2, String str) {
                        MBImageView.this.setImageBitmap(bitmap2);
                    }
                });
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f41090a = bitmap;
        if (bitmap != null && bitmap.isRecycled()) {
            this.f41090a = null;
            super.setImageBitmap(null);
            x.d("mb-widget-imageview", "setImageBitmap recycled");
            return;
        }
        super.setImageBitmap(bitmap);
    }

    public void setImageUrl(String str) {
        this.f41091b = str;
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41090a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41090a = null;
    }
}
