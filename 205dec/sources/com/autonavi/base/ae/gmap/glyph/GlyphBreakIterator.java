package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i4) {
        this.mBreakMode = i4;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i4 = this.mBreakMode;
        if (i4 == 1) {
            breakIterator = BreakIterator.getWordInstance();
        } else if (i4 == 2) {
            breakIterator = BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i5 = first;
            first = breakIterator.next();
            if (first == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i5));
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = numArr[i6].intValue();
        }
        return iArr;
    }
}
