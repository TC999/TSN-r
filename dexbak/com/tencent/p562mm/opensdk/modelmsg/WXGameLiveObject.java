package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p562mm.opensdk.utils.C12989b;
import java.util.HashMap;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXGameLiveObject */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXGameLiveObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXGameObject";
    public HashMap<String, String> extraInfoMap = new HashMap<>();

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    public String getExtra(String str, String str2) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            String str3 = hashMap.get(str);
            return str3 != null ? str3 : str2;
        }
        return null;
    }

    public void putExtra(String str, String str2) {
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap<>();
        }
        if (C12989b.m15256b(str)) {
            return;
        }
        this.extraInfoMap.put(str, str2);
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            bundle.putSerializable("_wxgame_extrainfo", hashMap);
        }
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 70;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extraInfoMap = (HashMap) bundle.getSerializable("_wxgame_extrainfo");
    }
}
