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
                put(1, new AnalyzedTwitterHandle("realdonaldtrump", 75, 50));
                put(2, new AnalyzedTwitterHandle("normmacdonald", 42, 50));
                put(3, new AnalyzedTwitterHandle("oprah", 142, 50));
            }
        };
    }

    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        return this.analyzedTwitterHandles.values();
    }
}
