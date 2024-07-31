package com.beizi.p051ad.internal.view;

import android.view.View;

/* renamed from: com.beizi.ad.internal.view.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Displayable {
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
