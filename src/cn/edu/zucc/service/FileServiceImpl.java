package cn.edu.zucc.service;

import cn.edu.zucc.dao.FileDao;
import cn.edu.zucc.dao.FileDaoImpl;
import cn.edu.zucc.model.FileupdownBean;

import java.util.List;

/**
 * Created by shentao on 2016/5/18.
 */
public class FileServiceImpl implements FileService{

    private FileDao fileDao;

    public FileDao getFileDao() {
        return fileDao;
    }

    public void setFileDao(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public List<FileupdownBean> getList() {
        return fileDao.getList();
    }

    @Override
    public int add(FileupdownBean fileupdownBean) {

        return fileDao.add(fileupdownBean);
    }

    @Override
    public int delete(FileupdownBean fileupdownBean) {
        return fileDao.delete(fileupdownBean);
    }

    @Override
    public int update(FileupdownBean fileupdownBean) {
        return fileDao.update(fileupdownBean);
    }

    @Override
    public FileupdownBean getById(Integer id) {
        return fileDao.getById(id);
    }
}
