package com.qq.e.comm.plugin.edgeanalytics.h.b;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.d;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o1;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected String f43019a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(int i4, String str);

        void a(String str, byte[] bArr);
    }

    public a() {
        a();
    }

    public void b() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("espju", "");
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        String e4 = b1.e(b4);
        if (TextUtils.isEmpty(e4)) {
            return;
        }
        File file = new File(b1.f(), e4);
        String d4 = b1.d(new File(b1.f(), e4));
        if (!TextUtils.isEmpty(d4)) {
            a(d4, false);
            return;
        }
        d.a().a(new com.qq.e.comm.plugin.i0.n.c(b4, f.a.GET, (byte[]) null), c.a.f44221d, new C0814a(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f43022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f43023b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicReference f43024c;

        b(a aVar, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, AtomicReference atomicReference) {
            this.f43022a = atomicBoolean;
            this.f43023b = countDownLatch;
            this.f43024c = atomicReference;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            this.f43022a.set(true);
            this.f43023b.countDown();
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            d1.a("GDTEAM_SM", dVar.b(), dVar);
            this.f43022a.set(false);
            this.f43024c.set(dVar);
            this.f43023b.countDown();
        }
    }

    protected void a() {
        try {
            this.f43019a = new String(Base64.decode("aHR0cHM6Ly9xenMuZ2R0aW1nLmNvbS91bmlvbi9yZXMvdW5pb25fY2RuL3BhZ2Uvb3RoZXIv", 0), com.qq.e.comm.plugin.k.a.f44515a);
        } catch (Exception e4) {
            d1.a("GDTEAM_SM", e4.getMessage(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z3) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("p");
            if (!TextUtils.isEmpty(optString)) {
                this.f43019a = optString;
            }
            if (z3 && (optJSONArray = jSONObject.optJSONArray("sl")) != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    a(optJSONArray.optString(i4), (h) null);
                }
            }
        } catch (JSONException e4) {
            d1.a("GDTEAM_SM", e4.getMessage(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.edgeanalytics.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0814a implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f43020a;

        C0814a(File file) {
            this.f43020a = file;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, g gVar) {
            if (gVar.getStatusCode() == 200) {
                try {
                    String b4 = gVar.b();
                    if (TextUtils.isEmpty(b4)) {
                        return;
                    }
                    a.this.a(b4, true);
                    b1.c(this.f43020a, b4);
                } catch (Exception e4) {
                    d1.a("GDTEAM_SM", e4.getMessage(), e4);
                }
            }
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, Exception exc) {
            d1.a("GDTEAM_SM", exc.getMessage(), exc);
        }
    }

    private String b(String str) {
        return str + "_bc_" + com.qq.e.comm.dynamic.c.a().b();
    }

    public void b(File file, c cVar) {
        String d4 = b1.d(file);
        String str = "";
        String str2 = TextUtils.isEmpty(d4) ? "File Content Empty" : "";
        try {
            str = a(d4);
        } catch (Exception e4) {
            str2 = e4.getMessage();
        }
        if (!TextUtils.isEmpty(str)) {
            cVar.a(str, (byte[]) null);
            return;
        }
        file.delete();
        cVar.a(6000, str2);
    }

    private void a(String str, h hVar) {
        if (!TextUtils.isEmpty(this.f43019a) && !TextUtils.isEmpty(str)) {
            com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().a(b1.f()).d(String.format("%s%s", this.f43019a, str)).d(false).b(false).a(str).a(), hVar);
        } else if (hVar != null) {
            hVar.a(new com.qq.e.comm.plugin.p.d(4, ""));
        }
    }

    public void a(String str, boolean z3, c cVar) {
        File f4 = b1.f();
        if (z3 && a(new File(f4, b(str)), cVar)) {
            return;
        }
        File file = new File(f4, str);
        if (file.exists()) {
            d1.a("GDTEAM_SM", "file exists, load from local");
            b(file, cVar);
            return;
        }
        d1.a("GDTEAM_SM", "file not exists");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference atomicReference = new AtomicReference();
        a(str, new b(this, atomicBoolean, countDownLatch, atomicReference));
        try {
            countDownLatch.await(2L, TimeUnit.MINUTES);
        } catch (InterruptedException e4) {
            d1.a("GDTEAM_SM", e4.getMessage(), e4);
        }
        if (atomicBoolean.get()) {
            b(file, cVar);
            return;
        }
        com.qq.e.comm.plugin.p.d dVar = (com.qq.e.comm.plugin.p.d) atomicReference.get();
        if (dVar != null) {
            cVar.a(dVar.a(), dVar.b());
        } else {
            cVar.a(6000, "Unknown Error");
        }
    }

    public boolean a(String str, byte[] bArr) {
        try {
            return b1.c(new File(b1.f(), b(str)), o1.c(bArr));
        } catch (Exception e4) {
            d1.a(e4.getMessage());
            return false;
        }
    }

    public boolean a(File file, c cVar) {
        try {
            byte[] d4 = o1.d(b1.e(file));
            if (d4 == null || d4.length <= 0) {
                return false;
            }
            cVar.a((String) null, d4);
            return true;
        } catch (Exception e4) {
            file.delete();
            d1.a(e4.getMessage());
            return false;
        }
    }

    protected String a(String str) throws Exception {
        return o1.b(str);
    }
}
