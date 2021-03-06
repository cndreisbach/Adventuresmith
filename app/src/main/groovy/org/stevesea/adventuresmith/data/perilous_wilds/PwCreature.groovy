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
 *
 */

package org.stevesea.adventuresmith.data.perilous_wilds

import groovy.transform.CompileStatic
import org.stevesea.adventuresmith.data.AbstractGenerator
import org.stevesea.adventuresmith.data.RangeMap
import org.stevesea.adventuresmith.data.Shuffler

@CompileStatic
class PwCreature extends AbstractGenerator {
    public static Map<String, PwCreature> generators = [
            'beast' : new PwCreature() {
                @Override
                String generate() {
                    getCreature(1)
                }
            },
            'human' : new PwCreature() {
                @Override
                String generate() {
                    getCreature(5)
                }
            },
            'humanoid' : new PwCreature() {
                @Override
                String generate() {
                    getCreature(7)
                }
            },
            'monster' : new PwCreature() {
                @Override
                String generate() {
                    getCreature(9)
                }
            },
            ]


    PwDetails pwDetails = new PwDetails()
    PwNPC pwNPC = new PwNPC()

    @Override
    AbstractGenerator withShuffler(Shuffler shuff) {
        super.withShuffler(shuff)
        pwDetails.withShuffler(shuff)
        pwNPC.withShuffler(shuff)
        this
    }
    RangeMap earthbound = new RangeMap()
            .with(1, 'termite/tick/louse')
            .with(2, 'snail/slug/worm')
            .with(3, 'ant/centipede/scorpion')
            .with(4, 'snake/lizard')
            .with(5, 'vole/rat/weasel')
            .with(6, 'boar/pig')
            .with(7, 'dog/fox/wolf')
            .with(8, 'cat/lion/panther')
            .with(9, 'deer/horse/camel')
            .with(10, 'ox/rhino')
            .with(11, 'bear/ape/gorilla')
            .with(12, 'mammoth/dinosaur')
    RangeMap airborne = new RangeMap()
            .with(1, 'mosquito/firefly')
            .with(2, 'locust/dragonfly/moth')
            .with(3, 'bee/wasp')
            .with(4, 'chicken/duck/goose')
            .with(5, 'songbird/parrot')
            .with(6, 'gull/waterbird')
            .with(7, 'heron/crane/stork')
            .with(8, 'crow/raven')
            .with(9, 'hawk/falcon')
            .with(10, 'eagle/owl')
            .with(11, 'condor')
            .with(12, 'pteranodon')
    RangeMap water_going = new RangeMap()
            .with(1, 'insect')
            .with(2, 'jelly/anemone')
            .with(3, 'clam/oyster/snail')
            .with(4, 'eel/snake')
            .with(5, 'frog/toad')
            .with(6, 'fish')
            .with(7, 'crab/lobster')
            .with(8, 'turtle')
            .with(9, 'alligator/crocodile')
            .with(10, 'dolphin/shark')
            .with(11, 'squid/octopus')
            .with(12, 'whale')

    RangeMap beast = new RangeMap()
            .with(1..7, "${ -> pick(earthbound)}")
            .with(8..10, "${ -> pick(airborne)}")
            .with(11..12, "${ -> pick(water_going)}")
    RangeMap humanoid_common = new RangeMap()
            .with(1..3, 'halfling (Small)')
            .with(4..5, 'goblin/kobold (Small)')
            .with(6..7, 'dwarf/gnome (Small)')
            .with(8..9, 'orc/hobgoblin/gnoll')
            .with(10..11, 'half-elf/half-orc, etc.')
            .with(12, 'elf')
    RangeMap humanoid_uncommon = new RangeMap()
            .with(1, 'fey (Tiny)')
            .with(2..3, 'catfolk/dogfolk')
            .with(4..6, 'lizardfolk/merfolk')
            .with(7, 'birdfolk')
            .with(8..10, 'ogre/troll (Large)')
            .with(11..12, 'cyclops/giant (Large)')
    RangeMap humanoid_hybrid = new RangeMap()
            .with(1..2, 'centaur')
            .with(3..5, 'werewolf/werebear')
            .with(6, "werecreature <br/><small>human + ${ -> pick(beast) }</small>")
            .with(7..10, "human + ${ -> pick(beast) }")
            .with(11..12, "human + ${ -> pickN(beast,2).join(' + ')}")

    RangeMap humanoid = new RangeMap()
            .with(1..7, "${ -> pick(humanoid_common)}")
            .with(8..10, "${ -> pick(humanoid_uncommon)}")
            .with(11..12, "${ -> pick(humanoid_hybrid)}")

