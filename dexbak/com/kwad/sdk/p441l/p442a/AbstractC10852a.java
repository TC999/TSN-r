package com.kwad.sdk.p441l.p442a;

import android.content.Context;
import java.util.List;

/* renamed from: com.kwad.sdk.l.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10852a implements InterfaceC10854c {
    protected List<InterfaceC10854c> aMR;
    protected boolean enabled;

    public AbstractC10852a(boolean z) {
        this.enabled = z;
    }

    private List<InterfaceC10854c> getChildren() {
        return this.aMR;
    }

    @Override // com.kwad.sdk.p441l.p442a.InterfaceC10854c
    /* renamed from: bA */
    public final boolean mo24639bA(Context context) {
        if (this.enabled) {
            List<InterfaceC10854c> children = getChildren();
            if (children != null && children.size() > 0) {
                for (InterfaceC10854c interfaceC10854c : children) {
                    if (interfaceC10854c.mo24639bA(context)) {
                        return true;
                    }
                }
                return false;
            }
            try {
                return mo23763bB(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: bB */
    protected boolean mo23763bB(Context context) {
        return false;
    }

    public AbstractC10852a() {
        this.enabled = true;
    }
}
