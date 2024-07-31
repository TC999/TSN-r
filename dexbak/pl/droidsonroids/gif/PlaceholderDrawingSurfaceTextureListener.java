package pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import pl.droidsonroids.gif.GifTextureView;

/* renamed from: pl.droidsonroids.gif.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class PlaceholderDrawingSurfaceTextureListener implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    private final GifTextureView.InterfaceC15434b f44468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceholderDrawingSurfaceTextureListener(GifTextureView.InterfaceC15434b interfaceC15434b) {
        this.f44468a = interfaceC15434b;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        Canvas lockCanvas = surface.lockCanvas(null);
        this.f44468a.m2483a(lockCanvas);
        surface.unlockCanvasAndPost(lockCanvas);
        surface.release();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
