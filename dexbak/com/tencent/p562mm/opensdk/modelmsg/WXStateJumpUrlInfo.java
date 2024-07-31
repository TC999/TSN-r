package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXStateJumpUrlInfo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXStateJumpUrlInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    public String jumpUrl;

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public boolean checkArgs() {
        String str;
        String str2 = this.jumpUrl;
        if (str2 == null || str2.length() <= 0) {
            str = "checkArgs fail, jumpUrl is null";
        } else if (this.jumpUrl.length() < LENGTH_LIMIT) {
            return true;
        } else {
            str = "checkArgs fail, jumpUrl is invalid";
        }
        Log.m15264e(TAG, str);
        return false;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void serialize(Bundle bundle) {
        bundle.putString("wx_state_jump_url", this.jumpUrl);
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public int type() {
        return 1;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void unserialize(Bundle bundle) {
        this.jumpUrl = bundle.getString("wx_state_jump_url", "");
    }
}
