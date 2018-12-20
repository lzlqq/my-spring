package com.leo.spring.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeoClassLoader extends ClassLoader {

    private File baseDir;

    public LeoClassLoader(){
        String basePath = LeoClassLoader.class.getResource("").getPath();
        this.baseDir=new File(basePath);
    }
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        String className=LeoClassLoader.class.getPackage().getName()+"."+name;
        if(baseDir!=null){
            File classFile=new File(baseDir,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in =null;
                ByteArrayOutputStream out = null;
                try {
                    in=new FileInputStream(classFile);
                    out=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int len;
                    while((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }
            }
        }

        return null;
    }
}
