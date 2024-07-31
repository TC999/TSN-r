package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.aw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9109aw extends AbstractC9230w {

    /* renamed from: com.kwad.components.core.webview.jshandler.aw$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9110a implements InterfaceC9914b {

        /* renamed from: XS */
        private String f29202XS;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "lifeStatus", this.f29202XS);
            return jSONObject;
        }
    }

    /* renamed from: aM */
    private void m29269aM(String str) {
        C9110a c9110a = new C9110a();
        c9110a.f29202XS = str;
        m29171b(c9110a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    /* renamed from: sr */
    public final void m29268sr() {
        m29269aM("showStart");
    }

    /* renamed from: ss */
    public final void m29267ss() {
        m29269aM("showEnd");
    }

    /* renamed from: st */
    public final void m29266st() {
        m29269aM("hideStart");
    }

    /* renamed from: su */
    public final void m29265su() {
        m29269aM("hideEnd");
    }

    /* renamed from: sv */
    public final void m29264sv() {
        m29269aM("pageVisiable");
    }

    /* renamed from: sw */
    public final void m29263sw() {
        m29269aM("pageInvisiable");
    }
}
