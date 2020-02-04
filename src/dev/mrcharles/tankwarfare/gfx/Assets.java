package dev.mrcharles.tankwarfare.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage soldier_reload_anim_a, soldier_reload_anim_b, soldier_reload_anim_c, soldier_reload_anim_d, 
	soldier_reload_anim_e, soldier_reload_anim_f, soldier_death_anim_a, soldier_death_anim_b, soldier_death_anim_c, 
	soldier_death_anim_d, wall_brick, grass, tree_grass, tank_frame_a, tank_frame_b, tank_gun_a, tank_gun_b, 
	tank_a_gun_fire_a, tank_a_gun_fire_b, tank_a_gun_fire_c, tank_derelict_frame_a, tank_derelict_frame_b, jeep_a, jeep_b, jeep_c, 
	jeep_derelict_a, jeep_derelict_b, jeep_derelict_c, missile_soldier, missile_soldier_dead_a, missile_soldier_dead_b, 
	missile_soldier_dead_c, missile_soldier_dead_d, missile_fire, missile_fire_b, missile_fire_c, missile_smoke_a, missile_smoke_b, 
	missile_smoke_c, tank_shell;
	public static BufferedImage[] soldier_dead, soldier_reload, tank_fire;
	private static int soldier_height_dead;
	private static int soldier_width_dead;
	private static int soldier_width_alive;
	private static int soldier_height_alive;
	public static BufferedImage[] shell_explode;
	public static void init() {
		spritesheet sheet = new spritesheet(ImageLoader.loadImage("/textures/spritesheetA.png"));
		spritesheet shell_sheet = new spritesheet(ImageLoader.loadImage("/textures/explosionSheet2png.png"));
		//common widths and heights
		soldier_width_dead = 90;
		soldier_height_dead = 90;
		soldier_width_alive = 46;
		soldier_height_alive = 80;
		//animations
		soldier_dead = new BufferedImage[4];
		soldier_dead[0] = sheet.crop(641, 108, soldier_width_dead, soldier_height_dead);
		soldier_dead[1] = sheet.crop(641, 170, soldier_width_dead, soldier_height_dead);
		soldier_dead[2] = sheet.crop(641, 236, soldier_width_dead, soldier_height_dead);
		soldier_dead[3] = sheet.crop(641, 314, soldier_width_dead, soldier_height_dead);
		
		soldier_reload = new BufferedImage[5];
		soldier_reload[0] = sheet.crop(1070, 242, soldier_width_alive, soldier_height_alive);
		soldier_reload[1] = sheet.crop(1014, 240, soldier_width_alive, soldier_height_alive);
		soldier_reload[2] = sheet.crop(960, 240, soldier_width_alive, soldier_height_alive);
		soldier_reload[3] = sheet.crop(898, 248, soldier_width_alive, soldier_height_alive);
		soldier_reload[4] = sheet.crop(840, 248, soldier_width_alive, soldier_height_alive);
		
		tank_fire = new BufferedImage[3];
		tank_fire[0] = sheet.crop(646, 871, 54, 63);
		tank_fire[1] = sheet.crop(724, 871, 54, 63);
		tank_fire[2] = sheet.crop(796, 871, 54, 63);
		
		shell_explode = new BufferedImage[63];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 8; j++) {
				shell_explode[i + j] = shell_sheet.crop(j * 99, i * 99, 99, 99);
			}
		}
		//the assets
		grass = sheet.crop(1213, 466, 160, 160);
		tree_grass = sheet.crop(126, 797, 160, 160);
		wall_brick = sheet.crop(713, 325, 160, 160);
		tank_frame_a = sheet.crop(584, 623, 112, 197);
		tank_frame_b = sheet.crop(997, 630, 141, 197);
		tank_gun_a = sheet.crop(723, 635, 93, 177);
		tank_gun_b = sheet.crop(1144, 652, 117, 241);
		tank_a_gun_fire_a = sheet.crop(646, 871, 56, 64);
		tank_a_gun_fire_b = sheet.crop(724, 871, 56, 54);
		tank_a_gun_fire_c = sheet.crop(806, 871, 38, 55);
		tank_shell = ImageLoader.loadImage("/textures/tankshell.png");
		
		soldier_reload_anim_a = sheet.crop(1070, 242, soldier_width_alive, soldier_height_alive);
		soldier_reload_anim_b = sheet.crop(1014, 240, soldier_width_alive, soldier_height_alive);
		soldier_reload_anim_c = sheet.crop(960, 240, soldier_width_alive, soldier_height_alive);
		soldier_reload_anim_d = sheet.crop(898, 248, soldier_width_alive, soldier_height_alive);
		soldier_reload_anim_e = sheet.crop(840, 248, soldier_width_alive, soldier_height_alive);
		tank_a_gun_fire_a = sheet.crop(646, 871, 54, 63);
		tank_a_gun_fire_b = sheet.crop(724, 871, 54, 63);
		tank_a_gun_fire_c = sheet.crop(806, 871, 54, 63);
		
	}
}
