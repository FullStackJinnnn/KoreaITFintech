package class02;

import java.util.Random;
import java.util.Scanner;

class Pokemon {
	static String titlePic="                                 ,'\\\r\n"
			+ "    _.----.        ____         ,'  _\\   ___    ___     ____\r\n"
			+ "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\r\n"
			+ "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\r\n"
			+ " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\r\n"
			+ "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\r\n"
			+ "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\r\n"
			+ "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\r\n"
			+ "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\r\n"
			+ "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\r\n"
			+ "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\r\n"
<<<<<<< HEAD
			+ "                                `'                            '-._|"+"                             "+"   `'                            '-._|";

	static String picachuPic = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
=======
<<<<<<< HEAD
			+ "                             "
			+ "   `'                            '-._|";
=======
			+ "                                `'                            '-._|";
>>>>>>> beb5ee2e5824e3626d7d691b540aa3a367f28774
	
	static String picachuPic="⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
>>>>>>> e1b5712c8e267e5d08830e2aae781c053e520706
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠋⠉⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡏⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⣤⣤⣤⣤⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⠴⠒⠊⠉⠉⠀⠀⣿⣿⣿⠿⠋⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢀⡠⠼⠴⠒⠒⠒⠒⠦⠤⠤⣄⣀⠀⢀⣠⠴⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀⣼⠿⠋⠁⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⣇⠔⠂⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⢰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠤⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⢀⡟⠀⣠⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⢻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⡤⠤⢴\r\n"
			+ "⠀⠀⠀⠀⠀⠀⣸⠁⣾⣿⣀⣽⡆⠀⠀⠀⠀⠀⠀⠀⢠⣾⠉⢿⣦⠀⠀⠀⢸⡀⠀⠀⢀⣠⠤⠔⠒⠋⠉⠉⠀⠀⠀⠀⢀⡞\r\n"
			+ "⠀⠀⠀⠀⠀⢀⡏⠀⠹⠿⠿⠟⠁⠀⠰⠦⠀⠀⠀⠀⠸⣿⣿⣿⡿⠀⠀⠀⢘⡧⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀\r\n"
			+ "⠀⠀⠀⠀⠀⣼⠦⣄⠀⠀⢠⣀⣀⣴⠟⠶⣄⡀⠀⠀⡀⠀⠉⠁⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀\r\n"
			+ "⠀⠀⠀⠀⢰⡇⠀⠈⡇⠀⠀⠸⡾⠁⠀⠀⠀⠉⠉⡏⠀⠀⠀⣠⠖⠉⠓⢤⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠃⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⢧⣀⡼⠃⠀⠀⠀⢧⠀⠀⠀⠀⠀⢸⠃⠀⠀⠀⣧⠀⠀⠀⣸⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠃⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠈⢧⡀⠀⠀⠀⠀⠘⣆⠀⠀⠀⢠⠏⠀⠀⠀⠀⠈⠳⠤⠖⠃⡟⠀⠀⠀⢾⠛⠛⠛⠛⠛⠛⠛⠛⠁⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠀⠀⠀⠈⠦⣀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠙⢦⠀⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⢠⡇⠙⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⠋⠸⡇⠈⢳⡀⠀⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⡼⣀⠀⠀⠈⠙⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⣷⠴⠚⠁⠀⣀⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⡴⠁⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⡴⠚⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⣼⢷⡆⠀⣠⡴⠧⣄⣇⠀⠀⠀⠀⠀⠀⠀⢲⠀⡟⠀⠀⠀⠀⠀⠀⠀⢀⡇⣠⣽⢦⣄⢀⣴⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⡿⣼⣽⡞⠁⠀⠀⠀⢹⡀⠀⠀⠀⠀⠀⠀⠈⣷⠃⠀⠀⠀⠀⠀⠀⠀⣼⠉⠁⠀⠀⢠⢟⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⣷⠉⠁⢳⠀⠀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠀⠀⣻⠀⠀⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⠏⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠹⡆⠀⠈⡇⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⢳⡀⠀⠙⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⢀⡄⠀⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⢳⡀⣰⣀⣀⣀⠀⠀⠀⠘⣦⣀⠀⠀⠀⡇⠀⠀⠀⢀⡴⠃⠀⠀⠀⠀⠀⢸⡇⢠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠉⠉⠀⠀⠈⠉⠉⠉⠙⠻⠿⠾⠾⠻⠓⢦⠦⡶⡶⠿⠛⠛⠓⠒⠒⠚⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

