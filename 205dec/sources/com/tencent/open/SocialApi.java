package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocialApi {

    /* renamed from: a  reason: collision with root package name */
    private SocialApiIml f51620a;

    public SocialApi(QQToken qQToken) {
        this.f51620a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f51620a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f51620a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f51620a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f51620a.story(activity, bundle, iUiListener);
    }
}
