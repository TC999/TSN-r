package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ServerBiddingModel.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f521a;

    /* renamed from: b  reason: collision with root package name */
    private f f522b;

    /* renamed from: c  reason: collision with root package name */
    private a f523c;

    /* compiled from: ServerBiddingModel.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f524a;

        /* renamed from: b  reason: collision with root package name */
        private List<h> f525b = new ArrayList();

        public void a(String str) {
            this.f524a = str;
        }

        public void a(List<h> list) {
            this.f525b = list;
        }
    }

    public String a() {
        return this.f521a;
    }

    public void a(a aVar) {
        this.f523c = aVar;
    }

    public void a(f fVar) {
        this.f522b = fVar;
    }

    public void a(String str) {
    }

    public List<h> b() {
        a aVar = this.f523c;
        if (aVar == null) {
            return null;
        }
        return aVar.f525b;
    }

    public void b(String str) {
        this.f521a = str;
    }

    public f c() {
        return this.f522b;
    }

    public void c(String str) {
    }

    public boolean d() {
        a aVar = this.f523c;
        return (aVar == null || TextUtils.isEmpty(aVar.f524a)) ? false : true;
    }
}