	static String raichuPic = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣷⡀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣄⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣆⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣶⣤⣙⣿⣿⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⣿⣿⡿⠿⠿⠿⠿⠗⠶⠶⠶⠤⢤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠖⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠓⠦⣤⣤⢤⡞⢦⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢦⡀⠈⢧⡀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⢀⣄⢀⣴⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣦⠀⠱⣄⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⣾⠈⠉⠀⠻⡷⠀⠀⣠⠖⠚⠉⠉⠉⠉⠓⢦⡀⠀⠀⠀⠀⠀⡤⠚⠉⠉⠉⠉⠑⠢⣄⠀⠈⢧⠀⠈⢳⡀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⢰⠇⠀⠀⠀⠀⡇⢠⡞⠀⠀⠀⠀⢀⡀⠀⠀⠀⢹⠀⠀⠀⠀⢸⠁⠀⠀⡤⠀⠀⠀⠀⠈⣇⠀⠸⡆⠀⠀⢻⡄⠀\r\n"
			+ "⠀⠀⠀⠀⢠⡏⠀⠀⠀⠀⠀⡇⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠈⠣⣀⠀⠀⠀⠀⠀⠀⣠⠇⠀⠀⡇⠀⠀⠀⢿⠀\r\n"
			+ "⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⡇⠀⠙⠲⢤⣀⣀⣀⣀⠤⠖⠋⠀⣀⡴⠚⠓⠢⣄⡈⠙⠒⠒⠒⠒⠋⠁⠀⠀⢸⠃⠀⠀⠀⢸⡆\r\n"
			+ "⠀⠀⠀⣼⠁⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠴⠚⢥⡀⠀⠀⠀⡀⠙⠓⠒⠶⠦⢤⡄⠀⠀⣠⡏⠀⠀⠀⠀⢸⡇\r\n"
			+ "⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⠀⢻⠀⠀⢀⣤⠶⠒⠚⠋⠉⠁⠀⠀⠀⠁⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⣇⢀⡴⠋⠀⠀⠀⠀⠀⣸⠃\r\n"
			+ "⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⢸⣧⡀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⣄⠀⠀⠀⠀⠀⢀⡟⠀\r\n"
			+ "⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠘⡏⠉⠳⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡄⠀⠀⢀⡾⠁⠀\r\n"
			+ "⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡀⣠⠞⠀⠀⠀\r\n"
			+ "⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⢠⡇⠀⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⢻⡏⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⢻⡀⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⠹⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠟⠁⠀⢷⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠙⠦⣤⣄⣀⠀⠘⠁⠀⠀⠀⠀⠀⠙⠲⠦⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣤⠴⠚⠉⠀⠀⠀⠀⠈⣇⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀\r\n"
			+ "⣠⣀⣀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀\r\n"
			+ "⢳⡀⠈⠙⠲⢤⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀\r\n"
			+ "⠀⠙⢦⡀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠙⠶⣄⡀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠁⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠈⠙⠲⢤⣹⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⣳⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⢾⡋⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠊⠁⠀⠈⠙⠲⠦⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣤⠴⠖⠛⠉⠀⠀⠉⠳⣄⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⢀⡔⠁⠀⠀⢀⠀⠀⠀⠀⢀⠀⠀⠈⢻⠉⠉⠉⠉⠉⠉⢹⠉⠉⠀⠀⡀⠀⠀⠀⠀⢠⡀⠀⠈⢧⡀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀⠀⠀⠀⠟⠒⠒⠒⠛⠙⣄⠀⣀⡴⠛⠳⢤⣀⡀⣧⠀⠀⠀⠀⠀⢸⡀⣀⣠⠴⠛⠦⣄⠀⢀⡏⠉⠙⠒⠶⠇⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠁⠀⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀";

