package com.beizi.fusion;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface NativeUnifiedAdResponse {
    String getActionText();

    String getDescription();

    int getECPM();

    String getIconUrl();

    String getImageUrl();

    List<String> getImgList();

    int getMaterialType();

    String getTitle();

    View getVideoView();

    ViewGroup getViewContainer();

    boolean isVideo();

    void registerViewForInteraction(List<View> list);
}
