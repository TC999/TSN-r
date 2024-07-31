package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IBasicCPUAggregation {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
