/*class Chapter {
	constructor(name) {
		this.chName = name;
	}
}

class ImageChapter extends Chapter {
	constructor(name, backgroundImg) {
		super(name);
		this.backgroundImg = backgroundImg;
		
	}
}

class ImageDialogChapter extends ImageChapter {
	constructor(name, backgroundImg, dialogs) {
		super(name, backgroundImg);
	}
}

let ch1 = new ImageChapter("BlueLabs", "assets/r_cbuilding.jpg");

let ch2 = new ImageDialogChapter("Welcome", "assets/floor_room.jpg",
			[ "Hello there, you must be the new Tec Worker! Welcome to BlueLabs, a Fake Videogames Software Company!",
			  "The boss was waiting for you but he is now in a meeting with a potential client."]);

let ch3 = new ImageDialogChapter("Introduction", "assets/floor_room.jpg",
			[ "Alex! Where's the new Tech Chief Officer?!", " ...It's right in front of you Sir boss..",
			  "Oh wonderful!", "You may become the new Tech Boss! But first, you'll new to work your way up with some projects.",
			  "Starting with this one. SuperCellular, a videoGames triple AAA business, has requested us a particular software system.",
			  "They want "]);

*/

//(function() {

	function nextErase(text) {
		return text.substring(0, text.length-5);
	}
	function nextWrite(text, goalWord) {
		return text + goalWord.substring(text.length, text.length+5);
	}

	function machine(el, dialog, index) {

		let actualTxt = "";
		let writing = true;

		let wordIndex = 0;
		let goalWord = dialog[0];

		return function() {
			if (writing)
				actualTxt = nextWrite(actualTxt, goalWord);
			else
				actualTxt = nextErase(actualTxt);

			if (writing && actualTxt==goalWord) {
				writing = false;
				goalWord = dialog[++wordIndex];
				
				if (wordIndex == dialog.length-1) wordIndex = -1;
			}
			if (!writing && actualTxt=="")
				writing = true;

			el.innerHTML = actualTxt;
		};
	}



	let dialogEls = document.querySelectorAll('.ch-dialog');

	for (let dialEl of dialogEls) {
		let dialogTxts = Array.from(dialEl.childNodes)
							.filter(nEl => nEl.nodeName=="P")
							.map(pEl => {
								return pEl.innerText;
							});
		//console.log(dialogTxts)
		while (dialEl.childNodes.length > 0)
			dialEl.removeChild(dialEl.childNodes[dialEl.childNodes.length-1]);

		let newP = document.createElement('p');
		dialEl.appendChild(newP);

		let began = false;
		setInterval(() => {
			if (Math.abs(dialEl.getBoundingClientRect().y) < window.innerHeight) {
				if (!began) {
					setInterval(machine(newP,dialogTxts,0), 160);
					began = true;
				}
			}
		}, 2000);
	}


//})();








