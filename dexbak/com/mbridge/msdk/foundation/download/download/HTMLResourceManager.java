package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.C7084b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.UriUtil;
import com.mbridge.msdk.p454a.OmsdkUtils;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HTMLResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    private static final String TAG = "HTMLResourceManager";
    private String mFileSaveSDDir;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
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
            DownloadTask.getInstance().runTask(new CommonTask() { // from class: com.mbridge.msdk.foundation.download.download.HTMLResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void pauseTask(boolean z) {
                }

                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void runTask() {
                    SameFileTool.m21746c(HTMLResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public String getHtmlContentFromUrl(String str) {
        try {
            String md5 = SameMD5.getMD5(UriUtil.m21950a(str));
            File file = new File(this.mFileSaveSDDir + "/" + md5 + ".html");
            if (file.exists()) {
                return SameFileTool.m21756a(file);
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
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(UriUtil.m21950a(str)) + ".html";
            File file = new File(str2);
            if (file.exists()) {
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b != null && !TextUtils.isEmpty(m23252b.m23386aL())) {
                    SameFileTool.m21751a(OmsdkUtils.m23469a(C7084b.m34758a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, SameFileTool.m21756a(file))).getBytes(), file);
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
        this.mFileSaveSDDir = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_HTML);
    }

    public boolean saveResHtmlFile(String str, byte[] bArr) {
        try {
            SameLogTool.m21736b(TAG, "saveResHtmlFile url:" + str);
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(UriUtil.m21950a(str)) + ".html";
            SameLogTool.m21736b(TAG, "saveResHtmlFile folderName:" + str2);
            return SameFileTool.m21751a(bArr, new File(str2));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private HTMLResourceManager() {
        init();
    }
}