	static String pyriPic = "              _.--\"\"`-..\r\n" + "            ,'          `.\r\n"
			+ "          ,'          __  `.\r\n" + "         /|          \" __   \\\r\n"
			+ "        , |           / |.   .\r\n" + "        |,'          !_.'|   |\r\n"
			+ "      ,'             '   |   |\r\n" + "     /              |`--'|   |\r\n"
			+ "    |                `---'   |\r\n" + "     .   ,                   |                       ,\".\r\n"
			+ "      ._     '           _'  |                    , ' \\ `\r\n"
			+ "  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\r\n"
			+ "  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\r\n"
			+ "-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\r\n"
			+ "  `,         \"\"\"\"'     `.              ,'         |   |  ',,\r\n"
			+ "    `.      '            '            /          '    |'. |/\r\n"
			+ "      `.   |              \\       _,-'           |       ''\r\n"
			+ "        `._'               \\   '\"\\                .      |\r\n"
			+ "           |                '     \\                `._  ,'\r\n"
			+ "           |                 '     \\                 .'|\r\n"
			+ "           |                 .      \\                | |\r\n"
			+ "           |                 |       L              ,' |\r\n"
			+ "           `                 |       |             /   '\r\n"
			+ "            \\                |       |           ,'   /\r\n"
			+ "          ,' \\               |  _.._ ,-..___,..-'    ,'\r\n"
			+ "         /     .             .      `!             ,j'\r\n"
			+ "        /       `.          /        .           .'/\r\n"
			+ "       .          `.       /         |        _.'.'\r\n"
			+ "        `.          7`'---'          |------\"'_.'\r\n"
			+ "       _,.`,_     _'                ,''-----\"'\r\n" + "   _,-_    '       `.     .'      ,\\\r\n"
			+ "   -\" /`.         _,'     | _  _  _.|\r\n" + "    \"\"--'---\"\"\"\"\"'        `' '! |! /\r\n"
			+ "                            `\" \" -' ";

	static String rezardPic = "                      ,-'`\\\r\n" + "                  _,\"'    j\r\n"
			+ "           __....+       /               .\r\n"
			+ "       ,-'\"             /               ; `-._.'.\r\n"
			+ "      /                (              ,'       .'\r\n"
			+ "     |            _.    \\             \\   ---._ `-.\r\n"
			+ "     ,|    ,   _.'  Y    \\             `- ,'   \\   `.`.\r\n"
			+ "     l'    \\ ,'._,\\ `.    .              /       ,--. l\r\n"
			+ "  .,-        `._  |  |    |              \\       _   l .\r\n"
			+ " /              `\"--'    /              .'       ``. |  )\r\n"
			+ ".\\    ,                 |                .        \\ `. '\r\n"
			+ "`.                .     |                '._  __   ;. \\'\r\n"
			+ "  `-..--------...'       \\                  `'  `-\"'.  \\\r\n"
			+ "      `......___          `._                        |  \\\r\n"
			+ "               /`            `..                     |   .\r\n"
			+ "              /|                `-.                  |    L\r\n"
			+ "             / |               \\   `._               .    |\r\n"
			+ "           ,'  |,-\"-.   .       .     `.            /     |\r\n"
			+ "         ,'    |     '   \\      |       `.         /      |\r\n"
			+ "       ,'     /|       \\  .     |         .       /       |\r\n"
			+ "     ,'      / |        \\  .    +          \\    ,'       .'\r\n"
			+ "    .       .  |         \\ |     \\          \\_,'        / j\r\n"
			+ "    |       |  L          `|      .          `        ,' '\r\n"
			+ "    |    _. |   \\          /      |           .     .' ,'\r\n"
			+ "    |   /  `|    \\        .       |  /        |   ,' .'\r\n"
			+ "    |   ,-..\\     -.     ,        | /         |,.' ,'\r\n"
			+ "    `. |___,`    /  `.   /`.       '          |  .'\r\n"
			+ "      '-`-'     j     ` /.\"7-..../|          ,`-'\r\n"
			+ "                |        .'  / _/_|          .\r\n"
			+ "                `,       `\"'/\"'    \\          `.\r\n"
			+ "                  `,       '.       `.         |\r\n"
			+ "             __,.-'         `.        \\'       |\r\n"
			+ "            /_,-'\\          ,'        |        _.\r\n"
			+ "             |___.---.   ,-'        .-':,-\"`\\,' .\r\n"
			+ "                  L,.--\"'           '-' |  ,' `-.\\\r\n"
			+ "                                        `.'";

