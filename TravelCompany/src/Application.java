import user.domain.ClientType;
import user.domain.User;

public class Application {

    public static void main(String[] args) {

        User[] users = new User[];

        employeeList.add(new Employee("Max Kuznetsov", "Technical lead", "max_k@coolhacker.com",  7_86_21, 5000, 41));
        employeeList.add(new Employee("Oksana Smirnova", "QA", "oksana_s@coolhacker.com", 7_88_09, 3000, 25));
        employeeList.add(new Employee("Viacheslav Kosogor", "Senior developer", "slava_k@coolhacker.com", 7_65_22, 4500, 42));
        employeeList.add(new Employee("Evgenii Gordon", "Middle developer", "john_g@coolhacker.com", 7_57_40, 3500, 23));
        employeeList.add(new Employee("Yana Chernyshiova", "Junior developer", "yana_ch@coolhacker.com", 7_32_85, 3000, 24));


        System.out.println(ClientType.isStrBelongsToEnum("FAVOURITE"));
        System.out.println(ClientType.isStrBelongsToEnum("No name"));


    }

}
