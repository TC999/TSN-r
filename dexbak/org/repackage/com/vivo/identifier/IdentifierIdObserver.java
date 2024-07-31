package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* renamed from: org.repackage.com.vivo.identifier.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: d */
    private static final String f44270d = "VMS_SDK_Observer";

    /* renamed from: a */
    private String f44271a;

    /* renamed from: b */
    private int f44272b;

    /* renamed from: c */
    private IdentifierIdClient f44273c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        this.f44273c = identifierIdClient;
        this.f44272b = i;
        this.f44271a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.f44273c;
        if (identifierIdClient != null) {
            identifierIdClient.m2714l(this.f44272b, this.f44271a);
        } else {
            Log.e(f44270d, "mIdentifierIdClient is null");
        }
    }
}
