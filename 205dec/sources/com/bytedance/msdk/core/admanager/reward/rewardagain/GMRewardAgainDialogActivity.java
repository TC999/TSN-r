package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class GMRewardAgainDialogActivity extends Activity {

    /* renamed from: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GMRewardAgainDialogActivity.this.finish();
            Runnable runnable = xv.xv().f27805w;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GMRewardAgainDialogActivity.this.finish();
            Runnable runnable = xv.xv().xv;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    static {
        StubApp.interface11(15409);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }
}
