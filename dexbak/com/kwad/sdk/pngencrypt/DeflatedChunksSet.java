package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.core.p397e.C10331c;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DeflatedChunksSet {
    protected byte[] aKG;
    private int aKH;
    private int aKI;
    private int aKJ;
    State aKK;
    private final boolean aKL;
    private AbstractC10923d aKM;
    private long aKN;
    private long aKO;
    int aKP;
    int aKQ;
    public final String aKR;
    protected final boolean aKq;
    private Inflater inf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
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

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aKK = state;
        this.aKN = 0L;
        this.aKO = 0L;
        this.aKP = -1;
        this.aKQ = -1;
        this.aKR = str;
        this.aKq = z;
        this.aKI = i;
        if (i > 0 && i2 >= i) {
            if (inflater != null) {
                this.inf = inflater;
                this.aKL = false;
            } else {
                this.inf = new Inflater();
                this.aKL = true;
            }
            this.aKG = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
            this.aKJ = -1;
            this.aKK = state;
            try {
                m24539dE(i);
                return;
            } catch (RuntimeException e) {
                close();
                throw e;
            }
        }
        throw new PngjException("bad inital row len " + i);
    }

    /* renamed from: JM */
    private boolean m24544JM() {
        State state;
        int i;
        try {
            if (this.aKK == State.ROW_READY) {
                C10331c.printStackTrace(new PngjException("invalid state"));
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
                    int i2 = this.aKH;
                    i = inflater.inflate(bArr2, i2, this.aKI - i2);
                } catch (DataFormatException e) {
                    C10331c.printStackTrace(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.aKH += i;
                this.aKO += i;
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
                mo24439JN();
                return true;
            }
            return false;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: JN */
    public void mo24439JN() {
    }

    /* renamed from: JO */
    protected int mo24438JO() {
        throw new PngjException("not implemented");
    }

    /* renamed from: JP */
    public final void m24543JP() {
        if (isDone()) {
            return;
        }
        this.aKK = State.DONE;
    }

    /* renamed from: JQ */
    public final int m24542JQ() {
        return this.aKJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m24541a(AbstractC10923d abstractC10923d) {
        if (!this.aKR.equals(abstractC10923d.m24546Jz().ahi)) {
            C10331c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + abstractC10923d.m24546Jz().ahi + ", expected:" + this.aKR));
        }
        this.aKM = abstractC10923d;
        int i = this.aKP + 1;
        this.aKP = i;
        int i2 = this.aKQ;
        if (i2 >= 0) {
            abstractC10923d.m24453dD(i + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m24540c(byte[] bArr, int i, int i2) {
        this.aKN += i2;
        if (i2 <= 0 || this.aKK.isDone()) {
            return;
        }
        if (this.aKK == State.ROW_READY) {
            C10331c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (!this.inf.needsDictionary() && this.inf.needsInput()) {
            this.inf.setInput(bArr, i, i2);
            if (this.aKq) {
                while (m24544JM()) {
                    m24539dE(mo24438JO());
                    isDone();
                }
                return;
            }
            m24544JM();
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

    /* renamed from: dE */
    public final void m24539dE(int i) {
        this.aKH = 0;
        this.aKJ++;
        if (i <= 0) {
            this.aKI = 0;
            m24543JP();
        } else if (this.inf.finished()) {
            this.aKI = 0;
            m24543JP();
        } else {
            this.aKK = State.WAITING_FOR_INPUT;
            this.aKI = i;
            if (this.aKq) {
                return;
            }
            m24544JM();
        }
    }

    /* renamed from: gh */
    public final boolean m24538gh(String str) {
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
        return new StringBuilder("idatSet : " + this.aKM.m24546Jz().ahi + " state=" + this.aKK + " rows=" + this.aKJ + " bytes=" + this.aKN + "/" + this.aKO).toString();
    }
}