	static String rezamongPic = "                 .\"-,.__\r\n" + "                 `.     `.  ,\r\n"
			+ "              .--'  .._,'\"-' `.\r\n" + "             .    .'         `'\r\n"
			+ "             `.   /          ,'\r\n" + "               `  '--.   ,-\"'\r\n"
			+ "                `\"`   |  \\\r\n" + "                   -. \\, |\r\n"
			+ "                    `--Y.'      ___.\r\n" + "                         \\     L._, \\\r\n"
			+ "               _.,        `.   <  <\\                _\r\n"
			+ "             ,' '           `, `.   | \\            ( `\r\n"
			+ "          ../, `.            `  |    .\\`.           \\ \\_\r\n"
			+ "         ,' ,..  .           _.,'    ||\\l            )  '\".\r\n"
			+ "        , ,'   \\           ,'.-.`-._,'  |           .  _._`.\r\n"
			+ "      ,' /      \\ \\        `' ' `--/   | \\          / /   ..\\\r\n"
			+ "    .'  /        \\ .         |\\__ - _ ,'` `        / /     `.`.\r\n"
			+ "    |  '          ..         `-...-\"  |  `-'      / /        . `.\r\n"
			+ "    | /           |L__           |    |          / /          `. `.\r\n"
			+ "   , /            .   .          |    |         / /             ` `\r\n"
			+ "  / /          ,. ,`._ `-_       |    |  _   ,-' /               ` \\\r\n"
			+ " / .           \\\"`_/. `-_ \\_,.  ,'    +-' `-'  _,        ..,-.    \\`.\r\n"
			+ ".  '         .-f    ,'   `    '.       \\__.---'     _   .'   '     \\ \\\r\n"
			+ "' /          `.'    l     .' /          \\..      ,_|/   `.  ,'`     L`\r\n"
			+ "|'      _.-\"\"` `.    \\ _,'  `            \\ `.___`.'\"`-.  , |   |    | \\\r\n"
			+ "||    ,'      `. `.   '       _,...._        `  |    `/ '  |   '     .|\r\n"
			+ "||  ,'          `. ;.,.---' ,'       `.   `.. `-'  .-' /_ .'    ;_   ||\r\n"
			+ "|| '              V      / /           `   | `   ,'   ,' '.    !  `. ||\r\n"
			+ "||/            _,-------7 '              . |  `-'    l         /    `||\r\n"
			+ ". |          ,' .-   ,' ||               | .-.        `.      .'     ||\r\n"
			+ " `'        ,'    `\".'    |               |    `.        '. -.'       `'\r\n"
			+ "          /      ,'      |               |,'    \\-.._,.'/'\r\n"
			+ "          .     /        .               .       \\    .''\r\n"
			+ "        .`.    |         `.             /         :_,'.'\r\n"
			+ "          \\ `...\\   _     ,'-.        .'         /_.-'\r\n"
			+ "           `-.__ `,  `'   .  _.>----''.  _  __  /\r\n"
			+ "                .'        /\"'          |  \"'   '_\r\n"
			+ "               /_|.-'\\ ,\".             '.'`__'-( \\\r\n"
			+ "                 / ,\"'\"\\,'               `/  `-.|\"";

