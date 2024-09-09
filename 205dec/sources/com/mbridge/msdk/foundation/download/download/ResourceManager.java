package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    public static final String KEY_INDEX_HTML = "foldername";
    public static final String KEY_MD5CHECK = "nc";
    public static final String KEY_MD5FILENAME = "md5filename";
    private static String TAG = "ResourceManager";
    private String mFileSaveSDDir;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class ResourceManagerHolder {
        public static ResourceManager instance = new ResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static ResourceManager getinstance() {
        return ResourceManagerHolder.instance;
    }

    private String save(String str, String str2, File file) {
        String a4 = v.a(str2, this.mFileSaveSDDir + TTPathConst.sSeparator + SameMD5.getMD5(ai.a(str)));
        return TextUtils.isEmpty(a4) ? v.b(file) : a4;
    }

    public void cleanZipRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.ResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z3) {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    v.c(ResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public String getResDirFromCampaign(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.mFileSaveSDDir + TTPathConst.sSeparator + SameMD5.getMD5(ai.a(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(KEY_INDEX_HTML);
            x.a(TAG, "check zip \u4e0b\u8f7d\u60c5\u51b5\uff1aurl:" + str);
            x.a(TAG, "check zip \u4e0b\u8f7d\u60c5\u51b5\uff1aindexHtml:" + queryParameters);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + TTPathConst.sSeparator + str5 + TTPathConst.sSeparator + str5 + ".html";
            if (v.a(str6)) {
                com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 != null && !TextUtils.isEmpty(b4.aL())) {
                    File file = new File(str6);
                    v.a(com.mbridge.msdk.a.b.a(com.iab.omid.library.mmadbridge.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, v.a(file))).getBytes(), file);
                }
                try {
                    str2 = str.substring(str.indexOf("?") + 1);
                } catch (Exception unused) {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(str2)) {
                    str3 = "?" + str2;
                }
                return "file://" + str6 + str3;
            }
            return null;
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.b(c.MBRIDGE_700_RES);
    }

    public synchronized String saveResFile(String str, byte[] bArr) {
        String message;
        String str2 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str3 = this.mFileSaveSDDir + TTPathConst.sSeparator + SameMD5.getMD5(ai.a(str)) + ".zip";
                    File file = new File(str3);
                    if (v.a(bArr, file)) {
                        Uri parse = Uri.parse(str);
                        List<String> queryParameters = parse.getQueryParameters(KEY_MD5CHECK);
                        if (queryParameters != null && queryParameters.size() != 0) {
                            str2 = save(str, str3, file);
                        }
                        List<String> queryParameters2 = parse.getQueryParameters(KEY_MD5FILENAME);
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            String str4 = queryParameters2.get(0);
                            if (!TextUtils.isEmpty(str4) && str4.equals(u.a(file))) {
                                str2 = save(str, str3, file);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        v.b(file);
                    }
                }
            } catch (Exception e4) {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
                message = e4.getMessage();
            }
        }
        message = str2;
        return message;
    }

    private ResourceManager() {
        init();
    }
}
