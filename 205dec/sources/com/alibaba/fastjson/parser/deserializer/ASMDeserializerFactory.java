package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.classLoader = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(183, type, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i4) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        if ((fieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor.visitInsn(89);
            methodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitJumpInsn(153, label);
            methodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            if (fieldInfo.fieldType instanceof Class) {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i4));
                methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.parserFeatures));
            String type = ASMUtils.type(JavaBeanDeserializer.class);
            methodVisitor.visitMethodInsn(182, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label);
        }
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.fieldType instanceof Class) {
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i4));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLabel(label2);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(158, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0934  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void _deserialze(com.alibaba.fastjson.asm.ClassWriter r30, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory.Context r31) {
        /*
            Method dump skipped, instructions count: 2892
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory._deserialze(com.alibaba.fastjson.asm.ClassWriter, com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory$Context):void");
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        int i4;
        int i5;
        MethodWriter methodWriter;
        Class<JavaBeanDeserializer> cls;
        int i6;
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        defineVarLexer(context, methodWriter2);
        _createInstance(context, methodWriter2);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i7 = 0;
        while (i7 < length) {
            boolean z3 = i7 == length + (-1);
            if (z3) {
                i4 = length;
                i5 = 93;
            } else {
                i4 = length;
                i5 = 44;
            }
            FieldInfo fieldInfo = fieldInfoArr[i7];
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            Class<?> cls3 = fieldInfo.fieldClass;
            boolean z4 = z3;
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if (cls3 != Byte.TYPE && cls3 != Short.TYPE && cls3 != Integer.TYPE) {
                if (cls3 == Long.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter2.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
                } else if (cls3 == Boolean.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                } else if (cls3 == Float.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
                    methodWriter2.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
                } else if (cls3 == Double.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
                    methodWriter2.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
                } else if (cls3 == Character.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter2.visitInsn(3);
                    methodWriter2.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                } else if (cls3 == String.class) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else if (cls3.isEnum()) {
                    Label label = new Label();
                    Label label2 = new Label();
                    Label label3 = new Label();
                    int i8 = i7;
                    Label label4 = new Label();
                    cls = cls2;
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    String str = JSONLexerBase;
                    methodWriter2.visitMethodInsn(182, str, "getCurrent", "()C");
                    methodWriter2.visitInsn(89);
                    methodWriter2.visitVarInsn(54, context.var("ch"));
                    methodWriter2.visitLdcInsn(110);
                    methodWriter2.visitJumpInsn(159, label4);
                    methodWriter2.visitVarInsn(21, context.var("ch"));
                    methodWriter2.visitLdcInsn(34);
                    methodWriter2.visitJumpInsn(160, label);
                    methodWriter2.visitLabel(label4);
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    methodWriter2.visitVarInsn(25, 1);
                    String str2 = DefaultJSONParser;
                    methodWriter2.visitMethodInsn(182, str2, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, str, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
                    methodWriter2.visitJumpInsn(167, label3);
                    methodWriter2.visitLabel(label);
                    methodWriter2.visitVarInsn(21, context.var("ch"));
                    methodWriter2.visitLdcInsn(48);
                    methodWriter2.visitJumpInsn(161, label2);
                    methodWriter2.visitVarInsn(21, context.var("ch"));
                    methodWriter2.visitLdcInsn(57);
                    methodWriter2.visitJumpInsn(163, label2);
                    _getFieldDeser(context, methodWriter2, fieldInfo);
                    methodWriter2.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    methodWriter2.visitMethodInsn(182, str, "scanInt", "(C)I");
                    methodWriter2.visitMethodInsn(182, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                    methodWriter2.visitJumpInsn(167, label3);
                    methodWriter2.visitLabel(label2);
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(16, i5);
                    String type2 = ASMUtils.type(cls);
                    methodWriter2.visitMethodInsn(182, type2, "scanEnum", "(L" + str + ";C)Ljava/lang/Enum;");
                    methodWriter2.visitLabel(label3);
                    methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter = methodWriter2;
                    i6 = i8;
                } else {
                    cls = cls2;
                    int i9 = i7;
                    if (Collection.class.isAssignableFrom(cls3)) {
                        Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type);
                        if (collectionItemClass == String.class) {
                            if (cls3 != List.class && cls3 != Collections.class && cls3 != ArrayList.class) {
                                methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodWriter2.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                            } else {
                                methodWriter2.visitTypeInsn(187, ASMUtils.type(ArrayList.class));
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
                            }
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                            methodWriter2.visitVarInsn(16, i5);
                            String str3 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str3, "scanStringArray", "(Ljava/util/Collection;C)V");
                            Label label5 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str3, "matchStat", "I");
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label5);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                            methodWriter2.visitLabel(label5);
                            i6 = i9;
                        } else {
                            Label label6 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            String str4 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str4, "token", "()I");
                            methodWriter2.visitVarInsn(54, context.var("token"));
                            methodWriter2.visitVarInsn(21, context.var("token"));
                            methodWriter2.visitLdcInsn(Integer.valueOf(i9 == 0 ? 14 : 16));
                            methodWriter2.visitJumpInsn(159, label6);
                            methodWriter2.visitVarInsn(25, 1);
                            methodWriter2.visitVarInsn(21, context.var("token"));
                            String str5 = DefaultJSONParser;
                            methodWriter2.visitMethodInsn(182, str5, "throwException", "(I)V");
                            methodWriter2.visitLabel(label6);
                            Label label7 = new Label();
                            Label label8 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitMethodInsn(182, str4, "getCurrent", "()C");
                            methodWriter2.visitVarInsn(16, 91);
                            methodWriter2.visitJumpInsn(160, label7);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitMethodInsn(182, str4, "next", "()C");
                            methodWriter2.visitInsn(87);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitLdcInsn(14);
                            methodWriter2.visitMethodInsn(182, str4, "setToken", "(I)V");
                            methodWriter2.visitJumpInsn(167, label8);
                            methodWriter2.visitLabel(label7);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitLdcInsn(14);
                            methodWriter2.visitMethodInsn(182, str4, "nextToken", "(I)V");
                            methodWriter2.visitLabel(label8);
                            i6 = i9;
                            _newCollection(methodWriter2, cls3, i6, false);
                            methodWriter2.visitInsn(89);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                            _getCollectionFieldItemDeser(context, methodWriter2, fieldInfo, collectionItemClass);
                            methodWriter2.visitVarInsn(25, 1);
                            methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                            methodWriter2.visitVarInsn(25, 3);
                            String type3 = ASMUtils.type(cls);
                            methodWriter2.visitMethodInsn(184, type3, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + str5 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                        }
                    } else {
                        i6 = i9;
                        if (cls3.isArray()) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitLdcInsn(14);
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
                            methodWriter2.visitVarInsn(25, 1);
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitLdcInsn(Integer.valueOf(i6));
                            methodWriter2.visitMethodInsn(182, ASMUtils.type(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            methodWriter2.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        } else {
                            Label label9 = new Label();
                            Label label10 = new Label();
                            if (cls3 == Date.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                String str6 = JSONLexerBase;
                                methodWriter2.visitMethodInsn(182, str6, "getCurrent", "()C");
                                methodWriter2.visitLdcInsn(49);
                                methodWriter2.visitJumpInsn(160, label9);
                                methodWriter2.visitTypeInsn(187, ASMUtils.type(Date.class));
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(16, i5);
                                methodWriter2.visitMethodInsn(182, str6, "scanLong", "(C)J");
                                methodWriter2.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                                methodWriter2.visitJumpInsn(167, label10);
                            }
                            methodWriter2.visitLabel(label9);
                            _quickNextToken(context, methodWriter2, 14);
                            methodWriter = methodWriter2;
                            _deserObject(context, methodWriter2, fieldInfo, cls3, i6);
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            if (!z4) {
                                methodWriter.visitLdcInsn(16);
                            } else {
                                methodWriter.visitLdcInsn(15);
                            }
                            String type4 = ASMUtils.type(cls);
                            methodWriter.visitMethodInsn(183, type4, "check", "(" + ASMUtils.desc(JSONLexer.class) + "I)V");
                            methodWriter.visitLabel(label10);
                        }
                    }
                    methodWriter = methodWriter2;
                }
                methodWriter = methodWriter2;
                cls = cls2;
                i6 = i7;
            } else {
                methodWriter = methodWriter2;
                cls = cls2;
                i6 = i7;
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i5);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            }
            i7 = i6 + 1;
            methodWriter2 = methodWriter;
            length = i4;
            fieldInfoArr = fieldInfoArr2;
            cls2 = cls;
        }
        MethodWriter methodWriter3 = methodWriter2;
        _batchSet(context, methodWriter3, false);
        Label label11 = new Label();
        Label label12 = new Label();
        Label label13 = new Label();
        Label label14 = new Label();
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        String str7 = JSONLexerBase;
        methodWriter3.visitMethodInsn(182, str7, "getCurrent", "()C");
        methodWriter3.visitInsn(89);
        methodWriter3.visitVarInsn(54, context.var("ch"));
        methodWriter3.visitVarInsn(16, 44);
        methodWriter3.visitJumpInsn(160, label12);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitMethodInsn(182, str7, "next", "()C");
        methodWriter3.visitInsn(87);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitLdcInsn(16);
        methodWriter3.visitMethodInsn(182, str7, "setToken", "(I)V");
        methodWriter3.visitJumpInsn(167, label14);
        methodWriter3.visitLabel(label12);
        methodWriter3.visitVarInsn(21, context.var("ch"));
        methodWriter3.visitVarInsn(16, 93);
        methodWriter3.visitJumpInsn(160, label13);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitMethodInsn(182, str7, "next", "()C");
        methodWriter3.visitInsn(87);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitLdcInsn(15);
        methodWriter3.visitMethodInsn(182, str7, "setToken", "(I)V");
        methodWriter3.visitJumpInsn(167, label14);
        methodWriter3.visitLabel(label13);
        methodWriter3.visitVarInsn(21, context.var("ch"));
        methodWriter3.visitVarInsn(16, 26);
        methodWriter3.visitJumpInsn(160, label11);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitMethodInsn(182, str7, "next", "()C");
        methodWriter3.visitInsn(87);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitLdcInsn(20);
        methodWriter3.visitMethodInsn(182, str7, "setToken", "(I)V");
        methodWriter3.visitJumpInsn(167, label14);
        methodWriter3.visitLabel(label11);
        methodWriter3.visitVarInsn(25, context.var("lexer"));
        methodWriter3.visitLdcInsn(16);
        methodWriter3.visitMethodInsn(182, str7, "nextToken", "(I)V");
        methodWriter3.visitLabel(label14);
        methodWriter3.visitVarInsn(25, context.var("instance"));
        methodWriter3.visitInsn(176);
        methodWriter3.visitMaxs(5, context.variantIndex);
        methodWriter3.visitEnd();
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i4) {
        String str;
        String str2;
        String str3;
        String str4;
        Label label2;
        String str5;
        int i5;
        Label label3 = new Label();
        String str6 = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str6, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(153, label3);
        _setFlag(methodVisitor, context, i4);
        Label label4 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(8);
        methodVisitor.visitJumpInsn(160, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(182, str6, "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label4);
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(21);
        methodVisitor.visitJumpInsn(160, label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitMethodInsn(182, str6, "nextToken", "(I)V");
        _newCollection(methodVisitor, cls, i4, true);
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitJumpInsn(159, label7);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(12);
        methodVisitor.visitJumpInsn(160, label);
        _newCollection(methodVisitor, cls, i4, false);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type = ASMUtils.type(ObjectDeserializer.class);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str7 = DefaultJSONParser;
        sb.append(str7);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitMethodInsn(185, type, "deserialze", sb.toString());
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            methodVisitor.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label7);
        _newCollection(methodVisitor, cls, i4, false);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo.fieldClass);
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        if (isPrimitive2) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            str2 = "nextToken";
            str3 = str6;
            str4 = "(I)V";
            methodVisitor.visitMethodInsn(182, str3, str2, str4);
            label2 = label3;
        } else {
            str2 = "nextToken";
            str3 = str6;
            str4 = "(I)V";
            methodVisitor.visitInsn(87);
            methodVisitor.visitLdcInsn(12);
            label2 = label3;
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            _quickNextToken(context, methodVisitor, 12);
        }
        methodVisitor.visitVarInsn(25, 1);
        String str8 = str4;
        methodVisitor.visitMethodInsn(182, str7, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(182, str7, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitInsn(87);
        Label label8 = new Label();
        Label label9 = new Label();
        methodVisitor.visitInsn(3);
        String str9 = str2;
        methodVisitor.visitVarInsn(54, context.var("i"));
        methodVisitor.visitLabel(label8);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str3, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(159, label9);
        methodVisitor.visitVarInsn(25, 0);
        String str10 = context.className;
        methodVisitor.visitFieldInsn(180, str10, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitVarInsn(21, context.var("i"));
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + str7 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str11 = str;
        methodVisitor.visitVarInsn(58, context.var(str11));
        methodVisitor.visitIincInsn(context.var("i"), 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var(str11));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitMethodInsn(182, str7, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str3, "token", "()I");
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitJumpInsn(160, label8);
        if (isPrimitive2) {
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            methodVisitor.visitMethodInsn(182, str3, str9, str8);
            i5 = 167;
            str5 = str7;
        } else {
            str5 = str7;
            _quickNextToken(context, methodVisitor, 12);
            i5 = 167;
        }
        methodVisitor.visitJumpInsn(i5, label8);
        methodVisitor.visitLabel(label9);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        methodVisitor.visitMethodInsn(182, str5, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str3, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor.visitLabel(label2);
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i4) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_prefix__", "[C");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(154, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i4);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i4);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getResolveStatus", "()I");
        methodVisitor.visitLdcInsn(1);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, str2, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, str2, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(182, type, "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(0);
        methodVisitor.visitMethodInsn(182, str2, "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _init(ClassWriter classWriter, Context context) {
        int length = context.fieldInfoList.length;
        for (int i4 = 0; i4 < length; i4++) {
            FieldInfo fieldInfo = context.fieldInfoList[i4];
            new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_prefix__", "[C").visitEnd();
        }
        int length2 = context.fieldInfoList.length;
        for (int i5 = 0; i5 < length2; i5++) {
            FieldInfo fieldInfo2 = context.fieldInfoList[i5];
            Class<?> cls = fieldInfo2.fieldClass;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                } else {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                }
            }
        }
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V", null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodWriter.visitMethodInsn(183, type, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V");
        int length3 = context.fieldInfoList.length;
        for (int i6 = 0; i6 < length3; i6++) {
            FieldInfo fieldInfo3 = context.fieldInfoList[i6];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo3.name + "\":");
            methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
            String str = context.className;
            methodWriter.visitFieldInsn(181, str, fieldInfo3.name + "_asm_prefix__", "[C");
        }
        methodWriter.visitInsn(177);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i4, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i4 / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i4));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(153, label);
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        java.lang.reflect.Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls != Byte.TYPE && cls != Short.TYPE && cls != Integer.TYPE && cls != Character.TYPE) {
            if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
                if (fieldInfo.method != null) {
                    methodVisitor.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                    if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                        return;
                    }
                    methodVisitor.visitInsn(87);
                    return;
                }
                methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            } else if (cls != Double.TYPE) {
                if (cls == String.class) {
                    methodVisitor.visitVarInsn(25, context.var("instance"));
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    _set(context, methodVisitor, fieldInfo);
                } else if (cls.isEnum()) {
                    methodVisitor.visitVarInsn(25, context.var("instance"));
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    _set(context, methodVisitor, fieldInfo);
                } else if (Collection.class.isAssignableFrom(cls)) {
                    methodVisitor.visitVarInsn(25, context.var("instance"));
                    if (TypeUtils.getCollectionItemClass(type) == String.class) {
                        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
                    } else {
                        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    }
                    _set(context, methodVisitor, fieldInfo);
                } else {
                    methodVisitor.visitVarInsn(25, context.var("instance"));
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    _set(context, methodVisitor, fieldInfo);
                }
            } else {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
                _set(context, methodVisitor, fieldInfo);
            }
        } else {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i4, boolean z3) {
        if (cls.isAssignableFrom(ArrayList.class) && !z3) {
            methodVisitor.visitTypeInsn(187, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z3) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
        } else if (z3) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i4));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i4) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "getCurrent", "()C");
        if (i4 == 12) {
            methodVisitor.visitVarInsn(16, 123);
        } else if (i4 == 14) {
            methodVisitor.visitVarInsn(16, 91);
        } else {
            throw new IllegalStateException();
        }
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i4));
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i4));
        methodVisitor.visitMethodInsn(182, str, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "getCurrent", "()C");
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(54, context.var("ch"));
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitJumpInsn(160, label2);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 125);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 93);
        methodVisitor.visitJumpInsn(160, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 26);
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(20);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "nextToken", "()V");
        methodVisitor.visitLabel(label5);
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? 185 : 182, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
            if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                return;
            }
            methodVisitor.visitInsn(87);
            return;
        }
        methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        String str = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(198, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i4) {
        String str = "_asm_flag_" + (i4 / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i4));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private Class<?> defineClassPublic(String str, byte[] bArr, int i4, int i5) {
        return this.classLoader.defineClassPublic(str, bArr, i4, i5);
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        Class<?> cls;
        String name;
        if (!javaBeanInfo.clazz.isPrimitive()) {
            String str = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
            String str2 = name.replace('.', '/') + TTPathConst.sSeparator + str;
            String str3 = ASMDeserializerFactory.class.getPackage().getName() + "." + str;
            ClassWriter classWriter = new ClassWriter();
            classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), null);
            _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
            _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
            byte[] byteArray = classWriter.toByteArray();
            return (ObjectDeserializer) defineClassPublic(str3, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, JavaBeanInfo.class).newInstance(parserConfig, javaBeanInfo);
        }
        throw new IllegalArgumentException("not support type :" + cls.getName());
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z3) {
        int length = context.fieldInfoList.length;
        for (int i4 = 0; i4 < length; i4++) {
            Label label = new Label();
            if (z3) {
                _isFlag(methodVisitor, context, i4, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i4]);
            if (z3) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        private final JavaBeanInfo beanInfo;
        private final String className;
        private final Class<?> clazz;
        private FieldInfo[] fieldInfoList;
        private int variantIndex;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i4) {
            this.variantIndex = -1;
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i4;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            return cls == null ? this.clazz : cls;
        }

        public int var(String str, int i4) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i4;
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i4 = this.variantIndex;
                this.variantIndex = i4 + 1;
                map.put(str, Integer.valueOf(i4));
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            methodWriter.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(183, ASMUtils.type(context.getInstClass()), "<init>", "()V");
            methodWriter.visitInsn(176);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}
