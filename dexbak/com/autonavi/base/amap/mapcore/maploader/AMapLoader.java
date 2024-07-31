package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AbstractAMapRequest;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.ClientInfo;
import com.amap.api.col.p0463l.DownloadManager;
import com.amap.api.col.p0463l.LinkLogConfig;
import com.amap.api.col.p0463l.LinkLogManager;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.col.p0463l.SDKInfo;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.StatisticsUtil;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.p048ae.gmap.NetworkProxyManager;
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

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapLoader implements DownloadManager.InterfaceC1941a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private Context context;
    private DownloadManager downloadManager;
    private ADataRequestParam mDataRequestParam;
    private boolean mRequestCancel;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class AMapGridDownloadRequest extends AbstractAMapRequest {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public String getIPV6URL() {
            return C1732a3.m55685y(getURL());
        }

        @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public Map<String, String> getRequestHead() {
            SDKInfo m55691s = C1732a3.m55691s();
            String m54396e = m55691s != null ? m55691s.m54396e() : null;
            String m55240j = C1780e4.m55240j(this.mContext);
            try {
                m55240j = URLEncoder.encode(m55240j, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", m54396e, "3dmap"));
            hashtable.put("x-INFO", ClientInfo.m54932b(this.mContext));
            hashtable.put(DomainCampaignEx.LOOPBACK_KEY, m55240j);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
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
        String m55240j = C1780e4.m55240j(this.context);
        try {
            m55240j = URLEncoder.encode(m55240j, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(m55240j);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String m54933a = ClientInfo.m54933a();
        stringBuffer.append("&ts=".concat(String.valueOf(m54933a)));
        stringBuffer.append("&scode=" + ClientInfo.m54931c(context, m54933a, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !NetworkProxyManager.getInstance().isNetworkConnected() ? "无网络" : str;
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
        StatisticsUtil.m53555f(this.context, hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            SDKLogHandler.m53863p(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            SDKLogHandler.m53863p(e2, "AbstractProtocalHandler", "strReEncoderException");
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
                this.downloadManager.m53928a();
            }
        }
    }

    public void doCancelAndNotify() {
        onCancel();
        doCancel();
    }

    public void doRequest() {
        if (Privacy.m54995a(this.context, C1732a3.m55691s()).f4676a != Privacy.EnumC1812c.SuccessCode) {
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
                DownloadManager downloadManager = new DownloadManager(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = downloadManager;
                downloadManager.m53927b(this);
            } catch (Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    protected String getRequestParams(String str, boolean z, int i) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public void onDownload(byte[] bArr, long j) {
        if (bArr == null || this.mDataRequestParam == null) {
            return;
        }
        NetworkProxyManager.getInstance().receiveNetData(this.mDataRequestParam.handler, bArr, bArr.length);
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public void onException(Throwable th) {
        int indexOf;
        try {
            String str = new String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            int parseInt = (TextUtils.isEmpty(str) || (indexOf = str.indexOf(NETWORK_RESPONSE_CODE_STRING)) == -1) ? -1 : Integer.parseInt(str.substring(indexOf + 8));
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, parseInt);
            }
        } catch (Throwable unused) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
            }
        }
        StatisticsUtil.m53556e(this.context, hashCode(), !NetworkProxyManager.getInstance().isNetworkConnected(), getNetworkFailedReason(th.getMessage()));
        SDKLogHandler.m53863p(th, "AMapLoader", "download onException");
        String str2 = LinkLogConfig.f3647e;
        LinkLogManager.m55482l(str2, "map loader exception " + th.getMessage());
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public void onFinish() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().finishDownLoad(this.mDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public void onStop() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().netStop(this.mDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
