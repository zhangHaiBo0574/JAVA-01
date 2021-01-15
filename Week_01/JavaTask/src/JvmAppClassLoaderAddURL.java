import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;

public class JvmAppClassLoaderAddURL extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String Hellobase64 = null;
        try {
            Hellobase64 = encodeBase64File("E:/javaclass/Hello.xlass");
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] bytes = decode(Hellobase64);
        return defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args)
    {
        try {
            Object o=  new JvmAppClassLoaderAddURL().findClass("Hello").newInstance();
            Method[] methods = o.getClass().getMethods();
            Method[] decaradMethods = o.getClass().getDeclaredMethods();
            for (Method m :methods)
            {
                System.out.println(m.toString());
            }
            try {
                o.getClass().getMethod("hello").invoke(o);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static String encodeBase64File(String path) throws Exception
    {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
                inputStream.read(buffer);
                inputStream.close();
            String replace = new BASE64Encoder().encode(buffer).replace("\r\n","");
             return replace;
    }
    public byte[] decode(String base64)
    {
        byte[] decode = Base64.getDecoder().decode(base64);
        byte a=(byte)255;
        for (int i=0;i<decode.length;i++)
        {
            byte b =decode[i];
            decode[i] = (byte)(a-b);
        }
        return decode;
    }
}
