package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EulerAngleModel {
    @JsonNode(key = "subTitle")
    private ActionParamConfigModel subTitle;
    @JsonNode(key = "title")
    private ActionParamConfigModel title;
    @JsonNode(key = "xAxis")
    private EulerAngleAxisModel xAxis;
    @JsonNode(key = "yAxis")
    private EulerAngleAxisModel yAxis;
    @JsonNode(key = "zAxis")
    private EulerAngleAxisModel zAxis;

    public ActionParamConfigModel getSubTitle() {
        return this.subTitle;
    }

    public ActionParamConfigModel getTitle() {
        return this.title;
    }

    public EulerAngleAxisModel getxAxis() {
        return this.xAxis;
    }

    public EulerAngleAxisModel getyAxis() {
        return this.yAxis;
    }

    public EulerAngleAxisModel getzAxis() {
        return this.zAxis;
    }

    public void setSubTitle(ActionParamConfigModel actionParamConfigModel) {
        this.subTitle = actionParamConfigModel;
    }

    public void setTitle(ActionParamConfigModel actionParamConfigModel) {
        this.title = actionParamConfigModel;
    }

    public void setxAxis(EulerAngleAxisModel eulerAngleAxisModel) {
        this.xAxis = eulerAngleAxisModel;
    }

    public void setyAxis(EulerAngleAxisModel eulerAngleAxisModel) {
        this.yAxis = eulerAngleAxisModel;
    }

    public void setzAxis(EulerAngleAxisModel eulerAngleAxisModel) {
        this.zAxis = eulerAngleAxisModel;
    }
}
