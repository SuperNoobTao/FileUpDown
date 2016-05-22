package cn.edu.zucc.action;

import cn.edu.zucc.model.FileupdownBean;
import cn.edu.zucc.service.FileService;
import cn.edu.zucc.util.method;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


import java.io.*;

public class FileUploadAction extends ActionSupport
{
    //private String username;
    private FileService fileService;

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    //注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;

    //提交过来的file的名字
    private String fileFileName;

    //提交过来的file的MIME类型
    private String fileContentType;

//    public String getUsername()
//    {
//        return username;
//    }
//
//    public void setUsername(String username)
//    {
//        this.username = username;
//    }

    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType)
    {
        this.fileContentType = fileContentType;
    }

    @Override
    public String execute() throws Exception
    {
        String root = ServletActionContext.getServletContext().getRealPath("/upload");

        InputStream is = new FileInputStream(file);

        OutputStream os = new FileOutputStream(new File(root, fileFileName));

        System.out.println("fileFileName: " + fileFileName);

        // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getPath());
        System.out.println(root);

        byte[] buffer = new byte[500];
        int length = 0;

        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();



        FileupdownBean fileupdownBean = new FileupdownBean();
        fileupdownBean.setName(fileFileName);
        fileupdownBean.setPath(root);
        fileupdownBean.setFormat("."+method.fomat(fileFileName));
        int i = fileService.add(fileupdownBean);


        return SUCCESS;
    }





}


