package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.p;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: GwoyeuRomatzyhResource.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private com.hp.hpl.sparta.e f61522a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: GwoyeuRomatzyhResource.java */
    /* renamed from: net.sourceforge.pinyin4j.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1248b {

        /* renamed from: a  reason: collision with root package name */
        static final b f61523a = new b();

        private C1248b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        return C1248b.f61523a;
    }

    private void c() {
        try {
            d(p.b("", i.a("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (ParseException e4) {
            e4.printStackTrace();
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private void d(com.hp.hpl.sparta.e eVar) {
        this.f61522a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.hp.hpl.sparta.e b() {
        return this.f61522a;
    }

    private b() {
        c();
    }
}
