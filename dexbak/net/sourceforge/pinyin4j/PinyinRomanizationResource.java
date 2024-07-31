package net.sourceforge.pinyin4j;

import com.p200hp.hpl.sparta.C7049p;
import com.p200hp.hpl.sparta.Document;
import com.p200hp.hpl.sparta.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: net.sourceforge.pinyin4j.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PinyinRomanizationResource {

    /* renamed from: a */
    private Document f44113a;

    /* compiled from: PinyinRomanizationResource.java */
    /* renamed from: net.sourceforge.pinyin4j.f$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static class C15384b {

        /* renamed from: a */
        static final PinyinRomanizationResource f44114a = new PinyinRomanizationResource();

        private C15384b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static PinyinRomanizationResource m2843a() {
        return C15384b.f44114a;
    }

    /* renamed from: c */
    private void m2841c() {
        try {
            m2840d(C7049p.m35141b("", ResourceHelper.m2823a("/pinyindb/pinyin_mapping.xml")));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m2840d(Document document) {
        this.f44113a = document;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Document m2842b() {
        return this.f44113a;
    }

    private PinyinRomanizationResource() {
        m2841c();
    }
}
