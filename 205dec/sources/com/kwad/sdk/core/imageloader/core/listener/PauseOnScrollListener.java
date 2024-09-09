package com.kwad.sdk.core.imageloader.core.listener;

import android.widget.AbsListView;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z3, boolean z4) {
        this(imageLoader, z3, z4, null);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i4, i5, i6);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i4) {
        if (i4 == 0) {
            this.imageLoader.resume();
        } else if (i4 != 1) {
            if (i4 == 2 && this.pauseOnFling) {
                this.imageLoader.pause();
            }
        } else if (this.pauseOnScroll) {
            this.imageLoader.pause();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i4);
        }
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z3, boolean z4, AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z3;
        this.pauseOnFling = z4;
        this.externalListener = onScrollListener;
    }
}
