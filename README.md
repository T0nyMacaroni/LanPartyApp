# LanPartyApp
Application for managing Lan parties for Playstation 4

## TODO
	- ! Undo/Redo Option
	- <!> Create a frame to add/remove/modify games
	- <!> Create a frame to create competitions
	- <!> Create a frame to create tournaments
	- !!! Create algorithm to generate teams
	- ...

## Bugs
	- !!! To many games could mess up the Player-frame games outlining
	- ...

## In progress
	- !!!! Documentation
	- !!!! Create Test-cases for as many objects as possible

## Finished
	- ! Textbox Outlining (TeamGeneratorNode)
	- !!!! I/O Handler (Export/Import players)
	- !! Add Listview Headers (Firstname, Name, PSN-ID)
	- !! Listview sorting logic
	- !!! Add Games property (Player, PlayerController, PlayerNode)
	
## Fixed
	- !!!! Creating a player within the PlayersFrame shouldn't overwrite an existing player.
	- !!! PSN-ID can't contain spaces (Player, PlayerController, PlayerNode)
	- !!! PSN-ID max length should be set to 16.