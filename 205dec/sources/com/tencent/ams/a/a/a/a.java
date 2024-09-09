package com.tencent.ams.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.tencent.ams.a.a.b.g;
import com.tencent.ams.a.a.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f50645c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static Context f50646d;

    /* renamed from: a  reason: collision with root package name */
    private boolean f50647a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f50648b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.tencent.ams.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC1028a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f50649c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f50650d;

        RunnableC1028a(a aVar, Context context, String str) {
            this.f50649c = context;
            this.f50650d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.c(this.f50649c, this.f50650d);
            } catch (Exception unused) {
            }
        }
    }

    private a() {
    }

    public static a a() {
        return f50645c;
    }

    public void b(Context context, String str) {
        if (this.f50647a || context == null) {
            return;
        }
        a(context, str);
    }

    public String a(String str) {
        String str2;
        String str3;
        com.tencent.ams.a.b.a.a("mma_origin_url: " + str);
        try {
        } catch (Throwable th) {
            com.tencent.ams.a.b.a.a("MMA", "getReportUrl error.", th);
            v.a(100182, (com.qq.e.comm.plugin.n0.c) null);
        }
        if (!TextUtils.isEmpty(str) && this.f50648b != null) {
            String b4 = com.tencent.ams.a.a.c.a.b(str);
            if (TextUtils.isEmpty(b4)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            g a4 = c.a();
            if (a4 != null && a4.f50677b != null && a4.f50677b.size() != 0) {
                HashMap hashMap = new HashMap(this.f50648b);
                long currentTimeMillis = System.currentTimeMillis();
                for (com.tencent.ams.a.a.b.b bVar : a4.f50677b) {
                    if (bVar.f50659b != null && !TextUtils.isEmpty(bVar.f50659b.f50669a) && b4.endsWith(bVar.f50659b.f50669a)) {
                        hashMap.putAll(com.tencent.ams.a.a.c.b.d(f50646d, bVar.f50658a, bVar.f50666i));
                        ArrayList arrayList = new ArrayList();
                        if (bVar.f50662e == null || bVar.f50662e.f50667a == null) {
                            str2 = "";
                            str3 = str2;
                        } else {
                            str2 = "";
                            str3 = str2;
                            for (com.tencent.ams.a.a.b.a aVar : bVar.f50662e.f50667a) {
                                if (aVar != null && aVar.f50657d) {
                                    str2 = bVar.f50663f;
                                    str3 = bVar.f50664g;
                                    arrayList.add(aVar.f50655b);
                                }
                            }
                        }
                        sb.append((String) com.tencent.ams.a.a.c.a.a(str, arrayList, str2, str3, "").get(Field.URL));
                        if (bVar.f50662e != null && bVar.f50662e.f50667a != null) {
                            for (com.tencent.ams.a.a.b.a aVar2 : bVar.f50662e.f50667a) {
                                if (aVar2 != null && aVar2.f50657d) {
                                    if ("TS".equals(aVar2.f50654a)) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(bVar.f50663f);
                                        sb2.append(aVar2.f50655b);
                                        sb2.append(bVar.f50664g != null ? bVar.f50664g : "");
                                        sb2.append(currentTimeMillis);
                                        sb.append(sb2.toString());
                                    } else if ("MUDS".equals(aVar2.f50654a)) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(bVar.f50663f);
                                        sb3.append(aVar2.f50655b);
                                        sb3.append(bVar.f50664g != null ? bVar.f50664g : "");
                                        sb3.append(com.tencent.ams.a.a.c.a.a("", aVar2, bVar));
                                        sb.append(sb3.toString());
                                    } else {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(bVar.f50663f);
                                        sb4.append(aVar2.f50655b);
                                        sb4.append(bVar.f50664g != null ? bVar.f50664g : "");
                                        sb4.append(com.tencent.ams.a.a.c.a.a((String) hashMap.get(aVar2.f50654a), aVar2, bVar));
                                        sb.append(sb4.toString());
                                    }
                                }
                            }
                        }
                        StringBuilder sb5 = new StringBuilder(com.tencent.ams.a.a.c.a.a(sb.toString(), new ArrayList(), str2, str3));
                        sb5.append("");
                        if (bVar.f50660c != null && bVar.f50660c.f50680b != null) {
                            String a5 = com.tencent.ams.a.a.c.a.a(f50646d, sb5.toString());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(bVar.f50663f);
                            sb6.append(bVar.f50660c.f50680b);
                            sb6.append(bVar.f50664g != null ? bVar.f50664g : "");
                            sb6.append(com.tencent.ams.a.a.c.a.a(a5));
                            sb5.append(sb6.toString());
                        }
                        com.tencent.ams.a.b.a.a("mma_request_url: " + sb5.toString());
                        return sb5.toString();
                    }
                }
                return null;
            }
        }
        return null;
    }

    private synchronized void a(Context context, String str) {
        if (this.f50647a) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            f50646d = applicationContext;
            if (this.f50648b == null) {
                this.f50648b = com.tencent.ams.a.a.c.b.a(applicationContext);
            }
            c.c(f50646d);
            this.f50647a = true;
            new Thread(new RunnableC1028a(this, context, str)).start();
        } catch (Exception unused) {
        }
    }
}
