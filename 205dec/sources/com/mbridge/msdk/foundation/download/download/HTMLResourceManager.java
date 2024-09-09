package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class HTMLResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    private static final String TAG = "HTMLResourceManager";
    private String mFileSaveSDDir;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class ResourceManagerHolder {
        public static HTMLResourceManager instance = new HTMLResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static HTMLResourceManager getInstance() {
        return ResourceManagerHolder.instance;
    }

    public void cleanHtmlRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.HTMLResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z3) {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    v.c(HTMLResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public String getHtmlContentFromUrl(String str) {
        try {
            String md5 = SameMD5.getMD5(ai.a(str));
            File file = new File(this.mFileSaveSDDir + TTPathConst.sSeparator + md5 + ".html");
            if (file.exists()) {
                return v.a(file);
            }
            return null;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public String getHtmlPathFromUrl(String str) {
        try {
            String str2 = this.mFileSaveSDDir + TTPathConst.sSeparator + SameMD5.getMD5(ai.a(str)) + ".html";
            File file = new File(str2);
            if (file.exists()) {
                com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                if (b4 != null && !TextUtils.isEmpty(b4.aL())) {
                    v.a(com.mbridge.msdk.a.b.a(com.iab.omid.library.mmadbridge.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, v.a(file))).getBytes(), file);
                }
                return "file:////" + str2;
            }
            return null;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.b(c.MBRIDGE_700_HTML);
    }

    public boolean saveResHtmlFile(String str, byte[] bArr) {
        try {
            x.b(TAG, "saveResHtmlFile url:" + str);
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            String str2 = this.mFileSaveSDDir + TTPathConst.sSeparator + SameMD5.getMD5(ai.a(str)) + ".html";
            x.b(TAG, "saveResHtmlFile folderName:" + str2);
            return v.a(bArr, new File(str2));
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private HTMLResourceManager() {
        init();
    }
}
