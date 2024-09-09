package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadEventConfig;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private DownloadEventConfig f31396c;

    public w(DownloadEventConfig downloadEventConfig) {
        this.f31396c = downloadEventConfig;
    }

    public boolean a() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public boolean bk() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public String c() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 223515) {
            if (valueSet != null) {
                c(((Integer) valueSet.objectValue(223516, Integer.class)).intValue());
                return null;
            }
            return null;
        } else if (i4 == 223517 && valueSet != null) {
            c((String) valueSet.objectValue(223518, String.class));
            return null;
        } else {
            return null;
        }
    }

    public String ev() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String f() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String gd() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public int k() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public Object p() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public String r() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public String sr() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public JSONObject t() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public String ux() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().i(223500, c()).i(223501, w()).i(223502, xv()).i(223503, sr()).i(223504, ux()).i(223505, f()).i(223506, r()).i(223507, ev()).i(223508, gd()).h(223509, p()).e(223510, k()).j(223511, a()).j(223512, bk()).h(223513, t()).h(223514, ys()).l();
    }

    public String w() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String xv() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    public JSONObject ys() {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    public void c(int i4) {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i4);
        }
    }

    public void c(String str) {
        DownloadEventConfig downloadEventConfig = this.f31396c;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
