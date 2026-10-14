public class Test {
    public static void main(String[] args) {
        Item stone = new Item("石头", 64);
        Item planks = new Item("木板", 64);
        Item diamondSword = new Item("钻石剑", 1);

        Inventory inventory = new Inventory();
        inventory.setCapacity(36);
        inventory.display();

        inventory.addItem(new ItemStack(stone,30));
        inventory.display();

        inventory.addItem(new ItemStack(stone,40));
        inventory.display();

        inventory.addItem(new ItemStack(diamondSword,1));
        inventory.display();

        inventory.removeItem("石头", 10);
        inventory.display();
    }
}
