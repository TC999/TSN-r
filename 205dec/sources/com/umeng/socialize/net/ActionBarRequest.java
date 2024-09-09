package com.umeng.socialize.net;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.SocializeUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ActionBarRequest extends SocializeRequest {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54089a = "/bar/get/";

    /* renamed from: b  reason: collision with root package name */
    private static final int f54090b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f54091c;

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
            r7.f54091c = r9
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
        return "/bar/get/" + SocializeUtils.getAppkey(this.mContext) + "/android";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams("dc", Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.f54091c));
        if (TextUtils.isEmpty(Config.EntityName)) {
            return;
        }
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
    }
}
