package fr.xebia.katas.gildedrose;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class InnTest {

    @Test
    public void should_not_loose_a_rule() throws Exception {
        String toCompare[] = {
                "+5 Dexterity Vest: (10, 20); Aged Brie: (2, 0); Elixir of the Mongoose: (5, 7); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (15, 20); Conjured Mana Cake: (3, 6)",
                "+5 Dexterity Vest: (9, 19); Aged Brie: (1, 1); Elixir of the Mongoose: (4, 6); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (14, 21); Conjured Mana Cake: (2, 4)",
                "+5 Dexterity Vest: (8, 18); Aged Brie: (0, 2); Elixir of the Mongoose: (3, 5); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (13, 22); Conjured Mana Cake: (1, 2)",
                "+5 Dexterity Vest: (7, 17); Aged Brie: (-1, 4); Elixir of the Mongoose: (2, 4); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (12, 23); Conjured Mana Cake: (0, 0)",
                "+5 Dexterity Vest: (6, 16); Aged Brie: (-2, 6); Elixir of the Mongoose: (1, 3); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (11, 24); Conjured Mana Cake: (-1, 0)",
                "+5 Dexterity Vest: (5, 15); Aged Brie: (-3, 8); Elixir of the Mongoose: (0, 2); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (10, 25); Conjured Mana Cake: (-2, 0)",
                "+5 Dexterity Vest: (4, 14); Aged Brie: (-4, 10); Elixir of the Mongoose: (-1, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (9, 27); Conjured Mana Cake: (-3, 0)",
                "+5 Dexterity Vest: (3, 13); Aged Brie: (-5, 12); Elixir of the Mongoose: (-2, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (8, 29); Conjured Mana Cake: (-4, 0)",
                "+5 Dexterity Vest: (2, 12); Aged Brie: (-6, 14); Elixir of the Mongoose: (-3, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (7, 31); Conjured Mana Cake: (-5, 0)",
                "+5 Dexterity Vest: (1, 11); Aged Brie: (-7, 16); Elixir of the Mongoose: (-4, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (6, 33); Conjured Mana Cake: (-6, 0)",
                "+5 Dexterity Vest: (0, 10); Aged Brie: (-8, 18); Elixir of the Mongoose: (-5, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (5, 35); Conjured Mana Cake: (-7, 0)",
                "+5 Dexterity Vest: (-1, 8); Aged Brie: (-9, 20); Elixir of the Mongoose: (-6, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (4, 38); Conjured Mana Cake: (-8, 0)",
                "+5 Dexterity Vest: (-2, 6); Aged Brie: (-10, 22); Elixir of the Mongoose: (-7, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (3, 41); Conjured Mana Cake: (-9, 0)",
                "+5 Dexterity Vest: (-3, 4); Aged Brie: (-11, 24); Elixir of the Mongoose: (-8, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (2, 44); Conjured Mana Cake: (-10, 0)",
                "+5 Dexterity Vest: (-4, 2); Aged Brie: (-12, 26); Elixir of the Mongoose: (-9, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (1, 47); Conjured Mana Cake: (-11, 0)",
                "+5 Dexterity Vest: (-5, 0); Aged Brie: (-13, 28); Elixir of the Mongoose: (-10, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (0, 50); Conjured Mana Cake: (-12, 0)",
                "+5 Dexterity Vest: (-6, 0); Aged Brie: (-14, 30); Elixir of the Mongoose: (-11, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-1, 0); Conjured Mana Cake: (-13, 0)",
                "+5 Dexterity Vest: (-7, 0); Aged Brie: (-15, 32); Elixir of the Mongoose: (-12, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-2, 0); Conjured Mana Cake: (-14, 0)",
                "+5 Dexterity Vest: (-8, 0); Aged Brie: (-16, 34); Elixir of the Mongoose: (-13, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-3, 0); Conjured Mana Cake: (-15, 0)",
                "+5 Dexterity Vest: (-9, 0); Aged Brie: (-17, 36); Elixir of the Mongoose: (-14, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-4, 0); Conjured Mana Cake: (-16, 0)",
                "+5 Dexterity Vest: (-10, 0); Aged Brie: (-18, 38); Elixir of the Mongoose: (-15, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-5, 0); Conjured Mana Cake: (-17, 0)",
                "+5 Dexterity Vest: (-11, 0); Aged Brie: (-19, 40); Elixir of the Mongoose: (-16, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-6, 0); Conjured Mana Cake: (-18, 0)",
                "+5 Dexterity Vest: (-12, 0); Aged Brie: (-20, 42); Elixir of the Mongoose: (-17, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-7, 0); Conjured Mana Cake: (-19, 0)",
                "+5 Dexterity Vest: (-13, 0); Aged Brie: (-21, 44); Elixir of the Mongoose: (-18, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-8, 0); Conjured Mana Cake: (-20, 0)",
                "+5 Dexterity Vest: (-14, 0); Aged Brie: (-22, 46); Elixir of the Mongoose: (-19, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-9, 0); Conjured Mana Cake: (-21, 0)",
                "+5 Dexterity Vest: (-15, 0); Aged Brie: (-23, 48); Elixir of the Mongoose: (-20, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-10, 0); Conjured Mana Cake: (-22, 0)",
                "+5 Dexterity Vest: (-16, 0); Aged Brie: (-24, 50); Elixir of the Mongoose: (-21, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-11, 0); Conjured Mana Cake: (-23, 0)",
                "+5 Dexterity Vest: (-17, 0); Aged Brie: (-25, 50); Elixir of the Mongoose: (-22, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-12, 0); Conjured Mana Cake: (-24, 0)",
                "+5 Dexterity Vest: (-18, 0); Aged Brie: (-26, 50); Elixir of the Mongoose: (-23, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-13, 0); Conjured Mana Cake: (-25, 0)",
                "+5 Dexterity Vest: (-19, 0); Aged Brie: (-27, 50); Elixir of the Mongoose: (-24, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-14, 0); Conjured Mana Cake: (-26, 0)",
                "+5 Dexterity Vest: (-20, 0); Aged Brie: (-28, 50); Elixir of the Mongoose: (-25, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-15, 0); Conjured Mana Cake: (-27, 0)",
                "+5 Dexterity Vest: (-21, 0); Aged Brie: (-29, 50); Elixir of the Mongoose: (-26, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-16, 0); Conjured Mana Cake: (-28, 0)",
                "+5 Dexterity Vest: (-22, 0); Aged Brie: (-30, 50); Elixir of the Mongoose: (-27, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-17, 0); Conjured Mana Cake: (-29, 0)",
                "+5 Dexterity Vest: (-23, 0); Aged Brie: (-31, 50); Elixir of the Mongoose: (-28, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-18, 0); Conjured Mana Cake: (-30, 0)",
                "+5 Dexterity Vest: (-24, 0); Aged Brie: (-32, 50); Elixir of the Mongoose: (-29, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-19, 0); Conjured Mana Cake: (-31, 0)",
                "+5 Dexterity Vest: (-25, 0); Aged Brie: (-33, 50); Elixir of the Mongoose: (-30, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-20, 0); Conjured Mana Cake: (-32, 0)",
                "+5 Dexterity Vest: (-26, 0); Aged Brie: (-34, 50); Elixir of the Mongoose: (-31, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-21, 0); Conjured Mana Cake: (-33, 0)",
                "+5 Dexterity Vest: (-27, 0); Aged Brie: (-35, 50); Elixir of the Mongoose: (-32, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-22, 0); Conjured Mana Cake: (-34, 0)",
                "+5 Dexterity Vest: (-28, 0); Aged Brie: (-36, 50); Elixir of the Mongoose: (-33, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-23, 0); Conjured Mana Cake: (-35, 0)",
                "+5 Dexterity Vest: (-29, 0); Aged Brie: (-37, 50); Elixir of the Mongoose: (-34, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-24, 0); Conjured Mana Cake: (-36, 0)",
                "+5 Dexterity Vest: (-30, 0); Aged Brie: (-38, 50); Elixir of the Mongoose: (-35, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-25, 0); Conjured Mana Cake: (-37, 0)",
                "+5 Dexterity Vest: (-31, 0); Aged Brie: (-39, 50); Elixir of the Mongoose: (-36, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-26, 0); Conjured Mana Cake: (-38, 0)",
                "+5 Dexterity Vest: (-32, 0); Aged Brie: (-40, 50); Elixir of the Mongoose: (-37, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-27, 0); Conjured Mana Cake: (-39, 0)",
                "+5 Dexterity Vest: (-33, 0); Aged Brie: (-41, 50); Elixir of the Mongoose: (-38, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-28, 0); Conjured Mana Cake: (-40, 0)",
                "+5 Dexterity Vest: (-34, 0); Aged Brie: (-42, 50); Elixir of the Mongoose: (-39, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-29, 0); Conjured Mana Cake: (-41, 0)",
                "+5 Dexterity Vest: (-35, 0); Aged Brie: (-43, 50); Elixir of the Mongoose: (-40, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-30, 0); Conjured Mana Cake: (-42, 0)",
                "+5 Dexterity Vest: (-36, 0); Aged Brie: (-44, 50); Elixir of the Mongoose: (-41, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-31, 0); Conjured Mana Cake: (-43, 0)",
                "+5 Dexterity Vest: (-37, 0); Aged Brie: (-45, 50); Elixir of the Mongoose: (-42, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-32, 0); Conjured Mana Cake: (-44, 0)",
                "+5 Dexterity Vest: (-38, 0); Aged Brie: (-46, 50); Elixir of the Mongoose: (-43, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-33, 0); Conjured Mana Cake: (-45, 0)",
                "+5 Dexterity Vest: (-39, 0); Aged Brie: (-47, 50); Elixir of the Mongoose: (-44, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-34, 0); Conjured Mana Cake: (-46, 0)",
                "+5 Dexterity Vest: (-40, 0); Aged Brie: (-48, 50); Elixir of the Mongoose: (-45, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-35, 0); Conjured Mana Cake: (-47, 0)",
                "+5 Dexterity Vest: (-41, 0); Aged Brie: (-49, 50); Elixir of the Mongoose: (-46, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-36, 0); Conjured Mana Cake: (-48, 0)",
                "+5 Dexterity Vest: (-42, 0); Aged Brie: (-50, 50); Elixir of the Mongoose: (-47, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-37, 0); Conjured Mana Cake: (-49, 0)",
                "+5 Dexterity Vest: (-43, 0); Aged Brie: (-51, 50); Elixir of the Mongoose: (-48, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-38, 0); Conjured Mana Cake: (-50, 0)",
                "+5 Dexterity Vest: (-44, 0); Aged Brie: (-52, 50); Elixir of the Mongoose: (-49, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-39, 0); Conjured Mana Cake: (-51, 0)",
                "+5 Dexterity Vest: (-45, 0); Aged Brie: (-53, 50); Elixir of the Mongoose: (-50, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-40, 0); Conjured Mana Cake: (-52, 0)",
                "+5 Dexterity Vest: (-46, 0); Aged Brie: (-54, 50); Elixir of the Mongoose: (-51, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-41, 0); Conjured Mana Cake: (-53, 0)",
                "+5 Dexterity Vest: (-47, 0); Aged Brie: (-55, 50); Elixir of the Mongoose: (-52, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-42, 0); Conjured Mana Cake: (-54, 0)",
                "+5 Dexterity Vest: (-48, 0); Aged Brie: (-56, 50); Elixir of the Mongoose: (-53, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-43, 0); Conjured Mana Cake: (-55, 0)",
                "+5 Dexterity Vest: (-49, 0); Aged Brie: (-57, 50); Elixir of the Mongoose: (-54, 0); Sulfuras, Hand of Ragnaros: (0, 50); Backstage passes to a TAFKAL80ETC concert: (-44, 0); Conjured Mana Cake: (-56, 0)" };

        Inn inn = new Inn();
        for (int i = 0; i < toCompare.length; i++) {
            assertThat(toCompare[i]).isEqualTo(inn.itemsAsString());
            inn.updateQuality();
        }
    }
    
    @Test
    public void conjured_items_degrade_faster() throws Exception {
        Inn inn = new Inn();
        Item conjuredManaCake = inn.items.get(5);
        
        assertThat(conjuredManaCake.getQuality()).isEqualTo(6);
        
        inn.updateQuality();
        assertThat(conjuredManaCake.getQuality()).isEqualTo(4);
        
        inn.updateQuality();
        assertThat(conjuredManaCake.getQuality()).isEqualTo(2);
    }
}
