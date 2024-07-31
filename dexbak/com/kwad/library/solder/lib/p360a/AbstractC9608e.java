package com.kwad.library.solder.lib.p360a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p362c.C9616a;
import com.kwad.library.solder.lib.p362c.C9617b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.kwad.library.solder.lib.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9608e<P extends AbstractC9604a> {
    protected String aiR;
    protected int ajA;
    protected String ajC;
    protected String ajD;
    protected boolean ajE;
    protected P ajF;
    protected InterfaceC9629b ajG;
    protected Throwable ajH;
    protected String ajI;
    protected boolean ajJ;
    protected long ajK;
    protected String ajL;
    protected List<C9616a> ajM;
    protected C9617b ajN;
    protected InterfaceC9607d ajh;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int ajz = 0;
    private final byte[] ajw = new byte[0];
    protected StringBuffer ajB = new StringBuffer(String.valueOf(-1));

    public AbstractC9608e(C9617b c9617b) {
        this.ajN = c9617b;
        this.aiR = c9617b.akf;
        this.mVersion = c9617b.version;
        this.ajL = c9617b.aki;
        this.ajJ = c9617b.ajJ;
        this.ajI = c9617b.ajI;
        this.ajK = c9617b.akh;
        this.mDownloadUrl = c9617b.akg;
    }

    /* renamed from: b */
    private List<C9616a> m28238b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.ajh.mo28174xb().mo28205bF(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.ajh.mo28174xb().mo28208a(str, str4, str3)) {
                            C9616a c9616a = new C9616a();
                            c9616a.akf = str;
                            c9616a.version = str4;
                            c9616a.f29488qs = true;
                            arrayList.add(c9616a);
                        } else {
                            this.ajh.mo28174xb().mo28212D(str, str4);
                        }
                    } else {
                        this.ajh.mo28174xb().mo28212D(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final AbstractC9608e m28240a(InterfaceC9607d interfaceC9607d) {
        this.ajh = interfaceC9607d;
        return this;
    }

    /* renamed from: bI */
    public final void m28237bI(String str) {
        this.mVersion = str;
    }

    /* renamed from: bL */
    public final AbstractC9608e m28236bL(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.ajB;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    /* renamed from: bM */
    public final void m28235bM(String str) {
        this.ajC = str;
    }

    /* renamed from: bN */
    public final void m28234bN(String str) {
        this.ajD = str;
    }

    /* renamed from: bO */
    public abstract P mo28214bO(String str);

    /* renamed from: bO */
    public final AbstractC9608e m28233bO(int i) {
        synchronized (this.ajw) {
            this.mState = i;
        }
        return m28236bL(String.valueOf(i));
    }

    /* renamed from: bP */
    public final void m28232bP(int i) {
        if (i > 0) {
            this.ajA = i;
        }
    }

    /* renamed from: c */
    public final void m28231c(P p) {
        this.ajF = p;
    }

    public final void cancel() {
        synchronized (this.ajw) {
            m28233bO(0);
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i;
        synchronized (this.ajw) {
            i = this.mState;
        }
        return i;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    /* renamed from: j */
    public final AbstractC9608e m28230j(@NonNull Throwable th) {
        this.ajH = th;
        return m28236bL(th.getLocalizedMessage());
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.aiR + "'}";
    }

    /* renamed from: xl */
    public final InterfaceC9607d m28229xl() {
        return this.ajh;
    }

    /* renamed from: xm */
    public final String m28228xm() {
        return this.ajB.toString();
    }

    @Nullable
    /* renamed from: xn */
    public final Throwable m28227xn() {
        return this.ajH;
    }

    /* renamed from: xo */
    public final boolean m28226xo() {
        m28233bO(-1);
        this.ajM = null;
        int i = this.ajz + 1;
        this.ajz = i;
        return i <= this.ajA;
    }

    @Nullable
    /* renamed from: xp */
    public final String m28225xp() {
        return this.aiR;
    }

    /* renamed from: xq */
    public final boolean m28224xq() {
        return this.ajE;
    }

    /* renamed from: xr */
    public final int m28223xr() {
        return this.ajz;
    }

    @Nullable
    /* renamed from: xs */
    public final String m28222xs() {
        if (!TextUtils.isEmpty(this.ajC)) {
            return this.ajC;
        }
        return this.ajD;
    }

    @Nullable
    /* renamed from: xt */
    public final InterfaceC9629b m28221xt() {
        return this.ajG;
    }

    /* renamed from: xu */
    public final boolean m28220xu() {
        return this.ajJ;
    }

    /* renamed from: xv */
    public final String m28219xv() {
        return this.ajI;
    }

    /* renamed from: xw */
    public final String m28218xw() {
        return this.ajL;
    }

    /* renamed from: xx */
    public final C9617b m28217xx() {
        return this.ajN;
    }

    /* renamed from: xy */
    public final List<C9616a> m28216xy() {
        String m28225xp = m28225xp();
        if (!TextUtils.isEmpty(m28225xp) && this.ajM == null) {
            this.ajM = m28238b(m28225xp, getVersion(), m28218xw());
        }
        return this.ajM;
    }

    /* renamed from: a */
    public final void m28239a(InterfaceC9629b interfaceC9629b) {
        this.ajG = interfaceC9629b;
    }
}