	static String ggobugiPic = "               _,........__\r\n" + "            ,-'            \"`-.\r\n"
			+ "          ,'                   `-.\r\n" + "        ,'                        \\\r\n"
			+ "      ,'                           .\r\n" + "      .'\\               ,\"\".       `\r\n"
			+ "     ._.'|             / |  `       \\\r\n" + "     |   |            `-.'  ||       `.\r\n"
			+ "     |   |            '-._,'||       | \\\r\n" + "     .`.,'             `..,'.'       , |`-.\r\n"
			+ "     l                       .'`.  _/  |   `.\r\n"
			+ "     `-.._'-   ,          _ _'   -\" \\  .     `\r\n"
			+ "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\r\n"
			+ ".'        `\"-..___      __,'\\          \\  \\     \\\r\n"
			+ "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\r\n"
			+ "  `.          |              `.          |  .     L\r\n"
			+ "    `.        |`--...________.'.        j   |     |\r\n"
			+ "      `._    .'      |          `.     .|   ,     |\r\n"
			+ "         `--,\\       .            `7\"\"' |  ,      |\r\n"
			+ "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\r\n"
			+ "             \\ `.     .          /      |  '      |  ,'          `.\r\n"
			+ "              \\  v.__  .        '       .   \\    /| /              \\\r\n"
			+ "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\r\n"
			+ "                `        .        `._ ___,j.  `/ .-       ,---.     |\r\n"
			+ "                ,`-.      \\         .\"     `.  |/        j     `    |\r\n"
			+ "               /    `.     \\       /         \\ /         |     /    j\r\n"
			+ "              |       `-.   7-.._ .          |\"          '         /\r\n"
			+ "              |          `./_    `|          |            .     _,'\r\n"
			+ "              `.           / `----|          |-............`---'\r\n"
			+ "                \\          \\      |          |\r\n"
			+ "               ,'           )     `.         |\r\n"
			+ "                7____,,..--'      /          |\r\n" + "                                  `---.__,--.'";

