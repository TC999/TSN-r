package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IBasicCPUAggregation {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface ICpuHotNativeStatus {
        void onNotifyPerformance(String str);
    }

    String getContentId();

    List<String> getImagesList();

    String getLongTitle();

    String getShortTitle();

    String getTitle();

    void registerViewForInteraction(View view, List<View> list, ICpuHotNativeStatus iCpuHotNativeStatus);
}
