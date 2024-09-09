package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b VO;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0652a extends com.kwad.sdk.core.response.a.a {
        public String Jj;
        public String VR;
        public String VS;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void c(C0652a c0652a);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int VT;
        public long VU;
        public boolean VV;
        public int errorCode;
    }

    public a(b bVar) {
        this.VO = bVar;
    }

    private void b(final C0652a c0652a) {
        bn.postOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (a.this.VO != null) {
                    a.this.VO.c(c0652a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0652a c0652a = new C0652a();
            c0652a.parseJson(new JSONObject(str));
            b(c0652a);
        } catch (Throwable unused) {
        }
    }
}
