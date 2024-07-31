package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.api.C6279a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.config.OnItemClickListener;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6309h extends C6279a implements OnItemClickListener {
    public C6309h(EventListener eventListener) {
        this.f22359ok = eventListener;
    }

    @Override // com.p521ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        m36775ok(ValueSetConstants.VALUE_ON_ITEM_CLICK, m36777ok() ? null : C5934b.m37914b().m37912d(C5930a.m37925b().m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new C6308bl(downloadModel)).m37919h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, new C6307a(downloadEventConfig)).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new C6312ok(downloadController)).m37926a()).m37915a());
    }
}
