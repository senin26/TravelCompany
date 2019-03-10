package user.search;

import user.domain.User;
import user.search.sort.SortCondition;
import user.search.sort.SortOrderDirection;
import user.search.sort.SortUserField;

import java.util.*;

import static storage.Storage.usersList;

public class UserSorting {

    SortCondition sortCondition;
    private List<User> sortingList;

    public UserSorting(SortCondition sortCondition) {
        this.sortCondition = sortCondition;
        sortingList = new ArrayList<>(usersList);
    }

    public List sort(int field) {
        sortingList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                if (sortCondition.getSortUserField()[field].equals(SortUserField.BY_NAME)) {
                    if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.DESC)){
                        return -u1.getFirstName().compareTo(u2.getFirstName());
                    }
                    else if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.ASC)){
                        return u1.getFirstName().compareTo(u2.getFirstName());
                    }
                }
                if (sortCondition.getSortUserField()[field].equals(SortUserField.BY_LAST_NAME)) {
                    if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.DESC)){
                        return -u1.getLastName().compareTo(u2.getLastName());
                    }
                    else if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.ASC)){
                        return u1.getLastName().compareTo(u2.getLastName());
                    }
                }
                if (sortCondition.getSortUserField()[field].equals(SortUserField.BY_AGE)) {
                    if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.DESC)){
                        return -Integer.compare(u1.getAge(), u2.getAge());
                    }
                    else if (sortCondition.getSortOrderDirection().equals(SortOrderDirection.ASC)){
                        return Integer.compare(u1.getAge(), u2.getAge());
                    }
                }
                return 0;
            }
        });
        return sortingList;
    }


    public List complexSort() {
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        int i = 0;
        for (User u:
                sortingList) {
            if (map.containsKey(u.getFirstName())) {
                ArrayList<Integer> tempList = map.get(u.getFirstName());
                tempList.add(i);
            }
            else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                map.put(u.getFirstName(), tempList);
            }
            i++;
        }

        Set<String> keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        List<User> listCopy = new ArrayList<>(sortingList);
        List<User> finalList = new ArrayList<>();
        List<User> tempList = new ArrayList<>();
        List<Integer> startEndList;
        int start;
        int end;

        while (iterator.hasNext()){
            startEndList = map.get(iterator.next());
            start = startEndList.get(0);
            if (startEndList.size()>1) {
                end = startEndList.get(startEndList.size()-1);
                if (end == (listCopy.size()-1)) {
                    tempList = new ArrayList<>(listCopy.subList(start, end));
                    tempList.add(listCopy.get(listCopy.size()-1));
                }
                else {
                    tempList = new ArrayList<>(listCopy.subList(start, end+1));
                }
                sortingList = tempList;
                sort(1);
            }
            else {
                tempList.clear();
                tempList.add(listCopy.get(start));
                sortingList = tempList;
            }
            finalList.addAll(start, sortingList);
        }
        return finalList;
    }



}
