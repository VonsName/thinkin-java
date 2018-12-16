//package gen;
//
//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassWriter;
//import jdk.internal.org.objectweb.asm.Opcodes;
//import jdk.internal.org.objectweb.asm.tree.*;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.security.ProtectionDomain;
//import java.util.List;
//
//public class MyTransformer implements ClassFileTransformer {
//    @SuppressWarnings({ "restriction", "deprecation" })
//	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        ClassReader classReader = new ClassReader(classfileBuffer);
//        ClassNode classNode = new ClassNode();
//        classReader.accept(classNode, 0);
//        List<MethodNode> methods = classNode.methods;
//        for (MethodNode method : methods) {
//
//            if ("<init>".endsWith(method.name) || "<clinit>".equals(method.name)) {
//                continue;
//            }
//            InsnList instructions = method.instructions;
//            InsnList insnList = new InsnList();
//            insnList.add(new FieldInsnNode(Opcodes.GETFIELD, "java/lang/System", "out", "Ljava/io/PrintStream;"));
//            insnList.add(new LdcInsnNode("Enter method-> " + classNode.name + "." + method.name));
//            insnList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));
//            instructions.insert(insnList);
//            method.maxStack += 3;
//        }
//        ClassWriter classWriter = new ClassWriter(0);
//        classNode.accept(classWriter);
//        return classWriter.toByteArray();
//    }
//}
