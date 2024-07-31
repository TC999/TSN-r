package com.p201hw.videoprocessor.jssrc;

import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* renamed from: com.hw.videoprocessor.jssrc.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SSRC {

    /* renamed from: q */
    private static final String f24096q = "1.30";

    /* renamed from: r */
    private static final int f24097r = 65536;

    /* renamed from: w */
    private static final int f24102w = 97;

    /* renamed from: y */
    static final /* synthetic */ boolean f24104y = false;

    /* renamed from: a */
    private ByteOrder f24105a;

    /* renamed from: b */
    private SplitRadixFft f24106b;

    /* renamed from: c */
    private double f24107c;

    /* renamed from: d */
    private double f24108d;

    /* renamed from: e */
    private int f24109e;

    /* renamed from: f */
    private double[][] f24110f;

    /* renamed from: g */
    private int f24111g;

    /* renamed from: h */
    private int f24112h;

    /* renamed from: i */
    private int f24113i;

    /* renamed from: j */
    private int f24114j;

    /* renamed from: k */
    private double[] f24115k;

    /* renamed from: l */
    private int f24116l;

    /* renamed from: m */
    private boolean f24117m;

    /* renamed from: n */
    private int f24118n;

    /* renamed from: o */
    private long f24119o;

    /* renamed from: p */
    private long f24120p;

    /* renamed from: s */
    private static final int[] f24098s = {0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};

    /* renamed from: t */
    private static final int[] f24099t = {1, 16, 20, 16, 16, 15, 16, 15};

    /* renamed from: u */
    private static final int[] f24100u = {8, 18, 27, 8, 8, 8, 10, 9};

    /* renamed from: v */
    private static final double[][] f24101v = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* renamed from: x */
    private static final double[] f24103x = {0.7d, 0.9d, 0.18d};

    public SSRC() {
        this.f24105a = ByteOrder.LITTLE_ENDIAN;
        this.f24106b = new SplitRadixFft();
        this.f24107c = 170.0d;
        this.f24108d = 100.0d;
        this.f24109e = 65536;
        this.f24117m = false;
    }

    /* renamed from: a */
    private int m34982a(double d) {
        return (int) (d >= Utils.DOUBLE_EPSILON ? d + 0.5d : d - 0.5d);
    }

    /* renamed from: b */
    private double m34981b(double d) {
        if (d <= 21.0d) {
            return Utils.DOUBLE_EPSILON;
        }
        if (d <= 50.0d) {
            double d2 = d - 21.0d;
            return (Math.pow(d2, 0.4d) * 0.5842d) + (d2 * 0.07886d);
        }
        return (d - 8.7d) * 0.1102d;
    }

    /* renamed from: e */
    private void m34978e(int i) {
        throw new IllegalStateException("unknown error " + i);
    }

    /* renamed from: f */
    private int m34977f(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    /* renamed from: h */
    private double m34975h(int i, double d, double d2) {
        double d3 = 1.0d / d2;
        double d4 = 6.283185307179586d * d;
        double d5 = i;
        Double.isNaN(d5);
        return d * 2.0d * d3 * m34968o(d5 * d4 * d3);
    }

    /* renamed from: j */
    public static void m34973j(String[] strArr) throws Exception {
        new SSRC(strArr);
    }

    /* renamed from: l */
    private void m34971l(int i) {
    }

    /* renamed from: m */
    private void m34970m() {
        this.f24119o = System.currentTimeMillis();
        this.f24120p = 0L;
        this.f24118n = -1;
    }

    /* renamed from: n */
    private void m34969n(double d) {
        int i;
        if (this.f24117m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f24119o;
        if (d == Utils.DOUBLE_EPSILON) {
            i = 0;
        } else {
            double d2 = currentTimeMillis;
            Double.isNaN(d2);
            i = (int) ((d2 * (1.0d - d)) / d);
        }
        int i2 = (int) (d * 100.0d);
        if (i2 != this.f24118n || currentTimeMillis != this.f24120p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i2));
            this.f24118n = i2;
        }
        if (currentTimeMillis != this.f24120p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
            this.f24120p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    /* renamed from: o */
    private double m34968o(double d) {
        if (d == Utils.DOUBLE_EPSILON) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    /* renamed from: q */
    private void m34966q() {
        System.err.printf("http://shibatch.sourceforge.net/\n\n", new Object[0]);
        System.err.printf("usage: ssrc [<options>] <source wav file> <destination wav file>\n", new Object[0]);
        System.err.printf("options : --rate <sampling rate>     output sample rate\n", new Object[0]);
        System.err.printf("          --att <attenuation(dB)>    attenuate signal\n", new Object[0]);
        System.err.printf("          --bits <number of bits>    output quantization bit length\n", new Object[0]);
        System.err.printf("          --tmpfile <file name>      specify temporal file\n", new Object[0]);
        System.err.printf("          --twopass                  two pass processing to avoid clipping\n", new Object[0]);
        System.err.printf("          --normalize                normalize the wave file\n", new Object[0]);
        System.err.printf("          --quiet                    nothing displayed except error\n", new Object[0]);
        System.err.printf("          --dither [<type>]          dithering\n", new Object[0]);
        System.err.printf("                                       0 : no dither\n", new Object[0]);
        System.err.printf("                                       1 : no noise shaping\n", new Object[0]);
        System.err.printf("                                       2 : triangular spectral shape\n", new Object[0]);
        System.err.printf("                                       3 : ATH based noise shaping\n", new Object[0]);
        System.err.printf("                                       4 : less dither amplitude than type 3\n", new Object[0]);
        System.err.printf("          --pdf <type> [<amp>]       select p.d.f. of noise\n", new Object[0]);
        System.err.printf("                                       0 : rectangular\n", new Object[0]);
        System.err.printf("                                       1 : triangular\n", new Object[0]);
        System.err.printf("                                       2 : Gaussian\n", new Object[0]);
        System.err.printf("          --profile <type>           specify profile\n", new Object[0]);
        System.err.printf("                                       standard : the default quality\n", new Object[0]);
        System.err.printf("                                       fast     : fast, not so bad quality\n", new Object[0]);
    }

    /* renamed from: r */
    private double m34965r(double d, int i, double d2, double d3) {
        double d4 = 4.0d * d * d;
        double d5 = i;
        Double.isNaN(d5);
        double d6 = d5 - 1.0d;
        return I0Bessel.m34983a(d2 * Math.sqrt(1.0d - (d4 / (d6 * d6)))) / d3;
    }

    /* renamed from: c */
    public int m34980c(double d, double[] dArr, int i, int i2) {
        int i3;
        double m34982a;
        if (i == 1) {
            double[] dArr2 = this.f24115k;
            int i4 = this.f24116l;
            this.f24116l = i4 + 1;
            double d2 = d + dArr2[i4 & 65535];
            int i5 = this.f24113i;
            if (d2 < i5) {
                double d3 = i5;
                Double.isNaN(d3);
                double d4 = d2 / d3;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d2 = i5;
            }
            int i6 = this.f24114j;
            if (d2 > i6) {
                double d5 = i6;
                Double.isNaN(d5);
                double d6 = d2 / d5;
                if (dArr[0] >= d6) {
                    d6 = dArr[0];
                }
                dArr[0] = d6;
                d2 = i6;
            }
            return m34982a(d2);
        }
        double d7 = Utils.DOUBLE_EPSILON;
        int i7 = 0;
        while (true) {
            i3 = this.f24112h;
            if (i7 >= i3) {
                break;
            }
            d7 += f24101v[this.f24111g][i7] * this.f24110f[i2][i7];
            i7++;
        }
        double d8 = d + d7;
        double[] dArr3 = this.f24115k;
        int i8 = this.f24116l;
        this.f24116l = i8 + 1;
        double d9 = dArr3[65535 & i8] + d8;
        for (int i9 = i3 - 2; i9 >= 0; i9--) {
            double[][] dArr4 = this.f24110f;
            dArr4[i2][i9 + 1] = dArr4[i2][i9];
        }
        int i10 = this.f24113i;
        if (d9 < i10) {
            double d10 = i10;
            Double.isNaN(d10);
            double d11 = d9 / d10;
            if (dArr[0] >= d11) {
                d11 = dArr[0];
            }
            dArr[0] = d11;
            m34982a = i10;
            double[][] dArr5 = this.f24110f;
            double[] dArr6 = dArr5[i2];
            Double.isNaN(m34982a);
            dArr6[0] = m34982a - d8;
            if (dArr5[i2][0] > 1.0d) {
                dArr5[i2][0] = 1.0d;
            }
            if (dArr5[i2][0] < -1.0d) {
                dArr5[i2][0] = -1.0d;
            }
        } else {
            int i11 = this.f24114j;
            if (d9 > i11) {
                double d12 = i11;
                Double.isNaN(d12);
                double d13 = d9 / d12;
                if (dArr[0] >= d13) {
                    d13 = dArr[0];
                }
                dArr[0] = d13;
                m34982a = i11;
                double[][] dArr7 = this.f24110f;
                double[] dArr8 = dArr7[i2];
                Double.isNaN(m34982a);
                dArr8[0] = m34982a - d8;
                if (dArr7[i2][0] > 1.0d) {
                    dArr7[i2][0] = 1.0d;
                }
                if (dArr7[i2][0] < -1.0d) {
                    dArr7[i2][0] = -1.0d;
                }
            } else {
                m34982a = m34982a(d9);
                double[] dArr9 = this.f24110f[i2];
                Double.isNaN(m34982a);
                dArr9[0] = m34982a - d8;
            }
        }
        return (int) m34982a;
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x08b3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x093b A[LOOP:14: B:269:0x0939->B:270:0x093b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0961 A[LOOP:15: B:272:0x095f->B:273:0x0961, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0983  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double m34979d(java.io.InputStream r64, java.io.OutputStream r65, int r66, int r67, int r68, int r69, int r70, double r71, int r73, boolean r74, int r75) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.jssrc.SSRC.m34979d(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    /* renamed from: g */
    protected byte[] m34976g(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    /* renamed from: i */
    public int m34974i(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != f24098s[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.f24111g = i7;
        this.f24110f = new double[i2];
        this.f24112h = f24099t[i7];
        for (int i8 = 0; i8 < i2; i8++) {
            this.f24110f[i8] = new double[this.f24112h];
        }
        this.f24113i = i3;
        this.f24114j = i4;
        this.f24115k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i9 = 0; i9 < 97; i9++) {
            iArr[i9] = random.nextInt();
        }
        if (i6 == 0) {
            for (int i10 = 0; i10 < 65536; i10++) {
                int nextInt = random.nextInt() % 97;
                int i11 = iArr[nextInt];
                iArr[nextInt] = random.nextInt();
                double[] dArr = this.f24115k;
                double d2 = i11;
                Double.isNaN(d2);
                dArr[i10] = ((d2 / 2.147483647E9d) - 0.5d) * d;
            }
        } else if (i6 == 1) {
            for (int i12 = 0; i12 < 65536; i12++) {
                int nextInt2 = random.nextInt() % 97;
                int i13 = iArr[nextInt2];
                iArr[nextInt2] = random.nextInt();
                int nextInt3 = random.nextInt() % 97;
                int i14 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                double[] dArr2 = this.f24115k;
                double d3 = i13;
                Double.isNaN(d3);
                double d4 = i14;
                Double.isNaN(d4);
                dArr2[i12] = d * ((d3 / 2.147483647E9d) - (d4 / 2.147483647E9d));
            }
        } else if (i6 == 2) {
            boolean z = false;
            double d5 = Utils.DOUBLE_EPSILON;
            double d6 = Utils.DOUBLE_EPSILON;
            for (int i15 = 0; i15 < 65536; i15++) {
                if (!z) {
                    int nextInt4 = random.nextInt() % 97;
                    double d7 = iArr[nextInt4];
                    Double.isNaN(d7);
                    double d8 = d7 / 2.147483647E9d;
                    iArr[nextInt4] = random.nextInt();
                    if (d8 == 1.0d) {
                        d8 = Utils.DOUBLE_EPSILON;
                    }
                    d5 = Math.sqrt(Math.log(1.0d - d8) * (-2.0d));
                    int nextInt5 = random.nextInt() % 97;
                    double d9 = iArr[nextInt5];
                    Double.isNaN(d9);
                    iArr[nextInt5] = random.nextInt();
                    d6 = 6.283185307179586d * (d9 / 2.147483647E9d);
                    this.f24115k[i15] = d * d5 * Math.cos(d6);
                    z = true;
                } else {
                    this.f24115k[i15] = d * d5 * Math.sin(d6);
                    z = false;
                }
            }
        }
        this.f24116l = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return f24100u[this.f24111g];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026e A[EDGE_INSN: B:69:0x026e->B:66:0x026e ?: BREAK  , SYNTHETIC] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double m34972k(java.io.InputStream r28, java.io.OutputStream r29, int r30, int r31, int r32, double r33, int r35, boolean r36, int r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.jssrc.SSRC.m34972k(java.io.InputStream, java.io.OutputStream, int, int, int, double, int, boolean, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:249:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x09ea  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double m34967p(java.io.InputStream r71, java.io.OutputStream r72, int r73, int r74, int r75, int r76, int r77, double r78, int r80, boolean r81, int r82) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.jssrc.SSRC.m34967p(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    /* renamed from: s */
    protected void m34964s(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(m34976g(byteBuffer));
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x090b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    SSRC(java.lang.String[] r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.jssrc.SSRC.<init>(java.lang.String[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SSRC(java.io.InputStream r25, java.io.OutputStream r26, int r27, int r28, int r29, int r30, int r31, int r32, double r33, int r35, boolean r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.jssrc.SSRC.<init>(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, int, double, int, boolean):void");
    }
}
