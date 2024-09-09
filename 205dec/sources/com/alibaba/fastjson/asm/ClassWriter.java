package com.alibaba.fastjson.asm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ClassWriter {
    private int access;
    FieldWriter firstField;
    MethodWriter firstMethod;
    int index;
    private int interfaceCount;
    private int[] interfaces;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int superName;
    String thisName;
    int threshold;
    Item[] typeTable;
    int version;

    public ClassWriter() {
        this(0);
    }

    private Item get(Item item) {
        Item[] itemArr = this.items;
        Item item2 = itemArr[item.hashCode % itemArr.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        if (item == null) {
            this.pool.put12(8, newUTF8(str));
            int i4 = this.index;
            this.index = i4 + 1;
            Item item2 = new Item(i4, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i4 = (length * 2) + 1;
            Item[] itemArr = new Item[i4];
            for (int i5 = length - 1; i5 >= 0; i5--) {
                Item item2 = this.items[i5];
                while (item2 != null) {
                    int i6 = item2.hashCode % i4;
                    Item item3 = item2.next;
                    item2.next = itemArr[i6];
                    itemArr[i6] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            double d4 = i4;
            Double.isNaN(d4);
            this.threshold = (int) (d4 * 0.75d);
        }
        int i7 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i7 % itemArr2.length;
        item.next = itemArr2[length2];
        itemArr2[length2] = item;
    }

    public Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        if (item == null) {
            this.pool.put12(7, newUTF8(str));
            int i4 = this.index;
            this.index = i4 + 1;
            Item item2 = new Item(i4, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newConstItem(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.key.set(intValue);
            Item item = get(this.key);
            if (item == null) {
                this.pool.putByte(3).putInt(intValue);
                int i4 = this.index;
                this.index = i4 + 1;
                Item item2 = new Item(i4, this.key);
                put(item2);
                return item2;
            }
            return item;
        } else if (obj instanceof String) {
            return newString((String) obj);
        } else {
            if (obj instanceof Type) {
                Type type = (Type) obj;
                return newClassItem(type.sort == 10 ? type.getInternalName() : type.getDescriptor());
            }
            throw new IllegalArgumentException("value " + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item == null) {
            int i4 = newClassItem(str).index;
            this.pool.put12(9, i4).putShort(newNameTypeItem(str2, str3).index);
            int i5 = this.index;
            this.index = i5 + 1;
            Item item2 = new Item(i5, this.key3);
            put(item2);
            return item2;
        }
        return item;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newMethodItem(String str, String str2, String str3, boolean z3) {
        int i4 = z3 ? 11 : 10;
        this.key3.set(i4, str, str2, str3);
        Item item = get(this.key3);
        if (item == null) {
            this.pool.put12(i4, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
            int i5 = this.index;
            this.index = i5 + 1;
            Item item2 = new Item(i5, this.key3);
            put(item2);
            return item2;
        }
        return item;
    }

    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        if (item == null) {
            int newUTF8 = newUTF8(str);
            this.pool.put12(12, newUTF8).putShort(newUTF8(str2));
            int i4 = this.index;
            this.index = i4 + 1;
            Item item2 = new Item(i4, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i4 = this.index;
            this.index = i4 + 1;
            item = new Item(i4, this.key);
            put(item);
        }
        return item.index;
    }

    public byte[] toByteArray() {
        int i4 = (this.interfaceCount * 2) + 24;
        int i5 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i5++;
            i4 += fieldWriter.getSize();
        }
        int i6 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i6++;
            i4 += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(i4 + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        ByteVector putShort = byteVector.putShort(this.index);
        ByteVector byteVector2 = this.pool;
        putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        for (int i7 = 0; i7 < this.interfaceCount; i7++) {
            byteVector.putShort(this.interfaces[i7]);
        }
        byteVector.putShort(i5);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = fieldWriter2.next) {
            fieldWriter2.put(byteVector);
        }
        byteVector.putShort(i6);
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = methodWriter2.next) {
            methodWriter2.put(byteVector);
        }
        byteVector.putShort(0);
        return byteVector.data;
    }

    public void visit(int i4, int i5, String str, String str2, String[] strArr) {
        this.version = i4;
        this.access = i5;
        this.name = newClassItem(str).index;
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClassItem(str2).index;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        for (int i6 = 0; i6 < this.interfaceCount; i6++) {
            this.interfaces[i6] = newClassItem(strArr[i6]).index;
        }
    }

    private ClassWriter(int i4) {
        this.index = 1;
        this.pool = new ByteVector();
        Item[] itemArr = new Item[256];
        this.items = itemArr;
        double length = itemArr.length;
        Double.isNaN(length);
        this.threshold = (int) (length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }
}
