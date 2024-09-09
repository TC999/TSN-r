package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.f2;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.h4;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.t6;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.x2;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.NetworkProxyManager;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapLoader implements t6.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "\u7f51\u7edc\u5f02\u5e38\u72b6\u6001\u7801\uff1a";
    private Context context;
    private t6 downloadManager;
    private ADataRequestParam mDataRequestParam;
    private boolean mRequestCancel;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class AMapGridDownloadRequest extends f2 {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public String getIPV6URL() {
            return a3.y(getURL());
        }

        @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public Map<String, String> getRequestHead() {
            p4 s3 = a3.s();
            String e4 = s3 != null ? s3.e() : null;
            String j4 = e4.j(this.mContext);
            try {
                j4 = URLEncoder.encode(j4, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", e4, "3dmap"));
            hashtable.put("x-INFO", h4.b(this.mContext));
            hashtable.put(DomainCampaignEx.LOOPBACK_KEY, j4);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(Context context, ADataRequestParam aDataRequestParam) {
        this.mRequestCancel = false;
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mDataRequestParam = aDataRequestParam;
        this.mRequestCancel = false;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String j4 = e4.j(this.context);
        try {
            j4 = URLEncoder.encode(j4, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(j4);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a4 = h4.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a4)));
        stringBuffer.append("&scode=" + h4.c(context, a4, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !NetworkProxyManager.getInstance().isNetworkConnected() ? "\u65e0\u7f51\u7edc" : str;
    }

    private void onCancel() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().netCancel(this.mDataRequestParam.handler, -1);
        }
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        x2.f(this.context, hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            u5.p(e4, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e5) {
            u5.p(e5, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
            }
        }
    }

    public void doCancelAndNotify() {
        onCancel();
        doCancel();
    }

    public void doRequest() {
        if (ft.a(this.context, a3.s()).f8385a != ft.c.SuccessCode) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
            }
        } else if (this.mRequestCancel) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
            }
        } else {
            ADataRequestParam aDataRequestParam = this.mDataRequestParam;
            String str = aDataRequestParam.requestBaseUrl;
            String str2 = aDataRequestParam.requestUrl;
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            String requestParams = getRequestParams(str2.replaceAll(";", getEncodeRequestParams(";").toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + UUID.randomUUID().toString());
            }
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.context, str + generateQueryString(this.context, stringBuffer.toString()), NetworkProxyManager.getInstance().getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
                t6 t6Var = new t6(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = t6Var;
                t6Var.b(this);
            } catch (Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    protected String getRequestParams(String str, boolean z3, int i4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z3) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public void onDownload(byte[] bArr, long j4) {
        if (bArr == null || this.mDataRequestParam == null) {
            return;
        }
        NetworkProxyManager.getInstance().receiveNetData(this.mDataRequestParam.handler, bArr, bArr.length);
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public void onException(Throwable th) {
        int indexOf;
        try {
            String str = new String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            int parseInt = (TextUtils.isEmpty(str) || (indexOf = str.indexOf("\u7f51\u7edc\u5f02\u5e38\u72b6\u6001\u7801\uff1a")) == -1) ? -1 : Integer.parseInt(str.substring(indexOf + 8));
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, parseInt);
            }
        } catch (Throwable unused) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
            }
        }
        x2.e(this.context, hashCode(), !NetworkProxyManager.getInstance().isNetworkConnected(), getNetworkFailedReason(th.getMessage()));
        u5.p(th, "AMapLoader", "download onException");
        String str2 = b3.f7208e;
        c3.l(str2, "map loader exception " + th.getMessage());
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public void onFinish() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().finishDownLoad(this.mDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public void onStop() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().netStop(this.mDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