	static String eanibugiPic = "     __                                _.--'\"7\r\n"
			+ "    `. `--._                        ,-'_,-  ,'\r\n" + "     ,'  `-.`-.                   /' .'    ,|\r\n"
			+ "     `.     `. `-     __...___   /  /     - j\r\n"
			+ "       `.     `  `.-\"\"        \" .  /       /\r\n" + "         \\     /                ` /       /\r\n"
			+ "          \\   /                         ,'\r\n" + "          '._'_               ,-'       |\r\n"
			+ "             | \\            ,|  |   ...-'\r\n"
			+ "             || `         ,|_|  |   | `             _..__\r\n"
			+ "            /|| |          | |  |   |  \\  _,_    .-\"     `-.\r\n"
			+ "           | '.-'          |_|_,' __!  | /|  |  /           \\\r\n"
			+ "   ,-...___ .=                  ._..'  /`.| ,`,.      _,.._ |\r\n"
			+ "  |   |,.. \\     '  `'        ____,  ,' `--','  |    /      |\r\n"
			+ " ,`-..'  _)  .`-..___,---'_...._/  .'      '-...'   |      /\r\n"
			+ "'.__' \"\"'      `.,------'\"'      ,/            ,     `.._.' `.\r\n"
			+ "  `.             | `--........,-'.            .         \\     \\\r\n"
			+ "    `-.          .   '.,--\"\"     |           ,'\\        |      .\r\n"
			+ "       `.       /     |          L          ,\\  .       |  .,---.\r\n"
			+ "         `._   '      |           \\        /  .  L      | /   __ `.\r\n"
			+ "            `-.       |            `._   ,    l   .    j |   '  `. .\r\n"
			+ "              |       |               `\"' |  .    |   /  '      .' |\r\n"
			+ "              |       |                   j  |    |  /  , `.__,'   |\r\n"
			+ "              `.      L                 _.   `    j ,'-'           |\r\n"
			+ "               |`\"---..\\._______,...,--' |   |   /|'      /        j\r\n"
			+ "               '       |                 |   .  / |      '        /\r\n"
			+ "                .      .              ____L   \\'  j    -',       /\r\n"
			+ "               / `.     .          _,\"     \\   | /  ,-','      ,'\r\n"
			+ "              /    `.  ,'`-._     /         \\  i'.,'_,'      .'\r\n"
			+ "             .       `.      `-..'             |_,-'      _.'\r\n"
			+ "             |         `._      |            ''/      _,-'\r\n"
			+ "             |            '-..._\\             `__,.--'\r\n"
			+ "            ,'           ,' `-.._`.            .\r\n"
			+ "           `.    __      |       \"'`.          |\r\n"
			+ "             `-\"'  `\"\"\"\"'            7         `.\r\n"
			+ "                                    `---'--.,'\"`'";
	static String geobukwangPic = "                       _\r\n" + "            _,..-\"\"\"--' `,.-\".\r\n"
			+ "          ,'      __.. --',  |\r\n" + "        _/   _.-\"' |    .' | |       ____\r\n"
			+ "  ,.-\"\"'    `-\"+.._|     `.' | `-..,',--.`.\r\n"
			+ " |   ,.                      '    j 7    l \\__\r\n"
			+ " |.-'                            /| |    j||  .\r\n"
			+ " `.                   |         / L`.`\"\"','|\\  \\\r\n"
<<<<<<< HEAD
			+ "   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l\r\n"
			+ "   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"3'  | |  l\r\n"
=======
<<<<<<< HEAD
			+ "   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"3'  | |  l\r\n"
=======
			+ "   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l\r\n"
>>>>>>> beb5ee2e5824e3626d7d691b540aa3a367f28774
>>>>>>> e1b5712c8e267e5d08830e2aae781c053e520706
			+ "     Y        `-----'       v'    ,'`,.__..' |   .\r\n"
			+ "      `.                   /     /   /     `.|   |\r\n"
			+ "        `.                /     l   j       ,^.  |L\r\n"
			+ "          `._            L       +. |._   .' \\|  | \\\r\n"
			+ "            .`--...__,..-'\"\"'-._  l L  \"\"\"    |  |  \\\r\n"
			+ "          .'  ,`-......L_       \\  \\ \\     _.'  ,'.  l\r\n"
			+ "       ,-\"`. / ,-.---.'  `.      \\  L..--\"'  _.-^.|   l\r\n"
			+ " .-\"\".'\"`.  Y  `._'   '    `.     | | _,.--'\"     |   |\r\n"
			+ "  `._'   |  |,-'|      l     `.   | |\"..          |   l\r\n"
			+ "  ,'.    |  |`._'      |      `.  | |_,...---\"\"\"\"\"`    L\r\n"
			+ " /   |   j _|-' `.     L       | j ,|              |   |\r\n"
			+ "`--,\"._,-+' /`---^..../._____,.L',' `.             |\\  |\r\n"
			+ "   |,'      L                   |     `-.          | \\j\r\n"
			+ "            .                    \\       `,        |  |\r\n"
			+ "             \\                __`.Y._      -.     j   |\r\n"
			+ "              \\           _.,'       `._     \\    |  j\r\n"
			+ "              ,-\"`-----\"\"\"\"'           |`.    \\  7   |\r\n"
			+ "             /  `.        '            |  \\    \\ /   |\r\n"
			+ "            |     `      /             |   \\    Y    |\r\n"
			+ "            |      \\    .             ,'    |   L_.-')\r\n"
			+ "             L      `.  |            /      ]     _.-^._\r\n"
			+ "              \\   ,'  `-7         ,-'      / |  ,'      `-._\r\n"
			+ "             _,`._       `.   _,-'        ,',^.-            `.\r\n"
			+ "          ,-'     v....  _.`\"',          _:'--....._______,.-'\r\n"
			+ "        ._______./     /',,-'\"'`'--.  ,-'  `.\r\n"
			+ "                 \"\"\"\"\"`.,'         _\\`----...' mh\r\n" + "                        --------\"\"'";

