package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, w {

    /* renamed from: c  reason: collision with root package name */
    private c f24930c;

    /* renamed from: w  reason: collision with root package name */
    private w.c f24931w;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public void c(c cVar) {
        this.f24930c = cVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
            if (com.bykv.vk.openvk.component.video.api.f.xv.w()) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        c cVar = this.f24930c;
        if (cVar != null) {
            cVar.c(surfaceTexture, i4, i5);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        c cVar = this.f24930c;
        if (cVar != null) {
            return cVar.c(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
        c cVar = this.f24930c;
        if (cVar != null) {
            cVar.w(surfaceTexture, i4, i5);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        c cVar = this.f24930c;
        if (cVar != null) {
            cVar.w(surfaceTexture);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        w.c cVar = this.f24931w;
        if (cVar != null) {
            cVar.c(i4);
        }
    }

    public void setWindowVisibilityChangedListener(w.c cVar) {
        this.f24931w = cVar;
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public void c(int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i5;
        layoutParams.width = i4;
        setLayoutParams(layoutParams);
    }
}
