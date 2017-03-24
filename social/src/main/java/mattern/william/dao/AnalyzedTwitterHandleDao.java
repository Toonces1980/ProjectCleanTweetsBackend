package mattern.william.dao;

import mattern.william.entity.AnalyzedTwitterHandle;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AnalyzedTwitterHandleDao {

    private static HashMap<Integer, AnalyzedTwitterHandle> analyzedTwitterHandles;

    static {
        analyzedTwitterHandles = new HashMap<Integer, AnalyzedTwitterHandle>() {
            {
                put(1, new AnalyzedTwitterHandle(1,"realdonaldtrump", 75, 50));
                put(2, new AnalyzedTwitterHandle(2,"normmacdonald", 42, 50));
                put(3, new AnalyzedTwitterHandle(3,"oprah", 142, 50));
            }
        };
    }

    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        return analyzedTwitterHandles.values();
    }

    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByID(int id){
        return analyzedTwitterHandles.get(id);
    }

    public void removeHandleByID(int id){
        analyzedTwitterHandles.remove(id);
    }

    public void removeHandleByHandle(String handle){
        for(AnalyzedTwitterHandle theHandle:analyzedTwitterHandles.values()){
            if(theHandle.getTwitterHandle().equals(handle)){
                analyzedTwitterHandles.remove(theHandle.getId());
            }
        }
    }

    public void insertHandle(AnalyzedTwitterHandle handle) {
        analyzedTwitterHandles.put(handle.getId(),handle);
    }

    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByHandle(String handle) {
        for(AnalyzedTwitterHandle analyzedHandle:analyzedTwitterHandles.values()){
            if(analyzedHandle.getTwitterHandle().equals(handle)){
                return analyzedHandle;
            }
        }
        return null;
    }
}
