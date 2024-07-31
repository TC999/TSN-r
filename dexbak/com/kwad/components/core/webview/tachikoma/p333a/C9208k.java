package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9208k extends AbstractC9230w {

    /* renamed from: ZK */
    InterfaceC9212b f29294ZK = new InterfaceC9212b() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1
        @Override // com.kwad.components.core.webview.tachikoma.p333a.C9208k.InterfaceC9212b
        /* renamed from: L */
        public final void mo29183L(final long j) {
            if (C9208k.this.f29295ns != null) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C9211a c9211a = new C9211a((byte) 0);
                        c9211a.creativeId = j;
                        C9208k.this.f29295ns.mo25251a(c9211a);
                    }
                });
            }
        }
    };

    /* renamed from: ns */
    private InterfaceC10627c f29295ns;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9211a implements InterfaceC9914b {
        public long creativeId;

        private C9211a() {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        /* synthetic */ C9211a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.k$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9212b {
        /* renamed from: L */
        void mo29183L(long j);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        C8615a.m30230b(this.f29294ZK);
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29295ns = interfaceC10627c;
        C8615a.m30232a(this.f29294ZK);
    }
}
