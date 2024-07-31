package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9197e extends AbstractC9230w {

    /* renamed from: ZF */
    private final InterfaceC9199b f29289ZF;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9198a implements InterfaceC9914b {
        public int height;

        private C9198a() {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }

        /* synthetic */ C9198a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9199b {
        @MainThread
        /* renamed from: jc */
        int mo29189jc();
    }

    public C9197e(InterfaceC9199b interfaceC9199b) {
        this.f29289ZF = interfaceC9199b;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9198a c9198a = new C9198a((byte) 0);
        InterfaceC9199b interfaceC9199b = this.f29289ZF;
        if (interfaceC9199b != null) {
            c9198a.height = interfaceC9199b.mo29189jc();
            interfaceC10627c.mo25251a(c9198a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
