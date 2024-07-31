package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WebCardVideoPositionHandler implements InterfaceC10625a {

    /* renamed from: Yj */
    private InterfaceC9030a f29068Yj;

    /* renamed from: Yi */
    private VideoPosition f29067Yi = new VideoPosition();

    /* renamed from: fS */
    private Handler f29069fS = new Handler(Looper.getMainLooper());

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class VideoPosition extends C10482a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        @KsJson
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class KSAdJSCornerModel extends C10482a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public final void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                KSAdJSCornerModel kSAdJSCornerModel = new KSAdJSCornerModel();
                this.cornerRadius = kSAdJSCornerModel;
                kSAdJSCornerModel.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9030a {
        /* renamed from: a */
        void mo29341a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(InterfaceC9030a interfaceC9030a) {
        this.f29068Yj = interfaceC9030a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29069fS.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            this.f29067Yi.parseJson(new JSONObject(str));
            if (this.f29068Yj != null) {
                this.f29069fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        WebCardVideoPositionHandler.this.f29068Yj.mo29341a(WebCardVideoPositionHandler.this.f29067Yi);
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        interfaceC10627c.mo25251a(null);
    }
}
