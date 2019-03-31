package common.solutions.paginator;

import common.business.domain.BaseDomain;

import java.util.List;

public final class Paginator {

    private Paginator() {
    }

    public static void show(List<? extends BaseDomain> list, int instancesOnPage) {
        print(list, instancesOnPage);
    }

    private static void print(List<? extends BaseDomain> list, int instancesOnPage) {
        int count = 1;
        int pageNumber = 1;
        System.out.println("///Page number 1///");
        for (BaseDomain each : list
        ) {
            System.out.printf("---(%d)---" + each.toString() + "\n", count);
            if (count == (instancesOnPage)) {
                System.out.println("---------------------");
                pageNumber++;
                System.out.printf("///Page number %d///\n", pageNumber);
                count = 1;
                continue;
            }
            count++;
        }
    }

}
