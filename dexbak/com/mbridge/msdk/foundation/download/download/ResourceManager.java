package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.C7084b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.tools.SameFileMD5;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.UriUtil;
import com.mbridge.msdk.p454a.OmsdkUtils;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.io.File;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    public static final String KEY_INDEX_HTML = "foldername";
    public static final String KEY_MD5CHECK = "nc";
    public static final String KEY_MD5FILENAME = "md5filename";
    private static String TAG = "ResourceManager";
    private String mFileSaveSDDir;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class ResourceManagerHolder {
        public static ResourceManager instance = new ResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static ResourceManager getinstance() {
        return ResourceManagerHolder.instance;
    }

    private String save(String str, String str2, File file) {
        String m21752a = SameFileTool.m21752a(str2, this.mFileSaveSDDir + "/" + SameMD5.getMD5(UriUtil.m21950a(str)));
        return TextUtils.isEmpty(m21752a) ? SameFileTool.m21749b(file) : m21752a;
    }

    public void cleanZipRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new CommonTask() { // from class: com.mbridge.msdk.foundation.download.download.ResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void pauseTask(boolean z) {
                }

                @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
                public void runTask() {
                    SameFileTool.m21746c(ResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public String getResDirFromCampaign(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(UriUtil.m21950a(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(KEY_INDEX_HTML);
            SameLogTool.m21738a(TAG, "check zip 下载情况：url:" + str);
            SameLogTool.m21738a(TAG, "check zip 下载情况：indexHtml:" + queryParameters);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (SameFileTool.m21755a(str6)) {
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b != null && !TextUtils.isEmpty(m23252b.m23386aL())) {
                    File file = new File(str6);
                    SameFileTool.m21751a(OmsdkUtils.m23469a(C7084b.m34758a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, SameFileTool.m21756a(file))).getBytes(), file);
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
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_RES);
    }

    public synchronized String saveResFile(String str, byte[] bArr) {
        String message;
        String str2 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str3 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(UriUtil.m21950a(str)) + ".zip";
                    File file = new File(str3);
                    if (SameFileTool.m21751a(bArr, file)) {
                        Uri parse = Uri.parse(str);
                        List<String> queryParameters = parse.getQueryParameters(KEY_MD5CHECK);
                        if (queryParameters != null && queryParameters.size() != 0) {
                            str2 = save(str, str3, file);
                        }
                        List<String> queryParameters2 = parse.getQueryParameters(KEY_MD5FILENAME);
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            String str4 = queryParameters2.get(0);
                            if (!TextUtils.isEmpty(str4) && str4.equals(SameFileMD5.m21760a(file))) {
                                str2 = save(str, str3, file);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        SameFileTool.m21749b(file);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                message = e.getMessage();
            }
        }
        message = str2;
        return message;
    }

    private ResourceManager() {
        init();
    }
}
