package mattern.william.service;

import mattern.william.dao.AnalyzedTwitterHandleDao;
import mattern.william.dao.HashMapDaoImpl;
import mattern.william.entity.AnalyzedTwitterHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnalyzedTweetService {

    @Autowired
    @Qualifier("mysql")
    private AnalyzedTwitterHandleDao analyzedTwitterHandleDao;

    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        return analyzedTwitterHandleDao.getAllAnalyzedTwitterHandles();
    }

    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByID(int id){
        return analyzedTwitterHandleDao.getAnalyzedTwitterHandleByID(id);
    }

    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByHandle(String handle){
        return analyzedTwitterHandleDao.getAnalyzedTwitterHandleByHandle(handle);
    }

    public void removeHandle(int id){
        analyzedTwitterHandleDao.removeHandleByID(id);
    }

    public void removeHandle(String twitterHandle){
        analyzedTwitterHandleDao.removeHandleByHandle(twitterHandle);
    }

    public void updateHandleByID(int id){
        analyzedTwitterHandleDao.removeHandleByID(id);
    }

    public void createNewHandle(AnalyzedTwitterHandle handle){
        analyzedTwitterHandleDao.insertHandle(handle);
    }
}
