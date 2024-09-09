package xyz.adscope.ad.model.http.request.ad;

import java.util.List;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SpecExtModel {
    private List<String> localInteractionId;
    private List<String> localRenderId;

    public List<String> getLocalInteractionId() {
        return this.localInteractionId;
    }

    public List<String> getLocalRenderId() {
        return this.localRenderId;
    }

    public void setLocalInteractionId(List<String> list) {
        this.localInteractionId = list;
    }

    public void setLocalRenderId(List<String> list) {
        this.localRenderId = list;
    }

    public String toString() {
        return "{\"localRenderId\":" + StringUtil.ListToString(this.localRenderId) + ", \"localInteractionId\":" + StringUtil.ListToString(this.localInteractionId) + '}';
    }
}
