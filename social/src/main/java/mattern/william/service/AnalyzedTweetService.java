package mattern.william.service;

import mattern.william.dao.AnalyzedTwitterHandleDao;
import mattern.william.entity.AnalyzedTwitterHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnalyzedTweetService {

    @Autowired
    private AnalyzedTwitterHandleDao analyzedTwitterHandleDao;

    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        return analyzedTwitterHandleDao.getAllAnalyzedTwitterHandles();
    }
}
