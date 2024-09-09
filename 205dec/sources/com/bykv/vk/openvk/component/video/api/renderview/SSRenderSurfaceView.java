package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, w {
    private static final ArrayList<xv> xv = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<c> f24928c;
    private w.c sr;

    /* renamed from: w  reason: collision with root package name */
    private xv f24929w;

    public SSRenderSurfaceView(Context context) {
        super(context);
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_SurfaceView", "SSRenderSurfaceView: ");
        c();
    }

    private void c() {
        xv xvVar = new xv(this);
        this.f24929w = xvVar;
        xv.add(xvVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        w.c cVar = this.sr;
        if (cVar != null) {
            cVar.c(i4);
        }
    }

    public void setWindowVisibilityChangedListener(w.c cVar) {
        this.sr = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<c> weakReference = this.f24928c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f24928c.get().c(surfaceHolder, i4, i5, i6);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<c> weakReference = this.f24928c;
        if (weakReference != null && weakReference.get() != null) {
            this.f24928c.get().c(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<c> weakReference = this.f24928c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f24928c.get().w(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public void c(c cVar) {
        this.f24928c = new WeakReference<>(cVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<xv> it = xv.iterator();
        while (it.hasNext()) {
            xv next = it.next();
            if (next != null && next.c() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f24929w);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.w
    public void c(int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i5;
        layoutParams.width = i4;
        setLayoutParams(layoutParams);
    }
}
