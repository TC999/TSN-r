package com.hw.videoprocessor.jssrc;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: SSRC.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: q  reason: collision with root package name */
    private static final String f37578q = "1.30";

    /* renamed from: r  reason: collision with root package name */
    private static final int f37579r = 65536;

    /* renamed from: w  reason: collision with root package name */
    private static final int f37584w = 97;

    /* renamed from: y  reason: collision with root package name */
    static final /* synthetic */ boolean f37586y = false;

    /* renamed from: a  reason: collision with root package name */
    private ByteOrder f37587a;

    /* renamed from: b  reason: collision with root package name */
    private c f37588b;

    /* renamed from: c  reason: collision with root package name */
    private double f37589c;

    /* renamed from: d  reason: collision with root package name */
    private double f37590d;

    /* renamed from: e  reason: collision with root package name */
    private int f37591e;

    /* renamed from: f  reason: collision with root package name */
    private double[][] f37592f;

    /* renamed from: g  reason: collision with root package name */
    private int f37593g;

    /* renamed from: h  reason: collision with root package name */
    private int f37594h;

    /* renamed from: i  reason: collision with root package name */
    private int f37595i;

    /* renamed from: j  reason: collision with root package name */
    private int f37596j;

    /* renamed from: k  reason: collision with root package name */
    private double[] f37597k;

    /* renamed from: l  reason: collision with root package name */
    private int f37598l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37599m;

    /* renamed from: n  reason: collision with root package name */
    private int f37600n;

    /* renamed from: o  reason: collision with root package name */
    private long f37601o;

    /* renamed from: p  reason: collision with root package name */
    private long f37602p;

    /* renamed from: s  reason: collision with root package name */
    private static final int[] f37580s = {0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f37581t = {1, 16, 20, 16, 16, 15, 16, 15};

    /* renamed from: u  reason: collision with root package name */
    private static final int[] f37582u = {8, 18, 27, 8, 8, 8, 10, 9};

    /* renamed from: v  reason: collision with root package name */
    private static final double[][] f37583v = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};

    /* renamed from: x  reason: collision with root package name */
    private static final double[] f37585x = {0.7d, 0.9d, 0.18d};

    public b() {
        this.f37587a = ByteOrder.LITTLE_ENDIAN;
        this.f37588b = new c();
        this.f37589c = 170.0d;
        this.f37590d = 100.0d;
        this.f37591e = 65536;
        this.f37599m = false;
    }

    private int a(double d4) {
        return (int) (d4 >= 0.0d ? d4 + 0.5d : d4 - 0.5d);
    }

    private double b(double d4) {
        if (d4 <= 21.0d) {
            return 0.0d;
        }
        if (d4 <= 50.0d) {
            double d5 = d4 - 21.0d;
            return (Math.pow(d5, 0.4d) * 0.5842d) + (d5 * 0.07886d);
        }
        return (d4 - 8.7d) * 0.1102d;
    }

    private void e(int i4) {
        throw new IllegalStateException("unknown error " + i4);
    }

    private int f(int i4, int i5) {
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == 0) {
                return i7;
            }
            i5 = i7 % i4;
        }
    }

    private double h(int i4, double d4, double d5) {
        double d6 = 1.0d / d5;
        double d7 = 6.283185307179586d * d4;
        double d8 = i4;
        Double.isNaN(d8);
        return d4 * 2.0d * d6 * o(d8 * d7 * d6);
    }

    public static void j(String[] strArr) throws Exception {
        new b(strArr);
    }

    private void l(int i4) {
    }

    private void m() {
        this.f37601o = System.currentTimeMillis();
        this.f37602p = 0L;
        this.f37600n = -1;
    }

    private void n(double d4) {
        int i4;
        if (this.f37599m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f37601o;
        if (d4 == 0.0d) {
            i4 = 0;
        } else {
            double d5 = currentTimeMillis;
            Double.isNaN(d5);
            i4 = (int) ((d5 * (1.0d - d4)) / d4);
        }
        int i5 = (int) (d4 * 100.0d);
        if (i5 != this.f37600n || currentTimeMillis != this.f37602p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i5));
            this.f37600n = i5;
        }
        if (currentTimeMillis != this.f37602p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i4));
            this.f37602p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    private double o(double d4) {
        if (d4 == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d4) / d4;
    }

    private void q() {
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

    private double r(double d4, int i4, double d5, double d6) {
        double d7 = 4.0d * d4 * d4;
        double d8 = i4;
        Double.isNaN(d8);
        double d9 = d8 - 1.0d;
        return a.a(d5 * Math.sqrt(1.0d - (d7 / (d9 * d9)))) / d6;
    }

    public int c(double d4, double[] dArr, int i4, int i5) {
        int i6;
        double a4;
        if (i4 == 1) {
            double[] dArr2 = this.f37597k;
            int i7 = this.f37598l;
            this.f37598l = i7 + 1;
            double d5 = d4 + dArr2[i7 & 65535];
            int i8 = this.f37595i;
            if (d5 < i8) {
                double d6 = i8;
                Double.isNaN(d6);
                double d7 = d5 / d6;
                if (dArr[0] >= d7) {
                    d7 = dArr[0];
                }
                dArr[0] = d7;
                d5 = i8;
            }
            int i9 = this.f37596j;
            if (d5 > i9) {
                double d8 = i9;
                Double.isNaN(d8);
                double d9 = d5 / d8;
                if (dArr[0] >= d9) {
                    d9 = dArr[0];
                }
                dArr[0] = d9;
                d5 = i9;
            }
            return a(d5);
        }
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            i6 = this.f37594h;
            if (i10 >= i6) {
                break;
            }
            d10 += f37583v[this.f37593g][i10] * this.f37592f[i5][i10];
            i10++;
        }
        double d11 = d4 + d10;
        double[] dArr3 = this.f37597k;
        int i11 = this.f37598l;
        this.f37598l = i11 + 1;
        double d12 = dArr3[65535 & i11] + d11;
        for (int i12 = i6 - 2; i12 >= 0; i12--) {
            double[][] dArr4 = this.f37592f;
            dArr4[i5][i12 + 1] = dArr4[i5][i12];
        }
        int i13 = this.f37595i;
        if (d12 < i13) {
            double d13 = i13;
            Double.isNaN(d13);
            double d14 = d12 / d13;
            if (dArr[0] >= d14) {
                d14 = dArr[0];
            }
            dArr[0] = d14;
            a4 = i13;
            double[][] dArr5 = this.f37592f;
            double[] dArr6 = dArr5[i5];
            Double.isNaN(a4);
            dArr6[0] = a4 - d11;
            if (dArr5[i5][0] > 1.0d) {
                dArr5[i5][0] = 1.0d;
            }
            if (dArr5[i5][0] < -1.0d) {
                dArr5[i5][0] = -1.0d;
            }
        } else {
            int i14 = this.f37596j;
            if (d12 > i14) {
                double d15 = i14;
                Double.isNaN(d15);
                double d16 = d12 / d15;
                if (dArr[0] >= d16) {
                    d16 = dArr[0];
                }
                dArr[0] = d16;
                a4 = i14;
                double[][] dArr7 = this.f37592f;
                double[] dArr8 = dArr7[i5];
                Double.isNaN(a4);
                dArr8[0] = a4 - d11;
                if (dArr7[i5][0] > 1.0d) {
                    dArr7[i5][0] = 1.0d;
                }
                if (dArr7[i5][0] < -1.0d) {
                    dArr7[i5][0] = -1.0d;
                }
            } else {
                a4 = a(d12);
                double[] dArr9 = this.f37592f[i5];
                Double.isNaN(a4);
                dArr9[0] = a4 - d11;
            }
        }
        return (int) a4;
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x08b3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x093b A[LOOP:14: B:269:0x0939->B:270:0x093b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0961 A[LOOP:15: B:272:0x095f->B:273:0x0961, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0983  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double d(java.io.InputStream r64, java.io.OutputStream r65, int r66, int r67, int r68, int r69, int r70, double r71, int r73, boolean r74, int r75) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.d(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    protected byte[] g(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    public int i(int i4, int i5, int i6, int i7, int i8, int i9, double d4) {
        int[] iArr = new int[97];
        int i10 = 1;
        while (i10 < 6 && i4 != f37580s[i10]) {
            i10++;
        }
        if ((i8 == 3 || i8 == 4) && i10 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i4));
        }
        i10 = (i8 == 2 || i10 == 6) ? 0 : 0;
        if (i8 == 4 && (i10 == 1 || i10 == 2)) {
            i10 += 5;
        }
        this.f37593g = i10;
        this.f37592f = new double[i5];
        this.f37594h = f37581t[i10];
        for (int i11 = 0; i11 < i5; i11++) {
            this.f37592f[i11] = new double[this.f37594h];
        }
        this.f37595i = i6;
        this.f37596j = i7;
        this.f37597k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i12 = 0; i12 < 97; i12++) {
            iArr[i12] = random.nextInt();
        }
        if (i9 == 0) {
            for (int i13 = 0; i13 < 65536; i13++) {
                int nextInt = random.nextInt() % 97;
                int i14 = iArr[nextInt];
                iArr[nextInt] = random.nextInt();
                double[] dArr = this.f37597k;
                double d5 = i14;
                Double.isNaN(d5);
                dArr[i13] = ((d5 / 2.147483647E9d) - 0.5d) * d4;
            }
        } else if (i9 == 1) {
            for (int i15 = 0; i15 < 65536; i15++) {
                int nextInt2 = random.nextInt() % 97;
                int i16 = iArr[nextInt2];
                iArr[nextInt2] = random.nextInt();
                int nextInt3 = random.nextInt() % 97;
                int i17 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                double[] dArr2 = this.f37597k;
                double d6 = i16;
                Double.isNaN(d6);
                double d7 = i17;
                Double.isNaN(d7);
                dArr2[i15] = d4 * ((d6 / 2.147483647E9d) - (d7 / 2.147483647E9d));
            }
        } else if (i9 == 2) {
            boolean z3 = false;
            double d8 = 0.0d;
            double d9 = 0.0d;
            for (int i18 = 0; i18 < 65536; i18++) {
                if (!z3) {
                    int nextInt4 = random.nextInt() % 97;
                    double d10 = iArr[nextInt4];
                    Double.isNaN(d10);
                    double d11 = d10 / 2.147483647E9d;
                    iArr[nextInt4] = random.nextInt();
                    if (d11 == 1.0d) {
                        d11 = 0.0d;
                    }
                    d8 = Math.sqrt(Math.log(1.0d - d11) * (-2.0d));
                    int nextInt5 = random.nextInt() % 97;
                    double d12 = iArr[nextInt5];
                    Double.isNaN(d12);
                    iArr[nextInt5] = random.nextInt();
                    d9 = 6.283185307179586d * (d12 / 2.147483647E9d);
                    this.f37597k[i18] = d4 * d8 * Math.cos(d9);
                    z3 = true;
                } else {
                    this.f37597k[i18] = d4 * d8 * Math.sin(d9);
                    z3 = false;
                }
            }
        }
        this.f37598l = 0;
        if (i8 == 0 || i8 == 1) {
            return 1;
        }
        return f37582u[this.f37593g];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026e A[EDGE_INSN: B:69:0x026e->B:66:0x026e ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double k(java.io.InputStream r28, java.io.OutputStream r29, int r30, int r31, int r32, double r33, int r35, boolean r36, int r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.k(java.io.InputStream, java.io.OutputStream, int, int, int, double, int, boolean, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:249:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x09ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double p(java.io.InputStream r71, java.io.OutputStream r72, int r73, int r74, int r75, int r76, int r77, double r78, int r80, boolean r81, int r82) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.p(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    protected void s(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(g(byteBuffer));
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
    b(java.lang.String[] r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.<init>(java.lang.String[]):void");
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
    public b(java.io.InputStream r25, java.io.OutputStream r26, int r27, int r28, int r29, int r30, int r31, int r32, double r33, int r35, boolean r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.jssrc.b.<init>(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, int, double, int, boolean):void");
    }
}
