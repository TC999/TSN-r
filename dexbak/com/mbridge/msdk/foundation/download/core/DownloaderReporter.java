package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DownloaderReporter {
    private static final String KEY = "key=";
    private static final String TAG = "DownloaderReporter";
    private final Map<String, String> _params;
    private final String _reportKey;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class Builder {
        private final Map<String, String> _params;
        private final String _reportKey;

        public Builder(String str) {
            if (!TextUtils.isEmpty(str)) {
                this._reportKey = str;
                this._params = new HashMap();
                return;
            }
            throw new IllegalArgumentException("reportKey can not be empty");
        }

        public Builder add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    this._params.put(str, str2);
                } catch (Exception unused) {
                }
            }
            return this;
        }

        public DownloaderReporter build() {
            return new DownloaderReporter(this);
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    String encodeValue = encodeValue(map.get(str));
                    sb.append("&");
                    sb.append(str);
                    sb.append("=");
                    sb.append(encodeValue);
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private String encodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public final void report() {
        String str = KEY + this._reportKey + asUrlParams(this._params);
        if (MBBatchReportManager.m22142a().m22135c()) {
            MBBatchReportManager.m22142a().m22139a(str);
            return;
        }
        try {
            new ReportRequest(MBSDKContext.m22865f().m22861j()).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(str, MBSDKContext.m22865f().m22861j(), ""), null);
        } catch (Exception e) {
            SameLogTool.m21733d(TAG, "report exception: " + e.getMessage());
        }
    }

    private DownloaderReporter(Builder builder) {
        this._reportKey = builder._reportKey;
        this._params = builder._params;
    }
}
