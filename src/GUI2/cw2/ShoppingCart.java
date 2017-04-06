package GUI2.cw2;

public class ShoppingCart extends AbstractBox {

    public ShoppingCart(Customer owner) {
        super(owner, owner.getFlowerList());
    }

    @Override
    public String getName() {
        return "Wózek";
    }

}
