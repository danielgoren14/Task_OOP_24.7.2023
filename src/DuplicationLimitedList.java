import java.util.*;
import java.util.stream.Collectors;

public class DuplicationLimitedList<T> {
    private List<T> limitedList;

    public DuplicationLimitedList () {
        this.limitedList = new ArrayList<>();
    }
    public boolean existDeclarative (T element) {
        return this.limitedList.stream().anyMatch(t -> t == element);
    }

    public void addDeclarative (T element) {
        if (isCurrentObjectLegalDeclarative(element)) {
            System.out.println("element "+ element +" is legal");
            this.limitedList.add(element);
        } else {
            System.out.println("element "+ element +" is illegal");
        }
    }

    public boolean isCurrentObjectLegalDeclarative (T element) {
        int counter = getCounterDeclarative(element);
        return counter == 3 ? false : true;
    }

    public int getCounterDeclarative (T element) {
        return Collections.frequency(this.limitedList, element);
    }

    public void add (T element) {
        if (isCurrentObjectLegal(element)) {
            this.limitedList.add(element);
            System.out.println("The object added successfully!");
        } else {
            System.out.println("there are already three equal objects in the list " + element.toString());
        }
    }
    public boolean isCurrentObjectLegal (T object) {
        int counter = getCount(object);
        return counter == 3 ? false : true;
    }

    public int getCount (Object element) {
        int counter = 0;
        for (Object tObject : this.limitedList) {
            if (tObject.equals(element)) {
                counter ++;
            }
        }
        return counter;
    }

    public void remove (T element) {
        if (exist(element)) {
            System.out.println("element " + element + " will be removed in a moment");
            this.limitedList.remove(element);
        } else {
            System.out.println("element "+ element +" is not even exist");
        }
    }

    public boolean exist (Object element) {
        boolean result = false;
        for (Object object : this.limitedList) {
            if (object.equals(element)) {
                result = true;
            }
        }
        return result;
    }

    public Map<T, Integer> getFrequency () {
        Map<T, Integer> result = new HashMap<>();
        for (T element : this.limitedList) {
            Integer frequency = getCount(element);
            result.put(element, frequency);
        }
        return result;
    }
    public void merge (DuplicationLimitedList<T> duplicationLimitedList) {
        for (T element : duplicationLimitedList.getLimitedList()) {
            int counterThis = getCount(element);
            if (counterThis == 3) {
                System.out.println("this list is Already full in this element");
            } else if (counterThis < 3){
                this.limitedList.add(element);
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DuplicationLimitedList<?> that = (DuplicationLimitedList<?>) o;

        return Objects.equals(limitedList, that.limitedList);
    }

    @Override
    public int hashCode() {
        return limitedList != null ? limitedList.hashCode() : 0;
    }

    public List<T> getLimitedList() {
        return limitedList;
    }

    public void setLimitedList(List<T> limitedList) {
        this.limitedList = limitedList;
    }

    @Override
    public String toString() {
        return "DuplicationLimitedList{" +
                "limitedList=" + limitedList +
                '}';
    }

    public static void main (String[] args) {
        DuplicationLimitedList duplicationLimitedList = new DuplicationLimitedList();
        String obj1 = "a";
        duplicationLimitedList.add(obj1);
        duplicationLimitedList.add(obj1);
        duplicationLimitedList.add(obj1);
        duplicationLimitedList.add(obj1);

        List<String> obj2 = new ArrayList<>();
        obj2.add("e");
        duplicationLimitedList.add(obj2);
        duplicationLimitedList.add(obj2);
        duplicationLimitedList.add(obj2);
        duplicationLimitedList.add(obj2);

        List<Integer> obj5 = new ArrayList<>();
        obj5.add(5);
        obj5.add(6);
        duplicationLimitedList.addDeclarative(obj5);

        List<Integer> integerList = new ArrayList<>();
        int number = 1;
        integerList.add(1);

        System.out.println("7" + duplicationLimitedList.exist(7));
        duplicationLimitedList.remove(number);
        duplicationLimitedList.remove(obj2);
        System.out.println(duplicationLimitedList.getCount(obj1));
        System.out.println(duplicationLimitedList.getCounterDeclarative(obj1));
        System.out.println(duplicationLimitedList.getCount(obj2));
        System.out.println(duplicationLimitedList.getCounterDeclarative(obj2));

        System.out.println(duplicationLimitedList.getFrequency());

        DuplicationLimitedList duplicationLimitedList1 = new DuplicationLimitedList();

        String obj3 = "c";
        duplicationLimitedList.add(obj3);
        duplicationLimitedList.add(obj3);
        duplicationLimitedList.add(obj3);
        duplicationLimitedList.add(obj3);

        String obj4 = "d";
        duplicationLimitedList.add(obj4);
        duplicationLimitedList.add(obj4);
        duplicationLimitedList.add(obj4);
        duplicationLimitedList.add(obj4);

        duplicationLimitedList.merge(duplicationLimitedList1);

        System.out.println(duplicationLimitedList.toString());
    }
}
