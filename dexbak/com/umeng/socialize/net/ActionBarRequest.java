package com.umeng.socialize.net;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.SocializeUtils;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ActionBarRequest extends SocializeRequest {

    /* renamed from: a */
    private static final String f39505a = "/bar/get/";

    /* renamed from: b */
    private static final int f39506b = 1;

    /* renamed from: c */
    private int f39507c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ActionBarRequest(android.content.Context r8, boolean r9) {
        /*
            r7 = this;
            java.lang.Class<com.umeng.socialize.net.ActionBarResponse> r3 = com.umeng.socialize.net.ActionBarResponse.class
            com.umeng.socialize.net.utils.URequest$RequestMethod r6 = com.umeng.socialize.net.utils.URequest.RequestMethod.GET
            java.lang.String r2 = ""
            r4 = 1
            r0 = r7
            r1 = r8
            r5 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r7.mContext = r8
            r7.f39507c = r9
            r7.mMethod = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.ActionBarRequest.<init>(android.content.Context, boolean):void");
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String getEcryptString(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f39505a + SocializeUtils.getAppkey(this.mContext) + "/android";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.f39507c));
        if (TextUtils.isEmpty(Config.EntityName)) {
            return;
        }
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
    }
}
