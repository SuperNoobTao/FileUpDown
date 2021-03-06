package cn.edu.zucc.service;

import cn.edu.zucc.model.FileupdownBean;

import java.util.List;

/**
 * Created by shentao on 2016/5/18.
 */
public interface FileService {

    public List<FileupdownBean> getList();
    public int add(FileupdownBean fileupdownBean);
    public int delete(FileupdownBean fileupdownBean);
    public int update(FileupdownBean fileupdownBean);
    public FileupdownBean getById(Integer id);
}
