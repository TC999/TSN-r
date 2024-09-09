package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i4, Handler handler) throws Exception {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i4 == 2) {
            if (strArr != null && strArr.length != 0) {
                this.mHttpDNSType = i4;
                this.mHostnames = strArr;
                this.mNetClient = aVMDLNetClient;
                if (aVMDLNetClient == null) {
                    this.mNetClient = new AVMDLHTTPNetwork();
                }
                this.mHttpDNSType = i4;
                this.mHandler = handler;
                return;
            }
            AVMDLLog.d(TAG, "host array is valid");
            throw new Exception("host array is valid");
        }
        AVMDLLog.d(TAG, "create fail type is not own");
        throw new Exception("type is not own");
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i4 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i4])) {
                    if (i5 == 0) {
                        sb.append(this.mHostnames[i4]);
                    } else {
                        sb.append("," + this.mHostnames[i4]);
                    }
                    i5++;
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLLog.d(TAG, String.format("****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType)));
        if (error != null) {
            AVMDLLog.d(TAG, String.format("handle response receive err:%s", error.errStr));
        } else if (jSONObject != null && jSONObject.length() != 0) {
            try {
                parseResult(jSONObject);
            } catch (Throwable th) {
                AVMDLLog.d(TAG, String.format("handle response exception:%s", th.toString()));
            }
            AVMDLLog.d(TAG, String.format("****parse end", new Object[0]));
        } else {
            AVMDLLog.d(TAG, String.format("json null err", new Object[0]));
        }
    }

    private void parseResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                AVMDLDNSInfo parserResultForSingleHost = parserResultForSingleHost(jSONArray.getJSONObject(i4));
                if (parserResultForSingleHost != null) {
                    IPCache.getInstance().put(parserResultForSingleHost.mHost, parserResultForSingleHost);
                }
            }
        } catch (Exception e4) {
            AVMDLLog.d(TAG, "parse json exception" + e4);
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) {
        String str;
        String str2;
        long j4;
        String str3;
        int i4 = this.mHttpDNSType;
        String str4 = "";
        if (i4 == 2 || i4 == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int optInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
                String optString = jSONObject.has("host") ? jSONObject.optString("host") : null;
                long currentTimeMillis = System.currentTimeMillis() + (optInt * 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        try {
                            str3 = optJSONArray.getString(i5);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            str3 = null;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            str4 = TextUtils.isEmpty(str4) ? str4 + str3 : str4 + "," + str3;
                        }
                    }
                    str = str4;
                    str2 = optString;
                    j4 = currentTimeMillis;
                }
            }
            return null;
        }
        str2 = null;
        str = "";
        j4 = 0;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, String.format("parse result host:%s ips:%s expiredT:%d", str2, str, Long.valueOf(j4)));
            return new AVMDLDNSInfo(this.mHttpDNSType, str2, str, j4, this.mId);
        }
        AVMDLLog.d(TAG, "parse result is null");
        return null;
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    public void start() {
        String _getURL = _getURL();
        AVMDLLog.d(TAG, "batch http dns  url:" + _getURL);
        Method[] declaredMethods = this.mNetClient.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Method method = declaredMethods[i4];
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z3 = true;
                break;
            }
            i4++;
        }
        if (z3) {
            this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.1
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.2
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        }
    }
}
