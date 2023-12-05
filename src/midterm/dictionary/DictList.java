package midterm.dictionary;

class DictList implements ListInterface {
    private String[] items;

    public DictList() {
        this.items = new String[0];
    }

    @Override
    public void addItem(String item) {
        String[] newItems = new String[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[items.length] = item;
        items = newItems;
    }

    @Override
    public String getItem(int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        } else {
            return null;
        }
    }
    public int indexOf(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int getSize() {
        return items.length;
    }
}
