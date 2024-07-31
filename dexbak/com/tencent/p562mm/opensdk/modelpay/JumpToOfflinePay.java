package com.tencent.p562mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JumpToOfflinePay {

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 24;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 24;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
