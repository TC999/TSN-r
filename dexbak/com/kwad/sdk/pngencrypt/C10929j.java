package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import java.util.Arrays;
import java.util.zip.Inflater;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.pngencrypt.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10929j extends DeflatedChunksSet {
    protected final C10924e aKn;
    protected byte[] aLh;
    protected byte[] aLi;
    protected final C10931k aLj;
    final C10939p aLk;
    protected int[] aLl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.pngencrypt.j$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static /* synthetic */ class C109301 {
        static final /* synthetic */ int[] aLm;

        static {
            int[] iArr = new int[FilterType.values().length];
            aLm = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aLm[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aLm[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aLm[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aLm[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C10929j(String str, boolean z, C10931k c10931k, C10924e c10924e) {
        this(str, z, c10931k, c10924e, null, null);
    }

    /* renamed from: JZ */
    private void m24437JZ() {
        m24435dI(this.aLk.aLR);
    }

    /* renamed from: Ka */
    private int m24436Ka() {
        int m24445JY;
        C10924e c10924e = this.aKn;
        int i = 0;
        if (c10924e == null) {
            int m24542JQ = m24542JQ();
            C10931k c10931k = this.aLj;
            if (m24542JQ < c10931k.aKU - 1) {
                m24445JY = c10931k.aLv;
                i = m24445JY + 1;
            }
        } else if (c10924e.m24452JR()) {
            m24445JY = this.aKn.m24445JY();
            i = m24445JY + 1;
        }
        if (!this.aKq) {
            m24539dE(i);
        }
        return i;
    }

    /* renamed from: dI */
    private void m24435dI(int i) {
        byte[] bArr = this.aLh;
        if (bArr == null || bArr.length < this.aKG.length) {
            byte[] bArr2 = this.aKG;
            this.aLh = new byte[bArr2.length];
            this.aLi = new byte[bArr2.length];
        }
        if (this.aLk.aLO == 0) {
            Arrays.fill(this.aLh, (byte) 0);
        }
        byte[] bArr3 = this.aLh;
        this.aLh = this.aLi;
        this.aLi = bArr3;
        byte b = this.aKG[0];
        if (FilterType.isValidStandard(b)) {
            FilterType byVal = FilterType.getByVal(b);
            int[] iArr = this.aLl;
            iArr[b] = iArr[b] + 1;
            this.aLh[0] = this.aKG[0];
            int i2 = C109301.aLm[byVal.ordinal()];
            if (i2 == 1) {
                m24433dK(i);
                return;
            } else if (i2 == 2) {
                m24431dM(i);
                return;
            } else if (i2 == 3) {
                m24430dN(i);
                return;
            } else if (i2 == 4) {
                m24434dJ(i);
                return;
            } else if (i2 == 5) {
                m24432dL(i);
                return;
            } else {
                throw new PngjException("Filter type " + ((int) b) + " not implemented");
            }
        }
        throw new PngjException("Filter type " + ((int) b) + " invalid");
    }

    /* renamed from: dJ */
    private void m24434dJ(int i) {
        int i2 = 1;
        int i3 = 1 - this.aLj.aLu;
        while (i2 <= i) {
            this.aLh[i2] = (byte) (this.aKG[i2] + (((i3 > 0 ? this.aLh[i3] & UByte.f41242c : 0) + (this.aLi[i2] & UByte.f41242c)) / 2));
            i2++;
            i3++;
        }
    }

    /* renamed from: dK */
    private void m24433dK(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aLh[i2] = this.aKG[i2];
        }
    }

    /* renamed from: dL */
    private void m24432dL(int i) {
        int i2 = 1;
        int i3 = 1 - this.aLj.aLu;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.aLh[i3] & UByte.f41242c : 0;
            if (i3 > 0) {
                i4 = this.aLi[i3] & UByte.f41242c;
            }
            this.aLh[i2] = (byte) (this.aKG[i2] + C10936n.m24425b(i5, this.aLi[i2] & UByte.f41242c, i4));
            i2++;
            i3++;
        }
    }

    /* renamed from: dM */
    private void m24431dM(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.aLj.aLu;
            if (i3 > i2) {
                break;
            }
            this.aLh[i3] = this.aKG[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.aLh;
            bArr[i4] = (byte) (this.aKG[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    /* renamed from: dN */
    private void m24430dN(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aLh[i2] = (byte) (this.aKG[i2] + this.aLi[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    /* renamed from: JN */
    public final void mo24439JN() {
        super.mo24439JN();
        this.aLk.update(m24542JQ());
        m24437JZ();
        C10939p c10939p = this.aLk;
        c10939p.m24409h(this.aLh, c10939p.aLR + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    /* renamed from: JO */
    protected final int mo24438JO() {
        return m24436Ka();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aLh = null;
        this.aLi = null;
    }

    private C10929j(String str, boolean z, C10931k c10931k, C10924e c10924e, Inflater inflater, byte[] bArr) {
        super(str, z, (c10924e != null ? c10924e.m24445JY() : c10931k.aLv) + 1, c10931k.aLv + 1, null, null);
        this.aLl = new int[5];
        this.aLj = c10931k;
        this.aKn = c10924e;
        this.aLk = new C10939p(c10931k, c10924e);
        C10331c.m26254d("PNG_ENCRYPT", "Creating IDAT set ");
    }
}
