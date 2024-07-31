package com.mbridge.msdk.out;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.system.NoProGuard;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CustomInfoManager implements NoProGuard {
    private static CustomInfoManager INSTANCE = null;
    private static String TAG = "CustomInfoManager";
    public static final int TYPE_BID = 6;
    public static final int TYPE_BIDLOAD = 7;
    public static final int TYPE_LOAD = 8;
    private ConcurrentHashMap<String, String> infoMap = new ConcurrentHashMap<>();

    private CustomInfoManager() {
    }

    private String getCustomInfoByUnitId(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
            return concurrentHashMap.get(str + "_bid");
        } else if (i != 7) {
            return i != 8 ? "" : this.infoMap.get(str);
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
            return concurrentHashMap2.get(str + "_bidload");
        }
    }

    public static synchronized CustomInfoManager getInstance() {
        CustomInfoManager customInfoManager;
        synchronized (CustomInfoManager.class) {
            if (INSTANCE == null) {
                synchronized (CustomInfoManager.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new CustomInfoManager();
                    }
                }
            }
            customInfoManager = INSTANCE;
        }
        return customInfoManager;
    }

    public void setCustomInfo(String str, int i, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        String m21813a = SameBase64Tool.m21813a(str2);
        if (i == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
            concurrentHashMap.put(str + "_bid", m21813a);
        } else if (i != 7) {
            if (i != 8) {
                return;
            }
            this.infoMap.put(str, m21813a);
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
            concurrentHashMap2.put(str + "_bidload", m21813a);
        }
    }

    public String getCustomInfoByUnitId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains(BidResponsed.KEY_BID_ID)) {
                    return getCustomInfoByUnitId(str, 6);
                }
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return getCustomInfoByUnitId(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains("v3")) {
                    return getCustomInfoByUnitId(str, 8);
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(TAG, "Exception", th);
        }
        return "";
    }
}
