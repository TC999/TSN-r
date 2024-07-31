package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p562mm.opensdk.utils.C12989b;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXLiteAppObject */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXLiteAppObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLiteAppObject";
    public String path;
    public String query;
    public String userName;
    public String webpageUrl;

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (C12989b.m15256b(this.userName)) {
            Log.m15264e(TAG, "userName is null");
            return false;
        }
        return true;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxliteapp_webpageurl", this.webpageUrl);
        bundle.putString("_wxliteapp_username", this.userName);
        bundle.putString("_wxliteapp_path", this.path);
        bundle.putString("_wxliteapp_query", this.query);
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 68;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxliteapp_webpageurl");
        this.userName = bundle.getString("_wxliteapp_username");
        this.path = bundle.getString("_wxliteapp_path");
        this.query = bundle.getString("_wxliteapp_query");
    }
}
