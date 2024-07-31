package com.kwad.library.solder.lib.ext;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;

/* renamed from: com.kwad.library.solder.lib.ext.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9633c {
    private final int ajA;
    private final String ajO;
    private final String ajP;
    private final String ajQ;
    private final String ajR;
    private final String ajS;
    private final String ajT;
    private final String ajU;
    private final boolean ajV;
    private final boolean ajW;
    private final boolean ajX;
    private ExecutorService ajY;
    private String ajZ;
    private byte[] aka;
    private boolean akb;
    private int akc;

    /* renamed from: com.kwad.library.solder.lib.ext.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9634a {
        private static final String akd;
        private String ajU;
        private boolean ajX;
        private ExecutorService ajY;
        private String ajZ;
        private byte[] aka;
        private boolean akb;
        private int ake;
        private int ajA = 3;
        private String ajO = "sodler";
        private String ajP = "code-cache";
        private String ajQ = "lib";
        private String ajR = "temp";
        private String ajT = akd;
        private String ajS = ".tmp";
        private boolean ajW = false;
        private boolean ajV = false;

        static {
            akd = Build.VERSION.SDK_INT == 30 ? "base-1_apk" : "base-1.apk";
        }

        /* renamed from: a */
        public final C9634a m28146a(ExecutorService executorService) {
            this.ajY = executorService;
            return this;
        }

        /* renamed from: bP */
        public final C9634a m28145bP(@NonNull String str) {
            this.ajO = str;
            return this;
        }

        /* renamed from: bQ */
        public final C9634a m28144bQ(int i) {
            if (i > 0) {
                this.ajA = i;
            }
            return this;
        }

        /* renamed from: bR */
        public final C9634a m28143bR(int i) {
            this.ake = i;
            return this;
        }

        /* renamed from: bh */
        public final C9634a m28142bh(boolean z) {
            this.akb = false;
            return this;
        }

        /* renamed from: bi */
        public final C9634a m28141bi(boolean z) {
            this.ajX = z;
            return this;
        }

        /* renamed from: xJ */
        public final C9633c m28140xJ() {
            return new C9633c(this.ajV, this.ajW, this.ajU, this.ajO, this.ajP, this.ajQ, this.ajR, this.ajS, this.ajT, this.ajA, this.ajZ, this.aka, this.akb, this.ajX, this.ajY, this.ake, (byte) 0);
        }
    }

    /* synthetic */ C9633c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService, i2);
    }

    public final int getRetryCount() {
        return this.ajA;
    }

    /* renamed from: xA */
    public final String m28156xA() {
        return this.ajO;
    }

    /* renamed from: xB */
    public final String m28155xB() {
        return this.ajP;
    }

    /* renamed from: xC */
    public final String m28154xC() {
        return this.ajQ;
    }

    /* renamed from: xD */
    public final String m28153xD() {
        return this.ajR;
    }

    /* renamed from: xE */
    public final String m28152xE() {
        return this.ajS;
    }

    /* renamed from: xF */
    public final String m28151xF() {
        return this.ajT;
    }

    /* renamed from: xG */
    public final boolean m28150xG() {
        return this.ajW;
    }

    /* renamed from: xH */
    public final boolean m28149xH() {
        return this.ajX;
    }

    /* renamed from: xI */
    public final ExecutorService m28148xI() {
        return this.ajY;
    }

    /* renamed from: xz */
    public final int m28147xz() {
        return this.akc;
    }

    private C9633c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2) {
        this.ajA = i;
        this.ajO = str2;
        this.ajP = str3;
        this.ajQ = str4;
        this.ajR = str5;
        this.ajS = str6;
        this.ajT = str7;
        this.ajU = str;
        this.ajV = z;
        this.ajW = z2;
        this.ajZ = str8;
        this.aka = bArr;
        this.akb = z3;
        this.ajX = z4;
        this.ajY = executorService;
        this.akc = i2;
    }
}
