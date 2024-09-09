package com.alibaba.fastjson.asm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEqualTo(Item item) {
        int i4 = this.type;
        if (i4 != 1) {
            if (i4 != 15) {
                if (i4 == 12) {
                    return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2);
                } else if (i4 != 13) {
                    switch (i4) {
                        case 3:
                        case 4:
                            return item.intVal == this.intVal;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2) && item.strVal3.equals(this.strVal3);
                    }
                }
            }
            return item.longVal == this.longVal;
        }
        return item.strVal1.equals(this.strVal1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i4, String str, String str2, String str3) {
        this.type = i4;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i4 != 1 && i4 != 7 && i4 != 8) {
            if (i4 == 12) {
                this.hashCode = (i4 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i4 != 13) {
                this.hashCode = (i4 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (i4 + str.hashCode()) & Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item(int i4, Item item) {
        this.index = i4;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i4) {
        this.type = 3;
        this.intVal = i4;
        this.hashCode = Integer.MAX_VALUE & (3 + i4);
    }
}
