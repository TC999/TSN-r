package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveStreamInfo {
    public static final int LIVE_STREAM_INFO_CMAF_INVALID = 1;
    public static final int LIVE_STREAM_INFO_LLS_INVALID = 2;
    public static final String MPD_VERSION = "1.0";
    private JSONObject mCommonInfo;
    private String mDefaultResolution;
    private int mFlag;
    private String mHost;
    private String mIp;
    private boolean mIsABRListMatch;
    private String mRequestParams;
    private JSONObject mStreamInfo;
    private boolean mEnableOriginResolution = false;
    private long mAdjustedOriginBitRate = -1;
    private int mIsCodecSame = -1;
    private String mTransportProtocol = "";
    private String mPortNum = "";
    private int mRtcFallback = 0;
    private final String TAG = "LiveStreamInfo";
    public int mSRShorterSideUpperBound = 0;
    public int mSRLongerSideUpperBound = 0;
    private int mSRFrameRateUpperBound = 0;
    public int mSharpenLongerSideUpperBound = 0;
    public int mSharpenLongerSideLowerBound = 0;
    public int mSharpenShorterSideUpperBound = 0;
    public int mSharpenShorterSideLowerBound = 0;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
        r6.mIsABRListMatch = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LiveStreamInfo(org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "list"
            java.lang.String r1 = "default"
            java.lang.String r2 = "common"
            r6.<init>()
            r3 = 0
            r6.mEnableOriginResolution = r3
            r4 = -1
            r6.mAdjustedOriginBitRate = r4
            r4 = -1
            r6.mIsCodecSame = r4
            java.lang.String r4 = ""
            r6.mTransportProtocol = r4
            r6.mPortNum = r4
            r6.mRtcFallback = r3
            java.lang.String r4 = "LiveStreamInfo"
            r6.TAG = r4
            r6.mSRShorterSideUpperBound = r3
            r6.mSRLongerSideUpperBound = r3
            r6.mSRFrameRateUpperBound = r3
            r6.mIsABRListMatch = r3
            r6.mSharpenLongerSideUpperBound = r3
            r6.mSharpenLongerSideLowerBound = r3
            r6.mSharpenShorterSideUpperBound = r3
            r6.mSharpenShorterSideLowerBound = r3
            if (r7 != 0) goto L32
            return
        L32:
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r7.getJSONObject(r5)     // Catch: org.json.JSONException -> La2
            r6.mStreamInfo = r5     // Catch: org.json.JSONException -> La2
            boolean r5 = r7.has(r2)     // Catch: org.json.JSONException -> La2
            if (r5 == 0) goto L46
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> La2
            r6.mCommonInfo = r7     // Catch: org.json.JSONException -> La2
        L46:
            org.json.JSONObject r7 = r6.mCommonInfo     // Catch: org.json.JSONException -> La2
            if (r7 == 0) goto La6
            java.lang.String r2 = "auto"
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> La2
            if (r7 == 0) goto L74
            boolean r2 = r7.has(r1)     // Catch: org.json.JSONException -> La2
            if (r2 == 0) goto L74
            java.lang.String r1 = r7.getString(r1)     // Catch: org.json.JSONException -> La2
            r6.mDefaultResolution = r1     // Catch: org.json.JSONException -> La2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> La2
            r1.<init>()     // Catch: org.json.JSONException -> La2
            java.lang.String r2 = "mDefaultResolution: "
            r1.append(r2)     // Catch: org.json.JSONException -> La2
            java.lang.String r2 = r6.mDefaultResolution     // Catch: org.json.JSONException -> La2
            r1.append(r2)     // Catch: org.json.JSONException -> La2
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> La2
            com.bykv.vk.component.ttvideo.log.MyLog.i(r4, r1)     // Catch: org.json.JSONException -> La2
        L74:
            r1 = 1
            r6.mIsABRListMatch = r1     // Catch: org.json.JSONException -> La2
            if (r7 == 0) goto La6
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> La2
            if (r1 == 0) goto La6
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> La2
            if (r7 == 0) goto La6
            int r0 = r7.length()     // Catch: org.json.JSONException -> La2
            if (r0 <= 0) goto La6
            r0 = 0
        L8c:
            int r1 = r7.length()     // Catch: org.json.JSONException -> La2
            if (r0 >= r1) goto La6
            java.lang.String r1 = r7.getString(r0)     // Catch: org.json.JSONException -> La2
            boolean r1 = r6.isSupport(r1)     // Catch: org.json.JSONException -> La2
            if (r1 != 0) goto L9f
            r6.mIsABRListMatch = r3     // Catch: org.json.JSONException -> La2
            goto La6
        L9f:
            int r0 = r0 + 1
            goto L8c
        La2:
            r7 = move-exception
            r7.printStackTrace()
        La6:
            r6.mFlag = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.<init>(org.json.JSONObject):void");
    }

    private boolean isNeedUseDefaultResolution(String str) {
        return (TextUtils.isEmpty(str) || !str.equals("auto") || TextUtils.isEmpty(this.mDefaultResolution)) ? false : true;
    }

    private String set_url_port_scheme(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.mPortNum)) {
            if (indexOf3 != -1) {
                int i4 = indexOf3 + 5;
                int i5 = i4 + 1;
                while (i5 < sb.length() && sb.charAt(i5) - '0' >= 0 && sb.charAt(i5) - '0' <= 9) {
                    i5++;
                }
                sb.replace(i4, i5, this.mPortNum);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + this.mPortNum);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.mTransportProtocol)) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && indexOf4 != -1) {
                sb2.replace(0, indexOf4, "http");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean adjustOriginBitRate(String str, String str2, long j4) {
        char c4;
        if (this.mAdjustedOriginBitRate > 0) {
            return true;
        }
        long j5 = -1;
        String str3 = LiveConfigKey.LOW;
        while (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(getStreamUrlForResolution(str3, str, str2))) {
                long bitrate = getBitrate(str3, str2);
                if (str3.equals(LiveConfigKey.ORIGIN) && bitrate <= j5 && j4 > 0) {
                    this.mAdjustedOriginBitRate = j4;
                    bitrate = j4;
                }
                j5 = bitrate;
            }
            str3.hashCode();
            switch (str3.hashCode()) {
                case -1008619738:
                    if (str3.equals(LiveConfigKey.ORIGIN)) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 3324:
                    if (str3.equals(LiveConfigKey.HIGH)) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 3448:
                    if (str3.equals(LiveConfigKey.LOW)) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 3665:
                    if (str3.equals(LiveConfigKey.STANDARD)) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 115761:
                    if (str3.equals(LiveConfigKey.UHD)) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
            str3 = null;
            switch (c4) {
                case 1:
                    str3 = LiveConfigKey.UHD;
                    break;
                case 2:
                    str3 = LiveConfigKey.STANDARD;
                    break;
                case 3:
                    str3 = LiveConfigKey.HIGH;
                    break;
                case 4:
                    str3 = LiveConfigKey.ORIGIN;
                    break;
            }
        }
        return this.mAdjustedOriginBitRate > 0;
    }

    public JSONObject getAbrInfo() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject("auto");
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public String getAvLinesParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optString("AvLines");
            }
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public long getBitrate(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("vbitrate");
            } catch (JSONException e4) {
                e4.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public int getCheckSilenceInterval(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                String sDKParams = getSDKParams(str, str2);
                if (sDKParams != null) {
                    return new JSONObject(sDKParams).optInt("CheckSilenceInterval");
                }
                return -1;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public String getDefaultResolution() {
        return this.mDefaultResolution;
    }

    public long getGopDuration(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("gop");
            } catch (JSONException e4) {
                e4.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("header");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.getString(next));
                }
                return hashMap;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public String getLabelfromBitrate(long j4, String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator<String> keys = this.mStreamInfo.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (isEnableAdaptive(next) && j4 == getBitrate(next, str) / 1000) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0 A[Catch: JSONException -> 0x0142, TryCatch #0 {JSONException -> 0x0142, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:15:0x0046, B:18:0x004e, B:22:0x0075, B:24:0x007d, B:27:0x008b, B:31:0x00a5, B:33:0x00b0, B:35:0x00b7, B:36:0x00cc, B:38:0x00d4, B:42:0x00f0, B:44:0x00fa, B:46:0x0109, B:48:0x0114, B:49:0x0118, B:45:0x0106, B:26:0x0084, B:54:0x0126), top: B:65:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114 A[Catch: JSONException -> 0x0142, TryCatch #0 {JSONException -> 0x0142, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:15:0x0046, B:18:0x004e, B:22:0x0075, B:24:0x007d, B:27:0x008b, B:31:0x00a5, B:33:0x00b0, B:35:0x00b7, B:36:0x00cc, B:38:0x00d4, B:42:0x00f0, B:44:0x00fa, B:46:0x0109, B:48:0x0114, B:49:0x0118, B:45:0x0106, B:26:0x0084, B:54:0x0126), top: B:65:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getMPDForFormat(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getMPDForFormat(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getPortNum(String str, String str2, String str3) {
        String str4;
        if (this.mCommonInfo == null) {
            return null;
        }
        try {
            str4 = new JSONObject(this.mCommonInfo.getJSONObject(str.equals(LiveConfigKey.RTMP) ? "rtmp_ports" : "http_ports").optString(str2)).optString(str3);
        } catch (JSONException e4) {
            e4.printStackTrace();
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return str4;
    }

    public String getQueryItems() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("query")) {
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("query");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    String encode = URLEncoder.encode(next, "UTF-8");
                    String encode2 = URLEncoder.encode(string, "UTF-8");
                    sb.append("&");
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                return sb.toString();
            } catch (UnsupportedEncodingException | JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public String getRuleIds() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("rule_ids")) {
            return null;
        }
        return this.mCommonInfo.optString("rule_ids");
    }

    public String getSDKParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                return this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public boolean getSREnabled(String str, String str2, int i4) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params"));
                long optLong = jSONObject.optLong("vbitrate");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NNSR"));
                int optInt = i4 == 1 ? jSONObject2.optInt("Enabled") : 0;
                long optLong2 = jSONObject2.optLong("VBitrateLowerBoundInKbps");
                this.mSRShorterSideUpperBound = jSONObject2.optInt("ShorterSideUpperBound");
                this.mSRLongerSideUpperBound = jSONObject2.optInt("LongerSideUpperBound");
                int optInt2 = jSONObject2.optInt("FrameRateUpperBound");
                this.mSRFrameRateUpperBound = optInt2;
                return optInt == 1 && optLong >= optLong2 * 1000 && this.mSRShorterSideUpperBound > 0 && this.mSRLongerSideUpperBound > 0 && optInt2 > 0;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public int getSRLongerSideUpperBound() {
        return this.mSRLongerSideUpperBound;
    }

    public int getSRShorterSideUpperBound() {
        return this.mSRShorterSideUpperBound;
    }

    public String getSessionID() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("session_id")) {
            return null;
        }
        return this.mCommonInfo.optString("session_id");
    }

    public JSONObject getSharpenParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("ASF"));
                this.mSharpenLongerSideUpperBound = jSONObject.optInt("LongerSideUpperBound");
                this.mSharpenLongerSideLowerBound = jSONObject.optInt("LongerSideLowerBound");
                this.mSharpenShorterSideUpperBound = jSONObject.optInt("ShorterSideUpperBound");
                this.mSharpenShorterSideLowerBound = jSONObject.optInt("ShorterSideLowerBound");
                return jSONObject;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getStreamUrlForResolution(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getStreamUrlForResolution(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getSuggestFormat(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                str3 = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestFormat");
            } catch (JSONException e4) {
                e4.printStackTrace();
                str3 = null;
            }
            if (str3 == null || str3.isEmpty()) {
                return null;
            }
            return str3;
        }
        return null;
    }

    public String getSuggestProtocol(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestProtocol");
                str3 = LiveConfigKey.TCP;
            } catch (JSONException e4) {
                e4.printStackTrace();
                str3 = null;
            }
            if (str3 == null || str3.isEmpty()) {
                return null;
            }
            return str3;
        }
        return null;
    }

    public String getVCodec(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("VCodec");
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public boolean isABRListMatch() {
        return this.mIsABRListMatch;
    }

    public boolean isCodecSame(String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject != null && jSONObject.length() > 0) {
            int i4 = this.mIsCodecSame;
            if (i4 >= 0) {
                return i4 == 1;
            }
            this.mIsCodecSame = 1;
            Iterator<String> keys = this.mStreamInfo.keys();
            String str2 = null;
            String str3 = null;
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                str3 = getVCodec(keys.next(), str);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                    this.mIsCodecSame = 0;
                    break;
                } else if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
            }
            if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
                this.mIsCodecSame = 0;
            }
            return this.mIsCodecSame == 1;
        }
        return false;
    }

    public boolean isEnableAdaptive(String str) {
        JSONArray optJSONArray;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            try {
                JSONObject abrInfo = getAbrInfo();
                if (abrInfo != null && abrInfo.has("list") && (optJSONArray = abrInfo.optJSONArray("list")) != null && optJSONArray.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        String string = optJSONArray.getString(i4);
                        if (string != null && string.equals(str) && (!string.equals(LiveConfigKey.ORIGIN) || this.mEnableOriginResolution)) {
                            return true;
                        }
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            return false;
        }
        return false;
    }

    public boolean isSupport(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mStreamInfo;
        if (jSONObject2 == null) {
            return false;
        }
        try {
            jSONObject = jSONObject2.getJSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public boolean isSupportSR(int i4, int i5, float f4) {
        return Math.max(i4, i5) <= this.mSRLongerSideUpperBound && Math.min(i4, i5) <= this.mSRShorterSideUpperBound && f4 <= ((float) this.mSRFrameRateUpperBound) && i4 < i5;
    }

    public boolean isSupportSharpen(int i4, int i5) {
        int max = Math.max(i4, i5);
        int min = Math.min(i4, i5);
        return max >= this.mSharpenLongerSideLowerBound && max <= this.mSharpenLongerSideUpperBound && min >= this.mSharpenShorterSideLowerBound && min <= this.mSharpenShorterSideUpperBound;
    }

    public void setDefaultResolution(String str) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            this.mDefaultResolution = str;
        }
    }

    public void setEnableOriginResolution(boolean z3) {
        this.mEnableOriginResolution = z3;
    }

    public boolean setFlag(int i4) {
        this.mFlag = i4 | this.mFlag;
        return true;
    }

    public void setRequestParams(String str) {
        this.mRequestParams = str;
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        this.mRequestParams = str;
        this.mIp = str2;
        this.mHost = str3;
    }

    public void setRtcFallback(int i4) {
        this.mRtcFallback = i4;
    }

    public void setTransportProtocol(String str, String str2) {
        this.mTransportProtocol = str;
        this.mPortNum = str2;
    }
}
