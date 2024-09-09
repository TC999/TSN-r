package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final File f42304a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42305b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f42306c;

    /* renamed from: d  reason: collision with root package name */
    private File f42307d;

    /* renamed from: e  reason: collision with root package name */
    private String f42308e;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.dl.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0799a implements Runnable {
        RunnableC0799a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String d4 = b1.d(a.this.f42307d);
            if (a.this.f42308e.equals(s0.a(d4))) {
                if (a.this.f42306c) {
                    a aVar = a.this;
                    aVar.a(aVar.f42307d, d4);
                    return;
                }
                return;
            }
            a.this.f42307d.delete();
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.p.h {
        b() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            if (file == null) {
                return;
            }
            a.this.a(file, b1.d(file));
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            new com.qq.e.comm.plugin.n0.e(1190007).d(dVar.a());
            com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
            dVar2.a("ot", dVar.getMessage());
            dVar2.a("rs", a.this.f42305b);
        }
    }

    public a(File file, String str, boolean z3) {
        this.f42304a = file;
        this.f42305b = str;
        this.f42306c = z3;
    }

    abstract void a(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int length;
        String str = this.f42305b;
        if (str == null || (length = str.length()) < 40) {
            return;
        }
        this.f42308e = this.f42305b.substring(length - 32);
        File file = new File(this.f42304a, this.f42308e);
        this.f42307d = file;
        if (!file.exists()) {
            a();
        } else {
            com.qq.e.comm.plugin.util.d0.f46406b.submit(new RunnableC0799a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().d(this.f42305b).a(this.f42304a).a(this.f42308e).b(false).d(false).a(), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            file.delete();
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException unused) {
            file.delete();
        }
    }
}
