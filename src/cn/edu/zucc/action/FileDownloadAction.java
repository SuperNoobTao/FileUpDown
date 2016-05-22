package cn.edu.zucc.action;

import cn.edu.zucc.model.FileupdownBean;
import cn.edu.zucc.service.FileService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shentao on 2016/5/17.
 */
public class FileDownloadAction extends ActionSupport
{
    private FileService fileService;
    private FileupdownBean fileupdownBean = new FileupdownBean();
    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public InputStream getDownloadFile()
    {
        return ServletActionContext.getServletContext().getResourceAsStream("upload/account-licenses.xls");
    }


    public String getDownList() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        ArrayList<FileupdownBean> list = (ArrayList<FileupdownBean>) fileService.getList();
        request.setAttribute("news", list);
        return "List";
    }


    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
}