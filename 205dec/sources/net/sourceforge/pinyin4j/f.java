package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.p;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PinyinRomanizationResource.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private com.hp.hpl.sparta.e f61527a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: PinyinRomanizationResource.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        static final f f61528a = new f();

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a() {
        return b.f61528a;
    }

    private void c() {
        try {
            d(p.b("", i.a("/pinyindb/pinyin_mapping.xml")));
        } catch (ParseException e4) {
            e4.printStackTrace();
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private void d(com.hp.hpl.sparta.e eVar) {
        this.f61527a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.hp.hpl.sparta.e b() {
        return this.f61527a;
    }

    private f() {
        c();
    }
}
