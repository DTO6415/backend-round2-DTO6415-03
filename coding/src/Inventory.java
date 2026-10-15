import java.util.ArrayList;

public class Inventory {
    private int capacity;
    private ArrayList<ItemStack> items;
    public Inventory(){
        items = new ArrayList<ItemStack>();
    }
    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<ItemStack>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int addItem(ItemStack itemStackToAdd) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItem().getName().equals(itemStackToAdd.getItem().getName())) {
                if (items.get(i).getQuantity() + itemStackToAdd.getQuantity() <= items.get(i).getItem().getMaxStackSize()) {
                    items.get(i).setQuantity(items.get(i).getQuantity() + itemStackToAdd.getQuantity());
                    return capacity;
                } else {
                    itemStackToAdd.setQuantity(itemStackToAdd.getQuantity() + items.get(i).getQuantity() - itemStackToAdd.getItem().getMaxStackSize());
                    items.get(i).setQuantity(itemStackToAdd.getItem().getMaxStackSize());
                }
            }//执行完后，itemStackToAdd的quantity即为剩余未添加的数量
        }
        if (capacity > 0) {
            items.add(itemStackToAdd);
            return --capacity;
        } else {
            return -itemStackToAdd.getQuantity();
        }
    }

    public boolean removeItem(String itemName, int amountToRemove) {
        if(getItemCount(itemName) < amountToRemove) return false;
        for (int i = 0; i < items.size(); i++) {
            if (itemName.equals(items.get(i).getItem().getName())) {
                int nowQuantity = items.get(i).getQuantity();
                items.get(i).setQuantity(Math.max(nowQuantity - amountToRemove, 0));
                amountToRemove = Math.max(amountToRemove - nowQuantity, 0);
                if(items.get(i).getQuantity() == 0) {
                    items.remove(i--);
                    capacity++;
                }
            }
        }
        return true;
    }

    public int getItemCount(String itemName) {
        int nowCount = 0;
        for (int i = 0; i < items.size(); i++) {
            if (itemName.equals(items.get(i).getItem().getName()))
                nowCount += items.get(i).getQuantity();
        }
        return nowCount;
    }

    public ArrayList<String> getItemNameList() {
        ArrayList<String> itemNameList = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            if (!itemNameList.contains(items.get(i).getItem().getName()))
                itemNameList.add(items.get(i).getItem().getName());
        }
        return itemNameList;
    }

    public void display() {
        if (items.size() > 0) {
            System.out.println("背包中的物品如下:");
            ArrayList<String> itemNameList = getItemNameList();
            for (int i = 0; i < itemNameList.size(); i++) {
                System.out.println(itemNameList.get(i) + "，数量为: " + getItemCount(itemNameList.get(i)));
            }
            System.out.println("--------------------");
            System.out.println("背包的状态如下：");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i).getItem().getName() + "，数量为: " + items.get(i).getQuantity());
            }
        } else {
            System.out.println("背包为空");
        }
        System.out.println("展示完毕");
        System.out.println("--------------------");
    }
}
