package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.download.DownloadController;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6312ok implements Bridge {

    /* renamed from: ok */
    private DownloadController f22425ok;

    public C6312ok(DownloadController downloadController) {
        this.f22425ok = downloadController;
    }

    /* renamed from: a */
    public int m36668a() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    /* renamed from: bl */
    public boolean m36665bl() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223317) {
            if (valueSet != null) {
                m36666a(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, Boolean.class)).booleanValue());
                return null;
            }
            return null;
        }
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                if (valueSet != null) {
                    m36657ok(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, Integer.class)).intValue());
                    return null;
                }
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                if (valueSet != null) {
                    m36667a(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, Integer.class)).intValue());
                    return null;
                }
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                if (valueSet != null) {
                    m36654ok(((Boolean) valueSet.objectValue(ValueSetConstants.f22560x47d11ab6, Boolean.class)).booleanValue());
                    return null;
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: h */
    public Object m36664h() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    /* renamed from: i */
    public boolean m36663i() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    /* renamed from: j */
    public boolean m36662j() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    /* renamed from: k */
    public JSONObject m36661k() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    /* renamed from: kf */
    public int m36660kf() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    /* renamed from: n */
    public boolean m36659n() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    /* renamed from: ok */
    public int m36658ok() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    /* renamed from: p */
    public boolean m36653p() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    /* renamed from: q */
    public int m36652q() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    /* renamed from: r */
    public Object m36651r() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    /* renamed from: rh */
    public boolean m36650rh() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    /* renamed from: s */
    public boolean m36649s() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    /* renamed from: t */
    public boolean m36648t() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37921f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_LINK_MODE, m36658ok()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_MODE, m36668a()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_BACK_DIALOG, m36665bl()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ADD_TO_DOWNLOAD_MANAGE, m36649s()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_MULTIPLE_DOWNLOAD, m36659n()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_CHUNK_COUNT, m36660kf()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_CLICK_OPERATION, m36664h()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SHOULD_USE_NEW_WEB_VIEW, m36653p()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_INTERCEPT_FLAG, m36652q()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, m36661k()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_OBJECT, m36651r()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, m36661k()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_SHOW_COMPLIANCE_DIALOG, m36662j()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, m36647z()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_NEW_ACTIVITY, m36650rh()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AH, m36648t()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AM, m36663i()).m37926a();
    }

    /* renamed from: z */
    public boolean m36647z() {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    /* renamed from: a */
    public void m36667a(int i) {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            downloadController.setLinkMode(i);
        }
    }

    /* renamed from: ok */
    public void m36657ok(int i) {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            downloadController.setDownloadMode(i);
        }
    }

    /* renamed from: a */
    public void m36666a(boolean z) {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z);
        }
    }

    /* renamed from: ok */
    public void m36654ok(boolean z) {
        DownloadController downloadController = this.f22425ok;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z);
        }
    }
}
