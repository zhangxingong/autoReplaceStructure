package com.hdms.test;

import com.hdms.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class ClasssPathTest {
    @Test
    public void getClassPath() {
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);
    }

    @Test
    public void getProjectPath() throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        File file = new File(courseFile);
        String parent = file.getParent();
        System.out.println(parent);
    }

    @Test
    public void listAllFiles() throws IOException {
        String directory = com.hdms.util.FileUtils.getWorkSpace();
        if (StringUtils.isValid(directory)) {
            File workspace = new File(directory);
            if (workspace.isDirectory()) {
                File[] listFiles = workspace.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                       return pathname.isFile() && pathname.getName().endsWith(".jsp");
                    }
                });
                for (File listFile : listFiles) {
                    System.out.println(listFile.getName());
                }
            }
        }
    }

    @Test
    public void getJarPath() throws IOException {
        System.out.println("java_vendor:"  + System.getProperty( "java.vendor" ));
        System.out.println("java_vendor_url:"
                + System.getProperty("java.vendor.url" ));
        System.out.println("java_home:"  + System.getProperty( "java.home" ));
        System.out.println("java_class_version:"
                + System.getProperty("java.class.version" ));
        System.out.println("java_class_path:"
                + System.getProperty("java.class.path" ));
        System.out.println("os_name:"  + System.getProperty( "os.name" ));
        System.out.println("os_arch:"  + System.getProperty( "os.arch" ));
        System.out.println("os_version:"  + System.getProperty( "os.version" ));
        System.out.println("user_name:"  + System.getProperty( "user.name" ));
        System.out.println("user_home:"  + System.getProperty( "user.home" ));
        System.out.println("user_dir:"  + System.getProperty( "user.dir" ));
        System.out.println("java_vm_specification_version:"
                + System.getProperty("java.vm.specification.version" ));
        System.out.println("java_vm_specification_vendor:"
                + System.getProperty("java.vm.specification.vendor" ));
        System.out.println("java_vm_specification_name:"
                + System.getProperty("java.vm.specification.name" ));
        System.out.println("java_vm_version:"
                + System.getProperty("java.vm.version" ));
        System.out.println("java_vm_vendor:"
                + System.getProperty("java.vm.vendor" ));
        System.out
                .println("java_vm_name:"  + System.getProperty( "java.vm.name" ));
        System.out.println("java_ext_dirs:"
                + System.getProperty("java.ext.dirs" ));
        System.out.println("file_separator:"
                + System.getProperty("file.separator" ));
        System.out.println("path_separator:"
                + System.getProperty("path.separator" ));
        System.out.println("line_separator:"
                + System.getProperty("line.separator" ));
    }

}
