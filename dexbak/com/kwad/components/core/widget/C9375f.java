package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.core.widget.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9375f extends FrameLayout {
    private boolean acs;

    /* renamed from: iD */
    protected boolean f29464iD;

    /* renamed from: if */
    protected InterfaceC9376g f29465if;
    @NonNull
    protected Context mContext;

    public C9375f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.f29464iD = C11015ai.m24123LZ();
    }

    /* renamed from: tu */
    private void m28872tu() {
        boolean m24123LZ = C11015ai.m24123LZ();
        if (!this.acs || m24123LZ == this.f29464iD) {
            return;
        }
        this.f29464iD = m24123LZ;
        InterfaceC9376g interfaceC9376g = this.f29465if;
        if (interfaceC9376g != null) {
            interfaceC9376g.mo28871j(!m24123LZ);
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m28872tu();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.acs = i == 0;
        m28872tu();
    }

    public final void setOrientationChangeListener(InterfaceC9376g interfaceC9376g) {
        this.f29465if = interfaceC9376g;
    }
}
