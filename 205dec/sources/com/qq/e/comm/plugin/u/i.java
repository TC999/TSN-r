package com.qq.e.comm.plugin.u;

import android.view.View;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.pi.IBidding;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface i extends ApkDownloadComplianceInterface, IBidding {
    void destroy();

    View e();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    int getVideoDuration();

    boolean isValid();

    void preloadVideo();

    void render();

    void setAdSize(ADSize aDSize);
}
