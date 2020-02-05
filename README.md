#A random Tank Game in 2D Java AWT + Swing

Because why not.

I know other langauges + modules are better. I don't care.

The Grand ToDO:

Spawn Map - In other words making dev.mrcharles.tankwarfare.world.Level.java actually work:
- reads in text file with some numbers
- turns it into an int[][] and assigns entity ids at the coordinates from the file
- passes that int[][] to some grand logic controller - it will render the lot of enemies.

The Player - dev.mrcharles.tankwarfare.entities.creatures.Player.java
- Need to get the geometry right on the projectile, first having it render at the tip of the barrel, then move with the barrel.
  Eventually it needs to be fired from the barrel. Then fix the explosion logic in that class and do AoE damage to nearby entities.
- Movement is actually very nice, but could be better with acceleration.

The HUD - dev.mrcharles.tankwarfare.gfx.Hud.java
- Needs some spicy UI update and probably a developer toggle. Will want to see things like raycasting and collision boxes sometimes. 
- But mainly it is waiting on graphics and for more general game logic to be complete like scoring and ammunition.

Graphics - dev.mrcharles.tankware.gfx.Assets.java
- Need a whole lot more assets. This includes animations, tiles, enemies, powerups, ammunition, walls, cover. 
- Most importantly need to finish making use of the current spirtesheets. Not that I made them. 

General Efficiency:
- Rendering of map is excellent. 
- Logic is yet to be tested. 
- Initial memory usage is minimal. So can load in a whole ton more assets.
