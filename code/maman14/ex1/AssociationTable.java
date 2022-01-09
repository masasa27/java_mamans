package code.maman14.ex1;

import java.util.*;

public class AssociationTable {

    private  TreeMap<Object, Object> tree_map = new TreeMap<Object, Object>();


    public boolean contains(Object key) {
        return tree_map.containsKey(key);
    }

    public boolean remove(Object key) {
        if (this.contains(key)) {
            this.tree_map.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public void add(Object key, Object value) {
        this.tree_map.put(key, value);
    }

    public Object get(Object key)
    {
        if (this.contains(key))
        {
            return this.tree_map.get(key);
        }
        return null;
    }

    public Iterator keyIterator()
    {
        return tree_map.keySet().iterator();
    }
}