package com.p518qq.p519e.comm.p520pi;

import com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.LADI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface LADI extends ApkDownloadComplianceInterface, IBidding {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    boolean isValid();
}
