package kotlin.p613io;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000L\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0019\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0013\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\u0087\b\u001a\u0013\u0010\u0016\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\u0087\b\u001a\t\u0010 \u001a\u00020\u0002H\u0087\b\u001a\b\u0010\"\u001a\u0004\u0018\u00010!¨\u0006#"}, m12616d2 = {"", "message", "Lkotlin/f1;", "g", "", "e", "", "f", "", "a", "", "h", "", "b", "", "i", "", "d", "", "c", "", "j", "r", "p", CampaignEx.JSON_KEY_AD_Q, C7304t.f25048d, "s", "m", UMCommonContent.f37782aL, "o", "n", "u", "k", "", "v", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "ConsoleKt")
/* renamed from: kotlin.io.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Console {
    @InlineOnly
    /* renamed from: a */
    private static final void m8490a(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    @InlineOnly
    /* renamed from: b */
    private static final void m8489b(char c) {
        System.out.print(c);
    }

    @InlineOnly
    /* renamed from: c */
    private static final void m8488c(double d) {
        System.out.print(d);
    }

    @InlineOnly
    /* renamed from: d */
    private static final void m8487d(float f) {
        System.out.print(f);
    }

    @InlineOnly
    /* renamed from: e */
    private static final void m8486e(int i) {
        System.out.print(i);
    }

    @InlineOnly
    /* renamed from: f */
    private static final void m8485f(long j) {
        System.out.print(j);
    }

    @InlineOnly
    /* renamed from: g */
    private static final void m8484g(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    /* renamed from: h */
    private static final void m8483h(short s) {
        System.out.print(Short.valueOf(s));
    }

    @InlineOnly
    /* renamed from: i */
    private static final void m8482i(boolean z) {
        System.out.print(z);
    }

    @InlineOnly
    /* renamed from: j */
    private static final void m8481j(char[] cArr) {
        System.out.print(cArr);
    }

    @InlineOnly
    /* renamed from: k */
    private static final void m8480k() {
        System.out.println();
    }

    @InlineOnly
    /* renamed from: l */
    private static final void m8479l(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    @InlineOnly
    /* renamed from: m */
    private static final void m8478m(char c) {
        System.out.println(c);
    }

    @InlineOnly
    /* renamed from: n */
    private static final void m8477n(double d) {
        System.out.println(d);
    }

    @InlineOnly
    /* renamed from: o */
    private static final void m8476o(float f) {
        System.out.println(f);
    }

    @InlineOnly
    /* renamed from: p */
    private static final void m8475p(int i) {
        System.out.println(i);
    }

    @InlineOnly
    /* renamed from: q */
    private static final void m8474q(long j) {
        System.out.println(j);
    }

    @InlineOnly
    /* renamed from: r */
    private static final void m8473r(Object obj) {
        System.out.println(obj);
    }

    @InlineOnly
    /* renamed from: s */
    private static final void m8472s(short s) {
        System.out.println(Short.valueOf(s));
    }

    @InlineOnly
    /* renamed from: t */
    private static final void m8471t(boolean z) {
        System.out.println(z);
    }

    @InlineOnly
    /* renamed from: u */
    private static final void m8470u(char[] cArr) {
        System.out.println(cArr);
    }

    @Nullable
    /* renamed from: v */
    public static final String m8469v() {
        C14328p c14328p = C14328p.f41104i;
        InputStream inputStream = System.in;
        C14342f0.m8185o(inputStream, "System.`in`");
        Charset defaultCharset = Charset.defaultCharset();
        C14342f0.m8185o(defaultCharset, "Charset.defaultCharset()");
        return c14328p.m8366f(inputStream, defaultCharset);
    }
}
