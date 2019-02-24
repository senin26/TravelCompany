package user;

public enum UserCategory implements UserDiscount {

    FIRST_TIME {
        @Override
        public int getDiscount() {
            return 5;
        }
    },
    BRONZE {
        @Override
        public int getDiscount() {
            return 10;
        }
    },
    SILVER {
        @Override
        public int getDiscount() {
            return 15;
        }
    },
    GOLD {
        @Override
        public int getDiscount() {
            return 20;
        }
    };

    UserCategory() {
    }



}
