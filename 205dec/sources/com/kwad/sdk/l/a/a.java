package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements c {
    protected List<c> aMR;
    protected boolean enabled;

    public a(boolean z3) {
        this.enabled = z3;
    }

    private List<c> getChildren() {
        return this.aMR;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean bA(Context context) {
        if (this.enabled) {
            List<c> children = getChildren();
            if (children != null && children.size() > 0) {
                for (c cVar : children) {
                    if (cVar.bA(context)) {
                        return true;
                    }
                }
                return false;
            }
            try {
                return bB(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    protected boolean bB(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
