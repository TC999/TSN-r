package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXStateJumpChannelProfileInfo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXStateJumpChannelProfileInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    private static final int USERNAME_LENGTH_LIMIT = 1024;
    public String username;

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public boolean checkArgs() {
        String str;
        String str2 = this.username;
        if (str2 == null || str2.length() <= 0) {
            str = "checkArgs fail, username is null";
        } else if (this.username.length() < 1024) {
            return true;
        } else {
            str = "checkArgs fail, username length exceed limit";
        }
        Log.m15264e(TAG, str);
        return false;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void serialize(Bundle bundle) {
        bundle.putString("wx_state_jump_channel_profile_username", this.username);
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public int type() {
        return 3;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void unserialize(Bundle bundle) {
        this.username = bundle.getString("wx_state_jump_channel_profile_username", "");
    }
}
