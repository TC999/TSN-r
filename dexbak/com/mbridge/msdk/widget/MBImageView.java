package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBImageView extends ImageView {

    /* renamed from: a */
    private Bitmap f32379a;

    /* renamed from: b */
    private String f32380b;

    public MBImageView(Context context) {
        super(context);
        this.f32379a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f32379a;
        if (bitmap != null && bitmap.isRecycled()) {
            SameLogTool.m21733d("mb-widget-imageview", "onDraw bitmap recycled");
            if (getContext() != null) {
                CommonImageLoader.m22343a(getContext()).m22339a(this.f32380b, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.widget.MBImageView.1
                    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
                    public final void onFailedLoad(String str, String str2) {
                        SameLogTool.m21733d("mb-widget-imageview", str2 + " load failed:" + str);
                    }

                    @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
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
        this.f32379a = bitmap;
        if (bitmap != null && bitmap.isRecycled()) {
            this.f32379a = null;
            super.setImageBitmap(null);
            SameLogTool.m21733d("mb-widget-imageview", "setImageBitmap recycled");
            return;
        }
        super.setImageBitmap(bitmap);
    }

    public void setImageUrl(String str) {
        this.f32380b = str;
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32379a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32379a = null;
    }
}
