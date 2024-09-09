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
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i4, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i4;
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i4 = this.mHttpDNSType;
        if (i4 == 2 || i4 == 1) {
            sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i4 == 3) {
            sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i5 = this.mHttpDNSType;
        if (i5 == 2 || i5 == 1) {
            sb.append("&source=vod");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        AVMDLLog.d(TAG, String.format("****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname));
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            String str = error.errStr;
            aVMDLDNSInfo2.mErrorStr = str;
            AVMDLLog.d(TAG, String.format("handle response receive err:%s", str));
        } else if (jSONObject != null && jSONObject.length() != 0) {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                AVMDLLog.d(TAG, String.format("handle response exception:%s", th.toString()));
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo == null) {
                AVMDLLog.d(TAG, String.format("info null err", new Object[0]));
            } else {
                AVMDLLog.d(TAG, String.format("****parse suc for host:%s iplist:%s", this.mHostname, aVMDLDNSInfo.mIpList));
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
        } else {
            int i4 = this.mHttpDNSType;
            new Error(i4, this.mHostname, this.mId, String.format("HTTP dns empty, type:%d", Integer.valueOf(i4)));
            AVMDLLog.d(TAG, String.format("json null err", new Object[0]));
        }
        AVMDLLog.d(TAG, String.format("****parse failed for host:%s", this.mHostname));
        notifyError(aVMDLDNSInfo2);
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        long currentTimeMillis;
        String str;
        int i4 = this.mHttpDNSType;
        String str2 = "";
        if (i4 != 2 && i4 != 1) {
            currentTimeMillis = 0;
            str = null;
        } else if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        } else {
            r14 = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
            AVMDLLog.d(TAG, String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(r14), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
            int i5 = AVMDLDNSParser.mGlobalForceExpiredTime;
            if (i5 > 0) {
                r14 = i5;
            }
            currentTimeMillis = System.currentTimeMillis() + (r14 * 1000);
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            str = null;
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                try {
                    str = optJSONArray.getString(i6);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = TextUtils.isEmpty(str2) ? str2 + str : str2 + "," + str;
                }
            }
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                    if (jSONObject2.has("type") && jSONObject2.getInt("type") == 1) {
                        if (jSONObject2.has("TTL")) {
                            r14 = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            str = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = TextUtils.isEmpty(str2) ? str2 + str : str2 + "," + str;
                        }
                    }
                }
                AVMDLLog.d(TAG, String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(r14), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                int i8 = AVMDLDNSParser.mGlobalForceExpiredTime;
                if (i8 > 0) {
                    r14 = i8;
                }
                currentTimeMillis = System.currentTimeMillis() + (r14 * 1000);
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str2, currentTimeMillis, this.mId);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        String _getURL = _getURL();
        AVMDLLog.d(TAG, "http dns url:" + _getURL);
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
            this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.1
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.2
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        }
    }
}
