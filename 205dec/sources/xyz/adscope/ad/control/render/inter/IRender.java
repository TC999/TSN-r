package xyz.adscope.ad.control.render.inter;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IRender<T> {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum RENDER_ERROR_TYPE {
        RENDER_IMAGE_FAIL(1001, "render image fail"),
        RENDER_IMAGE_EXCEPTION(1002, "render image exception"),
        RENDER_FAIL_CONTEXT_NULL(1003, "context is null"),
        RENDER_FAIL_TOTAL_RENDER_OR_INTERACTION_NOT_COMPLETE(1004, "render list or interaction list not complete"),
        RENDER_FAIL_LOAD_AD_DATA(1005, "fail load ad data");
        
        public int code;
        public String msg;

        RENDER_ERROR_TYPE(int i4, String str) {
            this.code = i4;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    void destroy();

    void rendAd(Context context, ViewGroup viewGroup, BidModel bidModel, AdScopeCycleModel adScopeCycleModel, IRenderCallback iRenderCallback);

    void renderSuccess();

    void setAutoHeight(boolean z3);

    void setITrackEventStatus(ITrackEventStatus iTrackEventStatus);

    void setInteractionExecute(IInteractionExecute iInteractionExecute);

    void startRender(ViewGroup viewGroup, IRenderCallback iRenderCallback);
}
