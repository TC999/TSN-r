package com.kwad.sdk.pngencrypt;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DeflatedChunksSet {
    protected byte[] aKG;
    private int aKH;
    private int aKI;
    private int aKJ;
    State aKK;
    private final boolean aKL;
    private d aKM;
    private long aKN;
    private long aKO;
    int aKP;
    int aKQ;
    public final String aKR;
    protected final boolean aKq;
    private Inflater inf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z3, int i4, int i5, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aKK = state;
        this.aKN = 0L;
        this.aKO = 0L;
        this.aKP = -1;
        this.aKQ = -1;
        this.aKR = str;
        this.aKq = z3;
        this.aKI = i4;
        if (i4 > 0 && i5 >= i4) {
            if (inflater != null) {
                this.inf = inflater;
                this.aKL = false;
            } else {
                this.inf = new Inflater();
                this.aKL = true;
            }
            this.aKG = (bArr == null || bArr.length < i4) ? new byte[i5] : bArr;
            this.aKJ = -1;
            this.aKK = state;
            try {
                dE(i4);
                return;
            } catch (RuntimeException e4) {
                close();
                throw e4;
            }
        }
        throw new PngjException("bad inital row len " + i4);
    }

    private boolean JM() {
        State state;
        int i4;
        try {
            if (this.aKK == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("invalid state"));
            }
            if (this.aKK.isDone()) {
                return false;
            }
            byte[] bArr = this.aKG;
            if (bArr == null || bArr.length < this.aKI) {
                this.aKG = new byte[this.aKI];
            }
            if (this.aKH < this.aKI && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aKG;
                    int i5 = this.aKH;
                    i4 = inflater.inflate(bArr2, i5, this.aKI - i5);
                } catch (DataFormatException e4) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("error decompressing zlib stream ", e4));
                    i4 = 0;
                }
                this.aKH += i4;
                this.aKO += i4;
            }
            if (this.aKH == this.aKI) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.aKH > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.aKK = state;
            if (state == State.ROW_READY) {
                JN();
                return true;
            }
            return false;
        } catch (RuntimeException e5) {
            close();
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JN() {
    }

    protected int JO() {
        throw new PngjException("not implemented");
    }

    public final void JP() {
        if (isDone()) {
            return;
        }
        this.aKK = State.DONE;
    }

    public final int JQ() {
        return this.aKJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(d dVar) {
        if (!this.aKR.equals(dVar.Jz().ahi)) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Jz().ahi + ", expected:" + this.aKR));
        }
        this.aKM = dVar;
        int i4 = this.aKP + 1;
        this.aKP = i4;
        int i5 = this.aKQ;
        if (i5 >= 0) {
            dVar.dD(i4 + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(byte[] bArr, int i4, int i5) {
        this.aKN += i5;
        if (i5 <= 0 || this.aKK.isDone()) {
            return;
        }
        if (this.aKK == State.ROW_READY) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (!this.inf.needsDictionary() && this.inf.needsInput()) {
            this.inf.setInput(bArr, i4, i5);
            if (this.aKq) {
                while (JM()) {
                    dE(JO());
                    isDone();
                }
                return;
            }
            JM();
            return;
        }
        throw new RuntimeException("should not happen");
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aKK.isClosed()) {
                this.aKK = State.CLOSED;
            }
            if (!this.aKL || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void dE(int i4) {
        this.aKH = 0;
        this.aKJ++;
        if (i4 <= 0) {
            this.aKI = 0;
            JP();
        } else if (this.inf.finished()) {
            this.aKI = 0;
            JP();
        } else {
            this.aKK = State.WAITING_FOR_INPUT;
            this.aKI = i4;
            if (this.aKq) {
                return;
            }
            JM();
        }
    }

    public final boolean gh(String str) {
        if (this.aKK.isClosed()) {
            return false;
        }
        if (str.equals(this.aKR)) {
            return true;
        }
        if (this.aKK.isDone()) {
            if (!this.aKK.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aKR + " set is not done");
    }

    public final boolean isClosed() {
        return this.aKK.isClosed();
    }

    public final boolean isDone() {
        return this.aKK.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aKM.Jz().ahi + " state=" + this.aKK + " rows=" + this.aKJ + " bytes=" + this.aKN + TTPathConst.sSeparator + this.aKO).toString();
    }
}