	int lv;
	int exp;
	String name;
	static int[] evolveCnt = new int[3];
	static String a;

	Pokemon() {

	}

	Pokemon(String name) {
		this(name, 5);
	}

	Pokemon(String name, int lv) {
		this.name = name;
		this.lv = lv;
	}

	void expPlus(int ranExp) {
		this.exp += ranExp;
	}

	void lvup() {
		this.lv++;
	}

	void printInfo() {
		System.out.println(name + " Lv." + lv + "[" + exp + "/100]입니다.");
	}

	void gameStart() {

		Random rand = new Random();

		while (true) {
			int ranExp;
			int lvcnt;
			lvcnt = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println(this.name + " 레벨업 게입 시작 1 종료 0");
			int ans = sc.nextInt();
			if (ans == 1) {
				boolean ranDom = rand.nextBoolean();
				if (ranDom == false) {
					System.out.println("꽝! 아무것도 없습니다....");
				} else {
					ranExp = rand.nextInt(451) + 50;

<<<<<<< HEAD
					expPlus(ranExp);
					this.expPlus(ranExp);
					System.out.println("축하합니다!\n얻은 경험치 : " + ranExp + " EXP");
=======
<<<<<<< HEAD
					this.expPlus(ranExp);
=======
					expPlus(ranExp);
>>>>>>> beb5ee2e5824e3626d7d691b540aa3a367f28774
					System.out.println("축하합니다!\n얻은 경험치 : " + ranExp +" EXP");
>>>>>>> e1b5712c8e267e5d08830e2aae781c053e520706

					if (this.exp > 100) {
						while (this.exp > 100) {
							this.exp -= 100;
							lvcnt++;
<<<<<<< HEAD
							lvup();
							this.lvup();
=======
<<<<<<< HEAD
							this.lvup();
=======
							lvup();
>>>>>>> beb5ee2e5824e3626d7d691b540aa3a367f28774
>>>>>>> e1b5712c8e267e5d08830e2aae781c053e520706
							if (this.lv > 15) {
								this.lv = 15;
								this.exp = 100;
								break;
							}
						}
						System.out.println("우왕 " + this.name + " 레벨 " + lvcnt + " UP!!");
						printInfo();
					} else {
						System.out.println("아쉽게 레벨업은 못했네요");
						printInfo();
					}

					System.out.println("");
					System.out.println("");

					if (this.lv >= 15) {
						System.out.println("축하합니다!" + this.name + "★☆★☆☆★만렙★☆★☆★☆\n");
						System.out.println("진화시키겠습니까 ?! 숫자를 입력하세요 1.네 / 0.아니오");
						ans = sc.nextInt();
						if (ans == 1) {

							System.out.println("....으잉!?" + this.name + "의 상태가.....!\n");
							System.out.print("축하합니다!" + this.name + "는( 은 ) ");
							if (this.name.equals("피카츄")) {
								System.out.println("라이츄 ( 으 )로 진화했다!");
								System.out.println(Pokemon.raichuPic);
								Pokemon.evolveCnt[0]++;
								System.out.println(Pokemon.evolveCnt[0]);
							} else if (this.name.equals("파이리")) {
								System.out.println("리자드 ( 으 )로 진화했다!");
								System.out.println(Pokemon.rezardPic);
								Pokemon.evolveCnt[1]++;
							} else if (this.name.equals("리자드")) {
								System.out.println("리자몽 ( 으 )로 진화했다!");
								System.out.println(Pokemon.rezamongPic);
								Pokemon.evolveCnt[1]++;
							} else if (this.name.equals("꼬부기")) {
								System.out.println("어니부기 ( 으 )로 진화했다!");
								System.out.println(Pokemon.eanibugiPic);
								Pokemon.evolveCnt[2]++;
							} else if (this.name.equals("어니부기")) {
								System.out.println("거북왕 ( 으 )로 진화했다!");
								System.out.println(Pokemon.geobukwangPic);
								Pokemon.evolveCnt[2]++;
							}

						}
						break;

					}

				}

			} else {
				break;
			}
		}
	}
}

