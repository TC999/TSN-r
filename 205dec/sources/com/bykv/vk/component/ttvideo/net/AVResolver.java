package com.bykv.vk.component.ttvideo.net;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.AVThreadPool;
import com.bykv.vk.component.ttvideo.player.CalledByNative;
import com.bykv.vk.component.ttvideo.player.Keep;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "ttmj";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress inetAddress;
            Log.i(AVResolver.TAG, "start ParserHost task");
            String str = null;
            try {
                inetAddress = InetAddress.getByName(this.mHostName);
            } catch (Throwable th) {
                th = th;
                inetAddress = null;
            }
            try {
                str = inetAddress.getHostAddress();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                this.mResolver.mError = th.getMessage();
                this.mResolver.mRet = true;
                if (inetAddress != null) {
                    return;
                }
                return;
            }
            this.mResolver.mRet = true;
            if (inetAddress != null || str == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = str;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = str;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }
    }

    public static final boolean isIP(String str) {
        if (str.length() < 7 || str.length() > 15) {
            return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        String str2;
        synchronized (AVResolver.class) {
            long currentTimeMillis = System.currentTimeMillis();
            Hashtable<String, HostInfo> hashtable = mCacheHosts;
            String str3 = null;
            if (hashtable.size() > 128) {
                Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
                String str4 = null;
                while (it.hasNext()) {
                    HostInfo value = it.next().getValue();
                    str3 = it.next().getKey();
                    if (value != 0) {
                        long j4 = value.time;
                        if (j4 < currentTimeMillis) {
                            str4 = value;
                            currentTimeMillis = j4;
                        }
                    }
                }
                str2 = str3;
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 != null && str2 != null) {
                mCacheHosts.remove(str2);
            }
            mCacheHosts.put(str, hostInfo);
        }
    }

    @CalledByNative
    public void freeAddress() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @CalledByNative
    public String getAddress() {
        String[] strArr;
        if (this.mRet && (strArr = this.mIPStr) != null && strArr[0] != null) {
            return strArr[0];
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    @CalledByNative
    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (str != null && str.length() >= 1 && !"".equals(str)) {
            if (isIP(this.mHostName)) {
                this.mIPStr = r10;
                String[] strArr = {this.mHostName};
                this.mRet = true;
                return;
            }
            Hashtable<String, HostInfo> hashtable = mCacheHosts;
            HostInfo hostInfo = hashtable.get(str);
            this.mHostInfo = hostInfo;
            if (hostInfo != null) {
                if (hostInfo.ip != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    HostInfo hostInfo2 = this.mHostInfo;
                    if (currentTimeMillis - hostInfo2.time < HOST_MAX_CACHE_TIME) {
                        this.mIPStr = r10;
                        String[] strArr2 = {hostInfo2.ip};
                        this.mRet = true;
                        return;
                    }
                }
                hashtable.remove(str);
                this.mHostInfo = null;
            }
            try {
                AVThreadPool.addTask(new ParserHost(this, this.mHostName));
                return;
            } catch (Exception e4) {
                this.mRet = true;
                this.mError = e4.getMessage();
                return;
            }
        }
        this.mRet = true;
    }

    @CalledByNative
    public int isSuccess() {
        if (this.mRet) {
            String[] strArr = this.mIPStr;
            return (strArr == null || strArr[0] == null) ? -1 : 1;
        }
        return 0;
    }
}
