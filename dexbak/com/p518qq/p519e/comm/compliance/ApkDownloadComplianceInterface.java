package com.p518qq.p519e.comm.compliance;

/* renamed from: com.qq.e.comm.compliance.ApkDownloadComplianceInterface */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ApkDownloadComplianceInterface {
    public static final int INSTALL_BITS = 256;
    public static final int SCENES_AD_OR_NATIVE_LANDING_PAGE = 1;
    public static final int SCENES_WEB_LANDING_PAGE = 2;

    String getApkInfoUrl();

    void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener);
}
