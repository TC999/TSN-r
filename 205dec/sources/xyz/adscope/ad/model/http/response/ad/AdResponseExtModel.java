package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdResponseExtModel {
    @JsonNode(key = "updateCfg")
    private boolean updateCfg;
    @JsonNode(key = AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY)
    private long updateTime;

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isUpdateCfg() {
        return this.updateCfg;
    }

    public void setUpdateCfg(boolean z3) {
        this.updateCfg = z3;
    }

    public void setUpdateTime(long j4) {
        this.updateTime = j4;
    }
}
