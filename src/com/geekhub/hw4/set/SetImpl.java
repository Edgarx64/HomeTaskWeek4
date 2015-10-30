package com.geekhub.hw4.set;

import java.util.Set;
import java.util.TreeSet;

public class SetImpl<T> implements SetOperations {
    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set<T> union(Set a, Set b) {
        Set<T> result = new TreeSet<>(a);
        result.addAll(b);
        return result;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set<T> result = new TreeSet<>(a);
        result.removeAll(b);
        return result;
    }

    @Override
    public Set intersect(Set a, Set b) {
        TreeSet<T> result = new TreeSet(a);
        result.retainAll(b);
        return result;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        SetImpl<T> operation = new SetImpl<>();
        Set<T> unionSet = operation.union(a,b);
        Set<T> intersectSet = operation.intersect(a,b);
        return operation.subtract(unionSet, intersectSet);
    }
}
