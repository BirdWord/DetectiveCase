package caveExplorer;

public class FinalRoom implements Event {
	private static final String[] evilLines = {"Surprised to see me here?\nThe man in the dimly lit room quickly tears off the garbage bag over his head.",
											"Oh you haven't realized yet?\nI am...\nBenjamin Nockles the Fifth.",
											"Now that you've seen me, I can't let you escape.\nYou'll have to fight me in order to leave.",
											"Fool, I shall banish you to the shadow realm!11!!!!\nLet's d-d-d-d-uuuualll!!1111!1",
											"I start off by summoning the backlog of your failures which you will never forget.",
											"Hey, you can't do that; that's cheating.",
											"NOOOOOOO STOOOOPPP!!! IT BURNS!!11!!!11",
											"That's not even the right game; stop cheating :("
											};
	private static final String[] goodLines = {"You look so familiar, but just who are you?",
											"Uhhh...\n Who's that again? I don't recognize that name.",
											"Well, I don't believe I have any weapon with me.",
											"Oh god, I think i played that game when I was like 5.",
											"Please no, I'm still having nightmare from that.\nWell, I use Monster Reborn on Kristy and bring her back to life.",
											"No it's not; face your fear. Have you ever seen the light of an innocent youth??",
											"Kristy: 'Wow you suck; Lemme just summon a Lugia. Lugia, use AEROBLAST!!",
											"Kristy: 'Quick, Lugia; use EARTHQUAKE!\nThe walls started shaking and a hole erupted in the wall."
											};
	private static final String[] storyEnd = {"As the smoke cleared, the police were outside.",
											"Wow, what happened in there?\nAre you sure you weren't carrying any weapons?",
											"Anyways, I'm just glad you're safe cuz you're our best detective.",
											"Now let's just apprehend this criminal and put him away for good.",
											"And you...? Take the rest of the day off; you've been through a lot."
											};
	@Override
	public void play() {
		readConvo(evilLines,goodLines);
		GameStartEvent.readSequence(storyEnd);
		CaveExplorer.print("                ~~~THE END~~~");
		CaveExplorer.alive = false;
	}
	private void readConvo(String[] arr1, String[] arr2){
		for(int i = 0; i<arr1.length; i++){
			CaveExplorer.print(arr1[i]);
			CaveExplorer.print(" - - - Press Enter - - - ");
			CaveExplorer.in.nextLine();
			CaveExplorer.print(arr2[i]);
			CaveExplorer.print(" - - - Press Enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}

}
