package com.qq.e.comm.plugin.f;

import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o1;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f43025c = "a";

    /* renamed from: a  reason: collision with root package name */
    private volatile JSONObject f43026a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f43027b = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    protected abstract String b();

    protected abstract int c();

    protected abstract String d();

    void a(b bVar) {
        if (this.f43027b.get()) {
            if (bVar != null) {
                bVar.a(this.f43026a);
                return;
            }
            return;
        }
        String d4 = d();
        if (TextUtils.isEmpty(d4)) {
            a(b(), bVar);
            return;
        }
        String e4 = b1.e(d4);
        if (TextUtils.isEmpty(e4)) {
            a(b(), bVar);
            return;
        }
        File file = new File(b1.c(), e4);
        String d5 = b1.d(file);
        if (!TextUtils.isEmpty(d5)) {
            a(d5, bVar);
            return;
        }
        com.qq.e.comm.plugin.i0.d.a().a(new com.qq.e.comm.plugin.i0.n.c(d4, f.a.GET, (byte[]) null), c.a.f44221d, new C0815a(bVar, file));
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.f.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0815a extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f43029b;

        C0815a(b bVar, File file) {
            this.f43028a = bVar;
            this.f43029b = file;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int statusCode = gVar.getStatusCode();
            if (statusCode == 200) {
                try {
                    String b4 = gVar.b();
                    if (!TextUtils.isEmpty(b4)) {
                        a.this.a(b4, this.f43028a);
                        synchronized (a.class) {
                            b1.c(this.f43029b, b4);
                        }
                        return;
                    }
                } catch (Exception e4) {
                    d1.a(e4.getMessage(), e4);
                }
            } else {
                v.a(9200019, null, Integer.valueOf(a.this.c()), Integer.valueOf(statusCode), null);
            }
            a aVar = a.this;
            aVar.a(aVar.b(), this.f43028a);
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            d1.a(a.f43025c, exc.getMessage(), exc);
            a aVar = a.this;
            aVar.a(aVar.b(), this.f43028a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, b bVar) {
        if (str != b() || this.f43026a == null) {
            try {
                String b4 = o1.b(str);
                if (!TextUtils.isEmpty(b4)) {
                    this.f43026a = new JSONObject(b4);
                    if (str != b()) {
                        this.f43027b.set(true);
                    }
                }
            } catch (Exception unused) {
            }
            if (this.f43026a == null) {
                this.f43026a = new JSONObject();
            }
        }
        if (bVar != null) {
            bVar.a(this.f43026a);
        }
    }
}
