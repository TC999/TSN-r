package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.api.C6279a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6310kf extends C6279a implements IDownloadButtonClickListener {
    public C6310kf(EventListener eventListener) {
        this.f22359ok = eventListener;
    }

    @Override // com.p521ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z) {
        m36775ok(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37917j(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        m36776ok(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
