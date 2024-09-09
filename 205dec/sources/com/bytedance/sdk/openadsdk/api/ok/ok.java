package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadController;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {
    private DownloadController ok;

    public ok(DownloadController downloadController) {
        this.ok = downloadController;
    }

    public int a() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean bl() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 223317) {
            if (valueSet != null) {
                a(((Boolean) valueSet.objectValue(223323, Boolean.class)).booleanValue());
                return null;
            }
            return null;
        }
        switch (i4) {
            case 223311:
                if (valueSet != null) {
                    ok(((Integer) valueSet.objectValue(223320, Integer.class)).intValue());
                    return null;
                }
                return null;
            case 223312:
                if (valueSet != null) {
                    a(((Integer) valueSet.objectValue(223321, Integer.class)).intValue());
                    return null;
                }
                return null;
            case 223313:
                if (valueSet != null) {
                    ok(((Boolean) valueSet.objectValue(223322, Boolean.class)).booleanValue());
                    return null;
                }
                return null;
            default:
                return null;
        }
    }

    public Object h() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean i() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public boolean j() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public JSONObject k() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public int kf() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean n() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public int ok() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public boolean p() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public int q() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public Object r() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    public boolean rh() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean s() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public boolean t() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().f(223300, ok()).f(223301, a()).j(223302, bl()).j(223303, s()).j(223304, n()).f(223305, kf()).h(223306, h()).j(223307, p()).f(223308, q()).h(223309, k()).h(2233010, r()).h(223309, k()).j(223314, j()).j(223315, z()).j(223316, rh()).j(223318, t()).j(223319, i()).a();
    }

    public boolean z() {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    public void a(int i4) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setLinkMode(i4);
        }
    }

    public void ok(int i4) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setDownloadMode(i4);
        }
    }

    public void a(boolean z3) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z3);
        }
    }

    public void ok(boolean z3) {
        DownloadController downloadController = this.ok;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z3);
        }
    }
}
