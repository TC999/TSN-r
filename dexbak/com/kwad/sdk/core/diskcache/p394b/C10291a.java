package com.kwad.sdk.core.diskcache.p394b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.p393a.C10281a;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11023ap;
import com.kwad.sdk.utils.C11031aw;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kwad.sdk.core.diskcache.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10291a {
    private C10281a auh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10292a {
        static final C10291a aui = new C10291a((byte) 0);
    }

    /* synthetic */ C10291a(byte b) {
        this();
    }

    /* renamed from: Dc */
    public static C10291a m26395Dc() {
        return C10292a.aui;
    }

    /* renamed from: Dd */
    private boolean m26394Dd() {
        init(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext());
        return this.auh == null;
    }

    @Nullable
    /* renamed from: ds */
    private File m26389ds(String str) {
        if (m26394Dd() || TextUtils.isEmpty(str)) {
            return null;
        }
        return C10293b.m26388a(this.auh, str);
    }

    private synchronized void init(Context context) {
        if (this.auh != null || context == null) {
            return;
        }
        try {
            this.auh = C10281a.m26432a(C11031aw.m23996cK(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final boolean m26393a(String str, C10404a.C10405a c10405a) {
        File m26389ds;
        if (!m26394Dd() && !TextUtils.isEmpty(str)) {
            String m26384dt = C10295c.m26384dt(str);
            if (C10293b.m26386a(this.auh, str, m26384dt, c10405a) && (m26389ds = m26389ds(m26384dt)) != null && m26389ds.exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m26392b(String str, @NonNull String str2, C10404a.C10405a c10405a) {
        File m26389ds;
        if (!m26394Dd() && !TextUtils.isEmpty(str)) {
            String m26384dt = C10295c.m26384dt(str2);
            if (C10293b.m26386a(this.auh, str, m26384dt, c10405a) && (m26389ds = m26389ds(m26384dt)) != null && m26389ds.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: bV */
    public final File m26391bV(String str) {
        if (m26394Dd() || TextUtils.isEmpty(str)) {
            return null;
        }
        return m26389ds(C10295c.m26384dt(str));
    }

    public final void delete() {
        if (m26394Dd()) {
            return;
        }
        try {
            this.auh.delete();
        } catch (IOException unused) {
        }
    }

    /* renamed from: dr */
    public final void m26390dr(String str) {
        if (m26394Dd() || TextUtils.isEmpty(str)) {
            return;
        }
        C10293b.m26387a(this.auh, str, C10295c.m26384dt(str));
    }

    public final boolean remove(String str) {
        if (m26394Dd()) {
            return false;
        }
        try {
            C11023ap.m24089ax(str, "cacheKey is not allowed empty");
            return this.auh.remove(C10295c.m26384dt(str));
        } catch (IOException unused) {
            return false;
        }
    }

    private C10291a() {
    }
}
