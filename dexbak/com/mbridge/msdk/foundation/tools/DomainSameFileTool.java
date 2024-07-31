package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import java.io.File;
import java.io.IOException;

/* renamed from: com.mbridge.msdk.foundation.tools.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainSameFileTool {
    /* renamed from: a */
    public static File m21879a(String str, Context context, boolean[] zArr) throws IOException {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_APK) + "/download/.mb" + str);
            file.mkdirs();
            if (file.exists()) {
                zArr[0] = true;
                return file;
            }
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        new File(absolutePath).mkdir();
        SameFileTool.m21753a(absolutePath, 505, -1, -1);
        String str2 = absolutePath + "/mbdownload";
        new File(str2).mkdir();
        SameFileTool.m21753a(str2, 505, -1, -1);
        File file2 = new File(str2);
        zArr[0] = false;
        return file2;
    }
}
