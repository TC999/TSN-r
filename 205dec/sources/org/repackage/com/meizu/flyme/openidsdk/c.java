package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    String f61601a;

    /* renamed from: b  reason: collision with root package name */
    Boolean f61602b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.f61602b = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f61602b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f61601a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f61601a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        Boolean bool = this.f61602b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
