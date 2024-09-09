package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadController;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private DownloadController f31372c;

    public c(DownloadController downloadController) {
        this.f31372c = downloadController;
    }

    public boolean a() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public boolean bk() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    public int c() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 223317) {
            if (valueSet != null) {
                w(((Boolean) valueSet.objectValue(223323, Boolean.class)).booleanValue());
                return null;
            }
            return null;
        }
        switch (i4) {
            case 223311:
                if (valueSet != null) {
                    c(((Integer) valueSet.objectValue(223320, Integer.class)).intValue());
                    return null;
                }
                return null;
            case 223312:
                if (valueSet != null) {
                    w(((Integer) valueSet.objectValue(223321, Integer.class)).intValue());
                    return null;
                }
                return null;
            case 223313:
                if (valueSet != null) {
                    c(((Boolean) valueSet.objectValue(223322, Boolean.class)).booleanValue());
                    return null;
                }
                return null;
            default:
                return null;
        }
    }

    public boolean ev() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public int f() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean fp() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public int gd() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public Object k() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    public JSONObject p() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public Object r() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean sr() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public boolean t() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean ux() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().e(223300, c()).e(223301, w()).j(223302, xv()).j(223303, sr()).j(223304, ux()).e(223305, f()).h(223306, r()).j(223307, ev()).e(223308, gd()).h(223309, p()).h(2233010, k()).h(223309, p()).j(223314, a()).j(223315, bk()).j(223316, t()).j(223318, ys()).j(223319, fp()).l();
    }

    public int w() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean xv() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    public boolean ys() {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    public void c(int i4) {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            downloadController.setDownloadMode(i4);
        }
    }

    public void w(int i4) {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            downloadController.setLinkMode(i4);
        }
    }

    public void c(boolean z3) {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z3);
        }
    }

    public void w(boolean z3) {
        DownloadController downloadController = this.f31372c;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z3);
        }
    }
}
