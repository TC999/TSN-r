package net.sourceforge.pinyin4j;

import com.p200hp.hpl.sparta.Element;
import com.p200hp.hpl.sparta.ParseException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: net.sourceforge.pinyin4j.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GwoyeuRomatzyhTranslator {

    /* renamed from: a */
    private static String[] f44110a = {"_I", "_II", "_III", "_IV", "_V"};

    GwoyeuRomatzyhTranslator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m2858a(String str) {
        String m2822a = TextHelper.m2822a(str);
        String m2821b = TextHelper.m2821b(str);
        try {
            Element mo35113s = GwoyeuRomatzyhResource.m2862a().m2861b().mo35113s("//" + PinyinRomanizationType.f44129b.m2825a() + "[text()='" + m2822a + "']");
            if (mo35113s != null) {
                return mo35113s.mo35111u("../" + PinyinRomanizationType.f44134g.m2825a() + f44110a[Integer.parseInt(m2821b) - 1] + "/text()");
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
