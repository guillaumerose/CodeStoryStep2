package fr.xebia.katas.gildedrose;

import static com.google.common.collect.Lists.transform;
import static java.lang.Math.max;
import static java.lang.Math.min;

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
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 50));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            
            final int sellIn = isSulfura(item) ? item.getSellIn() : item.getSellIn() - 1;
            item.setSellIn(sellIn);

            final int quality = min(max(0, 
                                        item.getQuality() + conjuredFactor(item) * increaseOfQualityFor(item)), 
                                    50);
            item.setQuality(quality);
        }

    }

    private int increaseOfQualityFor(Item item) {
        final int sellIn = item.getSellIn();
        final int quality = item.getQuality();
    
        if (isBrie(item)) {
            if (sellIn < 0) {
                return 2;
            }
            return 1;
        } else if (isBackstage(item)) {
            if (sellIn < 0) {
                return -quality;
            } else if (sellIn < 5) {
                return 3;
            } else if (sellIn < 10) {
                return 2;
            }
            return 1;
        } else if (isSulfura(item)) {
            return 0;
        }
        if (sellIn < 0) {
            return -2;
        }
        return -1;
    }

    private int conjuredFactor(Item item) {
        return isConjured(item) ? 2 : 1;
    }

    private boolean isConjured(Item item) {
        return item.getName().startsWith("Conjured");
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
        inn.updateQuality();
    }

    public String itemsAsString() {
        return Joiner.on("; ").join(transform(items, TO_STRING));
    }

    private static Function<Item, String> TO_STRING = new Function<Item, String>() {
        @Override
        public String apply(Item item) {
            return item.getName() + ": (" + item.getSellIn() + ", " + item.getQuality() + ")";
        }
    };
}
