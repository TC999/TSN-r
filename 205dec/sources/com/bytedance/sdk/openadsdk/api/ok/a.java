package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadEventConfig;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {
    private DownloadEventConfig ok;

    public a(DownloadEventConfig downloadEventConfig) {
        this.ok = downloadEventConfig;
    }

    public String a() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String bl() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 223515) {
            if (valueSet != null) {
                ok(((Integer) valueSet.objectValue(223516, Integer.class)).intValue());
                return null;
            }
            return null;
        } else if (i4 == 223517 && valueSet != null) {
            ok((String) valueSet.objectValue(223518, String.class));
            return null;
        } else {
            return null;
        }
    }

    public String h() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public boolean j() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public Object k() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public String kf() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String n() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public String ok() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String p() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String q() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public int r() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public JSONObject rh() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public String s() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public JSONObject t() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().i(223500, ok()).i(223501, a()).i(223502, bl()).i(223503, s()).i(223504, n()).i(223505, kf()).i(223506, h()).i(223507, p()).i(223508, q()).h(223509, k()).f(223510, r()).j(223511, j()).j(223512, z()).h(223513, rh()).h(223514, t()).a();
    }

    public boolean z() {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public void ok(int i4) {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i4);
        }
    }

    public void ok(String str) {
        DownloadEventConfig downloadEventConfig = this.ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
