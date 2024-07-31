package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;

/* renamed from: com.umeng.commonsdk.config.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SensitiveFieldHandler implements IConfigHandler {
    @Override // com.umeng.commonsdk.config.IConfigHandler
    /* renamed from: a */
    public void mo14017a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong == -1) {
                UMRTLog.m14009e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.m14008i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof CollectController)) {
                return;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    String str2 = strArr[i];
                    if (FieldTable.m14020a(str2)) {
                        ((CollectController) obj).mo14018a(str2, Boolean.valueOf(BitUtils.m14029a(parseLong, i)));
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
        } catch (Throwable unused2) {
            UMRTLog.m14009e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
