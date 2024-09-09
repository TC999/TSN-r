package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: PostExecutor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends b {

    /* renamed from: e  reason: collision with root package name */
    z f770e;

    public c(v vVar) {
        super(vVar);
        this.f770e = null;
    }

    public void a(String str, byte[] bArr) {
        this.f770e = z.a(u.a(str), bArr);
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b b() {
        y.a aVar = new y.a();
        if (TextUtils.isEmpty(this.f769d)) {
            d.a("PostExecutor", "execute: Url is Empty");
            return null;
        }
        try {
            aVar.b(this.f769d);
            if (this.f770e == null) {
                d.a("PostExecutor", "RequestBody is null, content type is not support!!");
                return null;
            }
            a(aVar);
            aVar.a((Object) a());
            try {
                a0 A = this.f766a.a(aVar.a(this.f770e).a()).A();
                if (A != null) {
                    HashMap hashMap = new HashMap();
                    r e4 = A.e();
                    if (e4 != null) {
                        for (int i4 = 0; i4 < e4.b(); i4++) {
                            hashMap.put(e4.a(i4), e4.b(i4));
                        }
                        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b(A.f(), A.c(), A.g(), hashMap, A.a().d(), A.l(), A.j());
                    }
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        } catch (IllegalArgumentException unused) {
            d.a("PostExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            return null;
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f770e = z.a(u.a("application/json; charset=utf-8"), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostExecutor.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a f771a;

        a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.f771a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.f771a;
            if (aVar != null) {
                aVar.a(c.this, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.f771a != null) {
                HashMap hashMap = new HashMap();
                if (a0Var != null) {
                    r e4 = a0Var.e();
                    if (e4 != null) {
                        for (int i4 = 0; i4 < e4.b(); i4++) {
                            hashMap.put(e4.a(i4), e4.b(i4));
                        }
                    }
                    this.f771a.a(c.this, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.f(), a0Var.c(), a0Var.g(), hashMap, a0Var.a().d(), a0Var.l(), a0Var.j()));
                }
            }
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        y.a aVar2 = new y.a();
        if (TextUtils.isEmpty(this.f769d)) {
            aVar.a(this, new IOException("Url is Empty"));
            return;
        }
        try {
            aVar2.b(this.f769d);
            if (this.f770e == null) {
                if (aVar != null) {
                    aVar.a(this, new IOException("RequestBody is null, content type is not support!!"));
                    return;
                }
                return;
            }
            a(aVar2);
            aVar2.a((Object) a());
            this.f766a.a(aVar2.a(this.f770e).a()).a(new a(aVar));
        } catch (IllegalArgumentException unused) {
            aVar.a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }
}
