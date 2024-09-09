package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.net.Uri;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: GetExecutor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public static final d f761g = new d.a().b().a();

    /* renamed from: e  reason: collision with root package name */
    private d f762e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f763f;

    static {
        new d.a().a();
    }

    public a(v vVar) {
        super(vVar);
        this.f762e = f761g;
        this.f763f = new HashMap();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        y.a aVar2 = new y.a();
        s.a aVar3 = new s.a();
        try {
            Uri parse = Uri.parse(this.f769d);
            aVar3.e(parse.getScheme());
            aVar3.c(parse.getHost());
            String encodedPath = parse.getEncodedPath();
            if (!TextUtils.isEmpty(encodedPath)) {
                if (encodedPath.startsWith(TTPathConst.sSeparator)) {
                    encodedPath = encodedPath.substring(1);
                }
                aVar3.a(encodedPath);
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    this.f763f.put(str, parse.getQueryParameter(str));
                }
            }
            for (Map.Entry<String, String> entry : this.f763f.entrySet()) {
                aVar3.a(entry.getKey(), entry.getValue());
            }
            a(aVar2);
            aVar2.a(this.f762e);
            aVar2.a((Object) a());
            this.f766a.a(aVar2.a(aVar3.a()).b().a()).a(new C0030a(aVar));
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void b(String str, String str2) {
        if (str == null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d.a("GetExecutor", "name cannot be null !!!");
        } else {
            this.f763f.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GetExecutor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class C0030a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a f764a;

        C0030a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.f764a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.f764a;
            if (aVar != null) {
                aVar.a(a.this, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.f764a != null) {
                HashMap hashMap = new HashMap();
                if (a0Var != null) {
                    r e4 = a0Var.e();
                    if (e4 != null) {
                        for (int i4 = 0; i4 < e4.b(); i4++) {
                            hashMap.put(e4.a(i4), e4.b(i4));
                        }
                    }
                    this.f764a.a(a.this, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.f(), a0Var.c(), a0Var.g(), hashMap, a0Var.a().d(), a0Var.l(), a0Var.j()));
                }
            }
        }
    }
}
