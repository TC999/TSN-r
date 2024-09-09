package xyz.adscope.ad.model.http.response.ad;

import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EulerAngleAxisModel {
    @JsonNode(key = "angle")
    private ActionParamConfigModel angle;
    @JsonNode(key = "animation")
    private int animation;
    @JsonNode(key = "direction")
    private ActionParamConfigModel direction;

    public ActionParamConfigModel getAngle() {
        return this.angle;
    }

    public int getAnimation() {
        return this.animation;
    }

    public ActionParamConfigModel getDirection() {
        return this.direction;
    }

    public void setAngle(ActionParamConfigModel actionParamConfigModel) {
        this.angle = actionParamConfigModel;
    }

    public void setAnimation(int i4) {
        this.animation = i4;
    }

    public void setDirection(ActionParamConfigModel actionParamConfigModel) {
        this.direction = actionParamConfigModel;
    }
}
