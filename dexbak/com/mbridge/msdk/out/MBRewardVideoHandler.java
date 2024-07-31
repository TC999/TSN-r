package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.reward.a.a;
import com.mbridge.msdk.video.bt.module.b.g;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBRewardVideoHandler {
    private static final String TAG = "MBRewardVideoHandler";
    private a controller;

    public MBRewardVideoHandler(Context context, String str, String str2) {
        if (MBSDKContext.m22865f().m22861j() == null && context != null) {
            MBSDKContext.m22865f().m22875b(context);
        }
        String m21981f = SameTool.m21981f(str2);
        if (!TextUtils.isEmpty(m21981f)) {
            SameTool.m22008a(str2, m21981f);
        }
        initMBRewardVideoHandler(str, str2);
    }

    private void initMBRewardVideoHandler(String str, String str2) {
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
            }
            this.controller.b(str, str2);
        } catch (Throwable th) {
            SameLogTool.m21735b(TAG, th.getMessage(), th);
        }
    }

    public void clearBitmapCache() {
        try {
            CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22344a();
        } catch (Throwable th) {
            SameLogTool.m21733d(TAG, th.getMessage());
        }
    }

    public void clearVideoCache() {
        try {
            if (this.controller != null) {
                SameFileTool.m21758a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.b() : "";
    }

    public boolean isReady() {
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.e(false);
        }
        return false;
    }

    public void load() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.d(true);
        }
    }

    public void loadFormSelfFilling() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.d(false);
        }
    }

    public void playVideoMute(int i) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    public void setRewardPlus(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void setRewardVideoListener(g gVar) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(new com.mbridge.msdk.video.bt.module.b.a(gVar));
        }
    }

    public void show() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void show(String str) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, (String) null);
        }
    }

    public void show(String str, String str2) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, str2);
        }
    }

    public MBRewardVideoHandler(String str, String str2) {
        String m21981f = SameTool.m21981f(str2);
        if (!TextUtils.isEmpty(m21981f)) {
            SameTool.m22008a(str2, m21981f);
        }
        initMBRewardVideoHandler(str, str2);
    }
}
