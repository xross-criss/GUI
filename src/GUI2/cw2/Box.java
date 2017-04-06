package GUI2.cw2;

import java.util.ArrayList;
import java.util.List;

public class Box extends AbstractBox {

    private List<Flower> flowerList;

    public Box(Customer owner) {
        super(owner, new ArrayList<>());
    }

    @Override
    public String getName() {
        return "Pudełko";
    }

}
