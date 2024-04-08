package Mock;
import Crud.Lab2CrudInterface;
import Entity.Entity;

public class Lab2CrudMock implements Lab2CrudInterface {
    @Override
    public Entity readEntity(){

        return new Entity("Mock1",24,3.2f);
    }

    @Override
    public void updateEntity(Entity Entity) {

    }
}
