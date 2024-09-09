package xyz.adscope.ad.control.render.inter;

import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdView<T> {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AD_VIEW_TYPE {
        WEB_VIEW(1, "web"),
        IMAGE_VIEW(3, "image"),
        VIDEO_VIEW(4, "video"),
        TEXT_VIEW(5, "text"),
        TYPE_VIEW(6, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW),
        VOICE_VIEW(7, "voice"),
        APP_INFO_VIEW(8, "appInfo");
        
        private int code;
        private String value;

        AD_VIEW_TYPE(int i4, String str) {
            this.code = i4;
            this.value = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }
    }

    void destroy();

    View getSelfView();

    void loadAd(T t3, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel);

    void loadSuccess();

    void setAdListener(AdListener adListener);

    void setITrackEventStatus(ITrackEventStatus iTrackEventStatus);
}
