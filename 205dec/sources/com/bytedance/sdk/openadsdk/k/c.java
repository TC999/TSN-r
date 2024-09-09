package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ux;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.component.w.c.f;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.p;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.w f35917c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    protected JSONObject f35918f;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private String f35919p;

    /* renamed from: r  reason: collision with root package name */
    protected String f35920r;

    /* renamed from: t  reason: collision with root package name */
    private long f35921t;
    public static final AtomicInteger sr = new AtomicInteger(0);

    /* renamed from: k  reason: collision with root package name */
    private static final ConcurrentLinkedDeque<String> f35915k = new ConcurrentLinkedDeque<>();

    /* renamed from: w  reason: collision with root package name */
    protected AtomicBoolean f35922w = new AtomicBoolean(false);
    protected AtomicBoolean xv = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, HashMap<String, byte[]>> f35916a = new HashMap<>();
    final ExecutorService ux = ev.c();
    private final String bk = "index_censorship.json";
    private AtomicInteger ys = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.k.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0529c {
        void c(boolean z3, Map<String, Object> map);
    }

    public c(com.bytedance.sdk.openadsdk.k.w wVar, String str, String str2, String str3, String str4) {
        this.f35920r = "";
        this.f35917c = wVar;
        this.ev = str;
        this.f35920r = str4;
        this.gd = str2;
        JSONObject jSONObject = new JSONObject();
        this.f35918f = jSONObject;
        try {
            jSONObject.putOpt("log_extra", str3);
            this.f35918f.putOpt(BidResponsedEx.KEY_CID, str);
            this.f35918f.putOpt("ac", Integer.valueOf(ys.xv(ls.getContext())));
            this.f35918f.putOpt("resource_type", "union");
            this.f35918f.putOpt("app_name", k.sr().gd());
            this.f35918f.putOpt("app_id", k.sr().ev());
            this.f35918f.putOpt("app_version", com.bytedance.sdk.openadsdk.core.r.c.sr());
            this.f35918f.putOpt("sdk_version", eq.xv);
            this.f35918f.putOpt("plugin_version", "6.1.0.6");
            this.f35918f.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            this.f35918f.putOpt("platform", "Android");
            this.f35918f.putOpt("device_id", i.xv());
            this.f35918f.putOpt("web_url", str4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        sr.incrementAndGet();
        c(str, str2);
    }

    private String c(int i4) {
        if (i4 != 100) {
            if (i4 != 101) {
                switch (i4) {
                    case 200:
                        return "OK";
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    default:
                        switch (i4) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case 408:
                                return "Request Time-out";
                            case 409:
                                return "Conflict";
                            case 410:
                                return "Gone";
                            case 411:
                                return "Length Required";
                            case 412:
                                return "Precondition Failed";
                            case 413:
                                return "Request Entity Too Large";
                            case 414:
                                return "Request-URI Too Large";
                            case 415:
                                return "Unsupported Media Type";
                            case 416:
                                return "Requested range not satisfiable";
                            case 417:
                                return "Expectation Failed";
                            default:
                                switch (i4) {
                                    case 500:
                                        return "Internal Server Error";
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Time-out";
                                    case 505:
                                        return "HTTP Version not supported";
                                    default:
                                        return "";
                                }
                        }
                }
            }
            return "Switching Protocols";
        }
        return "Continue";
    }

    public static void c(Context context) {
        try {
            File file = new File(w(context));
            if (System.currentTimeMillis() - file.lastModified() <= 3000 || !file.exists()) {
                return;
            }
            a.w("weblp", "cache exist");
            com.bytedance.sdk.openadsdk.k.c.c.w(w(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void xv(Context context, String str, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, p pVar, Map<String, Object> map) {
        try {
            if (xv.c()) {
                String xv = xv(context);
                String uri = webResourceRequest.getUrl().toString();
                String w3 = pVar.w();
                if (TextUtils.equals(w3.toLowerCase(), "javascript")) {
                    w3 = "js";
                }
                File file = new File(xv);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = ux.w(uri) + "." + w3;
                File file2 = new File(xv, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                a.w("weblp", "file:" + file2.getAbsolutePath() + "  " + ls.w().xk());
                if (com.bytedance.sdk.openadsdk.k.c.c.c(webResourceResponse.getData(), xv, str2, ls.w().xk())) {
                    try {
                        c(this.f35918f, str, pVar, str2, uri, webResourceRequest.getRequestHeaders(), map);
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        a.w("weblp", e.getMessage());
                    }
                }
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    abstract void c();

    abstract void c(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, p pVar, InterfaceC0529c interfaceC0529c);

    abstract void c(String str, String str2);

    abstract void c(String str, String str2, long j4, String str3, long j5, long j6);

    protected abstract void c(JSONObject jSONObject, String str, p pVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    abstract boolean c(p pVar);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0257 A[Catch: Exception -> 0x0249, LOOP:0: B:128:0x0257->B:130:0x025f, LOOP_START, TryCatch #6 {Exception -> 0x0249, blocks: (B:126:0x0253, B:128:0x0257, B:130:0x025f, B:131:0x0263, B:133:0x026b), top: B:138:0x0253 }] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v23, types: [int] */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sr() {
        /*
            Method dump skipped, instructions count: 639
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.c.sr():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ux() {
        a.w("weblp", "destroy");
        if (f35915k.contains(this.ev)) {
            c(null, w(ls.getContext()), ls.getContext(), -1L, -1L);
        } else if (this.f35922w.compareAndSet(false, true)) {
            c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.c.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.xv.set(true);
                        c.this.sr();
                        c.this.f35922w.set(false);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void w() {
        c();
    }

    public boolean xv() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class w extends Exception {

        /* renamed from: c  reason: collision with root package name */
        boolean f35935c;

        /* renamed from: w  reason: collision with root package name */
        boolean f35936w;
        long xv;

        public w(boolean z3) {
            this.f35935c = z3;
        }

        public w(boolean z3, boolean z4, long j4) {
            this.f35935c = z3;
            this.f35936w = z4;
            this.xv = j4;
        }

        public w(boolean z3, long j4) {
            this.f35935c = z3;
            this.xv = j4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0075 A[EDGE_INSN: B:48:0x0075->B:17:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00de -> B:45:0x00ed). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(android.content.Context r9, java.lang.String r10, android.webkit.WebResourceRequest r11, android.webkit.WebResourceResponse r12, com.bytedance.sdk.component.w.c.p r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            r8 = this;
            boolean r9 = com.bytedance.sdk.openadsdk.k.xv.c()
            if (r9 == 0) goto Led
            android.net.Uri r9 = r11.getUrl()
            java.lang.String r5 = r9.toString()
            java.lang.String r9 = r13.w()
            java.lang.String r0 = r9.toLowerCase()
            java.lang.String r1 = "javascript"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L20
            java.lang.String r9 = "js"
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.bytedance.sdk.component.utils.ux.w(r5)
            r0.append(r1)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto Led
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> r0 = r8.f35916a
            java.lang.Object r0 = r0.get(r9)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 != 0) goto L52
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> r1 = r8.f35916a
            r1.put(r9, r0)
        L52:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r1]
            java.io.InputStream r12 = r12.getData()
        L5f:
            int r3 = r12.read(r2)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r6 = -1
            r7 = 0
            if (r3 == r6) goto L75
        L67:
            if (r7 >= r1) goto L5f
            r3 = r2[r7]     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r9.add(r3)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            int r7 = r7 + 1
            goto L67
        L75:
            int r1 = r9.size()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
        L7b:
            int r2 = r9.size()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            if (r7 >= r2) goto L90
            java.lang.Object r2 = r9.get(r7)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.lang.Byte r2 = (java.lang.Byte) r2     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            byte r2 = r2.byteValue()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r1[r7] = r2     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            int r7 = r7 + 1
            goto L7b
        L90:
            com.bytedance.sdk.openadsdk.core.z.r r2 = com.bytedance.sdk.openadsdk.core.ls.w()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            int r2 = r2.xk()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.lang.String r3 = "weblp"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r6.<init>()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.lang.String r7 = "single:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r6.append(r2)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            com.bytedance.sdk.component.utils.a.w(r3, r6)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            long r2 = (long) r2     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r6 = 1048576(0x100000, double:5.180654E-318)
            long r2 = r2 * r6
            int r9 = r9.size()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            long r6 = (long) r9     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            int r9 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r9 > 0) goto Lcd
            r0.put(r4, r1)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            org.json.JSONObject r1 = r8.f35918f     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            java.util.Map r6 = r11.getRequestHeaders()     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
            r0 = r8
            r2 = r10
            r3 = r13
            r7 = r14
            r0.c(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Ld1 java.lang.Exception -> Ld3
        Lcd:
            r12.close()     // Catch: java.io.IOException -> Ldd
            goto Led
        Ld1:
            r9 = move-exception
            goto Le2
        Ld3:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> Ld1
            if (r12 == 0) goto Led
            r12.close()     // Catch: java.io.IOException -> Ldd
            goto Led
        Ldd:
            r9 = move-exception
            r9.printStackTrace()
            goto Led
        Le2:
            if (r12 == 0) goto Lec
            r12.close()     // Catch: java.io.IOException -> Le8
            goto Lec
        Le8:
            r10 = move-exception
            r10.printStackTrace()
        Lec:
            throw r9
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.c.w(android.content.Context, java.lang.String, android.webkit.WebResourceRequest, android.webkit.WebResourceResponse, com.bytedance.sdk.component.w.c.p, java.util.Map):void");
    }

    public WebResourceResponse c(WebView webView, final WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AtomicBoolean atomicBoolean;
        if (webView != null && !f35915k.contains(this.ev) && (((atomicBoolean = this.xv) == null || !atomicBoolean.get()) && this.ys.get() < 1)) {
            if (xv.c() && webResourceRequest != null) {
                if (TextUtils.equals(webResourceRequest.getMethod().toLowerCase(), f3.f5657f)) {
                    if (ls.w().wv() == 1) {
                        a.w("weblp", "went rp");
                        WebResourceResponse c4 = c(ls.getContext(), this.f35920r, webResourceRequest);
                        if (c4 != null) {
                            a.w("weblp", "rp response is not null");
                            c4.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                            return c4;
                        }
                    } else {
                        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.c.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.c(ls.getContext(), c.this.f35920r, webResourceRequest);
                            }
                        });
                    }
                } else {
                    a.w("weblp", "not get");
                }
            } else {
                a.w("weblp", "re == null");
            }
            return webResourceResponse;
        }
        a.w("weblp", "preResponse");
        return webResourceResponse;
    }

    private String xv(Context context) {
        String str = this.f35919p;
        if (str != null) {
            return str;
        }
        try {
            String str2 = w(context) + File.separator + this.ev;
            this.f35919p = str2;
            return str2;
        } catch (Exception e4) {
            e4.printStackTrace();
            StringBuilder sb = new StringBuilder();
            String str3 = File.separator;
            sb.append(str3);
            sb.append(".lp_cache");
            sb.append(str3);
            sb.append(this.ev);
            return sb.toString();
        }
    }

    public void c(final Runnable runnable) {
        this.ux.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.c.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this.ux) {
                    try {
                        runnable.run();
                    }
                }
            }
        });
    }

    protected WebResourceResponse c(final Context context, final String str, final WebResourceRequest webResourceRequest) {
        final Pair<WebResourceResponse, p> c4;
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> c5;
        if (!xv.c() || (c4 = c(webResourceRequest)) == null || (webResourceResponse = (WebResourceResponse) c4.first) == null || !c((p) c4.second) || (c5 = c(webResourceResponse)) == null) {
            return null;
        }
        a.w("weblp", "shouldStoreRequestRes()");
        c(webResourceRequest, (WebResourceResponse) c5.second, (p) c4.second, new InterfaceC0529c() { // from class: com.bytedance.sdk.openadsdk.k.c.3
            @Override // com.bytedance.sdk.openadsdk.k.c.InterfaceC0529c
            public void c(final boolean z3, final Map<String, Object> map) {
                c.this.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AtomicBoolean atomicBoolean;
                        try {
                            if (!z3 || (atomicBoolean = c.this.xv) == null || atomicBoolean.get()) {
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            c.this.c(context, str, webResourceRequest, (WebResourceResponse) c5.second, (p) c4.second, map);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        });
        return (WebResourceResponse) c5.first;
    }

    private boolean w(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.k.c.w.c(str, str2);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String w(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.w.w(context).getAbsolutePath() + File.separator + ".lp_cache";
    }

    protected void c(Context context, String str, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, p pVar, Map<String, Object> map) {
        if (c(pVar)) {
            a.w("weblp", "storage:" + ls.w().x());
            if (ls.w().x() == 1) {
                w(context, str, webResourceRequest, webResourceResponse, pVar, map);
            } else {
                xv(context, str, webResourceRequest, webResourceResponse, pVar, map);
            }
        }
    }

    private int w(byte[] bArr, int i4, File file) {
        if (i4 <= 0) {
            return -1;
        }
        return c(bArr, i4 - 1, file);
    }

    public void c(WebView webView, String str) {
        if (str == null || !str.startsWith("http")) {
            return;
        }
        this.ys.incrementAndGet();
    }

    private byte[] c(byte[] bArr, int i4) {
        return com.bytedance.sdk.openadsdk.n.w.c(bArr, i4);
    }

    private int c(byte[] bArr, int i4, File file) {
        try {
            t.c cVar = new t.c();
            fp c4 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux().c(cVar.c(ls.w().bw() + ("?aid=" + k.sr().ev() + "&device_platform=android&device_type=android&source_type=union")).c(com.bytedance.sdk.component.w.c.ys.c(p.c("multipart/form-data"), bArr, "file", file.getName())).w()).c();
            int xv = c4.xv();
            a.w("weblp", "res:" + xv);
            if (xv == 200) {
                JSONObject jSONObject = new JSONObject(c4.f().w());
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("msg");
                a.w("weblp", optInt + " " + optString);
                if (optInt == 0 && TextUtils.equals("success", optString)) {
                    return 200;
                }
                return w(bArr, i4, file);
            }
            a.w("weblp", "retry:" + i4);
            return w(bArr, i4, file);
        } catch (Throwable th) {
            th.printStackTrace();
            a.w("weblp", "message:" + th.getMessage());
            return w(bArr, i4, file);
        }
    }

    private void c(File file, String str, Context context, long j4, long j5) {
        try {
            com.bytedance.sdk.openadsdk.k.c.c.w(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("web_count:");
            AtomicInteger atomicInteger = sr;
            sb.append(atomicInteger.get());
            a.w("weblp", sb.toString());
            if (atomicInteger.get() > 0) {
                atomicInteger.decrementAndGet();
            }
            if (atomicInteger.get() == 0) {
                com.bytedance.sdk.openadsdk.k.c.c.w(w(context));
            }
            c(this.ev, this.gd, this.f35921t, this.f35920r, j4, j5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<android.webkit.WebResourceResponse, android.webkit.WebResourceResponse> c(android.webkit.WebResourceResponse r19) {
        /*
            r18 = this;
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.InputStream r0 = r19.getData()     // Catch: java.lang.Exception -> L29
            int r0 = com.bytedance.sdk.openadsdk.k.c.w.c(r0, r1)     // Catch: java.lang.Exception -> L29
            r3 = -1
            if (r0 == r3) goto L26
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L29
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L29
            r3.<init>(r0)     // Catch: java.lang.Exception -> L29
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L24
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Exception -> L24
            r0.<init>(r4)     // Catch: java.lang.Exception -> L24
            goto L38
        L24:
            r0 = move-exception
            goto L2b
        L26:
            r0 = r2
            r3 = r0
            goto L38
        L29:
            r0 = move-exception
            r3 = r2
        L2b:
            r0.printStackTrace()
            r1.close()     // Catch: java.lang.Throwable -> L32
            goto L37
        L32:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L37:
            r0 = r2
        L38:
            boolean r1 = com.bytedance.sdk.openadsdk.k.xv.c()
            if (r1 == 0) goto L8e
            android.webkit.WebResourceResponse r1 = new android.webkit.WebResourceResponse
            java.lang.String r5 = r19.getMimeType()
            java.lang.String r6 = r19.getEncoding()
            int r7 = r19.getStatusCode()
            java.lang.String r8 = r19.getReasonPhrase()
            java.util.Map r9 = r19.getResponseHeaders()
            r2 = 0
            if (r3 != 0) goto L5e
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r4 = new byte[r2]
            r3.<init>(r4)
        L5e:
            r10 = r3
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            android.webkit.WebResourceResponse r3 = new android.webkit.WebResourceResponse
            java.lang.String r12 = r19.getMimeType()
            java.lang.String r13 = r19.getEncoding()
            int r14 = r19.getStatusCode()
            java.lang.String r15 = r19.getReasonPhrase()
            java.util.Map r16 = r19.getResponseHeaders()
            if (r0 != 0) goto L82
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            byte[] r2 = new byte[r2]
            r0.<init>(r2)
        L82:
            r17 = r0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r1, r3)
            return r0
        L8e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.c.c(android.webkit.WebResourceResponse):android.util.Pair");
    }

    private Pair<WebResourceResponse, p> c(WebResourceRequest webResourceRequest) {
        if (xv.c() && webResourceRequest != null) {
            try {
                com.bytedance.sdk.component.w.c.a ux = com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux();
                t.c cVar = new t.c();
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                if (requestHeaders != null) {
                    for (String str : requestHeaders.keySet()) {
                        cVar.w(str, requestHeaders.get(str));
                    }
                }
                cVar.c(webResourceRequest.getUrl().toString());
                fp c4 = ux.c(cVar.w()).c();
                int xv = c4.xv();
                if (xv == 200) {
                    HashMap hashMap = new HashMap();
                    f r3 = c4.r();
                    if (r3 != null) {
                        for (int i4 = 0; i4 < r3.c(); i4++) {
                            hashMap.put(r3.c(i4), r3.w(i4));
                        }
                    }
                    InputStream xv2 = c4.f().xv();
                    p c5 = c(hashMap);
                    a.w("weblp", "mediaType:" + c5.c() + TTPathConst.sSeparator + c5.w());
                    String c6 = c(xv);
                    return new Pair<>(new WebResourceResponse(c5.c() + TTPathConst.sSeparator + c5.w(), c5.xv() == null ? null : c5.xv().toString(), xv, c6, hashMap, xv2), c5);
                }
                a.w("weblp", "net:" + xv);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.w.c.p c(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L2f
            java.lang.String r0 = "Content-Type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L11
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L11:
            java.lang.String r0 = "content-type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L20
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L20:
            java.lang.String r0 = "CONTENT-TYPE"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L2f
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L2f:
            r3 = 0
        L30:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L38
            java.lang.String r3 = "text/html; charset=UTF-8"
        L38:
            com.bytedance.sdk.component.w.c.p r3 = com.bytedance.sdk.component.w.c.p.c(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.c.c(java.util.Map):com.bytedance.sdk.component.w.c.p");
    }
}
