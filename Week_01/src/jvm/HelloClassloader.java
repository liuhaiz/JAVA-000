package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 刘海忠
 * @description 作业2
 * @date 2020/10/16
 */
public class HelloClassloader extends ClassLoader {
	public static void main(String[] args) {
		try {
			Class<?> helloClass = new HelloClassloader().findClass("Hello");
			Object o = helloClass.newInstance();
			Method method = helloClass.getMethod("hello");
			method.invoke(o);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Class<?> findClass(String name) {
		File file = new File(this.getClass().getResource("Hello.xlass").getPath());
		byte[] bytes = new byte[(int) file.length()];
		try {
			new FileInputStream(file).read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (255 - bytes[i]);
		}
		return defineClass(name, bytes, 0, bytes.length);
	}
}
