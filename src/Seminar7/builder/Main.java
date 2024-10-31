package Seminar7.builder;

import Seminar7.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
     BigCard bigcardBuilder = new BigCard();
     System.out.println(
             bigcardBuilder
             .setColorFront("белый")
             .setColorBack("красный")
             .build()
     );

     SmallCard smallcardBuilder = new SmallCard();
     System.out.println(smallcardBuilder.build());

    }
}
