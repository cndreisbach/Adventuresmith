/*
 * Copyright (c) 2016 Steve Christensen
 *
 * This file is part of RPG-Pad.
 *
 * RPG-Pad is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RPG-Pad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RPG-Pad.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.stevesea.rpgpad;

import org.stevesea.rpgpad.data.AbstractGenerator;
import org.stevesea.rpgpad.data.DiceRoller;
import org.stevesea.rpgpad.data.fourth_page.FourthPageArtifact;
import org.stevesea.rpgpad.data.fourth_page.FourthPageCity;
import org.stevesea.rpgpad.data.fourth_page.FourthPageDungeon;
import org.stevesea.rpgpad.data.fourth_page.FourthPageMonster;
import org.stevesea.rpgpad.data.freebooters_on_the_frontier.FotFSpells;
import org.stevesea.rpgpad.data.freebooters_on_the_frontier.FotFTraits;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsAfflictions;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsCharacter;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsItems;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsMagic;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsMonsters;
import org.stevesea.rpgpad.data.maze_rats.MazeRatsPotionEffects;
import org.stevesea.rpgpad.data.perilous_wilds.PwCreature;
import org.stevesea.rpgpad.data.perilous_wilds.PwDanger;
import org.stevesea.rpgpad.data.perilous_wilds.PwDiscovery;
import org.stevesea.rpgpad.data.perilous_wilds.PwDungeon;
import org.stevesea.rpgpad.data.perilous_wilds.PwDungeonDiscoveryAndDanger;
import org.stevesea.rpgpad.data.perilous_wilds.PwFollower;
import org.stevesea.rpgpad.data.perilous_wilds.PwNPC;
import org.stevesea.rpgpad.data.perilous_wilds.PwPlace;
import org.stevesea.rpgpad.data.perilous_wilds.PwRegion;
import org.stevesea.rpgpad.data.perilous_wilds.PwSteading;
import org.stevesea.rpgpad.data.perilous_wilds.PwTreasure;
import org.stevesea.rpgpad.data.perilous_wilds.PwTreasureGuarded;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum DatasetButton {
    FreebooterSpells(Dataset.FreebootersOnTheFrontier, new FotFSpells(),  R.string.FotFSpells),
    FreebooterTraits(Dataset.FreebootersOnTheFrontier, new FotFTraits(), R.string.FotFTraits),

    PerilousDiscovery(Dataset.ThePerilousWilds, new PwDiscovery(), R.string.PwDiscovery),
    PerilousDanger(Dataset.ThePerilousWilds, new PwDanger(), R.string.PwDanger),
    PerilousDungeonExplore(Dataset.ThePerilousWilds, new PwDungeonDiscoveryAndDanger(), R.string.PwDungeonExplore),

    PerilousSteading(Dataset.ThePerilousWildsNames, new PwSteading(), R.string.PwSteading),
    PerilousDungeon(Dataset.ThePerilousWildsNames, new PwDungeon(), R.string.PwDungeon),
    PerilousNPCFollower(Dataset.ThePerilousWildsNames, new PwFollower(), R.string.PwNPCFollower),
    PerilousPlaces(Dataset.ThePerilousWildsNames, new PwPlace(),  R.string.PwPlaces),
    PerilousRegions(Dataset.ThePerilousWildsNames, new PwRegion(), R.string.PwRegions),

    PerilousTreasureGuarded(Dataset.ThePerilousWildsTreasure, new PwTreasureGuarded(), R.string.PwTreasureGuarded),
    PerilousTreasureGuarded1(Dataset.ThePerilousWildsTreasure, PwTreasureGuarded.gg.get("1bonus"), R.string.PwTreasureGuarded1),
    PerilousTreasureGuarded2(Dataset.ThePerilousWildsTreasure, PwTreasureGuarded.gg.get("2bonus"), R.string.PwTreasureGuarded2),
    PerilousTreasureUnguarded(Dataset.ThePerilousWildsTreasure, PwTreasure.generators.get("unguarded"), R.string.PwTreasureUnguarded),
    PerilousTreasureItem(Dataset.ThePerilousWildsTreasure, PwTreasure.generators.get("item"), R.string.PwTreasureItem),

    PerilousNPC(Dataset.ThePerilousWildsNPC, new PwNPC(), R.string.PwNPC),
    PerilousNPCWilderness(Dataset.ThePerilousWildsNPC, PwNPC.generators.get("wilderness"), R.string.PwNPCWilderness),
    PerilousNPCRural(Dataset.ThePerilousWildsNPC, PwNPC.generators.get("rural"), R.string.PwNPCRural),
    PerilousNPCUrban(Dataset.ThePerilousWildsNPC, PwNPC.generators.get("urban"), R.string.PwNPCUrban),

    PerilousCreature(Dataset.ThePerilousWildsCreature, new PwCreature(), R.string.PwCreature),
    PerilousCreatureB(Dataset.ThePerilousWildsCreature, PwCreature.generators.get("beast"), R.string.PwCreatureBeast),
    PerilousCreatureHuman(Dataset.ThePerilousWildsCreature, PwCreature.generators.get("human"), R.string.PwCreatureHuman),
    PerilousCreatureHumanoid(Dataset.ThePerilousWildsCreature, PwCreature.generators.get("humanoid"), R.string.PwCreatureHumanoid),
    PerilousCreatureMonster(Dataset.ThePerilousWildsCreature, PwCreature.generators.get("monster"), R.string.PwCreatureMonster),


    MrCharacters(Dataset.MazeRats, new MazeRatsCharacter(), R.string.MrCharacters),
    MrMonsters(Dataset.MazeRats, new MazeRatsMonsters(), R.string.MrMonsters),
    MrMagic(Dataset.MazeRats, new MazeRatsMagic(), R.string.MrMagic),
    MrItems(Dataset.MazeRats, new MazeRatsItems(), R.string.MrItems),
    MrAfflictions(Dataset.MazeRats, new MazeRatsAfflictions(), R.string.MrAfflictions),
    MrPotionEffects(Dataset.MazeRats, new MazeRatsPotionEffects(), R.string.MrPotionEffects),

    Dr1d6(Dataset.DiceRoller, DiceRoller.generators.get("1d6"), R.string.dice_roller_1d6),
    Dr1d8(Dataset.DiceRoller, DiceRoller.generators.get("1d8"), R.string.dice_roller_1d8),
    Dr1d10(Dataset.DiceRoller, DiceRoller.generators.get("1d10"), R.string.dice_roller_1d10),
    Dr1d12(Dataset.DiceRoller, DiceRoller.generators.get("1d12"), R.string.dice_roller_1d12),
    Dr1d20(Dataset.DiceRoller, DiceRoller.generators.get("1d20"), R.string.dice_roller_1d20),
    Dr1d30(Dataset.DiceRoller, DiceRoller.generators.get("1d30"), R.string.dice_roller_1d30),
    Dr1d100(Dataset.DiceRoller, DiceRoller.generators.get("1d100"), R.string.dice_roller_1d100),
    Dr2d20Adv(Dataset.DiceRoller, DiceRoller.generators.get("1d20adv"), R.string.dice_roller_2d20_adv),
    Dr2d20Disadv(Dataset.DiceRoller, DiceRoller.generators.get("1d20disadv"), R.string.dice_roller_2d20_disadv),
    Dr2d6(Dataset.DiceRoller, DiceRoller.generators.get("2d6"), R.string.dice_roller_2d6),
    Dr3d6(Dataset.DiceRoller, DiceRoller.generators.get("3d6"), R.string.dice_roller_3d6),
    Dr4d4(Dataset.DiceRoller, DiceRoller.generators.get("4d4"), R.string.dice_roller_4d4),


    FpArtifacts(Dataset.TheFourthPage, new FourthPageArtifact(), R.string.fourth_page_artifact),
    FpMonster(Dataset.TheFourthPage, new FourthPageMonster(), R.string.fourth_page_monster),
    FpCity(Dataset.TheFourthPage, new FourthPageCity(), R.string.fourth_page_city),
    FpDungeon(Dataset.TheFourthPage, new FourthPageDungeon(), R.string.fourth_page_dungeon),
    ;

    public final int stringResourceId;
    public final Dataset dataset;
    public final AbstractGenerator generator;

    DatasetButton(Dataset dataset, AbstractGenerator obj, int stringResourceId) {
        this.stringResourceId = stringResourceId;
        this.dataset = dataset;
        this.generator = obj;
    }

    static Collection<DatasetButton> getButtonsForDataset(Dataset dset) {
        List<DatasetButton> result = new ArrayList<>();
        if (dset.equals(Dataset.None)) {
            return new ArrayList<>();
        }
        for (DatasetButton val: values()) {
            if (val.dataset == dset)
                result.add(val);
        }
        return result;
    }

    String generate() {
        return generator.generate();
    }
}