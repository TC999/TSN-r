package com.kwad.sdk.core.download.p395a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import java.util.List;

/* renamed from: com.kwad.sdk.core.download.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10299b {

    /* renamed from: com.kwad.sdk.core.download.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10300a {
        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();

        /* renamed from: oo */
        void mo26365oo();
    }

    /* renamed from: com.kwad.sdk.core.download.a.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10301b implements InterfaceC10300a {
        @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
        public void onError(Throwable th) {
        }

        @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
        public void onSuccess() {
        }

        @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
        /* renamed from: oo */
        public final void mo26365oo() {
        }
    }

    /* renamed from: D */
    public static int m26367D(Context context, String str) {
        return m26366a(context, str, new C10301b());
    }

    /* renamed from: a */
    public static int m26366a(Context context, String str, @NonNull InterfaceC10300a interfaceC10300a) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            interfaceC10300a.onPreStart();
            C10331c.m26254d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setFlags(268435456);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                interfaceC10300a.onStart();
                context.startActivity(intent);
                interfaceC10300a.onSuccess();
                return 1;
            }
            interfaceC10300a.mo26365oo();
            return 0;
        } catch (Throwable th) {
            interfaceC10300a.onError(th);
            return -1;
        }
    }
}
