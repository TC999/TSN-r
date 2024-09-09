package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IdentifierIdObserver.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d extends ContentObserver {

    /* renamed from: d  reason: collision with root package name */
    private static final String f61671d = "VMS_SDK_Observer";

    /* renamed from: a  reason: collision with root package name */
    private String f61672a;

    /* renamed from: b  reason: collision with root package name */
    private int f61673b;

    /* renamed from: c  reason: collision with root package name */
    private c f61674c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, int i4, String str) {
        super(null);
        this.f61674c = cVar;
        this.f61673b = i4;
        this.f61672a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z3) {
        c cVar = this.f61674c;
        if (cVar != null) {
            cVar.l(this.f61673b, this.f61672a);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
