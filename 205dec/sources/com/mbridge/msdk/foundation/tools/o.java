package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MIMManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o {

    /* renamed from: d */
    private static volatile String f39871d;

    /* renamed from: a */
    private CopyOnWriteArrayList<CampaignEx> f39872a;

    /* renamed from: b */
    private volatile b f39873b;

    /* renamed from: c */
    private final AtomicBoolean f39874c;

    /* renamed from: e */
    private volatile Boolean f39875e;

    /* renamed from: f */
    private CampaignEx f39876f;

    /* renamed from: g */
    private int f39877g;

    /* renamed from: h */
    private Context f39878h;

    /* compiled from: MIMManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {

        /* renamed from: a */
        private static final o f39895a = new o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MIMManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:86:0x0083 A[Catch: Exception -> 0x00a8, TryCatch #0 {Exception -> 0x00a8, blocks: (B:63:0x0033, B:66:0x003a, B:68:0x004b, B:71:0x0052, B:74:0x005d, B:86:0x0083, B:87:0x008a, B:81:0x006f, B:82:0x0075, B:83:0x007b), top: B:93:0x0033 }] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onReceive(final android.content.Context r9, android.content.Intent r10) {
            /*
                r8 = this;
                java.lang.String r0 = r10.getAction()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto Lb
                return
            Lb:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.s.b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L19
                goto Lb2
            L19:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.s.b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L27
                goto Lb2
            L27:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.s.b(r1)
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto Lb2
                android.os.Bundle r10 = r10.getExtras()     // Catch: java.lang.Exception -> La8
                if (r10 != 0) goto L3a
                return
            L3a:
                java.lang.String r0 = "statusCode"
                r1 = -1
                int r7 = r10.getInt(r0, r1)     // Catch: java.lang.Exception -> La8
                java.lang.String r0 = "packageName"
                java.lang.String r2 = ""
                java.lang.String r10 = r10.getString(r0, r2)     // Catch: java.lang.Exception -> La8
                if (r7 == r1) goto La7
                boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> La8
                if (r0 == 0) goto L52
                goto La7
            L52:
                com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.o.a.a()     // Catch: java.lang.Exception -> La8
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = com.mbridge.msdk.foundation.tools.o.a(r0, r10)     // Catch: java.lang.Exception -> La8
                if (r10 != 0) goto L5d
                return
            L5d:
                com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.o.a.a()     // Catch: java.lang.Exception -> La8
                r1 = 3001(0xbb9, float:4.205E-42)
                if (r7 == r1) goto L7b
                r1 = 3002(0xbba, float:4.207E-42)
                if (r7 == r1) goto L75
                r1 = 3008(0xbc0, float:4.215E-42)
                if (r7 == r1) goto L6f
                r10 = 0
                goto L81
            L6f:
                com.mbridge.msdk.foundation.tools.o$2 r1 = new com.mbridge.msdk.foundation.tools.o$2     // Catch: java.lang.Exception -> La8
                r1.<init>()     // Catch: java.lang.Exception -> La8
                goto L80
            L75:
                com.mbridge.msdk.foundation.tools.o$3 r1 = new com.mbridge.msdk.foundation.tools.o$3     // Catch: java.lang.Exception -> La8
                r1.<init>()     // Catch: java.lang.Exception -> La8
                goto L80
            L7b:
                com.mbridge.msdk.foundation.tools.o$4 r1 = new com.mbridge.msdk.foundation.tools.o$4     // Catch: java.lang.Exception -> La8
                r1.<init>()     // Catch: java.lang.Exception -> La8
            L80:
                r10 = r1
            L81:
                if (r10 == 0) goto L8a
                java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch: java.lang.Exception -> La8
                r0.execute(r10)     // Catch: java.lang.Exception -> La8
            L8a:
                com.mbridge.msdk.foundation.tools.o r3 = com.mbridge.msdk.foundation.tools.o.a.a()     // Catch: java.lang.Exception -> La8
                java.lang.String r5 = "dm_page_status"
                com.mbridge.msdk.foundation.tools.o r10 = com.mbridge.msdk.foundation.tools.o.a.a()     // Catch: java.lang.Exception -> La8
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r10.b()     // Catch: java.lang.Exception -> La8
                java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch: java.lang.Exception -> La8
                com.mbridge.msdk.foundation.tools.o$5 r0 = new com.mbridge.msdk.foundation.tools.o$5     // Catch: java.lang.Exception -> La8
                r2 = r0
                r4 = r9
                r2.<init>()     // Catch: java.lang.Exception -> La8
                r10.execute(r0)     // Catch: java.lang.Exception -> La8
                goto Lb2
            La7:
                return
            La8:
                r9 = move-exception
                java.lang.String r9 = r9.getMessage()
                java.lang.String r10 = "MIMManager"
                com.mbridge.msdk.foundation.tools.x.d(r10, r9)
            Lb2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public Boolean g() {
        Cursor cursor;
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        Boolean bool = null;
        if (j4 != null) {
            try {
                if (j4.getContentResolver() != null) {
                    try {
                        cursor = j4.getContentResolver().query(Uri.parse(s.b("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                                    bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e4) {
                                x.a("MIMManager", e4.getMessage());
                            }
                            try {
                                f39871d = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e5) {
                                x.a("MIMManager", e5.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e6) {
                            x.a("MIMManager", e6.getMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                x.d("MIMManager", e7.getMessage());
            }
        }
        return bool;
    }

    public final String f() {
        try {
            return f39871d == null ? "" : String.format("[%s]", f39871d);
        } catch (Exception unused) {
            return "";
        }
    }

    private o() {
        this.f39877g = 0;
        this.f39872a = new CopyOnWriteArrayList<>();
        this.f39874c = new AtomicBoolean(false);
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.f39875e == null || campaignEx == null || !this.f39875e.booleanValue()) {
                return;
            }
            this.f39876f = null;
            try {
                this.f39872a.remove(campaignEx);
            } catch (Exception e4) {
                x.a("MIMManager", e4.getMessage());
            }
        } catch (Exception e5) {
            x.d("MIMManager", e5.getMessage());
        }
    }

    public final void c() {
        this.f39877g++;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>, android.content.Context, com.mbridge.msdk.foundation.tools.o$b, com.mbridge.msdk.foundation.entity.CampaignEx] */
    public final void d() {
        int i4 = this.f39877g - 1;
        this.f39877g = i4;
        if (i4 <= 0) {
            Context context = this.f39878h;
            if (this.f39873b == null || context == null) {
                return;
            }
            try {
                try {
                    context.unregisterReceiver(this.f39873b);
                } catch (Exception e4) {
                    x.a("MIMManager", e4.getMessage());
                }
            } finally {
                this.f39876f = null;
                this.f39872a.clear();
                this.f39872a = null;
                this.f39873b = null;
                this.f39878h = null;
            }
        }
    }

    public final Boolean e() {
        return this.f39875e;
    }

    public static o a() {
        return a.f39895a;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.f39875e == null || campaignEx == null || !this.f39875e.booleanValue()) {
                return;
            }
            this.f39876f = campaignEx;
            this.f39872a.add(campaignEx);
        } catch (Exception e4) {
            x.d("MIMManager", e4.getMessage());
        }
    }

    final CampaignEx b() {
        return this.f39876f;
    }

    public CampaignEx b(String str) {
        try {
            CampaignEx campaignEx = this.f39876f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f39876f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f39872a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.f39872a.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e4) {
            x.d("MIMManager", e4.getMessage());
            return null;
        }
    }

    public final boolean a(String str) {
        this.f39875e = Boolean.TRUE;
        try {
            if (TextUtils.isEmpty(str) || this.f39875e == null) {
                return false;
            }
            if (this.f39875e.booleanValue()) {
                try {
                    String trim = str.trim();
                    if (trim.startsWith(s.b("YkQwD+z8H+N1WBK3H+xtLkeAyM=="))) {
                        String b4 = s.b("H75TDkQsVbxPY7V=");
                        if (!trim.contains(b4 + "=1")) {
                            if (!trim.contains(b4 + "=2")) {
                                if (!trim.contains(b4 + "=3")) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        } catch (Exception e4) {
            x.d("MIMManager", e4.getMessage());
            return false;
        }
    }

    public final void a(final Context context) {
        this.f39878h = context;
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.o.1
            {
                o.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (o.this.f39874c.compareAndSet(false, true)) {
                    try {
                        o oVar = o.this;
                        oVar.f39875e = oVar.g();
                    } catch (Exception e4) {
                        x.a("MIMManager", e4.getMessage());
                    }
                    if (o.this.f39875e == null || !o.this.f39875e.booleanValue() || context == null) {
                        return;
                    }
                    try {
                        o.this.f39873b = new b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(s.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                        intentFilter.addAction(s.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                        intentFilter.addAction(s.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                        context.registerReceiver(o.this.f39873b, intentFilter);
                    } catch (Exception e5) {
                        x.a("MIMManager", e5.getMessage());
                    }
                }
            }
        });
    }
}
