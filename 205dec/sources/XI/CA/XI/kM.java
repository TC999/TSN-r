package XI.CA.XI;

import android.database.ContentObserver;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class kM extends ContentObserver {
    public int K0;

    /* renamed from: XI  reason: collision with root package name */
    public String f72XI;
    public K0 kM;

    public kM(K0 k02, int i4, String str) {
        super(null);
        this.kM = k02;
        this.K0 = i4;
        this.f72XI = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z3) {
        K0 k02 = this.kM;
        if (k02 != null) {
            k02.K0(this.K0, this.f72XI);
        }
    }
}
