package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.aj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9067aj implements InterfaceC10625a {

    /* renamed from: NY */
    private final WebView f29145NY;

    /* renamed from: WA */
    private Handler f29146WA;
    @Nullable

    /* renamed from: WB */
    private InterfaceC10627c f29147WB;

    /* renamed from: Xo */
    private boolean f29148Xo;
    @Nullable

    /* renamed from: cS */
    private InterfaceC9071b f29149cS;

    /* renamed from: com.kwad.components.core.webview.jshandler.aj$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9070a implements InterfaceC9914b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "height", this.height);
            C11126t.putValue(jSONObject, "leftMargin", this.leftMargin);
            C11126t.putValue(jSONObject, "rightMargin", this.rightMargin);
            C11126t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.aj$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9071b {
        @MainThread
        /* renamed from: a */
        void mo28995a(@NonNull C9070a c9070a);
    }

    public C9067aj(C10605b c10605b, @Nullable InterfaceC9071b interfaceC9071b) {
        this(c10605b, interfaceC9071b, true);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29147WB = null;
        this.f29149cS = null;
        this.f29146WA.removeCallbacksAndMessages(null);
    }

    private C9067aj(C10605b c10605b, @Nullable InterfaceC9071b interfaceC9071b, boolean z) {
        this.f29148Xo = true;
        this.f29146WA = new Handler(Looper.getMainLooper());
        this.f29145NY = c10605b.f29620NY;
        this.f29149cS = interfaceC9071b;
        this.f29148Xo = true;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29147WB = interfaceC10627c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final C9070a c9070a = new C9070a();
            c9070a.parseJson(jSONObject);
            this.f29146WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.aj.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9067aj.this.f29145NY != null && C9067aj.this.f29148Xo) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) C9067aj.this.f29145NY.getLayoutParams();
                        marginLayoutParams.width = -1;
                        C9070a c9070a2 = c9070a;
                        marginLayoutParams.height = c9070a2.height;
                        marginLayoutParams.leftMargin = c9070a2.leftMargin;
                        marginLayoutParams.rightMargin = c9070a2.rightMargin;
                        marginLayoutParams.bottomMargin = c9070a2.bottomMargin;
                        C9067aj.this.f29145NY.setLayoutParams(marginLayoutParams);
                    }
                    if (C9067aj.this.f29149cS != null) {
                        C9067aj.this.f29149cS.mo28995a(c9070a);
                    }
                }
            });
            this.f29146WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.aj.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9067aj.this.f29147WB != null) {
                        C9067aj.this.f29147WB.mo25251a(null);
                    }
                }
            });
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            interfaceC10627c.onError(-1, e.getMessage());
        }
    }
}
