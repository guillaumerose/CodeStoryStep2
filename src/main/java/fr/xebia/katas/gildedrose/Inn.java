package fr.xebia.katas.gildedrose;

import static com.google.common.collect.Lists.transform;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

public class Inn {
    public List<Item> items;

    public Inn() {
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (!isBrie(item) && !isBackstage(item)) {
                if (item.getQuality() > 0) {
                    if (!isSulfura(item)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (isBackstage(item)) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!isSulfura(item)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!isBrie(item)) {
                    if (!isBackstage(item)) {
                        if (item.getQuality() > 0) {
                            if (!isSulfura(item)) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }

    }

    private boolean isSulfura(Item item) {
        return item.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isBrie(Item item) {
        return item.getName().equals("Aged Brie");
    }

    public static void main(String[] args) {
        Inn inn = new Inn();
        for (int i = 0; i < 60; i++) {
            System.out.println(itemsAsString(inn));
            inn.updateQuality();
        }
    }

    public static String itemsAsString(Inn inn) {
        return Joiner.on("; ").join(transform(inn.items, TO_STRING));
    }

    public static Function<Item, String> TO_STRING = new Function<Item, String>() {
        @Override
        public String apply(Item item) {
            return item.getName() + ": (" + item.getSellIn() + ", " + item.getQuality() + ")";
        }
    };
}
