public class ItemStack {
    private Item item;
    private int quantity;
    public ItemStack() {
        item = new Item();
        quantity = 0;
    }

    public ItemStack(Item item, int quantity) {
        this.item = item;
        if(quantity < 0 || quantity > item.getMaxStackSize()){
            System.out.println("Invalid quantity");
            return;
        }
        this.quantity = quantity;
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0 || quantity > item.getMaxStackSize()){
            System.out.println("Invalid quantity");
            return;
        }
        this.quantity = quantity;
    }
}
