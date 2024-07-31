package com.autonavi.base.p048ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* renamed from: com.autonavi.base.ae.gmap.glyph.GlyphBreakIterator */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i) {
        this.mBreakMode = i;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i = this.mBreakMode;
        if (i == 1) {
            breakIterator = BreakIterator.getWordInstance();
        } else if (i == 2) {
            breakIterator = BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i2 = first;
            first = breakIterator.next();
            if (first == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i2));
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }
}
