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
            
            final int sellIn = item.getSellIn() - 1;
            if (!isSulfura(item)) {
                item.setSellIn(sellIn);
            }

            int quality = item.getQuality();
            if (isBrie(item)) {
                quality = qualityIncreaseBy(item, 1);
                if (sellIn < 0) {
                    quality = qualityIncreaseBy(item, 1);
                }
            } else if (isBackstage(item)) {
                quality = qualityIncreaseBy(item, 1);

                if (sellIn < 5) {
                    quality = qualityIncreaseBy(item, 1);
                }

                if (sellIn < 10) {
                    quality = qualityIncreaseBy(item, 1);
                }
                
                if (sellIn < 0) {
                    quality = qualityIncreaseBy(item, -quality);
                }
            } else if (isSulfura(item)) {
            } else {
                quality = qualityIncreaseBy(item, -1);
                if (sellIn < 0) {
                    quality = qualityIncreaseBy(item, -1);
                }
            }
        }

    }

    private int qualityIncreaseBy(Item item, int inc) {
        final int askedQuality = item.getQuality() + inc;
        if (askedQuality >= 0 && askedQuality <= 50) {
            item.setQuality(askedQuality);
        }
        return item.getQuality();
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
