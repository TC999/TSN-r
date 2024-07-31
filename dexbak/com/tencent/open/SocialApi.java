package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocialApi {

    /* renamed from: a */
    private SocialApiIml f37220a;

    public SocialApi(QQToken qQToken) {
        this.f37220a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C12925a.m15471a("SocialApi", iUiListener)) {
            return;
        }
        this.f37220a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C12925a.m15471a("SocialApi", iUiListener)) {
            return;
        }
        this.f37220a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C12925a.m15471a("SocialApi", iUiListener)) {
            return;
        }
        this.f37220a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (C12925a.m15471a("SocialApi", iUiListener)) {
            return;
        }
        this.f37220a.story(activity, bundle, iUiListener);
    }
}
