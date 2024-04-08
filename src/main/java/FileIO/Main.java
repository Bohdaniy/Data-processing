package FileIO;

import Entity.Entity;


public class Main {
    public static void main(String[] args){
        Entity Entity = new Entity("Mock1",24,3.2f);

        FileIOInterface fio = new FileIO();
        fio.saveToFile(Entity);
        System.out.println((Entity) fio.loadFromFile());
    }
}
