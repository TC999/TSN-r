package com.qq.e.comm.plugin.o0.f;

import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.n0.c;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.d;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45036a = "a";

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface b {
        void a(String str);

        void a(String str, int i4);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class C0864a extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f45037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f45038b;

        C0864a(b bVar, String str) {
            this.f45037a = bVar;
            this.f45038b = str;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            d1.a(a.f45036a, "onCompleted");
            this.f45037a.a(a.a(this.f45038b));
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(d dVar) {
            String str = a.f45036a;
            d1.a(str, "\u97f3\u9891\u4e0b\u8f7d\u5931\u8d25, code: " + dVar.a() + ", msg: " + dVar.b(), dVar);
            this.f45037a.a(this.f45038b, dVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            d1.b(f45036a, "\u97f3\u9891\u4e0b\u8f7d\u5931\u8d25\uff0cempty audio url");
            return;
        }
        com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().d(str).a(b1.d(str)).a(b1.p()).d(true).c("Audio").a(c.a(eVar)).a(), new C0864a(bVar, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        File c4 = b1.c(str);
        if (c4 != null) {
            return c4.getAbsolutePath();
        }
        return null;
    }
}
