package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.Collections;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface CookieJar {

    /* renamed from: a */
    public static final CookieJar f1342a = new C1071a();

    /* compiled from: CookieJar.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1071a implements CookieJar {
        C1071a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CookieJar
        /* renamed from: a */
        public List<Cookie> mo58379a(HttpUrl httpUrl) {
            return Collections.emptyList();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CookieJar
        /* renamed from: a */
        public void mo58378a(HttpUrl httpUrl, List<Cookie> list) {
        }
    }

    /* renamed from: a */
    List<Cookie> mo58379a(HttpUrl httpUrl);

    /* renamed from: a */
    void mo58378a(HttpUrl httpUrl, List<Cookie> list);
}
