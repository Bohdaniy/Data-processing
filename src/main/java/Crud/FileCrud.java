package Crud;

import Entity.Entity;
import FileIO.FileIO;
import FileIO.FileIOInterface;

public class FileCrud implements Lab2CrudInterface {
    FileIOInterface fio;
    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public Entity readEntity() {
        return (Entity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(Entity Entity) {
        fio.saveToFile(Entity);

    }
}
