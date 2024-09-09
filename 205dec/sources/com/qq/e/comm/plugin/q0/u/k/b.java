package com.qq.e.comm.plugin.q0.u.k;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j1;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private final String f45626d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f45627e;

    /* renamed from: f  reason: collision with root package name */
    private final InterfaceC0881b f45628f;

    /* renamed from: h  reason: collision with root package name */
    private final int f45630h;

    /* renamed from: c  reason: collision with root package name */
    private int f45625c = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45631i = false;

    /* renamed from: g  reason: collision with root package name */
    private final ConnectivityManager f45629g = (ConnectivityManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("connectivity");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exchanger f45632a;

        a(Exchanger exchanger) {
            this.f45632a = exchanger;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            d1.a("onAvailable: \u5f00\u59cb\u4f7f\u7528\u6570\u636e\u7f51\u7edc", new Object[0]);
            try {
                this.f45632a.exchange(network, b.this.f45630h, TimeUnit.MILLISECONDS);
            } catch (Exception e4) {
                d1.a(e4.getMessage(), e4);
            }
            super.onAvailable(network);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q0.u.k.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface InterfaceC0881b {
        void a(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, InterfaceC0881b interfaceC0881b) {
        this.f45626d = str;
        this.f45628f = interfaceC0881b;
        a();
        this.f45630h = com.qq.e.comm.plugin.d0.a.d().f().a("cnrt", 5000);
    }

    private boolean b() {
        Object a4 = j1.a((Object) this.f45629g, j1.a(ConnectivityManager.class, "getMobileDataEnabled", true, new Class[0]), true, new Object[0]);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return true;
    }

    private boolean c() {
        int i4 = this.f45630h / 25;
        for (int i5 = 0; i5 < 25; i5++) {
            NetworkInfo networkInfo = this.f45629g.getNetworkInfo(5);
            if (networkInfo == null) {
                break;
            } else if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            } else {
                SystemClock.sleep(i4);
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject b4 = b(this.f45626d);
        InterfaceC0881b interfaceC0881b = this.f45628f;
        if (interfaceC0881b != null) {
            interfaceC0881b.a(b4);
        }
    }

    private void a() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("cnrhw", "*");
        try {
            if (!TextUtils.isEmpty(b4)) {
                if ("*".equals(b4)) {
                    this.f45631i = true;
                } else {
                    String[] split = b4.split(",");
                    if (split != null) {
                        this.f45627e = Arrays.asList(split);
                    }
                }
            }
        } catch (Exception e4) {
            d1.a("\u767d\u540d\u5355\u89e3\u6790\u5931\u8d25", e4);
        }
        if (this.f45627e == null) {
            this.f45627e = new ArrayList();
        }
    }

    private JSONObject b(String str) {
        try {
            URL url = new URL(str);
            if (this.f45629g == null) {
                this.f45625c = 5;
                return a(a(url, true));
            }
            String host = url.getHost();
            if (!this.f45631i && !this.f45627e.contains(host)) {
                this.f45625c = 6;
                return a(a(url, true));
            } else if (!b()) {
                this.f45625c = 2;
                return a(a(url, true));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return a(url);
            } else {
                return b(url);
            }
        } catch (MalformedURLException unused) {
            this.f45625c = 1;
            return a("");
        }
    }

    private JSONObject a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            this.f45625c = 1;
        }
        switch (this.f45625c) {
            case 0:
                str2 = "\u5207\u6362\u7f51\u7edc\u901a\u9053\u6210\u529f";
                break;
            case 1:
                str2 = "\u7f51\u7edc\u9519\u8bef";
                break;
            case 2:
                str2 = "\u79fb\u52a8\u7f51\u7edc\u672a\u8fde\u63a5";
                break;
            case 3:
                str2 = "\u65e0\u5207\u6362\u7f51\u7edc\u901a\u9053\u6743\u9650";
                break;
            case 4:
                str2 = "\u5207\u6362\u7f51\u7edc\u901a\u9053\u8d85\u65f6";
                break;
            case 5:
                str2 = "\u5207\u6362\u7f51\u7edc\u901a\u9053\u5931\u8d25";
                break;
            case 6:
                str2 = "\u57df\u540d\u4e0d\u5728\u767d\u540d\u5355:" + this.f45626d;
                break;
            default:
                str2 = "";
                break;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("response", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("code", Integer.valueOf(this.f45625c));
            jSONObject2.putOpt("msg", str2);
            jSONObject.putOpt("extra", jSONObject2);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        d dVar = new d();
        if (!TextUtils.isEmpty(str2)) {
            dVar.a("msg", str2);
        }
        v.b(1130009, null, Integer.valueOf(this.f45625c), dVar);
        return jSONObject;
    }

    private HttpURLConnection b(URL url, Network network, boolean z3) throws IOException {
        if (z3) {
            return (HttpURLConnection) url.openConnection();
        }
        if (network != null) {
            return (HttpURLConnection) network.openConnection(url);
        }
        if (Build.VERSION.SDK_INT < 21) {
            this.f45625c = a(5, url.getHost()) ? this.f45625c : 5;
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    private JSONObject b(URL url) {
        String a4;
        if (!b(0, "enableHIPRI")) {
            this.f45625c = 5;
            a4 = a(url, true);
        } else if (!c()) {
            this.f45625c = 4;
            a4 = a(url, true);
        } else {
            a4 = a(url, false);
        }
        return a(a4);
    }

    private boolean b(int i4, String str) {
        Object a4 = j1.a((Object) this.f45629g, j1.a(ConnectivityManager.class, "startUsingNetworkFeature", true, Integer.TYPE, String.class), true, Integer.valueOf(i4), str);
        return (a4 instanceof Integer) && ((Integer) a4).intValue() != -1;
    }

    private JSONObject a(URL url) {
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        Exchanger exchanger = new Exchanger();
        a aVar = new a(exchanger);
        Network network = null;
        try {
            this.f45629g.requestNetwork(build, aVar);
            network = (Network) exchanger.exchange(null, this.f45630h, TimeUnit.MILLISECONDS);
        } catch (SecurityException unused) {
            this.f45625c = 3;
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
        }
        if (network == null && this.f45625c == 0) {
            this.f45625c = 4;
        }
        JSONObject a4 = a(a(url, network, false));
        this.f45629g.unregisterNetworkCallback(aVar);
        return a4;
    }

    private String a(URL url, boolean z3) {
        return a(url, (Network) null, z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.net.URL r5, android.net.Network r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.net.HttpURLConnection r5 = r4.b(r5, r6, r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r1 = "GET"
            r5.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r1 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r5.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            java.lang.String r1 = com.qq.e.comm.plugin.i0.k.b()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            java.lang.String r2 = com.qq.e.comm.plugin.i0.k.a()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r5.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            java.net.HttpURLConnection r5 = r4.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            if (r5 == 0) goto L6e
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L6e
            java.io.InputStream r6 = r5.getInputStream()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r7.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L38:
            int r1 = r6.read(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r2 = -1
            if (r1 == r2) goto L44
            r2 = 0
            r7.write(r0, r2, r1)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            goto L38
        L44:
            r7.flush()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r0 = r5.getContentEncoding()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            if (r1 == 0) goto L53
            java.lang.String r0 = "UTF-8"
        L53:
            java.lang.String r0 = r7.toString(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r4.a(r6)
            r4.a(r7)
            if (r5 == 0) goto L62
            r5.disconnect()
        L62:
            return r0
        L63:
            r0 = move-exception
            goto L9f
        L65:
            r0 = move-exception
            r3 = r0
            r0 = r7
            r7 = r3
            goto L86
        L6a:
            r7 = move-exception
            goto La2
        L6c:
            r7 = move-exception
            goto L86
        L6e:
            r4.a(r0)
            r4.a(r0)
            if (r5 == 0) goto L98
            goto L95
        L77:
            r7 = move-exception
            r6 = r0
            goto La2
        L7a:
            r6 = move-exception
            r7 = r6
            r6 = r0
            goto L86
        L7e:
            r7 = move-exception
            r5 = r0
            r6 = r5
            goto La2
        L82:
            r5 = move-exception
            r7 = r5
            r5 = r0
            r6 = r5
        L86:
            java.lang.String r1 = r7.getMessage()     // Catch: java.lang.Throwable -> L9b
            com.qq.e.comm.plugin.util.d1.a(r1, r7)     // Catch: java.lang.Throwable -> L9b
            r4.a(r6)
            r4.a(r0)
            if (r5 == 0) goto L98
        L95:
            r5.disconnect()
        L98:
            java.lang.String r5 = ""
            return r5
        L9b:
            r7 = move-exception
            r3 = r0
            r0 = r7
            r7 = r3
        L9f:
            r3 = r0
            r0 = r7
            r7 = r3
        La2:
            r4.a(r6)
            r4.a(r0)
            if (r5 == 0) goto Lad
            r5.disconnect()
        Lad:
            goto Laf
        Lae:
            throw r7
        Laf:
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q0.u.k.b.a(java.net.URL, android.net.Network, boolean):java.lang.String");
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private boolean a(int i4, String str) {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(str);
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return a(i4, inetAddress);
        }
        return false;
    }

    private boolean a(int i4, InetAddress inetAddress) {
        Object a4 = j1.a((Object) this.f45629g, j1.a(ConnectivityManager.class, "requestRouteToHostAddress", true, Integer.TYPE, InetAddress.class), true, Integer.valueOf(i4), inetAddress);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return false;
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection, Network network, boolean z3) throws IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        for (int i4 = 0; i4 < 5; i4++) {
            httpURLConnection.connect();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                    break;
                }
                String headerField = httpURLConnection.getHeaderField("location");
                httpURLConnection.disconnect();
                httpURLConnection = b(new URL(headerField), network, z3);
                httpURLConnection.setConnectTimeout(connectTimeout);
                httpURLConnection.setReadTimeout(readTimeout);
                if (requestProperties != null) {
                    for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && !value.isEmpty()) {
                            for (String str : value) {
                                httpURLConnection.addRequestProperty(key, str);
                            }
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e4) {
                throw new IOException(e4.getMessage());
            }
        }
        return httpURLConnection;
    }
}
