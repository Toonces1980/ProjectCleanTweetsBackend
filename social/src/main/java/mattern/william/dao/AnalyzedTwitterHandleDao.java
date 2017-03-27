package mattern.william.dao;

import mattern.william.entity.AnalyzedTwitterHandle;

import java.util.Collection;

/**
 * Created by williammattern on 3/27/17.
 */
public interface AnalyzedTwitterHandleDao {
    Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles();

    AnalyzedTwitterHandle getAnalyzedTwitterHandleByID(int id);

    AnalyzedTwitterHandle getAnalyzedTwitterHandleByHandle(String handle);

    void removeHandleByID(int id);

    void removeHandleByHandle(String handle);

    void insertHandle(AnalyzedTwitterHandle handle);

}
