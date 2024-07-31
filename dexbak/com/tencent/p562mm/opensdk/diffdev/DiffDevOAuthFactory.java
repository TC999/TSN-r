package com.tencent.p562mm.opensdk.diffdev;

import com.tencent.p562mm.opensdk.diffdev.p564a.C12978a;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        Log.m15262v(TAG, "getDiffDevOAuth, version = " + i);
        if (i > 1) {
            Log.m15264e(TAG, "getDiffDevOAuth fail, unsupported version = " + i);
            return null;
        } else if (i != 1) {
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new C12978a();
            }
            return v1Instance;
        }
    }
}
