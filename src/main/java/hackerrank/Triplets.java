package hackerrank;

import java.util.*;

public class Triplets {

    static long countTriplets(List<Long> arr, long r) {

        if (arr.size() < 3)
            return 0;

        Long[] objects = arr.toArray(new Long[]{});

        Map<Long, List<Integer>> elements = new HashMap<>();

        for (int i = 0; i < objects.length; i++) {
            List<Integer> indexes = elements.get(objects[i]);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            elements.put(objects[i], indexes);
        }

        long triplets = 0;
        Set<Long> longs = elements.keySet();
        for (Long aLong : longs) {

            long firstTripletElem = aLong;
            long secondTripletElem = firstTripletElem * r;
            long thirdTripletElem = secondTripletElem * r;

            List<Integer> indexesOfFirstElem = elements.get(firstTripletElem);
            List<Integer> indexesOfSecondElem = elements.get(secondTripletElem);
            List<Integer> indexesOfThirdElem = elements.get(thirdTripletElem);

            if (indexesOfFirstElem != null && indexesOfSecondElem != null && indexesOfThirdElem != null) {
                for (Integer integer : indexesOfFirstElem) {
                    for (Integer integer1 : indexesOfSecondElem) {
                        for (Integer integer2 : indexesOfThirdElem) {
                            triplets++;
                        }
                    }
                }
            }
        }
        return triplets;
    }


}
