package midterm.dictionary;

public class Dictionary {
    private DictList englishList;
    private DictList vietnameseList;

    public Dictionary() {
        this.englishList = new DictList();
        this.vietnameseList = new DictList();
    }

    // Phương thức để nạp từ điển từ hai mảng tiếng Anh và tiếng Việt
    public void loadDictionary(String[] en, String[] vi) {
        for (String word : en) {
            englishList.addItem(word);
        }

        for (String word : vi) {
            vietnameseList.addItem(word);
        }
    }

    // Phương thức để dịch danh sách tiếng Anh sang tiếng Việt
    public DictList translate(DictList en) {
        DictList vi = new DictList();

        for (int i = 0; i < en.getSize(); i++) {
            String englishWord = en.getItem(i);
            String vietnameseTranslation = getVietnameseTranslation(englishWord);
            vi.addItem(vietnameseTranslation);
        }

        return vi;
    }

    private String getVietnameseTranslation(String englishWord) {
        int index = englishList.indexOf(englishWord);
        if (index != -1) {
            return vietnameseList.getItem(index);
        } else {
            return "Not found";
        }
    }

    // Các phương thức khác có thể thêm vào nếu cần
    public static void main(String[] args) {
        String[] en = {"one", "two", "three", "four"};
        String[] vi = {"mot", "hai", "ba", "bon"};
        Dictionary dc = new Dictionary();
        dc.loadDictionary(en, vi);
        DictList enl = new DictList();
        enl.addItem("one");
        enl.addItem("two");
        enl.addItem("three");
        DictList tran = dc.translate(enl);
        for (int i = 0; i < tran.getSize(); i++) {
            System.out.println(tran.getItem(i));
        }
    }
}
