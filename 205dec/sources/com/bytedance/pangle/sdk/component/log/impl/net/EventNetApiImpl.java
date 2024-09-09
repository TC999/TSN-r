package com.bytedance.pangle.sdk.component.log.impl.net;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.ILogNetDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdEventUploadResult;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.ad.AdLogEvent;
import com.bytedance.sdk.component.panglarmor.SoftDecTool;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventNetApiImpl implements EventNetApi<AdLogEventFace> {
    public static final String CONTENT_TYPE_APPLICATION_STREAM = "application/octet-stream;tt-data=a";
    private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private static final int MAX_RSP_TIME_DURATION = 300;
    public static final String TAG = "NetApiImpl";
    private final boolean mIsRoot = isRoot();

    private AdEventUploadResult doUploadAdEvent(byte[] bArr, Map<String, String> map, String str) {
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        boolean z5;
        String str2;
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            ILogNetDepend logNetDepend = adLogDepend.getLogNetDepend();
            IPostExecutor providerPostExecutor = logNetDepend.providerPostExecutor();
            providerPostExecutor.setUrl(logNetDepend.getAppLogUrl());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    providerPostExecutor.addHeader(entry.getKey(), entry.getValue());
                }
            }
            providerPostExecutor.setRequestBody(str, bArr);
            providerPostExecutor.addHeader("User-Agent", adLogDepend.getWebViewUA());
            INetResponse execute = providerPostExecutor.execute();
            if (execute == null) {
                return new AdEventUploadResult(false, 510, "RSP IS NULL", false, "error");
            }
            if (!execute.isSuccess() || TextUtils.isEmpty(execute.getBody())) {
                i4 = 0;
                z3 = false;
            } else {
                JSONObject jSONObject = new JSONObject(execute.getBody());
                z3 = isUploadEventSuccess(jSONObject);
                i4 = getRspSigncheckResult(jSONObject);
            }
            int code = execute.getCode();
            String str3 = execute.getHeaders() != null ? execute.getHeaders().get("x-tt-logid") : "error";
            boolean z6 = !z3 && code == 200;
            String message = execute.getMessage();
            message = (message == null || TextUtils.isEmpty(message)) ? "DEFAULT OK" : "DEFAULT OK";
            if (i4 != 0) {
                str2 = "RSP FAIL";
                i5 = i4;
                z4 = false;
                z5 = true;
            } else {
                z4 = z3;
                i5 = code;
                z5 = z6;
                str2 = message;
            }
            reportETEvent(bArr, map, str);
            return new AdEventUploadResult(z4, i5, str2, z5, str3);
        } catch (Throwable th) {
            LDebug.e(TAG, "uploadEvent error" + th.getMessage());
            return new AdEventUploadResult(false, 511, th.getMessage(), false, "error");
        }
    }

    private Map<String, String> generateLogEventHeaderMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (isEncryptSucceed(jSONObject)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    private Map<String, String> generateLogEventV3HeaderMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", CONTENT_TYPE_APPLICATION_STREAM);
        return hashMap;
    }

    public static byte[] getByteBody(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private int getRspSigncheckResult(JSONObject jSONObject) {
        int indexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String optString = jSONObject.optString("s_sig_ts");
            if (optString != null && (indexOf = optString.indexOf("_")) >= 5) {
                String substring = optString.substring(0, indexOf);
                String substring2 = optString.substring(indexOf + 1);
                JSONObject extraJson = LogInternalManager.getInstance().getAdLogDepend().getLogNetDepend().getExtraJson();
                String optString2 = extraJson != null ? extraJson.optString("device_id") : "";
                if (SoftDecTool.signVerifyMD5withRSA(optString2 + "_" + substring, substring2)) {
                    return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(substring).longValue()) > 300 ? 513 : 0;
                }
                return 512;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    private boolean isEncryptSucceed(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private static boolean isRoot() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void reportETEvent(byte[] bArr, Map<String, String> map, String str) {
        IAdLogDepend adLogDepend;
        ILogNetDepend logNetDepend;
        if (bArr == null || bArr.length == 0 || (adLogDepend = LogInternalManager.getInstance().getAdLogDepend()) == null || (logNetDepend = adLogDepend.getLogNetDepend()) == null || !logNetDepend.isReportEt()) {
            return;
        }
        IPostExecutor providerPostExecutor = logNetDepend.providerPostExecutor();
        providerPostExecutor.setUrl(logNetDepend.getETAppLogUrl());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                providerPostExecutor.addHeader(entry.getKey(), entry.getValue());
            }
        }
        providerPostExecutor.setRequestBody(str, bArr);
        providerPostExecutor.addHeader("User-Agent", adLogDepend.getWebViewUA());
        providerPostExecutor.enqueue(new INetCallback() { // from class: com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl.1
            @Override // com.bytedance.pangle.sdk.component.log.impl.net.INetCallback
            public void onFailure(INetExecutor iNetExecutor, IOException iOException) {
                LDebug.d(EventNetApiImpl.TAG, "onFailure: " + iOException.getMessage());
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.net.INetCallback
            public void onResponse(INetExecutor iNetExecutor, INetResponse iNetResponse) {
                if (iNetResponse != null && iNetResponse.isSuccess()) {
                    LDebug.d(EventNetApiImpl.TAG, "onResponse: " + iNetResponse.getBody());
                    return;
                }
                LDebug.d(EventNetApiImpl.TAG, "onResponse: NetResponse is null");
            }
        });
    }

    public boolean isUploadEventSuccess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase("success");
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.net.EventNetApi
    public AdEventUploadResult uploadEvent(List<AdLogEventFace> list) {
        ILogNetDepend logNetDepend;
        AdEventUploadResult doUploadAdEvent;
        byte[] byteBody;
        AdEventUploadResult doUploadAdEvent2;
        String str;
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null) {
            return null;
        }
        try {
            if (adLogDepend.canUseSDK() && (logNetDepend = adLogDepend.getLogNetDepend()) != null && list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                String str2 = "1streqid";
                String str3 = "2ndreqid";
                String str4 = "";
                boolean z3 = false;
                for (AdLogEventFace adLogEventFace : list) {
                    try {
                        if (TextUtils.equals("show", EventDebugUtils.getLabelOrEvent(adLogEventFace))) {
                            String ritCode = EventDebugUtils.getRitCode(adLogEventFace.getEvent());
                            if (!z3) {
                                str = EventDebugUtils.getReqId(adLogEventFace);
                            } else {
                                str3 = EventDebugUtils.getReqId(adLogEventFace);
                                str = str3;
                            }
                            str4 = ritCode;
                            str2 = str;
                            z3 = true;
                        }
                        JSONObject event = adLogEventFace.getEvent();
                        String optString = event.optString("event");
                        JSONObject optJSONObject = event.optJSONObject(EventMonitor.V3_PARAMS);
                        if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                            arrayList2.add(adLogEventFace);
                        } else {
                            arrayList.add(adLogEventFace);
                        }
                    } catch (Throwable th) {
                        th = th;
                        LDebug.e(TAG, "uploadEvent error" + th.getMessage());
                        return new AdEventUploadResult(false, 509, th.getMessage(), false, "error");
                    }
                }
                if (!arrayList.isEmpty()) {
                    String enableSendStagingAdlog = adLogDepend.getEnableSendStagingAdlog();
                    if (EventMonitor.V3_STAGING_ADLOG.equalsIgnoreCase(enableSendStagingAdlog)) {
                        JSONObject buildAdEventV3Body = logNetDepend.buildAdEventV3Body(v1ToV3List(arrayList, false), true, this.mIsRoot);
                        byteBody = logNetDepend.encryptV3Body(buildAdEventV3Body);
                        if (byteBody == null) {
                            JSONObject encryptBodyWithCBC = logNetDepend.encryptBodyWithCBC(buildAdEventV3Body);
                            byteBody = getByteBody(encryptBodyWithCBC);
                            doUploadAdEvent2 = doUploadAdEvent(byteBody, generateLogEventHeaderMap(encryptBodyWithCBC), "application/json; charset=utf-8");
                        } else {
                            doUploadAdEvent2 = doUploadAdEvent(byteBody, generateLogEventV3HeaderMap(), CONTENT_TYPE_APPLICATION_STREAM);
                        }
                    } else if ("all".equalsIgnoreCase(enableSendStagingAdlog)) {
                        JSONObject buildAdEventV3Body2 = logNetDepend.buildAdEventV3Body(v1ToV3List(arrayList, true), true, this.mIsRoot);
                        byte[] encryptV3Body = logNetDepend.encryptV3Body(buildAdEventV3Body2);
                        if (encryptV3Body == null) {
                            JSONObject encryptBodyWithCBC2 = logNetDepend.encryptBodyWithCBC(buildAdEventV3Body2);
                            doUploadAdEvent(getByteBody(encryptBodyWithCBC2), generateLogEventHeaderMap(encryptBodyWithCBC2), "application/json; charset=utf-8");
                        } else {
                            doUploadAdEvent(encryptV3Body, generateLogEventV3HeaderMap(), CONTENT_TYPE_APPLICATION_STREAM);
                        }
                        JSONObject buildAndEncryptV1Body = logNetDepend.buildAndEncryptV1Body(v1ToV1StagingList(arrayList), this.mIsRoot);
                        byteBody = getByteBody(buildAndEncryptV1Body);
                        doUploadAdEvent2 = doUploadAdEvent(byteBody, generateLogEventHeaderMap(buildAndEncryptV1Body), "application/json; charset=utf-8");
                    } else {
                        JSONObject buildAndEncryptV1Body2 = logNetDepend.buildAndEncryptV1Body(arrayList, this.mIsRoot);
                        byteBody = getByteBody(buildAndEncryptV1Body2);
                        doUploadAdEvent2 = doUploadAdEvent(byteBody, generateLogEventHeaderMap(buildAndEncryptV1Body2), "application/json; charset=utf-8");
                    }
                    if (z3) {
                        int length = byteBody != null ? byteBody.length : 0;
                        if (doUploadAdEvent2 != null) {
                            boolean z4 = doUploadAdEvent2.mSuccess;
                            int i4 = doUploadAdEvent2.mStatusCode;
                            String str5 = doUploadAdEvent2.mMsg;
                            EventDebugUtils.setShowResult(z4, i4, str5, str2 + "|" + str3, length, str4);
                        }
                    }
                    return doUploadAdEvent2;
                } else if (arrayList2.isEmpty()) {
                    return null;
                } else {
                    JSONObject buildAdEventV3Body3 = logNetDepend.buildAdEventV3Body(arrayList2, false, this.mIsRoot);
                    byte[] encryptV3Body2 = logNetDepend.encryptV3Body(buildAdEventV3Body3);
                    if (encryptV3Body2 == null) {
                        JSONObject encryptBodyWithCBC3 = logNetDepend.encryptBodyWithCBC(buildAdEventV3Body3);
                        encryptV3Body2 = getByteBody(encryptBodyWithCBC3);
                        doUploadAdEvent = doUploadAdEvent(encryptV3Body2, generateLogEventHeaderMap(encryptBodyWithCBC3), "application/json; charset=utf-8");
                    } else {
                        doUploadAdEvent = doUploadAdEvent(encryptV3Body2, generateLogEventV3HeaderMap(), CONTENT_TYPE_APPLICATION_STREAM);
                    }
                    if (z3) {
                        int length2 = encryptV3Body2 != null ? encryptV3Body2.length : 0;
                        if (doUploadAdEvent != null) {
                            boolean z5 = doUploadAdEvent.mSuccess;
                            int i5 = doUploadAdEvent.mStatusCode;
                            String str6 = doUploadAdEvent.mMsg;
                            EventDebugUtils.setShowResult(z5, i5, str6, str2 + "|" + str3, length2, str4);
                        }
                    }
                    return doUploadAdEvent;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.net.EventNetApi
    public AdEventUploadResult uploadStatsLog(JSONObject jSONObject) {
        ILogNetDepend logNetDepend;
        INetResponse execute;
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || !adLogDepend.canUseSDK() || jSONObject == null || jSONObject.length() <= 0 || (logNetDepend = adLogDepend.getLogNetDepend()) == null) {
            return null;
        }
        JSONObject encryptBodyWithCBC = logNetDepend.encryptBodyWithCBC(jSONObject);
        IPostExecutor providerPostExecutor = logNetDepend.providerPostExecutor();
        providerPostExecutor.setUrl(logNetDepend.getStatsLogUrl());
        providerPostExecutor.setJson(encryptBodyWithCBC.toString());
        providerPostExecutor.addHeader("User-Agent", adLogDepend.getWebViewUA());
        boolean z3 = false;
        int i4 = 0;
        String str = "error unknown";
        boolean z4 = false;
        try {
            execute = providerPostExecutor.execute();
        } catch (Throwable unused) {
        }
        if (execute == null) {
            return new AdEventUploadResult(false, 0, "error unknown", false, "ignore");
        }
        if (execute.isSuccess() && !TextUtils.isEmpty(execute.getBody())) {
            JSONObject jSONObject2 = new JSONObject(execute.getBody());
            int optInt = jSONObject2.optInt("code", -1);
            str = jSONObject2.optString("data", "");
            z3 = optInt == 20000;
            if (optInt == 60005) {
                z4 = true;
            }
        }
        i4 = execute.getCode();
        if (!execute.isSuccess()) {
            str = execute.getMessage();
        }
        return new AdEventUploadResult(z3, i4, str, z4, "ignore");
    }

    public List<AdLogEventFace> v1ToV1StagingList(List<AdLogEventFace> list) {
        ArrayList arrayList = new ArrayList();
        for (AdLogEventFace adLogEventFace : list) {
            try {
                JSONObject event = adLogEventFace.getEvent();
                JSONObject jSONObject = new JSONObject();
                Iterator<String> keys = event.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.putOpt(next, event.opt(next));
                }
                jSONObject.putOpt(EventMonitor.AD_STAGING_FLAG, 1);
                arrayList.add(new AdLogEvent(adLogEventFace.getLocalId(), jSONObject));
            } catch (Exception e4) {
                LDebug.e(e4.getMessage());
            }
        }
        return arrayList;
    }

    public List<AdLogEventFace> v1ToV3List(List<AdLogEventFace> list, boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (AdLogEventFace adLogEventFace : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject event = adLogEventFace.getEvent();
                jSONObject.putOpt("event", event.optString("label"));
                long optLong = event.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", DATA_FORMAT.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = event.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, event.opt(next));
                    }
                }
                if (z3) {
                    jSONObject2.putOpt(EventMonitor.AD_STAGING_FLAG, 3);
                }
                jSONObject.putOpt(EventMonitor.V3_PARAMS, jSONObject2);
                arrayList.add(new AdLogEvent(adLogEventFace.getLocalId(), jSONObject));
            } catch (Exception e4) {
                LDebug.e(e4.getMessage());
            }
        }
        return arrayList;
    }
}
