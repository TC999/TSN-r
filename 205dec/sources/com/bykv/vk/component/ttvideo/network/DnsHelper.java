package com.bykv.vk.component.ttvideo.network;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.network.IPCache;
import com.bykv.vk.component.ttvideo.network.NetworkManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class DnsHelper {
    private static final String TAG = "DnsHelper";
    private static final int UPDATE_PEROID = 300000;
    private static volatile long mServerIPTime;
    private volatile OnParseCompletionListener mCompletionListener;
    private Context mContext;
    private final ExecutorService mExecutor;
    private Future mFuture;
    private final INetworkClient mNetworkClient;
    public volatile String mServerIP;
    private volatile boolean mIsForceHttp = false;
    private String mHttpDNSServerHost = null;
    private volatile boolean mIsTTNetHttp = false;
    private int mExpiredTime = 600000;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface OnParseCompletionListener {
        void onParseComplete(String str, String str2, LiveError liveError, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class URLHostIndex {
        int authEnd;
        int hostEnd;
        int hostStart;

        URLHostIndex(int i4, int i5, int i6) {
            this.hostStart = i4;
            this.hostEnd = i5;
            this.authEnd = i6;
        }
    }

    public DnsHelper(Context context, ExecutorService executorService, INetworkClient iNetworkClient) {
        this.mContext = context;
        this.mExecutor = executorService;
        this.mNetworkClient = iNetworkClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHttpDns(final String str) {
        NetworkManager.doRequest(this.mNetworkClient, getURL(str), this.mHttpDNSServerHost, new NetworkManager.OnCompletionListener() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.2
            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onCompletion(JSONObject jSONObject) {
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String str2 = null;
                    try {
                        str2 = optJSONArray.getString(0);
                    } catch (Exception e4) {
                        Log.d(DnsHelper.TAG, e4.toString());
                    }
                    DnsHelper.this.notifyParseComplete(true, str, str2, null, true);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("host", str);
                DnsHelper.this.notifyParseComplete(true, str, null, new LiveError(LiveError.EMPTY, "http dns response ip empty", hashMap), true);
            }

            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onError(LiveError liveError) {
                DnsHelper.this.notifyParseComplete(true, str, null, liveError, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalDns(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null) {
                notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "", null), true);
                return;
            }
            String hostAddress = byName.getHostAddress();
            if (byName instanceof Inet6Address) {
                hostAddress = String.format("[%s]", hostAddress);
            }
            notifyParseComplete(false, str, hostAddress, null, true);
        } catch (UnknownHostException e4) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "Unknown host name");
            hashMap.put("host", str);
            hashMap.put("exception", e4.toString());
            notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "Unknown Host", hashMap), true);
        }
    }

    private String getURL(String str) {
        return String.format("https://%s/q?host=%s", this.mHttpDNSServerHost, str);
    }

    private static URLHostIndex getURLHostIndex(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("://") + 3;
        int length = str.length();
        int i4 = indexOf;
        int i5 = -1;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (charAt == '#' || charAt == '/') {
                break;
            }
            if (charAt == ':') {
                i5 = indexOf;
            } else if (charAt == '?') {
                break;
            } else if (charAt == '@') {
                i4 = indexOf + 1;
            }
            indexOf++;
        }
        if (i5 == -1) {
            i5 = indexOf;
        }
        return new URLHostIndex(i4, i5, indexOf);
    }

    public static String getUrlHost(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        URLHostIndex uRLHostIndex = getURLHostIndex(str);
        return str.substring(uRLHostIndex.hostStart, uRLHostIndex.hostEnd);
    }

    public static String hostToIPUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        URLHostIndex uRLHostIndex = getURLHostIndex(str);
        boolean startsWith = str.startsWith("http");
        String str3 = str.substring(0, uRLHostIndex.hostStart) + str2;
        int i4 = uRLHostIndex.hostEnd;
        if (uRLHostIndex.authEnd != -1) {
            str3 = str3 + str.substring(uRLHostIndex.hostEnd, uRLHostIndex.authEnd);
            i4 = uRLHostIndex.authEnd;
        }
        if (!startsWith) {
            str3 = str3 + TTPathConst.sSeparator + getUrlHost(str);
        }
        return str3 + str.substring(i4);
    }

    public static boolean isIP(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParseComplete(boolean z3, String str, String str2, LiveError liveError, boolean z4) {
        OnParseCompletionListener onParseCompletionListener;
        if (this.mIsForceHttp != z3 || (onParseCompletionListener = this.mCompletionListener) == null) {
            return;
        }
        if (z4 && str2 != null) {
            IPCache.IpInfo ipInfo = new IPCache.IpInfo();
            ipInfo.iptime = System.currentTimeMillis();
            ipInfo.ipaddr = str2;
            ipInfo.needUpdate = false;
            IPCache.getInstance().put(str, ipInfo);
        }
        onParseCompletionListener.onParseComplete(str, str2, liveError, z4);
    }

    public void cancel() {
        this.mCompletionListener = null;
        Future future = this.mFuture;
        if (future == null || future.isDone()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public void configure(boolean z3, String str) {
        this.mIsForceHttp = (!z3 || this.mNetworkClient == null || TextUtils.isEmpty(str) || str.equals("null")) ? false : true;
        this.mHttpDNSServerHost = str;
        Log.i(TAG, this.mIsForceHttp + this.mHttpDNSServerHost);
    }

    public String getDNSServerIP() {
        updateDNSServerIP();
        return this.mServerIP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r1 != r3) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseDns(final java.lang.String r9, com.bykv.vk.component.ttvideo.network.DnsHelper.OnParseCompletionListener r10) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto La1
            if (r10 != 0) goto La
            goto La1
        La:
            java.util.concurrent.ExecutorService r0 = r8.mExecutor
            if (r0 == 0) goto L99
            boolean r0 = r8.mIsForceHttp
            r8.cancel()
            r8.mCompletionListener = r10
            r10 = 0
            android.content.Context r1 = r8.mContext
            android.net.NetworkInfo r1 = com.bykv.vk.component.ttvideo.network.NetUtils.getNetworkInfo(r1)
            r2 = -1
            if (r1 == 0) goto L2a
            boolean r3 = r1.isAvailable()
            if (r3 == 0) goto L2a
            int r1 = r1.getType()
            goto L2b
        L2a:
            r1 = -1
        L2b:
            com.bykv.vk.component.ttvideo.network.IPCache r3 = com.bykv.vk.component.ttvideo.network.IPCache.getInstance()
            int r3 = r3.getCurNetType()
            r4 = 1
            if (r1 == r2) goto L39
            if (r1 == r3) goto L41
            goto L40
        L39:
            java.lang.String r10 = "DnsHelper"
            java.lang.String r2 = "start: NetWork may have some problems"
            android.util.Log.d(r10, r2)
        L40:
            r10 = 1
        L41:
            if (r10 == 0) goto L51
            com.bykv.vk.component.ttvideo.network.IPCache r10 = com.bykv.vk.component.ttvideo.network.IPCache.getInstance()
            r10.clear()
            com.bykv.vk.component.ttvideo.network.IPCache r10 = com.bykv.vk.component.ttvideo.network.IPCache.getInstance()
            r10.setCurNetType(r1)
        L51:
            com.bykv.vk.component.ttvideo.network.IPCache r10 = com.bykv.vk.component.ttvideo.network.IPCache.getInstance()
            com.bykv.vk.component.ttvideo.network.IPCache$IpInfo r10 = r10.get(r9)
            if (r10 == 0) goto L79
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r10.iptime
            long r1 = r1 - r3
            int r3 = r8.mExpiredTime
            long r3 = (long) r3
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L79
            boolean r1 = r10.needUpdate
            if (r1 != 0) goto L79
            boolean r3 = r8.mIsForceHttp
            java.lang.String r5 = r10.ipaddr
            r6 = 0
            r7 = 0
            r2 = r8
            r4 = r9
            r2.notifyParseComplete(r3, r4, r5, r6, r7)
            return
        L79:
            java.util.concurrent.ExecutorService r10 = r8.mExecutor
            boolean r10 = r10.isShutdown()
            if (r10 != 0) goto L8f
            java.util.concurrent.ExecutorService r10 = r8.mExecutor
            com.bykv.vk.component.ttvideo.network.DnsHelper$1 r1 = new com.bykv.vk.component.ttvideo.network.DnsHelper$1
            r1.<init>()
            java.util.concurrent.Future r9 = r10.submit(r1)
            r8.mFuture = r9
            goto L98
        L8f:
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r0.notifyParseComplete(r1, r2, r3, r4, r5)
        L98:
            return
        L99:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "mExecutor should not be null"
            r9.<init>(r10)
            throw r9
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.network.DnsHelper.parseDns(java.lang.String, com.bykv.vk.component.ttvideo.network.DnsHelper$OnParseCompletionListener):void");
    }

    public void updateDNSServerIP() {
        if (SystemClock.elapsedRealtime() - mServerIPTime >= 300000 && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                        if (byName != null) {
                            DnsHelper.this.mServerIP = byName.getHostAddress();
                            long unused = DnsHelper.mServerIPTime = SystemClock.elapsedRealtime();
                            MyLog.d(DnsHelper.TAG, "update dns server ip:" + DnsHelper.this.mServerIP);
                        }
                    } catch (UnknownHostException unused2) {
                    }
                }
            });
        }
    }
}