    RangeMap monster_unusual = new RangeMap()
            .with(1..3, 'plant/fungus')
            .with(4..5, "Undead Human <small>[${ -> pick(pwDetails.undead)}]</small>")
            .with(6, "Undead Humanoid  <small>[${ -> pick(pwDetails.undead)} + ${ -> pick(humanoid)}]</small>")
            .with(7..8, "${ -> pickN(beast,2).join(' + ')}")
            .with(9..10, "${ -> pick(beast) } + ${ -> pwDetails.pickAbility()}")
            .with(11..12, "${ -> pick(beast) } + ${ -> pwDetails.pickFeature()}")
    RangeMap monster_rare = new RangeMap()
            .with(1..3, 'slime/ooze (Amorphous)')
            .with(4..6, 'creation (Construct)')
            .with(7..9, "${ -> pick(beast) } + ${ -> pwDetails.pickOddity()}")
            .with(10..12, "${ -> pick(unnatural_entity)}")
    RangeMap monster_legendary = new RangeMap()
            .with(1..3, 'dragon/colossus (Huge)')
            .with(4..6, "${ -> pick(monster_unusual)} (Huge)")
            .with(7..9, "${ -> pick(monster_rare)} (Huge)")
            .with(10, "${ -> pick(beast) } + dragon")
            .with(11, "${ -> pick(monster_unusual)} + dragon")
            .with(12, "${ -> pick(monster_rare)} + dragon")
    RangeMap monster = new RangeMap()
            .with(1..7, "${ -> pick(monster_unusual)}")
            .with(8..10, "${ -> pick(monster_rare)} ${em('(rare)')}")
            .with(11..12, "${ -> pick(monster_legendary)} ${em('(legendary)')}")

    RangeMap unnatural_entity = new RangeMap()
            .with(1..8, """\
${ss('Undead:')} ${ -> pick(pwDetails.undead)}\
""")
            .with(9..11, """\
${ss('Planar:')} ${ -> pick(pwDetails.planar)}
<br/>
<br/>${ss('Element:')} ${ -> pwDetails.pickElement()}
<br/>${ss('Feature:')} ${ -> pwDetails.pickFeature()}
<br/>${ss('Tag:')} ${ -> pwDetails.pickTag()}\
""")
            .with(12, """\
${ss('Divine:')} ${ -> pick(pwDetails.divine)}
<br/>
<br/>${ss('Aspect:')} ${ -> pwDetails.pickAspect()}
<br/>${ss('Element:')} ${ -> pwDetails.pickElement()}
<br/>${ss('Feature:')} ${ -> pwDetails.pickFeature()}
<br/>${ss('Tag:')} ${ -> pwDetails.pickTag()}\
""")

    RangeMap creature_no_tags = new RangeMap()
            .with(1..4, "${ -> pick(beast)}")
            .with(5..6, "human")
            .with(7..8, "${ -> pick(humanoid)}")
            .with(9..12, "${ -> pick(monster)}")


    @Override
    String generate() {
        getCreature(roll('1d12'))
    }

    String getCreature(int roll) {

        RangeMap creature = new RangeMap()
                .with(1..4, """\
${strong('Beast')} -- ${small('Start with a real-world creature, then put a spin on it.')}
<br/>
<br/>${pick(beast)}
<br/>
<br/>${ss('Activity:')} ${pwDetails.pickActivity()}
<br/>${ss('Disposition:')} ${pwDetails.pickDisposition()}
<br/>${ss('No. Appearing:')} ${pwDetails.pickNumberAppearing()}
<br/>${ss('Size:')} ${pwDetails.pickSize()}\
""")
                .with(5..6, """\
${strong('Human')}
<br/>
<br/>${ss('Activity:')} ${pwDetails.pickActivity()}
<br/>${ss('Alignment:')} ${pwDetails.pickAlignment()}
<br/>${ss('Disposition:')} ${pwDetails.pickDisposition()}
<br/>${ss('No. Appearing:')} ${pwDetails.pickNumberAppearing()}
<br/>
<br/>${ss('Occupation:')} ${pick(pwNPC.occupation)}
<br/>${pwNPC.genSingleTrait()}\
""")
                .with(7..8, """\
${strong('Humanoid')} -- ${small('If you roll a classic fantasy species, adapt it to your setting')}
<br/>
<br/>${pick(humanoid)}
<br/>
<br/>${ss('Activity:')} ${pwDetails.pickActivity()}
<br/>${ss('Alignment:')} ${pwDetails.pickAlignment()}
<br/>${ss('Disposition:')} ${pwDetails.pickDisposition()}
<br/>${ss('No. Appearing:')} ${pwDetails.pickNumberAppearing()}
<br/>
<br/>${ss('Occupation:')} ${pick(pwNPC.occupation)}
<br/>${pwNPC.genSingleTrait()}\
""")
                .with(9..12, """\
${strong('Monster')} -- ${small('Give every monster life!')}
<br/>
<br/>${pick(monster)}
<br/>
<br/>${ss('Activity:')} ${pwDetails.pickActivity()}
<br/>${ss('Alignment:')} ${pwDetails.pickAlignment()}&nbsp;&nbsp;${ss('Size:')} ${pwDetails.pickSize()}
<br/>${ss('Disposition:')} ${pwDetails.pickDisposition()}
<br/>${ss('No. Appearing:')} ${pwDetails.pickNumberAppearing()}
<br/>
<br/>${strong('Optional:')}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Ability:')} ${pwDetails.pickAbility()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Adjective:')} ${pwDetails.pickAdjective()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Age:')} ${pwDetails.pickAge()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Aspect:')} ${pwDetails.pickAspect()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Condition:')} ${pwDetails.pickCondition()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Feature:')} ${pwDetails.pickFeature()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Oddity:')} ${pwDetails.pickOddity()}
<br/>&nbsp;&nbsp;&nbsp;${ssem('Tags:')} ${pwDetails.pickTag()}\
""")
        creature.get(roll)
    }


}
