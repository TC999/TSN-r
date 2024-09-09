package com.beizi.ad.internal.view;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Displayable.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface c {
    void destroy();

    boolean failed();

    int getCreativeHeight();

    int getCreativeWidth();

    int getRefreshInterval();

    View getView();

    void onDestroy();

    void onPause();

    void onResume();

    void visible();
}
