package net.sourceforge.pinyin4j;

import com.p200hp.hpl.sparta.C7049p;
import com.p200hp.hpl.sparta.Document;
import com.p200hp.hpl.sparta.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: net.sourceforge.pinyin4j.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GwoyeuRomatzyhResource {

    /* renamed from: a */
    private Document f44108a;

    /* compiled from: GwoyeuRomatzyhResource.java */
    /* renamed from: net.sourceforge.pinyin4j.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static class C15382b {

        /* renamed from: a */
        static final GwoyeuRomatzyhResource f44109a = new GwoyeuRomatzyhResource();

        private C15382b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static GwoyeuRomatzyhResource m2862a() {
        return C15382b.f44109a;
    }

    /* renamed from: c */
    private void m2860c() {
        try {
            m2859d(C7049p.m35141b("", ResourceHelper.m2823a("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m2859d(Document document) {
        this.f44108a = document;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Document m2861b() {
        return this.f44108a;
    }

    private GwoyeuRomatzyhResource() {
        m2860c();
    }
}
