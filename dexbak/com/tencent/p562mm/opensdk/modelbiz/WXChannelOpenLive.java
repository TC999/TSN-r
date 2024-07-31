package com.tencent.p562mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbase.BaseResp;
import com.tencent.p562mm.opensdk.utils.C12989b;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXChannelOpenLive {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive$Req */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenLive.Req";
        public String feedID;
        public String nonceID;

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (C12989b.m15256b(this.feedID)) {
                str = "feedID is null";
            } else if (C12989b.m15256b(this.nonceID)) {
                str = "nonceID is null";
            } else if (this.feedID.length() > 1024) {
                str = "feedID.length too long!";
            } else if (this.nonceID.length() <= 1024) {
                return true;
            } else {
                str = "nonceID.length too long!";
            }
            Log.m15264e(TAG, str);
            return false;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.feedID = bundle.getString("_wxapi_finder_feedID");
            this.nonceID = bundle.getString("_wxapi_finder_nonceID");
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 35;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_feedID", this.feedID);
            bundle.putString("_wxapi_finder_nonceID", this.nonceID);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive$Resp */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Resp extends BaseResp {
        public String extMsg;

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
            this.extMsg = bundle.getString("_wxapi_finder_extMsg");
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 35;
        }

        @Override // com.tencent.p562mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }
}
