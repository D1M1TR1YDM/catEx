import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int age = 0;
        int dogAge = 0;
        int catAge = 0;
        int mouseAge = 0;
        int count = 0;
        LinkedList<Animal> listFirst = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 51; i++) {
            Animal cat = new Cat("Cat", i);
            Animal dog = new Dog("Dog", i);
            int index = random.nextInt(listFirst.size() + 1);
            listFirst.add(index, cat);
            index = random.nextInt(listFirst.size());
            listFirst.add(index + 1, dog);
        }
        System.out.println(listFirst);
        for (int i = 0; i < listFirst.size(); i++) {
            if (listFirst.get(i) instanceof Cat) {
                count++;
            }
            if (count / 5 == 1) {
                count = 0;
                listFirst.remove(i);
            }
        }
        System.out.println(listFirst);
        count = 0;
        for (int i = 0; i < listFirst.size(); i++) {

            if (listFirst.get(i) instanceof Dog) {
                count++;
            }
            if (count / 3 == 1) {
                count = 0;
                Animal mouse = new Mouse("Mouse", age);
                age++;
                listFirst.add(i + 1, mouse);
                i++;
            }
        }
        System.out.println(listFirst);
        LinkedList<Animal> listSecond = new LinkedList<>();
        for (int i = 0; i < listFirst.size() - 1; i++) {
            if ((listFirst.get(i) instanceof Cat && listFirst.get(i + 1) instanceof Mouse) || (listFirst.get(i + 1) instanceof Cat && listFirst.get(i) instanceof Mouse)) {
                listSecond.add(listFirst.get(i));
                listFirst.remove(i);
                listSecond.add(listFirst.get(i));
                listFirst.remove(i);
            }

        }
        System.out.println(listFirst + "\n" + listSecond);
        listFirst.toArray();
        for (int i = 0; i < listFirst.size(); i++) {
            if (listFirst.get(i) instanceof Dog)
                dogAge += listFirst.get(i).getAge();
            if (listFirst.get(i) instanceof Cat)
                catAge += listFirst.get(i).getAge();
            if (listFirst.get(i) instanceof Mouse)
                mouseAge += listFirst.get(i).getAge();
        }
        System.out.println("mouse age " + mouseAge + " dog age " + dogAge + " cat age " + catAge);
        //    for (int i = 0; i < listSecond.size(); i ++){
        //       if (listSecond.get(i) instanceof Mouse)
        //           mouseAge += listSecond.get(i).getAge();
        //      if (listSecond.get(i) instanceof Cat)
        //          catAge += listSecond.get(i).getAge();
//
        //     }
        //     System.out.println(mouseAge +"   " + catAge);

    }
}