package net.sourceforge.pinyin4j;

import com.p200hp.hpl.sparta.Element;
import com.p200hp.hpl.sparta.ParseException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: net.sourceforge.pinyin4j.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PinyinRomanizationTranslator {
    PinyinRomanizationTranslator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m2826a(String str, PinyinRomanizationType pinyinRomanizationType, PinyinRomanizationType pinyinRomanizationType2) {
        String m2822a = TextHelper.m2822a(str);
        String m2821b = TextHelper.m2821b(str);
        try {
            Element mo35113s = PinyinRomanizationResource.m2843a().m2842b().mo35113s("//" + pinyinRomanizationType.m2825a() + "[text()='" + m2822a + "']");
            if (mo35113s != null) {
                String mo35111u = mo35113s.mo35111u("../" + pinyinRomanizationType2.m2825a() + "/text()");
                return mo35111u + m2821b;
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
