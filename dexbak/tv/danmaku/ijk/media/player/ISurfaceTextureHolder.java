package tv.danmaku.ijk.media.player;

import android.graphics.SurfaceTexture;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ISurfaceTextureHolder {
    SurfaceTexture getSurfaceTexture();

    void setSurfaceTexture(SurfaceTexture surfaceTexture);

    void setSurfaceTextureHost(ISurfaceTextureHost iSurfaceTextureHost);
}
