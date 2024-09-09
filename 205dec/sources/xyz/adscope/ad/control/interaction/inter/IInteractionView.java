package xyz.adscope.ad.control.interaction.inter;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.model.http.response.ad.NativeModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IInteractionView<T> extends IAdView<T> {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum INTERACTION_ACTION_CODE {
        INTERACTION_CODE_DEEPLINK(0),
        INTERACTION_CODE_DOWNLOAD(1);
        
        private int code;

        INTERACTION_ACTION_CODE(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum INTERACTION_ACTION_TYPE {
        INTERACTION_DEEPLINK("deeplink"),
        INTERACTION_LANDPAGE("landpage");
        
        private String value;

        INTERACTION_ACTION_TYPE(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum INTERACTION_VIEW_TYPE {
        INTERACTION_SHARK("shake"),
        INTERACTION_VIEW_CLICK("click"),
        INTERACTION_VIEW_REGIONAL("regional"),
        INTERACTION_VIEW_CAPSULE_CLOSE("capsuleclose"),
        INTERACTION_VIEW_GESTURE("slide"),
        INTERACTION_VIEW_TEXT("text"),
        INTERACTION_VIEW_TAG("tag"),
        INTERACTION_VIEW_IMAGE("image"),
        INTERACTION_VIEW_LOGO("logo"),
        INTERACTION_VIEW_MUTE(CampaignEx.JSON_NATIVE_VIDEO_MUTE),
        INTERACTION_VIEW_REPLAY("replay"),
        INTERACTION_VIEW_VIEW(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW),
        INTERACTION_VIEW_ROLL("roll"),
        INTERACTION_VIEW_APPINFO("appInfo"),
        INTERACTION_VIEW_COMPLAIN(InteractionCommon.COMPLAIN_TYPE_EXECUTION),
        INTERACTION_VIEW_EULERANGLE("eulerAngle");
        
        private String value;

        INTERACTION_VIEW_TYPE(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    void destroy();

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    View getSelfView();

    View getTotalAdView();

    void setInteractionExecute(IInteractionExecute iInteractionExecute);

    void setNativeModel(NativeModel nativeModel);

    void setRendView(RenderView renderView);
}
