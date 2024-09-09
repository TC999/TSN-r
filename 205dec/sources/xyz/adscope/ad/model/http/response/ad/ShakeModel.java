package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ShakeModel {
    @JsonNode(key = "axial")
    private ActionParamConfigModel axial;
    @JsonNode(key = "count")
    private ActionParamConfigModel count;
    @JsonNode(key = "endAmplitude")
    private ActionParamConfigModel endAmplitude;
    @JsonNode(key = "startAmplitude")
    private ActionParamConfigModel startAmplitude;

    public ActionParamConfigModel getAxial() {
        return this.axial;
    }

    public ActionParamConfigModel getCount() {
        return this.count;
    }

    public ActionParamConfigModel getEndAmplitude() {
        return this.endAmplitude;
    }

    public ActionParamConfigModel getStartAmplitude() {
        return this.startAmplitude;
    }

    public void setAxial(ActionParamConfigModel actionParamConfigModel) {
        this.axial = actionParamConfigModel;
    }

    public void setCount(ActionParamConfigModel actionParamConfigModel) {
        this.count = actionParamConfigModel;
    }

    public void setEndAmplitude(ActionParamConfigModel actionParamConfigModel) {
        this.endAmplitude = actionParamConfigModel;
    }

    public void setStartAmplitude(ActionParamConfigModel actionParamConfigModel) {
        this.startAmplitude = actionParamConfigModel;
    }
}