public class Test04 {

	public static void main(String[] args) {
		Pokemon[] picachu = new Pokemon[2];
		picachu[0] = new Pokemon("피카츄");
		picachu[1] = new Pokemon("라이츄", 1);

		Pokemon[] pyreeee = new Pokemon[3];
		pyreeee[0] = new Pokemon("파이리");
		pyreeee[1] = new Pokemon("리자드", 1);
		pyreeee[2] = new Pokemon("리자몽", 1);

		Pokemon[] ggobugi = new Pokemon[3];
		ggobugi[0] = new Pokemon("꼬부기");
		ggobugi[1] = new Pokemon("어니부기", 1);
		ggobugi[2] = new Pokemon("거북왕", 1);

		while (true) {
			System.out.println(Pokemon.titlePic);
			System.out.println("=======================현재 가진 포켓몬======================");
			picachu[Pokemon.evolveCnt[0]].printInfo();
			pyreeee[Pokemon.evolveCnt[1]].printInfo();
			ggobugi[Pokemon.evolveCnt[2]].printInfo();

			System.out.println("============================================================");
			System.out.println("어떤 포켓몬을 레벨업 시킬까요 ?! 숫자로 선택하세요");
			System.out.println("1." + picachu[Pokemon.evolveCnt[0]].name + " 2." + pyreeee[Pokemon.evolveCnt[1]].name
					+ " 3." + ggobugi[Pokemon.evolveCnt[2]].name);

			Scanner sc = new Scanner(System.in);
			int answer = sc.nextInt();
			switch (answer) {
			case 1:
				if (Pokemon.evolveCnt[0] < 1) {
					System.out.println(Pokemon.picachuPic);
					picachu[Pokemon.evolveCnt[0]].gameStart();
					break;

				} else {
					System.out.println(picachu[Pokemon.evolveCnt[0]].name + "는 ( 은 ) 최종진화! 더이상 진화불가▲▲▲ ");
					break;
				}
			case 2:
				if (Pokemon.evolveCnt[1] < 2) {
					if (Pokemon.evolveCnt[1] == 0) {
						System.out.println(Pokemon.pyriPic);
					} else {
						System.out.println(Pokemon.rezardPic);
					}

					pyreeee[Pokemon.evolveCnt[1]].gameStart();
					break;
				} else {
					System.out.println(pyreeee[Pokemon.evolveCnt[1]].name + "는 ( 은 ) 최종진화! 더이상 진화불가▲▲▲ ");
					break;
				}

			case 3:
				if (Pokemon.evolveCnt[2] < 2) {
					if (Pokemon.evolveCnt[2] == 0) {
						System.out.println(Pokemon.ggobugiPic);
					} else {
						System.out.println(Pokemon.eanibugiPic);
					}
					ggobugi[Pokemon.evolveCnt[2]].gameStart();
					break;
				} else {
					System.out.println(ggobugi[Pokemon.evolveCnt[0]].name + "는 ( 은 ) 최종진화! 더이상 진화불가▲▲▲ ");
					break;
				}
			}
			System.out.println("메인화면 : 1  종료:  0");
			answer = sc.nextInt();
			if (answer == 1) {
				continue;
			} else {
				System.out.println("=======================게임 종료======================");
				break;
			}
		}
	}

}
