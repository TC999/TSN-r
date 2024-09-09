package xyz.adscope.ad.control.render.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public enum RenderTrackClickTypeEnum {
    RENDER_TRACK_CLICK_TYPE_CLICK(0),
    RENDER_TRACK_CLICK_TYPE_SLIDE(1),
    RENDER_TRACK_CLICK_TYPE_SHAKE(2),
    RENDER_TRACK_CLICK_TYPE_EULER_ANGLE(3);
    
    public int code;

    RenderTrackClickTypeEnum(int i4) {
        this.code = i4;
    }

    public int getCode() {
        return this.code;
    }
}
