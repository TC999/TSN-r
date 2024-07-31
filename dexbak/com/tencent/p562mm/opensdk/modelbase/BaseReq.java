package com.tencent.p562mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.channel.p563a.C12976a;

/* renamed from: com.tencent.mm.opensdk.modelbase.BaseReq */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = C12976a.m15280a(bundle, "_wxapi_basereq_transaction");
        this.openId = C12976a.m15280a(bundle, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
