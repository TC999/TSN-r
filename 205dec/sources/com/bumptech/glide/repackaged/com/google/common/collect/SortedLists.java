package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class SortedLists {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static abstract class KeyAbsentBehavior {
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX;
        public static final KeyAbsentBehavior NEXT_HIGHER;
        public static final KeyAbsentBehavior NEXT_LOWER;

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum a extends KeyAbsentBehavior {
            a(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int i4) {
                return i4 - 1;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum b extends KeyAbsentBehavior {
            b(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i4) {
                return i4;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum c extends KeyAbsentBehavior {
            c(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i4) {
                return i4 ^ (-1);
            }
        }

        static {
            a aVar = new a("NEXT_LOWER", 0);
            NEXT_LOWER = aVar;
            b bVar = new b("NEXT_HIGHER", 1);
            NEXT_HIGHER = bVar;
            c cVar = new c("INVERTED_INSERTION_INDEX", 2);
            INVERTED_INSERTION_INDEX = cVar;
            $VALUES = new KeyAbsentBehavior[]{aVar, bVar, cVar};
        }

        private KeyAbsentBehavior(String str, int i4) {
        }

        abstract int resultIndex(int i4);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static abstract class KeyPresentBehavior {
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES;
        public static final KeyPresentBehavior ANY_PRESENT;
        public static final KeyPresentBehavior FIRST_AFTER;
        public static final KeyPresentBehavior FIRST_PRESENT;
        public static final KeyPresentBehavior LAST_BEFORE;
        public static final KeyPresentBehavior LAST_PRESENT;

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum a extends KeyPresentBehavior {
            a(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4) {
                return i4;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum b extends KeyPresentBehavior {
            b(String str, int i4) {
                super(str, i4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4) {
                int size = list.size() - 1;
                while (i4 < size) {
                    int i5 = ((i4 + size) + 1) >>> 1;
                    if (comparator.compare((E) list.get(i5), e4) > 0) {
                        size = i5 - 1;
                    } else {
                        i4 = i5;
                    }
                }
                return i4;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum c extends KeyPresentBehavior {
            c(String str, int i4) {
                super(str, i4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4) {
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = (i5 + i4) >>> 1;
                    if (comparator.compare((E) list.get(i6), e4) < 0) {
                        i5 = i6 + 1;
                    } else {
                        i4 = i6;
                    }
                }
                return i5;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum d extends KeyPresentBehavior {
            d(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e4, list, i4) + 1;
            }
        }

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        enum e extends KeyPresentBehavior {
            e(String str, int i4) {
                super(str, i4);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e4, list, i4) - 1;
            }
        }

        static {
            a aVar = new a("ANY_PRESENT", 0);
            ANY_PRESENT = aVar;
            b bVar = new b("LAST_PRESENT", 1);
            LAST_PRESENT = bVar;
            c cVar = new c("FIRST_PRESENT", 2);
            FIRST_PRESENT = cVar;
            d dVar = new d("FIRST_AFTER", 3);
            FIRST_AFTER = dVar;
            e eVar = new e("LAST_BEFORE", 4);
            LAST_BEFORE = eVar;
            $VALUES = new KeyPresentBehavior[]{aVar, bVar, cVar, dVar, eVar};
        }

        private KeyPresentBehavior(String str, int i4) {
        }

        abstract <E> int resultIndex(Comparator<? super E> comparator, E e4, List<? extends E> list, int i4);
    }

    public static <E> int a(List<? extends E> list, E e4, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(keyPresentBehavior);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = o.g(list);
        }
        int i4 = 0;
        int size = list.size() - 1;
        while (i4 <= size) {
            int i5 = (i4 + size) >>> 1;
            int compare = comparator.compare(e4, (E) list.get(i5));
            if (compare < 0) {
                size = i5 - 1;
            } else if (compare <= 0) {
                return i4 + keyPresentBehavior.resultIndex(comparator, e4, list.subList(i4, size + 1), i5 - i4);
            } else {
                i4 = i5 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i4);
    }
}
