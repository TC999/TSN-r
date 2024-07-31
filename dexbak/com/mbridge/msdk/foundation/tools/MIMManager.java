package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.mbridge.msdk.foundation.tools.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MIMManager {

    /* renamed from: d */
    private static volatile String f31098d;

    /* renamed from: a */
    private CopyOnWriteArrayList<CampaignEx> f31099a;

    /* renamed from: b */
    private volatile C11427b f31100b;

    /* renamed from: c */
    private final AtomicBoolean f31101c;

    /* renamed from: e */
    private volatile Boolean f31102e;

    /* renamed from: f */
    private CampaignEx f31103f;

    /* renamed from: g */
    private int f31104g;

    /* renamed from: h */
    private Context f31105h;

    /* compiled from: MIMManager.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.o$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11426a {

        /* renamed from: a */
        private static final MIMManager f31122a = new MIMManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MIMManager.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.o$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11427b extends BroadcastReceiver {
        private C11427b() {
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
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameBase64Tool.m21812b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L19
                goto Lb2
            L19:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameBase64Tool.m21812b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L27
                goto Lb2
            L27:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameBase64Tool.m21812b(r1)
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
                com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.MIMManager.C11426a.m21818a()     // Catch: java.lang.Exception -> La8
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = com.mbridge.msdk.foundation.tools.MIMManager.m21832a(r0, r10)     // Catch: java.lang.Exception -> La8
                if (r10 != 0) goto L5d
                return
            L5d:
                com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.MIMManager.C11426a.m21818a()     // Catch: java.lang.Exception -> La8
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
                java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils.m22309a()     // Catch: java.lang.Exception -> La8
                r0.execute(r10)     // Catch: java.lang.Exception -> La8
            L8a:
                com.mbridge.msdk.foundation.tools.o r3 = com.mbridge.msdk.foundation.tools.MIMManager.C11426a.m21818a()     // Catch: java.lang.Exception -> La8
                java.lang.String r5 = "dm_page_status"
                com.mbridge.msdk.foundation.tools.o r10 = com.mbridge.msdk.foundation.tools.MIMManager.C11426a.m21818a()     // Catch: java.lang.Exception -> La8
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r10.m21830b()     // Catch: java.lang.Exception -> La8
                java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils.m22309a()     // Catch: java.lang.Exception -> La8
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
                com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r10, r9)
            Lb2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.MIMManager.C11427b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* renamed from: g */
    public Boolean m21819g() {
        Cursor cursor;
        Context m22861j = MBSDKContext.m22865f().m22861j();
        Boolean bool = null;
        if (m22861j != null) {
            try {
                if (m22861j.getContentResolver() != null) {
                    try {
                        cursor = m22861j.getContentResolver().query(Uri.parse(SameBase64Tool.m21812b("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
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
                            } catch (Exception e) {
                                SameLogTool.m21738a("MIMManager", e.getMessage());
                            }
                            try {
                                f31098d = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e2) {
                                SameLogTool.m21738a("MIMManager", e2.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            SameLogTool.m21738a("MIMManager", e3.getMessage());
                        }
                    }
                }
            } catch (Exception e4) {
                SameLogTool.m21733d("MIMManager", e4.getMessage());
            }
        }
        return bool;
    }

    /* renamed from: f */
    public final String m21820f() {
        try {
            return f31098d == null ? "" : String.format("[%s]", f31098d);
        } catch (Exception unused) {
            return "";
        }
    }

    private MIMManager() {
        this.f31104g = 0;
        this.f31099a = new CopyOnWriteArrayList<>();
        this.f31101c = new AtomicBoolean(false);
    }

    /* renamed from: b */
    public final void m21829b(CampaignEx campaignEx) {
        try {
            if (this.f31102e == null || campaignEx == null || !this.f31102e.booleanValue()) {
                return;
            }
            this.f31103f = null;
            try {
                this.f31099a.remove(campaignEx);
            } catch (Exception e) {
                SameLogTool.m21738a("MIMManager", e.getMessage());
            }
        } catch (Exception e2) {
            SameLogTool.m21733d("MIMManager", e2.getMessage());
        }
    }

    /* renamed from: c */
    public final void m21826c() {
        this.f31104g++;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>, android.content.Context, com.mbridge.msdk.foundation.tools.o$b, com.mbridge.msdk.foundation.entity.CampaignEx] */
    /* renamed from: d */
    public final void m21824d() {
        int i = this.f31104g - 1;
        this.f31104g = i;
        if (i <= 0) {
            Context context = this.f31105h;
            if (this.f31100b == null || context == null) {
                return;
            }
            try {
                try {
                    context.unregisterReceiver(this.f31100b);
                } catch (Exception e) {
                    SameLogTool.m21738a("MIMManager", e.getMessage());
                }
            } finally {
                this.f31103f = null;
                this.f31099a.clear();
                this.f31099a = null;
                this.f31100b = null;
                this.f31105h = null;
            }
        }
    }

    /* renamed from: e */
    public final Boolean m21822e() {
        return this.f31102e;
    }

    /* renamed from: a */
    public static MIMManager m21838a() {
        return C11426a.f31122a;
    }

    /* renamed from: a */
    public final void m21836a(CampaignEx campaignEx) {
        try {
            if (this.f31102e == null || campaignEx == null || !this.f31102e.booleanValue()) {
                return;
            }
            this.f31103f = campaignEx;
            this.f31099a.add(campaignEx);
        } catch (Exception e) {
            SameLogTool.m21733d("MIMManager", e.getMessage());
        }
    }

    /* renamed from: b */
    final CampaignEx m21830b() {
        return this.f31103f;
    }

    /* renamed from: b */
    public CampaignEx m21827b(String str) {
        try {
            CampaignEx campaignEx = this.f31103f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f31103f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f31099a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.f31099a.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            SameLogTool.m21733d("MIMManager", e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public final boolean m21831a(String str) {
        this.f31102e = Boolean.TRUE;
        try {
            if (TextUtils.isEmpty(str) || this.f31102e == null) {
                return false;
            }
            if (this.f31102e.booleanValue()) {
                try {
                    String trim = str.trim();
                    if (trim.startsWith(SameBase64Tool.m21812b("YkQwD+z8H+N1WBK3H+xtLkeAyM=="))) {
                        String m21812b = SameBase64Tool.m21812b("H75TDkQsVbxPY7V=");
                        if (!trim.contains(m21812b + "=1")) {
                            if (!trim.contains(m21812b + "=2")) {
                                if (!trim.contains(m21812b + "=3")) {
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
        } catch (Exception e) {
            SameLogTool.m21733d("MIMManager", e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public final void m21837a(final Context context) {
        this.f31105h = context;
        ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.o.1
            {
                MIMManager.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (MIMManager.this.f31101c.compareAndSet(false, true)) {
                    try {
                        MIMManager mIMManager = MIMManager.this;
                        mIMManager.f31102e = mIMManager.m21819g();
                    } catch (Exception e) {
                        SameLogTool.m21738a("MIMManager", e.getMessage());
                    }
                    if (MIMManager.this.f31102e == null || !MIMManager.this.f31102e.booleanValue() || context == null) {
                        return;
                    }
                    try {
                        MIMManager.this.f31100b = new C11427b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(SameBase64Tool.m21812b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                        intentFilter.addAction(SameBase64Tool.m21812b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                        intentFilter.addAction(SameBase64Tool.m21812b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                        context.registerReceiver(MIMManager.this.f31100b, intentFilter);
                    } catch (Exception e2) {
                        SameLogTool.m21738a("MIMManager", e2.getMessage());
                    }
                }
            }
        });
    }
}
