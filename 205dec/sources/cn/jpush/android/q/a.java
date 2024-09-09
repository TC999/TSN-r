package cn.jpush.android.q;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.o.a;
import cn.jpush.android.p.b;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4302a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerC0071a f4303b;

    /* renamed from: c  reason: collision with root package name */
    private String f4304c;

    /* renamed from: d  reason: collision with root package name */
    private d f4305d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jpush.android.q.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class HandlerC0071a extends Handler {
        public HandlerC0071a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007d A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:9:0x0034, B:10:0x0038, B:12:0x003d, B:13:0x0045, B:15:0x004b, B:17:0x0055, B:19:0x0066, B:21:0x006d, B:22:0x0075, B:23:0x007d, B:24:0x0085, B:25:0x008d), top: B:30:0x0005 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                java.lang.String r0 = "InAppConnect"
                super.handleMessage(r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
                r1.<init>()     // Catch: java.lang.Throwable -> L95
                java.lang.String r2 = "send message to handle, what: "
                r1.append(r2)     // Catch: java.lang.Throwable -> L95
                int r2 = r5.what     // Catch: java.lang.Throwable -> L95
                r1.append(r2)     // Catch: java.lang.Throwable -> L95
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L95
                cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L95
                android.os.Bundle r1 = r5.getData()     // Catch: java.lang.Throwable -> L95
                r2 = 0
                if (r1 == 0) goto L33
                java.lang.String r3 = "n_content"
                java.lang.String r1 = r1.getString(r3)     // Catch: java.lang.Throwable -> L95
                boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L95
                if (r3 != 0) goto L33
                cn.jpush.android.d.d r1 = cn.jpush.android.d.d.b(r1)     // Catch: java.lang.Throwable -> L95
                goto L34
            L33:
                r1 = r2
            L34:
                android.content.Context r3 = cn.jpush.android.local.JPushConstants.mApplicationContext     // Catch: java.lang.Throwable -> L95
                int r5 = r5.what     // Catch: java.lang.Throwable -> L95
                switch(r5) {
                    case 1001: goto L8d;
                    case 1002: goto L85;
                    case 1003: goto L7d;
                    case 1004: goto L75;
                    case 1005: goto L6d;
                    case 1006: goto L45;
                    case 1007: goto L3d;
                    default: goto L3b;
                }     // Catch: java.lang.Throwable -> L95
            L3b:
                goto Lae
            L3d:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.e(r3, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L45:
                boolean r5 = cn.jpush.android.ad.a.i(r3)     // Catch: java.lang.Throwable -> L95
                if (r5 == 0) goto L6a
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                boolean r5 = r5.c()     // Catch: java.lang.Throwable -> L95
                if (r5 != 0) goto L64
                java.lang.String r5 = "no message is showing,start to handle cache message"
                cn.jpush.android.helper.Logger.d(r0, r5)     // Catch: java.lang.Throwable -> L95
                cn.jpush.android.q.a r5 = cn.jpush.android.q.a.a()     // Catch: java.lang.Throwable -> L95
                java.lang.String r1 = "handle_cache_message"
                r5.a(r3, r2, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L64:
                java.lang.String r5 = "inapp message is showing,do nothing "
            L66:
                cn.jpush.android.helper.Logger.d(r0, r5)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L6a:
                java.lang.String r5 = " inapp message do not show in background,do nothing"
                goto L66
            L6d:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.g(r3, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L75:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.c(r3, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L7d:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.a(r3)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L85:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.b(r3, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L8d:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L95
                r5.a(r3, r1)     // Catch: java.lang.Throwable -> L95
                goto Lae
            L95:
                r5 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "handleMessage failed, "
                r1.append(r2)
                java.lang.String r5 = r5.getMessage()
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                cn.jpush.android.helper.Logger.w(r0, r5)
            Lae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.q.a.HandlerC0071a.handleMessage(android.os.Message):void");
        }
    }

    public static a a() {
        if (f4302a == null) {
            synchronized (a.class) {
                if (f4302a == null) {
                    f4302a = new a();
                }
            }
        }
        return f4302a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0037
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private synchronized android.os.Handler b() {
        /*
            r4 = this;
            monitor-enter(r4)
            cn.jpush.android.q.a$a r0 = r4.f4303b     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L37
            cn.jpush.android.q.a$a r0 = new cn.jpush.android.q.a$a     // Catch: java.lang.Throwable -> L11
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L11
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L11
            r4.f4303b = r0     // Catch: java.lang.Throwable -> L11
            goto L37
        L11:
            r0 = move-exception
            java.lang.String r1 = "InAppConnect"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r2.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "build handle failed, "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L3b
            r2.append(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L3b
            cn.jpush.android.helper.Logger.w(r1, r0)     // Catch: java.lang.Throwable -> L3b
            cn.jpush.android.q.a$a r0 = new cn.jpush.android.q.a$a     // Catch: java.lang.Throwable -> L37
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L37
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L37
            r4.f4303b = r0     // Catch: java.lang.Throwable -> L37
        L37:
            cn.jpush.android.q.a$a r0 = r4.f4303b     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r4)
            return r0
        L3b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.q.a.b():android.os.Handler");
    }

    public void a(int i4) {
        if (b().hasMessages(i4)) {
            Logger.d("InAppConnect", "removeHandler remove waht=" + i4);
            b().removeMessages(i4);
        }
    }

    public void a(Context context) {
        if (b.a().b() <= 0) {
            Logger.d("InAppConnect", "no notify inapp cache to deal");
            return;
        }
        Logger.d("InAppConnect", "checkCacheOnRemoteProcess target=" + this.f4304c);
        d b4 = b.a().b(this.f4304c);
        this.f4305d = b4;
        if (b4 == null) {
            Logger.d("InAppConnect", "no find  message match target");
            return;
        }
        Logger.d("InAppConnect", "start to deal cache notify inapp message");
        JCoreHelper.majorExecutor(context, "InAppConnect", new a.C0070a(context, this.f4305d));
    }

    public void a(Context context, Bundle bundle, String str) {
        if (context != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
        }
    }

    public void a(Context context, d dVar) {
        if (context == null || dVar == null) {
            return;
        }
        Logger.d("InAppConnect", "start to process notify message");
        cn.jpush.android.d.b.a(context, dVar);
    }

    public void a(Context context, d dVar, int i4) {
        b(context, dVar, i4);
    }

    public void a(Context context, d dVar, String str) {
        Logger.d("InAppConnect", "processOnRemoteProcess mCurrentTarget=" + this.f4304c);
        if (dVar == null) {
            Logger.d("InAppConnect", "parsing json failed");
            c.a(context, str, 2004L, 4);
            return;
        }
        if (40 != dVar.bs) {
            c.a(context, dVar.f4127d, 2005L, 4);
        }
        b.a().a(dVar);
        a().b(context, dVar, "check_can_show_message");
    }

    public void a(Context context, String str) {
        cn.jpush.android.o.a.a().b(context, str);
    }

    public void a(Context context, boolean z3) {
        if (z3) {
            cn.jpush.android.ad.c.d(context, this.f4305d.f4127d);
            b.a().b(this.f4305d);
        }
        b.a().c(this.f4305d.f4127d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        if (r12 != 1002) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r10, cn.jpush.android.d.d r11, int r12) {
        /*
            r9 = this;
            r0 = 1003(0x3eb, float:1.406E-42)
            java.lang.String r1 = "InAppConnect"
            r2 = 1002(0x3ea, float:1.404E-42)
            if (r12 == r0) goto La
            if (r12 != r2) goto Ld
        La:
            r9.a(r2)     // Catch: java.lang.Throwable -> L97
        Ld:
            int r0 = r11.bt     // Catch: java.lang.Throwable -> L97
            r3 = 1
            r4 = 0
            if (r3 != r0) goto L1f
            int r0 = r11.aQ     // Catch: java.lang.Throwable -> L97
            long r6 = (long) r0     // Catch: java.lang.Throwable -> L97
            if (r12 == r2) goto L1a
            goto L52
        L1a:
            long r4 = cn.jpush.android.r.b.a(r10, r6, r3)     // Catch: java.lang.Throwable -> L97
            goto L52
        L1f:
            r3 = 4
            r6 = 0
            if (r3 != r0) goto L3d
            cn.jpush.android.o.a r0 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L97
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L34
            long r7 = r11.bQ     // Catch: java.lang.Throwable -> L97
            long r7 = cn.jpush.android.r.b.b(r10, r7)     // Catch: java.lang.Throwable -> L97
            goto L35
        L34:
            r7 = r4
        L35:
            if (r12 == r2) goto L38
            goto L52
        L38:
            long r4 = cn.jpush.android.r.b.a(r10, r7, r6)     // Catch: java.lang.Throwable -> L97
            goto L52
        L3d:
            cn.jpush.android.o.a r0 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L97
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L4e
            long r7 = r11.bQ     // Catch: java.lang.Throwable -> L97
            long r7 = cn.jpush.android.r.b.b(r10, r7)     // Catch: java.lang.Throwable -> L97
            goto L50
        L4e:
            long r7 = r11.bP     // Catch: java.lang.Throwable -> L97
        L50:
            if (r12 == r2) goto L38
        L52:
            r10 = 1005(0x3ed, float:1.408E-42)
            if (r12 != r10) goto L58
            r4 = 1000(0x3e8, double:4.94E-321)
        L58:
            android.os.Bundle r10 = new android.os.Bundle     // Catch: java.lang.Throwable -> L97
            r10.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r0 = "n_content"
            java.lang.String r11 = r11.c()     // Catch: java.lang.Throwable -> L97
            r10.putString(r0, r11)     // Catch: java.lang.Throwable -> L97
            android.os.Message r11 = new android.os.Message     // Catch: java.lang.Throwable -> L97
            r11.<init>()     // Catch: java.lang.Throwable -> L97
            r11.what = r12     // Catch: java.lang.Throwable -> L97
            int r0 = (int) r4     // Catch: java.lang.Throwable -> L97
            r11.arg1 = r0     // Catch: java.lang.Throwable -> L97
            r11.setData(r10)     // Catch: java.lang.Throwable -> L97
            android.os.Handler r10 = r9.b()     // Catch: java.lang.Throwable -> L97
            r10.sendMessageDelayed(r11, r4)     // Catch: java.lang.Throwable -> L97
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r10.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r11 = "notify inapp send to handler succeed, delayTime: "
            r10.append(r11)     // Catch: java.lang.Throwable -> L97
            r10.append(r4)     // Catch: java.lang.Throwable -> L97
            java.lang.String r11 = ", what: "
            r10.append(r11)     // Catch: java.lang.Throwable -> L97
            r10.append(r12)     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L97
            cn.jpush.android.helper.Logger.dd(r1, r10)     // Catch: java.lang.Throwable -> L97
            goto Lb0
        L97:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "sendToMainHandler failed, "
            r11.append(r12)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            cn.jpush.android.helper.Logger.w(r1, r10)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.q.a.b(android.content.Context, cn.jpush.android.d.d, int):void");
    }

    public void b(Context context, d dVar, String str) {
        cn.jpush.android.x.b.a(context, str, dVar, (Intent) null);
    }

    public void b(Context context, String str) {
        Logger.d("InAppConnect", "onTargetChange localTarget=" + this.f4304c + " newTarget=" + str);
        this.f4304c = str;
        b.a().c();
    }
}
