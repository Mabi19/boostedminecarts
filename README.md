# BoostedMinecarts

This is a Paper plugin
(it doesn't actually use any Paper-specific API, but I based this one off of a larger, private plugin which does)
which improves minecarts, allowing them to change their max speed by going over certain blocks.

## Configuration
The plugin's config file contains one object mapping material names
to speed multipliers. By default, lapis blocks are 1x speed,
quartz blocks are 1.5x speed and nether bricks are 5x speed.

Minecarts will fly off rails if they're going too fast on
turns or ramps; however, at 1.5x speed they can turn at 45 degree angles
(that is, the turn is not just one angled rail, but several
in a zigzag formation) and at 1x speed they can go up ramps.
