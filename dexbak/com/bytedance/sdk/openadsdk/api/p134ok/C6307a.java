package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6307a implements Bridge {

    /* renamed from: ok */
    private DownloadEventConfig f22423ok;

    public C6307a(DownloadEventConfig downloadEventConfig) {
        this.f22423ok = downloadEventConfig;
    }

    /* renamed from: a */
    public String m36757a() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    /* renamed from: bl */
    public String m36756bl() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223515) {
            if (valueSet != null) {
                m36749ok(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
                return null;
            }
            return null;
        } else if (i == 223517 && valueSet != null) {
            m36748ok((String) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
            return null;
        } else {
            return null;
        }
    }

    /* renamed from: h */
    public String m36755h() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    /* renamed from: j */
    public boolean m36754j() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    /* renamed from: k */
    public Object m36753k() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    /* renamed from: kf */
    public String m36752kf() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    /* renamed from: n */
    public String m36751n() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    /* renamed from: ok */
    public String m36750ok() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    /* renamed from: p */
    public String m36747p() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    /* renamed from: q */
    public String m36746q() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    /* renamed from: r */
    public int m36745r() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    /* renamed from: rh */
    public JSONObject m36744rh() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    /* renamed from: s */
    public String m36743s() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    /* renamed from: t */
    public JSONObject m36742t() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, m36750ok()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, m36757a()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, m36756bl()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, m36743s()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, m36751n()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, m36752kf()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, m36755h()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, m36747p()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, m36746q()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, m36753k()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, m36745r()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, m36754j()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, m36741z()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, m36744rh()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, m36742t()).m37926a();
    }

    /* renamed from: z */
    public boolean m36741z() {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    /* renamed from: ok */
    public void m36749ok(int i) {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i);
        }
    }

    /* renamed from: ok */
    public void m36748ok(String str) {
        DownloadEventConfig downloadEventConfig = this.f22423ok;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
