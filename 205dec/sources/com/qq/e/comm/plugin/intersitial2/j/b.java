package com.qq.e.comm.plugin.intersitial2.j;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.g0.v;
import com.qq.e.comm.plugin.intersitial2.d;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface b extends NEADI, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.u.b, com.qq.e.comm.plugin.e0.a, d, ApkDownloadComplianceInterface, DownloadConfirmListener {
    v d();

    ServerSideVerificationOptions f();

    com.qq.e.comm.plugin.n0.c m();

    void setLoadAdParams(LoadAdParams loadAdParams);

    @Override // com.qq.e.comm.pi.NEADI
    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
