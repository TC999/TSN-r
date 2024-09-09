package com.qq.e.comm.plugin.q0.s;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.q0.u.j;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements g {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f45522d = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");

    /* renamed from: a  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.q0.h f45523a;

    /* renamed from: b  reason: collision with root package name */
    protected final e f45524b = new e();

    /* renamed from: c  reason: collision with root package name */
    protected final d f45525c = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q0.s.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0877a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.c f45526c;

        RunnableC0877a(com.qq.e.comm.plugin.q0.s.c cVar) {
            this.f45526c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f45523a.a(this.f45526c.a());
            } catch (Throwable unused) {
                d1.a("Exception while sending JSResponse");
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.e f45528c;

        b(com.qq.e.comm.plugin.q0.s.e eVar) {
            this.f45528c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f45523a.a(this.f45528c.a());
            } catch (Throwable th) {
                d1.a("Exception while sending JSResponse", th);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.b f45530c;

        c(com.qq.e.comm.plugin.q0.s.b bVar) {
            this.f45530c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f45523a.a(this.f45530c.a());
            } catch (Throwable unused) {
                d1.a("Exception while fire JSEvent");
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, com.qq.e.comm.plugin.q0.u.i> f45532a = new HashMap();

        public com.qq.e.comm.plugin.q0.u.i a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f45532a.get(str);
        }

        void a(String str, com.qq.e.comm.plugin.q0.u.i iVar) {
            if (TextUtils.isEmpty(str) || iVar == null) {
                return;
            }
            this.f45532a.put(str, iVar);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, j> f45533a = new HashMap();

        public j a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f45533a.get(str);
        }

        void a(String str, j jVar) {
            if (TextUtils.isEmpty(str) || jVar == null) {
                return;
            }
            this.f45533a.put(str, jVar);
        }
    }

    public a(com.qq.e.comm.plugin.q0.h hVar) {
        this.f45523a = hVar;
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public g a(com.qq.e.comm.plugin.q0.u.i iVar) {
        if (iVar != null) {
            this.f45525c.a(iVar.a(), iVar);
        }
        return this;
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public g a(String str, j jVar) {
        this.f45524b.a(str, jVar);
        return this;
    }

    public void a(String... strArr) {
        a(new com.qq.e.comm.plugin.q0.s.c("bridge.onReceived", strArr));
    }

    public void a(com.qq.e.comm.plugin.q0.s.c cVar) {
        if (cVar != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0877a(cVar));
        }
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public void a(com.qq.e.comm.plugin.q0.s.e eVar) {
        if (eVar != null) {
            new Handler(Looper.getMainLooper()).post(new b(eVar));
        }
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public void a(com.qq.e.comm.plugin.q0.s.b bVar) {
        if (bVar != null) {
            new Handler(Looper.getMainLooper()).post(new c(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.q0.s.d a(Uri uri) {
        if (uri != null) {
            Matcher matcher = f45522d.matcher(uri.getPath());
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                String group3 = matcher.group(3);
                String queryParameter = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_Q);
                String queryParameter2 = uri.getQueryParameter("t1");
                long currentTimeMillis = System.currentTimeMillis();
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        currentTimeMillis = Long.parseLong(queryParameter2);
                    } catch (NumberFormatException unused) {
                    }
                }
                if ("multiAction".equals(group)) {
                    return new com.qq.e.comm.plugin.q0.s.d(group2, group, group3, null, queryParameter, currentTimeMillis);
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        jSONObject = new JSONObject(queryParameter);
                    }
                    return new com.qq.e.comm.plugin.q0.s.d(group2, group, group3, jSONObject, currentTimeMillis);
                } catch (JSONException e4) {
                    d1.a("Exception while json-parse JS Request Paramert Q", e4);
                    return null;
                }
            }
            return null;
        }
        return null;
    }
}
