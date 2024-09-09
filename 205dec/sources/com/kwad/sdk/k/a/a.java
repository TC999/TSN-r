package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class a implements c {
    protected List<c> aNY;
    protected boolean enabled;

    public a(boolean z3) {
        this.enabled = z3;
    }

    private List<c> getChildren() {
        return this.aNY;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean bN(Context context) {
        if (this.enabled) {
            List<c> children = getChildren();
            if (children != null && children.size() > 0) {
                for (c cVar : children) {
                    if (cVar.bN(context)) {
                        return true;
                    }
                }
                return false;
            }
            try {
                return bO(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    protected boolean bO(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
