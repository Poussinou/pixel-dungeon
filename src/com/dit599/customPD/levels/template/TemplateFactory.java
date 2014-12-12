package com.dit599.customPD.levels.template;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.dit599.customPD.actors.mobs.Gnoll;
import com.dit599.customPD.actors.mobs.Mob;
import com.dit599.customPD.items.Item;
import com.dit599.customPD.items.armor.Armor;
import com.dit599.customPD.items.food.Food;
import com.dit599.customPD.items.food.Pasty;
import com.dit599.customPD.items.potions.Potion;
import com.dit599.customPD.items.potions.PotionOfMight;
import com.dit599.customPD.items.rings.RingOfEvasion;
import com.dit599.customPD.items.scrolls.Scroll;
import com.dit599.customPD.items.weapon.Weapon;
import com.dit599.customPD.items.weapon.melee.ShortSword;
import com.dit599.customPD.levels.Room.Type;
import com.dit599.customPD.levels.*;
import com.dit599.customPD.levels.template.LevelTemplate.MagicItem;

public class TemplateFactory {

	public static DungeonTemplate createSimpleDungeon(String name) {
		DungeonTemplate template = new DungeonTemplate();
		boolean found = false;
		try{
			template.load(name);
			if(template.levelTemplates.get(0).specialRooms.size() > 0){
				found = true;
				Log.d("SUCCESS", "Loaded .map");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		template.name = name;
		if(!found){
			//template.reset();
			template.levelTemplates = new ArrayList<LevelTemplate>();
			template.levelTemplates.add(createSimpleLevel());
//			template.levelTemplates.add(createSimpleLevel());
//			template.levelTemplates.get(1).theme = SewerLevel.class;
//			template.levelTemplates.add(createSimpleLevel());
//			template.levelTemplates.add(createSimpleLevel());
//			template.levelTemplates.get(3).theme = SewerBossLevel.class;
//			template.save(name);
			Log.d("NEW", "Created .map");
		}
		return template;
	}

	public static LevelTemplate createSimpleLevel() {
		LevelTemplate level = new LevelTemplate();
		level.theme = SewerLevel.class;
		level.maxMobs = 5;
		level.timeToRespawn = 40;
		level.specialRooms.add(Type.TREASURY);
		level.specialRooms.add(Type.ARMORY);
		level.mobs.get(1).mobClass = Gnoll.class;
		level.mobs.get(1).weight = 2;
		level.weapons.add(new ShortSword());
		level.weapons.add(new ShortSword());
		level.consumables.add(new Food());
		level.rings.add(new MagicItem(RingOfEvasion.class, 2, true));
		level.potions.add(PotionOfMight.class);

		return level;
	}
}
