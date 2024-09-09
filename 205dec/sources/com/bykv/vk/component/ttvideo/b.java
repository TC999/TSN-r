package com.bykv.vk.component.ttvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<TTVideoEngine> f24862a;

    public b(TTVideoEngine tTVideoEngine) {
        this.f24862a = new WeakReference<>(tTVideoEngine);
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "new surface callback:" + this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "surfaceCreated, " + surfaceHolder);
        TTVideoEngine tTVideoEngine = this.f24862a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "surfaceDestroyed, " + surfaceHolder);
        TTVideoEngine tTVideoEngine = this.f24862a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a((Surface) null);
        }
    }
}
