package p000XI.p001CA.p002XI;

import android.database.ContentObserver;

/* renamed from: XI.CA.XI.kM */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0003kM extends ContentObserver {

    /* renamed from: K0 */
    public int f14K0;

    /* renamed from: XI */
    public String f15XI;

    /* renamed from: kM */
    public C0000K0 f16kM;

    public C0003kM(C0000K0 c0000k0, int i, String str) {
        super(null);
        this.f16kM = c0000k0;
        this.f14K0 = i;
        this.f15XI = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C0000K0 c0000k0 = this.f16kM;
        if (c0000k0 != null) {
            c0000k0.m60077K0(this.f14K0, this.f15XI);
        }
    }
}
