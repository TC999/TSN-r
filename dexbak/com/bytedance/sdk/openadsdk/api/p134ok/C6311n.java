package com.bytedance.sdk.openadsdk.api.p134ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.api.C6279a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.model.DownloadShortInfo;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6311n extends C6279a implements DownloadStatusChangeListener {
    public C6311n(EventListener eventListener) {
        this.f22359ok = eventListener;
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new C6313s(downloadShortInfo)).m37921f(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new C6313s(downloadShortInfo)).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new C6313s(downloadShortInfo)).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new C6313s(downloadShortInfo)).m37921f(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new C6308bl(downloadModel)).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new C6312ok(downloadController)).m37926a()).m37915a());
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        m36776ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.p521ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        m36775ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new C6313s(downloadShortInfo)).m37926a()).m37915a());
    }
}
