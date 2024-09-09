package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j extends DeflatedChunksSet {
    protected final e aKn;
    protected byte[] aLh;
    protected byte[] aLi;
    protected final k aLj;
    final p aLk;
    protected int[] aLl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
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

    public j(String str, boolean z3, k kVar, e eVar) {
        this(str, z3, kVar, eVar, null, null);
    }

    private void JZ() {
        dI(this.aLk.aLR);
    }

    private int Ka() {
        int JY;
        e eVar = this.aKn;
        int i4 = 0;
        if (eVar == null) {
            int JQ = JQ();
            k kVar = this.aLj;
            if (JQ < kVar.aKU - 1) {
                JY = kVar.aLv;
                i4 = JY + 1;
            }
        } else if (eVar.JR()) {
            JY = this.aKn.JY();
            i4 = JY + 1;
        }
        if (!this.aKq) {
            dE(i4);
        }
        return i4;
    }

    private void dI(int i4) {
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
        byte b4 = this.aKG[0];
        if (FilterType.isValidStandard(b4)) {
            FilterType byVal = FilterType.getByVal(b4);
            int[] iArr = this.aLl;
            iArr[b4] = iArr[b4] + 1;
            this.aLh[0] = this.aKG[0];
            int i5 = AnonymousClass1.aLm[byVal.ordinal()];
            if (i5 == 1) {
                dK(i4);
                return;
            } else if (i5 == 2) {
                dM(i4);
                return;
            } else if (i5 == 3) {
                dN(i4);
                return;
            } else if (i5 == 4) {
                dJ(i4);
                return;
            } else if (i5 == 5) {
                dL(i4);
                return;
            } else {
                throw new PngjException("Filter type " + ((int) b4) + " not implemented");
            }
        }
        throw new PngjException("Filter type " + ((int) b4) + " invalid");
    }

    private void dJ(int i4) {
        int i5 = 1;
        int i6 = 1 - this.aLj.aLu;
        while (i5 <= i4) {
            this.aLh[i5] = (byte) (this.aKG[i5] + (((i6 > 0 ? this.aLh[i6] & 255 : 0) + (this.aLi[i5] & 255)) / 2));
            i5++;
            i6++;
        }
    }

    private void dK(int i4) {
        for (int i5 = 1; i5 <= i4; i5++) {
            this.aLh[i5] = this.aKG[i5];
        }
    }

    private void dL(int i4) {
        int i5 = 1;
        int i6 = 1 - this.aLj.aLu;
        while (i5 <= i4) {
            int i7 = 0;
            int i8 = i6 > 0 ? this.aLh[i6] & 255 : 0;
            if (i6 > 0) {
                i7 = this.aLi[i6] & 255;
            }
            this.aLh[i5] = (byte) (this.aKG[i5] + n.b(i8, this.aLi[i5] & 255, i7));
            i5++;
            i6++;
        }
    }

    private void dM(int i4) {
        int i5;
        int i6 = 1;
        while (true) {
            i5 = this.aLj.aLu;
            if (i6 > i5) {
                break;
            }
            this.aLh[i6] = this.aKG[i6];
            i6++;
        }
        int i7 = i5 + 1;
        int i8 = 1;
        while (i7 <= i4) {
            byte[] bArr = this.aLh;
            bArr[i7] = (byte) (this.aKG[i7] + bArr[i8]);
            i7++;
            i8++;
        }
    }

    private void dN(int i4) {
        for (int i5 = 1; i5 <= i4; i5++) {
            this.aLh[i5] = (byte) (this.aKG[i5] + this.aLi[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void JN() {
        super.JN();
        this.aLk.update(JQ());
        JZ();
        p pVar = this.aLk;
        pVar.h(this.aLh, pVar.aLR + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int JO() {
        return Ka();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aLh = null;
        this.aLi = null;
    }

    private j(String str, boolean z3, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z3, (eVar != null ? eVar.JY() : kVar.aLv) + 1, kVar.aLv + 1, null, null);
        this.aLl = new int[5];
        this.aLj = kVar;
        this.aKn = eVar;
        this.aLk = new p(kVar, eVar);
        com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "Creating IDAT set ");
    }
}
