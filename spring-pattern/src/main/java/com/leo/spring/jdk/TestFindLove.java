package com.leo.spring.jdk;

import com.leo.spring.cglib.LeoCglibMeipo;
import com.leo.spring.cglib.LiSi;
import com.leo.spring.custom.LeoMeipo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestFindLove {

    public static void main(String[] args) {
        try {
            testJDKProxy();
            testCustomProxy();
            testCglib();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看源代码知道，代理类继承Proxy类,并且实现了被代理类实现的接口
     * 代理类的成员变量为InvocationHandler 接口的实现类的实例，如本例是Meipo类的实例，而Meipo类的实例初始化传入了目标对象
     * 调用目标接口的方法，实际上执行的是代理类实现的接口的方法，方法内部是调用其成员变量InvocationHandler接口实现类的实例的invoke方法
     * 也就是Meipo中的invoke方法，所以Meipo中只需要method.invoke(target.args),而不用使用proxy.invoke()了
     * 另外，jdk动态代理默认实现的有Object的equals，hashCode，toString三个方法以及接口的方法
     * 所以调用这三个默认方法，也会走代理类的方法
     */
    private static void testJDKProxy() throws IOException {


        Person person = (Person) new Meipo().getInstance(new Zhansan());
        System.out.println(person);
        System.out.println(person.getClass());
        person.findLove();

        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("D:/common_lib/src/$Proxy0.class");
        os.write(data);
        os.close();
    }

    private static void testCustomProxy() {
        Person person = (Person) new LeoMeipo().getInstance(new Zhansan());
        System.out.println(person);
        System.out.println(person.getClass());
        person.findLove();
    }


    /**
     * JDK的动态代理是通过接口来进行强制转换的
     * 生成以后的代理对象，可以强制转换为接口
     *
     * CGLib的动态代理是通过生成一个被代理对象的子类，然后重写父类的方法
     * 生成以后的对象，可以强制转换为被代理对象（也就是用自己写的类）
     * 子类引用赋值给父类
     */
    private static void testCglib() {


        try {
            LiSi obj = (LiSi) new LeoCglibMeipo().getInstance(LiSi.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
