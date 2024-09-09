package com.kwad.components.offline.api.core.imageplayer;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IImagePlayer {
    void destroy();

    FrameLayout getImagePlayerView(Context context);

    void pause();

    void play();

    void prepareToPlay();

    void registerMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);

    void resume();

    void setDuration(long j4);

    void setEnableCache(boolean z3);

    void setHorizontalGravity(int i4);

    void setImageResize(int i4);

    void setRadius(float f4, float f5, float f6, float f7);

    void setURLs(List<String> list);

    void setVerticalGravity(int i4);

    void stop();

    void unregisterMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);
}
