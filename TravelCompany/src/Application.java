import user.domain.ClientType;

public class Application {

    public static void main(String[] args) {

        System.out.println(ClientType.isStrBelongsToEnum("FAVOURITE"));
        System.out.println(ClientType.isStrBelongsToEnum("No name"));


    }

}
