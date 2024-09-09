package com.umeng.socialize.net.utils;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class URequest {
    protected static String APPLICATION = "application/x-www-form-urlencoded";
    protected static String GET = "GET";
    protected static String MULTIPART = "multipart/form-data";
    protected static String POST = "POST";
    protected String mBaseUrl;
    public Context mContext;
    public Map<String, String> mHeaders;
    public RequestMethod mMethod;
    protected MIME mMimeType;
    public Class<? extends SocializeReseponse> mResponseClz;
    public Map<String, String> mParams = new HashMap();
    public PostStyle postStyle = PostStyle.MULTIPART;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class FilePair {
        byte[] mBinaryData;
        String mFileName;

        public FilePair(String str, byte[] bArr) {
            this.mFileName = str;
            this.mBinaryData = bArr;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    protected enum MIME {
        DEFAULT("application/x-www-form-urlencoded;charset=utf-8"),
        JSON("application/json;charset=utf-8");
        
        private String mimeType;

        MIME(String str) {
            this.mimeType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mimeType;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum PostStyle {
        MULTIPART { // from class: com.umeng.socialize.net.utils.URequest.PostStyle.1
            @Override // java.lang.Enum
            public String toString() {
                return URequest.MULTIPART;
            }
        },
        APPLICATION { // from class: com.umeng.socialize.net.utils.URequest.PostStyle.2
            @Override // java.lang.Enum
            public String toString() {
                return URequest.APPLICATION;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum RequestMethod {
        GET { // from class: com.umeng.socialize.net.utils.URequest.RequestMethod.1
            @Override // java.lang.Enum
            public String toString() {
                return URequest.GET;
            }
        },
        POST { // from class: com.umeng.socialize.net.utils.URequest.RequestMethod.2
            @Override // java.lang.Enum
            public String toString() {
                return URequest.POST;
            }
        }
    }

    public URequest(String str) {
        this.mBaseUrl = str;
    }

    public static String buildGetParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                sb.append(str + "=" + URLEncoder.encode(map.get(str).toString()) + "&");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    public void addStringParams(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mParams.put(str, str2);
    }

    public String buildGetUrl(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return str;
        }
        if (!str.endsWith("?")) {
            str = str + "?";
        }
        String buildGetParams = buildGetParams(map);
        SLog.debug(UmengText.NET.assertURL(str, buildGetParams));
        try {
            buildGetParams = getEcryptString(buildGetParams);
        } catch (Exception e4) {
            SLog.error(UmengText.NET.PARSEERROR, e4);
        }
        return str + buildGetParams;
    }

    public abstract Map<String, Object> buildParams();

    public String generateGetURL(String str, Map<String, Object> map) {
        return buildGetUrl(str, map);
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public Map<String, Object> getBodyPair() {
        return null;
    }

    public String getDecryptString(String str) {
        return str;
    }

    public String getEcryptString(String str) {
        return str;
    }

    public Map<String, FilePair> getFilePair() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getHttpMethod() {
        return this.mMethod.toString();
    }

    public void onPrepareRequest() {
    }

    public void setBaseUrl(String str) {
        this.mBaseUrl = str;
    }

    public abstract String toGetUrl();

    public abstract JSONObject toJson();
}
