package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.log.a f24871a;

    /* renamed from: c  reason: collision with root package name */
    private c f24873c;

    /* renamed from: e  reason: collision with root package name */
    private String f24875e;

    /* renamed from: f  reason: collision with root package name */
    private String f24876f;

    /* renamed from: j  reason: collision with root package name */
    private Context f24880j;

    /* renamed from: g  reason: collision with root package name */
    private int f24877g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f24878h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f24879i = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f24881k = -2147483648L;

    /* renamed from: b  reason: collision with root package name */
    private f f24872b = new f();

    /* renamed from: d  reason: collision with root package name */
    private boolean f24874d = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private f f24882a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f24883b = new Handler(Looper.getMainLooper());

        /* renamed from: c  reason: collision with root package name */
        c f24884c;

        /* renamed from: com.bykv.vk.component.ttvideo.log.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        class RunnableC0332a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JSONObject f24885a;

            RunnableC0332a(a aVar, JSONObject jSONObject) {
                this.f24885a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.instance.a(false, this.f24885a);
            }
        }

        public a(f fVar, d dVar, c cVar) {
            this.f24882a = fVar;
            this.f24884c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AyncGetLogDataRunnable enter");
            f fVar = this.f24882a;
            if (fVar == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            JSONObject a4 = fVar.a(this.f24884c);
            Handler handler = this.f24883b;
            if (handler == null || handler.getLooper() == null) {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in child thread");
                e.instance.a(false, a4);
                return;
            }
            TTVideoEngineLog.i("VideoEventLoggerV2", "report in main looper");
            this.f24883b.post(new RunnableC0332a(this, a4));
        }
    }

    public d(Context context, com.bykv.vk.component.ttvideo.log.a aVar) {
        this.f24871a = aVar;
        this.f24873c = new c(aVar, context);
        this.f24880j = context;
    }

    private void b() {
        this.f24879i = 0;
        this.f24874d = true;
        this.f24878h = 0;
        this.f24881k = -2147483648L;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r5 = this;
            java.lang.String r0 = "VideoEventLoggerV2"
            java.lang.String r1 = "exception:"
            java.lang.String r2 = r5.f24875e
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto Lf
            java.lang.String r2 = r5.f24875e
            goto L19
        Lf:
            java.lang.String r2 = r5.f24876f
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L66
            java.lang.String r2 = r5.f24876f
        L19:
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r3)     // Catch: java.lang.IllegalArgumentException -> L20 java.io.UnsupportedEncodingException -> L2e
            goto L45
        L20:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = r3.toString()
            goto L3b
        L2e:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = r3.toString()
        L3b:
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog.e(r0, r1)
        L45:
            java.lang.String r0 = "&l="
            int r0 = r2.indexOf(r0)
            if (r0 <= 0) goto L66
            int r1 = r0 + 1
            java.lang.String r3 = "&"
            int r1 = r2.indexOf(r3, r1)
            int r0 = r0 + 3
            if (r1 <= 0) goto L5e
            java.lang.String r0 = r2.substring(r0, r1)
            goto L62
        L5e:
            java.lang.String r0 = r2.substring(r0)
        L62:
            com.bykv.vk.component.ttvideo.log.f r1 = r5.f24872b
            r1.f24904o = r0
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.c():void");
    }

    private void d() {
        if (this.f24872b == null) {
            return;
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "sendEvent pt_new:" + this.f24872b.f24891b + ", mEvent:" + this.f24872b + ", eventBase:" + this.f24873c);
        if (this.f24872b.f24891b > 0 || this.f24881k > 0) {
            int i4 = this.f24877g;
            if (i4 > 0) {
                this.f24873c.f24870h = i4;
            }
            SharedPreferences w3 = w.w(this.f24880j, "VideoEventLogger", 0);
            this.f24872b.f24905p = w3.getString("playersessionid", "");
            SharedPreferences.Editor edit = w3.edit();
            edit.putString("playersessionid", this.f24873c.f24868f);
            edit.apply();
            f fVar = this.f24872b;
            fVar.f24903n = this.f24873c.f24868f;
            fVar.f24897h = this.f24878h;
            String str = this.f24875e;
            if (str != null) {
                fVar.f24900k = str;
            }
            String str2 = this.f24876f;
            if (str2 != null) {
                fVar.f24901l = str2;
            }
            fVar.f24892c = fVar.f24891b;
            fVar.f24890a = this.f24881k;
            if (fVar.f24894e <= 0 && fVar.f24893d > 0) {
                fVar.f24894e = System.currentTimeMillis();
            }
            if (TextUtils.isEmpty(this.f24872b.f24904o)) {
                c();
            }
            EngineThreadPool.a().execute(new a(this.f24872b, this, this.f24873c));
            b();
        }
    }

    private void f(int i4) {
        d();
        this.f24872b = new f();
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a() {
        if (this.f24879i != 4) {
            this.f24879i = 2;
            this.f24874d = false;
            f fVar = this.f24872b;
            if (fVar.f24893d <= 0) {
                fVar.f24893d = System.currentTimeMillis();
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i4 != 5) {
            int i5 = this.f24879i;
            if (i5 != 3 ? i5 != 4 : false) {
                this.f24873c.a();
            }
        }
        if (this.f24874d) {
            f fVar = this.f24872b;
            if (fVar.f24893d <= 0) {
                fVar.f24895f = currentTimeMillis;
                f(i4);
            }
        }
        this.f24872b.f24894e = currentTimeMillis;
        f(i4);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(long j4, String str) {
        this.f24879i = 1;
        this.f24873c.a(str);
        if (this.f24881k <= 0) {
            this.f24881k = j4;
        }
        this.f24874d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bykv.vk.component.ttvideo.utils.Error r11, int r12) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r12 = r10.f24879i
            r2 = 0
            r3 = 4
            r4 = 1
            if (r12 != r3) goto Ld
            r5 = 0
            goto Le
        Ld:
            r5 = 1
        Le:
            r6 = 3
            if (r12 != r6) goto L12
            goto L13
        L12:
            r2 = r5
        L13:
            r12 = 5
            r10.f24879i = r12
            boolean r12 = r10.f24874d
            if (r12 == 0) goto L27
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f24872b
            long r5 = r12.f24893d
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L27
            r12.f24895f = r0
            goto L44
        L27:
            java.lang.String r12 = r11.f24913c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOwnPlayer"
            boolean r12 = r12.equals(r5)
            if (r12 != 0) goto L3b
            java.lang.String r12 = r11.f24913c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOSPlayer"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L40
        L3b:
            int r12 = r10.f24878h
            int r12 = r12 + r4
            r10.f24878h = r12
        L40:
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f24872b
            r12.f24894e = r0
        L44:
            if (r2 == 0) goto L4b
            com.bykv.vk.component.ttvideo.log.c r12 = r10.f24873c
            r12.a()
        L4b:
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f24872b
            int r0 = r11.getType()
            r12.f24898i = r0
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f24872b
            int r11 = r11.f24911a
            r12.f24899j = r11
            r10.f(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.a(com.bykv.vk.component.ttvideo.utils.Error, int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i4, int i5) {
        if (error.f24913c.equals(Error.VideoOwnPlayer) || error.f24913c.equals(Error.VideoOSPlayer)) {
            this.f24878h++;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str) {
        if (this.f24873c == null || str == null || str.isEmpty()) {
            return;
        }
        this.f24873c.b(str);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str, String str2) {
        this.f24875e = str;
        c cVar = this.f24873c;
        if (cVar != null) {
            cVar.f24869g = str;
        }
        this.f24876f = str2;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void b(int i4) {
        this.f24872b.f24902m = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r10) {
        /*
            r9 = this;
            int r0 = r9.f24879i
            if (r0 != 0) goto L5
            return
        L5:
            r0 = 1
            long r1 = java.lang.System.currentTimeMillis()
            int r3 = r9.f24879i
            r4 = 4
            r5 = 0
            if (r3 != r4) goto L11
            r0 = 0
        L11:
            r4 = 3
            if (r3 != r4) goto L15
            r0 = 0
        L15:
            r9.f24879i = r5
            boolean r3 = r9.f24874d
            if (r3 == 0) goto L34
            com.bykv.vk.component.ttvideo.log.f r3 = r9.f24872b
            long r4 = r3.f24891b
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L34
            long r4 = r3.f24893d
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L34
            long r4 = r3.f24895f
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L38
            r3.f24895f = r1
            goto L38
        L34:
            com.bykv.vk.component.ttvideo.log.f r3 = r9.f24872b
            r3.f24894e = r1
        L38:
            if (r0 == 0) goto L3f
            com.bykv.vk.component.ttvideo.log.c r0 = r9.f24873c
            r0.a()
        L3f:
            r9.f(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.c(int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void d(int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i4 != 10) {
            return;
        }
        f fVar = this.f24872b;
        if (fVar.f24891b <= 0) {
            fVar.f24891b = currentTimeMillis;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void e(int i4) {
        this.f24877g = i4;
        this.f24873c.f24870h = i4;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void reset() {
        this.f24874d = true;
        this.f24875e = null;
        this.f24876f = null;
        this.f24877g = 0;
        this.f24878h = 0;
        this.f24873c = new c(this.f24871a, this.f24880j);
    }
}
